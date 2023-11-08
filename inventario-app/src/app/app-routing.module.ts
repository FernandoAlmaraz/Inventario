import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ProductoListaComponent } from './producto-lista/producto-lista.component';

const routes: Routes = [
  {path: 'productos', component:ProductoListaComponent},
  {path: '',redirectTo:'productos',pathMatch: 'full'},
  // {path: '',component:ProductoLista}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
