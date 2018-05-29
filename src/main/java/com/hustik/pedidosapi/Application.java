package com.hustik.pedidosapi;

import com.hustik.pedidosapi.domain.Categoria;
import com.hustik.pedidosapi.domain.Cidade;
import com.hustik.pedidosapi.domain.Estado;
import com.hustik.pedidosapi.domain.Produto;
import com.hustik.pedidosapi.repositories.CategoriaRepository;
import com.hustik.pedidosapi.repositories.CidadeRepository;
import com.hustik.pedidosapi.repositories.EstadoRepository;
import com.hustik.pedidosapi.repositories.ProdutoRepository;
import java.math.BigDecimal;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private CategoriaRepository categoriaRepository;
    @Autowired
    private ProdutoRepository produtoRepository;
    @Autowired
    private CidadeRepository cidadeRepository;
    @Autowired
    private EstadoRepository estadoRepository;
    
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        
        // Inserts base para teste
        Categoria cat1 = new Categoria(null, "Informática");
        Categoria cat2 = new Categoria(null, "Escritório");
        
        Produto prod1 = new Produto(null, "Computador", new BigDecimal(2000.00));
        Produto prod2 = new Produto(null, "Impressora", new BigDecimal(800.00));
        Produto prod3 = new Produto(null, "Mouse Sem Fio", new BigDecimal(80.00));
        
        cat1.getProdutos().addAll(Arrays.asList(prod1, prod2, prod3));
        cat2.getProdutos().addAll(Arrays.asList(prod2));
        
        prod1.getCategorias().addAll(Arrays.asList(cat1));
        prod2.getCategorias().addAll(Arrays.asList(cat1, cat2));
        prod2.getCategorias().addAll(Arrays.asList(cat1));
        
        categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
        produtoRepository.saveAll(Arrays.asList(prod1, prod2, prod3));
        
        Estado sc = new Estado(null, "Santa Catarina");
        Estado sp = new Estado(null, "São Paulo");
        
        Cidade bc = new Cidade(null, "Balneário Camboriú", sc);
        Cidade camb = new Cidade(null, "Camboriú", sc);
        Cidade csp = new Cidade(null, "São Paulo", sp);
        Cidade camp = new Cidade(null, "Campinas", sp);
        
        sc.getCidades().addAll(Arrays.asList(bc, camb));
        sp.getCidades().addAll(Arrays.asList(csp, camp));
        
        estadoRepository.saveAll(Arrays.asList(sc, sp));
        cidadeRepository.saveAll(Arrays.asList(bc, camb, csp, camp));
        
    }

}
