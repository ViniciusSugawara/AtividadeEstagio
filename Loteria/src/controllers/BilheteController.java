package controllers;

import dominio.Bilhete;
import utilidades.EntradaDados;
import sorteadores.ISorteador;

import java.util.List;

public class BilheteController {

    public Bilhete preencheBilheteManualmente(int quantidadeNumeros){
        int[] numerosParaPreencher = new int[quantidadeNumeros];
        Bilhete bilhete = new Bilhete();
        for (int i = 0; i < quantidadeNumeros; i++) {
            System.out.println(i + 1 + "o numero");
            numerosParaPreencher[i] = EntradaDados.retornaNumero();
        }
        bilhete.setNumeros(numerosParaPreencher);
        return bilhete;
    }

    public Bilhete preencheBilheteAutomaticamente(ISorteador iSorteador){
        Bilhete bilhete = new Bilhete();
        iSorteador.realizaSorteio();
        bilhete.setNumeros(iSorteador.getNumerosSorteados());
        return bilhete;
    }

}
