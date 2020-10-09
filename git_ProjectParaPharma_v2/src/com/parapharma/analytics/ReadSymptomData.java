package com.parapharma.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Acquisition des symptômes et création du dictonnaire correspondant.
 *
 * @see AnalyticsCounter
 * @see WriteSymptomData
 * @author : Yanis, François, Jérôme
 * @version : 2.0
 */
class ReadSymptomData implements ISymptomReader {
	/**
	 * Informations d'accès au stockage des symptômes.
	 *
	 * Pour un fichier, il s'agit d'un chemin d'accès absolu ou relatif.
	 */
	private String src;
	/**
	 * Le dictionnaire des symptômes.
	 * Le dictionnaire est organisé sur le modèle 'nom du symptôme, nbr d'occurrences du symptôme.
	 */
	TreeMap<String, Integer> treeSymptoms = new TreeMap<>();

	/**
	 * Définir les informations d'accès au stockage des symptômes.
	 *
	 * @param src
	 * 	Les informations d'accès au stockage.
	 * @author : Yanis, François, Jérôme
	 * @version : 1.0
	 */
	public ReadSymptomData (String src) {
		this.src = src;
	}

	/**
	 * Lire le fichier des symptômes et créer le dictionnaire correspondant.
	 *
	 * @return Le dictionnaire des symptômes.
	 * @author : Yanis, François, Jérôme
	 * @version : 1.0
	 */
	@Override
	public TreeMap<String, Integer> GetSymptomsFromFile() {
		if (src != null) {
			try {
				/**
				 * Le tampon de lecture du fichier de symptômes.
				 */
				BufferedReader reader = new BufferedReader (new FileReader(src));
				/**
				 * La ligne lue dans le dictionnaire des symptômes.
				 */
				String line = reader.readLine();
				while (line != null) {
					if (treeSymptoms.containsKey(line)) {
						treeSymptoms.put(line, treeSymptoms.get(line) + 1);
					} else {
						treeSymptoms.put(line, 1);
					}
					line = reader.readLine();
				}
				reader.close();
				} catch (IOException e) {
				System.out.println("Le fichier '" + src + "' n'existe pas ou est inaccessible.");
				System.out.println("Aucun traitement n'a été réalisé.");
			}
		}
		if (treeSymptoms.size() == 0) {
			System.out.println("Le fichier des symptômes est vide.");
			System.out.println("Aucun traitement n'a été réalisé.");
		}
		return treeSymptoms;
	}
}
