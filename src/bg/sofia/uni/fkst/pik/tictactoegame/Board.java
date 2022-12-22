package bg.sofia.uni.fkst.pik.tictactoegame;

public class Board {
    public static final int BOARD_SIZE = 3;

    private int[][] board;  //declaring map

    public Board() {  //initializing map
        this.board = new int[BOARD_SIZE][BOARD_SIZE];
        int initializingMapValues = 0;
        for (int i = 0; i < board.length; i++) {

            for (int j = 0; j < board.length; j++) {

                board[i][j] = initializingMapValues++;

            }

        }

    }

    int[][] getBoard() {
        return board;
    }

    public void printBoard() {
        System.out.println();
        System.out.println("--------");
        for (int i = 0; i < board.length; i++) {

            for (int j = 0; j < board.length; j++) {
                if (board[i][j] > 8) {
                    char symbol = (char) board[i][j];
                    System.out.print(" " + symbol);
                } else {
                    System.out.print(" " + board[i][j]);
                }
            }
            System.out.println("\n--------");
        }

    }

    public void markTile(int positionToBeMarked, char symbol) {
        int counter = -1;

        try {
            if (positionToBeMarked < 0 || positionToBeMarked > 9) {
                throw new InvalidPosition("The position you entered is not a valid position on the map");
            }
        } catch (InvalidPosition e) {
            System.out.println(e.getMessage());
            return;
        }
        System.out.println("Position" + positionToBeMarked);
        for (int i = 0; i < board.length; i++) {

            for (int j = 0; j < board.length; j++) {
                counter++;
                if (counter == positionToBeMarked) {
                    board[i][j] = symbol;
                }

            }

        }

    }

    int checkColumn(int column, char symbol) {
        int symbolCounter = 0;
        for (int i = 0; i < board.length; i++) {  //checks for first column
            if (board[i][column] == symbol) {
                symbolCounter++;
            }//every symbol has an ASCII value bigger than the max value that is used in our array
            if (symbolCounter == 3) {
                return 1;
            }

        }
        return 0;
    }

    int checkRow(int row, char symbol) {
        int counter = 0;
        for (int i = 0; i < board.length; i++) {  //checks for first column
            if (board[row][i] == symbol) {
                counter++;
            }//every symbol has an ASCII value bigger than the max value that is used in our array
            if (counter == 3) {
                return 1;
            }

        }
        return 0;
    }

    int checkDiagonals(char symbol) {
        int counter = 0;
        int i = 0;
        while (i < board.length) {
            if (board[i][i] == symbol) {   //board[1][1]  board[2][2]
                counter++;

            }
            if (counter == 3) {
                return 1;
            }
            i++;
        }
        i = 0;
        counter = 0;
        int j = 2;
        while (i < board.length) {
            if (board[i][j] ==symbol) {   //board[1][1]  board[2][2]
                counter++;


            }
            if (counter == 3) {
                return 1;
            }
            i++;
            j--;
        }

        return 0;
    }

    boolean checkForWinner(char symbol) {

        int winner = checkDiagonals(symbol);
        if (winner != 0) {
            return true;
        }
        for (int i = 0; i < BOARD_SIZE; i++) {
            winner = checkColumn(i, symbol);
            if (winner != 0) {
                return true;
            }
        }

        for (int i = 0; i < BOARD_SIZE; i++) {
            winner = checkRow(i, symbol);
            if (winner!=0){
                return true;
            }
        }
        return false;


    }
}
