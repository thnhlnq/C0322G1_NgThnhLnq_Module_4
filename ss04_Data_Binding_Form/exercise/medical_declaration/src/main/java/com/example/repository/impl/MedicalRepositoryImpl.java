package com.example.repository.impl;

import com.example.model.Medical;
import com.example.repository.MedicalRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MedicalRepositoryImpl implements MedicalRepository {

    private static final List<Medical> medicals = new ArrayList<>();
    private static final List<String> births = new ArrayList<>();
    private static final List<String> genders = new ArrayList<>();
    private static final List<String> nationalities = new ArrayList<>();
    private static final List<String> travels = new ArrayList<>();
    private static final List<String> startDays = new ArrayList<>();
    private static final List<String> startMonths = new ArrayList<>();
    private static final List<String> startYears = new ArrayList<>();
    private static final List<String> endDays = new ArrayList<>();
    private static final List<String> endMonths = new ArrayList<>();
    private static final List<String> endYears = new ArrayList<>();

    static {
        medicals.add(new Medical("Nguyễn A", "1990", "Nam", "Việt Nam", "123456789", "Ô Tô", "14523", "4", "10", "10", "2019", "12", "10", "2019", "Quảng Trị"));
        medicals.add(new Medical("Văn B", "1995", "Nam", "Việt Nam", "174852365", "Tàu Thuyền", "11523", "7", "21", "12", "2020", "28", "12", "2020", "Quảng Nam"));
        medicals.add(new Medical("Thị C", "1993", "Nữ", "Việt Nam", "145236974", "Tàu Bay", "99874", "10", "31", "12", "2021", "15", "01", "2022", "Đà Nẵng"));

        births.add("1990");
        births.add("1991");
        births.add("1992");
        births.add("1993");
        births.add("1994");
        births.add("1995");

        genders.add("Nam");
        genders.add("Nữ");
        genders.add("Khác");

        nationalities.add("Việt Nam");
        nationalities.add("Anh");
        nationalities.add("Đức");
        nationalities.add("Hoa Kỳ");

        travels.add("Tàu Bay");
        travels.add("Tàu Thuyền");
        travels.add("Ô Tô");
        travels.add("Khác");

        startDays.add("1");
        startDays.add("2");
        startDays.add("3");
        startDays.add("4");
        startDays.add("5");
        startDays.add("6");
        startDays.add("7");
        startDays.add("8");
        startDays.add("9");
        startDays.add("10");
        startDays.add("11");
        startDays.add("12");
        startDays.add("13");
        startDays.add("14");
        startDays.add("15");
        startDays.add("16");
        startDays.add("17");
        startDays.add("18");
        startDays.add("19");
        startDays.add("20");
        startDays.add("21");
        startDays.add("22");
        startDays.add("23");
        startDays.add("24");
        startDays.add("25");
        startDays.add("26");
        startDays.add("27");
        startDays.add("28");
        startDays.add("29");
        startDays.add("30");
        startDays.add("31");

        startMonths.add("1");
        startMonths.add("2");
        startMonths.add("3");
        startMonths.add("4");
        startMonths.add("5");
        startMonths.add("6");
        startMonths.add("7");
        startMonths.add("8");
        startMonths.add("9");
        startMonths.add("10");
        startMonths.add("11");
        startMonths.add("12");

        startYears.add("2019");
        startYears.add("2020");
        startYears.add("2021");
        startYears.add("2022");

        endDays.add("1");
        endDays.add("2");
        endDays.add("3");
        endDays.add("4");
        endDays.add("5");
        endDays.add("6");
        endDays.add("7");
        endDays.add("8");
        endDays.add("9");
        endDays.add("10");
        endDays.add("11");
        endDays.add("12");
        endDays.add("13");
        endDays.add("14");
        endDays.add("15");
        endDays.add("16");
        endDays.add("17");
        endDays.add("18");
        endDays.add("19");
        endDays.add("20");
        endDays.add("21");
        endDays.add("22");
        endDays.add("23");
        endDays.add("24");
        endDays.add("25");
        endDays.add("26");
        endDays.add("27");
        endDays.add("28");
        endDays.add("29");
        endDays.add("30");
        endDays.add("31");

        endMonths.add("1");
        endMonths.add("2");
        endMonths.add("3");
        endMonths.add("4");
        endMonths.add("5");
        endMonths.add("6");
        endMonths.add("7");
        endMonths.add("8");
        endMonths.add("9");
        endMonths.add("10");
        endMonths.add("11");
        endMonths.add("12");

        endYears.add("2019");
        endYears.add("2020");
        endYears.add("2021");
        endYears.add("2022");
    }

    @Override
    public List<Medical> medicals() {
        return medicals;
    }

    @Override
    public List<String> births() {
        return births;
    }

    @Override
    public List<String> genders() {
        return genders;
    }

    @Override
    public List<String> nationalities() {
        return nationalities;
    }

    @Override
    public List<String> travels() {
        return travels;
    }

    @Override
    public List<String> startDay() {
        return startDays;
    }

    @Override
    public List<String> startMonth() {
        return startMonths;
    }

    @Override
    public List<String> startYear() {
        return startYears;
    }

    @Override
    public List<String> endDay() {
        return endDays;
    }

    @Override
    public List<String> endMonth() {
        return endMonths;
    }

    @Override
    public List<String> endYear() {
        return endYears;
    }

    @Override
    public Medical findByIdCard(String idCard) {
        Medical medical = null;

        for (Medical item: medicals) {
            if (item.getIdCard().equals(idCard)) {
                medical = new Medical(item.getName(), item.getBirth(), item.getGender(), item.getNationality(), item.getIdCard(), item.getTravel(), item.getVehicle(), item.getSeat(), item.getStartDay(), item.getStartMonth(), item.getStartYear(), item.getEndDay(), item.getEndMonth(), item.getEndYear(), item.getTravelInfo());
            }
        }
        return medical;
    }

    @Override
    public void edit(String idCard, Medical medical) {
        for (Medical item: medicals) {
            if (item.getIdCard().equals(idCard)) {
                item.setName(medical.getName());
                item.setBirth(medical.getBirth());
                item.setGender(medical.getGender());
                item.setNationality(medical.getNationality());
                item.setIdCard(medical.getIdCard());
                item.setTravel(medical.getTravel());
                item.setVehicle(medical.getVehicle());
                item.setSeat(medical.getSeat());
                item.setStartDay(medical.getStartDay());
                item.setStartMonth(medical.getStartMonth());
                item.setStartYear(medical.getStartYear());
                item.setEndDay(medical.getEndDay());
                item.setEndMonth(medical.getEndMonth());
                item.setEndYear(medical.getEndYear());
                item.setTravelInfo(medical.getTravelInfo());
            }
        }
    }

    @Override
    public void save(Medical medical) {
        medicals.add(medical);
    }
}
