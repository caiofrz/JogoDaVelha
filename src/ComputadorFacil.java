package src;

import java.util.Random;

public class ComputadorFacil extends Jogador{ 

    public ComputadorFacil(String nickName, String simbolo) {
        super(nickName, simbolo);
    }

    @Override
    public void jogar(String[][] tabuleiro){
        Random aleatorio = new Random(3);

        int linha, coluna;

        while(true){
            linha = aleatorio.nextInt(0, 2);
            coluna = aleatorio.nextInt(0, 2);

            if(tabuleiro[linha][coluna] == " "){
                tabuleiro[linha][coluna] = super.getSimbolo();
                return;
            }
        }

        

    }

}