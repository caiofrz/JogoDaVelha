package src;

public class Jogador{

    private String nickName;
    private String simbolo;


    public Jogador(String nickName, String simbolo) {
        this.nickName = nickName;
        this.simbolo = simbolo;
    }


    public void jogar(){

    }

    public String getNickName() {
        return this.nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getSimbolo() {
        return this.simbolo;
    }

    
}

