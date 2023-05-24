package com.example.myapplication.drivago;

public class modelSign {
    String sname , descp , url;

    modelSign(){

    }

    public modelSign(String sname, String descp, String url) {
        this.sname = sname;
        this.descp = descp;
        this.url = url;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getDescp() {
        return descp;
    }

    public void setDescp(String descp) {
        this.descp = descp;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
