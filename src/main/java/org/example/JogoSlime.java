package org.example;

import java.util.Scanner;

public class JogoSlime {
    private static Slime criarSlime(int ancestral) {
        switch (ancestral) {
            case 1:
                return new SlimeVampiro();
            case 2:
                return new SlimeDragao();
            case 3:
                return new SlimeSereia();
            case 4:
                return new SlimeAnjo();
            case 5:
                return new SlimeDemonio();
            default:
                throw new IllegalArgumentException("Ancestral inválido.");
        }
    }

    private static void executarTurno(Slime slime, Slime alvo, Scanner scanner) {
        boolean energizado = false;
        while (slime.energia > 0) {
            slime.exibirEstado();
            alvo.exibirEstado();
            System.out.println("Escolha uma habilidade: (energia restante: " + slime.energia + ")");
            System.out.println("0: Terminar turno");
            System.out.println("1: Ataque");
            System.out.println("2: Energizar");
            System.out.println("3: Especial");

            int escolha = scanner.nextInt();

            switch (escolha) {
                case 0:
                    return;
                case 1:
                    if (slime.temEnergiaSuficiente(1)) {
                        slime.atacar(alvo, energizado);
                    } else {
                        System.out.println("Energia insuficiente para atacar.");
                    }
                    break;
                case 2:
                    if (slime.temEnergiaSuficiente(2)) {
                        slime.energizar();
                        energizado = true;
                    } else {
                        System.out.println("Energia insuficiente para energizar.");
                    }
                    break;
                case 3:
                    slime.usarEspecial(alvo);
                    break;
                default:
                    System.out.println("Escolha inválida.");
            }

            if (alvo.getVida() <= 0) {
                System.out.println(alvo.nome + " foi derrotado! " + slime.nome + " venceu!");
                System.exit(0);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem-vindo ao jogo de slimes!");
        System.out.println("Escolha o ancestral do Slime A:");
        System.out.println("1 = vampiro; 2 = dragao; 3 = sereia; 4 = anjo; 5 = demonio");

        int ancestralA = scanner.nextInt();
        Slime slimeA = criarSlime(ancestralA);

        System.out.println("Escolha o ancestral do Slime B:");
        System.out.println("1 = vampiro; 2 = dragao; 3 = sereia; 4 = anjo; 5 = demonio");
        int ancestralB = scanner.nextInt();
        Slime slimeB = criarSlime(ancestralB);

        while (slimeA.getVida() > 0 && slimeB.getVida() > 0) {
            System.out.println("TURNO DO SLIME A");
            executarTurno(slimeA, slimeB, scanner);
            slimeA.recuperarEnergia();

            if (slimeB.getVida() > 0) {
                System.out.println("TURNO DO SLIME B");
                executarTurno(slimeB, slimeA, scanner);
                slimeB.recuperarEnergia();
            }
        }

        System.out.println("Fim do jogo!");
    }
}