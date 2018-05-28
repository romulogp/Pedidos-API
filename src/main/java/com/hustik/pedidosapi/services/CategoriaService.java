package com.hustik.pedidosapi.services;

import com.hustik.pedidosapi.domain.Categoria;
import com.hustik.pedidosapi.repositories.CategoriaRepository;
import com.hustik.pedidosapi.services.exceptions.ObjectNotFoundException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Rômulo Göelzer Portolann
 */
@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repo;
    
    public Categoria getById(Long id) {
        Optional<Categoria> categoria = repo.findById(id);
        return categoria.orElseThrow(() -> new ObjectNotFoundException(id, Categoria.class));
    }
    
    public List<Categoria> getAll() {
        return repo.findAll();
    }
    
}
