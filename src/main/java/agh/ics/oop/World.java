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
        Animal zebra = new Animal();
        String[] move = {"r","r","f","f","f"};
        OptionsParser tmp = new OptionsParser();
        MoveDirection[] move2 = tmp.parse(move);
        System.out.println(zebra);
        for(MoveDirection direction: move2)
        {
            zebra.move(direction);
        }

        System.out.println(zebra);


    }
}
