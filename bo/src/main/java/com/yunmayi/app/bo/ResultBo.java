package com.yunmayi.app.bo;

/**
 * Created by ys on 2018/4/19.
 */

public class ResultBo {

    /**
     * error : false
     * code : 信息代码
     * message : 信息
     */
    private boolean error;
    private String code;
    private String message;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
