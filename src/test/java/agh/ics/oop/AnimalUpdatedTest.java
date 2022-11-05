package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnimalUpdatedTest {
    @Test
    public void orientationTest(){
        // 5x5 map
        RectangularMap map = new RectangularMap(5,5);
        Vector2d startingPosition = new Vector2d(2,2);
        Animal zebra = new Animal(map,startingPosition);
        //turning right
       zebra.move(MoveDirection.RIGHT);
        assertEquals(zebra.getAnimalOrientation(),MapDirection.EAST);
        zebra.move(MoveDirection.RIGHT);
        assertEquals(zebra.getAnimalOrientation(),MapDirection.SOUTH);
        zebra.move(MoveDirection.RIGHT);
        assertEquals(zebra.getAnimalOrientation(),MapDirection.WEST);
        zebra.move(MoveDirection.RIGHT);
        assertEquals(zebra.getAnimalOrientation(),MapDirection.NORTH);
        //turning left
        zebra.move(MoveDirection.LEFT);
        assertEquals(zebra.getAnimalOrientation(),MapDirection.WEST);
        zebra.move(MoveDirection.LEFT);
        assertEquals(zebra.getAnimalOrientation(),MapDirection.SOUTH);
        zebra.move(MoveDirection.LEFT);
        assertEquals(zebra.getAnimalOrientation(),MapDirection.EAST);
        zebra.move(MoveDirection.LEFT);
        assertEquals(zebra.getAnimalOrientation(),MapDirection.NORTH);
    }
    @Test
    public void moveTest(){
    RectangularMap map = new RectangularMap(5,5);
    Vector2d startingPosition = new Vector2d(2,2);
    Animal zebra = new Animal(map, startingPosition);
    Vector2d tmp = new Vector2d(2,3);
    zebra.move(MoveDirection.FORWARD);
    assertEquals(zebra.getPosition(),tmp);
    zebra.move(MoveDirection.BACKWARD);
    tmp = new Vector2d(2,2);
    assertEquals(zebra.getPosition(),tmp);
    zebra.move(MoveDirection.RIGHT);
    zebra.move(MoveDirection.FORWARD);
    tmp = new Vector2d(3,2);
    assertEquals(zebra.getPosition(),tmp);
    zebra.move(MoveDirection.BACKWARD);
    tmp = new Vector2d(2,2);
    assertEquals(zebra.getPosition(),tmp);
    }
    @Test
    public void borderTest(){
        RectangularMap map = new RectangularMap(5,5);
        Vector2d startingPosition = new Vector2d(2,2);
        Animal zebra = new Animal(map, startingPosition);
        Vector2d tmp = new Vector2d(2,4);
        zebra.move(MoveDirection.FORWARD);
        zebra.move(MoveDirection.FORWARD);
        zebra.move(MoveDirection.FORWARD);
        assertEquals(zebra.getPosition(),tmp);
        zebra.move(MoveDirection.BACKWARD);
        zebra.move(MoveDirection.BACKWARD);
        zebra.move(MoveDirection.BACKWARD);
        zebra.move(MoveDirection.BACKWARD);
        zebra.move(MoveDirection.BACKWARD);
        tmp = new Vector2d(2,0);
        assertEquals(zebra.getPosition(),tmp);
        zebra.move(MoveDirection.RIGHT);
        zebra.move(MoveDirection.BACKWARD);
        zebra.move(MoveDirection.BACKWARD);
        zebra.move(MoveDirection.BACKWARD);
        tmp = new Vector2d(0,0);
        assertEquals(zebra.getPosition(),tmp);
        zebra.move(MoveDirection.FORWARD);
        zebra.move(MoveDirection.FORWARD);
        zebra.move(MoveDirection.FORWARD);
        zebra.move(MoveDirection.FORWARD);
        zebra.move(MoveDirection.FORWARD);
        tmp = new Vector2d(4,0);
        assertEquals(zebra.getPosition(),tmp);
    }

    //test copied from lab3
    @Test
    public void parserTest(){
        OptionsParser tmp = new OptionsParser();
        //all possibilities with some random exapmles :)
        String[] first = {"programowanie","f","w","javie","forward","jest","b","backward","przyjemne",":)","r","right","l","left"};
        MoveDirection[] second = {MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.BACKWARD,
                MoveDirection.BACKWARD, MoveDirection.RIGHT, MoveDirection.RIGHT, MoveDirection.LEFT, MoveDirection.LEFT};
        assertArrayEquals(tmp.parse(first),second);
    }
    @Test
    public void simulationTest(){

        // movement, directions, borders

        IWorldMap map = new RectangularMap(5,5);
        String[] commandsString = {"f", "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f"};
        MoveDirection[] commands = new OptionsParser().parse(commandsString);
        Vector2d position1 = new Vector2d(2,2);
        Vector2d position2 = new Vector2d(1,1);
        Vector2d[] startingPositions = {position1,position2};
        SimulationEngine engine = new SimulationEngine(commands,map,startingPositions);
        engine.run();

        assertEquals(engine.getAnimal(0).getAnimalOrientation(),MapDirection.SOUTH);
        assertEquals(engine.getAnimal(0).getPosition(),new Vector2d(3,0));

        assertEquals(engine.getAnimal(1).getAnimalOrientation(),MapDirection.NORTH);
        assertEquals(engine.getAnimal(1).getPosition(),new Vector2d(0,4));

        // collisions
        String[] commandsString2 = {"f","b"};
        MoveDirection[] commands2 = new OptionsParser().parse(commandsString2);
        Vector2d position3 = new Vector2d(2,2);
        Vector2d position4 = new Vector2d(2,3);
        Vector2d[] startingPositions2 = {position3, position4};
        SimulationEngine engine2 = new SimulationEngine(commands2,map,startingPositions2);
        engine2.run();

        assertEquals(engine2.getAnimal(0).getPosition(), new Vector2d(2,2));
        assertEquals(engine2.getAnimal(0).getAnimalOrientation(), MapDirection.NORTH);
        assertEquals(engine2.getAnimal(1).getPosition(), new Vector2d(2,3));
        assertEquals(engine2.getAnimal(1).getAnimalOrientation(), MapDirection.NORTH);




    }
}