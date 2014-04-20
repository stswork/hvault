package models.contact;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import models.user.User;
import play.data.validation.Constraints;
import play.db.ebean.Model;

import javax.persistence.*;

/**
 * Created by Sagar Gopale on 2/26/14.
 */
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Phone extends Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Constraints.Required
    private String name;

    @Constraints.Required
    private String description;

    @ManyToOne
    private User user;

    public Phone() {
    }

    public Phone(String name, String description, User user) {
        this.name = name;
        this.description = description;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
