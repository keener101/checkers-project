import java.util.ArrayList;

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

	public boolean canMove(Board board){			
		boolean retVal = false;

		if(checkerColor == Color.RED){				//if RED, checker needs open space in one of the forward diagonals
			if(checkerSpace.getRow() > 0){			//can't move forward if at front (king situation)
				if(checkerSpace.getCol() == 0){		//if on left edge, can only check right
					retVal = board.getSpace(checkerSpace.getRow()-1, checkerSpace.getCol()+1).getPiece() == null;
				} else if (checkerSpace.getCol() == 7){	//if on right edge, can only check right
					retVal = board.getSpace(checkerSpace.getRow()-1, checkerSpace.getCol()-1).getPiece() == null;
				} else {		//else, check both left and right and if either are empty, valid move
					retVal = (board.getSpace(checkerSpace.getRow()-1, checkerSpace.getCol()+1).getPiece() == null 
						|| board.getSpace(checkerSpace.getRow()-1, checkerSpace.getCol()-1).getPiece() == null);
				}
			}
		} else {									//if BLACK, needs open space in one of the backwards diagonals
			if(checkerSpace.getRow() < 7){			//can't move backwards if at back (king situation)
				if(checkerSpace.getCol() == 0){		//if on left edge, can only check right
					retVal = board.getSpace(checkerSpace.getRow()+1, checkerSpace.getCol()+1).getPiece() == null;
				} else if (checkerSpace.getCol() == 7){	//if on right edge, can only check right
					retVal = board.getSpace(checkerSpace.getRow()+1, checkerSpace.getCol()-1).getPiece() == null;
				} else {		//else, check both left and right and if either are empty, valid move
					retVal = (board.getSpace(checkerSpace.getRow()+1, checkerSpace.getCol()+1).getPiece() == null 
						|| board.getSpace(checkerSpace.getRow()+1, checkerSpace.getCol()-1).getPiece() == null);
				}
			}
		}

		System.out.println(retVal);
		return retVal;
	}

	public boolean canJump(Board board){

		boolean retVal = false;

		if(checkerColor == Color.RED){	//if red, there must a black checker in a upwards diagonal
			//AND an empty space in the diagonal behind the black checker
			if(checkerSpace.getRow() > 1){	//if in two first rows, can't jump
				if(checkerSpace.getCol() < 2){	//if one of the two leftmost columns, can only jump rightwards
					if(board.getSpace(checkerSpace.getRow()-1, checkerSpace.getCol()+1).getPiece() != null 
							&& board.getSpace(checkerSpace.getRow()-1, checkerSpace.getCol()+1).getPiece().getColor() == Color.BLACK 
							&& board.getSpace(checkerSpace.getRow()-2, checkerSpace.getCol()+2).getPiece() == null){
						retVal = true;
					}
				} else if (checkerSpace.getCol() > 5){ //if one two rightmost columns, can only jump left
					if(board.getSpace(checkerSpace.getRow()-1, checkerSpace.getCol()-1).getPiece() != null 
							&& board.getSpace(checkerSpace.getRow()-1, checkerSpace.getCol()-1).getPiece().getColor() == Color.BLACK 
							&& board.getSpace(checkerSpace.getRow()-2, checkerSpace.getCol()-2).getPiece() == null){
						retVal = true;
					}
				} else { //if somewhere in middle 4 rows, can jump to both left and right
					if(board.getSpace(checkerSpace.getRow()-1, checkerSpace.getCol()+1).getPiece() != null 
							&& board.getSpace(checkerSpace.getRow()-1, checkerSpace.getCol()+1).getPiece().getColor() == Color.BLACK 
							&& board.getSpace(checkerSpace.getRow()-2, checkerSpace.getCol()+2).getPiece() == null){
						retVal = true;
					}

					if(board.getSpace(checkerSpace.getRow()-1, checkerSpace.getCol()-1).getPiece() != null 
							&& board.getSpace(checkerSpace.getRow()-1, checkerSpace.getCol()-1).getPiece().getColor() == Color.BLACK 
							&& board.getSpace(checkerSpace.getRow()-2, checkerSpace.getCol()-2).getPiece() == null){
						retVal = true;
					}
				}
			}
		} else if (checkerColor == Color.BLACK){	//if black, there must a red checker in a downwards diagonal
			//AND an empty space in the diagonal behind the red checker
			if(checkerSpace.getRow() < 6){	//if in two last rows, can't jump
				if(checkerSpace.getCol() < 2){	//if one of the two leftmost columns, can only jump rightwards
					if(board.getSpace(checkerSpace.getRow()+1, checkerSpace.getCol()+1).getPiece() != null 
							&& board.getSpace(checkerSpace.getRow()+1, checkerSpace.getCol()+1).getPiece().getColor() == Color.RED 
							&& board.getSpace(checkerSpace.getRow()+2, checkerSpace.getCol()+2).getPiece() == null){
						retVal = true;
					}
				} else if (checkerSpace.getCol() > 5){ //if one two rightmost columns, can only jump left
					if(board.getSpace(checkerSpace.getRow()+1, checkerSpace.getCol()-1).getPiece() != null 
							&& board.getSpace(checkerSpace.getRow()+1, checkerSpace.getCol()-1).getPiece().getColor() == Color.RED 
							&& board.getSpace(checkerSpace.getRow()+2, checkerSpace.getCol()-2).getPiece() == null){
						retVal = true;
					}
				} else { //if somewhere in middle 4 rows, can jump to both left and right
					if(board.getSpace(checkerSpace.getRow()+1, checkerSpace.getCol()+1).getPiece() != null 
							&& board.getSpace(checkerSpace.getRow()+1, checkerSpace.getCol()+1).getPiece().getColor() == Color.RED 
							&& board.getSpace(checkerSpace.getRow()+2, checkerSpace.getCol()+2).getPiece() == null){
						retVal = true;
					}

					if(board.getSpace(checkerSpace.getRow()+1, checkerSpace.getCol()-1).getPiece() != null 
							&& board.getSpace(checkerSpace.getRow()+1, checkerSpace.getCol()-1).getPiece().getColor() == Color.RED 
							&& board.getSpace(checkerSpace.getRow()+2, checkerSpace.getCol()-2).getPiece() == null){
						retVal = true;
					}
				}
			}
		}

		return retVal;
	}


	public ArrayList<Space> possibleMoves(Board board){
		ArrayList<Space> allMoves = new ArrayList<Space>();


		if(checkerColor == Color.RED){				
			if(checkerSpace.getCol() == 0){		//if on left edge, can add right
				allMoves.add(board.getSpace(checkerSpace.getRow()-1, checkerSpace.getCol()+1));
			} else if (checkerSpace.getCol() == 7){	//if on right edge, can add left
				allMoves.add(board.getSpace(checkerSpace.getRow()-1, checkerSpace.getCol()-1));
			} else {		//else, check both left and right and if either are empty, add to arraylist
				if(board.getSpace(checkerSpace.getRow()-1, checkerSpace.getCol()+1).getPiece() == null){
					allMoves.add(board.getSpace(checkerSpace.getRow()-1, checkerSpace.getCol()+1));
				}

				if(board.getSpace(checkerSpace.getRow()-1, checkerSpace.getCol()-1).getPiece() == null){
					allMoves.add(board.getSpace(checkerSpace.getRow()-1, checkerSpace.getCol()-1));
				}
			}

		} else {									//if BLACK, needs open space in one of the backwards diagonals
			if(checkerSpace.getCol() == 0){		//if on left edge, can add right
				allMoves.add(board.getSpace(checkerSpace.getRow()+1, checkerSpace.getCol()+1));
			} else if (checkerSpace.getCol() == 7){	//if on right edge, can add left
				allMoves.add(board.getSpace(checkerSpace.getRow()+1, checkerSpace.getCol()-1));
			} else {		//else, check both left and right and if either are empty, add to arraylist
				if(board.getSpace(checkerSpace.getRow()+1, checkerSpace.getCol()+1).getPiece() == null){
					allMoves.add(board.getSpace(checkerSpace.getRow()+1, checkerSpace.getCol()+1));
				}

				if(board.getSpace(checkerSpace.getRow()+1, checkerSpace.getCol()-1).getPiece() == null){
					allMoves.add(board.getSpace(checkerSpace.getRow()+1, checkerSpace.getCol()-1));
				}
			}
		}


		return allMoves;

	}

	//TODO: make this method return all the possible spaces a checker can jump to

	public ArrayList<Space> possibleJumps(Board board){
		ArrayList<Space> allJumps = new ArrayList<Space>();
		
		if (checkerColor == Color.RED){	//if color is red, needs to move downwards two diagonals
			if(checkerSpace.getCol() < 2){	//if on left edge, can only jump rightwards
				if(board.getSpace(checkerSpace.getRow()-1, checkerSpace.getCol()+1).getPiece() != null 
						&& board.getSpace(checkerSpace.getRow()-1, checkerSpace.getCol()+1).getPiece().getColor() == Color.RED 
						&& board.getSpace(checkerSpace.getRow()-2, checkerSpace.getCol()+2).getPiece() == null){
					allJumps.add(board.getSpace(checkerSpace.getRow()-2, checkerSpace.getCol()+2));
				}
			} else if(checkerSpace.getCol() > 5){ //if one two rightmost columns, can only jump left
				if(board.getSpace(checkerSpace.getRow()-1, checkerSpace.getCol()-1).getPiece() != null 
						&& board.getSpace(checkerSpace.getRow()-1, checkerSpace.getCol()-1).getPiece().getColor() == Color.BLACK 
						&& board.getSpace(checkerSpace.getRow()-2, checkerSpace.getCol()-2).getPiece() == null){
					allJumps.add(board.getSpace(checkerSpace.getRow()-2, checkerSpace.getCol()-2));
				}
		} else {  //if somewhere in middle 4 rows, can jump to both left and right
			if(board.getSpace(checkerSpace.getRow()-1, checkerSpace.getCol()+1).getPiece() != null 
					&& board.getSpace(checkerSpace.getRow()-1, checkerSpace.getCol()+1).getPiece().getColor() == Color.BLACK 
					&& board.getSpace(checkerSpace.getRow()-2, checkerSpace.getCol()+2).getPiece() == null){
				allJumps.add(board.getSpace(checkerSpace.getRow()-2, checkerSpace.getCol()+2));
			}

			if(board.getSpace(checkerSpace.getRow()-1, checkerSpace.getCol()-1).getPiece() != null 
					&& board.getSpace(checkerSpace.getRow()-1, checkerSpace.getCol()-1).getPiece().getColor() == Color.BLACK 
					&& board.getSpace(checkerSpace.getRow()-2, checkerSpace.getCol()-2).getPiece() == null){
				allJumps.add(board.getSpace(checkerSpace.getRow()-2, checkerSpace.getCol()-2));
			}
		}


		
		} else if (checkerColor == Color.BLACK){
			if(checkerSpace.getCol() < 2){	//if on left edge, can only jump rightwards
				if(board.getSpace(checkerSpace.getRow()+1, checkerSpace.getCol()+1).getPiece() != null 
						&& board.getSpace(checkerSpace.getRow()+1, checkerSpace.getCol()+1).getPiece().getColor() == Color.RED 
						&& board.getSpace(checkerSpace.getRow()+2, checkerSpace.getCol()+2).getPiece() == null){
					allJumps.add(board.getSpace(checkerSpace.getRow()+2, checkerSpace.getCol()+2));
				}
			} else if(checkerSpace.getCol() > 5){ //if one two rightmost columns, can only jump left
				if(board.getSpace(checkerSpace.getRow()+1, checkerSpace.getCol()-1).getPiece() != null 
						&& board.getSpace(checkerSpace.getRow()+1, checkerSpace.getCol()-1).getPiece().getColor() == Color.BLACK 
						&& board.getSpace(checkerSpace.getRow()+2, checkerSpace.getCol()-2).getPiece() == null){
					allJumps.add(board.getSpace(checkerSpace.getRow()+2, checkerSpace.getCol()-2));
				}
		} else {  //if somewhere in middle 4 rows, can jump to both left and right
			if(board.getSpace(checkerSpace.getRow()+1, checkerSpace.getCol()+1).getPiece() != null 
					&& board.getSpace(checkerSpace.getRow()+1, checkerSpace.getCol()+1).getPiece().getColor() == Color.BLACK 
					&& board.getSpace(checkerSpace.getRow()+2, checkerSpace.getCol()+2).getPiece() == null){
				allJumps.add(board.getSpace(checkerSpace.getRow()+2, checkerSpace.getCol()+2));
			}

			if(board.getSpace(checkerSpace.getRow()+1, checkerSpace.getCol()-1).getPiece() != null 
					&& board.getSpace(checkerSpace.getRow()+1, checkerSpace.getCol()-1).getPiece().getColor() == Color.BLACK 
					&& board.getSpace(checkerSpace.getRow()+2, checkerSpace.getCol()-2).getPiece() == null){
				allJumps.add(board.getSpace(checkerSpace.getRow()+2, checkerSpace.getCol()-2));
			}
		}
			
		}
		
		
		return allJumps;

	}

	//TODO: make this method move a piece (might not be a void return)

	public void move(){

	}

	//TODO: make this method jump (might not be a void return)

	public void jump(){

	}

	//TODO: make this method replace the Checker with a King

	public void kingMe(){

	}
}
