package fr.epita.advjava.datamodel;

import javax.persistence.*;
import java.sql.Timestamp;



@Entity
@Table(name = "bookings")
public class Booking {
    @Id
    @Column(name = "bookid")
    private int bookId;

    @ManyToOne
    @JoinColumn(name = "facid", referencedColumnName = "facid")
    private Facility facility;

    @ManyToOne
    @JoinColumn(name = "memid", referencedColumnName = "memid")
    private Member member;

    @Column(name = "starttime")
    private Timestamp startTime;

    @Column(name = "slots")
    private int slots;

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public Facility getFacility() {
        return facility;
    }

    public void setFacility(Facility facility) {
        this.facility = facility;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public int getSlots() {
        return slots;
    }

    public void setSlots(int slots) {
        this.slots = slots;
    }
}
