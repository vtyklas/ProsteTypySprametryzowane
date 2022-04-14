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

        boolean elementAdded = false;

        if (arr.length > sizeCounter) {

            for (int i = 0; i < arr.length; i++) {
                if (arr[i] != null) {
                    if (t.toString().equals(arr[i].toString())) {
                        return elementAdded;
                    }
                } else if (arr[i] == null && !elementAdded) {
                    arr[i] = t;
                    elementAdded = true;
                    sizeCounter++;
                }
            }
        } else {
            for (Object o : arr) {

                if (o != null) {
                    if (t.toString().equals(o.toString())) {
                        return elementAdded;
                    }
                }
            }

            Object[] temp = new Object[sizeCounter + 1];

            System.arraycopy(arr, 0, temp, 0, arr.length);
            arr = temp;


            for (int i = 0; i < arr.length; i++) {
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
        boolean duplicateFlag = false;
        int duplicate = 0;

        ArrayList<Object> noDuplicateList= new ArrayList<>(); // tworzymy pusta liste ktora nie bedzie zawierala duplikatow
        ArrayList<Object> tempList= new ArrayList<>(); // tworzymy liste tymczasowa ktora zawiera elementy dodawanej tablicy elementow
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] != null)
            {
                noDuplicateList.add(arr[i]);
            }
        }
//        Collections.addAll(noDuplicateList, arr); // dodanie wszystkich elemntow tablicy arr do listy bez duplikatow
////        System.out.println(noDuplicateList);
        Collections.addAll(tempList,array); //dodanie wszystkich elementow tablicy array do listy tymczasowej
//        System.out.println(tempList);


            for (int i = 0; i < array.length; i++) {
                duplicateFlag = false;
                int index = i;
                for (int j = 0; j < arr.length; j++)
                {
                    if(arr[j]==null){
                        continue;
                    }else

                        if (array[i].toString().equals(arr[j].toString()))
                        {
                            duplicate++;
                            duplicateFlag = true;
                            if(duplicate==array.length)
                            {
                                return added;
                            }
                        }
                    }
                    if(!duplicateFlag)
                    {
                        noDuplicateList.add(tempList.get(index));

    //                    System.out.println(noDuplicateList);

                        added = true;
                    }
                arr = noDuplicateList.toArray();
            }



        return added;
    }

    public T min() {
        T min = (T) arr[0];

        for (int i = 0; i < arr.length; i++)
        {
            if (min.compareTo((T) arr[i]) > 0)
                min = (T)arr[i];

        }

        return min;
    }

    public T max() {
        T max = (T) arr[0];

        for (int i = 0; i < arr.length; i++)
        {
            if (max.compareTo((T) arr[i]) < 0)
                max = (T)arr[i];

        }

        return max;
    }

    public void print(){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public boolean swap(int a,int b){
        if(arr[a] != arr[b]){
            T temp;
            temp = (T)arr[a];
            arr[a] = arr[b];
            arr[b] = temp;
            return true;
        }else return false;
    }

    public boolean delate(T t){

        boolean isDelated = false;
        T temp = null;
        for (int i = 0; i < arr.length && !isDelated; i++) {
            if(t.compareTo(arr[i])==0){
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



    @Override
    public String toString() {
        return "ArrayBox{" +
                "arr=" + Arrays.toString(arr) +
                '}';
    }


}
