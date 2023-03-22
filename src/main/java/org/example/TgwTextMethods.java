package org.example;

import org.apache.commons.lang3.StringUtils;

public class TgwTextMethods {
    //all these methods work with raw tengwar text, not Latin alphabet
    //TODO only use String[] in and out of the method, no String/StringBuilder?

    public static String fixDoubleConsonants(String inputText) {
        String[] rawChars = new String[]{"ww","zz", "22", "ee", "xx", "99", "ss", "zz", "jj", "yy", "66", "qq", "zz", "77", "88", "11", "rr", "nn", "AA", ",,"};
        String[] fixedChars = new String[]{"w:", "z;", "2:", "e;", "x:", "9;", "s:", "z;", "j:", "t", "5", "q;", "z;", "7;", "k", "1;", "r;", "n;", "A;", ""};
        return StringUtils.replaceEach(inputText, rawChars, fixedChars);
    }

    public static String fixFinalNGs(String inputText) { //TODO this is complicated, need a regex to find "ng"/"ngs" at end of words; "ng's" != "ngs"
//        StringBuilder outputText = new StringBuilder();
//        String[] inputArr = inputText.split("\\s+");
//        for (String word : inputArr) {
//            word = word.replace("6x8 ","b_ ") //ngs
//            .replace("6x ","b "); //ng
//            outputText.append(" " + word);
//        }

        return inputText.replaceAll("xP\\b", "b ")
                .replaceAll("xP8\\b", "b_ ");

        /*
        String[] rawChars = new String[]{"xP ", "xP8 "};
        String[] fixedChars = new String[]{"b ", "b_ "};
        return StringUtils.replaceEach(inputText, rawChars, fixedChars);
        */

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


        public static String fixOfThes(String inputText ) {
//            String[] rawChars = new String[]{" ]62 "," 3l "," he "," he 3l "};
//            String[] fixedChars = new String[]{" 2P "," @ "," W "," W: "};
//            return StringUtils.replaceEach(inputText, rawChars, fixedChars);

            return inputText
                    .replaceAll(" he 3l ", " W: ")
                    .replaceAll(" ]62 ", " 2P ") //and
                    .replaceAll(" 3l ", " @ ") //the
                    .replaceAll(" he ", " W ") //of
                    ; //of the
    }
}