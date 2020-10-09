package com.parapharma.analytics;

import java.util.TreeMap;

/**
 * Définition des éléments dédiés à l'enregistrement de dictionnaire.
 *
 * @author : Yanis, François, Jérôme
 * @version : 1.0
 */
public interface ISymptomWriter {
    /**
     * If no data is available, return an empty List
     *
     * @param treeSymptoms
     *  Le dictionnaire de decompte des symptômes.
     */
    public void WriteSymptomsToFile(TreeMap<String, Integer> treeSymptoms);
}