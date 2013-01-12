package pikomino.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class DiceTest {

	@Test
	public void testCreate() {
		try {
			Dice.createDice(1);
			assertTrue(true);
		} catch(IllegalArgumentException e) {
			fail();
		}
	}
	
	@Test
	public void testCreate2() {
		try {
			Dice.createDice(7);
			fail();
		} catch(IllegalArgumentException e) {
			assertTrue(true);
		}
	}
	
	@Test
	public void testCreate3() {
		try {
			Dice.createDice(0);
			fail();
		} catch(IllegalArgumentException e) {
			assertTrue(true);
		}
	}
	
	@Test
	public void testSetFace() {
		Dice dice = Dice.createDice(4);
		try {
			dice.setDieFaceValue(1);
			assertTrue( dice.getDieFaceValue() == 1 );
			
		} catch(IllegalArgumentException e) {
			fail();
		}
	}
	
	@Test
	public void testSetFace2() {
		Dice dice = Dice.createDice(4);
		try {
			dice.setDieFaceValue(0);
			fail();
		} catch(IllegalArgumentException e) {
			assertTrue(true);
		}
	}
	
	@Test
	public void testSetFace3() {
		Dice dice = Dice.createDice(4);
		try {
			dice.setDieFaceValue(7);
			fail();
		} catch(IllegalArgumentException e) {
			assertTrue(true);
		}
	}
}
