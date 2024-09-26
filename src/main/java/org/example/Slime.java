package org.example;

abstract class Slime {
    protected double vida = 10;
    protected double multiplicadorDano = 1;
    protected double resistencia = 0;
    protected double energia = 5;
    protected String nome;
    protected int poder;

    public Slime(String nome) {
        this.nome = nome;
    }

    public double getVida() {
        return vida;
    }

    public void atacar(Slime alvo, boolean energizado) {
        double E = energizado ? 0.5 : 0;
        double dano = multiplicadorDano - alvo.resistencia + E;
        alvo.vida -= dano;
        energia -= 1;
        System.out.println(nome + " causou " + dano + " de dano no " + alvo.nome);
    }

    public void energizar() {
        energia -= 2;
        System.out.println(nome + " está energizado e ganhará +0.5 de dano no próximo ataque.");
    }

    public boolean temEnergiaSuficiente(double custo) {
        return energia >= custo;
    }

    public abstract void usarEspecial(Slime alvo);

    public void exibirEstado() {
        System.out.println(nome + " - Vida: " + vida + " | Energia: " + energia + " | Multiplicador de dano: " + multiplicadorDano + " | Resistência: " + resistencia);
    }

    public void recuperarEnergia() {
        energia = Math.min(energia + 2, 5); // Recupera até o máximo de 5 de energia por turno
    }

    public abstract void atacar(Slime alvo);

    // Getter para o nome do slime
    public String getNome() {
        return nome;
    }

    // Método para o slime receber dano
    public void receberDano(int dano) {
        this.vida -= dano;
        if (this.vida < 0) {
            this.vida = 0;
        }
        System.out.println(this.nome + " agora tem " + this.vida + " pontos de vida.");
    }
//pode ser somente para o dragao?
    public int getPoder() {
        return poder;
    }
}
