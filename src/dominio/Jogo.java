package dominio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Jogo{

	private String descricao;
	private List<Resultado> resultados;
	
	public Jogo(String descricao) {
		this.descricao = descricao;
		this.resultados = new ArrayList<Resultado>();
	}
	
	public void anota(Resultado resultado) {
		if(resultados.isEmpty() || 
                !resultados.get(ultimoResultadoVisto()).getParticipante().equals(resultado.getParticipante())) {
            resultados.add(resultado);
        }
	}
	
	public List<Participante> identificaPrimeirosColocadosJogo(int numColocacoes){
		
		List<Resultado> resultadosOrdenados = ordenaResultadosPorMetrica()
				.stream()
				.limit(numColocacoes)
				.collect(Collectors.toList());
		
		List<Participante> participantes = new ArrayList<Participante>();
		
		for(Resultado r:resultadosOrdenados) {
			
			participantes.add(r.getParticipante());
		}
		
		return participantes;
		
	}
	
	public List<Resultado> ordenaResultadosPorMetrica(){
		
		List<Resultado> resultadosOrdenados = resultados;
		
		 Collections.sort(resultadosOrdenados, Comparator.comparingDouble(Resultado::getMetrica).reversed());		
		
		return resultadosOrdenados;
		
	}

	private int ultimoResultadoVisto() {
		return resultados.size()-1;
	}

	public String getDescricao() {
		return descricao;
	}

	public List<Resultado> getResultados() {
		return Collections.unmodifiableList(resultados);
	}

}
