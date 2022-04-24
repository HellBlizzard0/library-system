package com.Ejadatraining.Librarysystem.service;

import com.Ejadatraining.Librarysystem.entity.Book;
import com.Ejadatraining.Librarysystem.util.ReportParams;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.ooxml.JRDocxExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Description;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.sf.jasperreports.engine.JasperCompileManager;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ResourceUtils;

@Description(value = "T service responsible for processing data.")
@Service
public class ReportService< T> {

    private static final Logger LOGGER = LoggerFactory.getLogger(ReportService.class);

    public ResponseEntity<byte[]> printReport(List<Book> booksList, boolean isEnglish) {
        try {
            List<Book> books = booksList;

            //dynamic parameters required for report
            Map<String, Object> bookParams = new HashMap<String, Object>();
            bookParams.put("booksData", new JRBeanCollectionDataSource(books));

            JasperPrint bookReport
                    = JasperFillManager.fillReport(
                            JasperCompileManager.compileReport(
                                    ResourceUtils.getFile(isEnglish ? "classpath:BooksReportEN.jrxml" : "classpath:BooksReportAR.jrxml")
                                            .getAbsolutePath()) // path of the jasper report
                            ,
                             bookParams // dynamic parameters 
                            ,
                             new JREmptyDataSource()
                    );


            HttpHeaders headers = new HttpHeaders();
            //set the PDF format
            headers.setContentType(MediaType.APPLICATION_PDF);
            headers.setContentDispositionFormData("filename", "Books-details.pdf");
            //create the report in PDF format
            byte[] result = JasperExportManager.exportReportToPdf(bookReport);
            return new ResponseEntity<byte[]>(result, headers, HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<byte[]>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Method for generating simple report
     *
     * @param report - provided data object
     * @return byte array resource ()
     */
    public ByteArrayResource generateSimpleReport(T report, ExportReportType exportReportType) throws IOException {
        // get jasper template
        ClassPathResource reportResource = new ClassPathResource("templates/simple.jasper");

        // generate parameters
        Map<String, Object> reportParameters = new HashMap<>();
        generateReportParameters(reportParameters, report);

        // generate reports based on export type.
        switch (exportReportType) {
            case PDF:
                return exportReportToPDF(reportResource.getInputStream(), reportParameters);

            case DOCX:
                return exportReportToDOCx(reportResource.getInputStream(), reportParameters);

            default:
                return null;
        }
    }

    /**
     * Method for generating data source report
     *
     * @param reportList - provided report list
     * @param exportReportType - export type flag
     * @return byte array resource (generated file)
     * @throws IOException - input | output exception
     */
    public ByteArrayResource generateDataSourceReport(List<T> reportList, ExportReportType exportReportType)
            throws IOException {
        // get jasper template
        ClassPathResource reportResource = new ClassPathResource("templates/table_report.jasper");

        // generate source parameters
        Map<String, Object> reportParameters = new HashMap<>();

        JRBeanCollectionDataSource itemsJRBean = new JRBeanCollectionDataSource(reportList, true);
        reportParameters.put(ReportParams.PARAM_CUSTOM_DATA_SOURCE, itemsJRBean);

        // generate reports based on export type.
        switch (exportReportType) {
            case PDF:
                return exportReportToPDF(reportResource.getInputStream(), reportParameters);

            case DOCX:
                return exportReportToDOCx(reportResource.getInputStream(), reportParameters);

            default:
                return null;
        }
    }

    /**
     * Method for generating report parameters.
     *
     * @param reportParameters - reference to report parameters (passed by
     * reference).
     * @param reportData - report data object
     */
    private void generateReportParameters(Map<String, Object> reportParameters, T reportData) {
//        reportParameters.put(ReportParams.PARAM_FIRST_NAME, reportData.getFirstName());
//        reportParameters.put(ReportParams.PARAM_LAST_NAME, reportData.getLastName());
//        reportParameters.put(ReportParams.PARAM_AGE, reportData.getAge());
    }

    /**
     * Method for exporting report to PDF.
     *
     * @param targetStream - target report stream
     * @param parameters - generated parameters
     * @return byte array resource (file content)
     */
    private ByteArrayResource exportReportToPDF(InputStream targetStream, Map<String, Object> parameters) {
        try {
            JasperPrint jasperPrint = JasperFillManager.fillReport(targetStream, parameters, new JREmptyDataSource());

            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);

            // line bellow is only for demo purpose.
            JasperExportManager.exportReportToPdfStream(jasperPrint,
                    new FileOutputStream("src/main/resources/reports/report.pdf")
            );

            byte[] reportContent = outputStream.toByteArray();
            return new ByteArrayResource(reportContent);
        } catch (Exception e) {
            LOGGER.error("Exporting report to PDF error: {}", e.getMessage());
            return null;
        }
    }

    /**
     * Method for exporting report to DOCx format
     *
     * @param targetStream - target report stream
     * @param parameters - generated parameters
     * @return byte array resource (generated report file).
     */
    private ByteArrayResource exportReportToDOCx(InputStream targetStream, Map<String, Object> parameters) {
        try {
            JasperPrint jasperPrint = JasperFillManager.fillReport(targetStream, parameters, new JREmptyDataSource());
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

            JRDocxExporter exporter = new JRDocxExporter();
            exporter.setExporterInput(new SimpleExporterInput(jasperPrint));

            // the line bellow is only for demo purpose.
            exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(
                    new File("src/main/resources/reports/reports.docx"))
            );

            exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(outputStream));
            exporter.exportReport();

            byte[] reportContent = outputStream.toByteArray();
            return new ByteArrayResource(reportContent);
        } catch (Exception e) {
            LOGGER.error("Exporting report to DOCx error: {}", e.getMessage());
            return null;
        }
    }

    @Description(value = "Export report type enumeration.")
    public enum ExportReportType {

        PDF, DOCX

    }
}
