package models.measurements;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import models.user.User;
import org.joda.time.DateTime;
import play.data.format.Formats;
import play.data.validation.Constraints;
import play.db.ebean.Model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Sagar Gopale on 3/1/14.
 */
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Weight extends Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Constraints.Required
    private Integer pounds;

    @Constraints.Required
    private Integer ounce;

    public String note;

    @ManyToOne
    private User user;

    @Formats.DateTime(pattern = "MM/dd/yy")
    public Timestamp created = new Timestamp(DateTime.now().toDate().getTime());

    public Weight() {
    }

    public Weight(Integer pounds, Integer ounce, String note, User user) {
        this.pounds = pounds;
        this.ounce = ounce;
        this.note = note;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPounds() {
        return pounds;
    }

    public void setPounds(Integer pounds) {
        this.pounds = pounds;
    }

    public Integer getOunce() {
        return ounce;
    }

    public void setOunce(Integer ounce) {
        this.ounce = ounce;
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

    public static Finder<Long, Weight> find = new Finder<Long, Weight>(
            Long.class, Weight.class
    );
}
