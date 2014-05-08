package cz.cvut.ds.student17.entities;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by V on 7.5.2014.
 */
@Entity
@SequenceGenerator(name="seq_formtyp",  sequenceName="seq_formtyp", initialValue=1, allocationSize=5)
@Table(name = "formtyp", schema = "public", catalog = "student_db13_17")
public class FormtypEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_formtyp")
    @Column(name = "id_ft", nullable = false, insertable = true, updatable = true)
    private int idFt;
    @Basic
    @Column(name = "name", nullable = true, insertable = true, updatable = true, length = 2147483647)
    private String name;
    @OneToMany(mappedBy = "formtypByIdFt")
    private Collection<ExperimentEntity> experimentsByIdFt;
    @OneToMany(mappedBy = "formtypByIdFt")
    private Collection<FormstructEntity> formstructsByIdFt;

    public int getIdFt() {
        return idFt;
    }

    public void setIdFt(int idFt) {
        this.idFt = idFt;
    }

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

    public Collection<ExperimentEntity> getExperimentsByIdFt() {
        return experimentsByIdFt;
    }

    public void setExperimentsByIdFt(Collection<ExperimentEntity> experimentsByIdFt) {
        this.experimentsByIdFt = experimentsByIdFt;
    }

    public Collection<FormstructEntity> getFormstructsByIdFt() {
        return formstructsByIdFt;
    }

    public void setFormstructsByIdFt(Collection<FormstructEntity> formstructsByIdFt) {
        this.formstructsByIdFt = formstructsByIdFt;
    }
}
