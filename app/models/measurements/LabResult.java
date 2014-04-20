package models.measurements;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
public class LabResult extends Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Formats.DateTime(pattern = "MM/dd/yy")
    public Timestamp created = new Timestamp(DateTime.now().toDate().getTime());

}
