package org.example;

public class SlimeDemonio extends Slime{
    public SlimeDemonio() {
        super("Demônio");
    }

    @Override
    public void usarEspecial(Slime alvo) {
        if (temEnergiaSuficiente(4)) {
            multiplicadorDano += 0.2;
            energia -= 4;
            System.out.println(nome + " usou o especial e ganhou 0.2 de multiplicador de dano permanente.");
        } else {
            System.out.println("Energia insuficiente para usar o especial.");
        }
    }

    @Override
    public void atacar(Slime alvo) {
        System.out.println(this.getNome() + " invoca chamas infernais contra " + alvo.getNome() + "!");
        alvo.receberDano(20);  // O Slime Demônio causa 20 pontos de dano com seu ataque.
    }
}
