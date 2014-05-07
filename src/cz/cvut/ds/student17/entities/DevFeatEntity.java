package cz.cvut.ds.student17.entities;

import javax.persistence.*;

/**
 * Created by V on 7.5.2014.
 */
@Entity
@Table(name = "dev_feat", schema = "public", catalog = "student_db13_17")
@IdClass(DevFeatEntityPK.class)
public class DevFeatEntity {
    @Id
    @Column(name = "id_dev", nullable = false, insertable = true, updatable = true)
    private int idDev;
    @Id
    @Column(name = "id_feat", nullable = false, insertable = true, updatable = true)
    private int idFeat;
    @ManyToOne
    //@JoinColumn(name = "id_dev", referencedColumnName = "id_dev", nullable = false)
    @JoinColumn(name = "id_dev", referencedColumnName = "id_dev", nullable = false, insertable =  false, updatable = false)
    private DeviceEntity deviceByIdDev;
    @ManyToOne
    //@JoinColumn(name = "id_feat", referencedColumnName = "id_feat", nullable = false)
    @JoinColumn(name = "id_feat", referencedColumnName = "id_feat", nullable = false, insertable =  false, updatable = false)
    private FeatureEntity featureByIdFeat;

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

        DevFeatEntity that = (DevFeatEntity) o;

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

    public DeviceEntity getDeviceByIdDev() {
        return deviceByIdDev;
    }

    public void setDeviceByIdDev(DeviceEntity deviceByIdDev) {
        this.deviceByIdDev = deviceByIdDev;
    }

    public FeatureEntity getFeatureByIdFeat() {
        return featureByIdFeat;
    }

    public void setFeatureByIdFeat(FeatureEntity featureByIdFeat) {
        this.featureByIdFeat = featureByIdFeat;
    }
}
