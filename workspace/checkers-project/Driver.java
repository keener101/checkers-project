
public class Driver {

	public static void main(String[] args){
		Board myBoard = new Board();
		
		System.out.println(myBoard.toString());
		
		myBoard.getSpace(2, 0).getPiece().canMove(myBoard);
		myBoard.getSpace(5, 0).getPiece().canMove(myBoard);
		
		myBoard.getSpace(0, 0).getPiece().canMove(myBoard);
		myBoard.getSpace(7, 0).getPiece().canMove(myBoard);
	}
	
}
