package services;

import models.Room;

public class DataLoader {

    public DataLoader() {
        getRoom1();
    }
    public Room getRoom1() {

        int[][] map = {
                {0, 0, 1, 0},
                {0, 0, 0, 0},
                {0, 0, 1, 0},
                {0, 1, 0, 0},
                {0, 1, 1, 0},
                {0, 0, 1, 0},
                {1, 0, 0, 0},
                {1, 1, 1, 0}
        };
        return new Room(8, 4, map);
    }
}
