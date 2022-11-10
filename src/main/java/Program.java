import Chess.ChessGame;
import Chess.Tuple;
import Console.InputHandler;
import Console.BoardDisplay;

import java.util.Scanner;


public class Program {

    public static void main(String args[]) throws Exception {
        InputHandler handler = new InputHandler();
        Scanner scanner = new Scanner(System.in);

        int gamemode = displayMainMenu(scanner);

        ChessGame game = new ChessGame();
        BoardDisplay.clearConsole();
        BoardDisplay.printBoard(game.getBoard());
        while (!game.isFinished()) {
            System.out.println("Enter move (eg. A2-A3): ");
            String input = scanner.nextLine();

            if (!handler.isValid(input)) {
                System.out.println("Invalid input!");
                System.out.println("Valid input is in form: A2-A3");
            } else {
                Tuple from = handler.getFrom(input);
                Tuple to = handler.getTo(input);

                boolean movePlayed = game.playMove(from, to);
                if (!movePlayed)
                    System.out.println("Illegal move!");
                else {
                    BoardDisplay.clearConsole();
                    BoardDisplay.printBoard(game.getBoard());
                }
            }
        }
        scanner.close();
        System.out.println("Game has finished. Thanks for playing.");
    }

    public static int displayMainMenu(Scanner scanner) {
        System.out.println("Welcome to Chess!");
        int option = 0;
        
        boolean complete = false;
        while(!complete) {
            System.out.println("Please select your mode.");
    
            String[] options = new String[] {"1 - Regular Rules"};
    
            for(int i = 0; i < options.length; i++) {
                System.out.println(options[i]);
            }
            System.out.println("0 - Exit");

            String input = scanner.nextLine();
            try {
                option = Integer.parseInt(input);
            } catch (Exception ex) {

            }

            if (option >= 0 && option <= options.length) {
                complete = true;
            }

            if (option == 0) {
                System.exit(0);
            }
        }

        return option;
    }
}
