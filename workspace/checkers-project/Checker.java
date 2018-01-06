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
}
