package cz.cvut.ds.student17.entities;

import javax.persistence.*;

/**
 * Created by V on 7.5.2014.
 */
@Entity
@Table(name = "feat_exp", schema = "public", catalog = "student_db13_17")
@IdClass(FeatExpEntityPK.class)
public class FeatExpEntity {
    @Id
    //@Column(name = "id_exp", nullable = false, insertable = true, updatable = true)
    @Column(name = "id_exp", nullable = false, insertable = true, updatable = false)
    private int idExp;
    @Id
    @Column(name = "id_feat", nullable = false, insertable = true, updatable = true)
    private int idFeat;
    @ManyToOne
    //@JoinColumn(name = "id_exp", referencedColumnName = "id_exp", nullable = false)
    @JoinColumn(name = "id_exp", referencedColumnName = "id_exp", nullable = false,insertable =  false, updatable = false)
    private ExperimentEntity experimentByIdExp;
    @ManyToOne
    //@JoinColumn(name = "id_feat", referencedColumnName = "id_feat", nullable = false)
    @JoinColumn(name = "id_feat", referencedColumnName = "id_feat", nullable = false,insertable =  false, updatable = false)
    private FeatureEntity featureByIdFeat;

    public int getIdExp() {
        return idExp;
    }

    public void setIdExp(int idExp) {
        this.idExp = idExp;
    }

    public int getIdFeat() {
        return idFeat;
    }

    public void setIdFeat(int idFeat) {
        this.idFeat = idFeat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FeatExpEntity that = (FeatExpEntity) o;

        if (idExp != that.idExp) return false;
        if (idFeat != that.idFeat) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idExp;
        result = 31 * result + idFeat;
        return result;
    }

    public ExperimentEntity getExperimentByIdExp() {
        return experimentByIdExp;
    }

    public void setExperimentByIdExp(ExperimentEntity experimentByIdExp) {
        this.experimentByIdExp = experimentByIdExp;
    }

    public FeatureEntity getFeatureByIdFeat() {
        return featureByIdFeat;
    }

    public void setFeatureByIdFeat(FeatureEntity featureByIdFeat) {
        this.featureByIdFeat = featureByIdFeat;
    }
}
