import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface CatProfile {
  id: number;
  name: string;
  age: number;
}

@Injectable({
  providedIn: 'root',
})
export class CatProfileService {
  private apiUrl = 'http://localhost:8080/api/cats'; // Backend API URL

  constructor(private http: HttpClient) {}

  getCatProfiles(): Observable<CatProfile[]> {
    return this.http.get<CatProfile[]>(this.apiUrl);
  }

  generateRandomCat(): Observable<CatProfile> {
    return this.http.post<CatProfile>(`${this.apiUrl}/random`, {});
  }

  deleteCatProfile(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}