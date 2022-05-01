public class Student extends  Osoba{

    int numerGrupy;

    public Student(String nazwisko, int wiek, int numerGrupy) {
        super(nazwisko, wiek);
        this.numerGrupy = numerGrupy;
    }

    @Override
    public int compareTo(Osoba o)
    {
        super.compareTo(o);
        if(o instanceof Student){
            int result = Integer.compare(this.numerGrupy,((Student) o).numerGrupy);
            return result;
        }

        return 0;

    }

    public boolean equals(Osoba o)
    {
        if(o instanceof Student)
        {
            o = (Student) o;
            super.equals(o);
            return this.numerGrupy == ((Student) o).numerGrupy;
        }
        else return false;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Numer grupy: " + numerGrupy
                +"\n";
    }
}
