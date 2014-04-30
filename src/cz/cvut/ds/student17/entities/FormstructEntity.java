package cz.cvut.ds.student17.entities;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by jonasamrich on 30/04/14.
 */
@Entity
@Table(name = "formstruct", schema = "public", catalog = "student_db13_17")
public class FormstructEntity {
    private int idFs;
    private int idFt;
    private String name;
    private FormtypEntity formtypByIdFt;
    private Collection<ResultsEntity> resultsesByIdFs;

    @Id
    @Column(name = "id_fs")
    public int getIdFs() {
        return idFs;
    }

    public void setIdFs(int idFs) {
        this.idFs = idFs;
    }

    @Basic
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

        FormstructEntity that = (FormstructEntity) o;

        if (idFs != that.idFs) return false;
        if (idFt != that.idFt) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idFs;
        result = 31 * result + idFt;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "id_ft", referencedColumnName = "id_ft", nullable = false)
    public FormtypEntity getFormtypByIdFt() {
        return formtypByIdFt;
    }

    public void setFormtypByIdFt(FormtypEntity formtypByIdFt) {
        this.formtypByIdFt = formtypByIdFt;
    }

    @OneToMany(mappedBy = "formstructByIdFs")
    public Collection<ResultsEntity> getResultsesByIdFs() {
        return resultsesByIdFs;
    }

    public void setResultsesByIdFs(Collection<ResultsEntity> resultsesByIdFs) {
        this.resultsesByIdFs = resultsesByIdFs;
    }
}
