package com.botpy.digiccy.model;

/**
 * @author liuxuhui
 * @date 2018/11/18
 */
public class Result<T> extends BaseModel {

    public int code;
    public String message;
    public boolean success;
    public T data;

    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", success=" + success +
                ", data=" + data +
                '}';
    }
}
