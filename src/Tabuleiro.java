package src;

public class Tabuleiro {

    private String posicoesTabuleiro[][] = new String[3][3];
    private int quantidadeJogadas;


    public Tabuleiro() {
        inicializarTabuleiro();
        this.quantidadeJogadas = 0;
    }

    public void inicializarTabuleiro(){ // Inicializa cada posição do tabuleiro como um 'espaço em branco"
        for (int linha = 0; linha < 3; linha++) {
            for (int coluna = 0; coluna < 3; coluna++) {
                this.posicoesTabuleiro[linha][coluna] = "X";
            }
        }
    }

    public void mostrarTabuleiro(){ //Função que mostra o tabuleiro e as jogadas feitas

        Principal.limparTela();

         for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                System.out.print(this.posicoesTabuleiro[i][j]);
                if(j<2){
                    System.out.print("  |  ");
                }
            }
            if(i<2){
                System.out.println("\n___  ___  ___");
            }
            
            System.out.println("\n");
        }

    }


    public boolean verificarVitoria(){
        return true;
    }


    public int getQuantidadeJogadas() {
        return this.quantidadeJogadas;
    }

    public void setQuantidadeJogadas() {
        while(this.quantidadeJogadas <= 9){
            this.quantidadeJogadas++;
        }
    }

}