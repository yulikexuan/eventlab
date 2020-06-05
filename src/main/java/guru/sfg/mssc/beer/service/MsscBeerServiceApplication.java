//: guru.sfg.mssc.beer.service.MsscBeerServiceApplication.java


package guru.sfg.mssc.beer.service;


import guru.sfg.mssc.beer.service.web.events.GenericAppEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;

import java.util.UUID;


@Slf4j
@SpringBootApplication
public class MsscBeerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsscBeerServiceApplication.class, args);
    }

    @Async
    @EventListener
    public void handleFoundBeerEvent(GenericAppEvent<UUID> foundBeerEvent) {
        log.info(">>>>>>> [EVENT] - Found beer {} successfully! ",
                foundBeerEvent.getPayload());
    }

}///:~