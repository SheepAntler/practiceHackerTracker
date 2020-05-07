package stalterclouse.elspeth.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Used in a custom JSTL tag to take a LocalDateTime and return a formatted version
 *
 * @author BalusC and Bastien Jansen who provided me with this formatting solution here: https://stackoverflow.com/a/35607225/13107674 THANK YOU BOTH SO MUCH!
 */
public final class Dates {
    private Dates() {}

    public static String formatLocalDateTime(LocalDateTime localDateTime, String pattern) {
        return localDateTime.format(DateTimeFormatter.ofPattern(pattern));
    }
}
