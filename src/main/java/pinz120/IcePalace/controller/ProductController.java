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
import pinz120.IcePalace.model.Category;
import pinz120.IcePalace.model.Product;
import pinz120.IcePalace.repository.CategoryRepository;
import pinz120.IcePalace.repository.ProductRepository;
import pinz120.IcePalace.sevice.CategoryService;
import pinz120.IcePalace.sevice.ProductService;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
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
        model.addAttribute("product", product);
        return "UpdateProduct";
    }
    @PostMapping("/UpdateProduct")
    public String updateProduct(Product product){
        productService.createProduct(product);
        return "redirect:/IndexProduct";
    }

}
