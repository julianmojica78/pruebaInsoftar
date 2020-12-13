import { UsuarioComponent } from './components/usuario/usuario.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

const routes: Routes = [
  { path: 'usuarios', component: UsuarioComponent},
  { path: '', pathMatch: 'full', redirectTo: 'usuarios' },
  { path: '**', pathMatch: 'full', redirectTo: 'usuarios'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes, { useHash: true })],
  exports: [RouterModule]
})
export class AppRoutingModule { }
