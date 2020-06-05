//: guru.sfg.mssc.beer.service.config.AsynchronousSpringEventsConfig.java


package guru.sfg.mssc.beer.service.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.core.task.SimpleAsyncTaskExecutor;


@Configuration
public class AsynchronousSpringEventsConfig {

    @Bean
    public ApplicationEventMulticaster simpleAppEventMulticaster() {
        SimpleApplicationEventMulticaster appEventMulticaster =
                new SimpleApplicationEventMulticaster();
        appEventMulticaster.setTaskExecutor(new SimpleAsyncTaskExecutor());
        return appEventMulticaster;
    }

}///:~