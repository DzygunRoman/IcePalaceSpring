package pinz120.IcePalace.controller;


import jakarta.servlet.http.HttpSession;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import pinz120.IcePalace.model.Cart;
import pinz120.IcePalace.model.Product;
import pinz120.IcePalace.service.CategoryService;
import pinz120.IcePalace.service.ProductService;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    public String createProduct(Product product, @RequestParam("file") MultipartFile file) throws IOException {
        Path resourceDirectory =  Paths.get("src","main", "resources", "static", "images");
        Path fileNameAndPath = Paths.get(resourceDirectory.toAbsolutePath().toString(), file.getOriginalFilename());
        try(FileOutputStream stream = new FileOutputStream(fileNameAndPath.toString())){
            stream.write(file.getBytes());
        }catch (FileNotFoundException e){}
        product.setPhoto(file.getOriginalFilename());
        productService.createProduct(product);
        return "redirect:/IndexProduct";
    }

    @GetMapping("/DeleteProduct/{id}")
    public String deleteProduct(@PathVariable("id") Long id){
        productService.deleteById(id);
        return "redirect:/IndexProduct";
    }

    @GetMapping("/UpdateProduct/{id}")
    public String updateProductForm(@PathVariable("id") Long id, Model model){
        Optional<Product> product = productService.findById(id);
        model.addAttribute("categories", productService.getAllCategories());
        model.addAttribute("product", new Product());
        return "UpdateProduct";
    }

    @PostMapping("/UpdateProduct")
    public String updateProduct(Product product, @RequestParam("file") MultipartFile file) throws IOException{
        Path resourceDirectory =  Paths.get("src","main", "resources", "static", "images");
        Path fileNameAndPath = Paths.get(resourceDirectory.toAbsolutePath().toString(), file.getOriginalFilename());
        try(FileOutputStream stream = new FileOutputStream(fileNameAndPath.toString())){
            stream.write(file.getBytes());
        }catch (FileNotFoundException e){}
        product.setPhoto(file.getOriginalFilename());
        productService.createProduct(product);
        return "redirect:/IndexProduct";
    }

}
