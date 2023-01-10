package org.example;

import java.util.*;

public class Charsets {
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
        singleCharsMap.put('.', "=-=");
        singleCharsMap.put(',', "=");
        singleCharsMap.put('-', "\\");
        singleCharsMap.put('–', "Â");
        singleCharsMap.put('\'', "B");
        singleCharsMap.put('!', "Á");
        singleCharsMap.put('?', "À");
        singleCharsMap.put(';', "Ã");
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


    //set of those latin chars that couple with 'h' to form digraphs - 'C'->'CH','D'->'DH','S'->'SH', etc.
    static Set<Character> initFormingHDigraphEngCharsSet() {
        Set<Character> engLettersCouplingWithH = new HashSet<>();
        engLettersCouplingWithH.add('c');
        engLettersCouplingWithH.add('d');
        engLettersCouplingWithH.add('g');
        engLettersCouplingWithH.add('k');
        engLettersCouplingWithH.add('l');
        engLettersCouplingWithH.add('p');
        engLettersCouplingWithH.add('r');
        engLettersCouplingWithH.add('s');
        engLettersCouplingWithH.add('t');
        engLettersCouplingWithH.add('w');
        engLettersCouplingWithH.add('z');
        return engLettersCouplingWithH;
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

    //set of latin chars that represent vowels - 'A', 'O', etc
    static Set<Character> initVowelEngCharsSet() {
        Set<Character> charsThatAreVowels = new HashSet<>();
        charsThatAreVowels.add('a');
        charsThatAreVowels.add('o');
        charsThatAreVowels.add('u');
        charsThatAreVowels.add('e');
        charsThatAreVowels.add('i');
        return charsThatAreVowels;
    }

    //set of latin chars that form nasals after 'N' or 'M' when in tengwar
    static Set<Character> initPostnasalEngCharsSet() {
        Set<Character> chars = new HashSet<>();
        chars.add('b'); //b
        chars.add('c'); //c/k/q
        chars.add('k'); //c/k/q
        chars.add('q'); //c/k/q
        chars.add('d'); //d
        chars.add('g'); //g
        chars.add('j'); //j
        chars.add('l'); //l
        chars.add('p'); //p
        chars.add('t'); //t
//        chars.add(''); //ch
        return chars;
    }

    //set of tengwar chars that form nasals after 'N' or 'M'
    static Set<Character> initPostnasalTengwarSet() {
        Set<Character> tengwarNasalisable = new HashSet<>();
        tengwarNasalisable.add('w'); //b
        tengwarNasalisable.add('z'); //c/k/q
        tengwarNasalisable.add('2'); //d
        tengwarNasalisable.add('x'); //g
        tengwarNasalisable.add('s'); //j
        tengwarNasalisable.add('j'); //l
        tengwarNasalisable.add('q'); //p
        tengwarNasalisable.add('1'); //t
        tengwarNasalisable.add('a'); //ch
        return tengwarNasalisable;
    }

    //set of tengwar chars that are narrow (usu. have a single Lúva) and therefore require narrow tehtar
    static Set<Character> initNarrowTengwarSet() {
        Set<Character> narrowTengwar = new HashSet<>(); //in the Annatar font, these consonant characters appear narrow
        narrowTengwar.add('z');
        narrowTengwar.add('e');
        narrowTengwar.add('9');
        narrowTengwar.add('y');
        narrowTengwar.add('6');
        narrowTengwar.add('q');
        narrowTengwar.add('7');
        narrowTengwar.add('1');
        narrowTengwar.add('3');
        narrowTengwar.add('a');
        narrowTengwar.add('d');
        narrowTengwar.add('Q');
        narrowTengwar.add('o');
        narrowTengwar.add('u');
        narrowTengwar.add('8');
        return narrowTengwar;
    }

    //set of tengwar chars that are wide (usu. have double Lúvar) and therefore require broad tehtar
    static Set<Character> initWideTengwarSet() { //
        Set<Character> wideTengwar = new HashSet<>(); //in the Annatar font, these consonant characters appear wide
        wideTengwar.add('w');
        wideTengwar.add('2');
        wideTengwar.add('x');
        wideTengwar.add('s');
        wideTengwar.add('j');
        wideTengwar.add('r');
        wideTengwar.add('4');
        wideTengwar.add('f');
        wideTengwar.add('v');
        wideTengwar.add('5');
        wideTengwar.add('t');
        wideTengwar.add('m');
        wideTengwar.add('b');
        return wideTengwar;
    }

    //set of tengwar chars that represent vowels in the Mode of Beleriand
    static Set<Character> initVowelTengwarSet() {
        Set<Character> vowelTengwar = new HashSet<>(); //in the Annatar font, these keys on the alphabet map to the Tengwar vowels in full mode
        vowelTengwar.add(']'); //a
        vowelTengwar.add('l'); //e
        vowelTengwar.add('`'); //i
        vowelTengwar.add('h'); //o
        vowelTengwar.add('.'); //u
        vowelTengwar.add('i'); //y
        return vowelTengwar;
    }

    //set of tengwar consonant chars that are narrow: require left-offset vowel tehtar
    static Set<Character> initVowelCarryingNarrowTengwarSet() {
        Set<Character> narrowTengwar = new HashSet<>(); //in the Annatar font, these characters appear narrow
        narrowTengwar.add('1');
        narrowTengwar.add('q');
        narrowTengwar.add('a');
        narrowTengwar.add('z');
        narrowTengwar.add('3');
        narrowTengwar.add('e');
        narrowTengwar.add('d');
        narrowTengwar.add('c');
        narrowTengwar.add('6');
        narrowTengwar.add('y');
        narrowTengwar.add('h');
        narrowTengwar.add('n');
        narrowTengwar.add('7');
        narrowTengwar.add('u');
        narrowTengwar.add('i'); // s
        narrowTengwar.add(','); //ss z
        narrowTengwar.add('Q');
        narrowTengwar.add('9');
        narrowTengwar.add('o');
        narrowTengwar.add('8');
        narrowTengwar.add('A'); //placeholder for Latin 'x'
        return narrowTengwar;
    }

    //set of tengwar consonant that are wide: require right-offset vowel tehtar
    static Set<Character> initVowelCarryingWideTengwarSet() { //
        Set<Character> wideTengwar = new HashSet<>(); //in the Annatar font, these characters appear wide
        wideTengwar.add('2');
        wideTengwar.add('w');
        wideTengwar.add('s');
        wideTengwar.add('x');
        wideTengwar.add('4');
        wideTengwar.add('r');
        wideTengwar.add('f');
        wideTengwar.add('v');
        wideTengwar.add('5');
        wideTengwar.add('t');
        wideTengwar.add('g');
        wideTengwar.add('b');
        wideTengwar.add('j');
        wideTengwar.add('m');
        return wideTengwar;
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
    //mapping of vowel tengwar to vowel tehtar, use these for wide tengwar underneath

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