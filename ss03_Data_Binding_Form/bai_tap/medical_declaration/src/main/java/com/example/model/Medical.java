package com.example.model;

public class Medical {
    private String name;
    private String birth;
    private String gender;
    private String nationality;
    private String passport;
    private String travel;
    private String vehicle;
    private String seat;
    private String startDate;
    private String endDate;
    private String address;
    private String phone;
    private String email;
    private String symptom;
    private String exposure;

    public Medical() {
    }

    public Medical(String name, String birth, String gender, String nationality, String passport, String travel, String vehicle, String seat, String startDate, String endDate, String address, String phone, String email, String symptom, String exposure) {
        this.name = name;
        this.birth = birth;
        this.gender = gender;
        this.nationality = nationality;
        this.passport = passport;
        this.travel = travel;
        this.vehicle = vehicle;
        this.seat = seat;
        this.startDate = startDate;
        this.endDate = endDate;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.symptom = symptom;
        this.exposure = exposure;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getTravel() {
        return travel;
    }

    public void setTravel(String travel) {
        this.travel = travel;
    }

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSymptom() {
        return symptom;
    }

    public void setSymptom(String symptom) {
        this.symptom = symptom;
    }

    public String getExposure() {
        return exposure;
    }

    public void setExposure(String exposure) {
        this.exposure = exposure;
    }
}
