package org.prasidyo;

import java.util.Arrays;
import java.util.Objects;

public class Validation {

    public static boolean invalidSnakePosition(int headPosition, int tailPosition, int numberOfCells){
        if(headPosition == numberOfCells){
            System.out.println("There won’t be a snake at position " + headPosition);
            pleaseRetype();
            return true;
        }

        if(headPosition <= tailPosition){
            System.out.println("Snake head must be higher than tail");
            pleaseRetype();
            return true;
        }
        return false;
    }

    public static boolean snakeHeadExists(Snake snake){
        if(snake != null){
            System.out.println("There is already a snake head at position " + snake.getHead());
            pleaseRetype();
            return true;
        }
        return false;
    }

    public static boolean ladderStartExists(Ladder ladder){
        if(ladder != null){
            System.out.println("There is already a ladder start at position " + ladder.getStart());
            pleaseRetype();
            return true;
        }
        return false;
    }

    public static boolean invalidLadderPosition(int start, int end){
        if(start >= end){
            System.out.println("Ladder start must be lower than end");
            pleaseRetype();
            return true;
        }
        return false;
    }

    public static boolean outOfBoundPosition(int position, int numberOfCells){
        if(position < 1 || position > numberOfCells){
            System.out.println("Out of bound position! Can't be less than 1 or greater than " + numberOfCells);
            return true;
        }
        return false;
    }

    public static boolean infiniteLoop(int startPosition, int endPosition, Cell[] cells){
        int newPosition = endPosition;
        boolean infiniteLoop = false;

        while(true){
            Cell cell = cells[newPosition];

            if(startPosition == newPosition){
                System.out.println("Snakes and Ladders do not form an infinite loop!");
                pleaseRetype();
                infiniteLoop = true;
                break;
            }

            if(cell.getSnake() != null){
                newPosition = cell.getSnake().getTail();
            } else if(cell.getLadder() != null){
                newPosition = cell.getLadder().getEnd();
            } else {
                break;
            }
        }
        return infiniteLoop;
    }

    public static boolean existsName(String name, Player[] players){
        boolean foundName = Arrays.stream(players).filter(Objects::nonNull).anyMatch(o -> o.getName().equals(name));

        if(foundName){
            System.out.println("Name can't be the same as another player!");
            pleaseRetype();
            return true;
        }
        return false;
    }

    private static void pleaseRetype(){
        System.out.println("Please retype: ");
    }

}
