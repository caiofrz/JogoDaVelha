package src;

import java.util.Scanner;
import javax.swing.JOptionPane;

public class Jogador{

    static Scanner input = new Scanner(System.in);

    private String nickName;
    private String simbolo;
    private Jogador oponente;


    public Jogador(String nickName, String simbolo) {
        this.nickName = nickName;
        this.simbolo = simbolo;
    }


    public void jogar(String[][] tabuleiro){

        int linha;
        int coluna;

        try{
            System.out.println("Linha: ");   // 
            linha = (int) input.nextDouble();  //       
                                               // Lendo a posição do tabuleiro para jogada
            System.out.println("Coluna: "); //
            coluna = (int) input.nextDouble();// forma usada para correção de um bug do Scanner

            if(tabuleiro[linha][coluna] == " "){
                tabuleiro[linha][coluna] = this.getSimbolo();
            } else {
                System.out.println("Jogada inválida!");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Jogada inválida!");   
            input.close();   
        }
    }


    public void escolherOponente(){ //Método responsável por setar o oponente do jogador principal

        try{
            System.out.println("\n");
            System.out.println("--------------------------------");
            System.out.println("\tVAI JOGAR SOZINHO? ");
            System.out.println("--------------------------------");


            System.out.println("1. SIM");
            System.out.println("2. NÃO");

            System.out.println("\n");
            System.out.println("INFORME O NUMERO EQUIVALENTE A SUA ESCOLHA: ");
            int escolha = input.nextInt();


            if (escolha == 1) {
                // Caso o oponente seja o computador, é feita a chamada da função de escolha de dificuldade 
                this.escolherDificuldade();
            } else if(escolha == 2){
                // Caso tenha 2 jogadores, essa estrura cria a instancia de um novo jogador
                System.out.println("INFORME O NICK DO SEGUNDO JOGADOR: ");
                String nickName = input.next();

                this.oponente = new Jogador(nickName, "O");
            } else {
                System.out.println("ESCOLHA INVÁLIDA");
            }
            
        } catch(Exception ex){
            JOptionPane.showMessageDialog(null, "ERRO");
        }

        Principal.limparTela();
    }


    public void escolherDificuldade(){ //Método responsável pela escolha do nível do jogo

        try { //Estrutura de tratamento de exceção
            System.out.println("\n");
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

            if (dificuldade == 1) {// Estrutura que instancia um jogador-computador de acordo o nível de dificuldade escolhido
                this.oponente = new ComputadorFacil("pcFacil", "PC"); 
            } else {
                this.oponente = new ComputadorDificil("pcDificil", "PC");
            }
        } catch (Exception ex) { 
            JOptionPane.showMessageDialog(null, "ERRO"); //Mosta um painel na tela com a mensagem "ERRO"
        }
                
    }

    public Jogador getOponente(){
        return oponente;
    }
    
    public String getNickName() {
        return this.nickName;
    }

    public String getSimbolo() {
        return this.simbolo;
    }

    @Override
    public String toString(){
        return this.nickName + " - " + this.simbolo;
    }
    
}

