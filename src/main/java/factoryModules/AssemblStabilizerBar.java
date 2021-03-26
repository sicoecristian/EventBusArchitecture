package factoryModules;

import com.google.common.eventbus.Subscribe;
import eventBus.EventBusClass;
import objects.ChairInProgress;

import java.util.ArrayList;

public class AssemblStabilizerBar {
    private ArrayList<ChairInProgress> chairsInProgress;

    public AssemblStabilizerBar(){

    }
    public AssemblStabilizerBar(ArrayList<ChairInProgress> chairsInProgress){
        this.chairsInProgress=chairsInProgress;
    }

    @Subscribe
    public void assembleTheFeet(){
        for(ChairInProgress c:chairsInProgress){
            if(c.getFeet()!=null && c.getStabilizerBar()==null){
                c.setSeat("Stabilizer bar successfully assembled");
            }
        }
        EventBusClass.setChairInProgresses(chairsInProgress);
    }
}
