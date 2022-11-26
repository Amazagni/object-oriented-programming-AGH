package agh.ics.oop;

import agh.ics.oop.gui.IAppObserver;

import java.util.ArrayList;
import java.util.List;

public class SimulationEngine implements IEngine,Runnable{
    private MoveDirection[] moves;
    private final List<Animal> animals;
    private List<IAppObserver> observers = new ArrayList<>();
    private final IWorldMap map;
    private int moveDelay;
    public SimulationEngine(IWorldMap map,Vector2d[] startingPositions){
        this.animals = new ArrayList<>();
        this.map = map;

        for(Vector2d position: startingPositions){
            Animal tmp = new Animal(this.map,position);
            if(this.map.place(tmp)){animals.add(tmp);}
        }
    }
    public void setDirections(MoveDirection[] directions){
            this.moves = directions;
    }
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
            //informujemy app o zmianie pozycji
            for(IAppObserver observer: this.observers){
                observer.positionChanged();
            }
            try{
            Thread.sleep(this.moveDelay);
            }
            catch(InterruptedException a){
                System.out.println("Przerwano symulacje: "+ a);

            }

        }
    }

    @Override
    public void addObserver(IAppObserver observer){
        this.observers.add(observer);
    }

    @Override
    public void setDelay(int delay) {
        this.moveDelay = delay;

    }

}
