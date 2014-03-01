package models.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import models.conditions.Allergy;
import models.conditions.Condition;
import models.conditions.MedicalDevice;
import models.contact.Address;
import models.contact.Email;
import models.contact.Phone;
import models.files.CCD;
import models.files.CCR;
import models.files.Document;
import models.fitness.DietaryIntake;
import models.fitness.Excercise;
import models.history.Appointment;
import models.history.FamilyHistory;
import models.history.Immunization;
import models.history.Procedure;
import models.measurements.*;
import models.medications.Medication;
import models.relationship.Relationship;
import play.data.format.Formats;
import play.db.ebean.Model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sagar Gopale on 2/26/14.
 */
@Entity
@Table(name="o_user")
@JsonIgnoreProperties(ignoreUnknown = true)
public class User extends Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String profileImageUrl;

    private String firstName;

    private String middleName;

    private String lastName;

    private String nickName;

    private Relationship relationshipToPrimary;

    @Formats.DateTime(pattern = "MM/dd/yy")
    private Timestamp dateOfBirth = null;

    private Gender gender;

    @OneToMany
    private List<Address> addressList = new ArrayList<Address>();

    private UserType userType;

    @OneToMany
    private List<Email> emailList = new ArrayList<Email>();

    @OneToMany
    private List<Phone> phoneList = new ArrayList<Phone>();

    private String speciality;

    private String placeOfBuisness;

    private Region regionOfOrigin;

    private Timestamp dateOfDeath;

    private BloodType bloodType;

    private String ethnicity;

    private String language;

    @OneToMany
    private List<Allergy> allergyList = new ArrayList<Allergy>();

    @OneToMany
    private List<Condition> conditionList = new ArrayList<Condition>();

    @OneToMany
    private List<MedicalDevice> medicalDeviceList = new ArrayList<MedicalDevice>();

    @OneToMany
    private List<CCD> ccdList = new ArrayList<CCD>();

    @OneToMany
    private List<CCR> ccrList = new ArrayList<CCR>();

    @OneToMany
    private List<Document> documentList = new ArrayList<Document>();

    @OneToMany
    private List<DietaryIntake> dietaryIntakeList = new ArrayList<DietaryIntake>();

    @OneToMany
    private List<Excercise> excerciseList = new ArrayList<Excercise>();

    @OneToMany
    private List<Appointment> appointmentList = new ArrayList<Appointment>();

    @OneToMany
    private List<FamilyHistory> familyHistoryList = new ArrayList<FamilyHistory>();

    @OneToMany
    private List<Immunization> immunizationList = new ArrayList<Immunization>();

    @OneToMany
    private List<Procedure> procedureList = new ArrayList<Procedure>();

    @OneToMany
    private List<BloodGlucose> bloodGlucoseList = new ArrayList<BloodGlucose>();

    @OneToMany
    private List<BloodPressure> bloodPressureList = new ArrayList<BloodPressure>();

    @OneToMany
    private List<Cholesterol> cholesterolList = new ArrayList<Cholesterol>();

    @OneToMany
    private List<Height> heightList = new ArrayList<Height>();

    @OneToMany
    private List<PeakFlow> peakFlowList = new ArrayList<PeakFlow>();

    @OneToMany
    private List<Weight> weightList = new ArrayList<Weight>();

    @OneToMany
    private List<Medication> medicationList = new ArrayList<Medication>();

    public User() {
    }

    public User(String profileImageUrl, String firstName, String middleName, String lastName, String nickName, Relationship relationshipToPrimary, Timestamp dateOfBirth, Gender gender, UserType userType, String speciality, String placeOfBuisness, Region regionOfOrigin, Timestamp dateOfDeath, BloodType bloodType, String ethnicity, String language) {
        this.profileImageUrl = profileImageUrl;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.nickName = nickName;
        this.relationshipToPrimary = relationshipToPrimary;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.userType = userType;
        this.speciality = speciality;
        this.placeOfBuisness = placeOfBuisness;
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
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

    public String getPlaceOfBuisness() {
        return placeOfBuisness;
    }

    public void setPlaceOfBuisness(String placeOfBuisness) {
        this.placeOfBuisness = placeOfBuisness;
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

    public List<Allergy> getAllergyList() {
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

    public List<Excercise> getExcerciseList() {
        return excerciseList;
    }

    public void setExcerciseList(List<Excercise> excerciseList) {
        this.excerciseList = excerciseList;
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
    }
}
