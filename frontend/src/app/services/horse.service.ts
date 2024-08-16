import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Horse } from '../model/Horse';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root',
})
export class HorseService {
  private baseUrl: string;

  constructor(private http: HttpClient) {
    this.baseUrl = 'http://localhost:8765/api';
  }

  getHorses(): Observable<Array<Horse>> {
    return this.http.get<Array<Horse>>(`${this.baseUrl}/horses`);
  }
}
