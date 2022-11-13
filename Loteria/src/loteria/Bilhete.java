package loteria;

public class Bilhete {
    private int[] numeros;

    public Bilhete(){
    }

    public int[] getNumeros() {
        return numeros;
    }

    public void setNumeros(int[] numeros) {
        this.numeros = numeros;
    }
    public String retornaNumeros(){
        String numerosBilhete = "";
        for(int numero : numeros){
            numerosBilhete += numero + ", ";
        }
        return numerosBilhete;
    }
}
