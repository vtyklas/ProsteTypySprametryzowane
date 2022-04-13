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
                    if(this.wiek>o.wiek) {
                        return 1;
                    }else
                        if(this.wiek<o.wiek) {
                        return -1;
                        }else return 0;


        }

        public boolean equals(Osoba o){
                if(o == null && getClass() != o.getClass() ){
                    System.out.println("Jestem na nullu"
                    );
                    return false;
                }

                if(this.nazwisko.equals(o.nazwisko) && this.wiek == o.wiek){
                    System.out.println("nazwisko wiek ok");
                    return true;
                }

            return false;
        }


    @Override
    public String toString() {
        return "Osoba{" +
                "nazwisko='" + nazwisko + '\'' +
                ", wiek=" + wiek +
                '}';
    }
}

