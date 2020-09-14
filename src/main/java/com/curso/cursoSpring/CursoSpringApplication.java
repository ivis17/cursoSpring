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
		Categoria cat3 = new Categoria(null, "Tráfico de Armas");
		Categoria cat4 = new Categoria(null, "Assassino de aluguel");
		Categoria cat5 = new Categoria(null, "Escravos sexuais");
		Categoria cat6 = new Categoria(null, "BDSM");
		Categoria cat7 = new Categoria(null, "Carteira Rosa");
		Categoria cat8 = new Categoria(null, "Plantação");
		Categoria cat9 = new Categoria(null, "_\\|/_");
		Categoria cat10 = new Categoria(null, "Gari");
		Categoria cat11 = new Categoria(null, "A");
		Categoria cat12 = new Categoria(null, "Putas feias");
		Categoria cat13 = new Categoria(null, "Putas lindas");
		Categoria cat14 = new Categoria(null, "Pó");
		Categoria cat15 = new Categoria(null, "Raveiros");
		Categoria cat16 = new Categoria(null, "Servidor publico");
		Categoria cat17 = new Categoria(null, "Briga de rua");
		Categoria cat18 = new Categoria(null, "Rinha de galo");
		Categoria cat19 = new Categoria(null, "Travesti Anao");
		Categoria cat20 = new Categoria(null, "Tavesti Comum");
		Categoria cat21 = new Categoria(null, "Travesti");
		Categoria cat22 = new Categoria(null, "Anjo");
		Categoria cat23 = new Categoria(null, "Bucetola suja");
		Categoria cat24 = new Categoria(null, "Gostosas");
		Categoria cat25 = new Categoria(null, "Charlie Brown");
		

		Produto p1 = new Produto(null, "Puta", 200.00);
		Produto p2 = new Produto(null, "Pó", 20.00);
		Produto p3 = new Produto(null, "Traveco", 200.00);
		Produto p4 = new Produto(null, "Travecao", 250.00);
		Produto p5 = new Produto(null, "Pau", 1.00);
		Produto p6 = new Produto(null, "Pauzao", 20.00);
		Produto p7 = new Produto(null, "Pauzinho", 0.50);
		Produto p8 = new Produto(null, "Xana", 200.00);
		Produto p9 = new Produto(null, "Cuzin F", 300.00);
		Produto p10 = new Produto(null, "Cuzin M", 100.00);
		Produto p11 = new Produto(null, "Cuzin T", 1000.00);
		Produto p12 = new Produto(null, "Cu de cachorro", 12333213501.00);
		Produto p13 = new Produto(null, "Crack", 2.00);
		Produto p14 = new Produto(null, "Dola", 10.00);
		Produto p15 = new Produto(null, "25", 100.00);
		Produto p16 = new Produto(null, "Meia 25", 50.00);
		Produto p17 = new Produto(null, "Pino", 20.00);
		Produto p18 = new Produto(null, "Pino Qualidade", 400.00);
		Produto p19 = new Produto(null, "Seringa", 6.00);
		Produto p20 = new Produto(null, "Seringa Usada", 0.20);
		Produto p21 = new Produto(null, "Colírio de água", 10.00);
		Produto p22 = new Produto(null, "Lolo na lata", 45.00);
		Produto p23 = new Produto(null, "Lolo no pano", 30.00);
		Produto p24 = new Produto(null, "Bala", 40.00);
		Produto p25 = new Produto(null, "Doce", 60.00);
		Produto p26 = new Produto(null, "Boquetin F", 150.00);
		Produto p27 = new Produto(null, "Boquetin M", 70.00);
		Produto p28 = new Produto(null, "Boquetin T", 800.00);
		Produto p29 = new Produto(null, "Atravessado", 2500.00);
		Produto p30 = new Produto(null, "BDSM", 500.00);
		Produto p31 = new Produto(null, "Pau de borracha", 100.00);
		Produto p32 = new Produto(null, "Pau de madeira", 30.00);
		Produto p33 = new Produto(null, "Cha de fita", 22.00);
		Produto p34 = new Produto(null, "Cha de cogumelo", 80.00);
		Produto p35 = new Produto(null, "Cha de camomila", 15.00);

		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3,p4,p5,p6,p7,p8));
		cat2.getProdutos().addAll(Arrays.asList(p2,p9,p3,p5,p20));
		cat3.getProdutos().addAll(Arrays.asList(p2,p30,p32,p12,p16));
		cat4.getProdutos().addAll(Arrays.asList(p3,p5,p34));
		cat5.getProdutos().addAll(Arrays.asList(p22,p21,p17));
		cat6.getProdutos().addAll(Arrays.asList(p2,p1,p31,p26));

		p1.getCategorias().addAll(Arrays.asList(cat1,cat6));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2,cat6));
		p3.getCategorias().addAll(Arrays.asList(cat1,cat2,cat3,cat4));
		p4.getCategorias().addAll(Arrays.asList(cat1));
		p5.getCategorias().addAll(Arrays.asList(cat1,cat2,cat4));
		p6.getCategorias().addAll(Arrays.asList(cat1));
		p7.getCategorias().addAll(Arrays.asList(cat1));
		p8.getCategorias().addAll(Arrays.asList(cat1));
		p9.getCategorias().addAll(Arrays.asList(cat2));
		p20.getCategorias().addAll(Arrays.asList(cat2));
		p30.getCategorias().addAll(Arrays.asList(cat3));
		p31.getCategorias().addAll(Arrays.asList(cat6));
		p26.getCategorias().addAll(Arrays.asList(cat6));
		p32.getCategorias().addAll(Arrays.asList(cat3));
		p12.getCategorias().addAll(Arrays.asList(cat3));
		p16.getCategorias().addAll(Arrays.asList(cat3));
		p34.getCategorias().addAll(Arrays.asList(cat4));
		p22.getCategorias().addAll(Arrays.asList(cat5));
		p21.getCategorias().addAll(Arrays.asList(cat5));
		p17.getCategorias().addAll(Arrays.asList(cat5));

		categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6, cat7, cat8, cat9, cat10,cat11,cat12,
				cat13,cat14,cat15,cat16,cat17,cat18,cat19,cat20,cat21,cat22,cat23,cat24,cat25));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3,p4,p5,p6,p7,p8,p9,p10,p11,p12,p13,p14,p15,p16,p17,p18,p19,p20,
				p21,p22,p23,p24,p25,p26,p27,p28,p29,p30,p31,p32,p33,p34,p35));

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
