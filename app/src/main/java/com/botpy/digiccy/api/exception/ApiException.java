package com.botpy.digiccy.api.exception;

import android.text.TextUtils;

/**
 * @author liuxuhui
 * @date 2018/11/18
 */
public class ApiException extends Exception {
    /** Customer error code*/
    public static final int API_NETWORK_CONNECTED_ERROR = 80;
    public static final int API_NETWORK_TIME_OUT        = 90;
    public static final int API_NETWORK_ERROR           = 100;
    public static final int API_DECIPHER_ERROR          = 101;
    public static final int API_DESERIALIZE_ERROR       = 102;
    public static final int API_DATA_ERROR              = 103;
    public static final int API_COMPRESS_ERROR          = 106;

    /** Http response code */
    public static final int UNAUTHORIZED        = 401;
    public static final int NOT_FOUND           = 404;
    public static final int METHOD_NOT_ALLOW    = 405;
    public static final int SERVER_ERROR        = 500;
    public static final int SERVICE_UNAVAILABLE = 503;

    private int code;
    private String message;

    public ApiException() {
        super();
    }

    public ApiException(int code) {
        super();
        this.code = code;
    }

    public ApiException(String message) {
        this(0, message);
    }

    public ApiException(int code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    @Override
    public String getMessage() {
        String msg = message;
        switch (code) {
            case API_NETWORK_CONNECTED_ERROR:
                msg = "#没有网络#";
                break;

            case API_NETWORK_TIME_OUT:
                msg = "#连接超时#";
                break;

            case API_NETWORK_ERROR:
                msg = "#网络繁忙#";
                break;

            case UNAUTHORIZED:
                msg = "#登录过期#";
                break;

            case METHOD_NOT_ALLOW:
            case NOT_FOUND:
                msg = "#网络异常#";
                break;

            case API_DECIPHER_ERROR:
                msg = "#解密异常#";
                break;

            case API_DESERIALIZE_ERROR:
                msg = "#解析异常#";
                break;

            case API_DATA_ERROR:
                msg = message;
                break;

            case SERVER_ERROR:
            case SERVICE_UNAVAILABLE:
                msg = "#服务器错误#";
                break;

            case API_COMPRESS_ERROR:
                msg = "#资源异常#";
                break;

            default:
                if (TextUtils.isEmpty(msg)) {
                    msg = "未知错误";
                }
                break;
        }
        return msg;
    }

    public int getCode() {
        return code;
    }
}