public class Osoba implements Comparable<Osoba>{

    private String nazwisko;
    private int wiek;

    public Osoba(String nazwisko, int wiek) {
        this.nazwisko = nazwisko;
        this.wiek = wiek;
    }

    @Override
    public int compareTo(Osoba o) {
        int result = this.nazwisko.compareTo(o.nazwisko);
        if(result == 0){
            return Integer.compare(this.wiek,o.wiek);
        }else
            return result;

        }

        public boolean equals(Osoba o){

            return o!=null&&this.nazwisko.equals(o.nazwisko) && this.wiek == o.wiek;

        }


    @Override
    public String toString() {
        return  "\n"+getClass().getName() + "\n" +
                "Nazwisko: "+ nazwisko +
                "\nWiek:"+ wiek + "\n";
    }
}

