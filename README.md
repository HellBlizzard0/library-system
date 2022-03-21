Library System
==============

**Technologies Used** (So Far):

-   Spring Boot (Embedded with Tomcat Server).

-   Spring Security.

-   Spring Validation.

-   Maven

-   JSP, for simple login pages.

-   Bootstrap.

-   JQuery.

**How to run**:

1. Extract the database schema "Dump20220303.zip". Create the imported to mysql using your Database client.

2.  In your IDE, perform a Maven clean install.

3.  Run
    "com.​Ejadatraining.​Librarysystem.LibrarySystemApplication.java"
    
**Requests List**:

*REST Commands "/api/XXXX/YYYY*

where XXXX is the name of the Object being inspected
and YYYY is the command selected from the ones below

* GET requests
    + /getAllBooks
    + /getBookByNameOrIdOrAuthorname
    + /deleteBook
    + /getAllBorrows
    + /getBorrowByIdOrUserIdOrBookId
    + /deleteBorrow
    + /getAllCustomers
    + /getCustomerByIdOrName
    + /deleteCustomer
    + /getAllLibrarians
    + /getLibrarianByIdOrName
    + /deleteLibrarian
    + /getAllUsers
    + /getUserByIdOrUsername
    + /deleteUser
* POST requests
    + /addBook
    + /addBooks
    + /updateBook
    + /addCustomer
    + /addCustomers
    + /updateCustomer
    + /addLibrarian
    + /addLibrarians
    + /updateLibrarian
    + /addUser
    + /addUsers
    + /updateUser
    + /addBorrow
    + /addBorrows
    + /updateBorrow

# Diagrams

## Class Diagrams

**Package Structure**

![](README-assets/image1.png){width="5.510416666666667in"
height="4.6170745844269465in"}

**Package:**
**rest**![](media/image2.png){width="6.489583333333333in"
height="3.8020833333333335in"}

**Package: Entities**

![](media/image3.png){width="6.130347769028871in"
height="4.791666666666667in"}

**Package: Service**

![](media/image4.png){width="6.489583333333333in"
height="5.875in"}

**Package: DAO**

![](media/image5.png){width="6.489583333333333in"
height="4.333333333333333in"}

## Entity Relation Diagram (Database)

![](media/image6.png){width="6.5in"
height="4.927083333333333in"}
