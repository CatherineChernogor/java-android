package com.company;

import java.math.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        for (int i = 0; i < 20; i++) {
            int test1 = (int)(Math.random()*20)-10;
            int test2 = (int)(Math.random()*20)-10;
            Robot robot = new Robot(5, -5, Direction.UP);
            moveRobot(robot, test1,  test2);
        }
    }

    public enum Direction {
        UP,
        DOWN,
        LEFT,
        RIGHT
    }

    public static class Robot {
        int x;
        int y;
        Direction dir;

        public Robot(int x, int y, Direction dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }

        public Direction getDirection() {
            return dir;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public void turnLeft() {
            if (dir == Direction.UP) {
                dir = Direction.LEFT;
            } else if (dir == Direction.DOWN) {
                dir = Direction.RIGHT;
            } else if (dir == Direction.LEFT) {
                dir = Direction.DOWN;
            } else if (dir == Direction.RIGHT) {
                dir = Direction.UP;
            }
        }

        public void turnRight() {
            if (dir == Direction.UP) {
                dir = Direction.RIGHT;
            } else if (dir == Direction.DOWN) {
                dir = Direction.LEFT;
            } else if (dir == Direction.LEFT) {
                dir = Direction.UP;
            } else if (dir == Direction.RIGHT) {
                dir = Direction.DOWN;
            }
        }

        public void stepForward() {
            if (dir == Direction.UP) {
                y++;
            }
            if (dir == Direction.DOWN) {
                y--;
            }
            if (dir == Direction.LEFT) {
                x--;
            }
            if (dir == Direction.RIGHT) {
                x++;
            }
        }
    }

    static Robot goForY(Robot robot, int toY) {
        while (true) {
            if (robot.getY() == toY)
                return robot;

            robot.stepForward();
        }
    }

    static Robot goForX(Robot robot, int toX) {
        while (true) {
            if (robot.getX() == toX)
                return robot;

            robot.stepForward();
        }
    }


    static void setUP(Robot robot) {
        while (true) {
            if (robot.getDirection() != Direction.UP) {
                robot.turnRight();
            } else {
                break;
            }
        }
    }

    public static void moveRobot(Robot robot, int toX, int toY) {

        setUP(robot); //made robot to look up

        if (toY > robot.getY()) {
            robot = goForY(robot, toY);

        } else if (toY < robot.getY()) {
            robot.turnRight();
            robot.turnRight();
            robot = goForY(robot, toY);

        }
        setUP(robot); //made robot to look up

        if (toX > robot.getX()) {
            robot.turnRight();
            robot = goForX(robot, toX);

        } else if (toX < robot.getX()) {
            robot.turnLeft();
            robot = goForX(robot, toX);
        }
    }

}
