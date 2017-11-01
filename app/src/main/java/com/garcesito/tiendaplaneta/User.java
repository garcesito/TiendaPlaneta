package com.garcesito.tiendaplaneta;

/**
 * Created by pepel on 1/11/2017.
 */

public class User {
    private String name, name_user,autor, phone;
    private String uid;

    public User(String uid,String name, String autor, String name_user, String phone){
        this.name = name;
        this.name_user = name_user;
        this.autor = autor;
        this.phone = phone;
        this.uid = uid;
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName_user() {
        return name_user;
    }

    public void setName_user(String name_user) {
        this.name_user = name_user;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}
