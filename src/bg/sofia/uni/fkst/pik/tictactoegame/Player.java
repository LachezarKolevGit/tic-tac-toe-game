package bg.sofia.uni.fkst.pik.tictactoegame;

public class Player {

    private String name;
    private char symbol;
    private int winCounter;

    Player(String name, char symbol ){
        this.name=name;
        this.symbol=symbol;
        this.winCounter=0;
    }
    
    String getName(){
        return name;
    }

    char getSymbol(){
        return symbol;
    }

}
