package cz.cvut.ds.student17.entities;

import javax.persistence.*;

/**
 * Created by V on 21.5.2014.
 */
@Entity
@SequenceGenerator(name="seq_is1_device",  sequenceName="seq_is1_device", initialValue=1, allocationSize=5)
@Table(name = "is1_device", schema = "public", catalog = "student_db13_17")
public class DeviceEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_is1_device")
    @Column(name = "id_dev", nullable = false, insertable = true, updatable = true)
    private int idDev;
    @Basic
    @Column(name = "title", nullable = false, insertable = true, updatable = true, length = 2147483647)
    private String title;
    @Basic
    @Column(name = "description", nullable = true, insertable = true, updatable = true, length = 2147483647)
    private String description;

    public int getIdDev() {
        return idDev;
    }

    public void setIdDev(int idDev) {
        this.idDev = idDev;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
}
