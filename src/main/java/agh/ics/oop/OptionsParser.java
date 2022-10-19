package agh.ics.oop;

public class OptionsParser {
    public MoveDirection[] parse(String[] args){
         int final_length = 0;
         for(String argument:args){
             switch(argument){
                 case "f":
                     final_length += 1;
                     break;
                 case "forward":
                     final_length += 1;
                     break;
                 case "b":
                     final_length += 1;
                     break;
                 case "backward":
                     final_length += 1;
                     break;
                 case "r":
                     final_length += 1;
                     break;
                 case "right":
                     final_length += 1;
                     break;
                 case "l":
                     final_length += 1;
                     break;
                 case "left":
                     final_length += 1;
                     break;
             }}
         MoveDirection[] changed = new MoveDirection[final_length];
         int curr = 0;
         for(String argument:args){
             switch(argument){
                 case "f":
                     changed[curr] = MoveDirection.FORWARD;
                     curr += 1;
                     break;
                 case "forward":
                     changed[curr] = MoveDirection.FORWARD;
                     curr += 1;
                     break;
                 case "b":
                     changed[curr] = MoveDirection.BACKWARD;
                     curr += 1;
                     break;
                 case "backward":
                     changed[curr] = MoveDirection.BACKWARD;
                     curr += 1;
                     break;
                 case "r":
                     changed[curr] = MoveDirection.RIGHT;
                     curr += 1;
                     break;
                 case "right":
                     changed[curr] = MoveDirection.RIGHT;
                     curr += 1;
                     break;
                 case "l":
                     changed[curr] = MoveDirection.LEFT;
                     curr += 1;
                     break;
                 case "left":
                     changed[curr] = MoveDirection.LEFT;
                     curr += 1;
                     break;
                 }


        }
         return changed;
    }
}
