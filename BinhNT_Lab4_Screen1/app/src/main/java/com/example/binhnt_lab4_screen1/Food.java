package com.example.binhnt_lab4_screen1;

import java.io.Serializable;

public class Food implements Serializable {
    private String name;
    private String desc;
    private Double calogies;
    private Integer img;

    public Food() {
    }

    public Food(String name, String desc, Double calogies, int img) {
        this.name = name;
        this.desc = desc;
        this.calogies = calogies;
        this.img = img;
    }

    public Integer getImg() {
        return img;
    }

    public void setImg(Integer img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Double getCalogies() {
        return calogies;
    }

    public void setCalogies(Double calogies) {
        this.calogies = calogies;
    }

    @Override
    public String toString() {
        return "Food{" +
                "\t\nname:\"" + name + "\"," +
                "\t\ndesc:\"" + desc + "\"," +
                "\t\ncalogies: " + calogies + "," +
                "\t\nimg:" + img + "\n}";
    }
}
