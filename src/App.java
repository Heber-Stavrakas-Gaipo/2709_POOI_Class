import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        Dicionario dicionario = null;
        System.out.println("Quantas palavras tem no dicionario?");
        int quantPalavras = scanner.nextInt();
        dicionario = new Dicionario(quantPalavras);
        int option = 0;
        int counter = 0;
        boolean found = false;
        do {
            System.out.println(
                    "1 - Inserir palavra no dicionario;\n2 - Pesquisar palavra no dicionario;\n3 - Imprimir dicionario completo;\n4 - Alterar 1 significado de uma palavra;\n5 - Excluir uma palavra do dicionario;\n0 - Sair");
            System.out.println("Digite uma opcao: ");
            option = scanner.nextInt();
            System.out.print("\n");
            switch (option) {
                case 1: {
                    if (counter < dicionario.getQuantPalavra()) {
                        System.out.print("Digite o termo: ");
                        String termo = scanner.next();
                        System.out.println("\nQuantos significados essa palavra tem?");
                        int quantSignificados = scanner.nextInt();
                        scanner.nextLine(); // Consume leftover newline
                        Palavra palavra = new Palavra(termo, quantSignificados);
                        for (int i = 0; i < quantSignificados; i++) {
                            System.out.println("Digite o significado " + (i + 1) + ":");
                            String significado = scanner.nextLine();
                            palavra.incluiSignificados(significado);
                        }
                        dicionario.inserePalavra(palavra);
                        counter++;

                    } else {
                        System.out.println("Dicionario cheio!");
                    }
                }
                    break;
                case 2: {
                    System.out.println("Digite o termo que deseja pesquisar: ");
                    String termo = scanner.next();
                    System.out.print("\n");
                    Palavra[] palavras = dicionario.getPalavras();
                    found = false;
                    for (Palavra p : palavras) {
                        if (p != null && p.getTermo().equalsIgnoreCase(termo)) {
                            found = true;
                            System.out.println("Termo: " + p.getTermo());
                            String[] significados = p.getSignificado();
                            for (int i = 0; i < p.getQuantSignificado(); i++) {
                                if (significados[i] != null) {
                                    System.out.println(" - " + significados[i]);
                                }
                            }
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Palavra não encontrada no dicionário.");
                    }
                }
                    break;
                case 3: {
                    dicionario.imprimeDicionario();
                }
                    break;
                case 4: {
                    System.out.println("Digite o termo que deseja alterar um significado: ");
                    String termo = scanner.next();
                    Palavra[] palavras = dicionario.getPalavras();
                    found = false;
                    for (Palavra p : palavras) {
                        if (p != null && p.getTermo().equalsIgnoreCase(termo)) {
                            found = true;
                            String[] significados = p.getSignificado();
                            for (int i = 0; i < p.getQuantSignificado(); i++) {
                                if (significados[i] != null) {
                                    System.out.println(i + " - " + significados[i]);
                                }
                            }
                            System.out.println("Qual significado deseja alterar:");
                            int position = scanner.nextInt();
                            scanner.nextLine(); // Consume leftover newline
                            System.out.println("Digite o novo significado:");
                            String significado = scanner.nextLine();
                            p.alteraSignificado(significado, position);
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Palavra não encontrada no dicionário.");
                    }
                }
                    break;
                case 5: {
                    Palavra[] palavras = dicionario.getPalavras();
                    for (int i = 0; i < dicionario.getQuantPalavra(); i++) {
                        if (palavras[i] != null) {
                            System.out.println(i + " - " + palavras[i].getTermo());
                        }
                    }
                    System.out.println("Digite a posicao da palavra que deseja excluir: ");
                    int position = scanner.nextInt();
                    found = false;
                    if (position >= 0 && position < dicionario.getQuantPalavra()) {
                        Palavra p = palavras[position];
                        if (p != null) {
                            found = true;
                            dicionario.excluiPalavra(position);
                            System.out.println("Palavra excluída com sucesso.");
                            counter--; // Decrease counter when word is removed
                        }
                    }
                    if (!found) {
                        System.out.println("Palavra não encontrada no dicionário.");
                    }
                }
                default:
                    break;
            }

        } while (option != 0);
    }
}
