package ut.edu.webjava.services;

import ut.edu.webjava.models.User;
import ut.edu.webjava.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Transactional
    //Không cho phép ID quá lớn hoặc tự đặt ID sai,Tránh lỗi transaction xung đột,Đảm bảo chỉ cập nhật user nếu ID đã tồn tại trong DB
    public User createOrUpdateUser(User user) {
        if (user.getId() != null && !userRepository.existsById(user.getId())) {
            throw new RuntimeException("User ID không tồn tại, không thể cập nhật!");
        }
        return userRepository.save(user);
    }
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public boolean existsByUsername(String username) {
        return userRepository.findByUsername(username).isPresent();
    }

//    public User createUser(User user) {
//        return userRepository.save(user);
//    }
    @Transactional
    public User createUser(User user) {
    user.setId(null); // Xóa ID để tránh lỗi xung đột
    return userRepository.save(user);
    }
    public User updateUser(Long id, User updatedUser) {
        // Kiểm tra xem user có tồn tại không
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Cập nhật thông tin
        existingUser.setUsername(updatedUser.getUsername());
        existingUser.setEmail(updatedUser.getEmail());

        // Lưu vào CSDL
        return userRepository.save(existingUser);
    }
    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

}
