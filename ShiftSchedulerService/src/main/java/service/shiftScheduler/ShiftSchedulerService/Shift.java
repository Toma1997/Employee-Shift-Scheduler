package service.shiftScheduler.ShiftSchedulerService;

public class Shift {

    private int shiftId;
    private String name;
    private int startTime, endTime;
    private int leastPeople, maxPeople;
    private double leastExperience;

    public Shift() {

    }

    public Shift(int shiftId, String name, int startTime, int endTime, int leastPeople, int maxPeople, double leastExperience) {
        this.shiftId = shiftId;
        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
        this.leastPeople = leastPeople;
        this.maxPeople = maxPeople;
        this.leastExperience = leastExperience;
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

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
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

}
