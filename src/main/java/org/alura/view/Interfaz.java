package org.alura.view;

import org.alura.dto.Coin;
import org.alura.service.convert.Converter;
import org.alura.service.data.Data;
import org.alura.validator.ValidatorMount;

import java.io.IOException;
import java.util.Scanner;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Interfaz {

    private final Data data;

    public Interfaz(){
        this.data = new Data();
    }


    public void getOptions() {
        System.out.println("1. Convertir moneda");
        System.out.println("2. Salir");
    }

    public void getMenu() throws IOException, InterruptedException {
        Scanner sc = new Scanner(System.in);
        boolean bandera = true;

        while(bandera){
            getOptions();
            System.out.println("Ingrese una opcion: ");
            var opcion = sc.nextInt();
            switch (opcion){
                case 1 -> option1();
                case 2 -> {
                    bandera = false;
                    System.out.println("Gracias por usar el conversor de monedas");
                }
                default -> System.out.println("Opcion no valida");
            }
        }
    }

    public void option1() throws IOException, InterruptedException {
        Scanner sc = new Scanner(System.in);
        Converter conversor = new Converter();

        System.out.println("Ingrese la moneda de origen: ");
        var moneda_origen = sc.nextLine().toLowerCase();
        System.out.println("Ingrese la moneda de destino: ");
        var moneda_destino = sc.nextLine().toLowerCase();

        double cantidad = 0;
        do {
            System.out.println("Ingrese la cantidad a convertir: ");
            cantidad = sc.nextDouble();
        } while (!ValidatorMount.validar(cantidad));

        String currecy_code_origen = (String) data.getCurrencyCode().get(moneda_origen);
        double valor_moneda_origen = (double) data.getCoins().get(currecy_code_origen);
        var coin_origen = new Coin(currecy_code_origen, valor_moneda_origen);

        String currecy_code_destino = (String) data.getCurrencyCode().get(moneda_destino);
        double valor_moneda_destino = (double) data.getCoins().get(currecy_code_destino);
        var coin_destino = new Coin(currecy_code_destino, valor_moneda_destino);

        double conversion = conversor.convert(cantidad, coin_destino.getValue(), coin_origen.getValue());

        //System.out.println("La conversion de " + cantidad + " " + coin_origen.getCode() + " a " + coin_destino.getCode() + " es: " + conversion);

        Date fechaCambio = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("La conversión de " + cantidad + " " + coin_origen.getCode() +
                " a " + coin_destino.getCode() + " es: " + conversion +
                " (Fecha del tipo de cambio: " + sdf.format(fechaCambio) + ")");

    }


}
