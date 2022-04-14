public class Osoba implements Comparable<Osoba>{

    String nazwisko;
    int wiek;

    public Osoba(String nazwisko, int wiek) {
        this.nazwisko = nazwisko;
        this.wiek = wiek;
    }

    @Override
    public int compareTo(Osoba o) {
        if(this.nazwisko.compareTo(o.nazwisko)>0) {
            return 1;
        }else
                if(this.nazwisko.compareTo(o.nazwisko)<0) {

                    return -1;
                }else
                    if(this.nazwisko.compareTo(o.nazwisko)==0){
                            return 0;
                        }
                else
                        return Integer.compare(this.wiek, o.wiek);


        }

        public boolean equals(Osoba o){

            return o!=null&&this.nazwisko.equals(o.nazwisko) && this.wiek == o.wiek;

        }


    @Override
    public String toString() {
        return "Osoba{" +
                "nazwisko='" + nazwisko + '\'' +
                ", wiek=" + wiek +
                '}';
    }
}

