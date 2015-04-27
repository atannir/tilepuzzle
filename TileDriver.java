//package atannir.puzzle.nosuchtiles;

//import atannir.puzzle.nosuchtiles.*;
//import Tile;



//solver (and tester) for the Tile class and the puzzle at large


public class TileDriver {



	public static void main(String[] args) {

		/*
		1 MB RT RB VB
		2 RB FT FB VB
		3 FT MT VT RT
		4 MT FB FT VB
		5 VT MB FB RT
		6 RT MB VB MT
		7 VB RB MB FT
		8 VB MB FT RT
		9 VT RB MB FT
		*/


		Tile[] allTiles = new Tile[9];

		allTiles[0] = new Tile(1, "MB", "RT", "RB", "VB"); // MRV
		allTiles[1] = new Tile(2, "RB", "FT", "FB", "VB"); // RFV
		allTiles[2] = new Tile(3, "FT", "MT", "VT", "RT"); // FMVR
		allTiles[3] = new Tile(4, "MT", "FB", "FT", "VB"); // MFV
		allTiles[4] = new Tile(5, "VT", "MB", "FB", "RT"); // VMFR
		allTiles[5] = new Tile(6, "RT", "MB", "VB", "MT"); // RMV
		allTiles[6] = new Tile(7, "VB", "RB", "MB", "FT"); // VRMF
		allTiles[7] = new Tile(8, "VB", "MB", "FT", "RT"); // VMFR
		allTiles[8] = new Tile(9, "VT", "RB", "MB", "FT"); // VMRF


		Tile t = new Tile(1, "FT", "RB", "VT", "MB");
		testRotate(t);
		printFourSides(t);

	}

	public static void testRotate(Tile t) {
		System.out.println(t.toString());
		for ( int i = 0; i < 8; i++) {
			System.out.println(t.rotate());
			System.out.println(t.toString());
		}
	}

	public static void printFourSides(Tile t) {
		System.out.println(t.getT());
		System.out.println(t.getR());
		System.out.println(t.getB());
		System.out.println(t.getL());
	}
}