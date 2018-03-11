package com.example.demo.model;

/**
 * Created by yangtthi on 18/3/11.
 */
public class ResponseModel {

    private int code;
    private String name;
    private Object data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
