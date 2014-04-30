package cz.cvut.ds.student17.entities;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * Created by jonasamrich on 30/04/14.
 */
@Entity
@Table(name = "victim", schema = "public", catalog = "student_db13_17")
public class VictimEntity {
    private int idVic;
    private String name;
    private String email;
    private String phone;
    private Timestamp birthDate;
    private int credits;
    private Collection<TrialEntity> trialsByIdVic;

    @Id
    @Column(name = "id_vic")
    public int getIdVic() {
        return idVic;
    }

    public void setIdVic(int idVic) {
        this.idVic = idVic;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "birth_date")
    public Timestamp getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Timestamp birthDate) {
        this.birthDate = birthDate;
    }

    @Basic
    @Column(name = "credits")
    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VictimEntity that = (VictimEntity) o;

        if (credits != that.credits) return false;
        if (idVic != that.idVic) return false;
        if (birthDate != null ? !birthDate.equals(that.birthDate) : that.birthDate != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (phone != null ? !phone.equals(that.phone) : that.phone != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idVic;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (birthDate != null ? birthDate.hashCode() : 0);
        result = 31 * result + credits;
        return result;
    }

    @OneToMany(mappedBy = "victimByIdVic")
    public Collection<TrialEntity> getTrialsByIdVic() {
        return trialsByIdVic;
    }

    public void setTrialsByIdVic(Collection<TrialEntity> trialsByIdVic) {
        this.trialsByIdVic = trialsByIdVic;
    }
}
