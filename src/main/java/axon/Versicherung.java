package axon;

import java.util.HashSet;
import java.util.Set;

public class Versicherung {

  private Person versicherter;
  private Set<Person> beguenstigte = new HashSet<Person>(2);

  public Person getVersicherter() {
    return versicherter;
  }

  public void setVersicherter(Person versicherter) {
    this.versicherter = versicherter;
  }

  public Set<Person> getBeguenstigte() {
    return beguenstigte;
  }

  public void setBeguenstigte(Set<Person> beguenstigte) {
    this.beguenstigte = beguenstigte;
  }
}
