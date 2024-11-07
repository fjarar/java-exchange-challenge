import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner userQuery = new Scanner(System.in);
        CurrencyExchange currencyExchange = new CurrencyExchange();
        Currency currency;
        boolean continuar = true;
        do {
            System.out.println("**************************************");
            System.out.println("*Bienvenido/a al conversor de monedas*");
            System.out.println("*****************MENU*****************");
            System.out.println("**Seleccione una divisa a convertir***");
            System.out.println("1.- Dólar(USD) a Peso Chileno(CLP)");
            System.out.println("2.- Peso Chileno a Dólar");
            System.out.println("9.- Salir");
            System.out.println("Seleccione una opción valida:");
            System.out.println("**************************************");
            var opcion = Integer.valueOf(userQuery.nextLine());
            var valueToConvert = 0.0;
            switch (opcion){
                case 1:
                    System.out.println("Ingrese el monto a convertir");
                    valueToConvert = Double.valueOf(userQuery.nextLine());
                    currency = currencyExchange.currencyExchange("USD", "CLP", valueToConvert);
                    System.out.println(currency);
                    break;
                case 2:
                    System.out.println("Ingrese el monto a convertir");
                    valueToConvert = Double.valueOf(userQuery.nextLine());
                    currency = currencyExchange.currencyExchange("CLP", "USD", valueToConvert);
                    System.out.println(currency);
                    break;
                case 9:
                    System.out.println("Gracias por usar nuestro servicio");
                    continuar=false;
                    break;
                default:
                    System.out.println("La opción ingresada no es valida");
                    break;
            }
        }while(continuar);


    }
}
