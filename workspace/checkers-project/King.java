/**
 * Represents a King piece in Checkers. Child of Checker
 * 
 * @author Keener
 *
 */
public class King extends Checker {
	
	public King(Color kingColor, Space kingSpace){
		super(kingColor, kingSpace);
	}
	
	//TODO all of the necessary methods that King should override
	
	public boolean canMove(Board board){			
		boolean retVal = false;

			if(checkerSpace.getRow() > 0){			//check all upwards moves
				if(checkerSpace.getCol() == 0){		//if on left edge, can only check right
					retVal = board.getSpace(checkerSpace.getRow()-1, checkerSpace.getCol()+1).getPiece() == null;
				} else if (checkerSpace.getCol() == 7){	//if on right edge, can only check right
					retVal = board.getSpace(checkerSpace.getRow()-1, checkerSpace.getCol()-1).getPiece() == null;
				} else {		//else, check both left and right and if either are empty, valid move
					retVal = (board.getSpace(checkerSpace.getRow()-1, checkerSpace.getCol()+1).getPiece() == null 
							|| board.getSpace(checkerSpace.getRow()-1, checkerSpace.getCol()-1).getPiece() == null);
				}
			}
			
			if(checkerSpace.getRow() < 7){			//check all downwards moves
				if(checkerSpace.getCol() == 0){		//if on left edge, can only check right
					retVal = board.getSpace(checkerSpace.getRow()+1, checkerSpace.getCol()+1).getPiece() == null;
				} else if (checkerSpace.getCol() == 7){	//if on right edge, can only check right
					retVal = board.getSpace(checkerSpace.getRow()+1, checkerSpace.getCol()-1).getPiece() == null;
				} else {		//else, check both left and right and if either are empty, valid move
					retVal = (board.getSpace(checkerSpace.getRow()+1, checkerSpace.getCol()+1).getPiece() == null 
							|| board.getSpace(checkerSpace.getRow()+1, checkerSpace.getCol()-1).getPiece() == null);
				}
			}
			

			System.out.println(retVal);
			return retVal;	
			
		}

	
	
	public boolean canJump(Board board){

		boolean retVal = false;

			if(checkerSpace.getRow() > 1){	// only rows that can jump forward
				if(checkerSpace.getCol() < 2){	//if one of the two leftmost columns, can only jump rightwards
					
					//this checks for jumps that are up and to the right for left edges
					if(board.getSpace(checkerSpace.getRow()-1, checkerSpace.getCol()+1).getPiece() != null 
							&& board.getSpace(checkerSpace.getRow()-1, checkerSpace.getCol()+1).getPiece().getColor() == Color.BLACK 
							&& board.getSpace(checkerSpace.getRow()-2, checkerSpace.getCol()+2).getPiece() == null){
						retVal = true;
					}
				} else if (checkerSpace.getCol() > 5){ //if one two rightmost columns, can only jump left
					
					//this checks for jumps up and left for right edges
					if(board.getSpace(checkerSpace.getRow()-1, checkerSpace.getCol()-1).getPiece() != null 
							&& board.getSpace(checkerSpace.getRow()-1, checkerSpace.getCol()-1).getPiece().getColor() == Color.BLACK 
							&& board.getSpace(checkerSpace.getRow()-2, checkerSpace.getCol()-2).getPiece() == null){
						retVal = true;
					}
				} else { //if somewhere in middle 4 rows, can jump to both left and right
					
					//this checks for jumps up and right for middle
					if(board.getSpace(checkerSpace.getRow()-1, checkerSpace.getCol()+1).getPiece() != null 
							&& board.getSpace(checkerSpace.getRow()-1, checkerSpace.getCol()+1).getPiece().getColor() == Color.BLACK 
							&& board.getSpace(checkerSpace.getRow()-2, checkerSpace.getCol()+2).getPiece() == null){
						retVal = true;
					}

					//this checks for jumps up and left for middle
					if(board.getSpace(checkerSpace.getRow()-1, checkerSpace.getCol()-1).getPiece() != null 
							&& board.getSpace(checkerSpace.getRow()-1, checkerSpace.getCol()-1).getPiece().getColor() == Color.BLACK 
							&& board.getSpace(checkerSpace.getRow()-2, checkerSpace.getCol()-2).getPiece() == null){
						retVal = true;
					}
				}
			}
			
			if(checkerSpace.getRow() < 6){	//only downwards jumps
				if(checkerSpace.getCol() < 2){	//if one of the two leftmost columns, can only jump rightwards
					
					//this checks for jumps down and to the right for left edges
					if(board.getSpace(checkerSpace.getRow()+1, checkerSpace.getCol()+1).getPiece() != null 
							&& board.getSpace(checkerSpace.getRow()+1, checkerSpace.getCol()+1).getPiece().getColor() == Color.RED 
							&& board.getSpace(checkerSpace.getRow()+2, checkerSpace.getCol()+2).getPiece() == null){
						retVal = true;
					}
				} else if (checkerSpace.getCol() > 5){ //if one two rightmost columns, can only jump left
					
					//this checks for jumps down and to the left for right edges
					if(board.getSpace(checkerSpace.getRow()+1, checkerSpace.getCol()-1).getPiece() != null 
							&& board.getSpace(checkerSpace.getRow()+1, checkerSpace.getCol()-1).getPiece().getColor() == Color.RED 
							&& board.getSpace(checkerSpace.getRow()+2, checkerSpace.getCol()-2).getPiece() == null){
						retVal = true;
					}
				} else { //if somewhere in middle 4 rows, can jump to both left and right
					
					//this checks for jumps down and right for middle
					if(board.getSpace(checkerSpace.getRow()+1, checkerSpace.getCol()+1).getPiece() != null 
							&& board.getSpace(checkerSpace.getRow()+1, checkerSpace.getCol()+1).getPiece().getColor() == Color.RED 
							&& board.getSpace(checkerSpace.getRow()+2, checkerSpace.getCol()+2).getPiece() == null){
						retVal = true;
					}
					
					//this checks for jumps down and left for middle
					if(board.getSpace(checkerSpace.getRow()+1, checkerSpace.getCol()-1).getPiece() != null 
							&& board.getSpace(checkerSpace.getRow()+1, checkerSpace.getCol()-1).getPiece().getColor() == Color.RED 
							&& board.getSpace(checkerSpace.getRow()+2, checkerSpace.getCol()-2).getPiece() == null){
						retVal = true;
					}
				}
			}

		return retVal;
	}
	
	public void move(){
		
	}
	
	public void jump(){
		
	}

}
