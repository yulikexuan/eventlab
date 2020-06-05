//: guru.sfg.mssc.beer.service.web.events.NotFoundEventListener.java


package guru.sfg.mssc.beer.service.web.events;


import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;


@Slf4j
@Async
@Component
public class NotFoundEventListener implements ApplicationListener<NotFoundEvent> {

    @Override
    public void onApplicationEvent(NotFoundEvent notFoundEvent) {
        log.info(">>>>>> [EVENT] - {}", notFoundEvent.getMessage());
    }

}///:~