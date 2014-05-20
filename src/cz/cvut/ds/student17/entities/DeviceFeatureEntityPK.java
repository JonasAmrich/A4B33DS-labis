package cz.cvut.ds.student17.entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by V on 21.5.2014.
 */
public class DeviceFeatureEntityPK implements Serializable {
    @Column(name = "id_dev", nullable = false, insertable = true, updatable = true)
    @Id
    private int idDev;
    @Column(name = "id_feat", nullable = false, insertable = true, updatable = true)
    @Id
    private int idFeat;

    public int getIdDev() {
        return idDev;
    }

    public void setIdDev(int idDev) {
        this.idDev = idDev;
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

        DeviceFeatureEntityPK that = (DeviceFeatureEntityPK) o;

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
