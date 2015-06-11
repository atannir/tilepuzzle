//package atannir.puzzle.nosuchtiles;

public class Tile {

	//private int num = 0; //tile number for tracking
	private String name;
	private String[] Trbl = new String[4]; //Top Right Bottom Left
	private int rot = 0; // mod 4, rotation counter, CW assumed here

	private int DEBUG_LEVEL = 1;

	//enums here later, maybe, but now, strings.



	public Tile(String n, String T, String R, String B, String L){

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

	@Override
	public String toString() {
		if(DEBUG_LEVEL == 1){super.toString();}

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

	public String getComplementSide(String side)
	{ // this works well with 4-sided puzzle parts, might not work so well on other types.
		// it is either lucky or murky that this will overload on the type and the data.
		// specifically, T and B can refer to the top and bottom of the tile as well as
		// top and bottom of the symbol to match.
		// It is a mixing of data and metadata but I'll allow it because programming is fun. :-)
		switch(side.toUpperCase())
		{
			case "T":
				return "B";
			// a break here would be unreachable due to return.
			case "B":
				return "T";
			case "R":
				return "L";
			case "L":
				return "R";
			default:
				System.out.println("Complement not found for " + side + " or " + side.toUpperCase());
				return "X";
			//not found, instead of throwing a crazy exception, this should do.
		}
		//was getting conflicting errors here about missing return for function and unreachable statements...
	}

	public boolean match(String side, Tile til) {
		// return true if the tile passed in matches the complementary side of this tile
		// other logic (such as rotation) handled elsewhere.
		if(DEBUG_LEVEL == 1)
		{
			System.out.println("Side: " + side);
			System.out.println("Symbol to match: " + getN(side));
			System.out.println("Tile to match: " + til.toString());
			System.out.println("Type component: " + getType(getN(side)));
			System.out.println("Half component: " + getTB(getN(side)));
			System.out.println("Complement side: " + getComplementSide(side));
			System.out.println("Corresponding side: " + til.getN(getComplementSide(side)));
			System.out.println("Corresponding type: " + til.getType(til.getN(getComplementSide(side))));
			System.out.println("Corresponding half: " + til.getTB(til.getN(getComplementSide(side))));
			System.out.println("Try to match TB " + til.getTB(til.getN(getComplementSide(side))).compareTo(getComplementSide(getTB(getN(side))))); // 18 if uncorrected
			System.out.println("Try to match Type " + til.getType(til.getN(getComplementSide(side))).compareTo(getType(getN(side))));
		}

		if (
				(til.getTB(til.getN(getComplementSide(side))).compareTo(getComplementSide(getTB(getN(side)))) == 0)
						&& ((til.getType(til.getN(getComplementSide(side))).compareTo(getType(getN(side)))) == 0)
				)
		{
			// if the type of the side and the type of the complement of the side of the other tile match
			// and the half of the symbol matches
			return true;
		}
		else { return false; }
	}

	public String getType(String part) {return part.substring(0,1);} //get kind of the matching part
	public String getTB(String part) {return part.substring(1,2);} // for the half on the part, get either T or B



	//metaprogramming it isn't.
	public String getName() { return name; }
	public String getT() { return getN("T"); }
	public String getR() { return getN("R"); }
	public String getB() { return getN("B"); }
	public String getL() { return getN("L"); }

}