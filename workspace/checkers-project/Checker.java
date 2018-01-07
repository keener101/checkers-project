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

	public boolean canMove(){			
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

	//TODO: make this method check if a jump is possible

	public boolean canJump(){

		boolean retVal = false;

		if(checkerColor == Color.RED){	//if red, there must a black checker in a upwards diagonal
			//AND an empty space in the diagonal behind the black checker
			if(checkerSpace.getRow() > 1){	//if in two first rows, can't jump
				if(checkerSpace.getCol() < 2){	//if one of the two leftmost columns, can only jump rightwards
					if(Board.getSpace(checkerSpace.getRow()-1, checkerSpace.getCol()+1).getPiece() != null 
						&& Board.getSpace(checkerSpace.getRow()-1, checkerSpace.getCol()+1).getPiece().getColor() == Color.BLACK 
						&& Board.getSpace(checkerSpace.getRow()-2, checkerSpace.getCol()+2).getPiece() == null){
							retVal = true;
					}
				} else if (checkerSpace.getCol() > 5){ //if one two rightmost columns, can only jump left
					if(Board.getSpace(checkerSpace.getRow()-1, checkerSpace.getCol()-1).getPiece() != null 
							&& Board.getSpace(checkerSpace.getRow()-1, checkerSpace.getCol()-1).getPiece().getColor() == Color.BLACK 
							&& Board.getSpace(checkerSpace.getRow()-2, checkerSpace.getCol()-2).getPiece() == null){
								retVal = true;
						}
				} else { //if somewhere in middle 4 rows, can jump to both left and right
					if(Board.getSpace(checkerSpace.getRow()-1, checkerSpace.getCol()+1).getPiece() != null 
							&& Board.getSpace(checkerSpace.getRow()-1, checkerSpace.getCol()+1).getPiece().getColor() == Color.BLACK 
							&& Board.getSpace(checkerSpace.getRow()-2, checkerSpace.getCol()+2).getPiece() == null){
								retVal = true;
						}
					
					if(Board.getSpace(checkerSpace.getRow()-1, checkerSpace.getCol()-1).getPiece() != null 
							&& Board.getSpace(checkerSpace.getRow()-1, checkerSpace.getCol()-1).getPiece().getColor() == Color.BLACK 
							&& Board.getSpace(checkerSpace.getRow()-2, checkerSpace.getCol()-2).getPiece() == null){
								retVal = true;
						}
				}
			}
		} else if (checkerColor == Color.BLACK){	//if black, there must a red checker in a downwards diagonal
			//AND an empty space in the diagonal behind the red checker
			if(checkerSpace.getRow() < 6){	//if in two last rows, can't jump
				if(checkerSpace.getCol() < 2){	//if one of the two leftmost columns, can only jump rightwards
					if(Board.getSpace(checkerSpace.getRow()+1, checkerSpace.getCol()+1).getPiece() != null 
						&& Board.getSpace(checkerSpace.getRow()+1, checkerSpace.getCol()+1).getPiece().getColor() == Color.RED 
						&& Board.getSpace(checkerSpace.getRow()+2, checkerSpace.getCol()+2).getPiece() == null){
							retVal = true;
					}
				} else if (checkerSpace.getCol() > 5){ //if one two rightmost columns, can only jump left
					if(Board.getSpace(checkerSpace.getRow()+1, checkerSpace.getCol()-1).getPiece() != null 
							&& Board.getSpace(checkerSpace.getRow()+1, checkerSpace.getCol()-1).getPiece().getColor() == Color.RED 
							&& Board.getSpace(checkerSpace.getRow()+2, checkerSpace.getCol()-2).getPiece() == null){
								retVal = true;
						}
				} else { //if somewhere in middle 4 rows, can jump to both left and right
					if(Board.getSpace(checkerSpace.getRow()+1, checkerSpace.getCol()+1).getPiece() != null 
							&& Board.getSpace(checkerSpace.getRow()+1, checkerSpace.getCol()+1).getPiece().getColor() == Color.RED 
							&& Board.getSpace(checkerSpace.getRow()+2, checkerSpace.getCol()+2).getPiece() == null){
								retVal = true;
						}
					
					if(Board.getSpace(checkerSpace.getRow()+1, checkerSpace.getCol()-1).getPiece() != null 
							&& Board.getSpace(checkerSpace.getRow()+1, checkerSpace.getCol()-1).getPiece().getColor() == Color.RED 
							&& Board.getSpace(checkerSpace.getRow()+2, checkerSpace.getCol()-2).getPiece() == null){
								retVal = true;
						}
				}
			}
		}

		return retVal;
	}

	//TODO: make this method move a piece

	public void move(){

	}

	//TODO: make this method jump

	public void jump(){

	}

	//TODO: make this method replace the Checker with a King

	public void kingMe(){

	}
}
