//: guru.sfg.mssc.beer.service.web.events.NotFoundEventPublisher.java


package guru.sfg.mssc.beer.service.web.events;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;


@Component
public class NotFoundEventPublisher {

    private final ApplicationEventPublisher appEventPublisher;

    @Autowired
    public NotFoundEventPublisher(ApplicationEventPublisher appEventPublisher) {
        this.appEventPublisher = appEventPublisher;
    }

    public void publish(final String message) {
        NotFoundEvent event = NotFoundEvent.of(this, message);
        this.appEventPublisher.publishEvent(event);
    }

}///:~