package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.random;
import static java.lang.Math.sqrt;

public class GrassField extends AbstractWorldMap {

    private final List<Grass> clumpsOfGrass;
    private final int maxRange;
    public GrassField(int quantity){
        super(Integer.MAX_VALUE,Integer.MAX_VALUE,-Integer.MAX_VALUE,-Integer.MAX_VALUE);
        this.clumpsOfGrass = new ArrayList<>();
        this.maxRange = (int)(sqrt(quantity * 10));
        for(int i = 0; i < quantity; i ++){
            plantTheGrass();
        }
    }
    public Vector2d getLowerLeft(){
        Vector2d tmp = new Vector2d(Integer.MAX_VALUE - 1,Integer.MAX_VALUE - 1);
        for(Grass clumpOfGrass: clumpsOfGrass){
            tmp = tmp.lowerLeft(clumpOfGrass.getPosition());
        }
        for(Vector2d position: animals.keySet()){
            tmp = tmp.lowerLeft(position);
        }
        return tmp;
    }

    public Vector2d getUpperRight(){
        Vector2d tmp = new Vector2d(0,0);
        for(Grass clumpOfGrass: clumpsOfGrass){
            tmp = tmp.upperRight(clumpOfGrass.getPosition());
        }
        for(Vector2d position: animals.keySet()){
            tmp = tmp.upperRight(position);
        }
        return tmp;
    }

    @Override
    public Object objectAt(Vector2d position) {
        if (super.objectAt(position) == null){
            for(Grass clumpOfGrass: clumpsOfGrass){
                if(clumpOfGrass.getPosition().equals(position))return clumpOfGrass;
            }
            return null;
        }
        else{
            return super.objectAt(position);
        }
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        if(super.isOccupied(position)) return true;
        for(Grass clumpOfGrass: clumpsOfGrass){
            if(clumpOfGrass.getPosition().equals(position)){
                return true;
            }
        }
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
        this.clumpsOfGrass.add(new Grass(tmp));
    }
    // funkcja stworzona na potzreby testow
    public void plantTheGrassAt(Vector2d position){
        if(!isOccupied(position)){
            this.clumpsOfGrass.add(new Grass(position));
        }
    }

}
