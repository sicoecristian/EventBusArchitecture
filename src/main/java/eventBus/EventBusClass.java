package eventBus;
import com.google.common.eventbus.Subscribe;
import objects.ChairInProgress;
import objects.CompleteChair;

import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;


public class EventBusClass {


    private Map<Class<?>, List<Invocation>> invocations;

    private static ArrayList<ChairInProgress> chairInProgresses;
    private static ArrayList<CompleteChair> chairs;

    private String name;

    public static void setChairInProgresses(ArrayList<ChairInProgress> chairInProgresses) {
        EventBusClass.chairInProgresses = chairInProgresses;
    }

    public static void setChairs(ArrayList<CompleteChair> chairs) {
        EventBusClass.chairs = chairs;
    }

    public EventBusClass(String name) {
        this.name = name;
        invocations = new ConcurrentHashMap<>();
    }


    public void post(Object object) {
        Class<?> clazz = object.getClass();
        if (invocations.containsKey(clazz)) {
            invocations.get(clazz).forEach(invocation -> invocation.invoke(object));
        }
    }

    public void register(Object object) {
        Class<?> currentClass = object.getClass();
        // we try to navigate the object tree back to object ot see if
        // there is any annotated @Subscribe classes
        while (currentClass != null) {
            List<Method> subscribeMethods = findSubscriptionMethods(currentClass);
            for (Method method : subscribeMethods) {
                // we know for sure that it has only one parameter
                Class<?> type = method.getParameterTypes()[0];
                if (invocations.containsKey(type)) {
                    invocations.get(type).add(new Invocation(method, object));
                } else {
                    List<Invocation> temp = new Vector<>();
                    temp.add(new Invocation(method, object));
                    invocations.put(type, temp);
                }
            }
            currentClass = currentClass.getSuperclass();
        }
    }

    private List<Method> findSubscriptionMethods(Class<?> type) {
        List<Method> subscribeMethods = Arrays.stream(type.getDeclaredMethods())
                .filter(method -> method.isAnnotationPresent(Subscribe.class))
                .collect(Collectors.toList());
        checkSubscriberMethods(subscribeMethods);
        return subscribeMethods;
    }

    private void checkSubscriberMethods(List<Method> subscribeMethods) {
        boolean hasMoreThanOneParameter = subscribeMethods.stream()
                .anyMatch(method -> method.getParameterCount() != 1);
        if (hasMoreThanOneParameter) {
            throw new IllegalArgumentException(
                    "Method annotated with @Susbscribe has more than one parameter");
        }
    }

    public Map<Class<?>, List<Invocation>> getInvocations() {
        return invocations;
    }

    public String getName() {
        return name;
    }
}