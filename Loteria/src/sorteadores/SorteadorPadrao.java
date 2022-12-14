package sorteadores;
import java.util.Random;

public class SorteadorPadrao implements ISorteador {
    private int[] numerosSorteados;
    private int valorMaximo;
    private Random rand = new Random();

    public SorteadorPadrao(int quantiaNumerosSorteados, int valorMaximo){
        this.numerosSorteados = new int[quantiaNumerosSorteados];
        this.valorMaximo = valorMaximo;
    }

    private boolean verificaRepeticao(int numero){
        for(int i = 0; i < numerosSorteados.length; i++){
            if(numerosSorteados[i] == numero){
                return true;
            }
        }
        return false;
    }
    @Override
    public void realizaSorteio(){
        int i = 0;
        do{
            int numero = rand.nextInt(valorMaximo);
            if(!verificaRepeticao(numero)){
                numerosSorteados[i] = numero;
                i++;
            }
        } while (i < numerosSorteados.length);
    }

    public int[] getNumerosSorteados(){
        return this.numerosSorteados;
    }

    public String retornaNumerosSorteados(){
        String resultado = "";
        for(int numero : numerosSorteados){
            resultado += numero + ", ";
        }
        return resultado.substring(0, resultado.length()-2);
    }
}
