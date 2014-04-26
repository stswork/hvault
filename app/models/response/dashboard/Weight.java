package models.response.dashboard;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by Sagar Gopale on 4/26/14.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Weight {

    public Long id;
    public Long userId;
    public int pounds;
    public int ounces;
    public String note;
    public String created;

    public Weight() {
    }

    public Weight(Long id, Long userId, int pounds, int ounces, String note, String created) {
        this.id = id;
        this.userId = userId;
        this.pounds = pounds;
        this.ounces = ounces;
        this.note = note;
        this.created = created;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public int getPounds() {
        return pounds;
    }

    public void setPounds(int pounds) {
        this.pounds = pounds;
    }

    public int getOunces() {
        return ounces;
    }

    public void setOunces(int ounces) {
        this.ounces = ounces;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }
}
