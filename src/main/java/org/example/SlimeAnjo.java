package org.example;

public class SlimeAnjo extends Slime {
    public SlimeAnjo() {
        super("Anjo");
    }

    @Override
    public void usarEspecial(Slime alvo) {
        if (temEnergiaSuficiente(4)) {
            resistencia += 0.2;
            energia -= 4;
            System.out.println(nome + " usou o especial e ganhou 0.2 de resistência permanente.");
        } else {
            System.out.println("Energia insuficiente para usar o especial.");
        }
    }

    @Override
    public void atacar(Slime alvo) {
        System.out.println(this.getNome() + " lança um raio divino em " + alvo.getNome() + "!");
        alvo.receberDano(15);  // O Slime Anjo causa 15 pontos de dano com seu ataque.
    }
}
