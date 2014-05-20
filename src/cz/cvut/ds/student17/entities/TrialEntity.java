package cz.cvut.ds.student17.entities;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by V on 21.5.2014.
 */
@Entity
@SequenceGenerator(name="seq_is1_trial",  sequenceName="seq_is1_trial", initialValue=1, allocationSize=5)
@Table(name = "is1_trial", schema = "public", catalog = "student_db13_17")
public class TrialEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_is1_trial")
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
    @ManyToOne
    @JoinColumn(name = "id_vic", referencedColumnName = "id_vic", nullable = false, insertable =  false, updatable = false)
    private VictimEntity is1VictimByIdVic;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TrialEntity that = (TrialEntity) o;

        if (cost != that.cost) return false;
        if (idTrial != that.idTrial) return false;
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
        return result;
    }

    public VictimEntity getIs1VictimByIdVic() {
        return is1VictimByIdVic;
    }

    public void setIs1VictimByIdVic(VictimEntity is1VictimByIdVic) {
        this.is1VictimByIdVic = is1VictimByIdVic;
    }
}
