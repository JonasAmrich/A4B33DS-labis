package cz.cvut.ds.student17.entities;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by V on 7.5.2014.
 */
@Entity
@SequenceGenerator(name="seq_formstruct",  sequenceName="seq_formstruct", initialValue=1, allocationSize=5)
@Table(name = "formstruct", schema = "public", catalog = "student_db13_17")
public class FormstructEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_formstruct")
    @Column(name = "id_fs", nullable = false, insertable = true, updatable = true)
    private int idFs;
    @Basic
    @Column(name = "id_ft", nullable = false, insertable = true, updatable = true)
    private int idFt;
    @Basic
    @Column(name = "name", nullable = true, insertable = true, updatable = true, length = 2147483647)
    private String name;
    @Basic
    @Column(name = "id_fstype", nullable = false, insertable = true, updatable = true, length = 2147483647)
    private String idFstype;
    @ManyToOne
    //@JoinColumn(name = "id_ft", referencedColumnName = "id_ft", nullable = false)
    @JoinColumn(name = "id_ft", referencedColumnName = "id_ft", nullable = false, insertable =  false, updatable = false)
    private FormtypEntity formtypByIdFt;
    @ManyToOne
    //@JoinColumn(name = "id_fstype", referencedColumnName = "id_fstype", nullable = false)
    @JoinColumn(name = "id_fstype", referencedColumnName = "id_fstype", nullable = false, insertable =  false, updatable = false)
    private FstructtypeEntity fstructtypeByIdFstype;
    @OneToMany(mappedBy = "formstructByIdFs")
    private Collection<ResultsEntity> resultsesByIdFs;

    public int getIdFs() {
        return idFs;
    }

    public void setIdFs(int idFs) {
        this.idFs = idFs;
    }

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

    public String getIdFstype() {
        return idFstype;
    }

    public void setIdFstype(String idFstype) {
        this.idFstype = idFstype;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FormstructEntity that = (FormstructEntity) o;

        if (idFs != that.idFs) return false;
        if (idFt != that.idFt) return false;
        if (idFstype != null ? !idFstype.equals(that.idFstype) : that.idFstype != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idFs;
        result = 31 * result + idFt;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (idFstype != null ? idFstype.hashCode() : 0);
        return result;
    }

    public FormtypEntity getFormtypByIdFt() {
        return formtypByIdFt;
    }

    public void setFormtypByIdFt(FormtypEntity formtypByIdFt) {
        this.formtypByIdFt = formtypByIdFt;
    }

    public FstructtypeEntity getFstructtypeByIdFstype() {
        return fstructtypeByIdFstype;
    }

    public void setFstructtypeByIdFstype(FstructtypeEntity fstructtypeByIdFstype) {
        this.fstructtypeByIdFstype = fstructtypeByIdFstype;
    }

    public Collection<ResultsEntity> getResultsesByIdFs() {
        return resultsesByIdFs;
    }

    public void setResultsesByIdFs(Collection<ResultsEntity> resultsesByIdFs) {
        this.resultsesByIdFs = resultsesByIdFs;
    }
}
