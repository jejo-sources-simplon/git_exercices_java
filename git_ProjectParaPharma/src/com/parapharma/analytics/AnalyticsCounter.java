package com.parapharma.analytics;

import java.util.*;

/**
 * Classe principale : décompte des symptômes.
 *
 * @see ReadSymptomData
 * @see WriteSymptomData
 * @author : Yanis, François, Jérôme
 * @version : 1.0
 */
public class 	AnalyticsCounter {
	/**
	 * La liste des symptômes.
	 */
	private static List<String> listeSymptomes;
	/**
	 * Le dictionnaire de décompte des symptômes.
	 */
	private static LinkedHashMap<String, Integer> linkedHashMapSymptomes;

	public static void main(String args[]) {
		readSymptoms();
		if (listeSymptomes != null) {
			createDictionary();
			writeSymptomsAccount();
		}
	}

	/**
	 * Lire le fichier des symptômes et initialiser la liste des symptômes.
	 *
	 * @see ReadSymptomData
	 */
	static void readSymptoms() {
		ReadSymptomData readSymptoms = new ReadSymptomData("symptoms.txt");
		listeSymptomes = readSymptoms.GetSymptomsFromFile();
	}

	/**
	 * Créer le dictionnaire de décompte des symptômes depuis la liste des symptômes.
	 */
	static private void createDictionary() {
		linkedHashMapSymptomes = new LinkedHashMap<String, Integer>();
		Iterator<String> itListeSymptomes = listeSymptomes.iterator();
		String Symptom;
		while (itListeSymptomes.hasNext()) {
			Symptom = itListeSymptomes.next();
			linkedHashMapSymptomes.put(Symptom, Collections.frequency(listeSymptomes, Symptom));
		}
	}

	/**
	 * Créer le fichier de sortie de décompte des symptômes.
	 *
	 * @see WriteSymptomData     *
	 */
	static void writeSymptomsAccount() {
		WriteSymptomData WriteSymptoms = new WriteSymptomData("result.out");
		WriteSymptoms.WriteSymptomsToFile(linkedHashMapSymptomes);
	}
}
