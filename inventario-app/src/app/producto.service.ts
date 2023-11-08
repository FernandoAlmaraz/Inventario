import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Producto } from './producto';
@Injectable({
  providedIn: 'root'
})
export class ProductoService {

  private urlBase = "http://localhost:8081/inventario-app/productos"

  constructor(private clienthttp: HttpClient) { }

  obtenerProductosLista(): Observable<Producto[]> {
    return this.clienthttp.get<Producto[]>(this.urlBase);
  }

  agregarProducto(producto: Producto): Observable<Object> {
    return this.clienthttp.post(this.urlBase, producto);
  }
}
