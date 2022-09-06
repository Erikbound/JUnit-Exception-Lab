import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GradebookTester {

	GradeBook a;
	GradeBook b;
	
	@BeforeEach
	void setUp() throws Exception {
		a = new GradeBook(5);
		b = new GradeBook(5);
		
		a.addScore(3.5);
		a.addScore(8.8);
		
		b.addScore(12.4);
		b.addScore(2.2);;
		b.addScore(35.1);
		
	}

	@AfterEach
	void tearDown() throws Exception {
		a = null;
		b = null;
	}

	@Test
	void testAddScore() {
		assertTrue(a.toString().equals("3.5 8.8 "));
		assertTrue(b.toString().equals("12.4 2.2 35.1 "));
	}
	@Test
	void testSum() {
		assertEquals(a.sum(), 12.3);
		assertEquals(b.sum(), 49.7);
	}
	@Test
	void testMinimum() {
		assertEquals(a.minimum(), 3.5);
		assertEquals(b.minimum(), 2.2);
	}
	@Test
	void testFinalScore() {
		assertEquals(a.finalScore(), 8.8);
		assertEquals(b.finalScore(), 47.5);
	}

}
