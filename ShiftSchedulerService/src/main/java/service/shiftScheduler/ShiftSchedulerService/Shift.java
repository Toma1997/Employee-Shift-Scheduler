package service.shiftScheduler.ShiftSchedulerService;

import java.util.ArrayList;

public class Shift {

    private int shiftId;
    private String name;
    private int leastPeople, maxPeople;
    private double leastExperience;
    private ArrayList<Integer> employees;

    public Shift() {

    }

    public Shift(int shiftId, String name, int leastPeople, int maxPeople, double leastExperience) {
        this.shiftId = shiftId;
        this.name = name;
        this.leastPeople = leastPeople;
        this.maxPeople = maxPeople;
        this.leastExperience = leastExperience;
        this.employees = new ArrayList<>();
    }

    public int getShiftId() {
        return shiftId;
    }

    public void setShiftId(int shiftId) {
        this.shiftId = shiftId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLeastPeople() {
        return leastPeople;
    }

    public void setLeastPeople(int leastPeople) {
        this.leastPeople = leastPeople;
    }

    public int getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(int maxPeople) {
        this.maxPeople = maxPeople;
    }

    public double getLeastExperience() {
        return leastExperience;
    }

    public void setLeastExperience(double leastExperience) {
        this.leastExperience = leastExperience;
    }

    public ArrayList<Integer> getEmployees() {
        return employees;
    }

    public void setEmployees(ArrayList<Integer> employees) {
        this.employees = employees;
    }
}
