package cz.cvut.ds.student17.entities;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by jonasamrich on 30/04/14.
 */
@Entity
@Table(name = "feature", schema = "public", catalog = "student_db13_17")
public class FeatureEntity {
    private int idFeat;
    private String title;
    private Collection<DevFeatEntity> devFeatsByIdFeat;
    private Collection<FeatExpEntity> featExpsByIdFeat;

    @Id
    @Column(name = "id_feat")
    public int getIdFeat() {
        return idFeat;
    }

    public void setIdFeat(int idFeat) {
        this.idFeat = idFeat;
    }

    @Basic
    @Column(name = "title")
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

    @OneToMany(mappedBy = "featureByIdFeat")
    public Collection<DevFeatEntity> getDevFeatsByIdFeat() {
        return devFeatsByIdFeat;
    }

    public void setDevFeatsByIdFeat(Collection<DevFeatEntity> devFeatsByIdFeat) {
        this.devFeatsByIdFeat = devFeatsByIdFeat;
    }

    @OneToMany(mappedBy = "featureByIdFeat")
    public Collection<FeatExpEntity> getFeatExpsByIdFeat() {
        return featExpsByIdFeat;
    }

    public void setFeatExpsByIdFeat(Collection<FeatExpEntity> featExpsByIdFeat) {
        this.featExpsByIdFeat = featExpsByIdFeat;
    }
}
