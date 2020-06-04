//: guru.sfg.mssc.beer.service.web.events.NotFoundEvent.java


package guru.sfg.mssc.beer.service.web.events;


import lombok.Getter;
import org.springframework.context.ApplicationEvent;


@Getter
public class NotFoundEvent extends ApplicationEvent {

    private final String message;

    private NotFoundEvent(Object source, String message) {
        super(source);
        this.message = message;
    }

    public static NotFoundEvent of(Object source, String message) {
        return new NotFoundEvent(source, message);
    }

}///:~