package src;

public class Tabuleiro {

    private String tabuleiro[][] = new String[3][3];
    private int quantidadeJogadas;


    public Tabuleiro(int quantidadeJogadas) {
        this.quantidadeJogadas = quantidadeJogadas;
    }
    public boolean verificarVitoria(){
        return true;
    }
    public int getQuantidadeJogadas() {
        return this.quantidadeJogadas;
    }

    public void setQuantidadeJogadas(int quantidadeJogadas) {
        while(this.quantidadeJogadas <= 9){
            this.quantidadeJogadas++;
        }
    }

}