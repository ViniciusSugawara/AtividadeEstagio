package controllers;

import dominio.Bilhete;

import java.util.ArrayList;
import java.util.List;

public class ParticipanteController {
    List<Bilhete> bilhetes;
    public List<Bilhete> adicionaBilhetes(int quantidadeBilhetes){

        this.bilhetes = new ArrayList<>();
        for(int i = 0; i < quantidadeBilhetes; i++){
            bilhetes.add(new Bilhete());
        }
        return bilhetes;
    }
}
