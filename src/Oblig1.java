import java.util.Arrays;
import java.util.NoSuchElementException;

public class Oblig1 {

    public static void main(String[] args) {
        System.out.println("Hei AlgDat 2018");

        int[] arr = new int[]{1, 22, 11, 80, 10, 2};
        int[] arrCopy = new int[]{1, 22, 11, 80, 10, 2};
        int[] arr2 = new int[]{3, 3, 4, 5, 5, 6, 7, 7, 7, 8};
        int[] arr3 = new int[]{5, 3, 7, 4, 3, 5, 7, 8, 6, 7};

        System.out.println("Før ");
        printArray(arr);

        int maks = maks(arr);

        int antallOmbytter = ombyttinger(arrCopy);
        System.out.println("Oppgave 1");
        System.out.println("Maks verdi fra tabellen : " + maks);
        System.out.println("Antall Ombytting : " + antallOmbytter);
        System.out.println("Etter ");
        printArray(arr);
        System.out.println("Oppgave 2");
        printArray(arr2);
        System.out.println("Antall ulike verdier :" + antallUlikeSortert(arr2));
        System.out.println("Oppgave 3");
        printArray(arr3);
        System.out.println("Antall ulike verdier :" + antallUlikeUsortert(arr3));

        /*
        // FOR OPPGAVE 5
        int[] a = {6, 10, 9, 4, 1, 3, 8, 5, 2, 7};
        delsortering(a);
        System.out.println(Arrays.toString(a));*/


        /*
        // FOR OPPGAVE 6
        char[] chars = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};
        System.out.println(Arrays.toString(chars));
        rotasjon(chars, -103);
        System.out.println(Arrays.toString(chars));*/

        /*// FOR OPPGAVE 7.a
        String a = flett("ABC", "DEFGH");
        String b = flett("IJKLMN", "OPQ");
        String c = flett("", "AB");
        System.out.println(a + " " + b + " " + c);*/

       /* // FOR OPPDAVE 7.b
        String a = flett("AM ", "L", "GEDS", "ORATKRR", "", "R TRTE", "IO", "TGAUU");
        System.out.println(a);*/

        /*// FOR OPPDAVE 8
        int[] a = {6, 10, 16, 11, 7, 12, 3, 9, 8, 5};
        int[] indeks = indekssortering(a);
        System.out.println(Arrays.toString(a)); // skriver ut a
        System.out.println(Arrays.toString(indeks)); // skriver ut indeks*/

        /*// FOR OPPDAVE 9
        int[] a = {16, 6, 10, 16, 11, 7, 12, 3, 9, 8, 5};
        int[] tredjeMin = tredjeMin(a);
        System.out.println(Arrays.toString(tredjeMin));*/

        /*// FOR OPPGAVE 10
        String str1 = "ABBA";
        String str2 = "RABARBRA";
        String str3 = "BARBERER";
        System.out.println("Må være sant: " + inneholdt(str1, str2));
        System.out.println("Må ikke være sant : " + inneholdt(str1, str3));*/


    }

    private static int ombyttinger(int[] a) {

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
    private static int maks(int[] a) {

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

    private static void printArray(int[] a) {
        System.out.print("[");
        if (a.length > 0) {
            System.out.print(a[0]);
        }
        for (int i = 1; i < a.length; i++) {
            System.out.print(" , " + a[i]);
        }
        System.out.println("]");
        System.out.println();
    }

    //oppgave 2
    public static int antallUlikeSortert(int[] a) {

        if (a.length > 1) {
            int antallUlikeVerdier = 1;
            for (int i = 0; i < a.length - 1; i++) {
                if (a[i] > a[i + 1]) {
                    throw new IllegalStateException("Tabellen må være sortert stigende");

                } else if (a[i] != a[i + 1]) {
                    antallUlikeVerdier++;
                }

            }
            return antallUlikeVerdier;
        } else return 0;


    }

    //oppgave 3
    private static int antallUlikeUsortert(int[] a) {

        int antallULikeVerdier = 0;
        boolean isEqual = false;

        if (a.length > 1) {

            for (int i = 0; i < a.length - 1; i++) {
                isEqual = false;
                for (int j = i + 1; j < a.length - 1; j++) {
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

    //oppgave 4
    public static void delsortering(int[] a) {

        if (a.length < 1) return;

        Arrays.sort(a);

        int oddIndex = 0, temp;

        for (int i = 0; i < a.length; i++) {
            if (a[i] % 2 != 0) {
                temp = a[i];
                a[i] = a[oddIndex];
                a[oddIndex] = temp;

                oddIndex++;
            }
        }

        for (int i = oddIndex; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] > a[j]) {
                    temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
    }

    //oppgave 5
    public static void rotasjon(char[] a) {
        if (a.length < 1) return;
        char temp;

        for (int i = a.length - 1; i > 1; i--) {
            temp = a[i];
            a[i] = a[i - 1];
            a[i - 1] = temp;
        }

        temp = a[0];
        a[0] = a[1];
        a[1] = temp;
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
        for (int i = 0; i < s.length; i++) {
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

        int[] lav = new int[3];
        for (int n = 0; n < 3; n++) {
            lav[n] = 0;
            for (int i = n; i < length; i++) {
                if (a[i] < a[lav[n]]) {

                    boolean isIndexUsedBefore = false;
                    for (int j = 0; j < n; j++) {
                        if (a[i] == a[lav[j]]) {
                            isIndexUsedBefore = true;
                        }
                    }
                    if (!isIndexUsedBefore) {
                        lav[n] = i;
                    }
                }
            }
        }
        return lav;
    }

    //oppdave 10
    public static boolean inneholdt(String a, String b) {
        if (a.length() < 1) return true;

        int[] bruktIndex = new int[a.length()];

        if (a.length() > b.length())
            return false;
        else {
            int i;
            for (i = 0; i < a.length(); i++) {
                boolean isMatch = false;
                for (int j = 0; j < b.length(); j++) {
                    if (a.charAt(i) == b.charAt(j)) {

                        boolean isIndexUsedBefore = false;
                        for (int br = 0; br < i; br++) {
                            if (j == bruktIndex[br]) {
                                isIndexUsedBefore = true;
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
            return i == a.length();
        }
    }

}
