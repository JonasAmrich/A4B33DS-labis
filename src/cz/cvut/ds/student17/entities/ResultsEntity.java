package cz.cvut.ds.student17.entities;

import javax.persistence.*;

/**
 * Created by V on 21.5.2014.
 */
@Entity
@Table(name = "is1_results", schema = "public", catalog = "student_db13_17")
@IdClass(ResultsEntityPK.class)
public class ResultsEntity {
    @Id
    @Column(name = "id_trial", nullable = false, insertable = true, updatable = true)
    private int idTrial;
    @Id
    @Column(name = "id_fs", nullable = false, insertable = true, updatable = true)
    private int idFs;
    @Basic
    @Column(name = "res_value", nullable = true, insertable = true, updatable = true, length = 2147483647)
    private String resValue;
    @ManyToOne
    @JoinColumn(name = "id_trial", referencedColumnName = "id_trial", nullable = false,insertable = false, updatable = false)
    private TrialEntity is1TrialByIdTrial;

    public int getIdTrial() {
        return idTrial;
    }

    public void setIdTrial(int idTrial) {
        this.idTrial = idTrial;
    }

    public int getIdFs() {
        return idFs;
    }

    public void setIdFs(int idFs) {
        this.idFs = idFs;
    }

    public String getResValue() {
        return resValue;
    }

    public void setResValue(String resValue) {
        this.resValue = resValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ResultsEntity that = (ResultsEntity) o;

        if (idFs != that.idFs) return false;
        if (idTrial != that.idTrial) return false;
        if (resValue != null ? !resValue.equals(that.resValue) : that.resValue != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idTrial;
        result = 31 * result + idFs;
        result = 31 * result + (resValue != null ? resValue.hashCode() : 0);
        return result;
    }

    public TrialEntity getIs1TrialByIdTrial() {
        return is1TrialByIdTrial;
    }

    public void setIs1TrialByIdTrial(TrialEntity is1TrialByIdTrial) {
        this.is1TrialByIdTrial = is1TrialByIdTrial;
    }
}
