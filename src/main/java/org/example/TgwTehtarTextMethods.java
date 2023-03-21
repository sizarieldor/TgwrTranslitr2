package org.example;

import org.apache.commons.lang3.StringUtils;

import javax.xml.stream.events.StartDocument;

public class TgwTehtarTextMethods {
    public static String tehtarizeVowels(String inputText) { //TODO these replacements must be done simultaneously, not one after the other
        String[] rawChars = new String[]{"]", "l", "`", "h", ".", "i"};
        String[] fixedChars = new String[]{"`C", "`V", "`B", "`N", "`M", "`×"};
        //        return inputText
//                .replace("]","`C")//a
//                .replace("l","`V")//e
//                .replace("`","`B")//i
//                .replace("h","`N")//o
//                .replace(".","`M")//u
//                .replace("i","`×")//y
//                ;
        return StringUtils.replaceEach(inputText, rawChars, fixedChars);
    }

    public static String fixDiphtongs(String inputText) { //technically, any two vowels next to each other
        /*
        aa ea ia oa ua ya
        ae ee ie oe ue ye
        ao eo io oo uo yo
        au eu iu ou uu yu
         */
        String[] rawChars = new String[]{
                "`C`C",                "`V`C",
                "`B`C",                "`N`C",
                "`M`C",                "`×`C",
                "`C`V",                "`V`V",
                "`B`V",                "`N`V",
                "`M`V",                "`×`V",
                "`C`N",                "`V`N",
                "`B`N",                "`N`N",
                "`M`N",                "`×`N",
                "`C`M",                "`B`M",
                "`V`M",                "`N`M",
                "`M`M",                "`×`M",
                "`B`B",                "`×`×"
        };

        String[] fixedChars = new String[]{"~C",
                "]R",                "]T",
                "]N",                "]J",
                "]Õ",                "lE",
                "~V",                "lT",
                "lN",                "lJ",
                "lÕ",                "hE",
                "hR",                "hT",
                "~N",                "hJ",
                "hÕ",                ".E",
                ".T",                ".R",
                ".N",                "~M",
                ".Õ",                "~B",
                "~×"};
       /* return inputText
                .replace("`C`C", "~C")//long carrier + tehta; aa
                .replace("`V`C", "]R")//hardcoded ea
                .replace("`B`C", "]T")//hardcoded ia
                .replace("`N`C", "]N")//hardcoded oa
                .replace("`M`C", "]J")//hardcoded ua
                .replace("`×`C", "]Õ")//hardcoded ya

                .replace("`C`V", "lE")//hardcoded ae
                .replace("`V`V", "~V")//ee
                .replace("`B`V", "lT")//hardcoded ie
                .replace("`N`V", "lN")//hardcoded oe
                .replace("`M`V", "lJ")//hardcoded ue
                .replace("`×`V", "lÕ")//hardcoded ye

                .replace("`C`N", "hE")//hardcoded ao
                .replace("`V`N", "hR")//hardcoded eo
                .replace("`B`N", "hT")//hardcoded io
                .replace("`N`N", "~N")//oo
                .replace("`M`N", "hJ")//hardcoded uo
                .replace("`×`N", "hÕ")//hardcoded yo

                .replace("`C`M", ".E")//hardcoded au
                .replace("`B`M", ".T")//hardcoded iu
                .replace("`V`M", ".R")//hardcoded eu
                .replace("`N`M", ".N")//hardcoded ou
                .replace("`M`M", "~M")//uu
                .replace("`×`M", ".Õ")//hardcoded yu

                .replace("`B`B", "~B")//ii
                .replace("`×`×", "~×")//yy
                ;*/
        return StringUtils.replaceEach(inputText, rawChars, fixedChars);

    }

    /*public static String putTehtarOnSucceedingTengwar(String inputText) { //TODO
        //gonna need the big algo for this? [en]"nt" is [tg]"1p", that is, "tn" so i guess we can just look for the [en]"t" or [tg]"1" and skip the 'n'
        char[] inputChars = inputText.toCharArray();
        char cFirst = inputChars[0];
        char cScnd = inputChars[1];

        for (int i = 2; i < inputChars.length; i++) {
            char cFirst = inputChars[i - 2];
            char cScnd = inputChars[i - 1];
            char cThrd = inputChars[i];


        }
        return "";
    }*/

    public static String adjustCorrectTehtaForPrecedingTengwa(){

        return "";
    }
}