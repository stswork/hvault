package models.conditions;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import models.user.User;
import play.data.format.Formats;
import play.db.ebean.Model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Sagar Gopale on 3/1/14.
 */
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Condition extends Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;

    private String severity;

    private String status;

    @Formats.DateTime(pattern = "MM/dd/yy")
    private Timestamp startDate;

    @Formats.DateTime(pattern = "MM/dd/yy")
    private Timestamp endDate;

    private String howItEnded;

    private String note;

    @OneToMany
    private User user;

    public Condition() {
    }

    public Condition(String name, String severity, String status, Timestamp startDate, Timestamp endDate, String howItEnded, String note, User user) {
        this.name = name;
        this.severity = severity;
        this.status = status;
        this.startDate = startDate;
        this.endDate = endDate;
        this.howItEnded = howItEnded;
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

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Timestamp getStartDate() {
        return startDate;
    }

    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    public Timestamp getEndDate() {
        return endDate;
    }

    public void setEndDate(Timestamp endDate) {
        this.endDate = endDate;
    }

    public String getHowItEnded() {
        return howItEnded;
    }

    public void setHowItEnded(String howItEnded) {
        this.howItEnded = howItEnded;
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
}
