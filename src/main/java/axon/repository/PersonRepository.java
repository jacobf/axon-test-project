package axon.repository;

import axon.Person;
import org.axonframework.repository.AbstractRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class PersonRepository extends AbstractRepository<Person> {

  private Map<UUID, Person> personsDb = new HashMap<UUID, Person>();

  @Override
  protected void doSave(Person person) {
    personsDb.put(person.getIdentifier(), person);
  }

  @Override
  protected Person doLoad(UUID uuid) {
    return personsDb.get(uuid);
  }
}
