package cz.cvut.ds.student17.entities;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by V on 7.5.2014.
 */
@Entity
@SequenceGenerator(name="seq_customer",  sequenceName="seq_customer", initialValue=1, allocationSize=100)
@Table(name = "customer", schema = "public", catalog = "student_db13_17")
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_customer")
    @Column(name = "id_cust", nullable = false, insertable = true, updatable = true)
    private int idCust;
    @Basic
    @Column(name = "name", nullable = false, insertable = true, updatable = true, length = 2147483647)
    private String name;
    @Basic
    @Column(name = "email", nullable = true, insertable = true, updatable = true, length = 2147483647)
    private String email;
    @Basic
    @Column(name = "phone", nullable = true, insertable = true, updatable = true, length = 2147483647)
    private String phone;
    @OneToMany(mappedBy = "customerByIdCust")
    private Collection<ExperimentEntity> experimentsByIdCust;

    public int getIdCust() {
        return idCust;
    }

    public void setIdCust(int idCust) {
        this.idCust = idCust;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustomerEntity that = (CustomerEntity) o;

        if (idCust != that.idCust) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (phone != null ? !phone.equals(that.phone) : that.phone != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idCust;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        return result;
    }

    public Collection<ExperimentEntity> getExperimentsByIdCust() {
        return experimentsByIdCust;
    }

    public void setExperimentsByIdCust(Collection<ExperimentEntity> experimentsByIdCust) {
        this.experimentsByIdCust = experimentsByIdCust;
    }
}
