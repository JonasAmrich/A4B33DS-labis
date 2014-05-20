package cz.cvut.ds.student17.entities;

import javax.persistence.*;

/**
 * Created by V on 21.5.2014.
 */
@Entity
@SequenceGenerator(name="seq_is1_form_type",  sequenceName="seq_is1_form_type", initialValue=1, allocationSize=5)
@Table(name = "is1_form_type", schema = "public", catalog = "student_db13_17")
public class FormTypeEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_is1_form_type")
    @Column(name = "id_ft", nullable = false, insertable = true, updatable = true)
    private int idFt;
    @Basic
    @Column(name = "name", nullable = true, insertable = true, updatable = true, length = 2147483647)
    private String name;

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

        FormTypeEntity that = (FormTypeEntity) o;

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
}
