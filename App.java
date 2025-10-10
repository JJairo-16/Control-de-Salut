import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        // * Declaració de variables
        // Bucle
        boolean running = true;
        boolean needContinue;

        // Menú principal
        int menuOption = 0;

        // Dades personals
        String name;
        int age;
        double weight;
        double height;

        // Variables temporals
        String tempName;
        int tempAge;
        double tempWeight;
        double tempHeight;

        // * Crear scanner
        Scanner scanner = new Scanner(System.in);
        String input;

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
            input = scanner.nextLine();
            System.out.println("\n\n");

            // * Protecció d'errors de l'opció seleccionada
            // ? Comprova si no ha seleccionat res
            if (input.isBlank()) {
                System.out.println("No ha seleccionat ninguna opció. Si us plau, seleccioni una opció:\n\n");
                needContinue = true;

            } else { // ? Si hi ha contingut
                try { // ? Parsear L'opció
                    menuOption = Integer.parseInt(input);

                } catch (java.lang.NumberFormatException e) { // ? No es tracta d'un nombre enter
                    System.out.println("L'opció ha de ser un nombre enter. Si us plau, torni a intertar-lo:\n\n");
                    needContinue = true;

                } catch (Exception e) { // ? Altre tipus d'error
                    System.out.println("Alguna cosa ha sortit malament. Si us plau torni a intertar-lo:\n\n");
                    needContinue = true;
                }

                // ? Comprovar si es dins el rang
                if (menuOption > 4 || menuOption < 1) {
                    System.out.println("L'opció seleccionada no existeix. Si us plau, torni a intentar-ho:\n\n");
                    needContinue = true;
                }

            }

            // ? Reinicia el bucle
            if (needContinue) {
                continue;
            }

            // * Processar opció
            switch (menuOption) {
                case 1:
                    // * Missatge inical
                    System.out.println("== Guardar dades ==");

                    // * Declaració de variables
                    boolean inputLoop;

                    // Inicialització
                    tempName = "";
                    tempAge = 0;
                    tempWeight = 0;
                    tempHeight = 0;

                    // * Obtenir nom
                    inputLoop = true;
                    while (inputLoop) {
                        System.out.print("Introdueixi el seu nom complet, si us plau: ");
                        tempName = scanner.nextLine();

                        // Vàlidar nom
                        if (tempName.isBlank()) { // ? Està en blanc o només son espais en blanc
                            System.out.println("El nom no pot està en blanc. Si us plau, torni a intentar-ho:\n\n");

                        } else if (tempName.length() < 3) { // ? El nom és massa curt
                            System.out.println("El nom es massa curt. Si us plau, torni a intentar-ho:\n\n");

                        } else if (tempName.length() > 30) { // ? El nom és massa llarg
                            System.out.println("El nom es massa llarg. Si us plau, torni a intentar-ho:\n\n");

                        } else {
                            try {
                                Double.parseDouble(tempName); // ? És un número
                                System.out.println("El nom no pot ser un número. Si us plau, torni a intentar-ho:\n\n");

                            } catch (Exception e) { // ? Altres
                                inputLoop = false;
                            }
                        }
                    }

                    // * Obtenir edat
                    inputLoop = true;
                    while (inputLoop) {
                        System.out.print("Introdueixi la seva edat, si us plau: ");
                        input = scanner.nextLine();

                        // Vàlidar edat
                        if (input.isBlank()) { // ? Està en blanc o només son espais en blanc
                            System.out.println("L'edat no pot està en blanc. Si us plau, torni a intentar-ho:\n\n");

                        } else { // ? Si hi ha contingut
                            try {
                                tempAge = Integer.parseInt(input);

                                if (tempAge < 0) { // ? L'edat es menor a 0
                                    System.out.println("L'edat no pot ser menor a 0. Si us plau, torni a intentar-ho:\n\n");
                                
                                } else if (tempAge > 120) { // ? L'edat es major a 120
                                    System.out.println("L'edat no pot ser major a 120. Si us plau, torni a intentar-ho:\n\n");
                                
                                } else {
                                    inputLoop = false;
                                }

                            } catch (java.lang.NumberFormatException e) { // ? No és un nombre
                                System.out.println("L'edat ha de ser un nombre natual. Si us plau, torni a intentar-ho:\n\n");
                            
                            } catch (Exception e) { // ? Altres
                                System.out.println("Alguna cosa ha sortit malament. Si us plau, torni a intentar-ho:\n\n");
                            }
                        }
                    }

                    // * Obtenir pes
                    inputLoop = true;
                    while (inputLoop) { // ? Està en blanc o només son espais en blanc
                        System.out.print("Introdueixi el seu pes (Kg), si us plau: ");
                        input = scanner.nextLine();

                        // Vàlidar pes
                        if (input.isBlank()) { // ? Està en blanc o només son espais en blanc
                            System.out.println("El pes no pot estar en blanc. Si us plau, torni a intentar-ho:\n\n");
                        
                        } else { // ? Si hi ha contingut
                            try {
                                tempWeight = parseDouble(input);

                                if (tempWeight < 0) { // ? El pes és negatiu
                                    System.out.println("El pes no pot ser un nombre negatiu. Si us plau, torni a intentar-ho:\n\n");
                                
                                } else if (tempWeight > 120) { // ? El pes es major a 120 Kg
                                    System.out.println("El pes no pot ser major a 120 Kg. Si us plau, torni a intentar-ho:\n\n");
                                
                                } else {
                                    inputLoop = false;
                                }
                            
                            } catch (java.lang.NumberFormatException e) { // ? No es un nombre
                                System.out.println("El pes ha de ser un nombre (enter o decimal). Si us plau, torni a intentar-ho:\n\n");
                            
                            } catch (Exception e) { // ? Altres
                                System.out.println("Alguna cosa ha sortit malament. Si us plau, torni a intentar-ho:\n\n");
                            }

                        }
                    }
                    
                    // * Obtenir alçada
                    inputLoop = true;
                    while (inputLoop) {
                        System.out.print("Introdueixi la seva alçada (m), si us plau: ");
                        input = scanner.nextLine();

                        // Vàlidar alçada
                        if (input.isBlank()) { // ? Està en blanc o només son espais en blanc
                            System.out.println("L'alçada no pot estar en blanc. Si us plau, torni a intentar-ho:\n\n");
                        
                        } else { // ? Si hi ha contingut
                            try {
                                tempHeight = parseDouble(input);

                                if (tempHeight < 0.5) { // ? L'alçada es meno a 0.5m
                                    System.out.println("L'alçada ha de ser igual o major a 0.5m. Si us plau, torni a intentar-ho:\n\n");
                                
                                } else if (tempHeight > 2.5) { // ? L'alçada es major a 2.5m
                                    System.out.println("L'alçada no pot ser major a 2.5m. Si us plau, torni a intentar-ho:\n\n");
                                
                                } else {
                                    inputLoop = false;
                                }
                            
                            } catch (java.lang.NumberFormatException e) { // ? No es un nombre
                                System.out.println("L'alçada a de ser un nombre. Si us plau, torni a intentar-ho:\n\n");
                            
                            } catch (Exception e) { // ? Altres
                                System.out.println("Alguna cosa ha sortit malament. Si us plau, torni a intentar-ho:\n\n");
                            }

                        }
                    }

                    // * Guardar dades
                    name = tempName;
                    age = tempAge;
                    weight = tempWeight;
                    height = tempHeight;

                    // * Finalització
                    System.out.println("\n\n");

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

    // ! Aquesta funció permet passar d'String a double amb el punt i la coma com a separador de decimals
    private static double parseDouble(String input) {
        String tempString = input.replace(",", "."); // ? Passar el divisor decimal a punt
        return Double.parseDouble(tempString); // ? Parsear
    }
}
