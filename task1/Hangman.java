import java.util.ArrayList;
import java.util.Random;
import java.util.Arrays;
import java.util.Scanner;

public class Hangman {
    private static final String[] words = {"senla","code","java","programming","algorithm","computer","array","script "};
    private static final int attemps = 8;
    private Random random;
    private String wordToGuess;
    private char[] guessedWord;
    private ArrayList<Character> wrongGuesses;
    private int remainingAttempts;

    public Hangman() {
        random = new Random();
        wordToGuess = words[(int)(random.nextInt(0,words.length))];

        guessedWord = new char[wordToGuess.length()];
        Arrays.fill(guessedWord, '_');
        wrongGuesses = new ArrayList<>();
        remainingAttempts = attemps;
    }
    public void play() {
        Scanner scanner = new Scanner(System.in);
        while (remainingAttempts > 0 && !isWordGuessed()) {
            State();
            System.out.print("Введите букву(ENG): ");
            char guess = scanner.nextLine().charAt(0);

            if (isValidGuess(guess)) {
                if (wordToGuess.indexOf(guess) >= 0) {
                    updateGuessedWord(guess);
                } else {
                    wrongGuesses.add(guess);
                    remainingAttempts--;
                }
            } else {
                System.out.println("Вы уже вводили эту букву.Или введен некорректный символ. Попробуйте другую.");
            }
        }

        if (isWordGuessed()) {
            System.out.println("Поздравляем! Слово угадано: " + wordToGuess);
        } else {
            System.out.println("Вы проиграли! Загаданное слово: " + wordToGuess);
        }
        scanner.close();
    }

    private void State() {
        System.out.println("\nСлово: " + String.valueOf(guessedWord));
        System.out.println("Не правильные буквы: " + wrongGuesses);
        System.out.println("Осталось попыток: " + remainingAttempts);
        printHangman();
    }

    private boolean isWordGuessed() {
        return String.valueOf(guessedWord).equals(wordToGuess);
    }

    private boolean isValidGuess(char guess) {
        return Character.isLetter(guess) && !wrongGuesses.contains(guess) && !isGuessed(guess);
    }

    private void updateGuessedWord(char guess) {
        for (int i = 0; i < wordToGuess.length(); i++) {
            if (wordToGuess.charAt(i) == guess) {
                guessedWord[i] = guess;
            }
        }
    }

    private boolean isGuessed(char letter) {
        for (char c : guessedWord) {
            if (c == letter) {
                return true;
            }
        }
        return false;
    }

    private void printHangman() {
        System.out.println("  -----  ");
        System.out.print  ("  |"); if (remainingAttempts < 8) System.out.println("/  |   "); else System.out.println("");
        System.out.print("  |"); if (remainingAttempts < 7) System.out.println("   O   "); else System.out.println("");
        System.out.print("  |"); if (remainingAttempts < 6) System.out.print("  /"); if (remainingAttempts < 5) System.out.print("|"); if (remainingAttempts < 4) System.out.println("\\"); else System.out.println("");
        System.out.print("  |  ");if (remainingAttempts < 3) System.out.print("/");if (remainingAttempts < 2) System.out.println(" \\");else System.out.println("");
        System.out.println("  |");
    }

    public static void main(String[] args) {
        Hangman game = new Hangman();
        game.play();
    }
}
