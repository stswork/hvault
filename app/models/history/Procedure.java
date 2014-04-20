package models.history;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import models.user.User;
import org.joda.time.DateTime;
import play.data.format.Formats;
import play.db.ebean.Model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Sagar Gopale on 3/1/14.
 */
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Procedure extends Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;

    private Timestamp dateTime;

    private String locationOnBody;

    @OneToOne
    private User provider;

    @OneToOne
    private User secondaryProvider;

    private String note;

    @ManyToOne
    private User user;

    @Formats.DateTime(pattern = "MM/dd/yy")
    public Timestamp created = new Timestamp(DateTime.now().toDate().getTime());

    public Procedure() {
    }

    public Procedure(String name, Timestamp dateTime, String locationOnBody, User provider, User secondaryProvider, String note, User user) {
        this.name = name;
        this.dateTime = dateTime;
        this.locationOnBody = locationOnBody;
        this.provider = provider;
        this.secondaryProvider = secondaryProvider;
        this.note = note;
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

    public Timestamp getDateTime() {
        return dateTime;
    }

    public void setDateTime(Timestamp dateTime) {
        this.dateTime = dateTime;
    }

    public String getLocationOnBody() {
        return locationOnBody;
    }

    public void setLocationOnBody(String locationOnBody) {
        this.locationOnBody = locationOnBody;
    }

    public User getProvider() {
        return provider;
    }

    public void setProvider(User provider) {
        this.provider = provider;
    }

    public User getSecondaryProvider() {
        return secondaryProvider;
    }

    public void setSecondaryProvider(User secondaryProvider) {
        this.secondaryProvider = secondaryProvider;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
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
}
