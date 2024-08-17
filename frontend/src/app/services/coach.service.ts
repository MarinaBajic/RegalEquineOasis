import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Coach } from '../model/Coach';

@Injectable({
  providedIn: 'root',
})
export class CoachService {
  private baseUrl: string;

  constructor(private http: HttpClient) {
    this.baseUrl = 'http://localhost:8765/api';
  }

  getCoaches(): Observable<Array<Coach>> {
    return this.http.get<Array<Coach>>(`${this.baseUrl}/coaches`);
  }
}
