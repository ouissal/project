package com.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entities.Produit;

public interface ProduitRepository extends JpaRepository<Produit, Long> {

}
