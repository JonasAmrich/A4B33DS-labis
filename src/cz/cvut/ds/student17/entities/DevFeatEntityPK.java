package cz.cvut.ds.student17.entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by jonasamrich on 30/04/14.
 */
public class DevFeatEntityPK implements Serializable {
    private int idDev;
    private int idFeat;

    @Column(name = "id_dev")
    @Id
    public int getIdDev() {
        return idDev;
    }

    public void setIdDev(int idDev) {
        this.idDev = idDev;
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

        DevFeatEntityPK that = (DevFeatEntityPK) o;

        if (idDev != that.idDev) return false;
        if (idFeat != that.idFeat) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idDev;
        result = 31 * result + idFeat;
        return result;
    }
}
