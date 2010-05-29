package axon.repository;

import axon.Fall;
import axon.Person;
import org.axonframework.eventhandling.EventBus;
import org.axonframework.eventhandling.SimpleEventBus;
import org.axonframework.eventhandling.annotation.AnnotationEventListenerAdapter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.fest.assertions.Assertions.assertThat;
import static org.testng.Assert.assertEquals;

@Test
public class PersonRepositoryTest {

  private EventBus eventBus;
  private EventBus eventBus2;
  private PersonRepository personRepository;
  private PersonRepository personRepository2;
  private Fall fall;
  private Fall fall2;

  @BeforeMethod
  public void setUp() {
    eventBus = new SimpleEventBus();
    eventBus2 = new SimpleEventBus();
    fall = new Fall();
    fall2 = new Fall();
    AnnotationEventListenerAdapter eventListenerAdapter = new AnnotationEventListenerAdapter(fall, eventBus);
    eventListenerAdapter.subscribe();
    AnnotationEventListenerAdapter eventListenerAdapter2 = new AnnotationEventListenerAdapter(fall2, eventBus);
    eventListenerAdapter2.subscribe();
    eventBus2.subscribe(fall);
    personRepository = new PersonRepository();
    personRepository.setEventBus(eventBus);
    personRepository2 = new PersonRepository();
    personRepository2.setEventBus(eventBus2);
  }

  @Test
  public void testPersonIsStored() {
    Person person = new Person("name");
    personRepository.save(person);
    assertThat(personRepository.load(person.getIdentifier()).getName()).isEqualTo(person.getName());
  }

  @Test
  public void testPersonIsStoredInFallAsWell() {
    Person person = new Person("name");
    personRepository.save(person);
    assertThat(fall.getPersonen()).contains(person);
    assertThat(fall2.getPersonen()).contains(person);
  }

  @Test
  public void testPersonIsStoredInFallAsWellWithTwoEventBus() {
    Person person = new Person("name");
    Person person2 = new Person("name2");
    personRepository.save(person);
    personRepository2.save(person2);
    assertThat(fall.getPersonen()).contains(person);
    assertEquals(fall.getPersonen().size(), 2);
  }
}
