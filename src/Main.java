import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int opcao = 0;
        String continua = "S";

        System.out.println("GERENCIADOR DE TAREFAS INTELIGENTE\n");
        System.out.println("Menu do Gerenciador");

        while (continua.equalsIgnoreCase("S")) {

            Scanner scan = new Scanner(System.in);
            System.out.println("Digite a opção desejada:");

            try {
              opcao = scan.nextInt();
              scan.nextLine();

            } catch (InputMismatchException e) {
                System.out.println("ENTRADA INVÁLIDA. Digite um número: ");
                continue;
            }


            switch (opcao) {
                case 1:
                    System.out.println("Vai para tela de CADASTRO DE TAREFAS");
                    break;
                case 2:
                    System.out.println("Vai para tela do GERENCIAMENTO E FILTRAGEM");
                    break;

                default:
                    System.out.println("Opção inválida");
            }

        }

    }


}