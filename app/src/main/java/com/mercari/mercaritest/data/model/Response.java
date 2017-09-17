package com.mercari.mercaritest.data.model;

import java.util.List;

public class Response {
    private   String result;

    public void setResult(String result) {
        this.result = result;
    }

    public void setData(List<Item> data) {
        this.data = data;
    }

    private   List<Item> data;

    public Response(String result, List<Item> data) {
        this.result = result;
        this.data = data;
    }

    public String getResult() {
        return result;
    }

    public List<Item> getData() {
        return data;
    }

}