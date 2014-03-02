package models.history;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import models.user.User;
import play.db.ebean.Model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Sagar Gopale on 3/1/14.
 */
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Appointment extends Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private Timestamp startDate;

    private Timestamp endDate;

    @OneToOne
    private User provider;

    private String speciality;

    private String purpose;

    private AppointmentType appointmentType;

    private AppointmentStatus appointmentStatus;

    private String note;

    @OneToMany
    private User user;

    public Appointment() {
    }

    public Appointment(Timestamp startDate, Timestamp endDate, User provider, String speciality, String purpose, AppointmentType appointmentType, AppointmentStatus appointmentStatus, String note, User user) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.provider = provider;
        this.speciality = speciality;
        this.purpose = purpose;
        this.appointmentType = appointmentType;
        this.appointmentStatus = appointmentStatus;
        this.note = note;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public User getProvider() {
        return provider;
    }

    public void setProvider(User provider) {
        this.provider = provider;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public AppointmentType getAppointmentType() {
        return appointmentType;
    }

    public void setAppointmentType(AppointmentType appointmentType) {
        this.appointmentType = appointmentType;
    }

    public AppointmentStatus getAppointmentStatus() {
        return appointmentStatus;
    }

    public void setAppointmentStatus(AppointmentStatus appointmentStatus) {
        this.appointmentStatus = appointmentStatus;
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
