package cz.cvut.ds.student17.entities;

import javax.persistence.*;

/**
 * Created by V on 21.5.2014.
 */
@Entity
@SequenceGenerator(name="seq_is1_experiment",  sequenceName="seq_is1_experiment", initialValue=1, allocationSize=5)
@Table(name = "is1_experiment", schema = "public", catalog = "student_db13_17")
public class ExperimentEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_is1_experiment")
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
    @ManyToOne
    @JoinColumn(name = "id_cust", referencedColumnName = "id_cust", nullable = false)
    private CustomerEntity is1CustomerByIdCust;
    @ManyToOne
    @JoinColumn(name = "status_code", referencedColumnName = "status_code",nullable = false, insertable =  false, updatable = false)
    private ExperimentStatusEntity is1ExperimentStatusByStatusCode;
    @ManyToOne
    @JoinColumn(name = "id_ft", referencedColumnName = "id_ft",nullable = false, insertable =  false, updatable = false)
    private FormTypeEntity is1FormTypeByIdFt;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ExperimentEntity that = (ExperimentEntity) o;

        if (budget != that.budget) return false;
        if (idExp != that.idExp) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idExp;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + budget;
        return result;
    }

    public CustomerEntity getIs1CustomerByIdCust() {
        return is1CustomerByIdCust;
    }

    public void setIs1CustomerByIdCust(CustomerEntity is1CustomerByIdCust) {
        this.is1CustomerByIdCust = is1CustomerByIdCust;
    }

    public ExperimentStatusEntity getIs1ExperimentStatusByStatusCode() {
        return is1ExperimentStatusByStatusCode;
    }

    public void setIs1ExperimentStatusByStatusCode(ExperimentStatusEntity is1ExperimentStatusByStatusCode) {
        this.is1ExperimentStatusByStatusCode = is1ExperimentStatusByStatusCode;
    }

    public FormTypeEntity getIs1FormTypeByIdFt() {
        return is1FormTypeByIdFt;
    }

    public void setIs1FormTypeByIdFt(FormTypeEntity is1FormTypeByIdFt) {
        this.is1FormTypeByIdFt = is1FormTypeByIdFt;
    }
}
