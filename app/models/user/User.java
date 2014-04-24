package models.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import models.contact.Address;
import models.contact.Email;
import models.contact.Phone;
import models.relationship.Relationship;
import org.joda.time.DateTime;
import play.data.format.Formats;
import play.db.ebean.Model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sagar Gopale on 2/26/14.
 */
@Table(name="o_user")
@SequenceGenerator(name = "o_user_seq", sequenceName = "o_user_seq", initialValue = 1000)
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
public class User extends Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String profileImageUrl;

    private String fullName;

    private String email;

    private String password;

    private Relationship relationshipToPrimary;

    @Formats.DateTime(pattern = "MM/dd/yy")
    private Timestamp dateOfBirth = null;

    private Gender gender;

    @OneToMany(mappedBy = "user")
    private List<Address> addressList = new ArrayList<Address>();

    private UserType userType;

    @OneToMany(mappedBy = "user")
    private List<Email> emailList = new ArrayList<Email>();

    @OneToMany(mappedBy = "user")
    private List<Phone> phoneList = new ArrayList<Phone>();

    private String speciality;

    private String placeOfBusiness;

    private Region regionOfOrigin;

    private Timestamp dateOfDeath;

    private BloodType bloodType;

    private String ethnicity;

    private String language;

    /*@OneToMany(mappedBy = "user")
    private List<Allergy> allergyList = new ArrayList<Allergy>();

    @OneToMany(mappedBy = "user")
    private List<Condition> conditionList = new ArrayList<Condition>();

    @OneToMany(mappedBy = "user")
    private List<MedicalDevice> medicalDeviceList = new ArrayList<MedicalDevice>();

    @OneToMany(mappedBy = "user")
    private List<CCD> ccdList = new ArrayList<CCD>();

    @OneToMany(mappedBy = "user")
    private List<CCR> ccrList = new ArrayList<CCR>();

    @OneToMany(mappedBy = "user")
    private List<Document> documentList = new ArrayList<Document>();

    @OneToMany(mappedBy = "user")
    private List<DietaryIntake> dietaryIntakeList = new ArrayList<DietaryIntake>();

    @OneToMany(mappedBy = "user")
    private List<Exercise> exerciseList = new ArrayList<Exercise>();

    @OneToMany(mappedBy = "user")
    private List<Appointment> appointmentList = new ArrayList<Appointment>();

    @OneToMany(mappedBy = "user")
    private List<FamilyHistory> familyHistoryList = new ArrayList<FamilyHistory>();

    @OneToMany(mappedBy = "user")
    private List<Immunization> immunizationList = new ArrayList<Immunization>();

    @OneToMany(mappedBy = "user")
    private List<Procedure> procedureList = new ArrayList<Procedure>();

    @OneToMany(mappedBy = "user")
    private List<BloodGlucose> bloodGlucoseList = new ArrayList<BloodGlucose>();

    @OneToMany(mappedBy = "user")
    private List<BloodPressure> bloodPressureList = new ArrayList<BloodPressure>();

    @OneToMany(mappedBy = "user")
    private List<Cholesterol> cholesterolList = new ArrayList<Cholesterol>();

    @OneToMany(mappedBy = "user")
    private List<Height> heightList = new ArrayList<Height>();

    @OneToMany(mappedBy = "user")
    private List<PeakFlow> peakFlowList = new ArrayList<PeakFlow>();

    @OneToMany(mappedBy = "user")
    private List<Weight> weightList = new ArrayList<Weight>();

    @OneToMany(mappedBy = "user")
    private List<Medication> medicationList = new ArrayList<Medication>();*/

    @Formats.DateTime(pattern = "MM/dd/yy")
    public Timestamp created = new Timestamp(DateTime.now().toDate().getTime());

    public User() {
    }

    public User(String profileImageUrl, String fullName, String email, String password, Relationship relationshipToPrimary, Timestamp dateOfBirth, Gender gender, UserType userType, String speciality, String placeOfBusiness, Region regionOfOrigin, Timestamp dateOfDeath, BloodType bloodType, String ethnicity, String language) {
        this.profileImageUrl = profileImageUrl;
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.relationshipToPrimary = relationshipToPrimary;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.userType = userType;
        this.speciality = speciality;
        this.placeOfBusiness = placeOfBusiness;
        this.regionOfOrigin = regionOfOrigin;
        this.dateOfDeath = dateOfDeath;
        this.bloodType = bloodType;
        this.ethnicity = ethnicity;
        this.language = language;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    public void setProfileImageUrl(String profileImageUrl) {
        this.profileImageUrl = profileImageUrl;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Relationship getRelationshipToPrimary() {
        return relationshipToPrimary;
    }

    public void setRelationshipToPrimary(Relationship relationshipToPrimary) {
        this.relationshipToPrimary = relationshipToPrimary;
    }

    public Timestamp getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Timestamp dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public List<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public List<Email> getEmailList() {
        return emailList;
    }

    public void setEmailList(List<Email> emailList) {
        this.emailList = emailList;
    }

    public List<Phone> getPhoneList() {
        return phoneList;
    }

    public void setPhoneList(List<Phone> phoneList) {
        this.phoneList = phoneList;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getPlaceOfBusiness() {
        return placeOfBusiness;
    }

    public void setPlaceOfBusiness(String placeOfBusiness) {
        this.placeOfBusiness = placeOfBusiness;
    }

    public Region getRegionOfOrigin() {
        return regionOfOrigin;
    }

    public void setRegionOfOrigin(Region regionOfOrigin) {
        this.regionOfOrigin = regionOfOrigin;
    }

    public Timestamp getDateOfDeath() {
        return dateOfDeath;
    }

    public void setDateOfDeath(Timestamp dateOfDeath) {
        this.dateOfDeath = dateOfDeath;
    }

    public BloodType getBloodType() {
        return bloodType;
    }

    public void setBloodType(BloodType bloodType) {
        this.bloodType = bloodType;
    }

    public String getEthnicity() {
        return ethnicity;
    }

    public void setEthnicity(String ethnicity) {
        this.ethnicity = ethnicity;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    /*public List<Allergy> getAllergyList() {
        return allergyList;
    }

    public void setAllergyList(List<Allergy> allergyList) {
        this.allergyList = allergyList;
    }

    public List<Condition> getConditionList() {
        return conditionList;
    }

    public void setConditionList(List<Condition> conditionList) {
        this.conditionList = conditionList;
    }

    public List<MedicalDevice> getMedicalDeviceList() {
        return medicalDeviceList;
    }

    public void setMedicalDeviceList(List<MedicalDevice> medicalDeviceList) {
        this.medicalDeviceList = medicalDeviceList;
    }

    public List<CCD> getCcdList() {
        return ccdList;
    }

    public void setCcdList(List<CCD> ccdList) {
        this.ccdList = ccdList;
    }

    public List<CCR> getCcrList() {
        return ccrList;
    }

    public void setCcrList(List<CCR> ccrList) {
        this.ccrList = ccrList;
    }

    public List<Document> getDocumentList() {
        return documentList;
    }

    public void setDocumentList(List<Document> documentList) {
        this.documentList = documentList;
    }

    public List<DietaryIntake> getDietaryIntakeList() {
        return dietaryIntakeList;
    }

    public void setDietaryIntakeList(List<DietaryIntake> dietaryIntakeList) {
        this.dietaryIntakeList = dietaryIntakeList;
    }

    public List<Exercise> getExerciseList() {
        return exerciseList;
    }

    public void setExerciseList(List<Exercise> exerciseList) {
        this.exerciseList = exerciseList;
    }

    public List<Appointment> getAppointmentList() {
        return appointmentList;
    }

    public void setAppointmentList(List<Appointment> appointmentList) {
        this.appointmentList = appointmentList;
    }

    public List<FamilyHistory> getFamilyHistoryList() {
        return familyHistoryList;
    }

    public void setFamilyHistoryList(List<FamilyHistory> familyHistoryList) {
        this.familyHistoryList = familyHistoryList;
    }

    public List<Immunization> getImmunizationList() {
        return immunizationList;
    }

    public void setImmunizationList(List<Immunization> immunizationList) {
        this.immunizationList = immunizationList;
    }

    public List<Procedure> getProcedureList() {
        return procedureList;
    }

    public void setProcedureList(List<Procedure> procedureList) {
        this.procedureList = procedureList;
    }

    public List<BloodGlucose> getBloodGlucoseList() {
        return bloodGlucoseList;
    }

    public void setBloodGlucoseList(List<BloodGlucose> bloodGlucoseList) {
        this.bloodGlucoseList = bloodGlucoseList;
    }

    public List<BloodPressure> getBloodPressureList() {
        return bloodPressureList;
    }

    public void setBloodPressureList(List<BloodPressure> bloodPressureList) {
        this.bloodPressureList = bloodPressureList;
    }

    public List<Cholesterol> getCholesterolList() {
        return cholesterolList;
    }

    public void setCholesterolList(List<Cholesterol> cholesterolList) {
        this.cholesterolList = cholesterolList;
    }

    public List<Height> getHeightList() {
        return heightList;
    }

    public void setHeightList(List<Height> heightList) {
        this.heightList = heightList;
    }

    public List<PeakFlow> getPeakFlowList() {
        return peakFlowList;
    }

    public void setPeakFlowList(List<PeakFlow> peakFlowList) {
        this.peakFlowList = peakFlowList;
    }

    public List<Weight> getWeightList() {
        return weightList;
    }

    public void setWeightList(List<Weight> weightList) {
        this.weightList = weightList;
    }

    public List<Medication> getMedicationList() {
        return medicationList;
    }

    public void setMedicationList(List<Medication> medicationList) {
        this.medicationList = medicationList;
    }*/

    public static Finder<Long, User> find = new Finder<Long, User>(
            Long.class, User.class
    );

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }
}
