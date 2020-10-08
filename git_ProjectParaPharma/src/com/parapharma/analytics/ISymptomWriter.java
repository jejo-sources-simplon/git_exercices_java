package com.parapharma.analytics;

import java.util.LinkedHashMap;

/**
 * Anything that will store the account symptom.
 *
 */
public interface ISymptomWriter {
    /**
     * If no data is available, return an empty List
     *
     * @param HashMapSymptomes
     *  Le dictionnaire de decompte des symptômes.
     */
    void WriteSymptomsToFile(LinkedHashMap<String, Integer> HashMapSymptomes);
}