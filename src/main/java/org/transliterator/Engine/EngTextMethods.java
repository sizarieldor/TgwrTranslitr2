package org.transliterator.Engine;

import java.util.Map;

public class EngTextMethods {
    //Here are the initial methods that work on the text while it is in its Latin-alphabet form

    public static String stripDiacritics(String inputText) {
        //this method replaces latin letters with diacritics with their "regular" equivalents
        //this method also removes the obscure chars '┤' and '╡' that are used by the program later on
        //honestly, I haven't taken the time to test this for every possible letter
        //TODO test for possible letters
        return inputText.replaceAll("┤", "-")
                .replaceAll("╡", "-")
                .replaceAll("A̍", "a")
                .replaceAll("Ä", "a")
                .replaceAll("Ą́", "a")
                .replaceAll("Ȧ", "a")
                .replaceAll("Ą̃", "a")
                .replaceAll("Á", "a")
                .replaceAll("Ă", "a")
                .replaceAll("Â", "a")
                .replaceAll("Ā", "a")
                .replaceAll("Ą", "a")
                .replaceAll("À", "a")
                .replaceAll("Ả", "a")
                .replaceAll("Ã", "a")
                .replaceAll("Å", "a")
                .replaceAll("Ɓ", "b")
                .replaceAll("Ḇ", "b")
                .replaceAll("Ƀ", "b")
                .replaceAll("B́", "b")
                .replaceAll("B̀", "b")
                .replaceAll("Ć", "c")
                .replaceAll("C̈", "c")
                .replaceAll("Ċ", "c")
                .replaceAll("Č", "c")
                .replaceAll("Ƈ", "c")
                .replaceAll("Ç", "c")
                .replaceAll("Ĉ", "c")
                .replaceAll("Ď", "d")
                .replaceAll("Ḑ", "d")
                .replaceAll("Ḍ", "d")
                .replaceAll("Ɗ", "d")
                .replaceAll("Ḏ", "d")
                .replaceAll("Ě", "e")
                .replaceAll("Ê", "e")
                .replaceAll("Ę", "e")
                .replaceAll("Ẽ", "e")
                .replaceAll("Ë", "e")
                .replaceAll("É", "e")
                .replaceAll("È", "e")
                .replaceAll("Ė", "e")
                .replaceAll("Ƒ", "f")
                .replaceAll("Ǧ", "g")
                .replaceAll("Ġ", "g")
                .replaceAll("G̃", "g")
                .replaceAll("Ğ", "g")
                .replaceAll("Ĝ", "g")
                .replaceAll("Ɠ", "g")
                .replaceAll("Ǵ", "g")
                .replaceAll("Gʻ", "g")
                .replaceAll("Ḫ", "h")
                .replaceAll("Ȟ", "h")
                .replaceAll("Ĥ", "h")
                .replaceAll("Ḥ", "h")
                .replaceAll("Ȋ", "i")
                .replaceAll("Ɨ", "i")
                .replaceAll("Í", "i")
                .replaceAll("Î", "i")
                .replaceAll("Ï", "i")
                .replaceAll("İ", "i")
                .replaceAll("Ì", "i")
                .replaceAll("Į", "i")
                .replaceAll("J̌", "j")
                .replaceAll("Ĵ", "j")
                .replaceAll("Ḱ", "k")
                .replaceAll("Ƙ", "k")
                .replaceAll("Ǩ", "k")
                .replaceAll("Ķ", "k")
                .replaceAll("Ľ", "l")
                .replaceAll("Ł̣", "l")
                .replaceAll("Ł", "l")
                .replaceAll("Ḷ", "l")
                .replaceAll("M̃", "m")
                .replaceAll("Ɱ", "m")
                .replaceAll("Ḿ", "m")
                .replaceAll("Ṅ", "n")
                .replaceAll("Ṉ", "n")
                .replaceAll("Ň", "n")
                .replaceAll("Ñ", "n")
                .replaceAll("Ń", "n")
                .replaceAll("Ǹ", "n")
                .replaceAll("Ɲ", "n")
                .replaceAll("Ơ", "o")
                .replaceAll("O͘", "o")
                .replaceAll("Ꝍ", "o")
                .replaceAll("Ö", "o")
                .replaceAll("Ó", "o")
                .replaceAll("Ò", "o")
                .replaceAll("Õ", "o")
                .replaceAll("Ǫ", "o")
                .replaceAll("Oʻ", "o")
                .replaceAll("P̃", "p")
                .replaceAll("Ƥ", "p")
                .replaceAll("Ṕ", "p")
                .replaceAll("R̃", "r")
                .replaceAll("Ř", "r")
                .replaceAll("Ṛ", "r")
                .replaceAll("Ȓ", "r")
                .replaceAll("Ŕ", "r")
                .replaceAll("Ş", "s")
                .replaceAll("S̩", "s")
                .replaceAll("Š", "s")
                .replaceAll("S̈", "s")
                .replaceAll("Ṡ", "s")
                .replaceAll("Ṣ", "s")
                .replaceAll("Ś", "s")
                .replaceAll("Ŝ", "s")
                .replaceAll("Ș", "s")
                .replaceAll("S̀", "s")
                .replaceAll("Ț", "t")
                .replaceAll("Ť", "t")
                .replaceAll("Ṭ", "t")
                .replaceAll("Ƭ", "t")
                .replaceAll("Ʈ", "t")
                .replaceAll("Ţ", "t")
                .replaceAll("ᵵ", "t")
                .replaceAll("Ꞟ", "u")
                .replaceAll("Ŭ", "u")
                .replaceAll("Ư", "u")
                .replaceAll("Ú", "u")
                .replaceAll("Û", "u")
                .replaceAll("Ü", "u")
                .replaceAll("Ų", "u")
                .replaceAll("Ẃ", "w")
                .replaceAll("Ẋ", "x")
                .replaceAll("X̣", "x")
                .replaceAll("Ý", "y")
                .replaceAll("Ÿ", "y")
                .replaceAll("Ƴ", "y")
                .replaceAll("Ȳ", "y")
                .replaceAll("Ż", "z")
                .replaceAll("Ȥ", "z")
                .replaceAll("Ź", "z")
                .replaceAll("Ž", "z")
                .replaceAll("Ẓ", "z")
                .replaceAll("Ẑ", "z")
                .replaceAll("Z̀", "z")
                .replaceAll("Ǯ", "z")
                ;
    }

    //use this to transliterate the following digraphs into their corresponding tengwa runes
    public static String translWordDigraphsSimple(String inputWord) {
        //this method uses two obscure chars, '┤' and '╡' to mark digraphs
        //'nn' and 'mm' are covered in another method
        String outputWord = inputWord
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
                .replaceAll("zh", "┤f╡");
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

                } else { //next char is not mapped
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