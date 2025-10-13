import java.util.Scanner;

import java.time.Year;

public class App {
    public static void main(String[] args) {
        // * Declaració de variables
        // Bucle
        boolean running = true;
        boolean needContinue;

        boolean inputLoop;
        boolean modLoop;

        // Menú principal
        int menuOption = 0;

        // Dades personals
        String name = "";
        int age = -1;
        double weight = -1;
        double height = -1;

        // Variables temporals
        String tempName;
        int tempAge;
        double tempWeight;
        double tempHeight;

        // * Regles
        // Menú
        final int MENU_MIN_OPTION = 1;
        final int MENU_MAX_OPTION = 4;

        final int MODMENU_MIN_OPTION = 1;
        final int MODMENU_MAX_OPTION = 4;

        // Nom
        final int NAME_MIN_LEN = 3;
        final int NAME_MAX_LEN = 30;

        // Edat
        final int MIN_AGE = 0;
        final int MAX_AGE = 120;

        // Pes
        final double MIN_WEIGHT = 0.0;
        final double MAX_WEIGHT = 400.0;

        // Altura
        final double MIN_HEIGHT = 0.5;
        final double MAX_HEIGHT = 2.5;

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
                System.out.println("No ha seleccionat cap opció. Si us plau, seleccioni una opció:\n\n");
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
                if (menuOption > MENU_MAX_OPTION || menuOption < MENU_MIN_OPTION) {
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
                case 1: // * Guardar dades
                    // * Missatge inicial
                    System.out.println("== Guardar dades ==");

                    // * Inicialització de variables
                    tempName = "";
                    tempAge = 0;
                    tempWeight = 0;
                    tempHeight = 0;

                    // * Obtenir nom
                    inputLoop = true;
                    while (inputLoop) {
                        System.out.print("Introdueixi el seu nom complet (sense accents), si us plau: ");
                        tempName = scanner.nextLine();

                        // Validar nom
                        if (tempName.isBlank()) { // ? Està en blanc o només són espais en blanc
                            System.out.println("El nom no pot estar en blanc. Si us plau, torni a intentar-ho:\n\n");

                        } else if (tempName.length() < NAME_MIN_LEN) { // ? El nom és massa curt
                            System.out.println("El nom és massa curt. Si us plau, torni a intentar-ho:\n\n");

                        } else if (tempName.length() > NAME_MAX_LEN) { // ? El nom és massa llarg
                            System.out.println("El nom és massa llarg. Si us plau, torni a intentar-ho:\n\n");

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

                        // Validar edat
                        if (input.isBlank()) { // ? Està en blanc o només són espais en blanc
                            System.out.println("L'edat no pot estar en blanc. Si us plau, torni a intentar-ho:\n\n");

                        } else { // ? Si hi ha contingut
                            try {
                                tempAge = Integer.parseInt(input);

                                if (tempAge < MIN_AGE) { // ? L'edat és menor a 0 (valor per defecte)
                                    System.out.printf("L'edat no pot ser menor a %d anys. Si us plau, torni a intentar-ho:%n%n%n", MIN_AGE);
                                
                                } else if (tempAge > MAX_AGE) { // ? L'edat es major a 120 (valor per defecte)
                                    System.out.printf("L'edat no pot ser major a %d anys. Si us plau, torni a intentar-ho:%n%n%n", MAX_AGE);
                                
                                } else {
                                    inputLoop = false;
                                }

                            } catch (java.lang.NumberFormatException e) { // ? No és un nombre
                                System.out.println("L'edat ha de ser un nombre natural. Si us plau, torni a intentar-ho:\n\n");
                            
                            } catch (Exception e) { // ? Altres
                                System.out.println("Alguna cosa ha sortit malament. Si us plau, torni a intentar-ho:\n\n");
                            }
                        }
                    }

                    // * Obtenir pes
                    inputLoop = true;
                    while (inputLoop) {
                        System.out.print("Introdueixi el seu pes (kg), si us plau: ");
                        input = scanner.nextLine();

                        // Validar pes
                        if (input.isBlank()) { // ? Està en blanc o només són espais en blanc
                            System.out.println("El pes no pot estar en blanc. Si us plau, torni a intentar-ho:\n\n");
                        
                        } else { // ? Si hi ha contingut
                            try {
                                tempWeight = parseDouble(input);

                                if (tempWeight < MIN_WEIGHT) { // ? El pes és menor a 0 (per defecte)
                                    System.out.printf("El pes no pot ser menor a %.2f. Si us plau, torni a intentar-ho:%n%n%n", MIN_WEIGHT);
                                
                                } else if (tempWeight > MAX_WEIGHT) { // ? El pes es major a 120 kg (valor per defecte)
                                    System.out.printf("El pes no pot ser major a %.2f kg. Si us plau, torni a intentar-ho:%n%n%n", MAX_WEIGHT);
                                
                                } else {
                                    inputLoop = false;
                                }
                            
                            } catch (java.lang.NumberFormatException e) { // ? No és un nombre
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

                        // Validar alçada
                        if (input.isBlank()) { // ? Està en blanc o només són espais en blanc
                            System.out.println("L'alçada no pot estar en blanc. Si us plau, torni a intentar-ho:\n\n");
                        
                        } else { // ? Si hi ha contingut
                            try {
                                tempHeight = parseDouble(input);

                                if (tempHeight < MIN_HEIGHT) { // ? L'alçada és menor a 0.5m (per defecte)
                                    System.out.printf("L'alçada ha de ser igual o major a %.2fm. Si us plau, torni a intentar-ho:%n%n%n", MIN_HEIGHT);
                                
                                } else if (tempHeight > MAX_HEIGHT) { // ? L'alçada és major a 2.5m (per defecte)
                                    System.out.printf("L'alçada no pot ser major a %.2fm. Si us plau, torni a intentar-ho:%n%n%n", MAX_HEIGHT);
                                
                                } else {
                                    inputLoop = false;
                                }
                            
                            } catch (java.lang.NumberFormatException e) { // ? No és un nombre
                                System.out.println("L'alçada ha de ser un nombre. Si us plau, torni a intentar-ho:\n\n");
                            
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
                    System.out.println("\nDades guardades correctament\n\n");

                    break;

                case 2: // * Modificar dada individualment
                    // * Validació
                    boolean canMod = (!name.isEmpty()) && (age != -1) && (weight != -1) && (height != -1);
                    if (!canMod) {
                        System.out.println("No s'han trobat dades. Si us plau, introdueixi les dades prèviament:\n\n");
                        break;
                    }

                    System.out.println("== Modificar dada ==");

                    // * Elecció de la dada
                    modLoop = true;
                    while (modLoop) {
                        // * Reiniciar status
                        needContinue = false;

                        // * Mostrar opcions
                        System.out.println("Opcions:");
                        System.out.println("1. Nom complet");
                        System.out.println("2. Edat");
                        System.out.println("3. Pes");
                        System.out.println("4. Alçada");

                        // * Obtenir opció
                        System.out.print("\nSi us plau, seleccioni una opció (amb el número d'aquesta): ");
                        input = scanner.nextLine();
                        System.out.println("\n\n");

                        // * Protecció d'errors de l'opció seleccionada
                        // ? Comprova si no ha seleccionat res
                        if (input.isBlank()) {
                            System.out.println("No ha seleccionat cap opció. Si us plau, seleccioni una opció:\n\n");
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

                            // ? Comprovar si és dins el rang
                            if (menuOption > MODMENU_MAX_OPTION || menuOption < MODMENU_MIN_OPTION) {
                                System.out.println("L'opció seleccionada no existeix. Si us plau, torni a intentar-ho:\n\n");
                                needContinue = true;
                            }
                        }

                        // ? Finalitzar el bucle
                        if (!needContinue) {
                            modLoop = false;
                        }
                    }
                    
                    // * Processar opció
                    switch (menuOption) {
                        case 1: // ? Modificar Nom complet
                            // Inicialització de variables
                            tempName = "";

                            // Obtenció de la nova dada
                            inputLoop = true;
                            while (inputLoop) {
                                System.out.print("Introdueixi el seu nom complet (sense accents), si us plau: ");
                                tempName = scanner.nextLine();

                                // Validar nom
                                if (tempName.isBlank()) { // ? Està en blanc o només són espais en blanc
                                    System.out.println("El nom no pot estar en blanc. Si us plau, torni a intentar-ho:\n\n");

                                } else if (tempName.length() < NAME_MIN_LEN) { // ? El nom és massa curt
                                    System.out.println("El nom és massa curt. Si us plau, torni a intentar-ho:\n\n");

                                } else if (tempName.length() > NAME_MAX_LEN) { // ? El nom és massa llarg
                                    System.out.println("El nom és massa llarg. Si us plau, torni a intentar-ho:\n\n");

                                } else {
                                    try {
                                        Double.parseDouble(tempName); // ? És un número
                                        System.out.println("El nom no pot ser un número. Si us plau, torni a intentar-ho:\n\n");

                                    } catch (Exception e) { // ? Altres
                                        inputLoop = false;
                                    }
                                }
                            }

                            // Guardar dada
                            name = tempName;
                            break;
                        
                        case 2: // ? Modificar edat
                            // Inicialització de variables
                            tempAge = 0;

                            // Obtenció de la nova dada
                            inputLoop = true;
                            while (inputLoop) {
                                System.out.print("Introdueixi la seva edat, si us plau: ");
                                input = scanner.nextLine();

                                // Validar edat
                                if (input.isBlank()) { // ? Està en blanc o només són espais en blanc
                                    System.out.println("L'edat no pot estar en blanc. Si us plau, torni a intentar-ho:\n\n");

                                } else { // ? Si hi ha contingut
                                    try {
                                        tempAge = Integer.parseInt(input);

                                        if (tempAge < MIN_AGE) { // ? L'edat és menor a 0 (per defecte)
                                            System.out.printf("L'edat no pot ser menor a %d anys. Si us plau, torni a intentar-ho:%n%n%n", MIN_AGE);
                                        
                                        } else if (tempAge > MAX_AGE) { // ? L'edat es major a 120 (per defecte)
                                            System.out.printf("L'edat no pot ser major a %d anys. Si us plau, torni a intentar-ho:%n%n%n", MAX_AGE);
                                        
                                        } else {
                                            inputLoop = false;
                                        }

                                    } catch (java.lang.NumberFormatException e) { // ? No és un nombre
                                        System.out.println("L'edat ha de ser un nombre natural. Si us plau, torni a intentar-ho:\n\n");
                                    
                                    } catch (Exception e) { // ? Altres
                                        System.out.println("Alguna cosa ha sortit malament. Si us plau, torni a intentar-ho:\n\n");
                                    }
                                }
                            }

                            // Guardar dada
                            age = tempAge;

                            break;

                        case 3: // ? Modificar pes
                            // Inicialització de variables
                            tempWeight = 0;

                            // Obtenció de la nova dada
                            inputLoop = true;
                            while (inputLoop) {
                                System.out.print("Introdueixi el seu pes (kg), si us plau: ");
                                input = scanner.nextLine();

                                // Validar pes
                                if (input.isBlank()) { // ? Està en blanc o només són espais en blanc
                                    System.out.println("El pes no pot estar en blanc. Si us plau, torni a intentar-ho:\n\n");
                                
                                } else { // ? Si hi ha contingut
                                    try {
                                        tempWeight = parseDouble(input);

                                        if (tempWeight < MIN_WEIGHT) { // ? El pes és menor a 0 kg (per defecte)
                                            System.out.printf("El pes no pot ser menor a %.2f kg. Si us plau, torni a intentar-ho:%n%n%n", MIN_WEIGHT);
                                        
                                        } else if (tempWeight > MAX_WEIGHT) { // ? El pes és major a 120 kg (per defecte)
                                            System.out.printf("El pes no pot ser major a %.2f kg. Si us plau, torni a intentar-ho:%n%n%n", MAX_WEIGHT);
                                        
                                        } else {
                                            inputLoop = false;
                                        }
                                    
                                    } catch (java.lang.NumberFormatException e) { // ? No és un nombre
                                        System.out.println("El pes ha de ser un nombre (enter o decimal). Si us plau, torni a intentar-ho:\n\n");
                                    
                                    } catch (Exception e) { // ? Altres
                                        System.out.println("Alguna cosa ha sortit malament. Si us plau, torni a intentar-ho:\n\n");
                                    }

                                }
                            }

                            // Guardar dada
                            weight = tempWeight;

                            break;
                    
                        case 4: // ? Modificar alçada
                            // Inicialització de variables
                            tempHeight = 0;

                            // Obtenció de la nova dada
                            inputLoop = true;
                            while (inputLoop) {
                                System.out.print("Introdueixi la seva alçada (m), si us plau: ");
                                input = scanner.nextLine();

                                // Validar alçada
                                if (input.isBlank()) { // ? Està en blanc o només són espais en blanc
                                    System.out.println("L'alçada no pot estar en blanc. Si us plau, torni a intentar-ho:\n\n");
                                
                                } else { // ? Si hi ha contingut
                                    try {
                                        tempHeight = parseDouble(input);

                                        if (tempHeight < MIN_HEIGHT) { // ? L'alçada és menor a 0.5m (per defecte)
                                            System.out.printf("L'alçada ha de ser igual o major a %.2fm. Si us plau, torni a intentar-ho:%n%n%n", MIN_HEIGHT);
                                        
                                        } else if (tempHeight > MAX_HEIGHT) { // ? L'alçada és major a 2.5m (per defecte)
                                            System.out.printf("L'alçada no pot ser major a %.2fm. Si us plau, torni a intentar-ho:%n%n%n", MAX_HEIGHT);
                                        
                                        } else {
                                            inputLoop = false;
                                        }
                                    
                                    } catch (java.lang.NumberFormatException e) { // ? No és un nombre
                                        System.out.println("L'alçada ha de ser un nombre. Si us plau, torni a intentar-ho:\n\n");
                                    
                                    } catch (Exception e) { // ? Altres
                                        System.out.println("Alguna cosa ha sortit malament. Si us plau, torni a intentar-ho:\n\n");
                                    }

                                }
                            }

                            // Guardar dada
                            height = tempHeight;
                            
                            break;
                    }

                    // * Finalització
                    System.out.println("\n\n");
                             
                    break;

                case 3: // * Càlcul i visualització de paràmetres
                    // * Validació
                    boolean canVisualize = (!name.isEmpty()) && (age != -1) && (weight != -1) && (height != -1);
                    if (!canVisualize) {
                        System.out.println("No s'han trobat dades. Si us plau, introdueixi les dades previament:\n\n");
                        break;
                    }

                    // * Declaració de variables
                    // Dades

                    // ? IMC
                    double imc;
                    String imcClassification;

                    // ? Freqüència cardíaca màxima estimada
                    int fcMax;

                    // ? Zones
                    final double MIN_ZONE = 0.50;
                    final double MAX_ZONE = 0.85;

                    int fcZMin;
                    int fcZMax;

                    // ? Aigua recomanada
                    double water;

                    // ? Any de naixement
                    int birthYear;

                    // Format del nom
                    String buffer; // ? Utilitzat per la capitalització del nom
                    boolean upper; // ? Determinar si la lletra es majúscula

                    // * Format
                    // Donar format al nom
                    tempName = name.trim().replaceAll("\\s+", " ").toLowerCase(); // ? Eliminar espais als costats | eliminar espais sobrants | passar a minúscules
                    
                    buffer = "";
                    for (int i = 0; i < tempName.length(); i++) {
                        char c = tempName.charAt(i);

                        upper = (i == 0 || tempName.charAt(i - 1) == ' '); // ? Serà majuscula si és la primera lletra del String o de la paraula

                        buffer += upper ? Character.toUpperCase(c) : c;
                    }

                    name = buffer;

                    // * Calcular paràmetres
                    // IMC
                    imc = weight / (height * height);
                    if (imc < 18.5) {
                        imcClassification = "pes baix";
                    
                    } else if (imc < 25) {
                        imcClassification = "pes normal";
                    
                    } else if (imc < 30) {
                        imcClassification = "sobrepès";
                    
                    } else {
                        imcClassification = "obesitat";
                    }

                    // Freqüència cardíaca màxima estimada
                    fcMax = 220 - age;
                    fcZMin = (int) Math.round(fcMax * MIN_ZONE);
                    fcZMax = (int) Math.round(fcMax * MAX_ZONE);

                    // Aigua diària recomanada
                    water = (35 * weight) / 1000;

                    // Any de naixement aproximat
                    int year = Year.now().getValue();
                    birthYear = year - age;

                    // * Mostrar paràmetres
                    System.out.println("== Dades ==");
                    System.out.printf("Hola, %s!%n", name);
                    System.out.printf("Edat: %d | Pes: %.2f kg | Alçada: %.2f m%n", age, weight, height);
                    System.out.printf("IMC: %.2f (%s)%n", imc, imcClassification);
                    System.out.printf("FC màxima estimada: %d bpm%n", fcMax);
                    System.out.printf("Zona FC objectiu: %d-%d bpm%n", fcZMin, fcZMax);
                    System.out.printf("Aigua recomanada: %.2f L/dia%n", water);
                    System.out.printf("Any de naixement aproximat: %d%n", birthYear);

                    // * Finalització
                    System.out.print("\nPrem enter per continuar: ");
                    scanner.nextLine();
                    System.out.println("\n\n");

                    break;

                case 4: // * Sortir
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
