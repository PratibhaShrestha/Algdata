import com.sun.tools.corba.se.idl.StringGen;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.NoSuchElementException;

public class Oblig1 {

    public static int ombyttinger(int[] a) {

        int ombyttinger = 0;

        if (a.length < 1)
            throw new java.util.NoSuchElementException("Tabellen er tom");
        int temp;
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] > a[i + 1]) {
                //swap
                temp = a[i];
                a[i] = a[i + 1];
                a[i + 1] = temp;

                ombyttinger++;
            }
        }
        return ombyttinger;
    }

    //oppgave 1
    public static int maks(int[] a) {

        if (a.length < 1)
            throw new java.util.NoSuchElementException("Tabellen er tom");
        int temp;
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] > a[i + 1]) {
                //swap
                temp = a[i];
                a[i] = a[i + 1];
                a[i + 1] = temp;
            }
        }
        // returning the last element, which is the greatest!
        return a[a.length - 1];
    }

    //oppgave 2
    public static int antallUlikeSortert(int[] a) {

        if (a.length == 1) return 1;
        else if (a.length > 1) {
            int antallUlikeVerdier = 1;
            for (int i = 0; i < a.length - 1; i++) {
                if (a[i] > a[i + 1]) {
                    throw new IllegalStateException("Tabellen må være sortert stigende");
                }

                if (a[i] != a[i + 1]) {
                    antallUlikeVerdier++;
                }

            }
            return antallUlikeVerdier;
        } else return 0;


    }

    //oppgave 3
    public static int antallUlikeUsortert(int[] a) {

        int antallULikeVerdier = 0;
        boolean isEqual;

        if (a.length < 1) return 0;
        else if (a.length == 1) return 1;
        else {
            for (int i = 0; i < a.length; i++) {
                isEqual = false;
                for (int j = i + 1; j < a.length; j++) {
                    if (a[i] == a[j]) {
                        isEqual = true;
                        break;
                    }
                } // end of j for....
                if (!isEqual) antallULikeVerdier++;
            } // end of i for
        }

        return antallULikeVerdier;
    }

    public static void main(String[] args) {

        int[] arr = {1, 4, 3, 45, 789, 54, 331, 65, 98};
        System.out.println(Arrays.toString(arr));
        delsortering(arr);
        System.out.println(Arrays.toString(arr));
    }

    //oppgave 4
    public static void delsortering(int[] a) {

        if (a.length < 1) return;
        int oddIndex = 0, temp;

        for (int i = 0; i < a.length; i++) {
            if (a[i] % 2 != 0) {
                temp = a[i];
                a[i] = a[oddIndex];
                a[oddIndex] = temp;

                oddIndex++;
            }
        }
        Arrays.sort(a, 0, oddIndex);
        Arrays.sort(a, oddIndex, a.length);
    }

    //oppgave 5
    public static void rotasjon(char[] a) {
        if (a.length < 1) return;
        char temp;

        temp = a[a.length - 1];
        for (int j = a.length - 1; j >= 0; j--) {
            if (j == 0) {
                a[j] = temp;
            } else {
                a[j] = a[(j - 1 + a.length) % a.length];
            }
        }
    }

    //oppgave 6
    public static void rotasjon(char[] a, int k) {
        if (a.length < 1 || k == 0) return;

        char temp;

        if (k >= 1) {
            if (k != 1 && (k >= a.length) && a.length % k == 0) return;
            if (k > a.length) {
                k = (k % a.length);
            }

            for (int i = 0; i < k; i++) {
                temp = a[a.length - 1];
                for (int j = a.length - 1; j >= 0; j--) {
                    if (j == 0) {
                        a[j] = temp;
                    } else {
                        a[j] = a[(j - 1 + a.length) % a.length];
                    }
                }
            }
        } else {
            if (k != -1 && a.length % Math.abs(k) == 0) return;
            k = Math.abs(k);
            if (k > a.length) {
                k = (k % a.length);
            }

            for (int i = 0; i < a.length - k; i++) {
                for (int j = i + k; j > i; j--) {
                    temp = a[j];
                    a[j] = a[j - 1];
                    a[j - 1] = temp;
                }
            }
        }

    }

    //oppgave 7.a
    public static String flett(String s, String t) {
        String outputString = "";
        int minimunLoop = (s.length() < t.length()) ? s.length() : t.length();

        for (int i = 0; i < minimunLoop; i++) {
            outputString += (String.valueOf(s.charAt(i)) + String.valueOf(t.charAt(i)));
        }

        if (s.length() > t.length())
            outputString += s.substring(minimunLoop, s.length());
        else if (t.length() > s.length())
            outputString += t.substring(minimunLoop, t.length());

        return outputString;
    }

    //oppgave 7.b
    public static String flett(String... s) {
        String outputString = "";
        int maxAntalIString = 0;
        for (int i = 0; i < s.length; i++) {
            if (s[i].length() > maxAntalIString)
                maxAntalIString = s[i].length();
        }

        for (int i = 0; i < maxAntalIString; i++) {
            for (int j = 0; j < s.length; j++) {
                if (s[j].length() > i)
                    outputString += s[j].charAt(i);
            }
        }

        return outputString;
    }

    //oppgave 8
    public static int[] indekssortering(int[] a) {
        if (a.length < 1) return new int[]{};
        int[] indexTable = new int[a.length];

        int[] copyArray = a.clone();
        Arrays.sort(copyArray);
        for (int i = 0; i < copyArray.length; i++) {
            indexTable[i] = getIndexOf(a, copyArray[i]);
        }
        return indexTable;
    }

    // tilegg metode til oppdave 8
    public static int getIndexOf(int[] a, int n) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == n) return i;
        }
        return 0;
    }

    // oppgave 9
    public static int[] tredjeMin(int[] a) {
        int length = a.length;
        if (length < 3) throw
                new NoSuchElementException("tabelen må ha minste 3 verdier");

        int[] lavIndex = new int[3];
        int[] lavVerdi = new int[3];

        for (int n = 0; n <= 2; n++) {
            lavVerdi[n] = Integer.MAX_VALUE;
            for (int i = 0; i < length; i++) {
                if (a[i] < lavVerdi[n]) {

                    boolean isIndexPresent = false;
                    for (int n1 = 0; n1 < n; n1++) {
                        if (i == lavIndex[n1]) {
                            isIndexPresent = true;
                        }
                    }
                    if (!isIndexPresent) {
                        lavVerdi[n] = a[i];
                        lavIndex[n] = i;
                    }
                }
            }
        }
        return lavIndex;
    }

    //oppdave 10
    public static boolean inneholdt(String a, String b) {
        if (a.length() < 1) return true;

        int[] bruktIndex = new int[a.length()];
        boolean isMatch, isIndexUsedBefore;

        if (a.length() > b.length())
            return false;
        else {
            int i;
            for (i = 0; i < a.length(); i++) {
                isMatch = false;
                for (int j = 0; j < b.length(); j++) {
                    if (a.charAt(i) == b.charAt(j)) {
                        isIndexUsedBefore = false;
                        for (int br = 0; br < i; br++) {
                            if (j == bruktIndex[br]) {
                                isIndexUsedBefore = true;
                                break;
                            }
                        }
                        if (!isIndexUsedBefore) {
                            isMatch = true;
                            bruktIndex[i] = j;
                            break;
                        }
                    }
                }
                if (!isMatch) return false;
            }
            return true;
        }
    }

}
