import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        /*Scanner userQuery = new Scanner(System.in);
        do {
            System.out.println("***************************");
            System.out.println("***********MENU************");
            System.out.println("Seleccione una divisa a convertir");
            System.out.println("***************************");
        }while(true);*/

        CurrencyExchange currencyExchange = new CurrencyExchange();
        Currency currency = currencyExchange.currencyExchange("USD");
        System.out.println(currency);
    }
}
