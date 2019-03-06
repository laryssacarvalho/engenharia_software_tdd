import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import builder.CriadorDeJogo;
import dominio.Jogo;
import dominio.Participante;
import junit.framework.Assert;

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
	
	@Test
	void todoJogoTemDescricao() {
		Jogo jogo = new CriadorDeJogo()
		.para("Teste Jogo")
		.constroi();		
		
	   assertFalse(jogo.getDescricao() == null);
	   assertFalse(jogo.getDescricao().isEmpty());
	}

}
