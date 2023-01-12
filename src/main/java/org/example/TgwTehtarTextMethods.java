package org.example;

public class TgwTehtarTextMethods {
    public static String tehtarizeVowels(String inputText) {
        return inputText
                .replace("]","`C")//a
                .replace("l","`V")//e
                .replace("`","`B")//i
                .replace("h","`N")//o
                .replace(".","`M")//u
                .replace("i","`×")//y
                ;
    }

    public static String fixDiphtongs(String inputText) { //technically, any two vowels next to each other
        /*
        aa ea ia oa ua ya
        ae ee ie oe ue ye
        ao eo io oo uo yo
        au eu iu ou uu yu
         */
        return inputText
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
                ;
    }

    public static String putTehtarOnSucceedingTengwar() { //TODO
        //gonna need the big algo for this? [en]"nt" is [tg]"1p", that is, "tn" so i guess we can just look for the [en]"t" or [tg]"1" and skip the 'n'
        return "";
    }
}