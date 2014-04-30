package cz.cvut.ds.student17.entities;

import javax.persistence.*;

/**
 * Created by jonasamrich on 30/04/14.
 */
@Entity
@Table(name = "results", schema = "public", catalog = "student_db13_17")
@IdClass(ResultsEntityPK.class)
public class ResultsEntity {
    private int idTrial;
    private int idFs;
    private String resValue;
    private FormstructEntity formstructByIdFs;
    private TrialEntity trialByIdTrial;

    @Id
    @Column(name = "id_trial")
    public int getIdTrial() {
        return idTrial;
    }

    public void setIdTrial(int idTrial) {
        this.idTrial = idTrial;
    }

    @Id
    @Column(name = "id_fs")
    public int getIdFs() {
        return idFs;
    }

    public void setIdFs(int idFs) {
        this.idFs = idFs;
    }

    @Basic
    @Column(name = "res_value")
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

    @ManyToOne
    @JoinColumn(name = "id_fs", referencedColumnName = "id_fs", nullable = false)
    public FormstructEntity getFormstructByIdFs() {
        return formstructByIdFs;
    }

    public void setFormstructByIdFs(FormstructEntity formstructByIdFs) {
        this.formstructByIdFs = formstructByIdFs;
    }

    @ManyToOne
    @JoinColumn(name = "id_trial", referencedColumnName = "id_trial", nullable = false)
    public TrialEntity getTrialByIdTrial() {
        return trialByIdTrial;
    }

    public void setTrialByIdTrial(TrialEntity trialByIdTrial) {
        this.trialByIdTrial = trialByIdTrial;
    }
}
