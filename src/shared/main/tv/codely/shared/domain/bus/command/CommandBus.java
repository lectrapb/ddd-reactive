package tv.codely.shared.infra.bus.command;

public interface CommandBus {

    void dispatch(Command command) throws CommandNotRegisteredError;
}
