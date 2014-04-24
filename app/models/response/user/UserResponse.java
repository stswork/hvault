package models.response.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by Sagar Gopale on 4/24/14.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserResponse {

    public String fullName;
    public String primaryEmail;
    public String primaryPhone;
    public String dateOfBirth;
    public String gender;
    public String userType;

    public UserResponse() {
    }

    public UserResponse(String fullName, String primaryEmail, String primaryPhone, String dateOfBirth, String gender, String userType) {
        this.fullName = fullName;
        this.primaryEmail = primaryEmail;
        this.primaryPhone = primaryPhone;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.userType = userType;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPrimaryEmail() {
        return primaryEmail;
    }

    public void setPrimaryEmail(String primaryEmail) {
        this.primaryEmail = primaryEmail;
    }

    public String getPrimaryPhone() {
        return primaryPhone;
    }

    public void setPrimaryPhone(String primaryPhone) {
        this.primaryPhone = primaryPhone;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
}
