package factoryModules;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import eventBus.EventBusClass;
import objects.ChairInProgress;

import java.util.ArrayList;

public class AssembleBackrest {
    private ArrayList<ChairInProgress> chairsInProgress;

    public AssembleBackrest(){

    }
    public AssembleBackrest(ArrayList<ChairInProgress> chairsInProgress){
        this.chairsInProgress=chairsInProgress;
    }

    @Subscribe
    public void assembleTheFeet(){
        for(ChairInProgress c:chairsInProgress){
            if(c.getSeat()!=null && c.getBackrest()==null){
                c.setSeat("Backrest successfully assembled");
            }
        }
        EventBusClass.setChairInProgresses(chairsInProgress);
    }
}
