package models;

import java.util.HashSet;
import java.util.Set;

public class VacuumCleaner {

    private long serialNumber;
    private boolean move;
    //UP, RIGHT, DOWN, LEFT
    private final int[][] moving = {{-1, 0}, {0, 1}, {1, 0}, {0, 1}};
    private Direction direction;
    private int[][] roomMap;
    private Set<String> isAlreadyCleaned = new HashSet<>();

    public VacuumCleaner() {
    }

    public VacuumCleaner(int[][] roomMap) {
        this.roomMap = roomMap;
    }

    public long getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(long serialNumber) {
        this.serialNumber = serialNumber;
    }

    public boolean isMove(int row, int col, int height, int weight, int[][] map) {
        return height > row && weight > col && col >= 0 && row >= 0 && map[row][col] != 1;
    }

    public void setMove(boolean move) {
        this.move = move;
    }

    public int[][] getMoving() {
        return moving;
    }


    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public Set<String> getIsAlreadyCleaned() {
        return isAlreadyCleaned;
    }

    public void setIsAlreadyCleaned(Set<String> isAlreadyCleaned) {
        this.isAlreadyCleaned = isAlreadyCleaned;
    }

    public int[][] getRoomMap() {
        return roomMap;
    }

    public void setRoomMap(int[][] roomMap) {
        this.roomMap = roomMap;
    }

    public void cleanPieces(int row, int col) {
        if (getRoomMap()[row][col] != 1) {
            getRoomMap()[row][col] = 2;
        }
    }
}


