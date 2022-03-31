export interface Book {
  id: number;
  title: string;
  dateOfCreation: Date;
  lastUpdated: Date;
  serialNumber: string;
  authorName: string;
  rating?: number;
  description?: string;
  genres?: string;
  pageCount?: number;
}
