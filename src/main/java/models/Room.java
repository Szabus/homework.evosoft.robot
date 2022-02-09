package models;

public class Room {

    private int height;
    private int weight;
    private int squareMeter;
    private boolean isClean;

    private int[][] map;

    public Room() {
    }

    public Room(int height, int weight, int[][] map) {
        this.height = height;
        this.weight = weight;
        this.squareMeter = setSquareMeter();
        this.map = map;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getSquareMeter() {
        return squareMeter;
    }

    public int setSquareMeter() {
        return this.squareMeter = this.height * this.weight;
    }

    public void setSquareMeter(int squareMeter) {
        this.squareMeter = squareMeter;
    }

    public boolean isClean() {
        return isClean;
    }

    public void setClean(boolean clean) {
        isClean = clean;
    }

    public int[][] getMap() {
        return map;
    }

    public int[][] setMap(int[][] map) {
        return this.map = map;
    }
}
