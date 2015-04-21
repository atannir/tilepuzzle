//package atannir.puzzle.nosuchtiles;

//import atannir.puzzle.nosuchtiles.*;
//import Tile;



//solver (and tester) for the Tile class and the puzzle at large


public class TileDriver {


	public static void main(String[] args) {

		Tile t = new Tile(1, "FT", "RB", "VT", "MB");
		System.out.println(t.toString());
		System.out.println(t.rotate());
		System.out.println(t.toString());
		System.out.println(t.rotate());
		System.out.println(t.toString());
		System.out.println(t.rotate());
		System.out.println(t.toString());
		System.out.println(t.getT()); // no longer correct

		//System.out.println(t.toString());
		System.out.println("TEST");


	}
}