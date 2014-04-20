package models.history;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import models.conditions.Condition;
import models.user.User;
import org.joda.time.DateTime;
import play.data.format.Formats;
import play.db.ebean.Model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sagar Gopale on 3/1/14.
 */
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class FamilyHistory extends Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    private List<Condition> conditionList = new ArrayList<Condition>();

    @OneToOne
    private User relative;

    @ManyToOne
    private User user;

    @Formats.DateTime(pattern = "MM/dd/yy")
    public Timestamp created = new Timestamp(DateTime.now().toDate().getTime());

    public FamilyHistory() {
    }

    public FamilyHistory(List<Condition> conditionList, User relative, User user) {
        this.conditionList = conditionList;
        this.relative = relative;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Condition> getConditionList() {
        return conditionList;
    }

    public void setConditionList(List<Condition> conditionList) {
        this.conditionList = conditionList;
    }

    public User getRelative() {
        return relative;
    }

    public void setRelative(User relative) {
        this.relative = relative;
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
