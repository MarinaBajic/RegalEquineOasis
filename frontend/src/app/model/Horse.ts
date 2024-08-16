import { Breed } from './Breed';

export type Horse = {
  id: number;
  fullName: string;
  nickname: string;
  gender: string;
  dateOfBirth: Date;
  breed: Breed;
};
