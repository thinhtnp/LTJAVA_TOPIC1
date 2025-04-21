package ut.edu.webjava.services;

import ut.edu.webjava.models.User;
import ut.edu.webjava.dto.CreateUserRequest;
import ut.edu.webjava.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
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

    @Transactional
    public User createUser(User user) {
        user.setId(null); // Xóa ID để tránh lỗi xung đột
        return userRepository.save(user);
    }
    @Transactional
    public User updateUser(Long id, User updatedUser) {
        Optional<User> existingUserOpt = userRepository.findById(id);
        if (existingUserOpt.isPresent()) {
            User existingUser = existingUserOpt.get();
            existingUser.setUsername(updatedUser.getUsername());
            existingUser.setEmail(updatedUser.getEmail());
            existingUser.setPhone(updatedUser.getPhone());
            existingUser.setAddress(updatedUser.getAddress());
            existingUser.setRole(updatedUser.getRole());
            return userRepository.save(existingUser);

        } else {
            throw new IllegalArgumentException("User not found");
        }
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

    // Đăng ký tài khoản người dùng từ CreateUserRequest
    @Transactional
    public void registerUser(CreateUserRequest request) {
        // Kiểm tra username có tồn tại không
        if (userRepository.findByUsername(request.getUsername()).isPresent()) {
            throw new RuntimeException("Username already exists");
        }

        // Kiểm tra email có tồn tại không
        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new RuntimeException("Email already exists");
        }

        // Tạo đối tượng User từ CreateUserRequest
        User user = new User();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword())); // Mã hóa mật khẩu

        // Lưu user vào database
        userRepository.save(user);
    }


}
