package org.example;

public class SlimeVampiro extends Slime {
    public SlimeVampiro() {
        super("Vampiro");
    }

    @Override
    public void usarEspecial(Slime alvo) {
        if (temEnergiaSuficiente(4)) {
            alvo.vida -= 2;
            vida = Math.min(vida + 1, 10); // Recupera até o máximo de 10 de vida
            energia -= 4;
            System.out.println(nome + " usou o especial e causou 2 de dano e recuperou 1 de vida.");
        } else {
            System.out.println("Energia insuficiente para usar o especial.");
        }
    }

    @Override
    public void atacar(Slime alvo) {
        System.out.println(this.getNome() + " morde " + alvo.getNome() + " e suga seu sangue!");
        alvo.receberDano(20);  // O slime vampiro causa 20 pontos de dano
    }
}
