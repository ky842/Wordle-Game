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
	
	@Test
	void testDisplay1() {
		assertEquals("a__le", WordleGame.display("steal", "apple"));
		assertEquals("_____", WordleGame.display("brush", "cloak"));
		assertEquals("WORDS", WordleGame.display("words", "words"));
		assertEquals("heart", WordleGame.display("earth", "heart"));
		assertEquals("baBE_", WordleGame.display("abbey", "babes"));
		assertEquals("doO__", WordleGame.display("flood", "doors"));
	}

}
