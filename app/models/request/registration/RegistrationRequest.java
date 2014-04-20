package models.request.registration;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.sql.Timestamp;

/**
 * Created by Sagar Gopale on 4/20/14.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class RegistrationRequest {

    public String fullName;
    public String nickName;
    public String password;
    public String phone;
    public String email;
    public String city;
    public String country;
    public String pincode;
    public Timestamp dateOfBirth;
    public String gender;

    public RegistrationRequest() {
    }

    public RegistrationRequest(String fullName, String nickName, String password, String phone, String email, String city, String country, String pincode, Timestamp dateOfBirth, String gender) {
        this.fullName = fullName;
        this.nickName = nickName;
        this.password = password;
        this.phone = phone;
        this.email = email;
        this.city = city;
        this.country = country;
        this.pincode = pincode;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
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

    public Timestamp getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Timestamp dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
