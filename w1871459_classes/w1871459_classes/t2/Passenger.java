package com.loshithan;

public class Passenger {
    String fName = "empty";
    String sName = "empty";
    int exp = 0;

    public void setFname(String fname) {
        this.fName = fname;
    }

    public void setSname(String sname) {
        this.sName = sname;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }



    public String getFname() {
        return fName;
    }

    public String getSname() {
        return sName;
    }

    public int getExp() {
        return exp;
    }
}
