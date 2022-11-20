package controllers;

import dominio.Bilhete;
import utilidades.EntradaDados;
import sorteadores.Sorteador;

import java.util.List;

public class BilheteController {
    public void preencheBilheteManualmente(List<Bilhete> bilhetes, int quantidadeNumeros){
        int[] numerosParaPreencher = new int[quantidadeNumeros];

        for(Bilhete bilhete: bilhetes) {
            for (int i = 0; i < quantidadeNumeros; i++) {
                System.out.println(i + 1 + "o numero");
                numerosParaPreencher[i] = EntradaDados.retornaNumero();
            }
            bilhete.setNumeros(numerosParaPreencher);
        }
    }

    public void preencheBilheteAutomaticamente(List<Bilhete> bilhetes, Sorteador sorteador){
        sorteador.realizaSorteio();
        for(Bilhete bilhete : bilhetes)
        bilhete.setNumeros(sorteador.getNumerosSorteados());
    }
}
