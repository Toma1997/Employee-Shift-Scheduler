package service.shiftScheduler.ShiftSchedulerService;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ShiftDAOService {
    private static int shiftCount = 4;
    private static List<Shift> shifts = new ArrayList<>();

    static {
        Shift shift1 = new Shift();
        shifts.add(shift1);

        Shift shift2 = new Shift();
        shifts.add(shift2);

        Shift shift3 = new Shift();
        shifts.add(shift3);

        Shift shift4 = new Shift();
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

    public int getNumberOfShifts(){
        return shiftCount;
    }

}
