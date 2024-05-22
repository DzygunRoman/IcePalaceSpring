package pinz120.IcePalace.controller;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pinz120.IcePalace.model.Category;
import pinz120.IcePalace.repository.CategoryRepository;
import pinz120.IcePalace.sevice.CategoryService;

import java.util.List;
import java.util.Optional;

@Controller
public class CategoryController {
    private final CategoryService categoryService;
    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/IndexCategory")
    public String findAll(Model model){
        List<Category> categories = (List<Category>) categoryService.findAll();
        model.addAttribute("categories", categories);
        return "IndexCategory";
    }
    @GetMapping("/CreateCategory")
    public String createCategoryForm(Category category){
        return "CreateCategory";
    }
    @PostMapping("/CreateCategory")
    public String createCategory(Category category){
        categoryService.createCategory(category);
        return "redirect:/IndexCategory";
    }
    @GetMapping("/DeleteCategory/{id}")
    public String deleteCategory(@PathVariable("id") Long id){
        categoryService.deleteById(id);
        return "redirect:/IndexCategory";
    }
    @GetMapping("/UpdateCategory/{id}")
    public String updateCategoryForm(@PathVariable("id") Long id, Model model ){
        Optional<Category> category = categoryService.findById(id);
        model.addAttribute("category",category);
        return "UpdateCategory";
    }
    @PostMapping("/UpdateCategory/{id}")
    public String updateCategory(Category category){
        categoryService.createCategory(category);
        return "redirect:/IndexCategory";
    }
}


