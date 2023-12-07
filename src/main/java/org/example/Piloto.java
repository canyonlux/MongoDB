package org.example;

import org.bson.types.ObjectId;

import java.util.Date;

public class Piloto {
    ObjectId id;
    Integer driverid;
    String code;
    String forename;
    String surname;
    Date dob;
    String nationality;
    Escuderia constructors;
    String url;

    public Piloto() {
    }

    public Piloto(ObjectId id, Integer driverid, String code, String forename, String surname, Date dob, String nationality, Escuderia constructors, String url) {
        this.id = id;
        this.driverid = driverid;
        this.code = code;
        this.forename = forename;
        this.surname = surname;
        this.dob = dob;
        this.nationality = nationality;
        this.constructors = constructors;
        this.url = url;
    }


    public int getDriverid() {
        return driverid;
    }

    public void setDriverid(int driverid) {
        this.driverid = driverid;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getForename() {
        return forename;
    }

    public void setForename(String forename) {
        this.forename = forename;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Escuderia getConstructors() {
        return constructors;
    }

    public void setConstructors(Escuderia constructors) {
        this.constructors = constructors;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public void setDriverid(Integer driverid) {
        this.driverid = driverid;
    }

    @Override
    public String toString() {
        return "Piloto{" +
                "code='" + code + '\'' +
                ", forename='" + forename + '\'' +
                ", surname='" + surname + '\'' +
                ", dob=" + dob +
                ", nationality='" + nationality + '\'' +
                ", equipo=" + constructors +
                ", url='" + url + '\'' +
                '}';
    }
}
