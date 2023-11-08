import { Component } from '@angular/core';
import { Producto } from '../producto';
import { ProductoService } from '../producto.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-editar-producto',
  templateUrl: './editar-producto.component.html',
  styleUrls: ['./editar-producto.component.css']
})
export class EditarProductoComponent {
  producto: Producto = new Producto();
  id: number = 0;
  constructor(private productoServicio: ProductoService,
    private ruta: ActivatedRoute,
    private router: Router) { }
  ngOnInit() {
    this.id = this.ruta.snapshot.params['id'];
    this.productoServicio.obternerProductoId(this.id).subscribe(
      {
        next: (datos) => this.producto = datos,
        error: (error: any) => console.log(error)
      }
    );
  }

  onSubmit() {
    this.guardarProducto();
  }
  guardarProducto() {
    this.productoServicio.editarProducto(this.id, this.producto).subscribe({
      next: (datos) => this.irProductoLista(),
      error: (err) => console.log(err)
    });
  }
  irProductoLista() {
    this.router.navigate(["/"]);
  }
}
