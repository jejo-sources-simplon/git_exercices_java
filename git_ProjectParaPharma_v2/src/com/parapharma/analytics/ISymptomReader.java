package com.parapharma.analytics;

import java.util.TreeMap;

/**
 * Définition des éléments dédiés à la lecture de fichiers de symptômes.
 *
 * @author : Yanis, François, Jérôme
 * @version : 1.0
 */
public interface ISymptomReader {
	/**
	 * If no data is available, return an empty List
	 *
	 * @return a raw listing of all Symptoms obtained from a data source, duplicates are possible/probable
	 */
	public TreeMap<String, Integer> GetSymptomsFromFile();
}
