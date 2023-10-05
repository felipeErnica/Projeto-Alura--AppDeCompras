import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    private static Card userCard;

    public static void main(String[] args) {
        System.out.println("Bem Vindo!");
        System.out.println("Selecione um limite para o cartão:");
        double cardLimit =  new Scanner(System.in).nextDouble();
        userCard = new Card(cardLimit);
        showMenu();
    }

    public static void showMenu() {
        System.out.println("""
    
    Selecione uma opção:
    --------------------------------------
    1 - Comprar Item
    2 - Mostrar Carrinho de Compras
    3 - Mostrar Limite Disponível no Cartão
    4 - Encerrar
    --------------------------------------
    """);

        int option = new Scanner(System.in).nextInt();
        switch (option) {
            case 1 -> {
                buyProduct();
                showMenu();
                break;
            }
            case 2 -> {
                userCard.printList();
                showListMenu();
                break;
            }
            case 3 -> {
                System.out.printf("Seu limite é: R$ %.2f\n", userCard.getCardLimit());
                showMenu();
                break;
            }
            case 4 -> {
                System.out.println("Itens comprados:");
                userCard.printList();
                System.out.println("Obrigado por comprar conosco!");
                break;
            }
            default -> {
                System.out.println("Selecione uma opção válida!");
                showMenu();
                break;
            }
        }
    }

    public static void  buyProduct() {
        System.out.println("Digite o que deseja comprar:");
        String itemName = new Scanner(System.in).next();

        System.out.println("Digite o preço:");
        double price = new Scanner(System.in).nextDouble();

        Product  newProduct = new Product(itemName,price);

        if (userCard.newTransaction(newProduct)){
            System.out.println("Compra concluída!");
        }
        else {
            System.out.println("Desculpe, seu limite é insuficiente!");
            System.out.printf("Seu limite é: R$ %.2f\n", userCard.getCardLimit());
        }
    }

    private static void showListMenu(){
        System.out.println("""
    Selecione uma opção:  
     
    --------------------------
    1 - Comprar Item
    2 - Remover Item
    3 - Retornar ao Menu
    --------------------------
    """);

        int option = new Scanner(System.in).nextInt();
        switch (option) {
            case 1 -> {
                buyProduct();
                showMenu();
                break;
            }
            case 2 -> {
                removeProduct();
                break;
            }
            case 3 -> {
                showMenu();
                break;
            }
            default -> {
                System.out.println("Selecione uma opção válida!");
                showListMenu();
                break;
            }
        }
    }

    private static void removeProduct() {
        System.out.println("Selecione o índice do produto que gostaria de remover:");
        int option = new  Scanner(System.in).nextInt();

        if (userCard.removeTransaction(option)) {
            System.out.println("Item removido com sucesso!");
            userCard.printList();
        }
        else {
            System.out.println("Selecione um item existente!");
        }
        showMenu();
    }
}