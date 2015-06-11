//package atannir.puzzle.nosuchtiles;

//import atannir.puzzle.nosuchtiles.*;
//import Tile;

//set ops
import java.util.*;


//solver (and tester) for the Tile class and the puzzle at large


public class TileDriver {

	public static void main(String[] args) {

		final int TOPLEFT = 0;
		final int TOP = 1;
		final int TOPRIGHT = 2;
		final int LEFT = 3;
		final int CENTER = 4;
		final int RIGHT = 5;
		final int BOTTOMLEFT = 6;
		final int BOTTOM = 7;
		final int BOTTOMRIGHT = 8;

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
		//Uncertain if will use names or offsets exclusively.
		//Changed to letters to stop caring about names vs offsets.
		allTiles[0] = new Tile("A", "MB", "RT", "RB", "VB"); // MRV
		allTiles[1] = new Tile("B", "RB", "FT", "FB", "VB"); // RFV
		allTiles[2] = new Tile("C", "FT", "MT", "VT", "RT"); // FMVR
		allTiles[3] = new Tile("D", "MT", "FB", "FT", "VB"); // MFV
		allTiles[4] = new Tile("E", "VT", "MB", "FB", "RT"); // VMFR
		allTiles[5] = new Tile("F", "RT", "MB", "VB", "MT"); // RMV
		allTiles[6] = new Tile("G", "VB", "RB", "MB", "FT"); // VRMF
		allTiles[7] = new Tile("H", "VB", "MB", "FT", "RT"); // VMFR
		allTiles[8] = new Tile("I", "VT", "RB", "MB", "FT"); // VMRF

		int[] board = {0,0,0,0,0,0,0,0,0}; //array offsets, I guess?

		//Set ops
		//Autoboxing for the something. No primitive types allowed.
		Set<Integer> fullSet = new HashSet<Integer>();
		for(int i = 0; i < 9; i++){ fullSet.add(i); } //probably a nicer way to do this using the actual data

		Set<Integer> availT = new HashSet<Integer>();
		for(int i = 0; i < 9; i++){ availT.add(i); }
		//Start with all tiles available.

		Set<Integer> usedT = new HashSet<Integer>(); //start empty
		//add and remove tiles as we use them

		//manually done because I don't really need to write code to sort through 9 tiles
		Set<Integer> AllFT = new HashSet<Integer>(); // 1 2 3 6 7 8
		AllFT.add(1); AllFT.add(2); AllFT.add(3); AllFT.add(6);
		AllFT.add(7); AllFT.add(8);

		Set<Integer> AllFB = new HashSet<Integer>(); // 1 3 4
		AllFB.add(1); AllFB.add(3); AllFB.add(4);

		Set<Integer> AllRT = new HashSet<Integer>(); // 0 2 4 5 7
		AllRT.add(0); AllRT.add(2); AllRT.add(4); AllRT.add(5); AllRT.add(7);

		Set<Integer> AllRB = new HashSet<Integer>(); // 0 1 6 8
		AllRB.add(0); AllRB.add(1); AllRB.add(6); AllRB.add(8);

		Set<Integer> AllVT = new HashSet<Integer>(); // 2 4 8
		AllVT.add(2); AllVT.add(4); AllVT.add(8);
//		for(int i = 0; i < 9; i++){ AllV.add(i); }

		Set<Integer> AllVB = new HashSet<Integer>(); // 0 1 3 5 6 7
		AllVB.add(0); AllVB.add(1); AllVB.add(3); AllVB.add(5); AllVB.add(6); AllVB.add(7);

		Set<Integer> AllMT = new HashSet<Integer>(); // 2 3 5
		AllMT.add(2); AllMT.add(3); AllMT.add(5);

		Set<Integer> AllMB = new HashSet<Integer>(); // 0 4 5 6 7 8
		AllMB.add(0); AllMB.add(4); AllMB.add(5); AllMB.add(6); AllMB.add(7); AllMB.add(8);
//		for(int i = 2; i < 9; i++){ AllM.add(i); }

		//Start setting up the board. Kind of arbitrary, actually.
		//Begin with the middle piece, or offset 4 in the array.


		// Simplest tile test. Match X-MB with Y-MT
		// Can match X-RB with Y-RT
		// Alternately, match X-VB with Y-VT
		Tile test1 = new Tile("X", "MB", "RT", "RB", "VB"); // MVR
		Tile test2 = new Tile("Y", "FT", "MT", "VT", "RT"); // FMVR

		// take tile 1, check type of R, compare to L of tile 2
		test2.rotate(); // with only 1 rotate, it will match T.
		test2.rotate(); // with 0 or 2 rotates, will not match T.
		if(test1.match("T",test2)) // match bottom of X with the corresponding side of Y (top)
		{
			//rotate here doesn't work because we've already passed the tile in to be matched.
			System.out.println(test1.toString() + " matched " + test2.toString());
		}
		else
		{
			System.out.println(test1.toString() + " did not match " + test2.toString());
		}

		// 1. make 8 groups for all tiles
		// 2. make helper functions in the Tile class to determine if something passed is a match.
		// 2b. (This means that a tile can 'know' if something matches it. The logic is in the class.)




		//Tile t = new Tile("1", "FT", "RB", "VT", "MB");
		//testRotate(t);
		//testRotate(allTiles[3]);

	}

	public static void testRotate(Tile t) {
		System.out.println(t.toString());
		for ( int i = 0; i < 11; i++) {
			System.out.println(t.rotate());
			System.out.println(t.toString());
			printFourSides(t);
		}
	}

	public static void printFourSides(Tile t) {
		System.out.println(t.getT());
		System.out.println(t.getR());
		System.out.println(t.getB());
		System.out.println(t.getL());
	}


/*	public static void printBoardStates() {

		System.out.println("Full: " + fullSet);
		System.out.println("All F:" + AllF);
		System.out.println("All R:" + AllR);
		System.out.println("All V:" + AllV);
		System.out.println("All M:" + AllM);
		System.out.println("Avail T:" + availT);
		System.out.println("Used: " + usedT);
	}*/

}