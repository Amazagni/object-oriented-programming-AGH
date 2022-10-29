package agh.ics.oop;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
/*
class AnimalTest {
    @Test
    public void orientationTest(){
        Animal zebra = new Animal();
        zebra.move(MoveDirection.LEFT);
        assertEquals(zebra.getAnimalOrientation(),MapDirection.WEST);
        zebra.move(MoveDirection.LEFT);
        assertEquals(zebra.getAnimalOrientation(),MapDirection.SOUTH);
        zebra.move(MoveDirection.LEFT);
        assertEquals(zebra.getAnimalOrientation(),MapDirection.EAST);
        zebra.move(MoveDirection.LEFT);
        assertEquals(zebra.getAnimalOrientation(),MapDirection.NORTH);
        zebra.move(MoveDirection.RIGHT);
        assertEquals(zebra.getAnimalOrientation(),MapDirection.EAST);
        zebra.move(MoveDirection.RIGHT);
        assertEquals(zebra.getAnimalOrientation(),MapDirection.SOUTH);
        zebra.move(MoveDirection.RIGHT);
        assertEquals(zebra.getAnimalOrientation(),MapDirection.WEST);
        zebra.move(MoveDirection.RIGHT);
        assertEquals(zebra.getAnimalOrientation(),MapDirection.NORTH);
    }

    @Test
    public void moveTest(){
        Animal zebra = new Animal();
        Vector2d tmp = new Vector2d(2,3);
        zebra.move(MoveDirection.FORWARD);
        assertEquals(zebra.getAnimalPosition(),tmp);
        zebra.move(MoveDirection.BACKWARD);
        tmp = new Vector2d(2,2);
        assertEquals(zebra.getAnimalPosition(),tmp);
        zebra.move(MoveDirection.RIGHT);
        zebra.move(MoveDirection.FORWARD);
        tmp = new Vector2d(3,2);
        assertEquals(zebra.getAnimalPosition(),tmp);
        zebra.move(MoveDirection.BACKWARD);
        tmp = new Vector2d(2,2);
        assertEquals(zebra.getAnimalPosition(),tmp);

    }
    @Test
    public void borderTest(){
        Animal zebra = new Animal();
        Vector2d tmp = new Vector2d(2,4);
        zebra.move(MoveDirection.FORWARD);
        zebra.move(MoveDirection.FORWARD);
        zebra.move(MoveDirection.FORWARD);
        assertEquals(zebra.getAnimalPosition(),tmp);
        zebra.move(MoveDirection.BACKWARD);
        zebra.move(MoveDirection.BACKWARD);
        zebra.move(MoveDirection.BACKWARD);
        zebra.move(MoveDirection.BACKWARD);
        zebra.move(MoveDirection.BACKWARD);
        tmp = new Vector2d(2,0);
        assertEquals(zebra.getAnimalPosition(),tmp);
        zebra.move(MoveDirection.RIGHT);
        zebra.move(MoveDirection.BACKWARD);
        zebra.move(MoveDirection.BACKWARD);
        zebra.move(MoveDirection.BACKWARD);
        tmp = new Vector2d(0,0);
        assertEquals(zebra.getAnimalPosition(),tmp);
        zebra.move(MoveDirection.FORWARD);
        zebra.move(MoveDirection.FORWARD);
        zebra.move(MoveDirection.FORWARD);
        zebra.move(MoveDirection.FORWARD);
        zebra.move(MoveDirection.FORWARD);
        tmp = new Vector2d(4,0);
        assertEquals(zebra.getAnimalPosition(),tmp);
    }
    @Test
    public void parserTest(){
        OptionsParser tmp = new OptionsParser();
        //all possibilities with some random exapmles :)
        String[] first = {"programowanie","f","w","javie","forward","jest","b","backward","przyjemne",":)","r","right","l","left"};
        MoveDirection[] second = {MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.BACKWARD,
                MoveDirection.BACKWARD, MoveDirection.RIGHT, MoveDirection.RIGHT, MoveDirection.LEFT, MoveDirection.LEFT};
        assertArrayEquals(tmp.parse(first),second);
    }


}*/