package org.example.springmvc.model.bai4;

public class MedicalDeclaration {
    private String name;
    private int age;
    private String gender;
    private long cmnd;
    private String travelInformation;
    private int vehicleNumber;
    private int startDate;
    private int endDate;
    private String province;

    public MedicalDeclaration() {
    }

    public MedicalDeclaration(String name, int age, String gender, long cmnd, String travelInformation, int vehicleNumber, int startDate, int endDate, String province) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.cmnd = cmnd;
        this.travelInformation = travelInformation;
        this.vehicleNumber = vehicleNumber;
        this.startDate = startDate;
        this.endDate = endDate;
        this.province = province;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public long getCmnd() {
        return cmnd;
    }

    public void setCmnd(long cmnd) {
        this.cmnd = cmnd;
    }

    public String getTravelInformation() {
        return travelInformation;
    }

    public void setTravelInformation(String travelInformation) {
        this.travelInformation = travelInformation;
    }

    public int getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(int vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public int getStartDate() {
        return startDate;
    }

    public void setStartDate(int startDate) {
        this.startDate = startDate;
    }

    public int getEndDate() {
        return endDate;
    }

    public void setEndDate(int endDate) {
        this.endDate = endDate;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }
}