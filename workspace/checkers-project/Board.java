/**
 * 
 * Represents a Checkers board
 * 
 * @author Keener
 *
 */
public class Board {
	
	private boolean blackTurn;
	private Space[][] board;
	
	public Board(){
		blackTurn = true;
		
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){
				new Space();
			}
		}
		
		
		
		
	}

}
