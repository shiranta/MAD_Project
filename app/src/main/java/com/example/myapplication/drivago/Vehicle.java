package com.example.myapplication.drivago;

public class Vehicle {
    String cName , price , period;

    public Vehicle(){

    }
    public Vehicle(String cName, String price, String period) {
        this.cName = cName;
        this.price = price;
        this.period = period;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }
}
