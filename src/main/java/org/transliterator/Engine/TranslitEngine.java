package org.transliterator.Engine;

import org.transliterator.GUI.Constants;

public class TranslitEngine {
    //This class manages the transliteration process
    //If I have free time, I might add more variations of the transliteration process
    //See http://at.mansbjorkman.net/teng_modes.htm

    public static String transliterateText(String inputText, String pickedMode) {
        String output;
        output = EngTextMethods.stripDiacritics(inputText);
        output = EngTextMethods.translWordDigraphsSimple(output);
        output = EngTextMethods.translWordCharsSimple(output);
        output = TgwTextMethods.fixOfThes(output);

        switch (pickedMode) {
            case (Constants.PICKER_MODE_AUTHOR_FULL):
                output = TgwTextMethods.fixDoubleConsonants(output);
                output = TgwTextMethods.putDotsForFullMode(output);
                output = TgwTextMethods.fixFinalNGs(output);
                break;

            case (Constants.PICKER_MODE_AUTHOR_OMATEHTA):
                output = TgwTextMethods.fixNasals(output);
                output = TgwTextMethods.fixDoubleConsonants(output);
                output = TgwTehtarTextMethods.tehtarizeVowels(output);
                output = TgwTehtarTextMethods.fixDiphtongs(output);
                output = TgwTextMethods.fixFinalNGs(output);
                output = TgwTehtarTextMethods.putTehtarOnSucceedingTengwar(output);
                //put final Ss
                break;
        }

        output = TgwTextMethods.applyFinalAdjustments(output);

        return output;
    }
}