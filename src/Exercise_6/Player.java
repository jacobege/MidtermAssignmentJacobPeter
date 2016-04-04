package Exercise_6;

public class Player {
    private final IDie[] _dice;
    private final IBoard _board;
    private final IPiece _piece;
    
    public Player(IBoard board, IDie[] dice, IPiece piece) {
        _board = board;
        _dice = dice;
        _piece = piece;
    }
    
    public void takeTurn() {
        int faceValues = 0;
        
        for (IDie die : _dice) {
            die.roll();
            faceValues += die.getFaceValue();
        }
        
        int oldLocation = _piece.getLocation();
        int newLocation = _board.getSquare(oldLocation, faceValues);
        _piece.setLocation(newLocation);
    }
}