package models.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import play.db.ebean.Model;

import javax.persistence.*;

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
    public Long id;


}
