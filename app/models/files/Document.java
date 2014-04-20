package models.files;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import models.user.User;
import org.joda.time.DateTime;
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
public class Document extends Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;


    @Constraints.Required
    private String filePath;

    private String description;

    @ManyToOne
    private User user;

    @Formats.DateTime(pattern = "MM/dd/yy")
    public Timestamp created = new Timestamp(DateTime.now().toDate().getTime());

    public Document() {
    }

    public Document(String filePath, String description, User user) {
        this.filePath = filePath;
        this.description = description;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
