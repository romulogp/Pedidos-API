package com.hustik.pedidosapi.services;

import com.hustik.pedidosapi.domain.Categoria;
import com.hustik.pedidosapi.repositories.CategoriaRepository;
import java.util.List;
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
        return repo.findById(id).orElse(null);
    }
    
    public List<Categoria> getAll() {
        return repo.findAll();
    }
    
}
