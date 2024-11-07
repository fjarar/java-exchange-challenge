import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner userQuery = new Scanner(System.in);
        CurrencyExchange currencyExchange = new CurrencyExchange();
        boolean continuar = true;
        do {
            System.out.println("**********************************************");
            System.out.println("**** Bienvenido/a al conversor de monedas ****");
            System.out.println("******************* MENU *********************");
            System.out.println("***** Seleccione una divisa a convertir ******");
            System.out.println("* 1.- Dólar(USD) a Peso Chileno(CLP)         *");
            System.out.println("* 2.- Peso Chileno a Dólar                   *");
            System.out.println("* 3.- Euro(EUR) a Peso Chileno(CLP)          *");
            System.out.println("* 4.- Peso Chileno a Euro(EUR)               *");
            System.out.println("* 5.- Real Brasileño(BRL) a Peso Chileno(CLP)*");
            System.out.println("* 6.- Peso Chileno a Real Brasileño(BRL)     *");
            System.out.println("* 9.- Salir                                  *");
            System.out.println("**      Seleccione una opción valida:        **");
            System.out.println("**********************************************");
            try {
                var opcion = Integer.valueOf(userQuery.nextLine());
                var valueToConvert = 0.0;
                System.out.println("Ingrese el monto a convertir");
                switch (opcion) {
                    case 1:
                        valueToConvert = Double.valueOf(userQuery.nextLine());
                        currencyExchange.currencyExchange("USD", "CLP", valueToConvert);
                        System.out.println(currencyExchange);
                        break;
                    case 2:
                        valueToConvert = Double.valueOf(userQuery.nextLine());
                        currencyExchange.currencyExchange("CLP", "USD", valueToConvert);
                        System.out.println(currencyExchange);
                        break;
                    case 3:
                        valueToConvert = Double.valueOf(userQuery.nextLine());
                        currencyExchange.currencyExchange("EUR", "CLP", valueToConvert);
                        System.out.println(currencyExchange);
                        break;
                    case 4:
                        valueToConvert = Double.valueOf(userQuery.nextLine());
                        currencyExchange.currencyExchange("CLP", "EUR", valueToConvert);
                        System.out.println(currencyExchange);
                        break;
                    case 5:
                        valueToConvert = Double.valueOf(userQuery.nextLine());
                        currencyExchange.currencyExchange("BRL", "CLP", valueToConvert);
                        System.out.println(currencyExchange);
                        break;
                    case 6:
                        valueToConvert = Double.valueOf(userQuery.nextLine());
                        currencyExchange.currencyExchange("CLP", "BRL", valueToConvert);
                        System.out.println(currencyExchange);
                        break;
                    case 9:
                        System.out.println("Gracias por usar nuestro servicio");
                        continuar = false;
                        break;
                    default:
                        System.out.println("La opción ingresada no es valida");
                        break;
                }

            } catch (NumberFormatException e) {
                System.out.println("Entrada no válida. Por favor ingrese un número válido.");
            }
        } while (continuar);


    }
}
