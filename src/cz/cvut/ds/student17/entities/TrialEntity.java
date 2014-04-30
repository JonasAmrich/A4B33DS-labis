package cz.cvut.ds.student17.entities;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * Created by jonasamrich on 30/04/14.
 */
@Entity
@Table(name = "trial", schema = "public", catalog = "student_db13_17")
public class TrialEntity {
    private int idTrial;
    private Timestamp timestampFrom;
    private Timestamp timestampTo;
    private int cost;
    private Integer idDev;
    private Integer idRoom;
    private int idVic;
    private Collection<ResultsEntity> resultsesByIdTrial;
    private DeviceEntity deviceByIdDev;
    private RoomEntity roomByIdRoom;
    private VictimEntity victimByIdVic;

    @Id
    @Column(name = "id_trial")
    public int getIdTrial() {
        return idTrial;
    }

    public void setIdTrial(int idTrial) {
        this.idTrial = idTrial;
    }

    @Basic
    @Column(name = "timestamp_from")
    public Timestamp getTimestampFrom() {
        return timestampFrom;
    }

    public void setTimestampFrom(Timestamp timestampFrom) {
        this.timestampFrom = timestampFrom;
    }

    @Basic
    @Column(name = "timestamp_to")
    public Timestamp getTimestampTo() {
        return timestampTo;
    }

    public void setTimestampTo(Timestamp timestampTo) {
        this.timestampTo = timestampTo;
    }

    @Basic
    @Column(name = "cost")
    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Basic
    @Column(name = "id_dev")
    public Integer getIdDev() {
        return idDev;
    }

    public void setIdDev(Integer idDev) {
        this.idDev = idDev;
    }

    @Basic
    @Column(name = "id_room")
    public Integer getIdRoom() {
        return idRoom;
    }

    public void setIdRoom(Integer idRoom) {
        this.idRoom = idRoom;
    }

    @Basic
    @Column(name = "id_vic")
    public int getIdVic() {
        return idVic;
    }

    public void setIdVic(int idVic) {
        this.idVic = idVic;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TrialEntity that = (TrialEntity) o;

        if (cost != that.cost) return false;
        if (idTrial != that.idTrial) return false;
        if (idVic != that.idVic) return false;
        if (idDev != null ? !idDev.equals(that.idDev) : that.idDev != null) return false;
        if (idRoom != null ? !idRoom.equals(that.idRoom) : that.idRoom != null) return false;
        if (timestampFrom != null ? !timestampFrom.equals(that.timestampFrom) : that.timestampFrom != null)
            return false;
        if (timestampTo != null ? !timestampTo.equals(that.timestampTo) : that.timestampTo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idTrial;
        result = 31 * result + (timestampFrom != null ? timestampFrom.hashCode() : 0);
        result = 31 * result + (timestampTo != null ? timestampTo.hashCode() : 0);
        result = 31 * result + cost;
        result = 31 * result + (idDev != null ? idDev.hashCode() : 0);
        result = 31 * result + (idRoom != null ? idRoom.hashCode() : 0);
        result = 31 * result + idVic;
        return result;
    }

    @OneToMany(mappedBy = "trialByIdTrial")
    public Collection<ResultsEntity> getResultsesByIdTrial() {
        return resultsesByIdTrial;
    }

    public void setResultsesByIdTrial(Collection<ResultsEntity> resultsesByIdTrial) {
        this.resultsesByIdTrial = resultsesByIdTrial;
    }

    @ManyToOne
    @JoinColumn(name = "id_dev", referencedColumnName = "id_dev")
    public DeviceEntity getDeviceByIdDev() {
        return deviceByIdDev;
    }

    public void setDeviceByIdDev(DeviceEntity deviceByIdDev) {
        this.deviceByIdDev = deviceByIdDev;
    }

    @ManyToOne
    @JoinColumn(name = "id_room", referencedColumnName = "id_room")
    public RoomEntity getRoomByIdRoom() {
        return roomByIdRoom;
    }

    public void setRoomByIdRoom(RoomEntity roomByIdRoom) {
        this.roomByIdRoom = roomByIdRoom;
    }

    @ManyToOne
    @JoinColumn(name = "id_vic", referencedColumnName = "id_vic", nullable = false)
    public VictimEntity getVictimByIdVic() {
        return victimByIdVic;
    }

    public void setVictimByIdVic(VictimEntity victimByIdVic) {
        this.victimByIdVic = victimByIdVic;
    }
}
