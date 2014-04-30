package cz.cvut.ds.student17.entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by jonasamrich on 30/04/14.
 */
public class ResultsEntityPK implements Serializable {
    private int idTrial;
    private int idFs;

    @Column(name = "id_trial")
    @Id
    public int getIdTrial() {
        return idTrial;
    }

    public void setIdTrial(int idTrial) {
        this.idTrial = idTrial;
    }

    @Column(name = "id_fs")
    @Id
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
