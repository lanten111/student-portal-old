package co.za.dto;

import java.io.Serializable;
import java.util.Objects;

public class AddressDto implements Serializable {
    private String streetName;
    private String buildingNumber;
    private String city;
    private String zipCode;
    private String country;

    public AddressDto() {
    }

    public AddressDto(String streetName, String buildingNumber, String city, String zipCode, String country) {
        this.streetName = streetName;
        this.buildingNumber = buildingNumber;
        this.city = city;
        this.zipCode = zipCode;
        this.country = country;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getBuildingNumber() {
        return buildingNumber;
    }

    public void setBuildingNumber(String buildingNumber) {
        this.buildingNumber = buildingNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddressDto entity = (AddressDto) o;
        return Objects.equals(this.streetName, entity.streetName) &&
                Objects.equals(this.buildingNumber, entity.buildingNumber) &&
                Objects.equals(this.city, entity.city) &&
                Objects.equals(this.zipCode, entity.zipCode) &&
                Objects.equals(this.country, entity.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(streetName, buildingNumber, city, zipCode, country);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "streetName = " + streetName + ", " +
                "buildingNumber = " + buildingNumber + ", " +
                "city = " + city + ", " +
                "zipCode = " + zipCode + ", " +
                "country = " + country + ")";
    }
}
