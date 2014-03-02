package models.conditions;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import models.YesNo;
import models.user.User;
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
public class Allergy extends Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Constraints.Required
    private String name;

    private String reaction;

    private AllergyType allergyType;

    @Formats.DateTime(pattern = "MM/dd/yy")
    private Timestamp firstObserved;

    @OneToOne
    private User provider;

    private String treatment;

    @Constraints.Required
    private YesNo effective;

    private String allergenCode;

    private String note;

    @OneToMany
    private User user;

    public Allergy() {
    }

    public Allergy(String name, String reaction, AllergyType allergyType, Timestamp firstObserved, User provider, String treatment, YesNo effective, String allergenCode, String note, User user) {
        this.name = name;
        this.reaction = reaction;
        this.allergyType = allergyType;
        this.firstObserved = firstObserved;
        this.provider = provider;
        this.treatment = treatment;
        this.effective = effective;
        this.allergenCode = allergenCode;
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

    public String getReaction() {
        return reaction;
    }

    public void setReaction(String reaction) {
        this.reaction = reaction;
    }

    public AllergyType getAllergyType() {
        return allergyType;
    }

    public void setAllergyType(AllergyType allergyType) {
        this.allergyType = allergyType;
    }

    public Timestamp getFirstObserved() {
        return firstObserved;
    }

    public void setFirstObserved(Timestamp firstObserved) {
        this.firstObserved = firstObserved;
    }

    public User getProvider() {
        return provider;
    }

    public void setProvider(User provider) {
        this.provider = provider;
    }

    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }

    public YesNo getEffective() {
        return effective;
    }

    public void setEffective(YesNo effective) {
        this.effective = effective;
    }

    public String getAllergenCode() {
        return allergenCode;
    }

    public void setAllergenCode(String allergenCode) {
        this.allergenCode = allergenCode;
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

