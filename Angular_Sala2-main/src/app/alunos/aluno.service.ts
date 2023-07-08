import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Observable } from 'rxjs';
import { Aluno } from './aluno.model';

@Injectable({
  providedIn: 'root'
})
export class AlunoService {

  constructor(private httpClient: HttpClient,
    private _snackBar: MatSnackBar) { }

  baseUrl = 'http://localhost:8080/academico/alunos';

  openSnackBar(message: string) {
    this._snackBar.open(message, 'X', {
      duration: 2000,
      verticalPosition: "top",
      horizontalPosition: "right"
    });
  }

  getAlunoList(): Observable<Aluno[]> {
    return this.httpClient.get<Aluno[]>(`${this.baseUrl}`);
  }

  getAluno(id: number): Observable<Aluno> {
    return this.httpClient.get<Aluno>(`${this.baseUrl}/${id}`);
  }

  createAluno(a: Aluno): Observable<Aluno> {
    return this.httpClient.post<Aluno>(`${this.baseUrl}`, a);
  }

  updateAluno(id: number, a: Aluno): Observable<Aluno> {
    return this.httpClient.put<Aluno>(`${this.baseUrl}/${id}`, a);
  }

  deleteAluno(id: number): Observable<Aluno> {
    return this.httpClient.delete<Aluno>(`${this.baseUrl}/${id}`);
  }

}
