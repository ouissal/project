package com.example.web;

import java.net.URI;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.dao.ProduitRepository;
import com.example.entities.Produit;

// pour créer avec spring une classe restful il suffit qu'elle soit annotée par @RestController

@Path("produits")
public class ProduitRestfulService {

	@Autowired
	private ProduitRepository produitRepository;

	// Lister les produits
	// pr acceder à la methode findAll
	// pr recuperer on fait GET
	// @RequestMapping(value = "/produits", method com.example.dao=
	// RequestMethod.GET)
	
	@GET
	@Produces("application/json")
	public List<Produit> listProduits() {
		return produitRepository.findAll();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response save(Produit p) {
		Produit nouvProduit = produitRepository.save(p);
		
		return Response.created(URI.create("http://localhost:8181/jers/produits/"+nouvProduit.getId()))
				.build();
	}

	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response update(@PathParam("id") Long id, Produit p) {
		//prck l'id on l'envoit sous le format d'un path param et pas dans la requete
		p.setId(id);
		produitRepository.save(p);
		
		return Response.ok()
				.build();
	}
	
	@DELETE
	@Path("{id}")
	public Response delete(@PathParam("id") Long id) {
		//prck l'id on l'envoit sous le format d'un path param et pas dans la requete
		
		produitRepository.delete(id);
		
		return Response.ok().build();
	}
	
	// ici c un path param,on specifi qu'on vt chercher avec id
	// c pr ça on utilise l'annotation @pathVariable
	// @RequestMapping(value = "/produits/{id}", method = RequestMethod.GET)
	//@GET
//@Path("{id}")
//public Produit getProduit(@PathParam("id") Long id) {
//return produitRepository.findOne(id);
//	}

	// Ajout avec POST
	//@RequestMapping(value = "/produits", method = RequestMethod.POST)

	// pr que les produits s'envoent en format json on utilise l'annotation
	// @RequestBody
	
	//update
	//on ajoute le pathparam id pr mettre à jour un produit connu par son id
	//@RequestMapping(value = "/produits/{id}", method = RequestMethod.PUT)

	// pr que les produits s'envoent en format json on utilise l'annotation
	// @RequestBody
	
	
	//update
		//on ajoute le pathparam id pr mettre à jour un produit connu par son id
		//@RequestMapping(value = "/produits/{id}", method = RequestMethod.DELETE)

		// pr que les produits s'envoent en format json on utilise l'annotation
		// @RequestBody
//		@DELETE
//		@Path("{id}")
//		public boolean delete(@PathParam("id") Long id, Produit p) {
//			//prck l'id on l'envoit sous le format d'un path param et pas dans la requete
//			p.setId(id);
//			produitRepository.delete(p);
//			return true;
//		}
}
