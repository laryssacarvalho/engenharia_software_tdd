import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import dominio.Participante;

public class ParticipanteTest {
	
	class NotParticipanteClass {
		
	}
	
	@Test
	void metodoEqualsDeveRetornarTrue() {
		Participante p1 = new Participante(1, "X");
		Participante p2 = new Participante(1, "X");
		
		
		assertEquals(p1.equals(p2), true);
		assertEquals(p2.equals(p1), true);
	}	
	
	@Test
	void metodoEqualsDeveRetornarFalse() {
		Participante p1 = new Participante(1, "X");
		Participante p2 = new Participante(2, "X");
		Participante p3 = null;
		NotParticipanteClass p4 = new NotParticipanteClass();
		int p5 = 1;
		Participante p6 = new Participante(2, "Y");
		Participante p7 = new Participante(7, null);
		Participante p8 = new Participante(7, "Z");
		
		assertEquals(p1.equals(p2), false);
		assertEquals(p2.equals(p3), false);
		assertEquals(p1.equals(p4), false);
		assertEquals(p1.equals(p5), false);
		assertEquals(p2.equals(p6), false);	
		assertEquals(p7.equals(p8), false);
	}

}
