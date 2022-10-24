package src;

import java.util.Random;
import javax.swing.JOptionPane;

public class ComputadorFacil extends Jogador{ 

    public ComputadorFacil(String nickName, String simbolo) {
        super(nickName, simbolo);
    }

    @Override
    public void jogar(String[][] tabuleiro){// O computador irá uma posição aleatória
        Random aleatorio = new Random();

        int linha, coluna;
        Boolean validaJogada = false;

        try {
            while (!validaJogada) { //Loop para garantir que o computador faça uma jogada válida
                linha = aleatorio.nextInt(3);
                coluna = aleatorio.nextInt(3);
                
                if(tabuleiro[linha][coluna] == " "){
                    tabuleiro[linha][coluna] = this.getSimbolo();
                    validaJogada = true;
                }
            }
            
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "ERRO");
        }
    }
}