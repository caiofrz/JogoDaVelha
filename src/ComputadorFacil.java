package src;

import java.util.Random;

public class ComputadorFacil extends Jogador{ 

    public ComputadorFacil(String nickName, String simbolo) {
        super(nickName, simbolo);
    }

    @Override
    public void jogar(String[][] tabuleiro){
        Random aleatorio = new Random();

        int linha, coluna;

        try {
            linha = aleatorio.nextInt(3);
            coluna = aleatorio.nextInt(3);
            
            if(tabuleiro[linha][coluna] == " "){
                tabuleiro[linha][coluna] = this.getSimbolo();
            }
            
        } catch (Exception ex) {
            
        }
    }
}