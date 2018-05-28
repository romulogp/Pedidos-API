package com.hustik.pedidosapi.services.exceptions;

/**
 *
 * @author Rômulo Göelzer Portolann
 */
public class ObjectNotFoundException extends RuntimeException {

    public ObjectNotFoundException(Long id, Class entity) {
        super("Object não encontrado! Id: " + id + ", Tipo: " + entity.getSimpleName());
    }

    public ObjectNotFoundException(String msg) {
        super(msg);
    }

    public ObjectNotFoundException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
