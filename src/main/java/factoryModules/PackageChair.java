package factoryModules;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import eventBus.EventBusClass;
import objects.ChairInProgress;
import objects.CompleteChair;

import java.util.ArrayList;

public class PackageChair {
    private ArrayList<ChairInProgress> chairsInProgress;
    private ArrayList<CompleteChair> completedChairs;

    public PackageChair(){

    }
    public PackageChair(ArrayList<ChairInProgress> chairsInProgress){
        this.chairsInProgress=chairsInProgress;
        completedChairs=new ArrayList<CompleteChair>();
    }

    @Subscribe
    public void packageTheChair(){
        int temp[] = new int[chairsInProgress.size()];
        int temmpsize=0;
        for(int i=0;i<chairsInProgress.size();i++){
            ChairInProgress c= chairsInProgress.get(i);
            if(c.getFeet()!=null && c.getStabilizerBar()!=null && c.getSeat()!=null && c.getBackrest()!=null){
                temp[temmpsize]=i;
                temmpsize++;
            }
        }
        for(ChairInProgress c: chairsInProgress){
            if(c.getFeet()!=null && c.getStabilizerBar()!=null && c.getSeat()!=null && c.getBackrest()!=null){
                completedChairs.add(new CompleteChair(c.getSeat(),c.getFeet(),c.getBackrest(),c.getStabilizerBar()));
            }
        }
        for(int i=0;i<temmpsize;i++){
            chairsInProgress.remove(temp[i]);
        }
        EventBusClass.setChairInProgresses(chairsInProgress);
        EventBusClass.setChairs(completedChairs);
        for(CompleteChair cc:completedChairs){
            System.out.println(cc.toString());
        }
    }


}
