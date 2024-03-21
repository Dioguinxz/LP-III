package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        int option;

        do {
            option = printMenu(teclado);

            switch (option) {
                case 1:
                    System.out.println("Enter the height:");
                    double height = teclado.nextDouble();

                    System.out.println("Enter the weight:");
                    double weight = teclado.nextDouble();

                    CalcIMC calcIMC = new CalcIMC();
                    System.out.println("");
                    System.out.println("--------------------------------");
                    calcIMC.CalculteIMC( weight, height);
                    System.out.println("--------------------------------");
                    System.out.println(" ");
                    break;

                case 2:
                    int optionCurrency;
                    do {
                        optionCurrency = printMenuCurrencyConversor(teclado);
                        switch (optionCurrency) {
                            case 1:
                                System.out.println("Enter dollar value:");
                                double dollarValueReal = teclado.nextDouble();
                                CurrencyConverter currencyConverter1 = new CurrencyConverter();
                                currencyConverter1.convertDolarToReal(dollarValueReal);
                                break;


                            case 2:
                                System.out.println("Enter dollar value:");
                                double dollarValueEuro = teclado.nextDouble();
                                CurrencyConverter currencyConverter2 = new CurrencyConverter();
                                currencyConverter2.convertDolarToEuro(dollarValueEuro);
                                break;

                            case 3:
                                System.out.println("Enter dollar value:");
                                double dollarValueLibra = teclado.nextDouble();
                                CurrencyConverter currencyConverter3 = new CurrencyConverter();
                                currencyConverter3.convertDolarToEuro(dollarValueLibra);
                                break;

                            case 4:
                                break;
                            case 5:
                                System.out.println("See you!");
                                System.exit(0);
                            default:
                                System.err.println("Invalid option. Type again");
                        }
                    } while (optionCurrency != 4);
                    break;

                case 3:
                    logicHangMan(teclado);
                    break;

                case 4:
                    System.out.println("See you!");
                    System.exit(0);
                    break;

                default:
                    System.err.println("Invalid option. Type again");
                    break;
            }
        } while (option != 4);
    }

    private static int printMenuCurrencyConversor(Scanner teclado) {
        int optionCurrency;
        System.out.println(" ");
        System.out.println("!-------------------------------------------------------------------!");
        System.out.println("!                        Currency Converter                         !");
        System.out.println("!-------------------------------------------------------------------!");
        System.out.println("! 1- Convert Dollar to Real                                         !");
        System.out.println("! 2- Convert Dollar to Euro                                         !");
        System.out.println("! 3- Convert Dollar to Libra                                        !");
        System.out.println("! 4- Back to menu                                                   !");
        System.out.println("! 5- Quit                                                           !");
        System.out.println("!-------------------------------------------------------------------!");
        optionCurrency = teclado.nextInt();
        return optionCurrency;
    }

    private static void logicHangMan(Scanner teclado) {
        int letterSize = printMenuHangMan(teclado);

        // load random word
        WordLoader wordLoader = new WordLoader(letterSize);
        String wordToPlay = wordLoader.load();

        // guess the word
        GuessWord guessWord = new GuessWord(wordToPlay);
        int maxAttempts = 10;
        int currentAtemmpts = 0;
        List<Integer> currentPosition = new ArrayList<>();
        List<Character> currentGuessedWord = new ArrayList<>();
        for (int index = 0; index < wordToPlay.length(); index++) {
            currentGuessedWord.add('_');
        }

        // Count attempts
        boolean win = false;
        for (int attempt = 1; attempt < maxAttempts; attempt++) {
            System.out.print("\nEnter a letter: ");
            String letter = teclado.next();

            if (letter.length() > 1) {
                System.out.println("Invalid letter. Enter a valid letter");
            }
            Integer[] positionsFound = guessWord.letterExist(letter.charAt(0));
            List<Integer> positions = new ArrayList<>(List.of(positionsFound));
            //currentPosition.addAll(List.of(positions));
            // accumulate the previous guesses characteres
            if (positions.isEmpty()) {
                currentAtemmpts++;
                System.out.println("Incorrect answer! Now you have " + (maxAttempts - currentAtemmpts) + " attempts.");
                printForca(currentGuessedWord, wordToPlay, currentPosition, letter.charAt(0));
            } else {
                // show guess
                System.out.println();
                printForca(currentGuessedWord, wordToPlay, positions, letter.charAt(0));
            }

            if (currentGuessedWord.stream().noneMatch((a) -> a.equals('_'))) {
                System.out.println("\nYou won!");
                win = true;
                break;
            }
        }
        if (!win) System.out.println("Game Over!");
    }

    private static int printMenuHangMan(Scanner teclado) {
        System.out.println(" ");
        System.out.println("!------------------------------------------------------------------------!");
        System.out.println("!                           HangMan Game                                 !");
        System.out.println("!------------------------------------------------------------------------!");
        // ask the word size
        System.out.println("!                                                                        !");
        System.out.println("! How many letters would you like to play? It might be 3, 4 or 5         !");
        System.out.println("!------------------------------------------------------------------------!");
        int letterSize = teclado.nextInt();
        return letterSize;
    }

    private static int printMenu(Scanner teclado) {
        int option;
        System.out.println("!----------------------------------------------------!");
        System.out.println("!                        MENU                        !");
        System.out.println("!----------------------------------------------------!");
        System.out.println("! 1- Calculate IMC                                   !");
        System.out.println("! 2- Currency Converter                              !");
        System.out.println("! 3- HangMan Game                                    !");
        System.out.println("! 4- Quit                                            !");
        System.out.println("!----------------------------------------------------!");
        option = teclado.nextInt();
        return option;
    }

    private static void printForca(List<Character> guessedLetters, String wordToPlay, List<Integer> positions, Character letter) {
        for (int index = 0; index < wordToPlay.length(); index++) {
            int finalIndex = index;
            boolean positionExists = positions.stream().anyMatch((pos) -> finalIndex == pos);
            if (positionExists) {
                guessedLetters.set(index, letter);
                System.out.print(letter);
            } else {
                System.out.print(guessedLetters.get(index));
            }
        }
    }
}
