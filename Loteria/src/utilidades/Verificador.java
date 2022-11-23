package utilidades;

import dominio.Bilhete;
import dominio.Participante;

import java.util.Arrays;
import java.util.List;

public class Verificador {
    //Classe de utilidade que recebe o resultado do sorteio e os numeros e faz as verificacoes para ver se alguem venceu
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
                if(Arrays.equals(resultado, bilhete.getNumeros())){
                    vencedor = participante;
                    return vencedor;
                }
            }
        }
        return null;
    }
}
