package co.vinni.ejemplospring.exceptions;


public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String mensaje){
        super(mensaje);
    }

}

