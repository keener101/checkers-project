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

	
	
	public boolean canJump(){
		return false;
	}
	
	public void move(){
		
	}
	
	public void jump(){
		
	}

}
