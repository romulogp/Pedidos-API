package com.hustik.pedidosapi;

import com.hustik.pedidosapi.domain.Categoria;
import com.hustik.pedidosapi.domain.Cidade;
import com.hustik.pedidosapi.domain.Cliente;
import com.hustik.pedidosapi.domain.Endereco;
import com.hustik.pedidosapi.domain.Estado;
import com.hustik.pedidosapi.domain.ItemPedido;
import com.hustik.pedidosapi.domain.Pagamento;
import com.hustik.pedidosapi.domain.PagamentoComBoleto;
import com.hustik.pedidosapi.domain.PagamentoComCartao;
import com.hustik.pedidosapi.domain.Pedido;
import com.hustik.pedidosapi.domain.Produto;
import com.hustik.pedidosapi.domain.StatusPagamento;
import com.hustik.pedidosapi.domain.TipoCliente;
import com.hustik.pedidosapi.repositories.CategoriaRepository;
import com.hustik.pedidosapi.repositories.CidadeRepository;
import com.hustik.pedidosapi.repositories.ClienteRepository;
import com.hustik.pedidosapi.repositories.EnderecoRepository;
import com.hustik.pedidosapi.repositories.EstadoRepository;
import com.hustik.pedidosapi.repositories.ItemPedidoRepository;
import com.hustik.pedidosapi.repositories.PagamentoRepository;
import com.hustik.pedidosapi.repositories.PedidoRepository;
import com.hustik.pedidosapi.repositories.ProdutoRepository;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private PagamentoRepository pagamentoRepository;
    @Autowired
    private ItemPedidoRepository itemPedidoRepository;
    
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
        
        Cidade balCambo = new Cidade(null, "Balneário Camboriú", sc);
        Cidade camboriu = new Cidade(null, "Camboriú", sc);
        Cidade saoPaulo = new Cidade(null, "São Paulo", sp);
        Cidade campinas = new Cidade(null, "Campinas", sp);
        
        sc.getCidades().addAll(Arrays.asList(balCambo, camboriu));
        sp.getCidades().addAll(Arrays.asList(saoPaulo, campinas));
        
        estadoRepository.saveAll(Arrays.asList(sc, sp));
        cidadeRepository.saveAll(Arrays.asList(balCambo, camboriu, saoPaulo, campinas));
        
        
        Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "32569854701", TipoCliente.PESSOA_FISICA);
        cli1.getTelefones().addAll(Arrays.asList("24658951232", "25896512478"));
        
        Endereco end1 = new Endereco(null, "Rua Osvaldo Nunes", "2157", "Fundos", "Centro", "88333256", cli1, campinas);
        Endereco end2 = new Endereco(null, "Rua Jacób", "100", "Sala 2000", "Centro", "88333596", cli1, campinas);
        
        cli1.getEnderecos().addAll(Arrays.asList(end1, end2));
        
        clienteRepository.saveAll(Arrays.asList(cli1));
        enderecoRepository.saveAll(Arrays.asList(end1, end2));
        
        
        DateTimeFormatter fmtDTime = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        DateTimeFormatter fmtDt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
        Pedido ped1 = new Pedido(null, LocalDateTime.parse("30/09/2018 16:19", fmtDTime), cli1, end1);
        Pedido ped2 = new Pedido(null, LocalDateTime.parse("10/10/2018 19:45", fmtDTime), cli1, end2);
        
        Pagamento pgto1 = new PagamentoComCartao(null, StatusPagamento.QUITADO, ped1, 6);
        ped1.setPagamento(pgto1);
        
        Pagamento pgto2 = new PagamentoComBoleto(null, StatusPagamento.PENDENTE, ped2, LocalDate.parse("20/10/2018", fmtDt), null);
        ped2.setPagamento(pgto2);
        
        cli1.getPedidos().addAll(Arrays.asList(ped1, ped2));
        
        pedidoRepository.saveAll(Arrays.asList(ped1, ped2));
        pagamentoRepository.saveAll(Arrays.asList(pgto1, pgto2));
        
        
        ItemPedido ip1 = new ItemPedido(ped1, prod1, new BigDecimal(0.00), 1, new BigDecimal(2000.00));
        ItemPedido ip2 = new ItemPedido(ped1, prod2, new BigDecimal(0.00), 2, new BigDecimal(80.00));
        ItemPedido ip3 = new ItemPedido(ped2, prod3, new BigDecimal(100.00), 1, new BigDecimal(800.00));
        
        ped1.getItens().addAll(Arrays.asList(ip1, ip2));
        ped2.getItens().addAll(Arrays.asList(ip3));
        
        prod1.getItens().addAll(Arrays.asList(ip1));
        prod2.getItens().addAll(Arrays.asList(ip2));
        prod3.getItens().addAll(Arrays.asList(ip3));
        
        itemPedidoRepository.saveAll(Arrays.asList(ip1, ip2, ip3));
    }

}
