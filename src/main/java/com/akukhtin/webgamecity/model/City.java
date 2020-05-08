package com.akukhtin.webgamecity.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CITY")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "city_name")
    private String cityName;
    @Column(name = "usage_word")
    private boolean usageWord;

    public City() {
    }

    public Long getId() {
        return id;
    }

    public String getCityName() {
        return cityName;
    }

    public boolean isUsageWord() {
        return usageWord;
    }

    public void setUsageWord(boolean usageWord) {
        this.usageWord = usageWord;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", cityName='" + cityName + '\'' +
                '}';
    }
}
