package com.example.inscryption;

import com.example.inscryption.Controller.Game;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {

        Game game = new Game();
        game.start();
    }
    @Override
    public void start(Stage stage) throws Exception {
        //Scene scene = new Scene();
        //stage.show();


    }
}
