import { HttpClient } from '@angular/common/http';
import { environment } from './../../environments/environment';
import { Injectable } from '@angular/core';
import { Usuario } from '../model/usuario';

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {

  url = `${environment.HOST}/usuarios`;

  constructor(private http: HttpClient) { }

  listar(page:number, size:number){
    return this.http.get<any>(`${this.url}/listar?page=${page}&size=${size}`);
  }
  listarPorId(id: number) {
    return this.http.get<Usuario>(`${this.url}/usuarioId/${id}`);
  }
  guardar(usuario: Usuario){
    return this.http.post(`${this.url}/guardar`, usuario);
  }
  editar(usuario: Usuario){
    return this.http.put(`${this.url}/editar`, usuario);
  }

}
