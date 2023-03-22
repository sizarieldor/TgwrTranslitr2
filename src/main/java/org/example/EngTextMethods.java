package org.example;

import java.util.Map;

public class EngTextMethods {

//    public static String revertVowels(String inputText) { //strip diacritics from letters
//        return inputText.replaceAll()
//    }

    //use this to transliterate the following digraphs into their corresponding tengwar
    public static String translWordDigraphsSimple(String inputWord) {
        //this method uses two obscure chars to mark digraphs
        String outputWord = inputWord
                .replaceAll("dh", "4") //TODO check
                .replaceAll("dh", "┤4╡") //Alt + 180, Alt + 181
                .replaceAll("ch", "┤a╡")
                .replaceAll("gh", "┤v╡")
                .replaceAll("kh", "┤Z╡")
                .replaceAll("lh", "┤m╡")
                .replaceAll("ph", "┤Q╡")
                .replaceAll("rh", "┤u╡")
                .replaceAll("sh", "┤d╡")
                .replaceAll("th", "┤3╡")
                .replaceAll("wh", "┤o╡")
                .replaceAll("zh", "┤f╡")
//                .replaceAll("nn", "[5]") //NB these two are done in the "double consonants" method in the Tengwar Engine class
//                .replaceAll("mm", "[t]")
                ;
        return outputWord;
    }

    //once the digraphs have been matched to their tengwar, proceed to transliterate the individual chars that are left
    public static String translWordCharsSimple(String inputWord) {
        Map<Character, String> singleCharsMap = CharMaps.initSingleCharsMap();
        char[] inputCharArr = inputWord.toCharArray();
        StringBuilder outputWord = new StringBuilder();

        boolean comingCharIsMapped = false;
        for (int i = 0; i < inputCharArr.length; i++) {
            char c = inputCharArr[i];

            if (c == '┤') {
                comingCharIsMapped = true;

            } else if (c != '╡') {
                if (comingCharIsMapped) {
                    outputWord.append(c);
                    comingCharIsMapped = false;

                } else { //next char is not
                    if (singleCharsMap.containsKey(c)) {
                        outputWord.append(singleCharsMap.get(c));
                    } else {
                        outputWord.append('-');
                    }

                    comingCharIsMapped = false;
                }
            }
        }
        return outputWord.toString();
    }

    // all the latin-alphabet text is processed;
    // the program now has a string of pure tengwar runes, upon which the rules for doubling and all the rest may be applied
}