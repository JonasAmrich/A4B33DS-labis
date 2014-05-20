package cz.cvut.ds.student17.entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by V on 21.5.2014.
 */
public class FeatureExperimentEntityPK implements Serializable {
    @Column(name = "id_exp", nullable = false, insertable = true, updatable = true)
    @Id
    private int idExp;
    @Column(name = "id_feat", nullable = false, insertable = true, updatable = true)
    @Id
    private int idFeat;

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

        FeatureExperimentEntityPK that = (FeatureExperimentEntityPK) o;

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
}
