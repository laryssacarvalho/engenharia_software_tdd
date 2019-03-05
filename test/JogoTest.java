import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import builder.CriadorDeJogo;
import dominio.Jogo;
import dominio.Participante;

class JogoTest {	
	
	@Test
	void devePermitirVariosParticipantes() {
		Jogo jogo = new CriadorDeJogo()
		.para("Teste Jogo")
		.resultado(new Participante("João"), 100)
		.resultado(new Participante("Luisa"), 200)
		.constroi();
		
		assertEquals(2, jogo.getResultados().size());
	}

}
