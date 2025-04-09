
package ut.edu.webjava.services;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.nio.file.*;

@Service
public class FileStorage {

    private final Path rootLocation = Paths.get("uploads");

    public String storeFile(MultipartFile file) throws IOException {

        if (!Files.exists(rootLocation)) {
            Files.createDirectories(rootLocation);
        }


        String filename = System.currentTimeMillis() + "_" + file.getOriginalFilename();
        Path destination = rootLocation.resolve(filename);


        Files.copy(file.getInputStream(), destination,
                StandardCopyOption.REPLACE_EXISTING);

        return "/uploads/" + filename;
    }
}