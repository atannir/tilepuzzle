//package atannir.puzzle.nosuchtiles;

public class Tile {

	//private int num = 0; //tile number for tracking
	private String name;
	private String[] Trbl = new String[4]; //Top Right Bottom Left
	private int rot = 0; // mod 4, rotation counter, CW assumed here

	//enums here later, maybe, but now, strings.



	public Tile(String n, String T, String R, String B, String L){
		// if(n > 0 && n <= 9) { num = n; }
		// else n = -1;
		// this was dumb anyway.
		name = n;
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
		if(rot == 0) {rot = 4;} //stupid but it works.
		rot = (rot - n);
		return rot;
	}
	public int rotate() { return rotateCW(1);}

	public String toString() {
		//index plus offset mod 4
		return new String("Tile " + name + " " +
				Trbl[(((0 + rot) % 4))] + " " +
				Trbl[(((1 + rot) % 4))] + " " +
				Trbl[(((2 + rot) % 4))] + " " +
				Trbl[(((3 + rot) % 4))]);
	}

	public String getN(String pos){
		int idx = 0;
		switch(pos) //Java 7 does strings in switches. Nice!
		{
			case "T":
				// idx = ((4 - (0 + rot)) % 4);
				idx = (((0 + rot) % 4));
				break;
			case "R":
				// idx = ((4 - (3 + rot)) % 4);
				idx = (((1 + rot) % 4));
				break;
			case "B":
				// idx = ((4 - (2 + rot)) % 4);
				idx = (((2 + rot) % 4));
				break;
			case "L":
				// idx = ((4 - (1 + rot)) % 4);
				idx = (((3 + rot) % 4));
				break;
			default:
				idx = 0; //bad but... could be worse?
				break;
		}
		return Trbl[idx];
	}

	//metaprogramming it isn't.
	public String getName() { return name; }
	public String getT() { return getN("T"); }
	public String getR() { return getN("R"); }
	public String getB() { return getN("B"); }
	public String getL() { return getN("L"); }

}