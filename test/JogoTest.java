import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import builder.CriadorDeJogo;
import dominio.Jogo;
import dominio.Participante;

class JogoTest {

	@Test
	void naoDeveAceitarDoisResultadosDoMesmoParticipante() {
		Jogo jogo = new CriadorDeJogo()
		.para("Teste Jogo")
		.resultado(new Participante("Maria"), 150)
		.resultado(new Participante("Maria"), 230)
		.constroi();
		
		assertEquals(1, jogo.getResultados().size());
		assertEquals(150, jogo.getResultados().get(0).getMetrica());
	}
	
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
