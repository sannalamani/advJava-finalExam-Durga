package fr.epita.advjava.datamodel;

import javax.persistence.*;

@Entity
@Table(name = "facilities")
public class Facility {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "facid")
    private int facId;

    @Column(name = "name")
    private String name;

    @Column(name = "membercost")
    private double memberCost;

    @Column(name = "guestcost")
    private double guestCost;

    @Column(name = "initialoutlay")
    private double initialOutlay;

    @Column(name = "monthlymaintenance")
    private double monthlyMaintenance;


    // Default constructor
    public Facility() {
    }

    // Parameterized constructor
    public Facility(int facId, String name, double memberCost, double guestCost, double initialOutlay, double monthlyMaintenance) {
        this.facId = facId;
        this.name = name;
        this.memberCost = memberCost;
        this.guestCost = guestCost;
        this.initialOutlay = initialOutlay;
        this.monthlyMaintenance = monthlyMaintenance;
    }

    // Getters and setters
    public int getFacId() {
        return facId;
    }

    public void setFacId(int facId) {
        this.facId = facId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMemberCost() {
        return memberCost;
    }

    public void setMemberCost(double memberCost) {
        this.memberCost = memberCost;
    }

    public double getGuestCost() {
        return guestCost;
    }

    public void setGuestCost(double guestCost) {
        this.guestCost = guestCost;
    }

    public double getInitialOutlay() {
        return initialOutlay;
    }

    public void setInitialOutlay(double initialOutlay) {
        this.initialOutlay = initialOutlay;
    }

    public double getMonthlyMaintenance() {
        return monthlyMaintenance;
    }

    public void setMonthlyMaintenance(double monthlyMaintenance) {
        this.monthlyMaintenance = monthlyMaintenance;
    }

    @Override
    public String toString() {
        return "Facility[" +
                "facId=" + facId +
                ", name='" + name + '\'' +
                ", memberCost=" + memberCost +
                ", guestCost=" + guestCost +
                ", initialOutlay=" + initialOutlay +
                ", monthlyMaintenance=" + monthlyMaintenance +
                ']';
    }
}
