package axon;

import axon.event.PersonAngelegtEvent;
import org.axonframework.domain.Event;
import org.axonframework.eventhandling.EventListener;
import org.axonframework.eventhandling.annotation.EventHandler;
import org.axonframework.eventsourcing.annotation.AbstractAnnotatedAggregateRoot;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Fall extends AbstractAnnotatedAggregateRoot implements EventListener {

  private List<Versicherung> versicherungen;
  private List<Person> personen = new ArrayList<Person>();

  public List<Versicherung> getVersicherungen() {
    return versicherungen;
  }

  public void setVersicherungen(List<Versicherung> versicherungen) {
    this.versicherungen = versicherungen;
  }

  public List<Person> getPersonen() {
    return Collections.unmodifiableList(personen);
  }

  @EventHandler
  private void handlePersonHinzugefuegtEvent(PersonAngelegtEvent event) {
    personen.add(event.getPerson());
  }

  public void handle(Event event) {
    this.handlePersonHinzugefuegtEvent((PersonAngelegtEvent) event);
  }
}
