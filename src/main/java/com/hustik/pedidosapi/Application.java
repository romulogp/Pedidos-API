package com.hustik.pedidosapi;

import com.hustik.pedidosapi.domain.Categoria;
import com.hustik.pedidosapi.repositories.CategoriaRepository;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private CategoriaRepository categoriaRepository;
    
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        
        // Inserts base para teste
        
        Categoria cat1 = new Categoria(null, "Informática");
        Categoria cat2 = new Categoria(null, "Escritório");
        categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
        
    }

}
