package com.nodji.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.nodji.api.utils.PasswordUtils;

@SpringBootApplication
public class P12Application {

	@Value("${paginacao.qtd_por_pagina}")
	private int qtdPorPagina;;
	
	
	public static void main(String[] args) {
		SpringApplication.run(P12Application.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> {
			String passEncoded = PasswordUtils.generateBCrypt("123456");
			System.out.println("Pass Encoded: " + passEncoded);
			
			passEncoded = PasswordUtils.generateBCrypt("123456");
			System.out.println("Pass Encoded: " + passEncoded);
			
			System.out.println("<<OK>>" + PasswordUtils.passValid("123456", passEncoded));
			
			System.out.println("Quantidade de linhas por pagina: " + this.qtdPorPagina);
		};
	}
}
