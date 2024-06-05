package app.superprof.shared.exceptions;

public class NotFoundException extends RuntimeException {

    public NotFoundException(Class<?> entityClass, Long id) {
        super("No " + entityClass.getSimpleName() + " found with ID: " + id);
    }
}
