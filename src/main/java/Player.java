import java.util.ArrayList;

public class Player {

    private String name;
    private Piece piece;

    private Board board;
    private Cup cup;

    private int cash;

    private final static int START_CASH = 1500;

    public Player(String name, Piece piece, Board board,Cup cup) {
        this.name = name;
        this.piece = piece;
        this.board = board;
        this.cup = cup;
        cash = START_CASH;
    }

    public String getName() {
        return name;
    }

    public Piece getPiece() {
        return piece;
    }

    /**
     * Roll dice and move the player to the corresponding location
     */
    public void takeTurn() {

        cup.roll();
        int fv = cup.getTotal();
        
        Square oldLoc = piece.getLocation();
        Square newLoc = board.getSquare(oldLoc, fv);

        piece.setLocation(newLoc);
        newLoc.landedOn(this);
    }

    public void setLocation(Square square){
        piece.setLocation(square);
    }

    public void addCash(int amount){
        cash += amount;
    }

    public int getNetWorth(){
        return cash;
    }

    public void reduceCash(int amount){
        cash -= amount;
    }
}
