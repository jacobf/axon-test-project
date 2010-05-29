package axon;

import axon.event.PersonAngelegtEvent;
import org.axonframework.eventsourcing.annotation.AbstractAnnotatedAggregateRoot;

public class Person extends AbstractAnnotatedAggregateRoot {

  private String name;

  public Person(String name) {
    this.name = name;
    this.registerEvent(new PersonAngelegtEvent(this));
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
