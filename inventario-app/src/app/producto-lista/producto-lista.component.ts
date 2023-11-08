import { Component, OnInit } from '@angular/core';
import { ProductoService } from '../producto.service';
import { Producto } from '../producto';
import { Router } from '@angular/router';

@Component({
  selector: 'app-producto-lista',
  templateUrl: './producto-lista.component.html',
  styleUrls: ['./producto-lista.component.css']
})
export class ProductoListaComponent implements OnInit {
  productos:Producto[]=[];
  constructor(private productoServicio:ProductoService,
    private router:Router){
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
  editarProducto(id:number) {
      this.router.navigate(["/editar-producto",id])
  }
}
