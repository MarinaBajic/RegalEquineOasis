import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { SessionType } from '../model/SessionType';

@Injectable({
  providedIn: 'root',
})
export class SessionService {
  private baseUrl: string;

  constructor(private http: HttpClient) {
    this.baseUrl = 'http://localhost:8765/api';
  }

  getSessionTypes(): Observable<Array<SessionType>> {
    return this.http.get<Array<SessionType>>(`${this.baseUrl}/sessions/types`);
  }
}
