package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static java.lang.System.*;
import static org.junit.jupiter.api.Assertions.*;

class OptionsParserTest {
    @Test
    public void parserTest(){
        OptionsParser tmp = new OptionsParser();
        //some working samples
        String[] first = {"f","forward","b","backward","r","right","l","left"};
        MoveDirection[] firstCheck = {MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.BACKWARD,
                MoveDirection.BACKWARD, MoveDirection.RIGHT, MoveDirection.RIGHT, MoveDirection.LEFT, MoveDirection.LEFT};
        assertArrayEquals(tmp.parse(first),firstCheck);

        String[] second = {"f", "forward", "unacceptableValue", "l", "right", "anotherunacceptableValue"};

        Boolean tr = true;
        Boolean fl = false;

        //checks if we catch an exception in array with unacceptableValues
        try {
        tmp.parse(second);
        assertTrue(fl); //returns false
        }
        catch(IllegalArgumentException a){
            assertTrue(tr); //returns true
        }

        //checks if we catch an exception in array without unacceptableValues
        try{
        tmp.parse(first);
        assertTrue(tr); //returns true
        }
        catch(IllegalArgumentException a){
            assertTrue(fl); //returns false
        }
    }

}