package cz.cvut.ds.student17.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by V on 21.5.2014.
 */
@Entity
@Table(name = "is1_experiment_status", schema = "public", catalog = "student_db13_17")
public class ExperimentStatusEntity {
    @Id
    @Column(name = "status_code", nullable = false, insertable = true, updatable = true, length = 50)
    private String statusCode;

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ExperimentStatusEntity that = (ExperimentStatusEntity) o;

        if (statusCode != null ? !statusCode.equals(that.statusCode) : that.statusCode != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return statusCode != null ? statusCode.hashCode() : 0;
    }
}
