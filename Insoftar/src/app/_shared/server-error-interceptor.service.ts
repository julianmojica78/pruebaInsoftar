import { MatSnackBar } from '@angular/material/snack-bar';
import { environment } from './../../environments/environment';
import { Injectable } from '@angular/core';
import { HttpInterceptor, HttpRequest, HttpHandler, HttpEvent, HttpResponse } from '@angular/common/http';
import { Observable, EMPTY } from 'rxjs';
import { tap, catchError, retry } from 'rxjs/operators';
import { Router } from '@angular/router';


@Injectable({
  providedIn: 'root'
})
export class ServerErrorInterceptorService implements HttpInterceptor {


  mensaje: string;
  mensajeError: string;
  constructor(private snackBar: MatSnackBar,
  private router: Router) { }

  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {

    return next.handle(request).pipe(retry(environment.REINTENTOS)).
      pipe(tap(event => {
        if (event instanceof HttpResponse) {
          if (event.body && event.body.error === true && event.body.errorMessage) {
            throw new Error(event.body.errorMessage);
          }/*else{
                              //this.snackBar.open("EXITO", 'AVISO', { duration: 5000 });    

                          }*/
        }
      })).pipe(catchError((err) => {
        //console.log('Entro Error Filtro');
        //console.log(err);
        //this.mensaje = err.error.message;

        //err.message
        //err.error.mensaje
        if (err.status === 404) {
          this.snackBar.open(err.error.message, 'ERROR', { duration: 5000 });
          
        }

        return EMPTY;
      }));

  }

}
