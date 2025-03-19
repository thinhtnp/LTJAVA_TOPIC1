package ut.edu.webjava.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ut.edu.webjava.models.Product;
import ut.edu.webjava.repositories.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    // Lấy tất cả sản phẩm
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    // Tìm sản phẩm theo ID
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    // Tìm sản phẩm theo Category ID
    public List<Product> findByCategoryId(Long categoryId) {
        return productRepository.findByCategoryId(categoryId);
    }

    // Thêm mới hoặc cập nhật sản phẩm
    public Product save(Product product) {
        return productRepository.save(product);
    }

    // Xóa sản phẩm theo ID
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }
}
