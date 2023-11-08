import { Component } from '@angular/core';
import { ProductoService } from '../producto.service';
import { Producto } from '../producto';
import { Router } from '@angular/router';

@Component({
  selector: 'app-agregar-producto',
  templateUrl: './agregar-producto.component.html',
  styleUrls: ['./agregar-producto.component.css']
})
export class AgregarProductoComponent {
  producto: Producto = new Producto();
  constructor(private productoServicio: ProductoService,
    private router: Router) { }

  onSubmit() {
    this.guardarProducto();
  }
  guardarProducto() {
    this.productoServicio.agregarProducto(this.producto).subscribe(
      {
        next: (value) => {
          this.irListaProductos();
        },
        error: (error: any) => { console.log("Error" + error); }
      }
    )
  }
  irListaProductos() {
    this.router.navigate(['/productos']);
  }
}