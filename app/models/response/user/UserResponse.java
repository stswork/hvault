package models.response.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by Sagar Gopale on 4/24/14.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserResponse {

    public String fullName;
    public String email;
    public String dateOfBirth;
    public String gender;
    public String userType;

}
