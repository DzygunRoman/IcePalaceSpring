package pinz120.IcePalace.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pinz120.IcePalace.model.Category;
import pinz120.IcePalace.repository.CategoryRepository;

import java.util.List;
@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category findById(Long id){
        return categoryRepository.getOne(id);
    }
    public List<Category> findAll(){
        return categoryRepository.findAll();
    }
    public Category saveCategory(Category category){
        return  categoryRepository.save(category);
    }
    public void deleteById(Long id){
        categoryRepository.deleteById(id);
    }
}
