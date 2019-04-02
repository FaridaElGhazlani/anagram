package anagram;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Dictionary;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
	private static final Logger LOGGER = Logger.getLogger(Main.class.getName());
	public static final Mot DOCUMENTING = new Mot("documenting ");

	public static void main(String[] args) throws IOException, URISyntaxException {

		// TODO Auto-generated method stub
		Main main = new Main();

		List<Mot> dictionnaire = main.readFileWithStreams();
//		List<Mot> dictionnaire = main.readFile();
		// LOGGER.info(dictionnaire.toString());
		
		List<Mot> aTester = creerPaire (dictionnaire);
		// LOGGER.info(aTester.toString());
		
		for (Mot paire : aTester) {
			if (paire.isIn(DOCUMENTING)) {
				System.out.println(paire);
			}
		}
	}

	private static List<Mot> creerPaire(List<Mot> dictionnaire) {
		// TODO Auto-generated method stub
		List<Mot> paires = new ArrayList<>();
		
		for (int i = 0; i < dictionnaire.size() - 1; i++) {
			for (int j = i+1 ; j < dictionnaire.size(); j++) {
				Mot premier = dictionnaire.get(i);
				Mot deuxieme = dictionnaire.get(j);
				paires.add(new Mot(premier+" "+deuxieme));
			}
		}
		
		return paires;
	}
	
	

	public List<Mot> readFile() {
		List<Mot> dictionnaire = new ArrayList<>();

		try (InputStream input = getClass().getClassLoader().getResourceAsStream("wordlist.txt");
				InputStreamReader inputReader = new InputStreamReader(input);
				BufferedReader reader = new BufferedReader(inputReader)) {
			String line = null;
			while ((line = reader.readLine()) != null) {
				String[] splitLine = line.trim().split(" +");
				for (String s : splitLine) {
					Mot mot = new Mot(s);
					boolean result = mot.isIn(DOCUMENTING);
					if (result == true) {
						dictionnaire.add(mot);
					}
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			LOGGER.log(Level.SEVERE, "fichier non trouvé", e);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			LOGGER.log(Level.SEVERE, "impossible de lire le fichier", e);
		}
		return dictionnaire;
	}

	public List<Mot> readFileWithStreams() throws IOException, URISyntaxException {
		URL resource = getClass().getClassLoader().getResource("wordlist.txt");
		return Files.lines(Paths.get(resource.toURI()))
			.map((String line) -> line.trim().split(" +"))
			.flatMap((String[] words) -> Stream.of(words))
			.map((String word) -> new Mot(word))
			.filter((Mot mot) -> mot.isIn(DOCUMENTING))
			.collect(Collectors.toList());
	}

}
