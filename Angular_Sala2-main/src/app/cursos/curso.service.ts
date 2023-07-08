import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Observable } from 'rxjs';
import { Curso } from './curso.model';

@Injectable({
  providedIn: 'root'
})
export class CursoService {

  constructor(private httpClient: HttpClient,
    private _snackBar: MatSnackBar) { }

  baseUrl = 'http://localhost:8080/academico/cursos';

  openSnackBar(message: string) {
    this._snackBar.open(message, 'X', {
      duration: 2000,
      verticalPosition: "top",
      horizontalPosition: "right"
    });
  }

  getCursoList(): Observable<Curso[]> {
    return this.httpClient.get<Curso[]>(`${this.baseUrl}`);
  }

  getCurso(id: number): Observable<Curso> {
    return this.httpClient.get<Curso>(`${this.baseUrl}/${id}`);
  }

  createCurso(c: Curso): Observable<Curso> {
    return this.httpClient.post<Curso>(`${this.baseUrl}`, c);
  }

  updateCurso(id: number, c: Curso): Observable<Curso> {
    return this.httpClient.put<Curso>(`${this.baseUrl}/${id}`, c);
  }

  deleteCurso(id: number): Observable<Curso> {
    return this.httpClient.delete<Curso>(`${this.baseUrl}/${id}`);
  }

}
