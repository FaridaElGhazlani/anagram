package anagram;



import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class MotTest {

	@Test
	void isTestn_Test() {
		Assertions.assertThat(Mot.isMot1InMot2("testn", "test")).isFalse();
	}
	
	@Test
	void isTest_Test() {
		Assertions.assertThat(Mot.isMot1InMot2("test", "test")).isTrue();
	}
	
	@Test
	void isTest_Testn() {
		Assertions.assertThat(Mot.isMot1InMot2("test", "testn")).isTrue();
	}

	@Test
	void isComet_Documenting() {
		Assertions.assertThat(Mot.isMot1InMot2("comet", Main.DOCUMENTING)).isTrue();
	}
	
	@Test
	void isConnect_Documenting() {
		Assertions.assertThat(Mot.isMot1InMot2("Connect", Main.DOCUMENTING)).isFalse();
	}
	
	@Test
	void isConnet_Documenting() {
		Assertions.assertThat(Mot.isMot1InMot2("Connet", Main.DOCUMENTING)).isTrue();
	}
}
