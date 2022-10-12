package agh.ics.oop;

import org.testng.annotations.Test;

import static org.testng.AssertJUnit.*;

public class Vector2dTest {
    @Test
    public void equalsTest() {
        Vector2d first = new Vector2d(1, 2);
        Vector2d second = new Vector2d(1, 2);
        Vector2d third = new Vector2d(2, 1);
        assertTrue(first.equals(second));
        assertFalse(first.equals(third));
    }

    @Test
    public void toStringTest() {
        Vector2d first = new Vector2d(1, 2);
        String a = "(1,2)";
        String b = "(1,3)";
        assertEquals(first.toString(), a);
        assertFalse(first.toString().equals(b));
    }

    @Test
    public void precedesTest() {
        Vector2d first = new Vector2d(1, 2);
        Vector2d second = new Vector2d(1, 3);
        Vector2d third = new Vector2d(2, 1);
        assertTrue(first.precedes(second));
        assertFalse(first.precedes(third));
        assertTrue(first.precedes(first));
    }

    @Test
    public void followsTest() {
        Vector2d first = new Vector2d(1, 2);
        Vector2d second = new Vector2d(1, 3);
        Vector2d third = new Vector2d(2, 1);
        assertTrue(second.follows(first));
        assertFalse(second.follows(third));
        assertFalse(third.follows(second));
        assertTrue(first.follows(first));
    }
    @Test
    public void upperRightTest(){
        Vector2d first = new Vector2d(1, 2);
        Vector2d second = new Vector2d(2, 1);
        Vector2d third = new Vector2d(2,2);
        assertEquals(first.upperRight(second),third);
        assertEquals(second.upperRight(first),third);
    }

    @Test
    public void lowerLeftTest(){
        Vector2d first = new Vector2d(1, 2);
        Vector2d second = new Vector2d(2, 1);
        Vector2d third = new Vector2d(1,1);
        assertEquals(first.lowerLeft(second),third);
        assertEquals(second.lowerLeft(first),third);
    }
    @Test
    public void addTest(){
        Vector2d first = new Vector2d(1, 2);
        Vector2d second = new Vector2d(2, 2);
        Vector2d third = new Vector2d(3,4);
        assertEquals(first.add(second),second.add(first));
        assertEquals(first.add(second),third);
    }
    @Test
    public void subtractTest(){
        Vector2d first = new Vector2d(1, 2);
        Vector2d second = new Vector2d(2, 2);
        Vector2d third = new Vector2d(-1,0);
        assertEquals(first.substract(second),third);
    }
    @Test
    public void oppositeTest(){
        Vector2d first = new Vector2d(1, 2);
        Vector2d second = new Vector2d(2, 1);
        assertEquals(first.opposite(),second);
        assertEquals(second.opposite(),first);
    }

}