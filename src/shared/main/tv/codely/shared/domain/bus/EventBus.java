package tv.codely.shared.domain.bus;

import reactor.core.publisher.Mono;
import tv.codely.shared.domain.event.DomainEvent;

import java.util.List;

public interface EventBus {

    Mono<Void> publish(final List<DomainEvent<?>> events );
}
