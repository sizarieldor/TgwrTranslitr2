package org.example;

import org.example.Engine.Charsets;
import org.example.Engine.EngTextMethods;
import org.example.gui.MainFrame;

import java.util.*;

//1. how to avoid losing digraphs - wrap in symbols
//cincinnatti -- cinci[nn]a[tt]i
//others = o[th]ers
//2. remap the rest into runes
//3. adjust nasals, double consonants, tehtar,
public class Main {
    public static void main(String[] args) {
        MainFrame frame = new MainFrame();
        Scanner sc = new Scanner(System.in);
//        String input = sc.nextLine();

        //        ConsoleTest();

        //        String output = desiTest(input);
//        String output = replaceFinalNGs(input);

//        System.out.println(output);
//        System.out.println("");
    }

    private static String replaceFinalNGs(String inputText) {
        String result = inputText.replaceAll("ng\\b", "YY")
                .replaceAll("ngs\\b", "YYS");
        return result;
    }

    private static void ConsoleTest() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String input = sc.nextLine();
            String output = EngTextMethods.translWordDigraphsSimple(input);
            output = EngTextMethods.translWordCharsSimple(output);
            System.out.println(output);
        }
    }


    public static String putVowelAfterwards(String inputText) {
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'y', 'o', 'u', 'e', 'i'));

        char[] inputChars = inputText.toCharArray();
        StringBuilder result = new StringBuilder();
        ArrayDeque<Character> storedVowelQueue = new ArrayDeque<>();

        for (int i = 0; i < inputChars.length; i++) {
            char c = inputChars[i];
            if (vowels.contains(c)) {
                //store C for later
                storedVowelQueue.push(c);
            } else if (!storedVowelQueue.isEmpty()) {
                char thisV = storedVowelQueue.pop();
                result.append(c);
                result.append(thisV);
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }


    //n~Vr`Bj `VA1V76`Cj -> n~VrjB AV17V6jC
    //`C5.Nzp`V
    //n'V'B72 ->    = 'weird', only 'B should be swapped
    public static String putTehtarOnSucceedingTengwar(String inputText) {
        //initVowelTehtaOnCarrierSet, initVowelTehtaOnWideTengwaSet, initVowelTehtaOnNarrowTengwaSet
        Set<Character> vowelTehtarOnCarrierSet = Charsets.initVowelTehtaOnCarrierSet();
        Set<Character> vowelTehtarOnWideTengwarSet = Charsets.initVowelTehtaOnWideTengwaSet();
        Set<Character> vowelTehtarOnNarrowTengwarSet = Charsets.initVowelTehtaOnNarrowTengwaSet();

        char[] inputChars = inputText.toCharArray();
        ArrayDeque<Character> storedVowelQueue = new ArrayDeque<>();
        StringBuilder result = new StringBuilder();


        for (int i = 1; i < inputChars.length; i++) {
            char cFirst = inputChars[i - 1];
            char cSecnd = inputChars[i];

            if (cFirst == '`' && vowelTehtarOnCarrierSet.contains(cSecnd)) {
                storedVowelQueue.push(cSecnd);
            } else if (!storedVowelQueue.isEmpty()) {
                char currTehta = storedVowelQueue.pop();
                result.append(cSecnd);
                result.append(currTehta);
            } else {
                result.append(cFirst);
                result.append(cSecnd);
            }

        }
        return result.toString();
    }

    public static String builderTest(String input) {
        StringBuilder builder = new StringBuilder(input);

        builder.deleteCharAt(1);

        return builder.toString();
    }

    public static String desiTest(String input) {
        //TODO words ending in a vowel, the carrier needs to be preserved
        Set<Character> vowelTehtarOnCarrierSet = Charsets.initVowelTehtaOnCarrierSet();
        StringBuilder result = new StringBuilder();
        String[] inputAsStrings = input.split("`");
        for (String inputSplitElement : inputAsStrings) {
            if (!inputSplitElement.equals("")) { //necessary check, sometimes .split() creates an empty string, which then causes an error
                char firstChar = inputSplitElement.charAt(0);

                //check for valid first char
                boolean stringStartsWithVowelTehta = false;
                if (vowelTehtarOnCarrierSet.contains(firstChar)) {
                    stringStartsWithVowelTehta = true;
                }

                if (stringStartsWithVowelTehta && inputSplitElement.length() > 1) { //if valid 1st char AND if the snippet is 2 or more chars long
                    char[] splitElementArr = inputSplitElement.toCharArray();
                    char temp = splitElementArr[0];
                    splitElementArr[0] = splitElementArr[1];
                    splitElementArr[1] = temp;
                    result.append(splitElementArr); //need to use .toString()?
                } else {
                    result.append(inputSplitElement);
                }
            }
        }
        return result.toString();
    }

}