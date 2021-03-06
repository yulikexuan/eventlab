//: guru.sfg.mssc.beer.service.web.controller.BeerController.java


package guru.sfg.mssc.beer.service.web.controller;


import guru.sfg.mssc.beer.service.domain.services.IBeerService;
import guru.sfg.mssc.beer.service.web.events.EventPublisher;
import guru.sfg.mssc.beer.service.web.events.GenericAppEvent;
import guru.sfg.mssc.beer.service.web.events.NewBeerSavedEvent;
import guru.sfg.mssc.beer.service.web.model.BeerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.support.RequestHandledEvent;

import javax.validation.Valid;
import java.util.UUID;


@Slf4j
@RestController
@RequestMapping("/api/v1/beer")
public class BeerController {

    private final IBeerService beerService;
    private final EventPublisher eventPublisher;

    @Autowired
    public BeerController(IBeerService beerService,
                          EventPublisher eventPublisher) {

        this.beerService = beerService;
        this.eventPublisher = eventPublisher;
    }

    @GetMapping("/{id}")
    public ResponseEntity<BeerDto> getBeerById(@PathVariable("id") UUID id) {
        BeerDto beerDto = this.beerService.getById(id);
        this.eventPublisher.publishFoundBeerEvent(id);
        return new ResponseEntity<>(beerDto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity saveNewBeer(@Valid @RequestBody BeerDto beerDto) {

        return new ResponseEntity(this.beerService.saveNewBeer(beerDto),
                HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateBeerById(
            @PathVariable("id") UUID id, @Valid @RequestBody BeerDto beerDto) {

        return new ResponseEntity(this.beerService.updateBeer(id, beerDto),
                HttpStatus.NO_CONTENT);
    }

    @Async
    @EventListener
    public void handleRequestHandledEvent(RequestHandledEvent rhe) {
        log.info(">>>>>>> [EVENT] - Request was handled - {}", rhe.getDescription());
    }

    @Async
    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void handleCustom(NewBeerSavedEvent event) {
        log.info(">>>>>>> [EVENT] - Beer Updated. {}", event.getPayload());
    }

}///:~