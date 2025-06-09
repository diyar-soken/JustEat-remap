import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Ordine } from '../models/ordine.model';

@Injectable({
  providedIn: 'root'
})
export class OrdineService {
  private apiUrl = 'http://localhost:3000/api/ordini';

  constructor(private http: HttpClient) { }

  getAll(): Observable<Ordine[]> {
    return this.http.get<Ordine[]>(this.apiUrl);
  }

  getById(id: number): Observable<Ordine> {
    return this.http.get<Ordine>(`${this.apiUrl}/${id}`);
  }

  create(ordine: Ordine): Observable<Ordine> {
    return this.http.post<Ordine>(this.apiUrl, ordine);
  }

  update(id: number, ordine: Ordine): Observable<Ordine> {
    return this.http.put<Ordine>(`${this.apiUrl}/${id}`, ordine);
  }

  delete(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}
