package com.curso.cursoSpring;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.curso.cursoSpring.domain.Categoria;
import com.curso.cursoSpring.repositories.CategoriaRepository;

@SpringBootApplication
public class CursoSpringApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CursoSpringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Jogo do Bixo");
		Categoria cat2 = new Categoria(null, "Cartel");
		
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2));
		
	}
	
	

}
