//: guru.sfg.mssc.beer.service.web.events.ContextRefreshListener.java


package guru.sfg.mssc.beer.service.web.events;


import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;


@Slf4j
@Component
public class ContextRefreshListener implements
        ApplicationListener<ContextRefreshedEvent> {

    /*
     * Event raised when an ApplicationContext gets initialized or refreshed.
     */
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        log.info(">>>>>>> [EVENT] - Application Context was just initialized.");
    }

}///:~