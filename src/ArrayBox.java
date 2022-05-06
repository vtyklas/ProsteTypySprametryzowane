
import java.util.ArrayList;
import java.util.Arrays;


public class ArrayBox<T extends Comparable> {


    private Object[] arr;
    private static int currentSize; //Zmienna currentSize pokazuje aktualną ilość elementów tablicy arr.
    private static int ID;

    public ArrayBox(int c) {
        currentSize = 1;
        arr = new Object[c];
        int num = ID++;
    }


    public boolean add(T t)
    { //jeżeli currentSize jest wystarczający sprawdzamy czy dany elelemnt się nie powtarza jezeli tak to go dodajemy false wpp.

        try {
            for (int i = 0; i < currentSize; i++)
            {
                if (arr[i] != null) {
                    if (search(t) != -1)
                    {
                        return false;
                    }
                } else if (arr[i] == null)
                    {
                        arr[i] = t;
                        currentSize++;
                        return true;
                    }
            }
        } catch (ArrayIndexOutOfBoundsException e) { // jeżeli curretSize jest wiekszy tworzymy nowa tablice o 1 wieksza kopiujemy elelemnty starej i na pole null dodajemy elelemnt
            Object[] temp = new Object[arr.length + 1];

            System.arraycopy(arr, 0, temp, 0, arr.length);
            arr = temp;

            for (int i = 0; i < arr.length; i++)
            {
                if (arr[i] == null)
                {
                    arr[i] = t;
                    currentSize++;
                }
            }
            return true;
        }
        return false;
    }


    public boolean addAll(T[] array) //Wykorztujemy metodę add w pętli
    {
        boolean isAdded = false;

        for (T t : array) {
            if (search(t) == -1) {
                add(t);
                isAdded = true;
            }
        }
        return isAdded;

    }

    public T min() {
/*While sprawdza pierwszy indeks który nie jest nullem i przypisuje go do wartości min.
*Jeżeli tablica jest samymi nulami lub jest pusta zwraca w bloku catch stosowną informację.
*/
        try {

            int index = 0;
            while (arr[index] == null)
            {
                index++;
            }
            T min = (T) arr[index];

            for (Object o : arr) {
                if (o != null && min.compareTo(o) >=1)
                {
                    min = (T) o;
                }

            }
            System.out.print("MIN z "+ getClass().getName() +" " + ID);
            return min;
        }catch (NullPointerException e){
            System.out.println("Błąd - tablica zawiera same wartości null!");
        }
        return null;
    }

    public T max() {
        try {

            int index = 0;
            while (arr[index] == null)
            {
                index++;
            }
            T max = (T) arr[index];

            for (Object o : arr)
            {
                if (o != null && max.compareTo(o) < 0)
                {
                    max = (T) o;
                }
            }
            System.out.print("MAX z "+ ArrayBox.class.getName() + " " + ID);

            return max;
        }catch (NullPointerException |ArrayIndexOutOfBoundsException e)
        {
            System.out.print("Błąd - tablica " + getClass().getName() + " " + ID +  " jest ");
            return (T) String.valueOf("pusta!");
        }

    }

    public static int getID() {
        return ID;
    }

    public void print(){
        System.out.println(getClass().getName() + " " + getID());
        System.out.println("--------------");
        for (Object o : arr)
        {
            System.out.print(o+" ");
        }
        System.out.println();
        System.out.println("--------------");

    }

    public boolean swap(int a,int b){
        try{
            T temp;
            temp = (T )arr[a];
            arr[a] = arr[b];
            arr[b] = temp;
            return true;
        }catch(ArrayIndexOutOfBoundsException | NullPointerException e){
            if((a>=arr.length || a<0) && (b<arr.length && b>=0))
            {
                System.out.println("Indeks "+a+ " nie jest indeksem tablicy " + ArrayBox.class + " " + ID);
                return false;
            }else if((b>=arr.length || b<0) && (a<arr.length && a>=0))
            {
                System.out.println("Indeks "+b+ " nie jest indeksem tablicy " + ArrayBox.class + " " + ID);
                return false;
            }else System.out.println("Podane indeksy tablicy nie istanieja");
            return false;
        }

    }

    public boolean delate(T t)
    { // sprawdza czy podany elelemnt znajduje sie w tablicy i jeżeli tak to zamienia podany elelemnt na null
        int indexOfSameElement = -1;
            try
            {
                while(indexOfSameElement == -1) {
                    indexOfSameElement = search(t);
                    arr[indexOfSameElement] = null;
                }
                if(indexOfSameElement !=-1) {
                    ArrayList<T> tempList = new ArrayList<>();
                    for(Object o : arr){
                        if(o !=null)
                        tempList.add((T) o);
                    }
                    arr = tempList.toArray();
                }
            }catch(ArrayIndexOutOfBoundsException e)
            {
                System.out.println("Tablica jest pusta lub podana wartość metody nie istnieje");
                return false;
            }
            return false;
    }

    public int search(T t) { // sprawdza czy podany element jest równy zadanemu i zwraca wartość indeksu na którym się znajduje lub -1 wpp. Na tej zasadzie wykorzystujemy ją do metody add.
        int index = 0;
        for (Object o : arr)
        {
            if (o != null)
            {
                if (t.toString().equals(o.toString())) {return index;}
            }
            index++;
        }

        return -1;
    }

    @Override
    public String toString() {
        return Arrays.toString(arr);
    }
}
