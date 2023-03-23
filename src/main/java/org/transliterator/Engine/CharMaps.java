package org.transliterator.Engine;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class CharMaps {
    //TODO replace 'y'-tehta
    //mapping of latin chars to tengwar beleriand mode
    static Map<Character, String> initSingleCharsMap() {
        Map<Character, String> singleCharsMap = new LinkedHashMap<>();
        //this is not ideal, might read from a .csv later
        singleCharsMap.put('a', "]");
        singleCharsMap.put('b', "w"); //b
        singleCharsMap.put('c', "z"); //c
        singleCharsMap.put('d', "2"); //d
        singleCharsMap.put('e', "l");
        singleCharsMap.put('f', "e");
        singleCharsMap.put('g', "x");
        singleCharsMap.put('h', "9");
        singleCharsMap.put('i', "`");
        singleCharsMap.put('j', "s");
        singleCharsMap.put('k', "z");
        singleCharsMap.put('l', "j");
        singleCharsMap.put('m', "y");
        singleCharsMap.put('n', "6");
        singleCharsMap.put('o', "h");
        singleCharsMap.put('p', "q");
        singleCharsMap.put('q', "z");
        singleCharsMap.put('r', "7");
        singleCharsMap.put('s', "8");
        singleCharsMap.put('t', "1");
        singleCharsMap.put('u', ".");
        singleCharsMap.put('v', "r");
        singleCharsMap.put('w', "n");
        singleCharsMap.put('x', "A"); //placeholder
        singleCharsMap.put('y', "i");
        singleCharsMap.put('z', "k");
        singleCharsMap.put(' ', " "); // ?
        singleCharsMap.put('.', " =-="); //NB space in front of the punctuation, to enable the of/the/ofthe method to work accurately; TODO remove these spaces?
        singleCharsMap.put(',', " =");
        singleCharsMap.put('-', "\\");
        singleCharsMap.put('–', "Â");
        singleCharsMap.put('\'', "="); //' a.k.a. apostrophe, it used to be marked with an upper dot (keyboard B), which was unreadable
        singleCharsMap.put('!', " Á");
        singleCharsMap.put('?', " À");
        singleCharsMap.put(';', " Ã");
        singleCharsMap.put('1', "ñ");
        singleCharsMap.put('2', "ò");
        singleCharsMap.put('3', "ó");
        singleCharsMap.put('4', "ô");
        singleCharsMap.put('5', "õ");
        singleCharsMap.put('6', "ö");
        singleCharsMap.put('7', "ø");
        singleCharsMap.put('8', "ù");
        singleCharsMap.put('9', "û");
        singleCharsMap.put('0', "ú");
        singleCharsMap.put('(', "Œ");
        singleCharsMap.put(')', "œ");
        singleCharsMap.put('[', "Œ");
        singleCharsMap.put(']', "œ");
        singleCharsMap.put('{', "Œ");
        singleCharsMap.put('}', "œ");
        return singleCharsMap;
        //NB default punctuation mark for unsupported characters is ':'
        //there exist no runes for arithmetic operations and such
        //this whole thing has been designed by J.R.R.T. with text in mind
    }

    //mapping of latin digraphs to their tengwar equivalents
    static Map<String, String> initDigraphsMap() {
        Map<String, String> digraphCharsMap = new LinkedHashMap<>();
        digraphCharsMap.put("dh", "4");
        digraphCharsMap.put("ch", "a");
        digraphCharsMap.put("gh", "v");
        digraphCharsMap.put("kh", "Z");
        digraphCharsMap.put("lh", "m");
        digraphCharsMap.put("ph", "Q");
        digraphCharsMap.put("rh", "u");
        digraphCharsMap.put("sh", "d");
        digraphCharsMap.put("th", "3");
        digraphCharsMap.put("wh", "o");
        digraphCharsMap.put("zh", "f");
        digraphCharsMap.put("nn", "5");
        digraphCharsMap.put("mm", "t");
        digraphCharsMap.put("ng", "b");
        return digraphCharsMap;
    }

    //mapping of certain punctuation characters to their tengwar equivalents
    static Map<Character, String> initPunctuationCharsMap() {
        Map<Character, String> punctuationCharactersMap = new HashMap<>();
        punctuationCharactersMap.put('.', "=-=");
        punctuationCharactersMap.put(',', "=");
        punctuationCharactersMap.put('-', "\\");
        punctuationCharactersMap.put('–', "Â");
        punctuationCharactersMap.put('!', "Á");
        punctuationCharactersMap.put('?', "À");
        punctuationCharactersMap.put(';', "Ã");
        punctuationCharactersMap.put(':', "-");
        return punctuationCharactersMap;
    }

    //mapping of vowel tengwar to vowel tehtar, use these for narrow tengwar underneath
    static HashMap<Character, Character> initVowelTehtarForNarrowTengwarMap() {
        HashMap<Character, Character> mapVowelTehtarForWideTengwar = new HashMap<>();
        mapVowelTehtarForWideTengwar.put(']', 'E'); //a tengwa -> a tehta on top of a narrow tengwa
        mapVowelTehtarForWideTengwar.put('l', 'R'); //e
        mapVowelTehtarForWideTengwar.put('`', 'T'); //i
        mapVowelTehtarForWideTengwar.put('h', 'N'); //o
        mapVowelTehtarForWideTengwar.put('.', 'J'); //u
        mapVowelTehtarForWideTengwar.put('i', 'Õ'); //y, Alt+0213
        return mapVowelTehtarForWideTengwar;
    }

    static HashMap<Character, Character> initVowelTehtarForWideTengwarMap() {
        HashMap<Character, Character> mapVowelTehtarForWideTengwar = new HashMap<>();
        mapVowelTehtarForWideTengwar.put(']', '#'); //a tengwa -> a tehta on top of a wide tengwa
        mapVowelTehtarForWideTengwar.put('l', '$'); //e
        mapVowelTehtarForWideTengwar.put('`', '%'); //i
        mapVowelTehtarForWideTengwar.put('h', 'Y'); //o
        mapVowelTehtarForWideTengwar.put('.', '&'); //u
        mapVowelTehtarForWideTengwar.put('i', 'Ô'); //y, Alt+0212
        return mapVowelTehtarForWideTengwar;
    }

    //this particular mapping is only used in the big f*cky method, which is currently being decommissioned
    static HashMap<Character, Character> initTengwarTehtarMap() {
        HashMap<Character, Character> vowelsTengwarTehtarOnCarrMap = new HashMap<>(); //use this to convert vowel tengwar into vowel tehtar
        vowelsTengwarTehtarOnCarrMap.put(']', 'C'); //a tengwa, a tehta on carrier
        vowelsTengwarTehtarOnCarrMap.put('l', 'V'); //e
        vowelsTengwarTehtarOnCarrMap.put('`', 'B'); //i
        vowelsTengwarTehtarOnCarrMap.put('h', 'N'); //o
        vowelsTengwarTehtarOnCarrMap.put('.', 'M'); //u
        vowelsTengwarTehtarOnCarrMap.put('i', '×'); //y, a weird little char, Alt+0215
        return vowelsTengwarTehtarOnCarrMap;
    }
}