
public class Test {
    public static void main(String[] args)
    {
        ArrayBox<Osoba>  bo = new ArrayBox<>(2);
            System.out.println("Z metody add:");
            bo.add(new Osoba("Kowalski", 19));                        // nazwisko = "Kowalki", wiek = 19
            bo.add(new Student("Kowalska", 18, 100));                    // nazwisko, wiek, grupa = 100
            bo.add(new Student("Kowalska", 20, 200));
            bo.add(new Osoba("Kowalski", 19));
            bo.print();

        Osoba[] to = new Osoba[] {new Osoba("Nowak", 21), new Student("Nowak", 22, 200)};
            bo.addAll(to);
            System.out.println("Z metody addAll:");
            bo.print();
            bo.delate(new Osoba( "Kowalski",19));
            System.out.println("Z metody delete:");
            bo.print();
            System.out.println("Z metody MIN:");
            System.out.println(bo.min());// Student 1: Kowalska, 18, 100
            bo.swap(1,3);
            System.out.println("Z metody swap dla Obiektow:");
            bo.print();

        ArrayBox<Student> bst = new ArrayBox<>(1);
            bst.add(new Student("Nowacka", 24, 100));
            bst.add(new Student("Nowacka", 24, 300));
            bst.add(new Student("Nowacka", 24, 200));
            System.out.println("Z metody MAX:");
            System.out.println(bst.max());                                          // Student 5: Nowacka, 24, 300

        ArrayBox<Integer> bi = new ArrayBox<>(2);
            Integer[] ti = new Integer[] {1,1,1,1,1,1,2, 3};
            bi.addAll(ti);
            System.out.println("Z metody addAll dla Integerow:");
            bi.print();                                                                          // 1, 2, 3

        ArrayBox<String> bs = new ArrayBox<>(1);
            String[] ts = new String[] {"cpp", new String("java")};
            bs.addAll(ts);
            System.out.println("Z metody addAll dla Stringów:");
            bs.print();
            bs.swap(0,1);
            System.out.println("Z metody swap dla Stringow:");
            bs.print(); // java, cpp
            bs.delate("cpp");
            System.out.println("Z metody delete dla Stringow:");
            bs.print();

        ArrayBox<String> xc = new ArrayBox<>(1);
            String[] tc = new String[] {};
            xc.addAll(tc);
            System.out.println("Test metody Max dla pustej tablicy Stringow");
            System.out.println(xc.max());
    //        System.out.println(bi.search(2));


    }
}
