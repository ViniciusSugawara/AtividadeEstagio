package io;

import controllers.LoteriaController;

public class LoteriaView {
    private LoteriaController loteriaController;

    public LoteriaView(LoteriaController loteriaController) {
        this.loteriaController = loteriaController;
    }

    public void demonstraExecucao(){
        System.out.println(loteriaController.executaJogo());
    }

    public void demonstraResultados(){
        System.out.println(loteriaController.executaDemonstracaoResultados());
    }
}
