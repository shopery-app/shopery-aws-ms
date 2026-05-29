package az.shopery.aws_ms.controller;

import az.shopery.aws_ms.service.S3FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/aws")
public class FileStorageController {

    private final S3FileService s3FileService;

    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> uploadFile(@RequestPart("file") MultipartFile file) {
        return ResponseEntity.ok(s3FileService.uploadNewFile(null, file));
    }

    @PutMapping(value = "/update", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> updateFile(@RequestParam String oldKey, @RequestPart("file") MultipartFile newFile) {
        return ResponseEntity.ok(s3FileService.uploadNewFile(oldKey, newFile));
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteFile(@RequestParam(required = false) String fileKey) {
        s3FileService.deleteFileIfExists(fileKey);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/presigned-url")
    public ResponseEntity<String> getPresignedUrl(@RequestParam(required = false) String fileKey) {
        return ResponseEntity.ok(s3FileService.generatePresignedUrl(fileKey));
    }
}
