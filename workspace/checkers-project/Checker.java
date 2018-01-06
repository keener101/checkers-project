/**
 * 
 * This represents a single checker piece.
 * 
 * 
 * @author Keener
 *
 */
public class Checker {
	
	
	Color checkerColor; 
	Space checkerSpace;
	
	public Checker(Color checkerColor, Space checkerSpace){
		this.checkerColor = checkerColor;
		this.checkerSpace = checkerSpace;
	}
	
	public Color getColor(){
		Color thisColor = checkerColor; 
		return thisColor;
	}
	
	public Space getSpace(){
		Space thisSpace = checkerSpace;
		return thisSpace;
	}
	
	public void setSpace(Space newSpace){
		checkerSpace = newSpace;
	}
	
	public boolean canMove(){			//TODO this only currently checks moves into empty spaces, not jumps
		boolean retVal = false;
		
		if(checkerColor == Color.RED){				//if RED, checker needs open space in one of the forward diagonals
			if(checkerSpace.getRow() > 0){			//can't move forward if at front (king situation)
				if(checkerSpace.getCol() == 0){		//if on left edge, can only check right
					retVal = Board.getSpace(checkerSpace.getRow()-1, checkerSpace.getCol()+1).getPiece() == null;
				} else if (checkerSpace.getCol() == 7){	//if on right edge, can only check right
					retVal = Board.getSpace(checkerSpace.getRow()-1, checkerSpace.getCol()-1).getPiece() == null;
				} else {		//else, check both left and right and if either are empty, valid move
					retVal = (Board.getSpace(checkerSpace.getRow()-1, checkerSpace.getCol()+1).getPiece() == null || Board.getSpace(checkerSpace.getRow()-1, checkerSpace.getCol()-1).getPiece() == null);
				}
			}
		} else {									//if BLACK, needs open space in one of the backwards diagonals
			if(checkerSpace.getRow() < 7){			//can't move backwards if at back (king situation)
				if(checkerSpace.getCol() == 0){		//if on left edge, can only check right
					retVal = Board.getSpace(checkerSpace.getRow()+1, checkerSpace.getCol()+1).getPiece() == null;
				} else if (checkerSpace.getCol() == 7){	//if on right edge, can only check right
					retVal = Board.getSpace(checkerSpace.getRow()+1, checkerSpace.getCol()-1).getPiece() == null;
				} else {		//else, check both left and right and if either are empty, valid move
					retVal = (Board.getSpace(checkerSpace.getRow()+1, checkerSpace.getCol()+1).getPiece() == null || Board.getSpace(checkerSpace.getRow()+1, checkerSpace.getCol()-1).getPiece() == null);
				}
			}
		}
		
		System.out.println(retVal);
		return retVal;
	}
}
