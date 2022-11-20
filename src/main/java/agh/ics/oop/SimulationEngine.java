package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class SimulationEngine implements IEngine{
    private final MoveDirection[] moves;
    private final List<Animal> animals;
    private final IWorldMap map;
    public SimulationEngine(MoveDirection[] movess, IWorldMap map,Vector2d[] startingPositions){
        this.moves = movess;
        this.animals = new ArrayList<>();
        this.map = map;

        for(Vector2d position: startingPositions){
            Animal tmp = new Animal(this.map,position);
            if(this.map.place(tmp)){animals.add(tmp);}
    }
    }

    public Animal getAnimal(int i){
        return this.animals.get(i);
    }

    @Override
    public void run() {
        int length = this.animals.size();
        int i = 0;
        for(MoveDirection move:this.moves){
            i = i%length;
            this.animals.get(i).move(move);
            i += 1;
        }
    }
}
