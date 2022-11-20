package controllers;

import dominio.Bilhete;

import java.util.ArrayList;
import java.util.List;

public class ParticipanteController {
    public List<Bilhete> adicionaBilhetes(int quantidadeBilhetes){
        List<Bilhete> bilhetes = new ArrayList<>();
        for(int i = 0; i < quantidadeBilhetes; i++){
            bilhetes.add(new Bilhete());
        }
        return bilhetes;
    }
}
