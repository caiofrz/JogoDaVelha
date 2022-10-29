package src;

import java.util.Random;

public class ComputadorDificil extends Jogador{

    public ComputadorDificil(String nickName, String simbolo) {
        super(nickName, simbolo);
    }

    @Override
    public void jogar(String [][] tabuleiro){ 
        //Não necessariamente este modelo de jogo é difícil
        //O computador tentará jogar ao entorno da ultima jogada
        for(int linha = 0; linha < 3; linha++){
            for(int coluna = 0; coluna < 3; coluna++){
                if(tabuleiro[linha][coluna] != " "){ 
                    //verificando se as posições das LINHAS a baixo ou acima estão vazias e marcando                    
                    try{
                        if(tabuleiro[linha+1][coluna] != this.getSimbolo() && tabuleiro[linha+1][coluna] == " "){
                            tabuleiro[linha+1][coluna] = this.getSimbolo();
                            return;
                        }
                    } catch (Exception ex){

                    }
                    try {
                        if(tabuleiro[linha-1][coluna] == " "){
                            tabuleiro[linha-1][coluna] = this.getSimbolo();
                            return;
                        }
                    } catch (Exception ex) {

                    }

                    //verificando se as posições das COLUNAS ao lado estão vazias e marcando 
                    try { 
                        if(tabuleiro[linha][coluna+1] == " "){
                            tabuleiro[linha][coluna+1] = this.getSimbolo();
                            return;
                        } 
                    }   catch (Exception ex) {

                    }
                    
                    try {
                        if(tabuleiro[linha][coluna-1] == " "){
                            tabuleiro[linha][coluna-1] = this.getSimbolo();
                            return;
                        }
                    } catch (Exception ex) {

                    }
                }
            }
        }
        
        //Se o computador não conseguir jogar como o método acima, o metódo de jogo fácil é acionado
        int linha;
        Random aleatorio = new Random();
        while(true){
            linha = aleatorio.nextInt(3);
            for(int coluna = 0; coluna < 3; coluna++){
                if(tabuleiro[linha][coluna] == " "){
                    tabuleiro[linha][coluna] = this.getSimbolo();
                    System.out.println("Jogada 5");
                    return;
                }
            }
        }
    }
}

