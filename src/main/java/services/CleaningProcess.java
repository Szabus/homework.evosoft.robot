package services;

import models.Room;
import models.VacuumCleaner;

public class CleaningProcess {

    public static void run() {

        DataLoader dataLoader = new DataLoader();
        Room room = dataLoader.getRoom1();
        VacuumCleaner vacuumCleaner = new VacuumCleaner(room.getMap());
        Cleaning cleaning = new Cleaning();
        cleaning.cleanAll(vacuumCleaner, room);
    }
}

