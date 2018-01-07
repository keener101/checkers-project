import java.util.ArrayList;

/**
 * 
 * Represents a Checkers board
 * 
 * @author Keener
 * @author Ames
 *
 */
public class Board {

	private boolean blackTurn;
	private static Space[][] board;
	private ArrayList<Checker> blackPieces;
	private ArrayList<Checker> redPieces;

	public Board(){
		blackTurn = true; 
		blackPieces = new ArrayList<Checker>();
		redPieces = new ArrayList<Checker>();

		board = new Space[8][8]; 

		for(int i = 0; i < 8; i++){ //initializing all the board spaces 8x8
			for(int j = 0; j < 8; j++){
				Space s = new Space(i, j);
				board[i][j] = s;
			}
		}

		for(int i = 0; i < 3; i++){		//makes initial black pieces
			if(i % 2 == 1){			//if odd number row (1st row, 3rd row)
				for(int j = 1; j < 8; j = j+2){
					Checker newChecker = new Checker(Color.BLACK, board[i][j]);
					blackPieces.add(newChecker);
					board[i][j].setPiece(newChecker);
				}
			} else {					//if even number row (2nd row)
				for(int j = 0; j < 8; j = j+2){
					Checker newChecker = new Checker(Color.BLACK, board[i][j]);
					blackPieces.add(newChecker);
					board[i][j].setPiece(newChecker);
				}
			}
		}

		//TODO add similar logic as above when creating red pieces and add to red ArrayList
		
		for(int i = 5; i < 8; i++){		//makes initial red pieces
			if(i % 2 == 0){			//if odd number row (7th row)
				for(int j = 1; j < 8; j = j+2){
					board[i][j].setPiece(new Checker(Color.RED, board[i][j]));
				}
			} else {					//if even number row (6th row, 8th row)
				for(int j = 0; j < 8; j = j+2){
					board[i][j].setPiece(new Checker(Color.RED, board[i][j]));
				}
			}

		}
	}

	public String toString(){
		String retVal = "";

		for (int i = 0; i < 8; i++){
			retVal += "\n";
			for (int j = 0; j < 8; j++){
				if(board[i][j].getPiece() == null){
					retVal += "O";
				} else if(board[i][j].getPiece().getColor() == Color.RED) {
					retVal += "R";
				} else {
					retVal += "B";
				}
			}
		}

		return retVal;

	}

	public static Space getSpace(int row, int col){
		
		try{
			if(row > 7 || row < 0 || col > 7 || col < 0){
				throw new Exception();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return board[row][col];
	}

}