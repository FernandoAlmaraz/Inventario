package gm.inventarios.servicio;

import gm.inventarios.modelo.Producto;

import java.util.List;

public interface IProductoServicio {
    public List<Producto> listarProductos();
    public Producto buscarProductoId(Integer idProducto);
    public Producto guardarProductos(Producto producto);
    public void eliminarProductoId(Integer idProducto);
}
