package wordle;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import wordle.WordleGame;

class WordleGameTest {

	@Test
	void testDisplay() {
		assertEquals("Cr__E", WordleGame.display("cherry", "crane"));
		
	}

}
