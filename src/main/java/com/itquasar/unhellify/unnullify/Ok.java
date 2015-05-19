package com.itquasar.unhellify.unnullify;

import com.itquasar.unhellify.unnullify.exceptions.NoErrorError;
import com.itquasar.unhellify.unnullify.exceptions.NullValueError;
import java.util.Objects;

/**
 * This class represents a success {@link Result}.
 *
 * @param <T> Type to be used in values.
 * @param <E> Type to be used in errors.
 *
 * @author Guilherme I F L Weizenmann
 * @since 0.1.0
 */
final class Ok<T, E> extends Result<T, E> {

    /**
     * Result value.
     */
    private final T value;

    /**
     * Build a Ok result with the given value.
     *
     * @param value Not null value.
     */
    public Ok(T value) {
        if (value == null) {
            throw new NullValueError("Null value is not allowed in Ok as value object (extends Result)");
        }
        this.value = value;
    }

    /**
     * Throws {@link NoErrorError}.
     *
     * @return Nothing!
     */
    @Override
    public E getError() {
        throw new NoErrorError("No error ocurred! This is a good Result!");
    }

    /**
     *
     * @return true
     */
    @Override
    public boolean hasValue() {
        return true;
    }

    /**
     * Get the holded value.
     *
     * @return The value.
     */
    @Override
    public T getValue() {
        return value;
    }

    /**
     * 
     * @return "Ok(value)"
     */
    @Override
    public String toString() {
        return "Ok(" + value + ")";
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.value);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Ok<?, ?> other = (Ok<?, ?>) obj;
        return Objects.equals(this.value, other.getValue());
    }

}
