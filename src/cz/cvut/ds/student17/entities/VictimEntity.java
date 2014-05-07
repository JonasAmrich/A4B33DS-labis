package cz.cvut.ds.student17.entities;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * Created by V on 7.5.2014.
 */
@Entity
@Table(name = "victim", schema = "public", catalog = "student_db13_17")
public class VictimEntity {
    @Id
    @Column(name = "id_vic", nullable = false, insertable = true, updatable = true)
    private int idVic;
    @Basic
    @Column(name = "name", nullable = false, insertable = true, updatable = true, length = 2147483647)
    private String name;
    @Basic
    @Column(name = "email", nullable = true, insertable = true, updatable = true, length = 2147483647)
    private String email;
    @Basic
    @Column(name = "phone", nullable = true, insertable = true, updatable = true, length = 2147483647)
    private String phone;
    @Basic
    @Column(name = "birth_date", nullable = true, insertable = true, updatable = true)
    private Timestamp birthDate;
    @Basic
    @Column(name = "credits", nullable = false, insertable = true, updatable = true)
    private int credits;
    @OneToMany(mappedBy = "victimByIdVic")
    private Collection<TrialEntity> trialsByIdVic;

    public int getIdVic() {
        return idVic;
    }

    public void setIdVic(int idVic) {
        this.idVic = idVic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Timestamp getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Timestamp birthDate) {
        this.birthDate = birthDate;
    }

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

    public Collection<TrialEntity> getTrialsByIdVic() {
        return trialsByIdVic;
    }

    public void setTrialsByIdVic(Collection<TrialEntity> trialsByIdVic) {
        this.trialsByIdVic = trialsByIdVic;
    }
}
