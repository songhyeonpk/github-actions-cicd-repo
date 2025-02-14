package com.sh.cicd.infrastructure.s3.exception;

import com.sh.cicd.common.exception.BaseCodeException;

public class S3NotFoundObjectException extends BaseCodeException {

    public static S3NotFoundObjectException NOT_FOUND_OBJECT
            = new S3NotFoundObjectException(S3ErrorCode.NOT_FOUND_OBJECT);

    S3NotFoundObjectException(S3ErrorCode errorCode) {
        super(errorCode);
    }
}
