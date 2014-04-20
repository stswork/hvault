package models.measurements;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import models.Comparison;
import models.YesNo;
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
public class BloodGlucose extends Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private MeasurementContext measurementContext;

    private BloodGlucoseMeasurementType measurementType;

    @Formats.DateTime(pattern = "MM/dd/yy")
    private Timestamp dateTime;

    private Comparison comparisonToNormal;

    private YesNo resultOfControlTest;

    private YesNo rangeOfDevice;

    private String note;

    @ManyToOne
    private User user;

    @Formats.DateTime(pattern = "MM/dd/yy")
    public Timestamp created = new Timestamp(DateTime.now().toDate().getTime());

    public BloodGlucose() {
    }

    public BloodGlucose(MeasurementContext measurementContext, BloodGlucoseMeasurementType measurementType, Timestamp dateTime, Comparison comparisonToNormal, YesNo resultOfControlTest, YesNo rangeOfDevice, String note, User user) {
        this.measurementContext = measurementContext;
        this.measurementType = measurementType;
        this.dateTime = dateTime;
        this.comparisonToNormal = comparisonToNormal;
        this.resultOfControlTest = resultOfControlTest;
        this.rangeOfDevice = rangeOfDevice;
        this.note = note;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MeasurementContext getMeasurementContext() {
        return measurementContext;
    }

    public void setMeasurementContext(MeasurementContext measurementContext) {
        this.measurementContext = measurementContext;
    }

    public BloodGlucoseMeasurementType getMeasurementType() {
        return measurementType;
    }

    public void setMeasurementType(BloodGlucoseMeasurementType measurementType) {
        this.measurementType = measurementType;
    }

    public Timestamp getDateTime() {
        return dateTime;
    }

    public void setDateTime(Timestamp dateTime) {
        this.dateTime = dateTime;
    }

    public Comparison getComparisonToNormal() {
        return comparisonToNormal;
    }

    public void setComparisonToNormal(Comparison comparisonToNormal) {
        this.comparisonToNormal = comparisonToNormal;
    }

    public YesNo getResultOfControlTest() {
        return resultOfControlTest;
    }

    public void setResultOfControlTest(YesNo resultOfControlTest) {
        this.resultOfControlTest = resultOfControlTest;
    }

    public YesNo getRangeOfDevice() {
        return rangeOfDevice;
    }

    public void setRangeOfDevice(YesNo rangeOfDevice) {
        this.rangeOfDevice = rangeOfDevice;
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

