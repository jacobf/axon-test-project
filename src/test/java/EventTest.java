import org.axonframework.eventhandling.EventListener;
import org.easymock.internal.MocksControl;
import org.testng.annotations.Test;

/**
 * Created by IntelliJ IDEA. User: leif.hanack Date: 29.05.2010 Time: 16:22:09 To change this template use File | Settings | File
 * Templates.
 */
public class EventTest {

  @Test
  public void testMessageForwarded() {
    MocksControl mocksControl = new MocksControl(MocksControl.MockType.NICE);
    EventListener listener = mocksControl.createMock(EventListener.class);

    // EventHandler add Event
    // EventListner : hab Event gefunden

  }
}
