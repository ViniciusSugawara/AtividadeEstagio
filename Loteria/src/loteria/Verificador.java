package loteria;

import dominio.Bilhete;
import dominio.Participante;

import java.util.List;

public class Verificador {
    private static int[] resultado;
    private static List<Participante> participantes;

    public Verificador(int[] resultado, List<Participante> participantes){
        this.resultado = resultado;
        this.participantes = participantes;
    }

    public static Participante verificaVencedor(){
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
