package com.example.myapplication.drivago;

public class CardInfo {
    private String Name;
    private String CardNo;
    private String exDate;
    private String Cvv;

    public CardInfo(){

    }

    public String getName(){
        return Name;
    }

    public void setName(String Name){
        this.Name = Name;
    }

    public String getCardNo(){
        return CardNo;
    }

    public void setCardNo(String CardNo){
        this.CardNo = CardNo;
    }

    public String getExDate(){
        return exDate;
    }

    public void setExDate(String exDate){
        this.exDate = exDate;
    }

    public String getCvv(){
        return Cvv;
    }

    public void setCvv(String Cvv){
        this.Cvv= Cvv;
    }

}
