import axon.event.PersonHinzugefuegtEvent;
import org.axonframework.eventhandling.EventBus;
import org.axonframework.eventhandling.EventListener;
import org.axonframework.eventhandling.SimpleEventBus;
import org.easymock.internal.MocksControl;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.easymock.EasyMock.expect;

/**
 * Created by IntelliJ IDEA. User: leif.hanack Date: 29.05.2010 Time: 16:52:10 To change this template use File | Settings | File
 * Templates.
 */
public class EventBusTest {

  private EventListener listener1;
  private EventListener listener2;
  private EventBus eventBus;
  private EventListener listener3;

  @BeforeMethod
  public void setUp() {
    MocksControl mockControl = new MocksControl(MocksControl.MockType.NICE);
    listener1 = mockControl.createMock(EventListener.class);
    listener2 = mockControl.createMock(EventListener.class);
    listener3 = mockControl.createMock(EventListener.class);
    eventBus = new SimpleEventBus();
  }

  @Test
  public void testEventIsDispatchedToSubscribedListeners() {
    eventBus.publish(new PersonHinzugefuegtEvent());
    eventBus.subscribe(listener1);
    // subscribing twice should not make a difference
    eventBus.subscribe(listener1);
    eventBus.publish(new PersonHinzugefuegtEvent());
    eventBus.subscribe(listener2);
    eventBus.subscribe(listener3);
    eventBus.publish(new PersonHinzugefuegtEvent());
    eventBus.unsubscribe(listener1);
    eventBus.publish(new PersonHinzugefuegtEvent());
    eventBus.unsubscribe(listener2);
    eventBus.unsubscribe(listener3);
    // unsubscribe a non-subscribed listener should not fail
    eventBus.unsubscribe(listener3);
    eventBus.publish(new PersonHinzugefuegtEvent());

    expect(listener1.handle(new PersonHinzugefuegtEvent())).times(2);
    /*
    verify(listener1, times(2)).handle(isA(PersonHinzugefuegtEvent.class));
    verify(listener2, times(2)).handle(isA(PersonHinzugefuegtEvent.class));
    verify(listener3, times(2)).handle(isA(PersonHinzugefuegtEvent.class));
    */
  }
}
