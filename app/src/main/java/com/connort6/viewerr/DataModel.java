package com.connort6.viewerr;

public class DataModel {
    String string;
    double num;

    public DataModel(String string, double num) {
        this.string = string;
        this.num = num;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public double getNum() {
        return num;
    }

    public void setNum(double num) {
        this.num = num;
    }
}
