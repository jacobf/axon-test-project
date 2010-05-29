package axon;

import java.util.List;

public class Fall {

  private List<Versicherung> versicherungen;
  private List<Person> personen;

  public List<Versicherung> getVersicherungen() {
    return versicherungen;
  }

  public void setVersicherungen(List<Versicherung> versicherungen) {
    this.versicherungen = versicherungen;
  }

  public List<Person> getPersonen() {
    return personen;
  }

  public void setPersonen(List<Person> personen) {
    this.personen = personen;
  }
}
