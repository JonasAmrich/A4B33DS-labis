package cz.cvut.ds.student17.entities;

import javax.persistence.*;

/**
 * Created by jonasamrich on 30/04/14.
 */
@Entity
@Table(name = "feat_exp", schema = "public", catalog = "student_db13_17")
@IdClass(FeatExpEntityPK.class)
public class FeatExpEntity {
    private int idExp;
    private int idFeat;
    private ExperimentEntity experimentByIdExp;
    private FeatureEntity featureByIdFeat;

    @Id
    @Column(name = "id_exp")
    public int getIdExp() {
        return idExp;
    }

    public void setIdExp(int idExp) {
        this.idExp = idExp;
    }

    @Id
    @Column(name = "id_feat")
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

    @ManyToOne
    @JoinColumn(name = "id_exp", referencedColumnName = "id_exp", nullable = false)
    public ExperimentEntity getExperimentByIdExp() {
        return experimentByIdExp;
    }

    public void setExperimentByIdExp(ExperimentEntity experimentByIdExp) {
        this.experimentByIdExp = experimentByIdExp;
    }

    @ManyToOne
    @JoinColumn(name = "id_feat", referencedColumnName = "id_feat", nullable = false)
    public FeatureEntity getFeatureByIdFeat() {
        return featureByIdFeat;
    }

    public void setFeatureByIdFeat(FeatureEntity featureByIdFeat) {
        this.featureByIdFeat = featureByIdFeat;
    }
}
