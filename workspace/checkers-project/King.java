import java.util.ArrayList;

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
							&& board.getSpace(checkerSpace.getRow()-1, checkerSpace.getCol()+1).getPiece().getColor() != checkerColor 
							&& board.getSpace(checkerSpace.getRow()-2, checkerSpace.getCol()+2).getPiece() == null){
						retVal = true;
					}
				} else if (checkerSpace.getCol() > 5){ //if one two rightmost columns, can only jump left
					
					//this checks for jumps up and left for right edges
					if(board.getSpace(checkerSpace.getRow()-1, checkerSpace.getCol()-1).getPiece() != null 
							&& board.getSpace(checkerSpace.getRow()-1, checkerSpace.getCol()-1).getPiece().getColor() != checkerColor 
							&& board.getSpace(checkerSpace.getRow()-2, checkerSpace.getCol()-2).getPiece() == null){
						retVal = true;
					}
				} else { //if somewhere in middle 4 rows, can jump to both left and right
					
					//this checks for jumps up and right for middle
					if(board.getSpace(checkerSpace.getRow()-1, checkerSpace.getCol()+1).getPiece() != null 
							&& board.getSpace(checkerSpace.getRow()-1, checkerSpace.getCol()+1).getPiece().getColor() != checkerColor 
							&& board.getSpace(checkerSpace.getRow()-2, checkerSpace.getCol()+2).getPiece() == null){
						retVal = true;
					}

					//this checks for jumps up and left for middle
					if(board.getSpace(checkerSpace.getRow()-1, checkerSpace.getCol()-1).getPiece() != null 
							&& board.getSpace(checkerSpace.getRow()-1, checkerSpace.getCol()-1).getPiece().getColor() != checkerColor 
							&& board.getSpace(checkerSpace.getRow()-2, checkerSpace.getCol()-2).getPiece() == null){
						retVal = true;
					}
				}
			}
			
			if(checkerSpace.getRow() < 6){	//only downwards jumps
				if(checkerSpace.getCol() < 2){	//if one of the two leftmost columns, can only jump rightwards
					
					//this checks for jumps down and to the right for left edges
					if(board.getSpace(checkerSpace.getRow()+1, checkerSpace.getCol()+1).getPiece() != null 
							&& board.getSpace(checkerSpace.getRow()+1, checkerSpace.getCol()+1).getPiece().getColor() != checkerColor
							&& board.getSpace(checkerSpace.getRow()+2, checkerSpace.getCol()+2).getPiece() == null){
						retVal = true;
					}
				} else if (checkerSpace.getCol() > 5){ //if one two rightmost columns, can only jump left
					
					//this checks for jumps down and to the left for right edges
					if(board.getSpace(checkerSpace.getRow()+1, checkerSpace.getCol()-1).getPiece() != null 
							&& board.getSpace(checkerSpace.getRow()+1, checkerSpace.getCol()-1).getPiece().getColor() != checkerColor 
							&& board.getSpace(checkerSpace.getRow()+2, checkerSpace.getCol()-2).getPiece() == null){
						retVal = true;
					}
				} else { //if somewhere in middle 4 rows, can jump to both left and right
					
					//this checks for jumps down and right for middle
					if(board.getSpace(checkerSpace.getRow()+1, checkerSpace.getCol()+1).getPiece() != null 
							&& board.getSpace(checkerSpace.getRow()+1, checkerSpace.getCol()+1).getPiece().getColor() != checkerColor
							&& board.getSpace(checkerSpace.getRow()+2, checkerSpace.getCol()+2).getPiece() == null){
						retVal = true;
					}
					
					//this checks for jumps down and left for middle
					if(board.getSpace(checkerSpace.getRow()+1, checkerSpace.getCol()-1).getPiece() != null 
							&& board.getSpace(checkerSpace.getRow()+1, checkerSpace.getCol()-1).getPiece().getColor() != checkerColor 
							&& board.getSpace(checkerSpace.getRow()+2, checkerSpace.getCol()-2).getPiece() == null){
						retVal = true;
					}
				}
			}

		return retVal;
	}
	
	public ArrayList<Space> possibleMoves(Board board){
		ArrayList<Space> allMoves = new ArrayList<Space>();
		
		if(checkerSpace.getRow() > 0){			//check all upwards moves
			if(checkerSpace.getCol() == 0){		//if on left edge, can only check right
				if (board.getSpace(checkerSpace.getRow()-1, checkerSpace.getCol()+1).getPiece() == null){
					allMoves.add(board.getSpace(checkerSpace.getRow()-1, checkerSpace.getCol()+1));
				}
			} else if (checkerSpace.getCol() == 7){	//if on right edge, can only check right
				if (board.getSpace(checkerSpace.getRow()-1, checkerSpace.getCol()-1).getPiece() == null){
					allMoves.add(board.getSpace(checkerSpace.getRow()-1, checkerSpace.getCol()-1));
				}
			} else {		//else, check both left and right and if either are empty, valid move
				if (board.getSpace(checkerSpace.getRow()-1, checkerSpace.getCol()+1).getPiece() == null){
					allMoves.add(board.getSpace(checkerSpace.getRow()-1, checkerSpace.getCol()+1));
				}
				
				if (board.getSpace(checkerSpace.getRow()-1, checkerSpace.getCol()-1).getPiece() == null){
					allMoves.add(board.getSpace(checkerSpace.getRow()-1, checkerSpace.getCol()+1));
				}
			}
		}
		
		if(checkerSpace.getRow() < 7){			//check all downwards moves
			if(checkerSpace.getCol() == 0){		//if on left edge, can only check right
				if(board.getSpace(checkerSpace.getRow()+1, checkerSpace.getCol()+1).getPiece() == null){
					allMoves.add(board.getSpace(checkerSpace.getRow()+1, checkerSpace.getCol()+1));
				}
			} else if (checkerSpace.getCol() == 7){	//if on right edge, can only check right
				if(board.getSpace(checkerSpace.getRow()+1, checkerSpace.getCol()-1).getPiece() == null){
					allMoves.add(board.getSpace(checkerSpace.getRow()+1, checkerSpace.getCol()-1));
				}
			} else {		//else, check both left and right and if either are empty, valid move
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

		if(checkerSpace.getRow() > 1){	// only rows that can jump forward
			if(checkerSpace.getCol() < 2){	//if one of the two leftmost columns, can only jump rightwards
				
				//this checks for jumps that are up and to the right for left edges
				if(board.getSpace(checkerSpace.getRow()-1, checkerSpace.getCol()+1).getPiece() != null 
						&& board.getSpace(checkerSpace.getRow()-1, checkerSpace.getCol()+1).getPiece().getColor() != checkerColor 
						&& board.getSpace(checkerSpace.getRow()-2, checkerSpace.getCol()+2).getPiece() == null){
					allJumps.add(board.getSpace(checkerSpace.getRow()-2, checkerSpace.getCol()+2));
				}
			} else if (checkerSpace.getCol() > 5){ //if one two rightmost columns, can only jump left
				
				//this checks for jumps up and left for right edges
				if(board.getSpace(checkerSpace.getRow()-1, checkerSpace.getCol()-1).getPiece() != null 
						&& board.getSpace(checkerSpace.getRow()-1, checkerSpace.getCol()-1).getPiece().getColor() != checkerColor 
						&& board.getSpace(checkerSpace.getRow()-2, checkerSpace.getCol()-2).getPiece() == null){
					allJumps.add(board.getSpace(checkerSpace.getRow()-2, checkerSpace.getCol()-2));
				}
			} else { //if somewhere in middle 4 rows, can jump to both left and right
				
				//this checks for jumps up and right for middle
				if(board.getSpace(checkerSpace.getRow()-1, checkerSpace.getCol()+1).getPiece() != null 
						&& board.getSpace(checkerSpace.getRow()-1, checkerSpace.getCol()+1).getPiece().getColor() != checkerColor 
						&& board.getSpace(checkerSpace.getRow()-2, checkerSpace.getCol()+2).getPiece() == null){
					allJumps.add(board.getSpace(checkerSpace.getRow()-2, checkerSpace.getCol()+2));
				}

				//this checks for jumps up and left for middle
				if(board.getSpace(checkerSpace.getRow()-1, checkerSpace.getCol()-1).getPiece() != null 
						&& board.getSpace(checkerSpace.getRow()-1, checkerSpace.getCol()-1).getPiece().getColor() != checkerColor 
						&& board.getSpace(checkerSpace.getRow()-2, checkerSpace.getCol()-2).getPiece() == null){
					allJumps.add(board.getSpace(checkerSpace.getRow()-2, checkerSpace.getCol()-2));
				}
			}
		}
		
		if(checkerSpace.getRow() < 6){	//only downwards jumps
			if(checkerSpace.getCol() < 2){	//if one of the two leftmost columns, can only jump rightwards
				
				//this checks for jumps down and to the right for left edges
				if(board.getSpace(checkerSpace.getRow()+1, checkerSpace.getCol()+1).getPiece() != null 
						&& board.getSpace(checkerSpace.getRow()+1, checkerSpace.getCol()+1).getPiece().getColor() != checkerColor
						&& board.getSpace(checkerSpace.getRow()+2, checkerSpace.getCol()+2).getPiece() == null){
					allJumps.add(board.getSpace(checkerSpace.getRow()+2, checkerSpace.getCol()+2));
				}
			} else if (checkerSpace.getCol() > 5){ //if one two rightmost columns, can only jump left
				
				//this checks for jumps down and to the left for right edges
				if(board.getSpace(checkerSpace.getRow()+1, checkerSpace.getCol()-1).getPiece() != null 
						&& board.getSpace(checkerSpace.getRow()+1, checkerSpace.getCol()-1).getPiece().getColor() != checkerColor 
						&& board.getSpace(checkerSpace.getRow()+2, checkerSpace.getCol()-2).getPiece() == null){
					allJumps.add(board.getSpace(checkerSpace.getRow()+2, checkerSpace.getCol()-2));
				}
			} else { //if somewhere in middle 4 rows, can jump to both left and right
				
				//this checks for jumps down and right for middle
				if(board.getSpace(checkerSpace.getRow()+1, checkerSpace.getCol()+1).getPiece() != null 
						&& board.getSpace(checkerSpace.getRow()+1, checkerSpace.getCol()+1).getPiece().getColor() != checkerColor 
						&& board.getSpace(checkerSpace.getRow()+2, checkerSpace.getCol()+2).getPiece() == null){
					allJumps.add(board.getSpace(checkerSpace.getRow()+2, checkerSpace.getCol()+2));
				}
				
				//this checks for jumps down and left for middle
				if(board.getSpace(checkerSpace.getRow()+1, checkerSpace.getCol()-1).getPiece() != null 
						&& board.getSpace(checkerSpace.getRow()+1, checkerSpace.getCol()-1).getPiece().getColor() != checkerColor
						&& board.getSpace(checkerSpace.getRow()+2, checkerSpace.getCol()-2).getPiece() == null){
					allJumps.add(board.getSpace(checkerSpace.getRow()+2, checkerSpace.getCol()-2));
				}
			}
		}

	return allJumps;
	}
	
	
	public void jump(Space newSpace, Board board){
		Space oldSpace = checkerSpace;
		newSpace.setPiece(this);
		oldSpace.setPiece(null);
		checkerSpace = newSpace;

		if (newSpace.getCol() < oldSpace.getCol()){ //if jumped to the left, remove jumped piece 
			if(newSpace.getRow() < oldSpace.getRow()){	//jumped up and to left
				Space jumpedSpace = board.getSpace(oldSpace.getRow()-1, oldSpace.getCol()-1);
				Checker jumpedChecker = jumpedSpace.getPiece();
				jumpedSpace.setPiece(null);
				jumpedChecker.setSpace(null);
				jumpedChecker.isActive = false;
			} else if (newSpace.getRow() > oldSpace.getRow()){ // jumped down and to left
				Space jumpedSpace = board.getSpace(oldSpace.getRow()+1, oldSpace.getCol()-1);
				Checker jumpedChecker = jumpedSpace.getPiece();
				jumpedSpace.setPiece(null);
				jumpedChecker.setSpace(null);
				jumpedChecker.isActive = false;
			}
		} else if (newSpace.getCol() > oldSpace.getCol()){ //if jumped to right
			if(newSpace.getRow() < oldSpace.getRow()){	//jumped up and to right
				Space jumpedSpace = board.getSpace(oldSpace.getRow()-1, oldSpace.getCol()+1);
				Checker jumpedChecker = jumpedSpace.getPiece();
				jumpedSpace.setPiece(null);
				jumpedChecker.setSpace(null);
				jumpedChecker.isActive = false;
			} else if (newSpace.getRow() > oldSpace.getRow()){ //jumped down and to right
				Space jumpedSpace = board.getSpace(oldSpace.getRow()+1, oldSpace.getCol()+1);
				Checker jumpedChecker = jumpedSpace.getPiece();
				jumpedSpace.setPiece(null);
				jumpedChecker.setSpace(null);
				jumpedChecker.isActive = false;

			}
		}

	}

}
