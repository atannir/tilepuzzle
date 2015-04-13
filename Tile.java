package atannir.puzzle.nosuchtiles;

public class Tile {
    
    private int num = 0; //tile number for tracking
    private String[] Trbl = new String[4]; //Top Right Bottom Left
    private int rot = 0; // mod 4, rotation counter, CW assumed here

    //enums here later, maybe, but now, strings.
    


    public Tile(int n, String T, String R, String B, String L){
	if(n > 0 && n <= 9) { num = n; }
	else n = -1;
	if (2 == T.length() && 2 == R.length() && 2 == B.length() && 2 == L.length()){
	    //Trbl = { T, R, B, L}; //doesn't work, even with [].
	    Trbl[0] = T;
	    Trbl[1] = R;
	    Trbl[2] = B;
	    Trbl[3] = L;
	}
	//else? We'll try not to misbehave.	

    }
    
    //rotate
    public int rotateCW(int n) {
	rot = rot + (n % 4); // equivalent to (rot + n) % 4, right?
	return rot;
    }
    public int rotate() { return rotateCW(1);}

    public String toString() {
	//TODO add offset into this so it is useful
	return new String("Tile " + num + " " + 
			  Trbl[0] + " " +
			  Trbl[1] + " " + 
			  Trbl[2] + " " +
			  Trbl[3]);
    }


    //get(trbl) etc
    //toString

}