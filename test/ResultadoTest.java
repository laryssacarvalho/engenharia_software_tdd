import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import dominio.Participante;
import dominio.Resultado;

class ResultadoTest {

	@Test
	void deveAdicionarParticipanteEMetrica() {
		Participante participante = new Participante("Test");
		double metrica = 5.3;
		
		Resultado resultado = new Resultado(participante, metrica);
		
		assertEquals(resultado.getMetrica(), 5.3);
		assertEquals(resultado.getParticipante().getNome(), "Test");
	}

}
