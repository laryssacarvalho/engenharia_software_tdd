package builder;
import dominio.Jogo;
import dominio.Participante;
import dominio.Resultado;

public class CriadorDeJogo {
	
	private Jogo jogo;

    public CriadorDeJogo() { }

    public CriadorDeJogo para(String descricao) {
        this.jogo = new Jogo(descricao);
        return this;
    }

    public CriadorDeJogo resultado(Participante participante, double metrica) {
        jogo.anota(new Resultado(participante, metrica));
        return this;
    }
    
    public CriadorDeJogo adicionaResultado(Resultado resultado) {
    	jogo.anota(resultado);
    	return this;
    }
    

    public Jogo constroi() { 
        return jogo;
    }

}