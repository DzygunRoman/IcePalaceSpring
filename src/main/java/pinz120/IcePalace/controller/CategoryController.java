package pinz120.IcePalace.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pinz120.IcePalace.model.Category;
import pinz120.IcePalace.service.CategoryService;

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
    public String updateCategoryForm( @PathVariable("id") Long id, Model model ){
        Optional<Category> category = categoryService.findById(id);
        if(category.isEmpty()){
            return "redirect:/UpdateCategory";
        }
        model.addAttribute("category",category.get());
        return "UpdateCategory";
    }

    @PostMapping("/UpdateCategory")
    public String updateCategory(@ModelAttribute Category category){
        categoryService.createCategory(category);
        return "redirect:/IndexCategory";
    }
}


