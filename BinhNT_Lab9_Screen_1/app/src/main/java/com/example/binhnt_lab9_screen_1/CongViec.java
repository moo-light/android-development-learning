package com.example.binhnt_lab9_screen_1;

import java.io.Serializable;

public class CongViec implements Serializable {
    private String tenCV;
    private int idCV;
    public CongViec(String name, int idCV) {
        this.tenCV = name;
        this.idCV = idCV;
    }

    public CongViec() {
    }

    public String getTenCV() {
        return tenCV;
    }

    public void setTenCV(String tenCV) {
        this.tenCV = tenCV;
    }

    public int getIdCV() {
        return idCV;
    }

    public void setIdCV(int idCV) {
        this.idCV = idCV;
    }
}
