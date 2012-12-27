package pikomino.model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class GameBoardTest {
	private static String[] names = {"Teste1", "Teste2"};
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		GameBoard gb = new GameBoard(names);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGameBoardStringArray() {
		fail("Not yet implemented");
	}

	@Test
	public void testGameBoardIntArrayListOfString() {
		fail("Not yet implemented");
	}

	@Test
	public void testChangeNextPlayer() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetPlayableDice() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetPlayedDice() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetPieces() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetPieces() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetCurrentPlayer() {
		fail("Not yet implemented");
	}

	@Test
	public void testRollDice() {
		fail("Not yet implemented");
	}

	@Test
	public void testSelectedDice() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetTotalDicePlayed() {
		fail("Not yet implemented");
	}

	@Test
	public void testTakePiece() {
		fail("Not yet implemented");
	}

	@Test
	public void testReturnPiece() {
		fail("Not yet implemented");
	}

	@Test
	public void testMoveDiceToPlayedList() {
		fail("Not yet implemented");
	}

}
