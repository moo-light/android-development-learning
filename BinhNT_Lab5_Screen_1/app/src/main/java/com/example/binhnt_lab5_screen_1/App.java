package com.example.binhnt_lab5_screen_1;
public class App {
    private String name;
    private String description;
    private int imageId;
    private String phoneType;

    public App(String name, String description, int imageId, String phoneType) {
        this.name = name;
        this.description = description;
        this.imageId = imageId;
        this.phoneType = phoneType;
    }

    // Getter and setter methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getPhoneType() {
        return phoneType;
    }

    public void setPhoneType(String phoneType) {
        this.phoneType = phoneType;
    }
}
