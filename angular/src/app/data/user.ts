export interface User {
  id: number;
  username: string;
  password: string;
  enabled: boolean;
  dateOfCreation: Date;
  lastUpdated: Date;
}

export interface Customer extends User {
  name: string;
  phoneNumber: string;
}

export interface Librarian extends User {
  name: string;
}
