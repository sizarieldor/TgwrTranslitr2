package org.example.Engine;

import java.util.*;

public class Charsets {


    //set of those latin chars that couple with 'h' to form digraphs - 'C'->'CH','D'->'DH','S'->'SH', etc.
    public static Set<Character> initFormingHDigraphEngCharsSet() {
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

    //set of latin chars that represent vowels - 'A', 'O', etc
    public static Set<Character> initVowelEngCharsSet() {
        Set<Character> charsThatAreVowels = new HashSet<>();
        charsThatAreVowels.add('a');
        charsThatAreVowels.add('o');
        charsThatAreVowels.add('u');
        charsThatAreVowels.add('e');
        charsThatAreVowels.add('i');
        return charsThatAreVowels;
    }

    //set of latin chars that form nasals after 'N' or 'M' when in tengwar
    public static Set<Character> initPostnasalEngCharsSet() {
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
    public static Set<Character> initPostnasalTengwarSet() {
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
    public static Set<Character> initNarrowTengwarSet() {
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
    public static Set<Character> initWideTengwarSet() { //
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
    public static Set<Character> initVowelTengwarSet() {
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
    public static Set<Character> initVowelCarryingNarrowTengwarSet() {
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
    public static Set<Character> initVowelCarryingWideTengwarSet() { //
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

    public static Set<Character> initVowelTehtaOnNarrowTengwaSet() {
        Set<Character> tehtarForNarrowTengwar = new HashSet<>();
        tehtarForNarrowTengwar.add('E'); //a
        tehtarForNarrowTengwar.add('R'); //e
        tehtarForNarrowTengwar.add('N'); //o
        tehtarForNarrowTengwar.add('J'); //u
        tehtarForNarrowTengwar.add('T'); //i
        tehtarForNarrowTengwar.add('Õ'); //y
        return tehtarForNarrowTengwar;
    }

    public static Set<Character> initVowelTehtaOnWideTengwaSet() {
        Set<Character> tehtarForWideTengwar = new HashSet<>();
        tehtarForWideTengwar.add('#'); //a
        tehtarForWideTengwar.add('$'); //e
        tehtarForWideTengwar.add('Y'); //o
        tehtarForWideTengwar.add('&'); //u
        tehtarForWideTengwar.add('%'); //i
        tehtarForWideTengwar.add('Ô'); //y
        return tehtarForWideTengwar;
    }

    public static Set<Character> initVowelTehtaOnCarrierSet() {
        Set<Character> tehtarForCarrier = new HashSet<>();
        tehtarForCarrier.add('C'); //a
        tehtarForCarrier.add('V'); //e
        tehtarForCarrier.add('N'); //o
        tehtarForCarrier.add('M'); //u
        tehtarForCarrier.add('B'); //i
        tehtarForCarrier.add('×'); //y
        return tehtarForCarrier;
    }

}