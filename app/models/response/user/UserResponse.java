package models.response.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by Sagar Gopale on 4/24/14.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserResponse {

    public Long id = 0L;
    public String fullName = StringUtils.EMPTY;
    public String primaryEmail;
    public String primaryPhone;
    public String dateOfBirth;
    public String gender;
    public String userType;
    public String relationshipToPrimary = StringUtils.EMPTY;

    public UserResponse() {
    }

    public UserResponse(Long id, String fullName, String primaryEmail, String primaryPhone, String dateOfBirth, String gender, String userType, String relationshipToPrimary) {
        this.id = id;
        this.fullName = fullName;
        this.primaryEmail = primaryEmail;
        this.primaryPhone = primaryPhone;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.userType = userType;
        this.relationshipToPrimary = relationshipToPrimary;
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

    public String getRelationshipToPrimary() {
        return relationshipToPrimary;
    }

    public void setRelationshipToPrimary(String relationshipToPrimary) {
        this.relationshipToPrimary = relationshipToPrimary;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
