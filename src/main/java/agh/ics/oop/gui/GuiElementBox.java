package agh.ics.oop.gui;

import agh.ics.oop.Animal;

import javax.swing.text.html.ImageView;
import java.awt.*;
import java.io.FileInputStream;

public class GuiElementBox {
    Image image;
    ImageView imageView ;
    public GuiElementBox(Animal animal){
        switch (animal.toString()){
            case "N":{
                this.image = new Image(new FileInputStream("src/main/resources/up.png"));
                this.imageView = new ImageView(this.image);
            }
        }
    }
}
