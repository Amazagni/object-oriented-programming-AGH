package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Animal extends AbstractWorldMapElement {
    private MapDirection direction = MapDirection.NORTH;
    private List<IPositionChangeObserver> observers;

    public String toString(){
        return switch (this.direction){
            case NORTH -> "N";
            case SOUTH -> "S";
            case EAST -> "E";
            case WEST -> "W";
        };
    }
    private IWorldMap map;
    public Animal(IWorldMap map, Vector2d initialPosition){
        super(initialPosition);
        this.map = map;
        this.observers = new ArrayList<>();
    }
    void addObsrver(IPositionChangeObserver observer){
        this.observers.add(observer);
    };
    void removeObserver(IPositionChangeObserver observer){
        this.observers.remove(observer);
    };
    void positionChanged(Vector2d newPosition){
        for(IPositionChangeObserver observer: observers){
            observer.positionChanged(this.position,newPosition);
        }

    }
    public boolean isAt(Vector2d position){
        return this.position.equals(position);
    }

    public MapDirection getAnimalOrientation(){
        return this.direction;
    }

    public void move(MoveDirection direction){
        switch(direction){
            case FORWARD:

                Vector2d tmp = this.direction.toUnitVector();
                tmp = tmp.add(this.position);
                if (this.map.canMoveTo(tmp)){
                    positionChanged(tmp);
                    this.position = tmp;
                }
                break;
            case BACKWARD:
                MapDirection toTurn = this.direction.next();
                toTurn = toTurn.next();
                Vector2d tmp2 = toTurn.toUnitVector();
                tmp2 = tmp2.add(this.position);
                if(this.map.canMoveTo(tmp2)){
                    positionChanged(tmp2);
                    this.position = tmp2;
                }

                break;
            case LEFT:
                this.direction = this.direction.previous();
                break;
            case RIGHT:
                this.direction = this.direction.next();
                break;

        }
    }
}
