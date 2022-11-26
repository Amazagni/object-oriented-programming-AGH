package agh.ics.oop.gui;

import agh.ics.oop.Animal;

import agh.ics.oop.IMapElement;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class GuiElementBox {
   Image image;
   IMapElement element;


    public GuiElementBox(IMapElement element){
            try{
                this.image = new Image(new FileInputStream(element.getPath()));
                this.element = element;
            }
            catch (FileNotFoundException a){
                System.out.println("Plik " + a + " nie istnieje");
            }
        }
    public VBox getVbox(){
        ImageView view = new ImageView(this.image);
        Label label;
        if(this.element instanceof Animal){
            label = new Label(this.element.getPosition().toString());
        }
        else{
            label = new Label("Trawa");
        }
        view.setFitHeight(20);
        view.setFitWidth(20);
        VBox toSend = new VBox(view, label);
        toSend.setAlignment(Pos.CENTER);
        return toSend;
    }
}

