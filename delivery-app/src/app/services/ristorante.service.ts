import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Ristorante } from '../models/ristorante.model';

@Injectable({
  providedIn: 'root'
})
export class RistoranteService {
  private apiUrl = 'http://localhost:3000/api/ristoranti';

  constructor(private http: HttpClient) { }

  getAll(): Observable<Ristorante[]> {
    return this.http.get<Ristorante[]>(this.apiUrl);
  }

  getById(id: number): Observable<Ristorante> {
    return this.http.get<Ristorante>(`${this.apiUrl}/${id}`);
  }

  create(ristorante: Ristorante): Observable<Ristorante> {
    return this.http.post<Ristorante>(this.apiUrl, ristorante);
  }

  update(id: number, ristorante: Ristorante): Observable<Ristorante> {
    return this.http.put<Ristorante>(`${this.apiUrl}/${id}`, ristorante);
  }

  delete(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}
