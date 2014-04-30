package cz.cvut.ds.student17.entities;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by jonasamrich on 30/04/14.
 */
@Entity
@Table(name = "room", schema = "public", catalog = "student_db13_17")
public class RoomEntity {
    private int idRoom;
    private String name;
    private String code;
    private Collection<TrialEntity> trialsByIdRoom;

    @Id
    @Column(name = "id_room")
    public int getIdRoom() {
        return idRoom;
    }

    public void setIdRoom(int idRoom) {
        this.idRoom = idRoom;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "code")
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

    @OneToMany(mappedBy = "roomByIdRoom")
    public Collection<TrialEntity> getTrialsByIdRoom() {
        return trialsByIdRoom;
    }

    public void setTrialsByIdRoom(Collection<TrialEntity> trialsByIdRoom) {
        this.trialsByIdRoom = trialsByIdRoom;
    }
}
