package com.parapharma.analytics;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/**
 * Classe chargée de l'enregistrement du décompte des symptômes.
 *
 * @see AnalyticsCounter
 * @see ReadSymptomData
 *
 * @author : Yanis, François, Jérôme
 * @version : 1.0
 */
class WriteSymptomData implements ISymptomWriter {
    /**
     * Le nom du fichier de sortie.
     *
     * Ce nom peut contenir un chmin d'accès absolu ou relatif.
     */
    private String filepath;

    /**
     * Constructeur de la classe.
     *
     * @param filepath
     * 	Le nom du fichier de sortie.
     */
    WriteSymptomData(String filepath) {
        this.filepath = filepath;
    }

    /**
     * Ecrire le fichier des sortie du décompte des symptômeS.
     *
     * @param HashMapSymptomes
     *  Le dictionnaire de decompte des symptômes.
     */
    @Override
    public void WriteSymptomsToFile(LinkedHashMap<String, Integer> HashMapSymptomes) {

        if (filepath != null) {
            try {
                BufferedWriter writer = new BufferedWriter (new FileWriter(filepath));
                for (HashMap.Entry<String, Integer> entry : HashMapSymptomes.entrySet()) {
                    writer.write(entry.getKey() + " : " + entry.getValue() + "\n");
                }
                writer.close();
                System.out.println("Le décompte de " + HashMapSymptomes.size() + " symptôme(s) a été enregistré dans le fichier '" + filepath + "'.");
            } catch (IOException e) {
                System.out.println("Le fichier '" + filepath + "' n'a pas pu être créé.");
                System.out.println("Le décompte des symptômes n'a pas été enregistré ");
            }
        }

    }
}
