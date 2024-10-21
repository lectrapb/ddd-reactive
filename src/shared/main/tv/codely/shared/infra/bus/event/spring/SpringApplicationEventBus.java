package tv.codely.shared.infra.bus.event.spring;

import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import tv.codely.shared.domain.bus.EventBus;
import tv.codely.shared.domain.event.DomainEvent;

import java.util.List;
@Service
@AllArgsConstructor
public class SpringApplicationEventBus implements EventBus {

    private final ApplicationEventPublisher publisher;

    @Override
    public Mono<Void> publish(List<DomainEvent<?>> events) {
        events.forEach(this::publish);
        return Mono.empty();
    }

    private void publish(final DomainEvent<?> event) {
        this.publisher.publishEvent(event);
    }
}
