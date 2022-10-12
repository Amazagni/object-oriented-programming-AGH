package agh.ics.oop;

public class World {
    public static void run(Direction[] args){
    for(Direction argument : args){
        switch(argument){
            case FORWARD:
                System.out.println("Zwierzak idzie do przodu");
                break;
            case BACKWARD:
                System.out.println("Zwierzak idzie do tyłu");
                break;
            case RIGHT:
                System.out.println("Zwierzak skręca w prawo");
                break;
            case LEFT:
                System.out.println("Zwierzak skręca w lewo");
                break;
        }
    }}
    public static Direction[] replace(String[] args) {
        // dlugosc nowej tablicy enumow (jesli w args mamy inne wejscie niz f b l r to dlugosci nie beda sie zgadzac)
        int length = 0;
        int DWA = 3;

        for(String argument : args){
            switch(argument){
                case "f":
                    length += 1;
                    break;
                case "b":
                    length += 1;
                    break;
                case "r":
                    length += 1;
                    break;
                case "l":
                    length += 1;
                    break;
            }}

        Direction[] neww = Direction.values();
        neww = new Direction[length];
        int i = 0;
        for(String argument : args){
            switch(argument){
                case "f":
                    neww[i] = Direction.FORWARD;
                    i += 1;
                    break;
                case "b":
                    neww[i] = Direction.BACKWARD;
                    i += 1;
                    break;
                case "r":
                    neww[i] = Direction.RIGHT;
                    i += 1;
                    break;
                case "l":
                    neww[i] = Direction.LEFT;
                    i += 1;
                    break;
            }
        }
        return neww;
    }
    public static void main(String[] args){
       // System.out.println("system wystartował");
       // Direction[] changed = replace(args);
       // run(changed);
       // System.out.print("system zakończył działanie");

        Vector2d position1 = new Vector2d(1,2);
        System.out.println(position1);
        Vector2d position2 = new Vector2d(-2,1);
        System.out.println(position2);
        System.out.println(position1.add(position2));

        MapDirection a = MapDirection.NORTH;
        System.out.println(a);
        System.out.println(a.next());
        System.out.println(a.previous());
        System.out.println(a.toUnitVector());
        System.out.println(a.toString());


    }
}
