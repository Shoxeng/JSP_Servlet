package pk.wieik.ti.ti.model;

public class KRuzytkownik {
    private String login = "";

    private String haslo = "";
    private int uprawnienia = -1;
    // -1 użytkownik niezalogowany
    // 1 użytkownik zalogowany
    // 2 administrator

    private String imie = "";
    private String nazwisko = "";
    private int wiek = -1;

    public KRuzytkownik(){
        this.login = "";
        this. haslo = "";
        this.uprawnienia = -1;
    }

    public KRuzytkownik(String login, String haslo, int uprawnienia){
        this.login = login;
        this.haslo = haslo;
        this.uprawnienia = uprawnienia;
    }
    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = _filtruj(imie);
    }

    public String getHaslo() {
        return haslo;
    }

    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }
    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = _filtruj(nazwisko);
    }

    public int getWiek() {
        return wiek;
    }

    public String getWiekS() {
        if (wiek>=0)
            return ""+wiek;
        else return "";
    }

    public void setWiek(int wiek) {
        if (wiek >= 0)
            this.wiek = wiek;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getUprawnienia() {
        return uprawnienia;
    }

    public void setUprawnienia(int uprawnienia) {
        this.uprawnienia = uprawnienia;
    }

    public String _filtruj(String wejscie) {

        StringBuffer filtrowane = new StringBuffer();
        char c;

        for (int i=0; i<wejscie.length(); i++)
        {
            c = wejscie.charAt(i);
            switch(c)
            {
                case '<': filtrowane.append("&lt;"); break;
                case '>': filtrowane.append("&gt;"); break;
                case '"': filtrowane.append("&quot;"); break;
                case '&': filtrowane.append("&amp;"); break;
                default: filtrowane.append(c);
            }
        }
        return filtrowane.toString();
    }

    @Override
    public String toString() {
        return "DGuzytkownik{" +
                "login='" + login + '\'' +
                ", uprawnienia=" + uprawnienia +
                '}';
    }
}

