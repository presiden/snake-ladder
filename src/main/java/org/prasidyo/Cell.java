package org.prasidyo;

public class Cell {

    private Snake snake;

    private Ladder ladder;

    public Cell(){}

    public Cell (Snake snake){
        this.snake = snake;
    }

    public Cell(Ladder ladder){
        this.ladder = ladder;
    }

    public Snake getSnake() {
        return snake;
    }

    public void setSnake(Snake snake) {
        this.snake = snake;
    }

    public Ladder getLadder() {
        return ladder;
    }

    public void setLadder(Ladder ladder) {
        this.ladder = ladder;
    }
}
