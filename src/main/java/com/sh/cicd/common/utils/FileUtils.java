package com.sh.cicd.common.utils;

import org.springframework.stereotype.Component;

import static com.sh.cicd.common.consts.StaticConsts.IMAGE_MIME_TYPES;

@Component
public class FileUtils {

    // 파일 확장자 추출
    public String getFileExtension(String filename) {
        int index = filename.lastIndexOf(".");
        if(index == -1 || index == filename.length() - 1) {
            throw new RuntimeException("file extension error");
        }

        return filename.substring(index + 1).toLowerCase();
    }

    // 이미지 파일 확장자 Content Type 추출
    public String getImageContentType(String fileExtension) {
        String mime = IMAGE_MIME_TYPES.get(fileExtension);
        if(mime == null) {
            throw new RuntimeException("content type error.");
        }

        return mime;
    }
}
