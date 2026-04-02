package wordle;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import wordle.WordleGame;

class WordleGameTest {

	@Test
	void testDisplay() {
		assertEquals(5, WordleGame.display("cherry", "crane").length());
		
		assertEquals("Cr__e", WordleGame.display("cherry", "crane"));
		assertEquals("GA__S", WordleGame.display("gains", "games"));
		assertEquals("anti_", WordleGame.display("giant", "antic"));
		
		// Test some fake words to test extreme cases
		assertEquals("_BbCC", WordleGame.display("bbccc", "abbcc"));
		assertEquals("_AaA_", WordleGame.display("aabaa", "caaac"));
		
	}

}
