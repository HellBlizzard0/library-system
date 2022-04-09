export interface User {
  id?: number;
  username?: string;
  password?: string;
  enabled?: boolean;
  dateOfCreation?: Date | string;
  lastUpdate?: Date | string;
  name?: string;
  phoneNumber?: string;
  role?: string;
}
