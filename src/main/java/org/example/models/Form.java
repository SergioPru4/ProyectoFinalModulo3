package org.example.models;

public class Form {
    private  String name;
    private  String country;
    private  String city;
    private  String card;
    private  String month;
    private  String year;

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getCard() {
        return card;
    }

    public String getMonth() {
        return month;
    }

    public String getYear() {
        return year;
    }

    @Override
    public String toString() {
        return "Form{" +
                "name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", card='" + card + '\'' +
                ", month='" + month + '\'' +
                ", year='" + year + '\'' +
                '}';
    }
}

