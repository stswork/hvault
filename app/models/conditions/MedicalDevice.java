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
public class MedicalDevice extends Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Formats.DateTime(pattern = "MM/dd/yy")
    private Timestamp startDate;

    private String deviceType;

    @OneToOne
    private User manufacturer;

    private String model;

    private String serialNumber;

    private String description;

    private String locationOnBody;

    private String note;

    @OneToMany
    private User user;

    public MedicalDevice() {
    }

    public MedicalDevice(Timestamp startDate, String deviceType, User manufacturer, String model, String serialNumber, String description, String locationOnBody, String note, User user) {
        this.startDate = startDate;
        this.deviceType = deviceType;
        this.manufacturer = manufacturer;
        this.model = model;
        this.serialNumber = serialNumber;
        this.description = description;
        this.locationOnBody = locationOnBody;
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

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public User getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(User manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocationOnBody() {
        return locationOnBody;
    }

    public void setLocationOnBody(String locationOnBody) {
        this.locationOnBody = locationOnBody;
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
