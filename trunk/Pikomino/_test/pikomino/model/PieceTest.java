package pikomino.model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class PieceTest {

	@Test
	public void test() {
		try {
			Piece.createPiece(23);
			assertTrue(true);
		} catch(IllegalArgumentException e) {
			fail();
		}
	}
	
	@Test
	public void test2() {
		try {
			Piece.createPiece(19);
			fail();
		} catch(IllegalArgumentException e) {
			assertTrue(true);
		}
	}
	
	@Test
	public void test3() {
		try {
			Piece.createPiece(37);
			fail();
		} catch(IllegalArgumentException e) {
			assertTrue(true);
		}
	}

}
