

public class Test {
    public static void main(String[] args)
    {
    ArrayBox<Osoba> bo = new ArrayBox<>(2);
    bo.add(new Osoba("Kowalski",19));
    bo.add(new Student("Kowalska",18,100));
    bo.add(new Student("Kowalska",20,200));
    bo.add(new Student("Kowalska",20,200));
    bo.print();

    Osoba[] to = new Osoba[] {new Osoba("Nowak", 21),new Osoba("Nowak", 21),new Osoba("Nowak", 21), new Student("Nowak",22,200),new Osoba("Nowak", 25),};
    bo.addAll(to);
    bo.print();

        System.out.println(bo.min());

        ArrayBox<Student> bst = new ArrayBox<>(1);
        bst.add(new Student("Nowacka", 24, 100));
        bst.add(new Student("Nowacka", 24, 300));
        bst.add(new Student("Nowacka", 24, 200));
        bst.add(new Student("Nowacka", 24, 200));
        bst.print();
        System.out.println(bst.max());

        ArrayBox<Integer> bi = new ArrayBox<>(2);
        Integer[] ti = new Integer[] {Integer.valueOf(1), 2, 3,3,3,3,3,3,3,3,3,4};

        bi.addAll(ti);

        bi.print();

        ArrayBox<String> bs = new ArrayBox<>(1);
        String[] ts = new String[] {"cpp", new String("java")};
        bs.addAll(ts);
        bs.print();
        bs.swap(1,12);
        bs.print();

        bs.delate("cpp");
        bs.print();
        bs.delate("java");
        bs.print();

    }
}
