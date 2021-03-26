package interfaces;
import java.util.List;

public interface EventBus {
    void register(Subscriabable subscriabable);

    void dispach(Event<?> event);

    List<Subscriabable> getSubscribers();
}
