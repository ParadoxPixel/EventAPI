package nl.iobyte.eventapi.objects;

import nl.iobyte.eventapi.interfaces.IExecutor;
import java.util.LinkedHashSet;
import java.util.Set;

public class Listener<T> {

    private final Set<IExecutor<T>> executors = new LinkedHashSet<>();

    public Listener<T> addHandler(IExecutor<T> executor) {
        executors.add(executor);
        return this;
    }

    public void fire(Object obj) {
        T event = (T) obj;
        for (IExecutor<T> executor : executors) {
            if (executor == null)
                return;

            try {
                executor.fire(event);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
