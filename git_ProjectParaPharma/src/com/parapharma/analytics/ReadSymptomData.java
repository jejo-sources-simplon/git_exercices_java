package com.parapharma.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Classe chargée de l'acquisition des symptômes.
 *
 * @see AnalyticsCounter
 * @see WriteSymptomData
 * @author : Yanis, François, Jérôme
 * @version : 1.0
 */
class ReadSymptomData implements ISymptomReader {
	/**
	 * Le nom du fichier de symptômes
	 *
	 * Ce nom peut contenir un chmin d'accès absolu ou relatif.
	 */
	private String filepath;

	/**
	 * Constructeur de la classe.
	 *
	 * @param filepath
	 * 	Le nom du fichier de symptômes.
	 */
	public ReadSymptomData (String filepath) {
		this.filepath = filepath;
	}

	/**
	 * Lire le fichier des symptômes et initialiser la liste des symptômes.
	 *
	 * @return Une instance Connection sur la base de donées MySQL.
	 */
	@Override
	public List<String> GetSymptomsFromFile() {
		/**
		 * La liste des symptômes.
		 */
		ArrayList<String> result = new ArrayList<String>();
		
		if (filepath != null) {
			try {
				/**
				 * Le tampon de lecture du fichier de symptômes.
				 */
				BufferedReader reader = new BufferedReader (new FileReader(filepath));
				/**
				 * La ligne lue dans le fichier de symptômes.
				 */
				String line = reader.readLine();
				
				while (line != null) {
					result.add(line);
					line = reader.readLine();
				}
				reader.close();
				} catch (IOException e) {
				System.out.println("Le fichier '" + filepath + "' n'existe pas ou est inaccessible.");
				System.out.println("Aucun traitement n'a été réalisé.");
			}
		}
		if (result.size() == 0) {
			System.out.println("Le fichier des symptômes est vide.");
			System.out.println("Aucun traitement n'a été réalisé.");
		} else {
			Collections.sort(result);
		}
		return result;
	}
}
