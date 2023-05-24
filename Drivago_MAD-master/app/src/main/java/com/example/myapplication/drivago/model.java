package com.example.myapplication.drivago;

public class model {
    String name,  plate , type;
    Integer contNo;

    model(){

    }
    public model(String name, Integer contNo, String plate, String type) {
        this.name = name;
        this.contNo = contNo;
        this.plate = plate;
        this.type = type;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getContNo() {
        return contNo;
    }

    public void setContNo(Integer contNo) {
        this.contNo = contNo;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
