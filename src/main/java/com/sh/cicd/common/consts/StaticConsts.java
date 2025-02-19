package com.sh.cicd.common.consts;

import java.util.Map;

public class StaticConsts {

    public static final String AUTH_HEADER = "Authorization";
    public static final String BEARER = "Bearer ";
    public static final int MILLI_TO_SECOND = 1000;
    public static final int BAD_REQUEST = 400;
    public static final int UNAUTHORIZED = 401;
    public static final int FORBIDDEN = 403;
    public static final int NOT_FOUND = 404;
    public static final int CONFLICT = 409;
    public static final int METHOD_NOT_ALLOWED = 405;
    public static final int INTERNAL_SERVER = 500;
    public static final int REQUEST_TIMEOUT = 408;
    public static final int TOO_MANY_REQUESTS = 429;
    public static final Map<String, String> IMAGE_MIME_TYPES =
            Map.of(
                    "jpg", "image/jpeg",
                    "jpeg", "image/jpeg",
                    "png", "image/png",
                    "gif", "image/gif",
                    "webp", "image/webp");
    public static final String IMAGE_DOMAIN = "https://d3uocrdmdebrsy.cloudfront.net";
    public static final String USER_DEFAULT_IMAGE = "users/default-image.png";
}
