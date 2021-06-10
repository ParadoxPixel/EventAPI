package nl.iobyte.eventapi.interfaces;

public interface IExecutor<T> {

    void fire(T event);

}
