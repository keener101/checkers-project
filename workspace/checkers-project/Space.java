/**
 * 
 * This represents a given space on a Board object
 * 
 * @author Keener
 *
 */


public class Space {
	
	private Checker piece;
	
	public Space() {
		piece = null;
		
	}
	
	public Space(Checker thisChecker){
		piece = thisChecker;
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
