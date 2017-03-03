package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import com.example.dao.ProduitRepository;
import com.example.entities.Produit;

@SpringBootApplication()
public class GestionProductApplication implements CommandLineRunner {

	@Autowired
	ProduitRepository produitRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(GestionProductApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		produitRepository.save(new Produit("product1",500,8));
		produitRepository.save(new Produit("product2",1000,5));
		produitRepository.save(new Produit("product3",3000,10));

		
	}
}
