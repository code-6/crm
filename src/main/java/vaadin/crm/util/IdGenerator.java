package vaadin.crm.util;

import java.util.concurrent.atomic.AtomicLong;

public class IdGenerator {
    private static AtomicLong id = new AtomicLong();

    public static long getId(){
        return id.getAndIncrement();
    }
}
