package pinz120.IcePalace.sevice;

import org.springframework.stereotype.Service;
import pinz120.IcePalace.model.Category;
import pinz120.IcePalace.repository.CategoryRepository;

import java.util.List;
import java.util.Optional;
@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Optional<Category> findById(Long id){
        return categoryRepository.findById(id);
    }
    public List<Category> findAll(){
        return (List<Category>) categoryRepository.findAll();
    }
    public void createCategory(Category category){
        categoryRepository.save(category);
    }
    public void deleteById(Long id){
        categoryRepository.deleteById(id);
    }
}
