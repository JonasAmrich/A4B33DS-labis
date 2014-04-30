package cz.cvut.ds.student17.entities;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by jonasamrich on 30/04/14.
 */
@Entity
@Table(name = "device", schema = "public", catalog = "student_db13_17")
public class DeviceEntity {
    private int idDev;
    private String title;
    private String description;
    private Collection<DevFeatEntity> devFeatsByIdDev;
    private Collection<TrialEntity> trialsByIdDev;

    @Id
    @Column(name = "id_dev")
    public int getIdDev() {
        return idDev;
    }

    public void setIdDev(int idDev) {
        this.idDev = idDev;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "description")
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

        DeviceEntity that = (DeviceEntity) o;

        if (idDev != that.idDev) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idDev;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "deviceByIdDev")
    public Collection<DevFeatEntity> getDevFeatsByIdDev() {
        return devFeatsByIdDev;
    }

    public void setDevFeatsByIdDev(Collection<DevFeatEntity> devFeatsByIdDev) {
        this.devFeatsByIdDev = devFeatsByIdDev;
    }

    @OneToMany(mappedBy = "deviceByIdDev")
    public Collection<TrialEntity> getTrialsByIdDev() {
        return trialsByIdDev;
    }

    public void setTrialsByIdDev(Collection<TrialEntity> trialsByIdDev) {
        this.trialsByIdDev = trialsByIdDev;
    }
}
