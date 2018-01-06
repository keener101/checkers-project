/**
 * 
 * This represents a given space on a Board object
 * 
 * @author Keener
 *
 */


public class Space {
	
	private Checker piece;
	private int row;
	private int col;
	
	public Space(int row, int col) {
		piece = null;
		this.row = row;
		this.col = col;
		
	}
	
	public Space(Checker piece, int row, int col){
		this.piece = piece;
		this.row = row;
		this.col = col;
	}
	
	public Checker getPiece() {
		Checker thisPiece = piece;
		return thisPiece;
	}
	
	public void setPiece(Checker newPiece){
		piece = newPiece;
	}
	
	public void movePiece(Space newSpace){
		newSpace.setPiece(piece);
		piece = null;
	}

}
