package factoryModules;

import com.google.common.eventbus.Subscribe;
import eventBus.EventBusClass;
import objects.ChairInProgress;

import java.util.ArrayList;

public class AssembleFeet {
    private ArrayList<ChairInProgress> chairsInProgress;

    public AssembleFeet(){

    }
    public AssembleFeet(ArrayList<ChairInProgress> chairsInProgress){
        this.chairsInProgress=chairsInProgress;
    }

    @Subscribe
    public void assembleTheFeet(){
        for(ChairInProgress c:chairsInProgress){
            if(c.getSeat()!=null && c.getFeet()==null){
                c.setSeat("Feet successfully assembled");
            }
        }
        EventBusClass.setChairInProgresses(chairsInProgress);
    }
}
