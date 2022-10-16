package src;

import java.util.Scanner;


public class Principal {

    public static void main(String[] args) {

        System.out.println("\t\t\t------------------------------");
        System.out.println("\t\t\t\tJOGO DA VELHA");
        System.out.println("\t\t\t------------------------------");

        Tabuleiro tabuleiro = new Tabuleiro();
        /*Scanner input = new Scanner(System.in);
        

        System.out.println("INFORME SEU NICK: ");
        String nickName = input.next();

        System.out.println("INFORME O SÍMBOLO QUE DESEJA JOGAR (X ou O): ");
        String simbolo = input.next();

        Jogador jogador1 = new Jogador(nickName, simbolo);
        

        EscolherOponente(jogador1); //Mostra o menu de dificuldades na tela*/

        tabuleiro.mostrarTabuleiro();

        
    }





    public static void EscolherOponente(Jogador jogador1){ //Função que verifica o oponente do jogador

        Scanner input = new Scanner(System.in);

        System.out.println("VAI JOGAR SOZINHO? ");

        System.out.println("\n");
        System.out.println("1. SIM");
        System.out.println("2. NÃO");
        System.out.println("\n");

        System.out.println("ESCOLHA: ");
        int oponente = input.nextInt();

        switch(oponente){

            case 1:
                // Caso o oponente seja o computador, é feita a chamada da função de escolha de dificuldade 
                menuDificuldade(jogador1);
                break;

            case 2:
                // Caso tenha 2 jogadores, essa estrura faz a instancia de um novo jogador
                System.out.println("INFORME O NICK: ");
                String nickName = input.next();

                String simbolo = jogador1.getSimbolo() == "X" ? "O" : "X";
                Jogador jogador2 = new Jogador(nickName, simbolo);
                break;

            default:
                System.out.println("ESCOLHA INVÁLIDA");
        }

        limparTela();

    }








    public static void menuDificuldade(Jogador jogador1){ //Função responsável pela escolha do nível do jogo

        Scanner input = new Scanner(System.in);

        String simbolo = jogador1.getSimbolo() == "X" ? "O" : "X";


            System.out.println("--------------------------------");
            System.out.println("ESCOLHA A DIFICULDADE DO JOGO!");
            System.out.println("--------------------------------");

            System.out.println("1. Fácil");
            System.out.println("2. Difícil");
            System.out.println("\n");

            System.out.println("INFORME O NUMERO EQUIVALENTE A SUA ESCOLHA: ");

            int dificuldade = input.nextInt();
            
        while(dificuldade !=1 && dificuldade !=2){ //Loop de validação da escolha do nível

            System.out.println("ESCOLHA INVÁLIDA! INFORME A NOVA ESCOLHA: ");
            dificuldade = input.nextInt();
        }

        if (dificuldade == 1) {// Estrutura que instancia um jogador-computador de acordo o nível de dificuldade
            ComputadorFacil jogador2 = new ComputadorFacil("pcFacil", simbolo); 
        } else {
             ComputadorDificil jogador2 = new ComputadorDificil("pcDificil", simbolo);
        }        
    }






    public final static void limparTela() { // Função responsável por "limpar a tela"
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }
}