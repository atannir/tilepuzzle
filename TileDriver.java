//package atannir.puzzle.nosuchtiles;

//import atannir.puzzle.nosuchtiles.*;
//import Tile;

//set ops
import java.util.*;


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
		//Uncertain if will use names or offsets exclusively.
		//For now, offsets, I think, since
		allTiles[0] = new Tile(1, "MB", "RT", "RB", "VB"); // MRV
		allTiles[1] = new Tile(2, "RB", "FT", "FB", "VB"); // RFV
		allTiles[2] = new Tile(3, "FT", "MT", "VT", "RT"); // FMVR
		allTiles[3] = new Tile(4, "MT", "FB", "FT", "VB"); // MFV
		allTiles[4] = new Tile(5, "VT", "MB", "FB", "RT"); // VMFR
		allTiles[5] = new Tile(6, "RT", "MB", "VB", "MT"); // RMV
		allTiles[6] = new Tile(7, "VB", "RB", "MB", "FT"); // VRMF
		allTiles[7] = new Tile(8, "VB", "MB", "FT", "RT"); // VMFR
		allTiles[8] = new Tile(9, "VT", "RB", "MB", "FT"); // VMRF

		//Set ops
		//Autoboxing for the something. No primitive types allowed.
		Set<Integer> fullSet = new HashSet<Integer>();
		for(int i = 0; i < 9; i++){ fullSet.add(i); } //probably a nicer way to do this using the actual data

		Set<Integer> availT = new HashSet<Integer>();
		for(int i = 0; i < 9; i++){ availT.add(i); }

		Set<Integer> usedT = new HashSet<Integer>(); //start empty

		//manually done because I don't really need to write code to sort through 9 tiles
		Set<Integer> AllF = new HashSet<Integer>(); //not 1 not 5
		AllF.add(1); AllF.add(2); AllF.add(3); AllF.add(4);
		AllF.add(6); AllF.add(7); AllF.add(8);

		Set<Integer> AllR = new HashSet<Integer>(); //not 3
		AllR.add(0); AllR.add(1); AllR.add(2); AllR.add(4);
		AllR.add(5); AllR.add(6); AllR.add(7); AllR.add(8);

		Set<Integer> AllV = new HashSet<Integer>(); //everything
		for(int i = 0; i < 9; i++){ AllV.add(i); }

		Set<Integer> AllM = new HashSet<Integer>(); //not 0 not 1
		for(int i = 2; i < 9; i++){ AllM.add(i); }

		//Not worth it, all tiles contain tops and bottoms
		//Set<int> AllT = new HashSet<int>();
		//Set<int> AllB = new HashSet<int>();

		System.out.println(fullSet);
		System.out.println(AllF);
		System.out.println(AllR);
		System.out.println(AllV);
		System.out.println(AllM);
		System.out.println(availT);
		System.out.println(usedT);





		//Tile t = new Tile(1, "FT", "RB", "VT", "MB");
		//testRotate(t);

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
}