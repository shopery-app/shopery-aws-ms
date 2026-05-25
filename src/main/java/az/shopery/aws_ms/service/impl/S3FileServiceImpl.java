package az.shopery.aws_ms.service.impl;

import az.shopery.aws_ms.service.S3FileService;
import az.shopery.aws_ms.util.S3FileUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
@RequiredArgsConstructor
public class S3FileServiceImpl implements S3FileService {

    private final S3FileUtil s3FileUtil;

    @Override
    public String uploadNewFile(String oldKey, MultipartFile newFile) {
        return s3FileUtil.uploadNewFile(oldKey, newFile);
    }

    @Override
    public void deleteFileIfExists(String fileKey) {
        s3FileUtil.deleteFileIfExists(fileKey);
    }

    @Override
    public String generatePresignedUrl(String fileKey) {
        return s3FileUtil.generatePresignedUrl(fileKey);
    }
}
