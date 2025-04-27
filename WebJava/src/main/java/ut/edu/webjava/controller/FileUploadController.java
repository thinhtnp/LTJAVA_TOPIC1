//
//package ut.edu.webjava.controller;
//
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//import ut.edu.webjava.service.FileStorage;
//import java.io.IOException;
//
//@RestController
//@RequestMapping("/api/files")
//public class FileUploadController {
//
//    private final FileStorage fileStorageService;
//
//
//    public FileUploadController(FileStorage fileStorageService) {
//        this.fileStorageService = fileStorageService;
//    }
//
//    @PostMapping("/upload")
//    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
//        try {
//            String fileUrl = fileStorageService.storeFile(file);
//            return ResponseEntity.ok(fileUrl);
//        } catch (IOException e) {
//            return ResponseEntity.internalServerError()
//                    .body("Upload failed: " + e.getMessage());
//        }
//    }
//}