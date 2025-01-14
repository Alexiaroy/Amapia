package com.amapia.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.amapia.entity.Member;
import com.amapia.entity.Producer;
import com.amapia.entity.Product;
import com.amapia.service.ProductService;

@Controller
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@GetMapping
    public String listProducts(Model model) {
        List<Product> products = productService.getAllProducts();
        
        model.addAttribute("products", products);
        return "products/listProducts"; 
    }
	
	@GetMapping("/create")
    public String showCreateForm(Model model, HttpSession session) {
        model.addAttribute("product", new Product());
        Member member = (Member) session.getAttribute("member");

        if (member != null && member.getProducer() != null) {
			Producer producer = member.getProducer();
			model.addAttribute("producer", producer);
			model.addAttribute("products", new Product());
	        return "products/create"; 
		}
		return "products/listProducts";
    
    }
	
	@PostMapping("/create")
	public String createProduct(
	        @ModelAttribute Product product,
	        @RequestParam("imageFile") MultipartFile imageFile,
	        HttpSession session,
	        Model model) throws IOException {

	    // Récupération du membre
	    Member member = (Member) session.getAttribute("member");
	    if (member != null && member.getProducer() != null) {
	        Producer producer = member.getProducer();
	        product.setProducer(producer);
	    } else {
	        throw new IllegalStateException("Producer not found in session.");
	    }

	    // Gestion de l'image
	    if (!imageFile.isEmpty()) {
	        product.setImageData(imageFile.getBytes());
	        product.setImageName(imageFile.getOriginalFilename());
	        product.setImageType(imageFile.getContentType());
	    }

	    // Sauvegarder le produit
	    productService.saveProduct(product, imageFile);

	    // Récupérer tous les produits pour les afficher
	    List<Product> products = productService.getAllProducts();
	    model.addAttribute("products", products);

	    // Ajouter un message de succès
	    model.addAttribute("successMessage", "Produit créé avec succès !");
	    return "products/listProducts"; // Rester sur la même page
	}


}
