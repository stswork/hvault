package models.contact;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import models.user.User;
import org.joda.time.DateTime;
import play.data.format.Formats;
import play.data.validation.Constraints;
import play.db.ebean.Model;

import javax.persistence.*;
import java.sql.Timestamp;

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

    @Constraints.Required
    private ContactType phoneType;

    @ManyToOne
    private User user;

    @Formats.DateTime(pattern = "MM/dd/yy")
    public Timestamp created = new Timestamp(DateTime.now().toDate().getTime());

    public Phone() {
    }

    public Phone(String name, String description, ContactType phoneType, User user) {
        this.name = name;
        this.description = description;
        this.phoneType = phoneType;
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

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public static Finder<Long, Phone> find = new Finder<Long, Phone>(
            Long.class, Phone.class
    );

    public ContactType getPhoneType() {
        return phoneType;
    }

    public void setPhoneType(ContactType phoneType) {
        this.phoneType = phoneType;
    }

    public enum PhoneType {
        PRIMARY,
        SECONDARY
    }
}
