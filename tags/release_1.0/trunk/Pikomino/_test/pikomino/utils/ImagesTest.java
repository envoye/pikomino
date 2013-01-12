package pikomino.utils;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import pikomino.model.Dice;
import pikomino.model.Piece;


public class ImagesTest {

	@Test
	public void testGetImage() {
		try {
			Images.getImageOf(new Object());
			fail();
		} catch(IllegalArgumentException e) {
			assertTrue(true);
		}
	}
	
	@Test
	public void testGetImageDice() {
		try {
			Images.getImageOf(Dice.createDice(1));
			assertTrue(true);
		} catch(IllegalArgumentException e) {
			fail();
		}
	}
	
	@Test
	public void testGetImagePiece() {
		try {
			Images.getImageOf(Piece.createPiece(22));
			assertTrue(true);
		} catch(IllegalArgumentException e) {
			fail();
		}
	}
	
}
