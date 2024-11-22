package jogodaforca;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class JogoDaForca {

    // Função para desenhar o boneco da forca
    public static String desenhaForca(int tentativas) {
        switch (tentativas) {
            case 0:
                return "_______\n|     |\n      |\n      |\n      |\n      |\n      |";
            case 1:
                return "_______\n|     |\nO     |\n      |\n      |\n      |\n      |";
            case 2:
                return "_______\n|     |\nO     |\n|     |\n      |\n      |\n      |";
            case 3:
                return "_______\n|     |\nO     |\n|\\    |\n      |\n      |\n      |";
            case 4:
                return "_______\n|     |\nO     |\n|\\    |\n/     |\n      |\n      |";
            case 5:
                return "_______\n|     |\nO     |\n|\\    |\n/ \\   |\n      |\n      |";
            default:
                return "_______\n|     |\nO     |\n|\\    |\n/ \\   |\nGame Over!\n      |";
        }
    }

    // Função principal do jogo
    public static void jogarForca() {
        // Lista de palavras possíveis
        List<String> palavras = new ArrayList<>();
        palavras.add("python");
        palavras.add("desenvolvimento");
        palavras.add("jogo");
        palavras.add("computador");
        palavras.add("algoritmo");

        // Selecionando uma palavra aleatória
        Random rand = new Random();
        String palavraSecreta = palavras.get(rand.nextInt(palavras.size()));
        
        // Inicializando variáveis
        char[] letrasCorretas = new char[palavraSecreta.length()];
        for (int i = 0; i < palavraSecreta.length(); i++) {
            letrasCorretas[i] = '_';
        }
        
        List<Character> letrasErradas = new ArrayList<>();
        int tentativas = 0;
        int maxTentativas = 6;
        String tema = "Tecnologia";  // Tema da palavra

        // Exibindo a introdução
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bem-vindo ao Jogo da Forca!");
        System.out.println("Tema: " + tema);
        System.out.println("A palavra tem " + palavraSecreta.length() + " letras.");
        
        // Início do loop do jogo
        while (tentativas < maxTentativas && new String(letrasCorretas).contains("_")) {
            System.out.println("\nPalavra: " + String.valueOf(letrasCorretas));
            System.out.println("Letras usadas: " + letrasErradas);
            System.out.println("Tentativas restantes: " + (maxTentativas - tentativas));
            System.out.println(desenhaForca(tentativas));

            System.out.print("Digite uma letra: ");
            String entrada = scanner.nextLine().toLowerCase();

            if (entrada.length() != 1 || !Character.isLetter(entrada.charAt(0))) {
                System.out.println("Por favor, insira apenas uma letra válida.");
                continue;
            }

            char letra = entrada.charAt(0);

            // Verifica se a letra já foi tentada
            if (letrasErradas.contains(letra) || new String(letrasCorretas).contains(String.valueOf(letra))) {
                System.out.println("Você já tentou essa letra.");
                continue;
            }

            // Verifica se a letra está na palavra secreta
            if (palavraSecreta.contains(String.valueOf(letra))) {
                System.out.println("A letra '" + letra + "' está correta!");
                for (int i = 0; i < palavraSecreta.length(); i++) {
                    if (palavraSecreta.charAt(i) == letra) {
                        letrasCorretas[i] = letra;
                    }
                }
            } else {
                System.out.println("A letra '" + letra + "' está incorreta.");
                letrasErradas.add(letra);
                tentativas++;
            }
        }

        // Verifica se o jogador ganhou ou perdeu
        if (!new String(letrasCorretas).contains("_")) {
            System.out.println("\nParabéns, você adivinhou a palavra!");
            System.out.println("A palavra era: " + palavraSecreta);
        } else {
            System.out.println(desenhaForca(tentativas));
            System.out.println("\nVocê foi enforcado! A palavra era: " + palavraSecreta);
        }

        scanner.close();
    }

    // Método principal para rodar o jogo
    public static void main(String[] args) {
        jogarForca();
    }
}
