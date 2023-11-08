package gm.inventarios.excepcion;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class RecusoNoEncontradoExcepcion extends RuntimeException{
    public RecusoNoEncontradoExcepcion(String mensaje){
        super(mensaje);
    }
}
