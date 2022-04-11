export interface Book {
  available?: any;
  id?: number;
  title?: string;
  dateOfCreation?: Date;
  lastUpdate?: Date | string;
  serialNumber?: string | string;
  authorName?: string;
  rating?: number;
  description?: string;
  genres?: string;
  pageCount?: number;
}
