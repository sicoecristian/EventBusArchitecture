import eventBus.EventBusClass;
import factoryModules.*;
import objects.ChairInProgress;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        EventBusClass eventBus = new EventBusClass("eventBus");
        AssemblStabilizerBar assemblStabilizerBar = new AssemblStabilizerBar();
        AssembleFeet assembleFeet = new AssembleFeet();
        PackageChair packageChair = new PackageChair();
        CutSeat cutSeat = new CutSeat();
        AssembleBackrest assembleBackrest = new AssembleBackrest();

        ArrayList<ChairInProgress> chairsInProgress=new  ArrayList<>();
        for(int i=0;i<10;i++){
            ChairInProgress c=new ChairInProgress();
            chairsInProgress.add(c);
        }

        EventBusClass.setChairInProgresses(chairsInProgress);

       // eventBus.register(assembleBackrest);
        eventBus.register(cutSeat);
       // eventBus.register(assembleFeet);
     //   eventBus.register(assemblStabilizerBar);
      //  eventBus.register(packageChair);

        eventBus.post(cutSeat);


    }
}
