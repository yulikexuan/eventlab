//: guru.sfg.mssc.beer.service.web.events.FoundBeerEvent.java


package guru.sfg.mssc.beer.service.web.events;


import java.util.UUID;


public class FoundBeerEvent extends GenericAppEvent<UUID> {

    private FoundBeerEvent(Object source, UUID payload) {
        super(source, payload, true);
    }

    public static FoundBeerEvent of(Object source, UUID payload) {
        return new FoundBeerEvent(source, payload);
    }

}///:~