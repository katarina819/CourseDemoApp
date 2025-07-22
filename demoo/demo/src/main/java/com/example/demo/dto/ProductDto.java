package com.example.demo.dto;

public class ProductDto {
    private String id;
    private String name;
    private String description;
    private Integer priceCentAmount;      // cijena u centima
    private String priceCurrencyCode;     // valuta, EUR
    private String startDate;
    private String duration;

    public ProductDto(String id, String name, String description, Integer priceCentAmount, String priceCurrencyCode, String startDate, String duration) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.priceCentAmount = priceCentAmount;
        this.priceCurrencyCode = priceCurrencyCode;
        this.startDate = startDate;
        this.duration = duration;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Integer getPriceCentAmount() {
        return priceCentAmount;
    }

    public void setPriceCentAmount(Integer priceCentAmount) {
        this.priceCentAmount = priceCentAmount;
    }

    public String getPriceCurrencyCode() {
        return priceCurrencyCode;
    }

    public void setPriceCurrencyCode(String priceCurrencyCode) {
        this.priceCurrencyCode = priceCurrencyCode;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

}
