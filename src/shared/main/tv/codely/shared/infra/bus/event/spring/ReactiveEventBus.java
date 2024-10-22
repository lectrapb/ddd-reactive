package tv.codely.shared.infra.bus.event.spring;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Sinks;
import tv.codely.shared.domain.event.DomainEvent;

@Service
public class ReactiveEventBus {
    private final Sinks.Many<DomainEvent<?>> sink;

    public ReactiveEventBus() {
        this.sink = Sinks.many().multicast().onBackpressureBuffer();
    }

    public void publish(DomainEvent<?> event) {
        sink.tryEmitNext(event);
    }

    public Sinks.Many<DomainEvent<?>> getSink() {
        return sink;
    }
}
