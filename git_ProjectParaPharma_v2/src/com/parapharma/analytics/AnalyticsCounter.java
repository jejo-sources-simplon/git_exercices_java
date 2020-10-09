package com.parapharma.analytics;

import java.io.File;
import java.util.*;

/**
 * Création d'un dictionnaire et d'un fichier de symptômes.
 *
 * @see ReadSymptomData
 * @see WriteSymptomData
 * @author : Yanis, François, Jérôme
 * @version : 2.0
 */
class AnalyticsCounter {

	/**
	 * Informations d'accès au stockage des symptômes.
	 *
	 * Pour un fichier, il s'agit d'un chemin d'accès absolu ou relatif.
	 */
	private String src;
	/**
	 * Information(s) de stockage pour l'enregistrement du dictionnaire des symptômes.
	 *
	 * Pour un fichier, il s'agit d'un chemin d'accès absolu ou relatif.
	 */
	private String dest;
	/**
	 * Définit le type de stockage des symptômes.
	 *
	 * Pour un fichier, le type est 'file'.
	 */
	private String storage;
	/**
	 * Le dictionnaire de décompte des symptômes.
	 */
	private TreeMap<String, Integer> treeSymptoms;
	/**
	 * Le nombre de cas de symptômes recensés.
	 */
	private int nbCases;

	/**
	 * Définir les informations d'accès aux stockages.
	 *
	 * @param src
	 * 	Les informations d'accès au stockage des symptômes.
	 * @param dest
	 *	Les informations pour l'enregistrement du dictionnaire des symptômes.
	 * @param storage
	 *	Définit le type de stockage des symptômes.
	 * @author : Yanis, François, Jérôme
	 * @version : 2.0
	 */
	public AnalyticsCounter(String src, String dest, String storage) {
		this.src = src;
		this.dest = dest;
		this.storage = storage;

		switch (storage) {
			case "file" :
				if (!existFileDest()) {
					createDicFromFile();
				}
				break;
			default :
		}
	}

	/**
	 * Vérifier l'existence d'un fichier.
	 *
	 * @return true : le fichier existe, false il n'existe pas.
	 * @author : Yanis, François, Jérôme
	 * @version : 1.0
	 */
	private boolean existFileDest() {
		if ((new File(dest)).exists()) {
			System.out.println(" -- Création de dictionnaire --");
			System.out.println("Un fichier de dictionnaire '" + dest + "' existe déjà !");
			System.out.println("Le décompte des symptômes demandé est annulé.");
			System.out.println();
			return true;
		}
		return false;
	}

	/**
	 * Créer le dictionnaire des symptômes.
	 *
	 * @author : Yanis, François, Jérôme
	 * @version : 1.0
	 */
	private void createDicFromFile() {
		treeSymptoms = (new ReadSymptomData(src)).GetSymptomsFromFile();
		if (treeSymptoms != null) {
			(new WriteSymptomData(dest)).WriteSymptomsToFile(treeSymptoms);
			treeSymptoms.forEach((key, value) -> nbCases += value);
		}
	}

	/**
	 * Afficher les informations relatives au dictionnaire.
	 *
	 * @author : Yanis, François, Jérôme
	 * @version : 1.0
	 */
	public void printDicInfoFile() {
		if (treeSymptoms != null) {
			System.out.println(" -- Informations de dictionnaire --");
			System.out.println("Le dictionnaire '" + dest + "' à été créé à partir du fichier '" + src + "'.");
			System.out.println("Il contient " + treeSymptoms.size() + " symptômes pour " + nbCases + " cas recensés.");
			System.out.println();
		}
	}
}
