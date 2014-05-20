package cz.cvut.ds.student17.entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by V on 21.5.2014.
 */
public class ResultsEntityPK implements Serializable {
    @Column(name = "id_trial", nullable = false, insertable = true, updatable = true)
    @Id
    private int idTrial;
    @Column(name = "id_fs", nullable = false, insertable = true, updatable = true)
    @Id
    private int idFs;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ResultsEntityPK that = (ResultsEntityPK) o;

        if (idFs != that.idFs) return false;
        if (idTrial != that.idTrial) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idTrial;
        result = 31 * result + idFs;
        return result;
    }
}
