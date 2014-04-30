package cz.cvut.ds.student17.entities;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by jonasamrich on 30/04/14.
 */
@Entity
@Table(name = "experiment", schema = "public", catalog = "student_db13_17")
@NamedQueries({
    @NamedQuery(name = "getAllExperiments", query = "SELECT OBJECT(exp) FROM ExperimentEntity exp"),
    @NamedQuery(name = "countExperiments", query = "SELECT COUNT(exp) FROM ExperimentEntity exp")
})
public class ExperimentEntity {
    private int idExp;
    private String title;
    private String description;
    private int budget;
    private String status;
    private int idCust;
    private int idFt;
    private CustomerEntity customerByIdCust;
    private FormtypEntity formtypByIdFt;
    private Collection<FeatExpEntity> featExpsByIdExp;

    @Id
    @Column(name = "id_exp")
    public int getIdExp() {
        return idExp;
    }

    public void setIdExp(int idExp) {
        this.idExp = idExp;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "budget")
    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    @Basic
    @Column(name = "status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Basic
    @Column(name = "id_cust")
    public int getIdCust() {
        return idCust;
    }

    public void setIdCust(int idCust) {
        this.idCust = idCust;
    }

    @Basic
    @Column(name = "id_ft")
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

    @ManyToOne
    @JoinColumn(name = "id_cust", referencedColumnName = "id_cust", nullable = false)
    public CustomerEntity getCustomerByIdCust() {
        return customerByIdCust;
    }

    public void setCustomerByIdCust(CustomerEntity customerByIdCust) {
        this.customerByIdCust = customerByIdCust;
    }

    @ManyToOne
    @JoinColumn(name = "id_ft", referencedColumnName = "id_ft", nullable = false)
    public FormtypEntity getFormtypByIdFt() {
        return formtypByIdFt;
    }

    public void setFormtypByIdFt(FormtypEntity formtypByIdFt) {
        this.formtypByIdFt = formtypByIdFt;
    }

    @OneToMany(mappedBy = "experimentByIdExp")
    public Collection<FeatExpEntity> getFeatExpsByIdExp() {
        return featExpsByIdExp;
    }

    public void setFeatExpsByIdExp(Collection<FeatExpEntity> featExpsByIdExp) {
        this.featExpsByIdExp = featExpsByIdExp;
    }


}
