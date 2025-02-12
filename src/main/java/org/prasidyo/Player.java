package org.prasidyo;

public class Player {

    private String name;

    private int position = 0;

    public Player(String name) {
        this.name = name;
    }

    public Player(String name,
                  int position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

}
