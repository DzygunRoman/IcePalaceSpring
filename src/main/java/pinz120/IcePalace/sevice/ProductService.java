package pinz120.IcePalace.sevice;

import org.springframework.stereotype.Service;
import pinz120.IcePalace.model.Category;
import pinz120.IcePalace.model.Product;
import pinz120.IcePalace.repository.CategoryRepository;
import pinz120.IcePalace.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    public ProductService(CategoryRepository categoryRepository, ProductRepository productRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }
    public Optional<Product> findById(Long id){
        return productRepository.findById(id);
    }
    public List<Product> findAll(){
        return (List<Product>) productRepository.findAll();
    }
    public void createProduct(Product product){
        productRepository.save(product);
    }
    public void deleteById(Long id){
        productRepository.deleteById(id);
    }
    public List<Category> getAllCategories(){
        return (List<Category>) categoryRepository.findAll();
    }
    public Optional<Category>  getCategory(Long id){
        return categoryRepository.findById(id);
    }
}
