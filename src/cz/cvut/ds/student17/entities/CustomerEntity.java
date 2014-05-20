package cz.cvut.ds.student17.entities;

import javax.persistence.*;

/**
 * Created by V on 21.5.2014.
 */
@Entity
@SequenceGenerator(name="seq_is1_customer",  sequenceName="seq_is1_customer", initialValue=1, allocationSize=5)
@Table(name = "is1_customer", schema = "public", catalog = "student_db13_17")
public class CustomerEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_is1_customer")
    @Column(name = "id_cust", nullable = false, insertable = true, updatable = true)
    private int idCust;
    @Basic
    @Column(name = "last_name", nullable = false, insertable = true, updatable = true, length = 2147483647)
    private String lastName;
    @Basic
    @Column(name = "first_name", nullable = true, insertable = true, updatable = true, length = 2147483647)
    private String firstName;
    @Basic
    @Column(name = "email", nullable = true, insertable = true, updatable = true, length = 2147483647)
    private String email;
    @Basic
    @Column(name = "phone", nullable = true, insertable = true, updatable = true, length = 2147483647)
    private String phone;

    public int getIdCust() {
        return idCust;
    }

    public void setIdCust(int idCust) {
        this.idCust = idCust;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
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
        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
        if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;
        if (phone != null ? !phone.equals(that.phone) : that.phone != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idCust;
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        return result;
    }
}
