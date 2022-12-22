package bg.sofia.uni.fkst.pik.tictactoegame;

import java.util.IllegalFormatCodePointException;
import java.util.Scanner;

public class GameInterface {
    private Board board;
    private Player player1;
    private Player player2;
    private int turn;
    private int state;

    GameInterface(String player1Name, String player2Name) {
        this.board = new Board();
        this.player1 = new Player(player1Name, 'X');
        this.player2 = new Player(player2Name, 'Q');
        this.turn = 0;
        this.state = 0;
    }


    void play() {
        int positionToBeMarked = 0;
        Scanner input = new Scanner(System.in);
        System.out.println("Game is starting");
        this.state = 1;
        while (state == 1) {
            board.printBoard();
            if (turn % 2 == 0) {
                System.out.println("It is " + player1.getName() + "'s turn");
                positionToBeMarked = input.nextInt();
                board.markTile(positionToBeMarked, player1.getSymbol());
                boolean win = board.checkForWinner(player1.getSymbol());
                if (win) {
                    System.out.println(player1.getName() + "wins !");
                    return;
                }
                turn++;
            } else {
                System.out.println("It is " + player2.getName() + "'s turn");
                positionToBeMarked = input.nextInt();
                board.markTile(positionToBeMarked, player2.getSymbol());
                boolean win = board.checkForWinner(player2.getSymbol());
                if (win) {
                    System.out.println(player2.getName() + "wins !");
                    return;
                }
                turn++;
            }
        }

    }


}
