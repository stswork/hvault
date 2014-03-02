package models.fitness;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import play.db.ebean.Model;

import javax.persistence.*;

/**
 * Created by Sagar Gopale on 3/2/14.
 */
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Nutrition extends Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private Double carbohydrates;

    private Double proteins;

    private Double totalFat;

    private Double saturatedFat;

    private Double monounsaturatedFat;

    private Double polyunsaturatedFat;

    private Double transFat;

    private Double sugar;

    private Double dietaryFiber;

    private Double cholesterol;

    private Double sodium;

    private Double calcium;

    private Double iron;

    private Double magnesium;

    private Double phosphorus;

    private Double potassium;

    private Double zinc;

    private Double vitamin_a_rae;

    private Double vitamin_b6;

    private Double vitamin_b12;

    private Double vitamin_c;

    private Double vitamin_d;

    private Double vitamin_e;

    private Double vitamin_k;

    private Double niacin;

    private Double riboflavin;

    private Double thiamin;

    private Double folate_dfe;

    public Nutrition() {
    }

    public Nutrition(Double carbohydrates, Double proteins, Double totalFat, Double saturatedFat, Double monounsaturatedFat, Double polyunsaturatedFat, Double transFat, Double sugar, Double dietaryFiber, Double cholesterol, Double sodium, Double calcium, Double iron, Double magnesium, Double phosphorus, Double potassium, Double zinc, Double vitamin_a_rae, Double vitamin_b6, Double vitamin_b12, Double vitamin_c, Double vitamin_d, Double vitamin_e, Double vitamin_k, Double niacin, Double riboflavin, Double thiamin, Double folate_dfe) {
        this.carbohydrates = carbohydrates;
        this.proteins = proteins;
        this.totalFat = totalFat;
        this.saturatedFat = saturatedFat;
        this.monounsaturatedFat = monounsaturatedFat;
        this.polyunsaturatedFat = polyunsaturatedFat;
        this.transFat = transFat;
        this.sugar = sugar;
        this.dietaryFiber = dietaryFiber;
        this.cholesterol = cholesterol;
        this.sodium = sodium;
        this.calcium = calcium;
        this.iron = iron;
        this.magnesium = magnesium;
        this.phosphorus = phosphorus;
        this.potassium = potassium;
        this.zinc = zinc;
        this.vitamin_a_rae = vitamin_a_rae;
        this.vitamin_b6 = vitamin_b6;
        this.vitamin_b12 = vitamin_b12;
        this.vitamin_c = vitamin_c;
        this.vitamin_d = vitamin_d;
        this.vitamin_e = vitamin_e;
        this.vitamin_k = vitamin_k;
        this.niacin = niacin;
        this.riboflavin = riboflavin;
        this.thiamin = thiamin;
        this.folate_dfe = folate_dfe;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getCarbohydrates() {
        return carbohydrates;
    }

    public void setCarbohydrates(Double carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    public Double getProteins() {
        return proteins;
    }

    public void setProteins(Double proteins) {
        this.proteins = proteins;
    }

    public Double getTotalFat() {
        return totalFat;
    }

    public void setTotalFat(Double totalFat) {
        this.totalFat = totalFat;
    }

    public Double getSaturatedFat() {
        return saturatedFat;
    }

    public void setSaturatedFat(Double saturatedFat) {
        this.saturatedFat = saturatedFat;
    }

    public Double getMonounsaturatedFat() {
        return monounsaturatedFat;
    }

    public void setMonounsaturatedFat(Double monounsaturatedFat) {
        this.monounsaturatedFat = monounsaturatedFat;
    }

    public Double getPolyunsaturatedFat() {
        return polyunsaturatedFat;
    }

    public void setPolyunsaturatedFat(Double polyunsaturatedFat) {
        this.polyunsaturatedFat = polyunsaturatedFat;
    }

    public Double getTransFat() {
        return transFat;
    }

    public void setTransFat(Double transFat) {
        this.transFat = transFat;
    }

    public Double getSugar() {
        return sugar;
    }

    public void setSugar(Double sugar) {
        this.sugar = sugar;
    }

    public Double getDietaryFiber() {
        return dietaryFiber;
    }

    public void setDietaryFiber(Double dietaryFiber) {
        this.dietaryFiber = dietaryFiber;
    }

    public Double getCholesterol() {
        return cholesterol;
    }

    public void setCholesterol(Double cholesterol) {
        this.cholesterol = cholesterol;
    }

    public Double getSodium() {
        return sodium;
    }

    public void setSodium(Double sodium) {
        this.sodium = sodium;
    }

    public Double getCalcium() {
        return calcium;
    }

    public void setCalcium(Double calcium) {
        this.calcium = calcium;
    }

    public Double getIron() {
        return iron;
    }

    public void setIron(Double iron) {
        this.iron = iron;
    }

    public Double getMagnesium() {
        return magnesium;
    }

    public void setMagnesium(Double magnesium) {
        this.magnesium = magnesium;
    }

    public Double getPhosphorus() {
        return phosphorus;
    }

    public void setPhosphorus(Double phosphorus) {
        this.phosphorus = phosphorus;
    }

    public Double getPotassium() {
        return potassium;
    }

    public void setPotassium(Double potassium) {
        this.potassium = potassium;
    }

    public Double getZinc() {
        return zinc;
    }

    public void setZinc(Double zinc) {
        this.zinc = zinc;
    }

    public Double getVitamin_a_rae() {
        return vitamin_a_rae;
    }

    public void setVitamin_a_rae(Double vitamin_a_rae) {
        this.vitamin_a_rae = vitamin_a_rae;
    }

    public Double getVitamin_b6() {
        return vitamin_b6;
    }

    public void setVitamin_b6(Double vitamin_b6) {
        this.vitamin_b6 = vitamin_b6;
    }

    public Double getVitamin_b12() {
        return vitamin_b12;
    }

    public void setVitamin_b12(Double vitamin_b12) {
        this.vitamin_b12 = vitamin_b12;
    }

    public Double getVitamin_c() {
        return vitamin_c;
    }

    public void setVitamin_c(Double vitamin_c) {
        this.vitamin_c = vitamin_c;
    }

    public Double getVitamin_d() {
        return vitamin_d;
    }

    public void setVitamin_d(Double vitamin_d) {
        this.vitamin_d = vitamin_d;
    }

    public Double getVitamin_e() {
        return vitamin_e;
    }

    public void setVitamin_e(Double vitamin_e) {
        this.vitamin_e = vitamin_e;
    }

    public Double getVitamin_k() {
        return vitamin_k;
    }

    public void setVitamin_k(Double vitamin_k) {
        this.vitamin_k = vitamin_k;
    }

    public Double getNiacin() {
        return niacin;
    }

    public void setNiacin(Double niacin) {
        this.niacin = niacin;
    }

    public Double getRiboflavin() {
        return riboflavin;
    }

    public void setRiboflavin(Double riboflavin) {
        this.riboflavin = riboflavin;
    }

    public Double getThiamin() {
        return thiamin;
    }

    public void setThiamin(Double thiamin) {
        this.thiamin = thiamin;
    }

    public Double getFolate_dfe() {
        return folate_dfe;
    }

    public void setFolate_dfe(Double folate_dfe) {
        this.folate_dfe = folate_dfe;
    }
}
