package services;

import models.Direction;
import models.Room;
import models.VacuumCleaner;

public class Cleaning {

    public Cleaning() {
    }

    public void cleanAll(VacuumCleaner vacuumCleaner, Room room) {
        vacuumCleaner.setMove(true);
        moveRobot(0, 0, vacuumCleaner, room, 0);
    }

    private void moveRobot(int row, int col, VacuumCleaner vacuumCleaner, Room room, int arrow) {
        String key = row + " " + col;

        if (!vacuumCleaner.getIsAlreadyCleaned().contains(key)
                && vacuumCleaner.isMove(row, col, room.getHeight(), room.getWeight(), vacuumCleaner.getRoomMap())) {

            vacuumCleaner.getIsAlreadyCleaned().add(key);

            vacuumCleaner.cleanPieces(row, col);

            for (int i = 0; i < 4; i++) {
                if (vacuumCleaner.isMove(row, col, room.getHeight(), room.getWeight(), vacuumCleaner.getRoomMap())) {
                    int[] currentDirection = vacuumCleaner.getMoving()[arrow];
                    moveRobot(row + currentDirection[0],
                            col + currentDirection[1],
                            vacuumCleaner,
                            room,
                            arrow);
                    if (room.isClean()) {
                        break;
                    }
                    vacuumCleaner.setDirection(Direction.RIGHT);
                    arrow = (arrow + 1) % 4;
                }
            }
        }
        moveBack(vacuumCleaner);
        finishedCleaning(vacuumCleaner, room);
    }

    private void moveBack(VacuumCleaner vacuumCleaner) {
        vacuumCleaner.setDirection(Direction.BACK);
    }

    private void finishedCleaning(VacuumCleaner vacuumCleaner, Room room) {
        int squareMeter = room.getSquareMeter();
        int notCleanableSum = notCleanableSpace(room.getMap());
        int cleanableSpace = squareMeter - notCleanableSum;

        if (cleanableSpace == vacuumCleaner.getIsAlreadyCleaned().size()) {
            room.setClean(true);
        }
    }

    private int notCleanableSpace(int[][] map) {
        int counter = 0;

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == 1) {
                    counter++;
                }
            }
        }
        return counter;
    }
}
