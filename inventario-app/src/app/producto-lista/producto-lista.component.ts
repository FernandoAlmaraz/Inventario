import { Component, OnInit } from '@angular/core';
import { ProductoService } from '../producto.service';
import { Producto } from '../producto';

@Component({
  selector: 'app-producto-lista',
  templateUrl: './producto-lista.component.html',
  styleUrls: ['./producto-lista.component.css']
})
export class ProductoListaComponent implements OnInit {
  productos:Producto[]=[];
  constructor(private productoServicio:ProductoService){
  }
  ngOnInit(){
    this.obtenerProductos();
  }
  obtenerProductos(){
    this.productoServicio.obtenerProductosLista().subscribe(
      (data)=>{
        this.productos = data;
      })
  }
}
