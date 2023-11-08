package gm.inventarios.controlador;

import gm.inventarios.excepcion.RecusoNoEncontradoExcepcion;
import gm.inventarios.modelo.Producto;
import gm.inventarios.servicio.ProductoServicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("inventario-app")
@CrossOrigin(value="http://localhost:4200")
public class ProductoControlador {

    private static final Logger logger = LoggerFactory.getLogger(ProductoControlador.class);

    @Autowired
    private ProductoServicio productoServicio;

    @GetMapping("/productos")
    public List<Producto> obtnerProductos(){
     List<Producto> productos =
        productoServicio.listarProductos();
     logger.info("productos obtenidos");
     productos.forEach((producto -> logger.info((producto.toString()))));
     return productos;
    }

    @PostMapping("/productos")
    public Producto agregarProducto(@RequestBody Producto producto){
        logger.info("Producto a agregar"+ producto);
        return this.productoServicio.guardarProductos(producto);
    }

    @GetMapping("/productos/{id}")
    public ResponseEntity<Producto> obtenerProductoId(@PathVariable int id){
        logger.info("El producto es:"+id);
        Producto producto =  this.productoServicio.buscarProductoId(id);
        if(producto!=null)
            return ResponseEntity.ok(producto);
        else
            throw new RecusoNoEncontradoExcepcion("No se encontró el id: "+id);
    }
    @PutMapping("/productos/{id}")
    public ResponseEntity<Producto> editarProducto(@PathVariable int id,
                                                   @RequestBody Producto productoRecibido){
        Producto producto  = this.productoServicio.buscarProductoId(id);
        if(producto ==null)
            throw new RecusoNoEncontradoExcepcion("No se encontro el producto");
        producto.setDescripcion(productoRecibido.getDescripcion());
        producto.setPrecio(productoRecibido.getPrecio());
        producto.setExistencia(productoRecibido.getExistencia());
        this.productoServicio.guardarProductos(producto);
        return ResponseEntity.ok(producto);
    }

    @DeleteMapping("/productos/{id}")
    public ResponseEntity<Map<String,Boolean>> eliminarProducto(@PathVariable int id){
        Producto producto = this.productoServicio.buscarProductoId(id);
        if(producto ==null)
            throw new RecusoNoEncontradoExcepcion("No se encontro el producto");
        this.productoServicio.eliminarProductoId(producto.getIdProducto());
        Map<String, Boolean> respuesta = new HashMap<>();
        respuesta.put("eliminado", Boolean.TRUE);
        return ResponseEntity.ok(respuesta);
    }
}
