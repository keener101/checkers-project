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
		
		for(int i = 0; i < 3; i++){		//makes initial black pieces
			if(i+1 % 2 == 1){			//if odd number row (1st row, 3rd row)
				for(int j = 1; j < 8; j = j+2){
					board[i][j].setPiece(new Checker(true));
				}
			} else {					//if even number row (2nd row)
				for(int j = 0; j < 8; j = j+2){
					board[i][j].setPiece(new Checker(true));
				}
			}

		}
		
		for(int i = 5; i < 8; i++){		//makes initial red pieces
			if(i+1 % 2 == 1){			//if odd number row (7th row)
				for(int j = 1; j < 8; j = j+2){
					board[i][j].setPiece(new Checker(false));
				}
			} else {					//if even number row (6th row, 8th row)
				for(int j = 0; j < 8; j = j+2){
					board[i][j].setPiece(new Checker(false));
				}
			}

		}
	}

		
	}

