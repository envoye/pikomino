package pikomino.model;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class GameBoardTest {
	private static String[] names = {"Teste1", "Teste2"};
	private static GameBoard gameBoard;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		gameBoard = new GameBoard(names);
	}

	@Test
	public void testChangeNextPlayer() {
		int actualID = gameBoard.getActualPlayerID();
		gameBoard.changeNextPlayer();
		if(actualID != gameBoard.getN_players() -1 )
			assertEquals(actualID + 1, gameBoard.getActualPlayerID());
		else
			assertEquals(0, gameBoard.getActualPlayerID());
	}
	
	@Test
	public void testChangeNextPlayer2() {
		
		gameBoard.changeNextPlayer();
		int actualID = gameBoard.getActualPlayerID();
		gameBoard.changeNextPlayer();
		if(actualID != gameBoard.getN_players() -1 )
			assertEquals(actualID + 1, gameBoard.getActualPlayerID());
		else
			assertEquals(0, gameBoard.getActualPlayerID());
	}

	
	@Test
	public void testTakePiece() {
		
		int size = gameBoard.getPieces().size();
		Piece temp = gameBoard.getPieces().get(0);
		gameBoard.takePiece(temp);
		
		assertEquals(size - 1, gameBoard.getPieces().size());
		
		assertTrue(temp == gameBoard.getActualPlayer().getTopPiece());
	}
	
	@Test
	public void testTakePiece2() {
		
		int size = gameBoard.getPieces().size();
		List<Piece> pieces = gameBoard.getPieces();
		Piece temp = pieces.get(pieces.size() - 1);
		
		gameBoard.takePiece(pieces.get(pieces.size() - 1));
		
		assertEquals(size - 1, pieces.size());
		assertTrue(temp == gameBoard.getActualPlayer().getTopPiece());
		
	}

}
