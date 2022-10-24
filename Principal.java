package src;

import java.util.Scanner;
import javax.swing.JOptionPane;

public class Principal {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("\t\t\t------------------------------");
        System.out.println("\t\t\t\tJOGO DA VELHA");
        System.out.println("\t\t\t------------------------------");

        Tabuleiro tabuleiro = new Tabuleiro();//Criando meu  tabuleiro
        Boolean vitoria = false;

        menuInstrucoes();//Chamada da função que irá mostrar as instruções do jogo
        
        System.out.println("INFORME SEU NICK: ");
        String nickName = input.next();

        System.out.println("INFORME O SÍMBOLO QUE DESEJA JOGAR: ");
        String simbolo = input.next();

        Jogador jogador1 = new Jogador(nickName, simbolo);//Criando jogador principal, com base no nick e simbolo escolhidos
        
        jogador1.escolherOponente(); //Faz a chamada do menu, para o jogador escolher seu oponente/nível de jogo

        Jogador jogador2 = jogador1.getOponente();

        //iniciando o jogo
        do{

            tabuleiro.mostrarTabuleiro();

            jogador1.jogar(tabuleiro.getPosicoesTabuleiro());
            tabuleiro.setQuantidadeJogadas();
            vitoria = tabuleiro.verificarVitoria();

            if(tabuleiro.getQuantidadeJogadas() == 9){ //Caso não haja vitória e o tabuleiro esteja completo, o Loop é encerrado 
                break;
            }

            if (!(vitoria)) {
                tabuleiro.mostrarTabuleiro();
                jogador2.jogar(tabuleiro.getPosicoesTabuleiro());
                tabuleiro.setQuantidadeJogadas();
            }
        } while(!(tabuleiro.verificarVitoria()));//Loop encerra quando houver vitória 

        //Finalizando o jogo 
        tabuleiro.mostrarTabuleiro();
        apresentarResultado(tabuleiro, jogador1, jogador2);
        input.close();

    } 


    public static void apresentarResultado(Tabuleiro tabuleiro, Jogador jogador1, Jogador jogador2){
        //Método responsável por apresentar o resultado da partida

        if(tabuleiro.verificarVitoria() == false && tabuleiro.getQuantidadeJogadas() == 9){
            JOptionPane.showMessageDialog(null, "EMPATE");
        } else if(tabuleiro.getSimboloVencedor() == jogador1.getSimbolo()){
            JOptionPane.showMessageDialog(null, "Vencedor: " + jogador1.toString());
        } else {
            JOptionPane.showMessageDialog(null, "Vencedor: " + jogador2.toString());
        }
    }


    public static void menuInstrucoes(){//Método responsável por apresentar as instruções do jogo

        System.out.println("--------------------------------");
        System.out.println("\tINSTRUÇÕES");
        System.out.println("--------------------------------");

        System.out.println("1. Este jogo é um jogo de console! Portanto todas as ações serão feitas através do mesmo");
        System.out.println("2. O tabuleiro funcionará como um plano cartesiano");
        System.out.println("3. As jogadas serão feitas por coordenadas de linha e coluna");
        System.out.println("4. As linhas vão de 0 a 2 e de cima para baixo, onde 0 é a linha mais acima");
        System.out.println("5. As colunas vão de 0 a 2 e da esquerda para a direta, onde 0 é a coluna mais a esquerda");
        System.out.println("6. EX. de jogada: linha = 0 e coluna = 0");
        System.out.println("7. Com esse exemplo de jogada você irá marcar o primeiro espaço mais a esquerda e mais acima do tabuleiro");
        System.out.println("8. As jogadas do computador serão marcadas como 'PC'");
        System.out.println("9. As jogadas do jogador 2 serão marcadas como 'O'");
        System.out.println("10. O jogador principal poderá escolher qualquer símbolo para marcar suas jogadas");
        System.out.println("\n");
    }



    public final static void limparTela() { // Função responsável por "limpar a tela"
        for (int i = 0; i < 20; i++) {
            System.out.println();
        }
    }
}