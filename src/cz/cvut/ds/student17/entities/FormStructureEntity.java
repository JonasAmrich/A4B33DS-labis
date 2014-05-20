package cz.cvut.ds.student17.entities;

import javax.persistence.*;

/**
 * Created by V on 21.5.2014.
 */
@Entity
@SequenceGenerator(name="seq_is1_form_structure",  sequenceName="seq_is1_form_structure", initialValue=1, allocationSize=5)
@Table(name = "is1_form_structure", schema = "public", catalog = "student_db13_17")
public class FormStructureEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_is1_form_structure")
    @Column(name = "id_fs", nullable = false, insertable = true, updatable = true)
    private int idFs;
    @Basic
    @Column(name = "name", nullable = true, insertable = true, updatable = true, length = 2147483647)
    private String name;
    @ManyToOne
    @JoinColumn(name = "id_ft", referencedColumnName = "id_ft", nullable = false, insertable =  false, updatable = false)
    private FormTypeEntity is1FormTypeByIdFt;

    public int getIdFs() {
        return idFs;
    }

    public void setIdFs(int idFs) {
        this.idFs = idFs;
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

        FormStructureEntity that = (FormStructureEntity) o;

        if (idFs != that.idFs) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idFs;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    public FormTypeEntity getIs1FormTypeByIdFt() {
        return is1FormTypeByIdFt;
    }

    public void setIs1FormTypeByIdFt(FormTypeEntity is1FormTypeByIdFt) {
        this.is1FormTypeByIdFt = is1FormTypeByIdFt;
    }
}
