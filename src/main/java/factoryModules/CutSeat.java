package factoryModules;

import com.google.common.eventbus.Subscribe;
import eventBus.EventBusClass;
import objects.ChairInProgress;

import java.util.ArrayList;

public class CutSeat {
    private ArrayList<ChairInProgress> chairsInProgress;

    public CutSeat(){

    }
    public CutSeat(ArrayList<ChairInProgress> chairsInProgress){
        this.chairsInProgress=chairsInProgress;
    }

    @Subscribe
    public void cutTheSeats(){

        for(ChairInProgress c:chairsInProgress){
            if(c.getSeat()==null){
                c.setSeat("Seat successfully assembled");
            }
        }
        EventBusClass.setChairInProgresses(chairsInProgress);
    }
}
