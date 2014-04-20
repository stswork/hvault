package models.contact;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import models.user.User;
import play.db.ebean.Model;

import javax.persistence.*;

/**
 * Created by Sagar Gopale on 2/26/14.
 */
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Address extends Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String streetAddress1;

    private String streetAddress2;

    private String streetAddress3;

    private String city;

    private String state;

    private String country;

    private String pincode;

    @ManyToOne
    private User user;

    public Address() {
    }

    public Address(Long id, String streetAddress1, String streetAddress2, String streetAddress3, String city, String state, String country, String pincode) {
        this.id = id;
        this.streetAddress1 = streetAddress1;
        this.streetAddress2 = streetAddress2;
        this.streetAddress3 = streetAddress3;
        this.city = city;
        this.state = state;
        this.country = country;
        this.pincode = pincode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreetAddress1() {
        return streetAddress1;
    }

    public void setStreetAddress1(String streetAddress1) {
        this.streetAddress1 = streetAddress1;
    }

    public String getStreetAddress2() {
        return streetAddress2;
    }

    public void setStreetAddress2(String streetAddress2) {
        this.streetAddress2 = streetAddress2;
    }

    public String getStreetAddress3() {
        return streetAddress3;
    }

    public void setStreetAddress3(String streetAddress3) {
        this.streetAddress3 = streetAddress3;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }
}
