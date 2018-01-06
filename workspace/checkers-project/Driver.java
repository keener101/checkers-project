
public class Driver {

	public static void main(String[] args){
		Board myBoard = new Board();
		
		System.out.println(myBoard.toString());
		
		Board.getSpace(2, 0).getPiece().canMove();
		Board.getSpace(5, 0).getPiece().canMove();
		
		Board.getSpace(0, 0).getPiece().canMove();
		Board.getSpace(7, 0).getPiece().canMove();
	}
	
}
