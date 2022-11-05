package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractWorldMap implements IWorldMap {
    protected Vector2d lowerLeft;
    protected Vector2d upperRight;
    protected List<Animal> animals = new ArrayList<>();
    protected MapVisualizer toVisualize;

    // "rozmiar mapy ma być "nieskończony" (czyli ograniczony tylko możliwościami int-a)"
    // jeśli dobrze rozumiem możemy wyjść poza pierwszą ćwiartkę układu wsp
    public AbstractWorldMap(int top, int right, int bottom, int left) {
        this.lowerLeft = new Vector2d(left,bottom);
        this.upperRight = new Vector2d(right, top);
        this.toVisualize = new MapVisualizer(this);
    }
    public boolean place(Animal animal) {
        if(canMoveTo(animal.getPosition())) {
            this.animals.add(animal);

            return true;
        }
        else{
            return false;
        }
    }
    public boolean canMoveTo(Vector2d position) {
        return !(objectAt(position) instanceof Animal) && this.lowerLeft.precedes(position) && this.upperRight.follows(position);
    }
    public boolean isOccupied(Vector2d position) {
        for(Animal animal:animals){
            if(animal.getPosition().equals(position))return true;
        }
        return false;
    }
    public Object objectAt(Vector2d position) {
        for(Animal animal:animals){
            if(animal.isAt(position))return animal;
        }
        return null;
    }
    abstract Vector2d getLowerLeft();
    abstract Vector2d getUpperRight();
    public String toString(){
        return this.toVisualize.draw(getLowerLeft(),getUpperRight());
    }
}
