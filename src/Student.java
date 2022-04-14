public class Student extends  Osoba{

    int numerGrupy;

    public Student(String nazwisko, int wiek, int numerGrupy) {
        super(nazwisko, wiek);
        this.numerGrupy = numerGrupy;
    }

    @Override
    public int compareTo(Osoba o)
    {
            if(o instanceof Student)
            {
                o = (Student) o;
                super.compareTo(o);

                if(this.numerGrupy > ((Student) o).numerGrupy)
                {
                    return 1;
                }else
                    if(this.numerGrupy<((Student) o).numerGrupy)
                    {
                        return -1;
                    }
                }

        return 0;

    }

    public boolean equals(Osoba o){
        if(o instanceof Student)
            o = (Student) o;
            super.equals(o);
            return this.numerGrupy == ((Student) o).numerGrupy;


    }

    @Override
    public String toString() {
        return super.toString() +
                ", numerGrupy=" + numerGrupy +
                '}';
    }
}
