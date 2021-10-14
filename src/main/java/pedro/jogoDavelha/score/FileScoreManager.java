package pedro.jogoDavelha.score;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import pedro.jogoDavelha.centro.Jogador;

public class FileScoreManager implements ScoreManager {
    
	private static final Path SCORE_FILE = Path.of("score.txt");
	
	private Map<String, Integer> scoreMap = new HashMap<>();
	
	
	
	public FileScoreManager() throws IOException {
	     setup();
	}
	
	private void setup() throws IOException {
		
		if(!Files.exists(SCORE_FILE)) {
			Files.createFile(SCORE_FILE);
		}
		
	 try (BufferedReader reader = Files.newBufferedReader(SCORE_FILE)) {
		 String line;
		 
		 while((line = reader.readLine()) != null) {
			 String[] tokens = line.split("\\|");
			 
			 scoreMap.put(tokens[0], Integer.parseInt(tokens[1]));
		 }
	 }
	}

	@Override
	public Integer getScore(Jogador jogador) {
		// TODO Auto-generated method stub
		return scoreMap.get(jogador.getNome().toUpperCase());
	}

	@Override
	public void saveScore(Jogador jogador) throws IOException {
		// TODO Auto-generated method stub
		
		Integer score = getScore(jogador);
		
		if (score == null) {
			score = 0;
		}
		
		scoreMap.put(jogador.getNome().toUpperCase(), score + 1);
		
		try(BufferedWriter writer = Files.newBufferedWriter(SCORE_FILE)){
			
			Set<Map.Entry<String, Integer>> entries = scoreMap.entrySet();
			
			for(Map.Entry<String, Integer> e : entries ) {
				String nome = e.getKey();
				Integer pont = e.getValue();
				writer.write(nome + "|" + pont);
				writer.newLine();
				
			}
		}
		
	}

}
