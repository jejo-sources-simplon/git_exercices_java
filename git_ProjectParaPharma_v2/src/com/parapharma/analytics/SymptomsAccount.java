package com.parapharma.analytics;

/**
 * Classe principale : appel de création de dictionnaires de symptômes.
 *
 * @see AnalyticsCounter
 * @author : Yanis, François, Jérôme
 * @version : 1.0
 */
public class SymptomsAccount {

    public static void main(String[] args) {

        // Créer un dictionnnaire 'resul.out' deptuis le fichier de symptômes 'symptoms.txt'.
        AnalyticsCounter ac = new AnalyticsCounter("symptoms.txt", "result.out", "file");
        ac.printDicInfoFile();

        // Créer un dictionnnaire 'resul1.out' deptuis le fichier de symptômes 'symptoms1.txt'.
        AnalyticsCounter ac1 = new AnalyticsCounter("symptoms1.txt", "result1.out", "file");
        ac1.printDicInfoFile();

    }

}
