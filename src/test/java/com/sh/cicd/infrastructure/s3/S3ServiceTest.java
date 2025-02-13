package com.sh.cicd.infrastructure.s3;

import com.sh.cicd.common.utils.FileUtils;
import com.sh.cicd.infrastructure.s3.dto.ImageUrlDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.presigner.S3Presigner;
import software.amazon.awssdk.services.s3.presigner.model.PresignedPutObjectRequest;
import software.amazon.awssdk.services.s3.presigner.model.PutObjectPresignRequest;

import java.net.URI;
import java.net.URL;

import static org.mockito.ArgumentMatchers.any;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class S3ServiceTest {

    @Mock
    private S3Properties s3Properties;

    @Mock
    private S3Presigner s3Presigner;

    @Mock
    private S3Client s3Client;

    @Mock
    private FileUtils fileUtils;

    @InjectMocks
    private S3Service s3Service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        when(s3Properties.getBucketName()).thenReturn("test-bucket");
    }

    @Test
    @DisplayName("pre-signed URL 발급 요청")
    void getPresignedUrlForUser() throws Exception{
        // Given
        String filename = "test-image.jpg";
        String fileExtension = "jpg";
        String contentType = "image/jpeg";

        when(fileUtils.getFileExtension(filename)).thenReturn(fileExtension);
        when(fileUtils.getImageContentType(fileExtension)).thenReturn(contentType);

        URI mockUri = URI.create("https://test-bucket.s3.amazonaws.com/users/mock-image.jpg");
        PresignedPutObjectRequest mockPresignedRequest = mock(PresignedPutObjectRequest.class);
        when(mockPresignedRequest.url()).thenReturn(new URL(mockUri.toString()));

        when(s3Presigner.presignPutObject(any(PutObjectPresignRequest.class)))
                .thenReturn(mockPresignedRequest);

        ImageUrlDto imageUrlDto = s3Service.getPreSignedUrlForUser(filename);

        System.out.println("url: " + imageUrlDto.getUrl());
        System.out.println("key: " + imageUrlDto.getKey());

        assertNotNull(imageUrlDto);
        assertTrue(imageUrlDto.getUrl().startsWith("https://test-bucket.s3.amazonaws.com/users/"));
        assertTrue(imageUrlDto.getKey().startsWith("users/"));

        verify(s3Presigner, times(1)).presignPutObject(any(PutObjectPresignRequest.class));
    }
}
