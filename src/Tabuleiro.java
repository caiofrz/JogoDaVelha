package src;

public class Tabuleiro {

    private String posicoesTabuleiro[][] = new String[3][3];
    private int quantidadeJogadas;
    private String simboloVencedor;


    public Tabuleiro() {
        inicializarTabuleiro();
        this.quantidadeJogadas = 0;
    }

    private void inicializarTabuleiro(){ // Inicializa cada posição do tabuleiro como um 'espaço em branco"
        for (int linha = 0; linha < 3; linha++) {
            for (int coluna = 0; coluna < 3; coluna++) {
                this.posicoesTabuleiro[linha][coluna] = " ";
            }
        }
    }

    public void mostrarTabuleiro(){ //Função que mostra o tabuleiro e as jogadas feitas

        Principal.limparTela();

         for(int linha = 0; linha < 3; linha++){
            for(int coluna = 0; coluna < 3; coluna++){
                System.out.print(this.posicoesTabuleiro[linha][coluna]);
                if(coluna < 2){
                    System.out.print("  |  ");
                }
            }
            if(linha < 2){
                System.out.println("\n___  ___  ___");
            }
            
            System.out.println("\n");
        }
    }


    public boolean verificarVitoria(){

            if(this.quantidadeJogadas < 5){ //Verificando a quantidade de jogadas, não pode haver ganhador com menos de 5 jogadas
                return false;
            }

            //Verificando vitoria diagonal 1 
            else if(this.posicoesTabuleiro[0][0] == this.posicoesTabuleiro[1][1] && this.posicoesTabuleiro[1][1] == this.posicoesTabuleiro[2][2] && this.posicoesTabuleiro[0][0] != " "){
                    this.simboloVencedor = this.posicoesTabuleiro[0][0];
                    System.out.println("Vencedor diagonal 1");
                    return true;
            }

            //Verificando vitoria diagonal 2
            else if(this.posicoesTabuleiro[2][0] == this.posicoesTabuleiro[1][1] && this.posicoesTabuleiro[1][1] == this.posicoesTabuleiro[0][2] && this.posicoesTabuleiro[2][0] != " "){
                    this.simboloVencedor = this.posicoesTabuleiro[2][0];
                    System.out.println("Vencedor diagonal 2");
                    return true;
            } else {
                //loop para verificar todas as possibilidades de vitoria verticais e horizontais
                for(int i = 0; i < 3; i++){
                    //Verificando vitoria na horizontal
                    if(this.posicoesTabuleiro[i][0] == this.posicoesTabuleiro[i][1] && this.posicoesTabuleiro[i][1] == this.posicoesTabuleiro[i][2] && this.posicoesTabuleiro[i][0] != " "){
                        this.simboloVencedor = this.posicoesTabuleiro[i][0];
                        System.out.println("Vencedor horizontal 1");
                        return true;
                    } 

                        // Verificando vitoria na vertical
                    else if(this.posicoesTabuleiro[0][i] == this.posicoesTabuleiro[1][i] && this.posicoesTabuleiro[1][i] == this.posicoesTabuleiro[2][i] && this.posicoesTabuleiro[0][i] != " "){
                        this.simboloVencedor = this.posicoesTabuleiro[0][i];
                        System.out.println("Vencedor vertical 1");
                        return true;
                    }
                }
            }
        return false;
    }

    public String getSimboloVencedor(){
        return this.simboloVencedor;
    }

    public int getQuantidadeJogadas() {
        return this.quantidadeJogadas;
    }

    public void setQuantidadeJogadas() {
        this.quantidadeJogadas++;
    }

    public String[][] getPosicoesTabuleiro() {
        return posicoesTabuleiro;
    }

}