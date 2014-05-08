package cz.cvut.ds.student17.entities;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * Created by V on 7.5.2014.
 */
@Entity
@SequenceGenerator(name="seq_trial",  sequenceName="seq_trial", initialValue=1, allocationSize=5)
@Table(name = "trial", schema = "public", catalog = "student_db13_17")
public class TrialEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_trial")
    @Column(name = "id_trial", nullable = false, insertable = true, updatable = true)
    private int idTrial;
    @Basic
    @Column(name = "timestamp_from", nullable = true, insertable = true, updatable = true)
    private Timestamp timestampFrom;
    @Basic
    @Column(name = "timestamp_to", nullable = true, insertable = true, updatable = true)
    private Timestamp timestampTo;
    @Basic
    @Column(name = "cost", nullable = false, insertable = true, updatable = true)
    private int cost;
    @Basic
    @Column(name = "id_dev", nullable = true, insertable = true, updatable = true)
    private Integer idDev;
    @Basic
    @Column(name = "id_room", nullable = true, insertable = true, updatable = true)
    private Integer idRoom;
    @Basic
    @Column(name = "id_vic", nullable = false, insertable = true, updatable = true)
    private int idVic;
    @OneToMany(mappedBy = "trialByIdTrial")
    private Collection<ResultsEntity> resultsesByIdTrial;
    @ManyToOne
    //@JoinColumn(name = "id_dev", referencedColumnName = "id_dev")
    @JoinColumn(name = "id_dev", referencedColumnName = "id_dev", insertable =  false, updatable = false)
    private DeviceEntity deviceByIdDev;
    @ManyToOne
    //@JoinColumn(name = "id_room", referencedColumnName = "id_room")
    @JoinColumn(name = "id_room", referencedColumnName = "id_room", insertable =  false, updatable = false)
    private RoomEntity roomByIdRoom;
    @ManyToOne
    //@JoinColumn(name = "id_room", referencedColumnName = "id_room")
    @JoinColumn(name = "id_vic", referencedColumnName = "id_vic", nullable = false, insertable =  false, updatable = false)
    private VictimEntity victimByIdVic;

    public int getIdTrial() {
        return idTrial;
    }

    public void setIdTrial(int idTrial) {
        this.idTrial = idTrial;
    }

    public Timestamp getTimestampFrom() {
        return timestampFrom;
    }

    public void setTimestampFrom(Timestamp timestampFrom) {
        this.timestampFrom = timestampFrom;
    }

    public Timestamp getTimestampTo() {
        return timestampTo;
    }

    public void setTimestampTo(Timestamp timestampTo) {
        this.timestampTo = timestampTo;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public Integer getIdDev() {
        return idDev;
    }

    public void setIdDev(Integer idDev) {
        this.idDev = idDev;
    }

    public Integer getIdRoom() {
        return idRoom;
    }

    public void setIdRoom(Integer idRoom) {
        this.idRoom = idRoom;
    }

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

    public Collection<ResultsEntity> getResultsesByIdTrial() {
        return resultsesByIdTrial;
    }

    public void setResultsesByIdTrial(Collection<ResultsEntity> resultsesByIdTrial) {
        this.resultsesByIdTrial = resultsesByIdTrial;
    }

    public DeviceEntity getDeviceByIdDev() {
        return deviceByIdDev;
    }

    public void setDeviceByIdDev(DeviceEntity deviceByIdDev) {
        this.deviceByIdDev = deviceByIdDev;
    }

    public RoomEntity getRoomByIdRoom() {
        return roomByIdRoom;
    }

    public void setRoomByIdRoom(RoomEntity roomByIdRoom) {
        this.roomByIdRoom = roomByIdRoom;
    }

    public VictimEntity getVictimByIdVic() {
        return victimByIdVic;
    }

    public void setVictimByIdVic(VictimEntity victimByIdVic) {
        this.victimByIdVic = victimByIdVic;
    }
}
