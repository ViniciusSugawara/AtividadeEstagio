package utilidades;

import dominio.Bilhete;
import dominio.Participante;

import java.util.List;

public class Verificador {
    private int[] resultado;
    private List<Participante> participantes;

    public Verificador(int[] resultado, List<Participante> participantes){
        this.resultado = resultado;
        this.participantes = participantes;
    }

    public Participante verificaVencedor(){
        Participante vencedor = null;
        for(Participante participante : participantes){
            for(Bilhete bilhete : participante.getBilhetes()){
                if(resultado.equals(bilhete.getNumeros())){
                    vencedor = participante;
                    return vencedor;
                }
            }
        }
        return null;
    }
}
