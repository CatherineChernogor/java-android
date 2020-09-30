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
