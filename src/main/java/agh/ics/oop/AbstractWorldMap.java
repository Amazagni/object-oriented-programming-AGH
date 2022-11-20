package agh.ics.oop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractWorldMap implements IWorldMap, IPositionChangeObserver {
    protected Vector2d lowerLeft;
    protected Vector2d upperRight;
    protected Map<Vector2d,Animal> animals = new HashMap<>();
    protected MapVisualizer toVisualize;
    public MapBoundary border;

    // "rozmiar mapy ma być "nieskończony" (czyli ograniczony tylko możliwościami int-a)"
    // jeśli dobrze rozumiem możemy wyjść poza pierwszą ćwiartkę układu wsp
    public AbstractWorldMap(int top, int right, int bottom, int left) {
        this.lowerLeft = new Vector2d(left,bottom);
        this.upperRight = new Vector2d(right, top);
        this.toVisualize = new MapVisualizer(this);
        this.border = new MapBoundary();
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        Animal toChange = animals.get(oldPosition);
        animals.put(newPosition,toChange);
        border.positionChanged(oldPosition, newPosition);
        animals.remove(oldPosition);
    }

    public boolean place(Animal animal) {
        Vector2d tmp = animal.getPosition();
        if(canMoveTo(tmp)) {
            this.animals.put(tmp,animal);
            animal.addObsrver(this);
            System.out.println(animal);
            this.border.addElement(animal);
            return true;
        }
        else{
            throw new IllegalArgumentException("Position "+ tmp + " is already occupied");
        }
    }
    public boolean canMoveTo(Vector2d position) {
        return !(objectAt(position) instanceof Animal) && this.lowerLeft.precedes(position) && this.upperRight.follows(position);
    }
    public boolean isOccupied(Vector2d position) {
        if(this.animals.get(position) != null) return true;
        return false;
    }
    public Object objectAt(Vector2d position) {
        return this.animals.get(position);
    }
    public abstract Vector2d getLowerLeft();
    public abstract Vector2d getUpperRight();
    public String toString(){
        return this.toVisualize.draw(getLowerLeft(),getUpperRight());
    }
}
