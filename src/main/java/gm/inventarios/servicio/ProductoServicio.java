package gm.inventarios.servicio;

import gm.inventarios.modelo.Producto;
import gm.inventarios.repositorio.ProductoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductoServicio implements IProductoServicio  {

    @Autowired
    private ProductoRepositorio productoRepositorio;
    @Override
    public List<Producto> listarProductos() {
      return  this.productoRepositorio.findAll();
    }

    @Override
    public Producto buscarProductoId(Integer idProducto) {
       Producto producto =
               this.productoRepositorio.findById(idProducto).orElse(null);
       return producto;
    }

    @Override
    public void guardarProductos(Producto producto) {
        this.productoRepositorio.save(producto);

    }

    @Override
    public void eliminarProductoId(Integer idProducto) {
        this.productoRepositorio.deleteById(idProducto);
    }
}
