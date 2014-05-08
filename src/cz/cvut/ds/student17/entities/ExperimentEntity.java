package cz.cvut.ds.student17.entities;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by V on 7.5.2014.
 */
@Entity
@SequenceGenerator(name="seq_experiment",  sequenceName="seq_experiment", initialValue=1, allocationSize=5)
@Table(name = "experiment", schema = "public", catalog = "student_db13_17")
public class ExperimentEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_experiment")
    @Column(name = "id_exp", nullable = false, insertable = true, updatable = true)
    private int idExp;
    @Basic
    @Column(name = "title", nullable = false, insertable = true, updatable = true, length = 2147483647)
    private String title;
    @Basic
    @Column(name = "description", nullable = true, insertable = true, updatable = true, length = 2147483647)
    private String description;
    @Basic
    @Column(name = "budget", nullable = false, insertable = true, updatable = true)
    private int budget;
    @Basic
    @Column(name = "status", nullable = true, insertable = true, updatable = true, length = 50)
    private String status;
    @Basic
    @Column(name = "id_cust", nullable = false, insertable = true, updatable = true)
    private int idCust;
    @Basic
    @Column(name = "id_ft", nullable = false, insertable = true, updatable = true)
    private int idFt;
    @ManyToOne
    //@JoinColumn(name = "id_cust", referencedColumnName = "id_cust", nullable = false)
    @JoinColumn(name = "id_cust", referencedColumnName = "id_cust", nullable = false, insertable =  false, updatable = false)
    private CustomerEntity customerByIdCust;
    @ManyToOne
    //@JoinColumn(name = "id_ft", referencedColumnName = "id_ft", nullable = false)
    @JoinColumn(name = "id_ft", referencedColumnName = "id_ft", nullable = false, insertable =  false, updatable = false)
    private FormtypEntity formtypByIdFt;
    @OneToMany(mappedBy = "experimentByIdExp")
    private Collection<FeatExpEntity> featExpsByIdExp;

    public int getIdExp() {
        return idExp;
    }

    public void setIdExp(int idExp) {
        this.idExp = idExp;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getIdCust() {
        return idCust;
    }

    public void setIdCust(int idCust) {
        this.idCust = idCust;
    }

    public int getIdFt() {
        return idFt;
    }

    public void setIdFt(int idFt) {
        this.idFt = idFt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ExperimentEntity that = (ExperimentEntity) o;

        if (budget != that.budget) return false;
        if (idCust != that.idCust) return false;
        if (idExp != that.idExp) return false;
        if (idFt != that.idFt) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idExp;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + budget;
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + idCust;
        result = 31 * result + idFt;
        return result;
    }

    public CustomerEntity getCustomerByIdCust() {
        return customerByIdCust;
    }

    public void setCustomerByIdCust(CustomerEntity customerByIdCust) {
        this.customerByIdCust = customerByIdCust;
    }

    public FormtypEntity getFormtypByIdFt() {
        return formtypByIdFt;
    }

    public void setFormtypByIdFt(FormtypEntity formtypByIdFt) {
        this.formtypByIdFt = formtypByIdFt;
    }

    public Collection<FeatExpEntity> getFeatExpsByIdExp() {
        return featExpsByIdExp;
    }

    public void setFeatExpsByIdExp(Collection<FeatExpEntity> featExpsByIdExp) {
        this.featExpsByIdExp = featExpsByIdExp;
    }
}
