package com.sh.cicd.infrastructure.s3;

import com.sh.cicd.common.utils.FileUtils;
import com.sh.cicd.infrastructure.s3.dto.ImageUrlDto;
import com.sh.cicd.infrastructure.s3.exception.S3NotFoundObjectException;
import java.time.Duration;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.*;
import software.amazon.awssdk.services.s3.presigner.S3Presigner;
import software.amazon.awssdk.services.s3.presigner.model.PresignedPutObjectRequest;
import software.amazon.awssdk.services.s3.presigner.model.PutObjectPresignRequest;

@Service
@RequiredArgsConstructor
public class S3Service {

    private final S3Properties s3Properties;
    private final S3Presigner s3Presigner;
    private final S3Client s3Client;
    private final FileUtils fileUtils;

    // 유저 pre-signed URL 요청
    public ImageUrlDto getPreSignedUrlForUser(String filename) {
        String fileExtension = fileUtils.getFileExtension(filename);
        String contentType = fileUtils.getImageContentType(fileExtension);
        String imageKey = "users/" + UUID.randomUUID() + "." + fileExtension;
        String url = generatePreSignedUrlRequest(imageKey, contentType);

        return ImageUrlDto.of(url, imageKey);
    }

    // pre-signed URL 발급
    private String generatePreSignedUrlRequest(String imageKey, String contentType) {
        PutObjectRequest putObjectRequest =
                PutObjectRequest.builder()
                        .bucket(s3Properties.getBucketName())
                        .key(imageKey)
                        .contentType(contentType)
                        .build();

        PutObjectPresignRequest putObjectPresignRequest =
                PutObjectPresignRequest.builder()
                        .signatureDuration(Duration.ofMinutes(5))
                        .putObjectRequest(putObjectRequest)
                        .build();

        PresignedPutObjectRequest presignedPutObjectRequest =
                s3Presigner.presignPutObject(putObjectPresignRequest);
        s3Presigner.close();

        return presignedPutObjectRequest.url().toString();
    }

    // 이미지 삭제
    public void deleteImage(String imageKey) {
        try {
            // 요청한 imageKey 를 가진 객체가 존재하는지 확인
            s3Client.headObject(
                    HeadObjectRequest.builder()
                            .bucket(s3Properties.getBucketName())
                            .key(imageKey)
                            .build());

            // 이미지 삭제
            DeleteObjectRequest deleteObjectRequest =
                    DeleteObjectRequest.builder()
                            .bucket(s3Properties.getBucketName())
                            .key(imageKey)
                            .build();

            s3Client.deleteObject(deleteObjectRequest);
        } catch (NoSuchKeyException e) {
            throw S3NotFoundObjectException.NOT_FOUND_OBJECT;
        }
    }
}
