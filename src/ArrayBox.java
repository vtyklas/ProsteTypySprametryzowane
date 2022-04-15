import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ArrayBox<T extends Comparable> {

    Object[] arr;
    static int sizeCounter;

    public ArrayBox(int c) {
        sizeCounter = 0;
        arr = new Object[c];

    }

    public boolean add(T t) {

        boolean elementAdded = false; //flaga sprawdzajca czy element zostal dodany czy nie

        if (arr.length > sizeCounter) { // sprawdzenie czy dlugosc tablicy jest wystarczajaca do ewentualnego pomieszczenia nowego elementu

            for (int i = 0; i < arr.length; i++) {
                if (arr[i] != null) {
                    if (t.toString().equals(arr[i].toString())) {  // sprawdzenie czy dodawany element nie jest duplikatem jeżeli tak to metoda konczy dzialnie z wynikiem false
                        return elementAdded;
                    }
                } else if (arr[i] == null) { //jezeli dany indeks tablicy jest pusty to dodajemy element t i zwiekszamy licznik dlugosci tablicy i zmieniamy flage na dodany true
                    arr[i] = t;
                    elementAdded = true;
                    sizeCounter++;
                }
            }
        } else {  // jezeli tablica nie pomiesci nowego elementu to najpierw sprawdzamy czy dany elelemnt nie jest duplikatem w pierwotnej tablicy jezeli jest metoda konczy dzialnie zwracajac false
            for (Object o : arr) {

                if (o != null) {
                    if (t.toString().equals(o.toString())) {
                        return elementAdded;
                    }
                }
            }

            Object[] temp = new Object[arr.length + 1]; // jezeli dany elelemnt nie jest duplikatem towrzymy tablice o dlugosci arr.length +1

            System.arraycopy(arr, 0, temp, 0, arr.length); // kopiujemy zawartosc tablicy arr do temp i przypisujemy wratosci temp do arr
            arr = temp;


            for (int i = 0; i < arr.length; i++) { // dodajemy na puste miejsce elelemnt t zwiekszajac liczni kspradzajacy rozmiar tablicy
                if (arr[i] == null) {
                    arr[i] = t;
                    elementAdded = true;
                    sizeCounter++;
                }
            }
        }
        return elementAdded;
    }

    public boolean addAll(T[] array)
    {
        boolean added = false;
        boolean duplicateFlag; // flaga duplikatu
        int duplicate = 0; // licznik ilosci duplikatow ktory odejmiemy zeby okreslic finalny rozmiar nowej tablicy arr

        ArrayList<Object> noDuplicateList= new ArrayList<>(); // tworzymy pusta liste ktora nie bedzie zawierala duplikatow
        ArrayList<Object> tempList= new ArrayList<>(); // tworzymy liste tymczasowa ktora zawiera elementy dodawanej tablicy elementow
        for (Object o : arr) { // kopiowanie elemntow arr do listy bez duplikatow z pominieciem elementow null
            if (o != null) {
                noDuplicateList.add(o);
            }
        }

        Collections.addAll(tempList,array); //dodanie wszystkich elementow tablicy array do listy tymczasowej

            for (int i = 0; i < array.length; i++) { // sprawdzamy elementy dodawane(array) do elemntow znajdujacych sie w arr
                duplicateFlag = false;
                int index = i; // indeks sluzy do dodanie odpowideniego elemntu z array do listy bez duplikatow

                for (Object o : arr) { //sprawdzamy czy tablica nei zawiera pustych elementow po to ze nie mozemy porownywac metoda equals do nulla iteracja jest pomijana jezeli null
                    if (o == null)
                    {
                        continue;
                    } else // sprawdzamy czy element z array pokrywa sie z elementem arr, jezeli tak licznik duplikatu +1 oraz flaga ustawiona na true
                        if (array[i].toString().equals(o.toString()))
                        {
                        duplicate++;
                        duplicateFlag = true;

                        if (duplicate == array.length) // sprawdzenie jezeli wszystkie elemnty ktore probujmy dodac pokrywaja sie z elemntami juz zawartymi w tablicy automatycznie konczymy metoda z wynikiem false
                        {
                            return added;
                        }
                    }
                }
                    if(!duplicateFlag) //jezeli flaga w iteracji array jest ustawiona na false to dodajemy do listy bez duplikatow elemkent z listy tymczasowej o indexie zgodnym z iteracja petli for
                    {
                        noDuplicateList.add(tempList.get(index));

    //                    System.out.println(noDuplicateList);

                        added = true; //ustawiamy flage zwracajaca wynik metody na true
                    }
                arr = noDuplicateList.toArray(); // przekstzalcienie listy bez duplikatow na tablice arr
            }



        return added;
    }

    public T min() {
        T min = (T) arr[0]; // przyjumey ze min znajduje sie na indeksie 0 tablicy arr

        for (Object o : arr) {
            if (min.compareTo((T) o) > 0) //wskazanie elementu min
                min = (T) o;

        }

        return min;
    }

    public T max() {
        T max = (T) arr[0];

        for (Object o : arr) {
            if (max.compareTo((T) o) < 0)
                max = (T) o;

        }

        return max;
    }

    public void print(){
        for (Object o : arr) {
            System.out.print(o + " ");
        }
        System.out.println();
    }

    public boolean swap(int a,int b){
        try{
            T temp;
            temp = (T)arr[a];
            arr[a] = arr[b];
            arr[b] = temp;
            return true;
        }catch(ArrayIndexOutOfBoundsException | NullPointerException e){
            if(a>arr.length && b<arr.length || a<0)
            {
                System.out.println("Indeks a: "+a+ " nie jest indeksem tablicy");
                return false;
            }else if(b>arr.length && a<arr.length || b<0)
            {
                System.out.println("Indeks b: "+b+ " nie jest indeksem tablicy");
                return false;
            }else System.out.println("Podane indeksy tablicy nie istanieja");
            return false;
        }


    }

    public boolean delate(T t){

        boolean isDelated = false;
        T temp = null;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]!=null && t.compareTo(arr[i])==0){
                temp = (T)arr[i];
                arr[i] = null;
                isDelated = true;
                break;
            }
        }
        if(isDelated){
            System.out.println("Usunieto wskazany element<"+temp+">");
        }else System.out.println("Nie mozna usunac podany element nie istnieje w zestawie");
        return isDelated;
    }

    public int search(T t)
    {
        int index = 0;
        for (Object o : arr)
        {

            if(t.toString().equals(o.toString()))
            {
                System.out.println("Podany elelemnt znajduje sie w tablicy. Jest to element na indeksie= "+index+" i jest to: "+arr[index]);
                return index;
            }
            index++;
            }
        System.out.println("Podany element nie znajduje sie w tablicy");
        return -1;
            }







    @Override
    public String toString() {
        return "ArrayBox{" +
                "arr=" + Arrays.toString(arr) +
                '}';
    }


}
