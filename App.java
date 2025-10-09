import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        // * Declaració de variables
        // Bucle
        boolean running = true;
        boolean needContinue;

        // Menú principal
        String menuOptionString;
        int menuOption = 0;

        // * Crear scanner
        Scanner scanner = new Scanner(System.in);

        // * Bucle principal
        while (running) {
            // * Reiniciar status
            needContinue = false;

            // * Mostrar opcions
            System.out.println("=== Menú ===");
            System.out.println("1. Introduir dades");
            System.out.println("2. Modificar dades");
            System.out.println("3. Visualitzar dades");
            System.out.println("4. Sortir");

            // * Obtenir opció
            System.out.print("\nSi us plau, seleccioni una opció (amb el número d'aquesta): ");
            menuOptionString = scanner.nextLine();
            System.out.println("\n\n");

            // * Protecció d'errors de l'opció seleccionada
            // ? Comprova si no ha seleccionat res
            if (menuOptionString.isBlank()) {
                System.out.println("No ha seleccionat ninguna opció. Si us plau, seleccioni una opció:\n\n");
                needContinue = true;

            } else { // ? Si hi ha contingut
                try { // ? Parsear L'opció
                    menuOption = Integer.parseInt(menuOptionString);
                
                } catch (java.lang.NumberFormatException e) { // ? No es tracta d'un nombre enter
                    System.out.println("L'opció ha de ser un nombre enter. Si us plau, torni a intertar-lo:\n\n");
                    needContinue = true;
                
                } catch (Exception e) { // ? Altre tipus d'error
                    System.out.println("Alguna cosa ha sortit malament. Si us plau torni a intertar-lo:\n\n");
                    needContinue = true;
                }

                // ? Comprovar si es dins el rang
                if (menuOption > 4 || menuOption < 1) {
                    System.out.println("L'opció seleccionada no existeix. Si us plau, torni a intentar-lo:\n\n");
                    needContinue = true;
                }

            }

            // ? Reinicia el bucle
            if (needContinue) { continue; }

            // * Processar opció
            switch (menuOption) {
                case 1:
                    break;
                
                case 2:
                    break;
                
                case 3:
                    break;
                
                case 4:
                    running = false;
                    break;
            }

        }

        // * Tencar scanner
        scanner.close();
    }
}
