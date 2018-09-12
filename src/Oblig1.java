
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

    //Oppgave 2

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

    //Oppgave 3
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

    /*public static int antallUlikeUsortert(int[] ids) {
        int uniques = 0;
        top:
        for (int i = 0; i < ids.length; i++) {
            final int id = ids[i];
            for (int j = i + 1; j < ids.length; j++) {
                if (id == ids[j]) continue top;
            }
            uniques++;
        }
        return uniques;
    }*/

    //Oppgave 4
    //public static void delsortering(int[] a){}


}
