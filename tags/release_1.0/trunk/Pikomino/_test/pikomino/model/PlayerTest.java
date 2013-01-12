package pikomino.model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class PlayerTest {
	
	@Test
	public void testTotalWorms() {
		Player p = new Player("p1");
		p.addPiecesStack(Piece.createPiece(22));
		p.addPiecesStack(Piece.createPiece(36));
		assertEquals(5, p.totalWorms());
	}
	
	@Test
	public void testTotalWorms2() {
		Player p = new Player("p1");
		p.addPiecesStack(Piece.createPiece(36));
		p.addPiecesStack(Piece.createPiece(22));
		assertEquals(5, p.totalWorms());
	}

	@Test
	public void testBiggestNumber() {
		Player p = new Player("p1");
		p.addPiecesStack(Piece.createPiece(22));
		p.addPiecesStack(Piece.createPiece(36));
		assertEquals(36, p.biggestNumber());
	}
	
	@Test
	public void testBiggestNumber2() {
		Player p = new Player("p1");
		p.addPiecesStack(Piece.createPiece(22));
		p.addPiecesStack(Piece.createPiece(33));
		p.addPiecesStack(Piece.createPiece(29));
		p.addPiecesStack(Piece.createPiece(36));
		p.addPiecesStack(Piece.createPiece(25));
		
		assertFalse(25 == p.biggestNumber());
	}

}
