package agh.ics.oop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.Math.random;
import static java.lang.Math.sqrt;

public class GrassField extends AbstractWorldMap {

    private final Map<Vector2d,Grass> clumpsOfGrass;
    private final int maxRange;
    public GrassField(int quantity){
        super(Integer.MAX_VALUE,Integer.MAX_VALUE,-Integer.MAX_VALUE,-Integer.MAX_VALUE);
        this.clumpsOfGrass = new HashMap<>();
        this.maxRange = (int)(sqrt(quantity * 10));
        this.border = new MapBoundary();
        for(int i = 0; i < quantity; i ++){
            plantTheGrass();
        }
    }
    public Vector2d getLowerLeft(){
       return border.getLowerLeft();
    }

    public Vector2d getUpperRight(){
        return border.getUpperRight();
    }

    @Override
    public Object objectAt(Vector2d position) {
        if (super.objectAt(position) == null){
            return this.clumpsOfGrass.get(position);
        }
        else{
            return super.objectAt(position);
        }
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        if(super.isOccupied(position)) return true;
        if(this.clumpsOfGrass.get(position) != null)return true;
        return false;
    }

    //Przesadzenie trawy w inne miejsce (jesli zwierze na zamiar na nim stanąć)
    @Override
    public boolean canMoveTo(Vector2d position) {
        if(super.canMoveTo(position)){
            Object tmp = objectAt(position);
            if(tmp instanceof Grass){
                clumpsOfGrass.remove(tmp);
                plantTheGrass();
            }
            return true;
        }
        else{
            return false;
        }
    }

    public void plantTheGrass(){
        int x = (int)(random() * this.maxRange);
        int y = (int)(random() * this.maxRange);
        Vector2d tmp = new Vector2d(x,y);
        while(isOccupied(tmp)){
            x = (int)(random() * this.maxRange);
            y = (int)(random() * this.maxRange);
            tmp = new Vector2d(x,y);
        }
        this.clumpsOfGrass.put(tmp,new Grass(tmp));
        border.addElement(new Grass(tmp));

    }
    // funkcja stworzona na potrzeby testow
    public void plantTheGrassAt(Vector2d position){
        if(!isOccupied(position)){
            this.clumpsOfGrass.put(position,new Grass(position));
            this.border.addElement(new Grass(position));
        }
    }

}
