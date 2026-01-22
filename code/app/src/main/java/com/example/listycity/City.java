package com.example.listycity;

public class City {

    private String name;
    private String province;
    private boolean selected;

    public City(String name, String province) {
        this.name = name;
        this.province = province;
        this.selected = false;
    }

    public String getName() { return name; }
    public String getProvince() { return province; }

    public void setName(String name) { this.name = name; }
    public void setProvince(String province) { this.province = province; }

    public boolean isSelected() { return selected; }
    public void setSelected(boolean selected) { this.selected = selected; }
}
