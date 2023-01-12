package org.example;

import java.util.*;

import static org.example.Charsets.*;

public class TranslitEngine {
    //    Map<Character, String> singleCharsMap = initSingleCharsMap();
//    Map<Character, String> punctuationCharsMap = initPunctuationCharsMap();
//    Map<String, String> digraphsMap = initDigraphsMap();
//    Set<Character> engCharsVowelsSet = initEngCharsVowels();
//    Set<Character> engCharsFormingHDigraphSet = initEngCharsFormingHDigraph();
//    Set<Character> engCharsPostnasalSet = initEngCharsPostnasal();
//    Set<Character> tengwarPostnasalSet = initTengwarPostnasal();
//    Set<Character> tengwarNarrowSet = initNarrowTengwar();
//    Set<Character> tengwarWideSet = initWideTengwar();
//    Set<Character> tengwarFullModeVowelsSet = initVowelTengwar();
    public static final char SHORT_CARRIER = '`';
    public static final char LONG_CARRIER = '~';
    public static final char DOUBLE_CONSONANT_UNDER_NARROW_TENGWA = ';';
    public static final char DOUBLE_CONSONANT_UNDER_WIDE_TENGWA = ':';


    public static String transliterateTextModeOfBel(String input, Map<Character, Character> singleCharsMap,
                                                    Map<Character, String> punctuationCharsMap, Map<String, String> digraphsMap,
                                                    Set<Character> setEngCharsVowels, Set<Character> setEngCharsFormingHDigraph,
                                                    Set<Character> engCharsPostnasalSet) {

        StringBuilder transliteratedText = new StringBuilder();
        String[] inputSplitIntoWords = input.split("\\s+");
        boolean prevWordIsOf = false; //block to take care of the "of-the" tengwa
        for (String word : inputSplitIntoWords) {
            if (word.equals("of")) {
                if (prevWordIsOf) {
                    transliteratedText.append(" W");
                }
                prevWordIsOf = true; //note down the word but do not print yet
            } else if (word.equals("the")) {
                if (!prevWordIsOf) { //the previous word is NOT "of"
                    transliteratedText.append(" @"); //just append the "the"
                } else {  //now is the time to generate an "of-the" ligature
                    transliteratedText.append(" W:");
                    prevWordIsOf = false;
                }
            } else { //current word is neither "of" or "the", but a normal word
                if (prevWordIsOf) {
                    transliteratedText.append(" W"); //get rid of the stored "of"
                    prevWordIsOf = false;
                }
                transliteratedText.append(" " + transliterateWord(word,
                        singleCharsMap,
                        punctuationCharsMap,
                        digraphsMap,
                        setEngCharsFormingHDigraph,
                        setEngCharsVowels,
                        engCharsPostnasalSet));
            }
        }
        transliteratedText.deleteCharAt(0); //the first char is always a space, this removes it
        return transliteratedText.toString();
    }

    public static String transliterateWord(String word, Map<Character, Character> mapSingleChars,
                                           Map<Character, String> mapPunctuationChars, Map<String, String> mapDigraphs,
                                           Set<Character> setCharsFormingHDigraph, Set<Character> setCharsVowels,
                                           Set<Character> engCharsPostnasalSet) {

        StringBuilder resultTgw = new StringBuilder();

        char[] engWordIntoChars = word.toCharArray();
        for (int i = 0; i < engWordIntoChars.length; i++) {
            char engChar = engWordIntoChars[i];
            if (i == 0) { //when doing the first char of the word
                if (mapSingleChars.containsKey(engChar)) { //check is it a letter
                    resultTgw.append(mapSingleChars.get(engChar));
                } else if (mapPunctuationChars.containsKey(engChar)) { //check is it a punctiation sign
                    resultTgw.append(mapPunctuationChars.get(engChar));
                } else { //print non-supported sign
                    resultTgw.append(mapPunctuationChars.get(':'));
                }
            } else { //when doing the second+ char of the word
                char previousEngChar = engWordIntoChars[i - 1];

                if (setCharsVowels.contains(engChar)) { //case - is vowel
                    resultTgw.append(mapSingleChars.get(engChar));
                    //append the vowel tengwa from the mode of Beleriand
                    //this actually gets removed by the next method
                } else if (engChar == 'h') { //case - could be made into th/dh/sh/etc
                    if (setCharsFormingHDigraph.contains(previousEngChar)) {
                        String engNewDigraph = previousEngChar + "h";
                        resultTgw.deleteCharAt(resultTgw.length() - 1);
                        resultTgw.append(mapDigraphs.get(engNewDigraph));
                    } else {
                        resultTgw.append(mapSingleChars.get('h'));
                    }
                } else if (engCharsPostnasalSet.contains(engChar)) { //case - is consonant
                    if (previousEngChar == engChar) {  //double consonant, incl. 'nn' or 'mm'
                        switch (engChar) {
                            case 'n':
                                resultTgw.deleteCharAt(resultTgw.length() - 1);
                                resultTgw.append(mapDigraphs.get("nn"));
                                break;
                            case 'm':
                                resultTgw.deleteCharAt(resultTgw.length() - 1);
                                resultTgw.append(mapDigraphs.get("mm"));
                                break;
                            default: //double consonant, this is for the full mode
                                char tengwaOfDoubleLetter = mapSingleChars.get(engChar);
                                Set<Character> narrowTengwar = Charsets.initNarrowTengwarSet();
                                if (narrowTengwar.contains(tengwaOfDoubleLetter)) {
                                    resultTgw.append(DOUBLE_CONSONANT_UNDER_NARROW_TENGWA);
                                } else {
                                    resultTgw.append(DOUBLE_CONSONANT_UNDER_WIDE_TENGWA);
                                }
                                break;
                        }
                    } else { //not double consonant
                        resultTgw.append(mapSingleChars.get(engChar));
                    }
                } else {
                    if (mapSingleChars.containsKey(engChar)) {
                        resultTgw.append(mapSingleChars.get(engChar));
                    } else if (mapPunctuationChars.containsKey(engChar)) {
                        resultTgw.append(mapPunctuationChars.get(engChar));
                    } else {
                        resultTgw.append(mapPunctuationChars.get(':')); //default punctuation for anything that is not supported in the font
                    }
                }
            }
        }
        return resultTgw.toString();
    }

    public static String putTehtarOnLongCarriers(String input) {

        return input
                .replace("]]", "~C") //long carrier + tehta
                .replace("ll", "~V")
                .replace("``", "~B")
                .replace("hh", "~N")
                .replace("..", "~M")
                .replace("ii", "~×")
//
//                .replace("]l", "lE")//hardcoded ae
//                .replace("]h", "hE")//hardcoded ao
//                .replace("].", ".E")//hardcoded au
//
//                .replace("l]", "]R")//hardcoded ea
//                .replace("lh", "hR")//hardcoded eo
//                .replace("l.", ".R")//hardcoded eu
//
//                .replace("h]", "]N")//hardcoded oa
//                .replace("hl", "lN")//hardcoded oe
//                .replace("h.", ".N")//hardcoded ou
//
//                .replace(".]", "]J")//hardcoded ua
//                .replace(".l", "lJ")//hardcoded ue
//                .replace(".h", "hJ")//hardcoded uo
//
//                .replace("`]", "]T")//hardcoded ia
//                .replace("`l", "lT")//hardcoded ie
//                .replace("`h", "hT")//hardcoded io
//                .replace("`.", ".T")//hardcoded iu
//
//                .replace("i]", "]Õ")//hardcoded ya
//                .replace("il", "lÕ")//hardcoded ye
//                .replace("ih", "hÕ")//hardcoded yo
//                .replace("i.", ".Õ")//hardcoded yu

                .replace("6x8", "b_")//hardcoded ngs
                .replace("6x", "b")//hardcoded ng
                .replace("jj", "m");
    }

    public static String rewriteNasals(String textConsonantsDoubled, Set<Character> setTengwarNarrow,
                                       Set<Character> setTengwarWide, Set<Character> setCharsNasalisable) {
        StringBuilder result = new StringBuilder();
        char[] tengwarCharArray = textConsonantsDoubled.toCharArray();

        for (char t : tengwarCharArray) {
            if (result.length() > 1) {
                char lastAppendedChar = result.charAt(result.length() - 1);
                switch (lastAppendedChar) {
                    case '6':
                        //if current char goes with N-nasalisation:
                        Set<Character> charsNasalisableN = new HashSet<>(Arrays.asList('z', '2', 'x', 's', 'j', '1', 'a'));
                        if (charsNasalisableN.contains(t)) { //TODO confirm logic
                            result.deleteCharAt(result.length() - 1);
                            result.append(t);
                            if (setTengwarNarrow.contains(t)) {
                                result.append('p');
                            } else {
                                result.append('P');
                            }
                        } else {
                            result.append(t);
                        }
                        break;
                    case 'y':
                        //if current char goes with M-nasalisation:
                        Set<Character> charsNasalisableM = new HashSet<>(Arrays.asList('w', 'q'));
                        if (charsNasalisableM.contains(t)) {
                            // the t-char is either 'w' or 'q'
                            result.deleteCharAt(result.length() - 1);
                            result.append(t);
                            if (setTengwarNarrow.contains(t)) {
                                result.append('p');
                            } else {
                                result.append('P');
                            }
                        } else {
                            result.append(t);
                        }
                        break;
                    default:
                        result.append(t);
                        break;
                }
            } else {
                result.append(t);
            }
        }
        return result.toString();
    }

    public static String repositionDoubleConsonants(String textWithDirectReplacements, Set<Character> setTengwarNarrow,
                                                    Set<Character> setTengwarWide) {
        StringBuilder result = new StringBuilder();
        char[] tengwarCharArray = textWithDirectReplacements.toCharArray();

        for (char t : tengwarCharArray) {
            if (result.length() > 0) {
                char lastAppendedChar = result.charAt(result.length() - 1);
                if (t == lastAppendedChar) {
                    //double N or double M
                    if (t == '6') { //case NN
                        int resultLastCharIndex = result.length() - 1;
                        result.deleteCharAt(resultLastCharIndex);
                        result.append('5');
                    } else if (t == 'y') { //case MM
                        int resultLastCharIndex = result.length() - 1;
                        result.deleteCharAt(resultLastCharIndex);
                        result.append('t');
                    } else if (setTengwarNarrow.contains(lastAppendedChar)) {
                        //append narrow underline
                        result.append(';');
                    } else if (setTengwarWide.contains(lastAppendedChar)) {
                        //append wide underline
                        result.append(':');
                    } else {
                        result.append(t);
                    }
                } else {
                    result.append(t);
                }
            } else {
                result.append(t);
            }
        }
        return result.toString();
    }

    public static String tehtarizeVowels(String tengwarText) {
        //NB this method assumes that any two consecutive vowels are already turned into a diphtong
        HashMap<Character, Character> mapVowelsTengwarTehtarOnCarr = Charsets.initTengwarTehtarMap(); //use this to convert vowel tengwar into vowel tehtar
        Set<Character> setVowelCarryingNarrowTengwar = Charsets.initVowelCarryingNarrowTengwarSet(); //this includes diphtongs
        Set<Character> setVowelCarryingWideTengwar = Charsets.initVowelCarryingWideTengwarSet();
        HashMap<Character, Character> mapVowelTehtarForNarrowTengwar = Charsets.initVowelTehtarForNarrowTengwarMap();
        HashMap<Character, Character> mapVowelTehtarForWideTengwar = Charsets.initVowelTehtarForWideTengwarMap();

        StringBuilder result = new StringBuilder();
        char[] tengwarCharArray = tengwarText.toCharArray();
        ArrayDeque<Character> stackVowelTengwar = new ArrayDeque<>();

        for (char t : tengwarCharArray) {
            if (mapVowelsTengwarTehtarOnCarr.containsKey(t)) { //case vowel tengwa - only push vowels if they are single tengwa
                stackVowelTengwar.push(t);
            } else if (t == '`' || t == 'i') { //case with i or y
                if (!stackVowelTengwar.isEmpty()) {
                    char lastStoredVowelTengwa = stackVowelTengwar.pop();
                    //short carrier + tehta
                    result.append(SHORT_CARRIER);
                    result.append(mapVowelsTengwarTehtarOnCarr.get(lastStoredVowelTengwa));
                }
                result.append(SHORT_CARRIER);
                result.append(mapVowelsTengwarTehtarOnCarr.get(t));
            } else if (t == LONG_CARRIER) { //case with long vowel (long carrier + tehta)
                if (!stackVowelTengwar.isEmpty()) {
                    char lastStoredVowelTengwa = stackVowelTengwar.pop();
                    //short carrier + tehta
                    result.append(SHORT_CARRIER);
                    result.append(mapVowelsTengwarTehtarOnCarr.get(lastStoredVowelTengwa));
                }
                result.append(t);
            } else if (mapVowelsTengwarTehtarOnCarr.containsValue(t)) { //case with vowel tehta, those are only found above long carriers
                result.append(t);
            } else if (t == 'p' || t == 'P' || t == ':' || t == ';') { //case with nasal or doubler tehta
                result.append(t);
            } else if (setVowelCarryingNarrowTengwar.contains(t) || setVowelCarryingWideTengwar.contains(t)) { //case with any tengwa, upon which a vowel tehta is placed; this method also does diphtongs
                if (!stackVowelTengwar.isEmpty()) { //check if prev char was a vowel tengwa and write it as a tehta
                    char previousVowelTengwa = stackVowelTengwar.pop();
                    if (setVowelCarryingNarrowTengwar.contains(t)) { //narrow tengwa -> appropriate vowel tehta
                        result.append(t);
                        char tehtaForNarrowTengwa = mapVowelTehtarForNarrowTengwar.get(previousVowelTengwa);
                        result.append(tehtaForNarrowTengwa);
                    } else { //wide tengwa  -> appropriate vowel tehta
                        result.append(t);
                        char tehtaForWideTengwa = mapVowelTehtarForWideTengwar.get(previousVowelTengwa);
                        result.append(tehtaForWideTengwa);
                    }
                } else { //the prev char was non-vowel
                    result.append(t);
                }
            } else {
                result.append(" ");
//                result.append();

            }
        }
        //final clearing of remaining tehtar
        if (!stackVowelTengwar.isEmpty()) {
            char lastStoredVowelTengwa = stackVowelTengwar.pop();
            //short carrier + tehta
            result.append(SHORT_CARRIER);
            result.append(mapVowelsTengwarTehtarOnCarr.get(lastStoredVowelTengwa));
        }
        return result.toString();
    }


    public static String fixVowels(String tengwarText) {
        Set<Character> vowelTengwarSet = initVowelTengwarSet();

        StringBuilder result = new StringBuilder();
        char[] tengwarCharArray = tengwarText.toCharArray();
        ArrayDeque<Character> stackTengVowels = new ArrayDeque<>();

        for (char t : tengwarCharArray) {
            if (vowelTengwarSet.contains(t)) {

            }
        }

        return result.toString();
    }


}