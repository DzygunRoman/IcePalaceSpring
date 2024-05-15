package pinz120.IcePalace.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pinz120.IcePalace.model.Category;
import pinz120.IcePalace.repository.CategoryRepository;


import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/IndexCategory")
public class CategoryController {
    @Autowired
    CategoryRepository categoryRepository;


    @GetMapping("/IndexCategory")
    public String findAllCategories(Model model){
        List<Category> categories = (List<Category>) categoryRepository.findAll();
        model.addAttribute("categories", categories);
        return "IndexCategory";
    }
    @GetMapping("/CreateCategory")
    public String createCategoryForm(Category category){
        return "CreateCategory";
    }
    @PostMapping("/CreateCategory")
    public String createCategory(Category category){
         categoryRepository.save(category);
        return "redirect:/IndexCategory";
    }
    @GetMapping("DeleteCategory/{id}")
    public String deleteCategory(@PathVariable("id") Long id){
        categoryRepository.deleteById(id);
        return "redirect:/IndexCategory";
    }

    @PostMapping("/UpdateCategory")
    public String updateCategory(@ModelAttribute Category category, Model model){
        categoryRepository.save(category);
        return "redirect:/IndexCategory";
    }
}
