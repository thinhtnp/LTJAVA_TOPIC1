package ut.edu.webjava.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ut.edu.webjava.models.Category;
import ut.edu.webjava.repositories.CategoryRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    // Lấy danh sách tất cả danh mục
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    // Tìm danh mục theo ID
    public Optional<Category> findById(Long id) {
        return categoryRepository.findById(id);
    }

    // Thêm mới hoặc cập nhật danh mục
    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    // Xóa danh mục
    public void deleteById(Long id) {
        categoryRepository.deleteById(id);
    }
}
