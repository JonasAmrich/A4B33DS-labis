package cz.cvut.ds.student17.entities;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by jonasamrich on 30/04/14.
 */
@Entity
@Table(name = "formtyp", schema = "public", catalog = "student_db13_17")
public class FormtypEntity {
    private int idFt;
    private String name;
    private Collection<ExperimentEntity> experimentsByIdFt;
    private Collection<FormstructEntity> formstructsByIdFt;

    @Id
    @Column(name = "id_ft")
    public int getIdFt() {
        return idFt;
    }

    public void setIdFt(int idFt) {
        this.idFt = idFt;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FormtypEntity that = (FormtypEntity) o;

        if (idFt != that.idFt) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idFt;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "formtypByIdFt")
    public Collection<ExperimentEntity> getExperimentsByIdFt() {
        return experimentsByIdFt;
    }

    public void setExperimentsByIdFt(Collection<ExperimentEntity> experimentsByIdFt) {
        this.experimentsByIdFt = experimentsByIdFt;
    }

    @OneToMany(mappedBy = "formtypByIdFt")
    public Collection<FormstructEntity> getFormstructsByIdFt() {
        return formstructsByIdFt;
    }

    public void setFormstructsByIdFt(Collection<FormstructEntity> formstructsByIdFt) {
        this.formstructsByIdFt = formstructsByIdFt;
    }
}
