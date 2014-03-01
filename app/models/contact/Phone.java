package models.contact;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import play.db.ebean.Model;

import javax.persistence.*;

/**
 * Created by Sagar Gopale on 2/26/14.
 */
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Phone extends Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
}
