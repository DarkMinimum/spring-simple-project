package ua.darkminimum.entities;

import javax.persistence.*;
import java.io.Serializable;


/**
 * States to Company entity
 */
@Entity(name="COMPANY")
public class Company implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_CO")
    @SequenceGenerator(name="SEQ_CO", sequenceName="SEQ_CO", allocationSize = 1)
    private Long pk;
    private String name;
    private String contactPhone;
    private String email;

    public Long getPk() {
        return pk;
    }

    public void setPk(Long pk) {
        this.pk = pk;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
