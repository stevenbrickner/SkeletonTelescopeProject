package Events;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;

import Events.Listeners.*;

public class EventDispatcher {
    private static final ExecutorService executorService = Executors.newFixedThreadPool(1);
    private static final BlockingQueue<Event> eventQueue = new PriorityBlockingQueue<>();
    private static final List<EventListener> eventListeners = new ArrayList<>();

    private EventDispatcher() {
        // Private constructor to prevent instantiation
    }

    public static void registerEventListener(EventListener listener) {
        eventListeners.add(listener);
    }

    public static void unregisterEventListener(EventListener listener) {
        eventListeners.remove(listener);
    }

    public static void dispatchEvent(Event event) {
        eventQueue.offer(event); // Add event to the queue
    }

    public static void start() {
        System.out.println("Dispatcher processing events");
        executorService.execute(EventDispatcher::processEvents);
    }

    private static void processEvents() {
        while (true) {
            try {
                Event event = eventQueue.take(); // Blocking call to take an event from the queue
                for (EventListener listener : eventListeners) {
                    listener.onEvent(event);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
    
    public static void shutdown() {
        executorService.shutdown();
    }
}
