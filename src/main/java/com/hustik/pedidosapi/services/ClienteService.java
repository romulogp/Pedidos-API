package com.hustik.pedidosapi.services;

import com.hustik.pedidosapi.domain.Cliente;
import com.hustik.pedidosapi.repositories.ClienteRepository;
import com.hustik.pedidosapi.services.exceptions.ObjectNotFoundException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Rômulo Göelzer Portolann
 */
@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repo;
    
    public Cliente getById(Long id) {
        Optional<Cliente> cliente = repo.findById(id);
        return cliente.orElseThrow(() -> new ObjectNotFoundException(id, Cliente.class));
    }
    
}
