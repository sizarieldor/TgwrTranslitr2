package org.transliterator.Engine;

import org.apache.commons.lang3.StringUtils;

public class TgwTextMethods {
    //Here are the methods that work on the text after the Latin-alphabet chars have been mapped to their closest tengwa equivalents
    //The methods here are not dealing with tehtar (the doodles above the runes, which denote vowels)
    //all these methods work with raw tengwar text, not Latin alphabet

    public static String fixOfThes(String inputText ) {

        return inputText
                .replaceAll(" he 3l ", " W: ")
                .replaceAll(" ]62 ", " 2P ")
                .replaceAll(" 3l ", " @ ")
                .replaceAll(" he ", " W ")
                ;
    }

    public static String fixDoubleConsonants(String inputText) {
        String[] rawChars = new String[]{"ww","zz", "22", "ee", "xx", "99", "ss", "zz", "jj", "yy", "66", "qq", "zz", "77", "88", "11", "rr", "nn", "AA", ",,"};
        String[] fixedChars = new String[]{"w:", "z;", "2:", "e;", "x:", "9;", "s:", "z;", "j:", "t", "5", "q;", "z;", "7;", "k", "1;", "r;", "n;", "A;", ""};
        return StringUtils.replaceEach(inputText, rawChars, fixedChars);
    }

    public static String fixNasals(String inputText) {
        String[] rawChars = new String[]{"yw", "6z","62","6e","6x","6s","yq","61","6r","6a"};
        String[] fixedChars = new String[]{"wP", "zp", "2P", "ep", "xP", "sp", "qp", "1p", "rP", "aP"};
        return StringUtils.replaceEach(inputText, rawChars, fixedChars);
    }

    public static String putDotsForFullMode(String inputText) {
        String[] rawChars = new String[]{"]","`"};
        String[] fixedChars = new String[]{"]G","`B"};
        return StringUtils.replaceEach(inputText, rawChars, fixedChars);
    }

    public static String fixFinalNGs(String inputText) { //this uses a regex to find "ng"/"ngs" at end of words; "ng's" != "ngs"
        return inputText.replaceAll("xP\\b", "b ")
                .replaceAll("xP8\\b", "b_ ");
    }

/*    public static String fixFinalSs(String inputText) { //TODO format the terminal 's' tengwar for stylistic purposes; is this even necessary?
        //do a regex for every consonant-vowel-S
//        return inputText.replaceAll("")
        return "";
    }*/

    public static String applyFinalAdjustments(String inputText) {
        //this method is for making small corrections that would be inconvenient to perform earlier in the program
        //replace the placeholder for 'x': 'A'
        return inputText.replaceAll("A", "z|");
    }
}