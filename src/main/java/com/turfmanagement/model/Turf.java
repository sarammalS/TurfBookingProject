package com.turfmanagement.model;

public class Turf {
    private int id;
    private String name;
    private String location;
    private String description;
    private double pricePerHour;
    private String imagePath;

    public Turf() {}

    public Turf(int id, String name, String location, String description, double pricePerHour, String imagePath) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.description = description;
        this.pricePerHour = pricePerHour;
        this.imagePath = imagePath;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public double getPricePerHour() { return pricePerHour; }
    public void setPricePerHour(double pricePerHour) { this.pricePerHour = pricePerHour; }

    public String getImagePath() { return imagePath; }
    public void setImagePath(String imagePath) { this.imagePath = imagePath; }
}
