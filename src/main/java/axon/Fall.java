package axon;

import axon.event.PersonAngelegtEvent;
import org.axonframework.eventhandling.annotation.EventHandler;
import org.axonframework.eventsourcing.annotation.AbstractAnnotatedAggregateRoot;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Fall extends AbstractAnnotatedAggregateRoot {

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
}
