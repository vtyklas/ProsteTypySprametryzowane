import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ArrayBox<T extends Comparable> {

    Object[] arr;
    static int sizeCounter;
    boolean uniqness;

    public ArrayBox(int c) {
        sizeCounter = 0;
        arr = new Object[c];
        uniqness = true;

    }

    public boolean add(T t) {
        boolean added = false;
        boolean flag = false;
        List<T> tempList = new ArrayList<>();
        if (arr.length <= sizeCounter) {

            for (int i = 0; i < arr.length; i++) {
                if (!t.toString().equals(arr[i].toString())) {
                    tempList.add((T) arr[i]);

                } else flag = true;

            }
            if (arr.length < tempList.size()) {
                added = true;
            }


        }else {
            for (int i = 0; i < arr.length; i++) {
                if(arr[i] != null &&!t.toString().equals(arr[i].toString()) ){
                    flag = true;
                }else if(!flag) {
                    arr[i] = t;
                    added = true;
                }
            }



        }

        return added;
    }
//
//        if(arr.length<=sizeCounter){
//            Object []temp = new Object[sizeCounter+1];
//
//            for (int i = 0; i < arr.length; i++)
//            {
//                temp[i] = arr[i];
//            }
//            arr = temp;
//        }
//
//        // pętlą for dodajemy elelemnt na nowe puste miejsce, sprawdzajac czy nie jest taki sam jak poprzednie elementy
//        for (int j = 0; j < arr.length; j++) {
//            if (arr[j]!=null && !added) {
//                if(t.toString().equals(arr[j].toString()))
//                flag = true;
//            } else
//                if(arr[j] == null && !flag && !added){
//                arr[j] = t;
//                added = true;
//                sizeCounter++;
//
//            }
//
//        }
//        return added;


    public boolean addAll(T[] array)
    {
        boolean added = false;
        boolean flag = false;
        boolean tempadd = false;

//        System.out.println(array.length);
//        System.out.println(sizeCounter);
        if(arr.length <= array.length+sizeCounter){
            sizeCounter+= array.length;
//            System.out.println(sizeCounter);
            Object[] temp = new Object[sizeCounter];
            for (int i = 0; i < arr.length; i++) {
                temp[i] = arr[i];
            }
            arr = temp;

        }

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (array[i] == arr[j]) {
                    flag = true;
                } else
                    if(arr[j] == null && !flag && !tempadd){
                        arr[j] = array[i];
                        tempadd = true;
                        added = true;
                }

            }
            flag = false;
            tempadd = false;
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
