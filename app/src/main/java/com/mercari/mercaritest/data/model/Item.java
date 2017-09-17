package com.mercari.mercaritest.data.model;

public class Item {

    private   String id;

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setNum_likes(long num_likes) {
        this.num_likes = num_likes;
    }

    public void setNum_comments(long num_comments) {
        this.num_comments = num_comments;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    private  String name;
    private  String status;
    private  long num_likes;
    private  long num_comments;
    private  long price;
    private  String photo;

    public Item(String id, String name, long num_likes, long num_comments, long price, String photo, String status) {
        this.id = id;
        this.name = name;
        this.num_likes = num_likes;
        this.num_comments = num_comments;
        this.price = price;
        this.photo = photo;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    public long getNum_likes() {
        return num_likes;
    }

    public long getNum_comments() {
        return num_comments;
    }

    public long getPrice() {
        return price;
    }

    public String getPhoto() {
        return photo;
    }

}
