package controllers;

import dominio.Bilhete;
import io.EntradaDados;

public class BilheteController {
    public Bilhete preencheBilhete(Bilhete bilhete, int quantidadeNumeros){
        int[] numerosParaPreencher = new int[quantidadeNumeros];
        for(int i = 0; i < numerosParaPreencher.length; i++){
            System.out.println(i + 1 + "o numero");
            numerosParaPreencher[i] = EntradaDados.retornaNumero();
        }
        bilhete.setNumeros(numerosParaPreencher);
        return bilhete;
    }

}
