package interfaces;

import java.util.Set;

public interface Subscriabable {
    void handle(Event<?> event);
    Set<Class<?>> supports();

}