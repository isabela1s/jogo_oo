package org.example;

public class SlimeDragao extends Slime {
    private int poder;

    public SlimeDragao() {
        super("Slime Dragão");
        this.poder = 100;  // Poder exclusivo do Slime Dragão
    }

    public int getPoder() {
        return poder;
    }

    @Override
    public void atacar(Slime alvo) {
        System.out.println(this.getNome() + " lança uma rajada de fogo em " + alvo.getNome() + "!");
        alvo.receberDano(30 + this.getPoder());  // Usa o poder no ataque
    }

    @Override
    public void usarEspecial(Slime alvo) {
        System.out.println(this.getNome() + " invoca um dragão para atacar " + alvo.getNome() + "!");
        alvo.receberDano(50 + this.getPoder());  // Usa o poder no ataque especial
    }
}
