package org.example;

public class SlimeSereia extends Slime {
    public SlimeSereia() {
        super("Sereia");
    }

    @Override
    public void usarEspecial(Slime alvo) {
        if (temEnergiaSuficiente(6)) {
            alvo.energia = 0;
            energia = Math.min(energia + 2, 5); // Recupera até 2 de energia
            energia -= 6;
            System.out.println(nome + " usou o especial e zerou a energia do alvo.");
        } else {
            System.out.println("Energia insuficiente para usar o especial.");
        }
    }

    @Override
    public void atacar(Slime alvo) {
        // Implementação específica para o ataque da SlimeSereia
        System.out.println(this.getNome() + " lança um canto hipnótico em " + alvo.getNome());
        alvo.receberDano(15); // Supondo que a sereia cause 15 de dano
    }
}


