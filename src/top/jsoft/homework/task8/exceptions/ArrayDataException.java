package top.jsoft.homework.task8.exceptions;

/**
 * Created by psygrammator
 * group jsoft.top
 */
public class ArrayDataException extends Exception {
    public ArrayDataException() {
    }

    public ArrayDataException(String message) {
        super(message);
    }

    public ArrayDataException(String message, Throwable cause) {
        super(message, cause);
    }

    public ArrayDataException(Throwable cause) {
        super(cause);
    }

    public ArrayDataException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
