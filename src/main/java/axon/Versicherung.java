package axon;

import java.util.HashSet;
import java.util.Set;

public class Versicherung {

  private Person versicherter;
  private Set<Person> beguenstigte = new HashSet<Person>(2);

  public Versicherung(Person versicherter) {
    this.versicherter = versicherter;
    addBeguenstigten(versicherter);
  }

  public Person getVersicherter() {
    return versicherter;
  }

  public void setVersicherter(Person versicherter) {
    this.versicherter = versicherter;
  }

  public Set<Person> getBeguenstigte() {
    return beguenstigte;
  }

  public void addBeguenstigten(Person beguenstigter) {
    if (beguenstigte.size() < 2) {
      beguenstigte.add(beguenstigter);
    }
    else {
      throw new IllegalStateException("Es sind bereits zwei Beguenstigte angegeben");
    }
  }

  public void removeBeguenstigten(Person beguenstigter) {
    beguenstigte.remove(beguenstigter);
  }
}
