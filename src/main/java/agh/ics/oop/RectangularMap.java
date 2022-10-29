package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class RectangularMap implements IWorldMap{
    private Vector2d lowerLeft;
    private Vector2d upperRight;
    private List<Animal> animals;
    private MapVisualizer toVisualize;

    public RectangularMap(int width, int height){
        this.lowerLeft = new Vector2d(0,0);
        this.upperRight = new Vector2d(height-1,width-1);
        this.animals = new ArrayList<>();
        this.toVisualize = new MapVisualizer(this);
    }

    @Override
    public boolean place(Animal animal) {
        if(isOccupied(animal.getAnimalPosition()))
            return false;
        else{
            this.animals.add(animal);
            return true;
        }
    }
    @Override
    public boolean canMoveTo(Vector2d position) {
        return !isOccupied(position) && this.lowerLeft.precedes(position) && this.upperRight.follows(position);
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        for(Animal animal:animals){
            if(animal.getAnimalPosition().equals(position))return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return toVisualize.draw(this.lowerLeft,this.upperRight);
    }

    @Override
    public Object objectAt(Vector2d position) {
        for(Animal animal:animals){
            if(animal.getAnimalPosition().equals(position))return animal;
        }
        return null;
    }
}
