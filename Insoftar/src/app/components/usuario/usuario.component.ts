import { MatTableDataSource } from '@angular/material/table';
import { MatPaginator } from '@angular/material/paginator';

import { UsuarioService } from './../../service/usuario.service';
import { Component, OnInit, ViewChild } from '@angular/core';
import { Usuario } from 'src/app/model/usuario';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { StringDecoder } from 'string_decoder';

@Component({
  selector: 'app-usuario',
  templateUrl: './usuario.component.html',
  styleUrls: ['./usuario.component.css']
})
export class UsuarioComponent implements OnInit {

  displayedColumns: string[] = ['id', 'nombre', 'apellido', 'cedula', 'correo', 'telefono', 'acciones'];
  dataSource = new MatTableDataSource<Usuario>();

  cantidad: number = 0;
  isVisible: boolean = true;
  isVisibleForm: boolean = true;
  isSaving: boolean = true;
  form: FormGroup;

  @ViewChild(MatPaginator, { static: true }) paginator: MatPaginator;

  constructor(private usuarioService: UsuarioService,
    private _snackBar: MatSnackBar
  ) { }

  ngOnInit(): void {
    this.listaUsuarios(0, 10);
    this.iniciarFormulario();
  }

  listaUsuarios(pagina: number, size: number) {
    this.usuarioService.listar(pagina, size).subscribe(data => {
      this.dataSource = new MatTableDataSource(data.content);
      this.cantidad = data.totalElements;
    });
  }

  cambioPagina(e: any) {
    this.listaUsuarios(e.pageIndex, e.pageSize);
  }

  iniciarFormulario() {
    this.form = new FormGroup({
      'id': new FormControl(0),
      'nombre': new FormControl(''),
      'apellido': new FormControl(''),
      'cedula': new FormControl(''),
      'correo': new FormControl('', [
        Validators.required,
        Validators.email]),
      'telefono': new FormControl('')

    });
  }

  guardar() {
    let usuario = new Usuario();
    usuario.id = this.form.value['id'];
    usuario.nombre = this.form.value['nombre'];
    usuario.apellido = this.form.value['apellido'];
    usuario.cedula = this.form.value['cedula'];
    usuario.correo = this.form.value['correo'];
    usuario.telefono = this.form.value['telefono'];
    if (this.isSaving) {
      this.usuarioService.guardar(usuario).subscribe(() => {
        this.noVisibilidad();
        this.mostrarMensaje('Se ha guardado Correctamente', 'Guardar');
      });
    } else {
      this.usuarioService.editar(usuario).subscribe(() => {
        this.listaUsuarios(0, 10);
        this.noVisibilidad();
        this.mostrarMensaje('Se ha editado Correctamente', 'Editar');

      });
    }
  }

  obtenerUsuario(id: number) {
    this.isSaving = false;
    this.usuarioService.listarPorId(id).subscribe(data => {
      this.form = new FormGroup({
        'id': new FormControl(data.id),
        'nombre': new FormControl(data.nombre),
        'apellido': new FormControl(data.apellido),
        'cedula': new FormControl(data.cedula),
        'correo': new FormControl(data.correo, [
          Validators.required,
          Validators.email]),
        'telefono': new FormControl(data.telefono)
      });
      this.Visibilidad();
    });
  }

  Visibilidad() {
    this.isVisible = false;
    this.isVisibleForm = true;
  }
  noVisibilidad() {
    this.isVisible = true;
    this.isVisibleForm = true;
    this.iniciarFormulario();
  }

  mostrarMensaje(mensaje: string, accion: string) {
    this._snackBar.open(mensaje, accion, {
      duration: 5000,
    });
  }

}
