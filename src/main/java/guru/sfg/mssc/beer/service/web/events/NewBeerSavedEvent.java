//: guru.sfg.mssc.beer.service.web.events.NewBeerSavedEvent.java


package guru.sfg.mssc.beer.service.web.events;


import guru.sfg.mssc.beer.service.web.model.BeerDto;


public class NewBeerSavedEvent extends GenericAppEvent<BeerDto> {

    private NewBeerSavedEvent(Object source, BeerDto payload) {
        super(source, payload, true);
    }

    public static NewBeerSavedEvent of(Object source, BeerDto payload) {
        return new NewBeerSavedEvent(source, payload);
    }

}///:~