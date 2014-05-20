package cz.cvut.ds.student17.entities;

import javax.persistence.*;

/**
 * Created by V on 21.5.2014.
 */
@Entity
@Table(name = "is1_form_structure_type", schema = "public", catalog = "student_db13_17")
public class FormStructureTypeEntity {
    @Id
    @Column(name = "id_fstype", nullable = false, insertable = true, updatable = true, length = 2147483647)
    private String idFstype;
    @Basic
    @Column(name = "description", nullable = true, insertable = true, updatable = true, length = 2147483647)
    private String description;

    public String getIdFstype() {
        return idFstype;
    }

    public void setIdFstype(String idFstype) {
        this.idFstype = idFstype;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FormStructureTypeEntity that = (FormStructureTypeEntity) o;

        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (idFstype != null ? !idFstype.equals(that.idFstype) : that.idFstype != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idFstype != null ? idFstype.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }
}
