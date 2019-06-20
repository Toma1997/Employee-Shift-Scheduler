package service.shiftScheduler.ShiftSchedulerService;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ShiftDAOService {
    private static int shiftCount = 4;
    private static List<Shift> shifts = new ArrayList<>();

    static {
        Shift shift1 = new Shift(1, "morning", 2, 4, 2);
        shifts.add(shift1);

        Shift shift2 = new Shift(2, "day", 2, 4, 1);
        shifts.add(shift2);

        Shift shift3 = new Shift(3, "afternoon", 3, 5, 3);
        shifts.add(shift3);

        Shift shift4 = new Shift(4, "night", 2, 5, 4);
        shifts.add(shift4);
    }

    public List<Shift> getAllShifts(){
        return shifts;
    }

    public Shift findShift(int id){
        for(Shift shift: shifts){
            if(shift.getShiftId() == id){
                return shift;
            }
        }
        return null;
    }

    public Shift setEmployeesToShift(int id, ArrayList<Integer> employees){
        for(Shift shift: shifts){
            if(shift.getShiftId() == id){
                shift.setEmployees(employees);
                return shift;
            }
        }
        return null;
    }

    public int getNumberOfShifts(){
        return shiftCount;
    }

}
