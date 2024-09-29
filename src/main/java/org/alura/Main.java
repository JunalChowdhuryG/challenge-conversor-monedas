package org.alura;

import org.alura.view.Interfaz;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        try {
            Interfaz interfaz = new Interfaz();

            interfaz.getMenu();
        }catch (Exception e) {
            e.printStackTrace();
        }



    }
    
}