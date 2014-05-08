package cz.cvut.ds.student17.entities;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by V on 7.5.2014.
 */
@Entity
@SequenceGenerator(name="seq_room",  sequenceName="seq_room", initialValue=1, allocationSize=5)
@Table(name = "room", schema = "public", catalog = "student_db13_17")
public class RoomEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_room")
    @Column(name = "id_room", nullable = false, insertable = true, updatable = true)
    private int idRoom;
    @Basic
    @Column(name = "name", nullable = true, insertable = true, updatable = true, length = 2147483647)
    private String name;
    @Basic
    @Column(name = "code", nullable = true, insertable = true, updatable = true, length = 50)
    private String code;
    @OneToMany(mappedBy = "roomByIdRoom")
    private Collection<TrialEntity> trialsByIdRoom;

    public int getIdRoom() {
        return idRoom;
    }

    public void setIdRoom(int idRoom) {
        this.idRoom = idRoom;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RoomEntity that = (RoomEntity) o;

        if (idRoom != that.idRoom) return false;
        if (code != null ? !code.equals(that.code) : that.code != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idRoom;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (code != null ? code.hashCode() : 0);
        return result;
    }

    public Collection<TrialEntity> getTrialsByIdRoom() {
        return trialsByIdRoom;
    }

    public void setTrialsByIdRoom(Collection<TrialEntity> trialsByIdRoom) {
        this.trialsByIdRoom = trialsByIdRoom;
    }
}
