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
	boolean isActive;

	public Checker(Color checkerColor, Space checkerSpace){
		this.checkerColor = checkerColor;
		this.checkerSpace = checkerSpace;
		isActive = true;
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

	public void move(Space newSpace){
		Space oldSpace = this.getSpace();
		newSpace.setPiece(this);
		oldSpace.setPiece(null);
		checkerSpace = newSpace;

	}


	public void jump(Space newSpace, Board board){
		Space oldSpace = checkerSpace;
		newSpace.setPiece(this);
		oldSpace.setPiece(null);
		checkerSpace = newSpace;

		if (newSpace.getCol() < oldSpace.getCol()){ //if jumped to the left, remove jumped piece 
			if(checkerColor == Color.RED){	//if RED, jumped up and to left
				Space jumpedSpace = board.getSpace(oldSpace.getRow()-1, oldSpace.getCol()-1);
				Checker jumpedChecker = jumpedSpace.getPiece();
				jumpedSpace.setPiece(null);
				jumpedChecker.setSpace(null);
				jumpedChecker.isActive = false;
			} else if (checkerColor == Color.BLACK){ //if BLACK, jumped down and to left
				Space jumpedSpace = board.getSpace(oldSpace.getRow()+1, oldSpace.getCol()-1);
				Checker jumpedChecker = jumpedSpace.getPiece();
				jumpedSpace.setPiece(null);
				jumpedChecker.setSpace(null);
				jumpedChecker.isActive = false;
			}
		} else if (newSpace.getCol() > oldSpace.getCol()){ //if jumped to right
			if(checkerColor == Color.RED){	//if RED, jumped up and to right
				Space jumpedSpace = board.getSpace(oldSpace.getRow()-1, oldSpace.getCol()+1);
				Checker jumpedChecker = jumpedSpace.getPiece();
				jumpedSpace.setPiece(null);
				jumpedChecker.setSpace(null);
				jumpedChecker.isActive = false;
			} else if (checkerColor == Color.BLACK){ //if BLACK, jumped down and to right
				Space jumpedSpace = board.getSpace(oldSpace.getRow()+1, oldSpace.getCol()+1);
				Checker jumpedChecker = jumpedSpace.getPiece();
				jumpedSpace.setPiece(null);
				jumpedChecker.setSpace(null);
				jumpedChecker.isActive = false;

			}
		}

	}


	public void kingMe(Board board){
		Space kingSpace = checkerSpace;
		King king = new King(checkerColor, kingSpace);
		kingSpace.setPiece(king);
		this.isActive = false;
		
		board.addKing(checkerColor, king);
	}
}
