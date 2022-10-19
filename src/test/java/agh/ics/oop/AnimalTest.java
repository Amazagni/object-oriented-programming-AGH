package agh.ics.oop;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnimalTest {
    @Test
    public void directionTest(){
        Animal zebra = new Animal();
        zebra.move(MoveDirection.LEFT);
        assertEquals(zebra.toString(),"position: (2,2) orientation: Zachód");
        zebra.move(MoveDirection.LEFT);
        assertEquals(zebra.toString(),"position: (2,2) orientation: Południe");
        zebra.move(MoveDirection.LEFT);
        assertEquals(zebra.toString(),"position: (2,2) orientation: Wschód");
        zebra.move(MoveDirection.LEFT);
        assertEquals(zebra.toString(),"position: (2,2) orientation: Północ");
        zebra.move(MoveDirection.RIGHT);
        assertEquals(zebra.toString(),"position: (2,2) orientation: Wschód");
        zebra.move(MoveDirection.RIGHT);
        assertEquals(zebra.toString(),"position: (2,2) orientation: Południe");
        zebra.move(MoveDirection.RIGHT);
        assertEquals(zebra.toString(),"position: (2,2) orientation: Zachód");
        zebra.move(MoveDirection.RIGHT);
        assertEquals(zebra.toString(),"position: (2,2) orientation: Północ");
    }

    @Test
    public void moveTest(){
        Animal zebra = new Animal();
        zebra.move(MoveDirection.FORWARD);
        assertEquals(zebra.toString(),"position: (2,3) orientation: Północ");
        zebra.move(MoveDirection.BACKWARD);
        assertEquals(zebra.toString(),"position: (2,2) orientation: Północ");
        zebra.move(MoveDirection.RIGHT);
        zebra.move(MoveDirection.FORWARD);
        assertEquals(zebra.toString(),"position: (3,2) orientation: Wschód");
        zebra.move(MoveDirection.BACKWARD);
        assertEquals(zebra.toString(),"position: (2,2) orientation: Wschód");
    }
    @Test
    public void borderTest(){
        Animal zebra = new Animal();
        zebra.move(MoveDirection.FORWARD);
        zebra.move(MoveDirection.FORWARD);
        zebra.move(MoveDirection.FORWARD);
        assertEquals(zebra.toString(),"position: (2,4) orientation: Północ");
        zebra.move(MoveDirection.BACKWARD);
        zebra.move(MoveDirection.BACKWARD);
        zebra.move(MoveDirection.BACKWARD);
        zebra.move(MoveDirection.BACKWARD);
        zebra.move(MoveDirection.BACKWARD);
        assertEquals(zebra.toString(),"position: (2,0) orientation: Północ");
        zebra.move(MoveDirection.RIGHT);
        zebra.move(MoveDirection.BACKWARD);
        zebra.move(MoveDirection.BACKWARD);
        zebra.move(MoveDirection.BACKWARD);
        assertEquals(zebra.toString(),"position: (0,0) orientation: Wschód");
        zebra.move(MoveDirection.FORWARD);
        zebra.move(MoveDirection.FORWARD);
        zebra.move(MoveDirection.FORWARD);
        zebra.move(MoveDirection.FORWARD);
        zebra.move(MoveDirection.FORWARD);
        assertEquals(zebra.toString(),"position: (4,0) orientation: Wschód");
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


}