package loteria;

public class LoteriaView {
    private Loteria loteria;

    public LoteriaView(Loteria loteria) {
        this.loteria = loteria;
    }

    public void demonstraExecucao(){
        System.out.println(loteria.executaJogo());
    }

    public void demonstraResultados(){
        System.out.println(loteria.executaDemonstracaoResultados());
    }
}
