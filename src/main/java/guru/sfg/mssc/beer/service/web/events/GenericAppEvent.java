//: guru.sfg.mssc.beer.service.web.events.GenericAppEvent.java


package guru.sfg.mssc.beer.service.web.events;


import lombok.Getter;
import org.springframework.context.ApplicationEvent;


@Getter
public class GenericAppEvent<T> extends ApplicationEvent {

    private final T payload;
    protected final boolean success;

    public GenericAppEvent(Object source, T payload, boolean success) {
        super(source);
        this.payload = payload;
        this.success = success;
    }

}///:~