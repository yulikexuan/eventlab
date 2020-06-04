//: guru.sfg.mssc.beer.service.domain.services.IBeerService.java


package guru.sfg.mssc.beer.service.domain.services;


import guru.sfg.mssc.beer.service.web.model.BeerDto;

import java.util.UUID;


public interface IBeerService {

    BeerDto getById(UUID id);

    BeerDto saveNewBeer(BeerDto beerDto);

    BeerDto updateBeer(UUID id, BeerDto beerDto);

}///:~