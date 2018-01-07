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
	
	public boolean canMove(){
		return false;
	}
	
	public boolean canJump(){
		return false;
	}
	
	public void move(){
		
	}
	
	public void jump(){
		
	}

}
