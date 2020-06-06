//: guru.sfg.mssc.beer.service.web.events.NotFoundEventPublisher.java


package guru.sfg.mssc.beer.service.web.events;


import guru.sfg.mssc.beer.service.web.model.BeerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import java.util.UUID;


@Component
public class EventPublisher {

    private final ApplicationEventPublisher appEventPublisher;

    @Autowired
    public EventPublisher(ApplicationEventPublisher appEventPublisher) {
        this.appEventPublisher = appEventPublisher;
    }

    public void publishNotFoundEvent(final String message) {
        NotFoundEvent event = NotFoundEvent.of(this, message);
        this.appEventPublisher.publishEvent(event);
    }

    public void publishFoundBeerEvent(final UUID beerId) {
        FoundBeerEvent foundBeerEvent = FoundBeerEvent.of(this, beerId);
        this.appEventPublisher.publishEvent(foundBeerEvent);
    }

    public void publishNewBeerSavedEvent(final BeerDto beerDto) {
        NewBeerSavedEvent event =  NewBeerSavedEvent.of(this, beerDto);
        this.appEventPublisher.publishEvent(event);
    }

}///:~