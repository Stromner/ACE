package ace.core.errors;

import org.springframework.core.NestedCheckedException;

/**
 * Custom NestedCheckedException
 */
public class IllegalPlayerDataException extends NestedCheckedException {
    /**
     * @param msg error
     */
    public IllegalPlayerDataException(String msg) {
        super(msg);
    }

    /**
     * @param msg error
     * @param cause thrown cause
     */
    public IllegalPlayerDataException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
