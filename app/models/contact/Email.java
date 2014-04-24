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
public class Email extends Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Constraints.Required
    private String name;

    @Constraints.Required
    private String description;

    @Constraints.Required
    private EmailType emailType;

    @ManyToOne
    private User user;

    @Formats.DateTime(pattern = "MM/dd/yy")
    public Timestamp created = new Timestamp(DateTime.now().toDate().getTime());

    public Email(String name, String description, EmailType emailType, User user) {
        this.name = name;
        this.description = description;
        this.emailType = emailType;
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

    public String getEmail() {
        return description;
    }

    public void setEmail(String description) {
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

    public EmailType getEmailType() {return emailType;}

    public void setEmailType(EmailType emailType) {this.emailType = emailType;}

    public static Finder<Long, Email> find = new Finder<Long, Email>(
            Long.class, Email.class
    );

    public enum EmailType {
        PRIMARY,
        SECONDARY
    }
}
