package com.example.myapplication.drivago;

import android.widget.EditText;

public class Student {
    String id;
    String name;
    String address;
    String tel;
    String vehical;

    public Student(EditText etid, EditText etname, EditText etaddress, EditText ettel, EditText etvehical) {
    }

    public Student(String id, String name, String address, String tel, String vehical) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.tel = tel;
        this.vehical = vehical;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getVehical() {
        return vehical;
    }

    public void setVehical(String vehical) {
        this.vehical = vehical;
    }
}
