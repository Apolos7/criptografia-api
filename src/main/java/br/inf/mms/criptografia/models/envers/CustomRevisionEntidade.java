package br.inf.mms.criptografia.models.envers;

import jakarta.persistence.*;
import org.hibernate.envers.DateTimeFormatter;
import org.hibernate.envers.RevisionEntity;
import org.hibernate.envers.RevisionNumber;
import org.hibernate.envers.RevisionTimestamp;

import java.util.Date;

@Entity
@Table(name = "revinfo", schema = "auditoria")
@RevisionEntity()
public class CustomRevisionEntidade {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "revinfo_seq")
    @SequenceGenerator(name = "revinfo_seq", sequenceName = "revinfo_seq", allocationSize = 1)
    @RevisionNumber
    @Column(name = "rev")
    private int id;

    @RevisionTimestamp
    @Column(name = "revtstmp")
    private long timestamp;

    @Transient
    public Date getRevisionDate() {
        return new Date( timestamp );
    }

    @Override
    public boolean equals(Object o) {
        if ( this == o ) {
            return true;
        }
        if ( !(o instanceof CustomRevisionEntidade) ) {
            return false;
        }

        final CustomRevisionEntidade that = (CustomRevisionEntidade) o;
        return id == that.id
               && timestamp == that.timestamp;
    }

    @Override
    public int hashCode() {
        int result;
        result = id;
        result = 31 * result + (int) (timestamp ^ (timestamp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "DefaultRevisionEntity(id = " + id
               + ", revisionDate = " + DateTimeFormatter.INSTANCE.format( getRevisionDate() ) + ")";
    }
}
