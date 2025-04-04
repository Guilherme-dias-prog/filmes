package br.com.alura.screenmatch.excecao;

public class ErrodeConversaoexception extends Throwable {
    public String mesagem;
    public ErrodeConversaoexception(String mesagem) {
        this.mesagem=mesagem;
    }


    public String getMessage() {
        return this.mesagem;
    }
}
