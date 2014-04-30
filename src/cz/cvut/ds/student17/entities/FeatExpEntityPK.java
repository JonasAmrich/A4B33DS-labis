package cz.cvut.ds.student17.entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by jonasamrich on 30/04/14.
 */
public class FeatExpEntityPK implements Serializable {
    private int idExp;
    private int idFeat;

    @Column(name = "id_exp")
    @Id
    public int getIdExp() {
        return idExp;
    }

    public void setIdExp(int idExp) {
        this.idExp = idExp;
    }

    @Column(name = "id_feat")
    @Id
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

        FeatExpEntityPK that = (FeatExpEntityPK) o;

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
