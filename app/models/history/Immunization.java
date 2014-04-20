package models.history;

import models.user.User;
import org.joda.time.DateTime;
import play.data.format.Formats;
import play.db.ebean.Model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Sagar Gopale on 3/1/14.
 */
public class Immunization extends Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String immunizationType;

    @Formats.DateTime(pattern = "MM/dd/yy")
    private Timestamp dateGiven;

    private String numberInSequence; //1 of 3 OR 2 of 4, etc.

    @OneToOne
    private User provider;

    private String adverseEffects;

    private String locationOnBody;

    private String manufacturer;

    @ManyToOne
    private User user;

    @Formats.DateTime(pattern = "MM/dd/yy")
    public Timestamp created = new Timestamp(DateTime.now().toDate().getTime());

    public Immunization() {
    }

    public Immunization(String immunizationType, Timestamp dateGiven, String numberInSequence, User provider, String adverseEffects, String locationOnBody, String manufacturer, User user) {
        this.immunizationType = immunizationType;
        this.dateGiven = dateGiven;
        this.numberInSequence = numberInSequence;
        this.provider = provider;
        this.adverseEffects = adverseEffects;
        this.locationOnBody = locationOnBody;
        this.manufacturer = manufacturer;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImmunizationType() {
        return immunizationType;
    }

    public void setImmunizationType(String immunizationType) {
        this.immunizationType = immunizationType;
    }

    public Timestamp getDateGiven() {
        return dateGiven;
    }

    public void setDateGiven(Timestamp dateGiven) {
        this.dateGiven = dateGiven;
    }

    public String getNumberInSequence() {
        return numberInSequence;
    }

    public void setNumberInSequence(String numberInSequence) {
        this.numberInSequence = numberInSequence;
    }

    public User getProvider() {
        return provider;
    }

    public void setProvider(User provider) {
        this.provider = provider;
    }

    public String getAdverseEffects() {
        return adverseEffects;
    }

    public void setAdverseEffects(String adverseEffects) {
        this.adverseEffects = adverseEffects;
    }

    public String getLocationOnBody() {
        return locationOnBody;
    }

    public void setLocationOnBody(String locationOnBody) {
        this.locationOnBody = locationOnBody;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
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
