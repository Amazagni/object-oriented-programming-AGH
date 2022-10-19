package agh.ics.oop;

import java.util.Map;

public class Animal {
    private Vector2d position = new Vector2d(2,2);
    private MapDirection orientation = MapDirection.NORTH;
    public String toString(){
        return "position: " + this.position.toString() + " orientation: " + this.orientation.toString();
    }
    public boolean isAt(Vector2d position){
        return this.position.equals(position);
    }
    public void move(MoveDirection direction){
        switch(direction) {
            case FORWARD:
                switch (this.orientation) {
                    case NORTH:
                        if (this.position.y < 4) {
                            Vector2d tmp = new Vector2d(0, 1);
                            this.position = this.position.add(tmp);
                        }
                        break;
                    case EAST:
                        if (this.position.x < 4) {
                            Vector2d tmp = new Vector2d(1, 0);
                            this.position = this.position.add(tmp);
                        }
                        break;
                    case SOUTH:
                        if (this.position.y > 0) {
                            Vector2d tmp = new Vector2d(0, -1);
                            this.position = this.position.add(tmp);                        }
                        break;
                    case WEST:
                        if (this.position.x > 0) {
                            Vector2d tmp = new Vector2d(-1, 0);
                            this.position = this.position.add(tmp);
                        }
                        break;
                }
                break;
            case BACKWARD:
                switch (this.orientation) {
                    case NORTH:
                        if (this.position.y > 0) {
                            Vector2d tmp = new Vector2d(0, -1);
                            this.position = this.position.add(tmp);
                        }
                        break;
                    case EAST:
                        if (this.position.x > 0) {
                            Vector2d tmp = new Vector2d(-1, 0);
                            this.position = this.position.add(tmp);
                        }
                        break;
                    case SOUTH:
                        if (this.position.y < 4) {
                            Vector2d tmp = new Vector2d(0, 1);
                            this.position = this.position.add(tmp);
                        }
                        break;
                    case WEST:
                        if (this.position.x < 4) {
                            Vector2d tmp = new Vector2d(1, 0);
                            this.position = this.position.add(tmp);
                        }
                        break;
                }
                break;
            case LEFT:
                this.orientation = this.orientation.previous();
                break;
            case RIGHT:
                this.orientation = this.orientation.next();
                break;
        }
    }

}
