package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlaceTest {
    @Test
    public void placeTest(){
        GrassField map = new GrassField(0);
        Vector2d tmp = new Vector2d(-25,-25);
        Animal animal1 = new Animal(map,tmp);
        Animal tester = new Animal(map,tmp);
        boolean tr = true;
        boolean fl = false;
        assertTrue(map.place(animal1));
        assertTrue(map.objectAt(tmp) instanceof Animal);
        try{
            map.place(tester);
            assertTrue(fl); //returns false
        }
        catch(IllegalArgumentException a){
            assertTrue(tr); //returns true
        }

        tmp = new Vector2d(30,30);
        Animal animal2 = new Animal(map,tmp);
        assertTrue(map.place(animal2));
        assertTrue(map.objectAt(tmp) instanceof Animal);
        tester = new Animal(map,tmp);
        try{
            map.place(tester);
            assertTrue(fl); //returns false
        }
        catch(IllegalArgumentException a){
            assertTrue(tr); //returns true
        }

        tmp = new Vector2d(10,10);
        tester = new Animal(map,tmp);

        try{
            map.place(tester);
            assertTrue(tr);
        }
        catch(IllegalArgumentException a) {
            assertTrue(fl);
        }
    }
}