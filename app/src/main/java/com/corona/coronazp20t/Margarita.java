package com.corona.coronazp20t;

public class Margarita {
    private int id;
    private String name;
    private String tags;
    private String category;
    private String glass;

    public Margarita(int id, String name, String tags, String category, String glass) {
        this.id = id;
        this.name = name;
        this.tags = tags;
        this.category = category;
        this.glass = glass;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getGlass() {
        return glass;
    }

    public void setGlass(String glass) {
        this.glass = glass;
    }
}
