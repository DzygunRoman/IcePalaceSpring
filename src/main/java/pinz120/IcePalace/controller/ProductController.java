package pinz120.IcePalace.controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.thymeleaf.util.StringUtils;
import pinz120.IcePalace.DTO.DtoCreateProduct;
import pinz120.IcePalace.model.Category;
import pinz120.IcePalace.model.Product;
import pinz120.IcePalace.repository.CategoryRepository;
import pinz120.IcePalace.repository.ProductRepository;
import pinz120.IcePalace.sevice.CategoryService;
import pinz120.IcePalace.sevice.ProductService;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Controller
public class ProductController {


    private final CategoryService categoryService;
    private final ProductService productService;
    @Autowired
    public ProductController(CategoryService categoryService, ProductService productService) {
        this.categoryService = categoryService;
        this.productService = productService;
    }
    @GetMapping("/IndexProduct")
    public String findAll(Model model){
        List<Product> products = (List<Product>) productService.findAll();
        model.addAttribute("products", products);
        return "IndexProduct";
    }
    @GetMapping("/CreateProduct")
    public String createProductForm( Model model){
        model.addAttribute("categories", productService.getAllCategories());
        model.addAttribute("product", new Product());
        return "CreateProduct";
    }
    @PostMapping("/CreateProduct")
    public String createProduct(Product product)  {
        Product p = new Product();
        p.setName(product.getName());
        p.setPrice(product.getPrice());
        p.setSlug(product.getSlug());
        p.setDescription(product.getDescription());
        p.setAvailable(product.getAvailable());
        p.setCategory(product.getCategory());
        productService.createProduct(p);
        return "redirect:/IndexProduct";
    }
}
