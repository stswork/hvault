package models.request.registration;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by Sagar Gopale on 4/20/14.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class RegistrationRequest {

    public String fullName;
    public String password;
    public String phone;
    public String email;
    public String city;
    public String country;
    public String pincode;
    public int dayOfBirth;
    public int monthOfBirth;
    public int yearOfBirth;
    public String gender;

    public RegistrationRequest() {
    }

    public RegistrationRequest(String fullName, String password, String phone, String email, String city, String country, String pincode, int dayOfBirth, int monthOfBirth, int yearOfBirth, String gender) {
        this.fullName = fullName;
        this.password = password;
        this.phone = phone;
        this.email = email;
        this.city = city;
        this.country = country;
        this.pincode = pincode;
        this.dayOfBirth = dayOfBirth;
        this.monthOfBirth = monthOfBirth;
        this.yearOfBirth = yearOfBirth;
        this.gender = gender;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
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

    public int getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(int dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public int getMonthOfBirth() {
        return monthOfBirth;
    }

    public void setMonthOfBirth(int monthOfBirth) {
        this.monthOfBirth = monthOfBirth;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
