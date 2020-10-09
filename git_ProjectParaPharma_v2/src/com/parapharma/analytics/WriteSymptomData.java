package com.parapharma.analytics;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.io.*;

/**
 * Enregistrement du dictionnaire des symptômes.
 *
 * @see AnalyticsCounter
 * @see ReadSymptomData
 *
 * @author : Yanis, François, Jérôme
 * @version : 1.0
 */
class WriteSymptomData implements ISymptomWriter {
    /**
     * Information(s) d'accès pour l'enregistrement du dictionnaire des symptômes.
     *
     * Pour un fichier, il s'agit d'un chemin d'accès absolu ou relatif.
     */
    private String dest;

    /**
     * Définir les informations de stockage pour l'enregistrement du dictionnaire des symptômes.
     *
     * @param dest
     * 	Le nom du fichier de symptômes à écrire.
     * @author : Yanis, François, Jérôme
     * @version : 1.0
     */
    WriteSymptomData(String dest) {
        this.dest = dest;
    }

    /**
     * Enregistrer le dictionnaire dans un nouveau fichier.
     *
     * @param treeSymptoms
     *  Le dictionnaire de decompte des symptômes.
     * @author : Yanis, François, Jérôme
     * @version : 1.0
     */
    @Override
    public void WriteSymptomsToFile(TreeMap<String, Integer> treeSymptoms) {

        if (dest != null) {
            try {
                BufferedWriter writer = new BufferedWriter (new FileWriter(dest));
                for (HashMap.Entry<String, Integer> entry : treeSymptoms.entrySet()) {
                    writer.write(entry.getKey() + " : " + entry.getValue() + "\n");
                }
                writer.close();
            } catch (IOException e) {
                System.out.println("Le fichier '" + dest + "' n'a pas pu être créé.");
                System.out.println("Le décompte des symptômes n'a pas été enregistré ");
            }
        }
    }
}
