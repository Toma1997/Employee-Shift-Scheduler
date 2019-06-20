package service.shiftScheduler.ShiftSchedulerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ShiftServiceController {

    @Autowired
    ShiftDAOService service;

    //localhost:1313/all-shifts
    @GetMapping("/all-shifts")
    public List<Shift> retrieveAllShifts(){
        return service.getAllShifts();
    }

    // example -> localhost:1313/all-shifts/2
    @GetMapping("/all-shifts/{id}")
    public Shift retrieveShift(@PathVariable int id){
        return service.findShift(id);
    }

    //localhost:1313/number-of-shifts
    @GetMapping("/number-of-shifts")
    public int shiftsCount(){
        return service.getNumberOfShifts();
    }



}
