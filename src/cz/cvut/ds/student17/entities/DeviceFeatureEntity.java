package cz.cvut.ds.student17.entities;

import javax.persistence.*;

/**
 * Created by V on 21.5.2014.
 */
@Entity
@Table(name = "is1_device_feature", schema = "public", catalog = "student_db13_17")
@IdClass(DeviceFeatureEntityPK.class)
public class DeviceFeatureEntity {
    @Id
    @Column(name = "id_dev", nullable = false, insertable = true, updatable = true)
    private int idDev;
    @Id
    @Column(name = "id_feat", nullable = false, insertable = true, updatable = true)
    private int idFeat;
    @ManyToOne
    @JoinColumn(name = "id_feat", referencedColumnName = "id_feat",nullable = false, insertable =  false, updatable = false)
    private FeatureEntity is1FeatureByIdFeat;

    public int getIdDev() {
        return idDev;
    }

    public void setIdDev(int idDev) {
        this.idDev = idDev;
    }

    public int getIdFeat() {
        return idFeat;
    }

    public void setIdFeat(int idFeat) {
        this.idFeat = idFeat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DeviceFeatureEntity that = (DeviceFeatureEntity) o;

        if (idDev != that.idDev) return false;
        if (idFeat != that.idFeat) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idDev;
        result = 31 * result + idFeat;
        return result;
    }

    public FeatureEntity getIs1FeatureByIdFeat() {
        return is1FeatureByIdFeat;
    }

    public void setIs1FeatureByIdFeat(FeatureEntity is1FeatureByIdFeat) {
        this.is1FeatureByIdFeat = is1FeatureByIdFeat;
    }
}
