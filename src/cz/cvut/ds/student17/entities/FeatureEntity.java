package cz.cvut.ds.student17.entities;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by V on 7.5.2014.
 */
@Entity
@Table(name = "feature", schema = "public", catalog = "student_db13_17")
public class FeatureEntity {
    @Id
    @Column(name = "id_feat", nullable = false, insertable = true, updatable = true)
    private int idFeat;
    @Basic
    @Column(name = "title", nullable = false, insertable = true, updatable = true, length = 2147483647)
    private String title;
    @OneToMany(mappedBy = "featureByIdFeat")
    private Collection<DevFeatEntity> devFeatsByIdFeat;
    @OneToMany(mappedBy = "featureByIdFeat")
    private Collection<FeatExpEntity> featExpsByIdFeat;

    public int getIdFeat() {
        return idFeat;
    }

    public void setIdFeat(int idFeat) {
        this.idFeat = idFeat;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FeatureEntity that = (FeatureEntity) o;

        if (idFeat != that.idFeat) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idFeat;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        return result;
    }

    public Collection<DevFeatEntity> getDevFeatsByIdFeat() {
        return devFeatsByIdFeat;
    }

    public void setDevFeatsByIdFeat(Collection<DevFeatEntity> devFeatsByIdFeat) {
        this.devFeatsByIdFeat = devFeatsByIdFeat;
    }

    public Collection<FeatExpEntity> getFeatExpsByIdFeat() {
        return featExpsByIdFeat;
    }

    public void setFeatExpsByIdFeat(Collection<FeatExpEntity> featExpsByIdFeat) {
        this.featExpsByIdFeat = featExpsByIdFeat;
    }
}
