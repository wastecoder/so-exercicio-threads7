package controller;

import javax.swing.*;
import java.util.Random;

public class ThreadReel extends Thread {
    private JLabel labelNumero;
    private JButton botaoIniciar;
    private int valorAtual;

    public ThreadReel(JLabel JLabelNumero, JButton botaoIniciar) {
        this.labelNumero = JLabelNumero;
        this.botaoIniciar = botaoIniciar;
    }

    @Override
    public void run() {
        botaoIniciar.setEnabled(false); //Desabilita o botão
        rodarRoleta();
        botaoIniciar.setEnabled(true); //Reabilita o botão
    }

    //1) Define um valor inicial aleatório de 1 a 7
    //2) Aumenta o valor inicial 10x e para no valor final
    //3) Cada aumento espera 150ms
    public void rodarRoleta() {
        int MAIOR_NUMERO = 7;

        int numeroInicial = gerarNumeroInicialAleatorio(MAIOR_NUMERO);
        labelNumero.setText(String.valueOf(numeroInicial));

        for (int i = 0; i < 10; i++) {
            //++labelNumero
            incrementarLabelNumero();

            //Ao chegar no limite superior (7), volta ao limite inferior (1)
            verificarLimiteSuperior(MAIOR_NUMERO);

            //Espera 150ms para aumentar o valor atual
            try {
                Thread.sleep(150);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public int gerarNumeroInicialAleatorio(int maiorNumero) {
        Random aleatorio = new Random();
        return aleatorio.nextInt(maiorNumero) + 1; //1 a maiorNumero
    }

    public void incrementarLabelNumero() {
        valorAtual = Integer.parseInt(labelNumero.getText());
        valorAtual++;
        labelNumero.setText(String.valueOf(valorAtual));
    }

    public void verificarLimiteSuperior(int limiteSuperior) {
        if (valorAtual > limiteSuperior) {
            labelNumero.setText("1");
        }
    }
}
