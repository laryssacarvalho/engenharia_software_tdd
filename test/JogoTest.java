import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import builder.CriadorDeJogo;
import dominio.Jogo;
import dominio.Resultado;
import dominio.Participante;
import junit.framework.Assert;

class JogoTest {	
	
	@Parameter
	public static List<Participante> participantes = new ArrayList<Participante>() {{
		
		add(new Participante("A"));
		add(new Participante("B"));
		add(new Participante("C"));
		add(new Participante("D"));
		add(new Participante("E"));
		
	}};
	
	@Parameter
	public static int numColocacoes = 3;
	
	@Parameter
	public static List<Resultado> resultados = new ArrayList<Resultado>() {{
		
		add(new Resultado(participantes.get(0), 85));
		add(new Resultado(participantes.get(1), 105));			
		add(new Resultado(participantes.get(2), 20));			
		add(new Resultado(participantes.get(3), 55));			
		add(new Resultado(participantes.get(4), 20));	
		
	}};
	
	@Test
	void ordenacaoResultadosPorMetrica() {					
		
		Jogo jogo = new CriadorDeJogo()
				.para("Teste Ordenação por Metrica")
				.adicionaResultado(resultados.get(0))
				.adicionaResultado(resultados.get(1))
				.adicionaResultado(resultados.get(2))
				.adicionaResultado(resultados.get(3))
				.adicionaResultado(resultados.get(4))
				.constroi();			
		
		assertEquals(new ArrayList<Resultado>() {{
			
			add(resultados.get(1));
			add(resultados.get(0));
			add(resultados.get(3));
			add(resultados.get(2));
			add(resultados.get(4));
			
		}}, jogo.ordenaResultadosPorMetrica());
	}
	
	@Test
	void identificaPrimeirosColocadosJogo() {
		
		Jogo jogo = new CriadorDeJogo()
				.para("Teste Identifica Primeiros Colocados Jogo")
				.adicionaResultado(resultados.get(2))
				.adicionaResultado(resultados.get(3))
				.adicionaResultado(resultados.get(0))
				.adicionaResultado(resultados.get(1))
				.constroi();
		
		assertEquals(new ArrayList<Participante>(){{
			
			add(participantes.get(1));
			add(participantes.get(0));
			add(participantes.get(3));
			
		}}, jogo.identificaPrimeirosColocadosJogo(numColocacoes));		
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
	
	@Test
	void todoJogoTemDescricao() {
		Jogo jogo = new CriadorDeJogo()
		.para("Teste Jogo")
		.constroi();		
		
	   assertFalse(jogo.getDescricao() == null);
	   assertFalse(jogo.getDescricao().isEmpty());
	}
	
	@Test
	void devePermitirApenasUmParticipante() {
		Jogo jogo = new Jogo("Jogo um participante");
						
		assertEquals(0, jogo.getResultados().size());
		
		jogo.anota(new Resultado(new Participante("Maria"), 100));
		
		assertEquals(1, jogo.getResultados().size());
		
		assertEquals(100.0, jogo.getResultados().get(0).getMetrica(), 0.00001);
	}

}
