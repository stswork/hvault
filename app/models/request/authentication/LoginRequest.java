package models.request.authentication;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by Sagar Gopale on 4/24/14.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class LoginRequest {

    public String userName;
    public String password;

    public LoginRequest() {
    }

    public LoginRequest(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
