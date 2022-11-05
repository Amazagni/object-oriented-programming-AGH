package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GrassFieldTest {
    @Test
    public void isOccupiedTest(){
        GrassField map = new GrassField(0);
        Vector2d tmp = new Vector2d(2,2);
        assertFalse(map.isOccupied(tmp));
        map.plantTheGrassAt(tmp);
        assertTrue(map.isOccupied(tmp));
    }
    @Test
    public void objectAtTest(){
        GrassField map = new GrassField(0);
        Vector2d tmp = new Vector2d(2,2);
        assertEquals(null,map.objectAt(tmp));
        map.plantTheGrassAt(tmp);
        assertTrue(map.objectAt(tmp) instanceof Grass);
    }
    @Test
    public void canMoveToTest(){
        GrassField map = new GrassField(0);
        Vector2d tmp = new Vector2d(2,2);
        assertTrue(map.canMoveTo(tmp));
        map.plantTheGrassAt(tmp);
        assertTrue(map.canMoveTo(tmp));
        Animal animal = new Animal(map,tmp);
        map.place(animal);
        assertFalse(map.canMoveTo(tmp));
        tmp = new Vector2d(-100,-120);
        assertTrue(map.canMoveTo(tmp));
    }

    @Test
    public void placeTest(){
        GrassField map = new GrassField(0);
        Vector2d tmp = new Vector2d(-25,-25);
        Animal animal = new Animal(map,tmp);
        Animal animal2 = new Animal(map,tmp);
        assertTrue(map.place(animal));
        assertTrue(map.objectAt(tmp) instanceof Animal);
        assertFalse(map.place(animal2));
        tmp = new Vector2d(30,30);
        animal2 = new Animal(map,tmp);
        map.plantTheGrassAt(tmp);
        assertTrue(map.place(animal2));
        assertTrue(map.objectAt(tmp) instanceof Animal);

    }
}