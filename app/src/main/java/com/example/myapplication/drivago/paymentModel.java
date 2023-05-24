

package com.example.myapplication.drivago;

public class paymentModel {
    private String name;
    private String cardNo;
    private String exDate;
    private String cvv;

    paymentModel()
    {

    }

    public paymentModel(String name, String cardNo, String exDate, String Cvv) {
        this.name = name;
        this.cardNo = cardNo;
        this.exDate = exDate;
        this.cvv = Cvv;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getExDate() {
        return exDate;
    }

    public void setExDate(String exDate) {
        this.exDate = exDate;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }
}

