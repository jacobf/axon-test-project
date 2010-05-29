package axon;

import java.util.HashSet;
import java.util.Set;

public class Versicherung {

  private Person versicherter;
  private Set<Person> begünstigte = new HashSet<Person>(2);

  public Person getVersicherter() {
    return versicherter;
  }

  public void setVersicherter(Person versicherter) {
    this.versicherter = versicherter;
  }

  public Set<Person> getBegünstigte() {
    return begünstigte;
  }

  public void setBegünstigte(Set<Person> begünstigte) {
    this.begünstigte = begünstigte;
  }
}
