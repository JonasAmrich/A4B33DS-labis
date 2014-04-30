package cz.cvut.ds.student17.entities;

import javax.persistence.*;

/**
 * Created by jonasamrich on 30/04/14.
 */
@Entity
@Table(name = "dev_feat", schema = "public", catalog = "student_db13_17")
@IdClass(DevFeatEntityPK.class)
public class DevFeatEntity {
    private int idDev;
    private int idFeat;
    private DeviceEntity deviceByIdDev;
    private FeatureEntity featureByIdFeat;

    @Id
    @Column(name = "id_dev")
    public int getIdDev() {
        return idDev;
    }

    public void setIdDev(int idDev) {
        this.idDev = idDev;
    }

    @Id
    @Column(name = "id_feat")
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

    @ManyToOne
    @JoinColumn(name = "id_dev", referencedColumnName = "id_dev", nullable = false)
    public DeviceEntity getDeviceByIdDev() {
        return deviceByIdDev;
    }

    public void setDeviceByIdDev(DeviceEntity deviceByIdDev) {
        this.deviceByIdDev = deviceByIdDev;
    }

    @ManyToOne
    @JoinColumn(name = "id_feat", referencedColumnName = "id_feat", nullable = false)
    public FeatureEntity getFeatureByIdFeat() {
        return featureByIdFeat;
    }

    public void setFeatureByIdFeat(FeatureEntity featureByIdFeat) {
        this.featureByIdFeat = featureByIdFeat;
    }
}
