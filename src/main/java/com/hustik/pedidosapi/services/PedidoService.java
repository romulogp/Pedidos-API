package com.hustik.pedidosapi.services;

import com.hustik.pedidosapi.domain.Categoria;
import com.hustik.pedidosapi.domain.Pedido;
import com.hustik.pedidosapi.repositories.PedidoRepository;
import com.hustik.pedidosapi.services.exceptions.ObjectNotFoundException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Rômulo Göelzer Portolann
 */
@Service
public class PedidoService {

    @Autowired
    private PedidoRepository repo;
    
    public Pedido getById(Long id) {
        Optional<Pedido> categoria = repo.findById(id);
        return categoria.orElseThrow(() -> new ObjectNotFoundException(id, Categoria.class));
    }
    
}
