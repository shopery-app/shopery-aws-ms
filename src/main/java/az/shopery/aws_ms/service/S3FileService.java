package az.shopery.aws_ms.service;

import org.springframework.web.multipart.MultipartFile;

public interface S3FileService {
    String uploadNewFile(String oldKey, MultipartFile newFile);
    void deleteFileIfExists(String fileKey);
    String generatePresignedUrl(String fileKey);
}
