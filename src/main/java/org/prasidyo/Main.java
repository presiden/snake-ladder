package org.prasidyo;

import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static final int numberOfCells = 100;
    private static final Cell[] cells = new Cell[numberOfCells + 1];
//    private static Player[] players;

    public static void main(String[] args) {
        start();
    }

    private static void start(){
        Dice dice = new Dice();
//        Cell[] cells = new Cell[numberOfCells + 1];

        initCell();
        addSnake();
        addLadder();

        Player[] players = addPlayer();

        for(int x = 0; x < players.length; x++){
            Player player = players[x];
            int diceNumber = dice.roll();
            int currentPosition = player.getPosition();
            int newPosition = getNextPosition(currentPosition, diceNumber);
            player.setPosition(newPosition);

            System.out.println(player.getName() + " rolled a " + diceNumber + " and moved from " + currentPosition + " to " + newPosition);

            if(newPosition == numberOfCells){
                System.out.println("***** Player " + player.getName() + " WIN!!! *****");
                break;
            } else if(x == players.length - 1){
                x = -1;
            }
        }

        scanner.close();
    }

    private static void initCell(){
        for(int x = 0; x <= numberOfCells; x++){
            cells[x] = new Cell();
        }
    }

    private static void addSnake(){
        System.out.print("Enter number of snakes in the board: ");
        int numberOfSnakes = scanner.nextInt();

        for(int x = 0; x < numberOfSnakes; x++){
            int head = scanner.nextInt();
            int tail = scanner.nextInt();

            boolean isInvalid = Validation.outOfBoundPosition(head, numberOfCells) ||
                                Validation.outOfBoundPosition(tail, numberOfCells) ||
                                Validation.snakeHeadExists(cells[head].getSnake()) ||
                                Validation.invalidSnakePosition(head, tail, numberOfCells);
            if (isInvalid) {
                x--;
                continue;
            }

            Cell cell = cells[head];
            cell.setSnake(new Snake(head, tail));
        }
    }

    private static void addLadder(){
        System.out.print("Enter number of ladders in the board: ");
        int numberOfLadders = scanner.nextInt();

        for(int x = 0; x < numberOfLadders; x++){
            int start = scanner.nextInt();
            int end = scanner.nextInt();

            boolean isInvalid = Validation.outOfBoundPosition(start, numberOfCells) ||
                                Validation.outOfBoundPosition(end, numberOfCells) ||
                                Validation.infiniteLoop(start, end, cells) ||
                                Validation.ladderStartExists(cells[start].getLadder()) ||
                                Validation.invalidLadderPosition(start, end) ||
                                Validation.snakeHeadExists(cells[start].getSnake());
            if (isInvalid) {
                x--;
                continue;
            }

            Cell cell = cells[start];
            cell.setLadder(new Ladder(start, end));
        }
    }

    private static Player[] addPlayer(){
        System.out.print("Enter number of players: ");
        int numberOfPlayers = scanner.nextInt();
        Player[] players = new Player[numberOfPlayers];

        for(int x = 0; x < numberOfPlayers; x++){
            String name = scanner.next();
            if(Validation.existsName(name, players)){
                x--;
                continue;
            }

            Player player = new Player(name);
            players[x] = player;
        }
        return players;
    }

    private static int getNextPosition(int currentPosition, int diceNumber){
        int nextPosition = currentPosition + diceNumber;
        if (nextPosition == numberOfCells) {
            return nextPosition;
        } else if(nextPosition > numberOfCells){
            return currentPosition;
        }

        while(true){
            Cell cell = cells[nextPosition];

            if(cell.getSnake() != null){
                nextPosition = cell.getSnake().getTail();
            } else if(cell.getLadder() != null){
                nextPosition = cell.getLadder().getEnd();
            } else {
                break;
            }
        }

        return nextPosition;
    }

}