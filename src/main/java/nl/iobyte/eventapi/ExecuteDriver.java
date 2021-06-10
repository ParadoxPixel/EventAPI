package nl.iobyte.eventapi;

import nl.iobyte.eventapi.interfaces.IExecutable;
import nl.iobyte.eventapi.interfaces.IExecutor;
import nl.iobyte.eventapi.objects.Listener;

import java.util.HashMap;
import java.util.Map;

public class ExecuteDriver {

    private final Map<Class<? extends IExecutable>, Listener<?>> listeners = new HashMap<>();

    public <T extends IExecutable> Listener<T> on(Class<T> event) {
        Listener<T> listener = (Listener<T>) listeners.getOrDefault(event, new Listener<T>());
        listeners.put(event, listener);
        return listener;
    }

    public <T extends IExecutable> ExecuteDriver on(Class<T> event, IExecutor<T> handler) {
        on(event).addHandler(handler);
        return this;
    }

    public void fire(Object event) {
        if(event == null)
            return;

        Class<?> c1 = event.getClass();
        Class<?> c2;
        for(Map.Entry<Class<? extends IExecutable>, Listener<?>> entrySet : listeners.entrySet()) {
            c2 = entrySet.getKey();
            if(!c2.isInstance(event) && !c2.isAssignableFrom(c1))
                continue;

            try {
                entrySet.getValue().fire(event);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
