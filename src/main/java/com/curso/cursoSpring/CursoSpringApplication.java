package com.curso.cursoSpring;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.curso.cursoSpring.domain.Categoria;
import com.curso.cursoSpring.domain.Cidade;
import com.curso.cursoSpring.domain.Cliente;
import com.curso.cursoSpring.domain.Endereco;
import com.curso.cursoSpring.domain.Estado;
import com.curso.cursoSpring.domain.ItemPedido;
import com.curso.cursoSpring.domain.Pagamento;
import com.curso.cursoSpring.domain.PagamentoComBoleto;
import com.curso.cursoSpring.domain.PagamentoComCartao;
import com.curso.cursoSpring.domain.Pedido;
import com.curso.cursoSpring.domain.Produto;
import com.curso.cursoSpring.domain.enums.EstadoPagamento;
import com.curso.cursoSpring.domain.enums.TipoCliente;
import com.curso.cursoSpring.repositories.CategoriaRepository;
import com.curso.cursoSpring.repositories.CidadeRepository;
import com.curso.cursoSpring.repositories.ClienteRepository;
import com.curso.cursoSpring.repositories.EnderecoRepository;
import com.curso.cursoSpring.repositories.EstadoRepository;
import com.curso.cursoSpring.repositories.ItemPedidoRepository;
import com.curso.cursoSpring.repositories.PagamentoRepository;
import com.curso.cursoSpring.repositories.PedidoRepository;
import com.curso.cursoSpring.repositories.ProdutoRepository;

@SpringBootApplication
public class CursoSpringApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
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
		SpringApplication.run(CursoSpringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Categoria cat1 = new Categoria(null, "Puteiro");
		Categoria cat2 = new Categoria(null, "Biqueira");

		Produto p1 = new Produto(null, "Puta", 200.00);
		Produto p2 = new Produto(null, "Pó", 20.00);
		Produto p3 = new Produto(null, "Traveco", 200.00);

		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));

		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));

		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));

		Estado est1 = new Estado(null, "MG");
		Estado est2 = new Estado(null, "SP");

		Cidade c1 = new Cidade(null, "Betim", est2);
		Cidade c2 = new Cidade(null, "Fodase", est1);
		Cidade c3 = new Cidade(null, "Osasco", est1);

		est2.getCidades().addAll(Arrays.asList(c1));
		est1.getCidades().addAll(Arrays.asList(c2, c3));

		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));

		Cliente cli1 = new Cliente(null, "Pedrinho", "pedrinho@gmail.com", "9191919191", TipoCliente.PESSOAFISICA);

		cli1.getTelefones().addAll(Arrays.asList("23123213", "213123"));

		Endereco e1 = new Endereco(null, "rua fodase", "123", "ap 213", "fodase", "12342", cli1, c1);
		Endereco e2 = new Endereco(null, "rua cu", "412", "ap 55", "cu", "12342", cli1, c2);

		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));

		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1, e2));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		Pedido ped1 = new Pedido(null,sdf.parse("30/09/2020 17:50"),cli1,e1);
		
		Pedido ped2 = new Pedido(null,sdf.parse("20/01/2002 23:50"),cli1,e2);
		
		Pagamento pagto1 = new PagamentoComCartao(null,EstadoPagamento.QUITADO,ped1,5);
		ped1.setPagamento(pagto1);
		
		Pagamento pagto2 = new PagamentoComBoleto(null,EstadoPagamento.CANCELADO,ped2,sdf.parse("30/09/2020 00:00"),sdf.parse("30/09/2020 00:00"));
		ped2.setPagamento(pagto2);
		
		cli1.getPedidos().addAll(Arrays.asList(ped1,ped2));
		
		pedidoRepository.saveAll(Arrays.asList(ped1, ped2));
		
		pagamentoRepository.saveAll(Arrays.asList(pagto1, pagto2));
		
		ItemPedido ip1 = new ItemPedido(ped1,p1,0.00,1,2000.00);
		ItemPedido ip2 = new ItemPedido(ped1,p2,3.00,1,300.00);
		ItemPedido ip3 = new ItemPedido(ped2,p3,1.30,1,20.00);
		
		ped1.getItens().addAll(Arrays.asList(ip1, ip2));
		ped2.getItens().addAll(Arrays.asList(ip3));
		
		p1.getItens().addAll(Arrays.asList(ip1, ip2));
		p2.getItens().addAll(Arrays.asList(ip2));
		p3.getItens().addAll(Arrays.asList(ip1,ip2,ip3));
		
		itemPedidoRepository.saveAll(Arrays.asList(ip1,ip2,ip3));

	}

}
