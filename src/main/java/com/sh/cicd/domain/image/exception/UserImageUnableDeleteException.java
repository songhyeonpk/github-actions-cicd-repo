package com.sh.cicd.domain.image.exception;

import com.sh.cicd.common.exception.BaseCodeException;

public class UserImageUnableDeleteException extends BaseCodeException {

    public static UserImageUnableDeleteException UNABLE_DELETE =
            new UserImageUnableDeleteException(UserImageErrorCode.USER_IMAGE_UNABLE_DELETE);

    UserImageUnableDeleteException(UserImageErrorCode errorCode) {
        super(errorCode);
    }
}
