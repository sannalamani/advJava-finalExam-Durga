package fr.epita.advjava.datamodel;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "MEMBERS")
public class Member {
    @Id

    @Column(name = "memid")
    private int memId;

    @Column(name = "surname")
    private String surname;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "address")
    private String address;

    @Column(name = "zipcode")
    private int zipcode;

    @Column(name = "telephone")
    private String telephone;

    @Column(name = "recommendedby")
    private Integer recommendedBy;

    @Column(name = "joindate")
    private Timestamp joinDate;


    // Default constructor
    public Member() {
    }

    // Parameterized constructor
    public Member(int memId, String surname, String firstName, String address, int zipcode, String telephone,
                  Integer recommendedBy, Timestamp joinDate) {
        this.memId = memId;
        this.surname = surname;
        this.firstName = firstName;
        this.address = address;
        this.zipcode = zipcode;
        this.telephone = telephone;
        this.recommendedBy = recommendedBy;
        this.joinDate = joinDate;
    }

    // Getters and setters
    public int getMemId() {
        return memId;
    }

    public void setMemId(int memId) {
        this.memId = memId;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getZipcode() {
        return zipcode;
    }

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Integer getRecommendedBy() {
        return recommendedBy;
    }

    public void setRecommendedBy(Integer recommendedBy) {
        this.recommendedBy = recommendedBy;
    }

    public Timestamp getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Timestamp joinDate) {
        this.joinDate = joinDate;
    }

    @Override
    public String toString() {
        return "Member[" +
                "memId=" + memId +
                ", surname='" + surname + '\'' +
                ", firstName='" + firstName + '\'' +
                ", address='" + address + '\'' +
                ", zipcode=" + zipcode +
                ", telephone='" + telephone + '\'' +
                ", recommendedBy=" + recommendedBy +
                ", joinDate=" + joinDate +
                ']';
    }
}
