import java.util.*;

public class Test {
    public static void main(String[] args)
    {
        ArrayBox<Osoba>  bo = new ArrayBox<>(2);
        ArrayBox.class.getName();
        bo.add(new Osoba("Kowalski", 19));                        // nazwisko = "Kowalki", wiek = 19
        bo.add(new Student("Kowalska", 18, 100));                    // nazwisko, wiek, grupa = 100
        bo.add(new Student("Kowalska", 20, 200));

        Osoba[] to = new Osoba[] {new Osoba("Nowak", 21), new Student("Nowak", 22, 200)};
        bo.addAll(to);

        bo.print();

//        bo.delate(new Osoba( "Kowalski",19));
//        bo.delate((new Student("Kowalska", 18, 100)));

        System.out.println(bo.min());                                           // Student 1: Kowalska, 18, 100

        ArrayBox<Student> bst = new ArrayBox<>(1);
        bst.add(new Student("Nowacka", 24, 100));
        bst.add(new Student("Nowacka", 24, 300));
        bst.add(new Student("Nowacka", 24, 200));
        bst.print();
        System.out.println(bst.max());                                          // Student 5: Nowacka, 24, 300

        ArrayBox<Integer> bi = new ArrayBox<>(2);
        Integer[] ti = new Integer[] {Integer.valueOf(1), 1,1,1,1,1,2, 3};
        bi.addAll(ti);

        bi.print();                                                                          // 1, 2, 3

        ArrayBox<String> bs = new ArrayBox<>(1);
        String[] ts = new String[] {"cpp", new String("java")};
        bs.addAll(ts);
        bs.print();
        bs.swap(0,1);
        bs.print();                                                                         // java, cpp
        bs.delate("cpp");
        bs.print();
        bo.swap(0,4);
        bo.print();
        ArrayBox<String> xc = new ArrayBox<>(1);
        String[] tc = new String[] {};
        xc.addAll(tc);
        System.out.println(xc.max());
        System.out.println(bi.search(2));


    }
}
