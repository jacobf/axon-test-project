package axon.event;

import axon.Person;
import org.axonframework.domain.DomainEvent;

public class PersonAngelegtEvent extends DomainEvent {

  private Person person;

  public PersonAngelegtEvent(Person person) {
    this.person = person;
  }

  public Person getPerson() {
    return person;
  }
}
