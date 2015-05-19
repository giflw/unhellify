package com.itquasar.unhellify.unnullify;

import com.itquasar.unhellify.unnullify.exceptions.NoErrorError;
import com.itquasar.unhellify.unnullify.exceptions.NullValueError;
import java.util.Objects;

/**
 *
 * @param <T> Type to be used in values.
 * @param <E> Type to be used in errors.
 *
 * @author Guilherme I F L Weizenmann
 * @since 2015-05-18
 */
public class Ok<T, E> extends Result<T, E> {

    private final T value;

    public Ok(T value) {
        if (value == null) {
            throw new NullValueError("Null value is not allowed in Ok as value object (extends Result)");
        }
        this.value = value;
    }

    @Override
    public E getError() {
        throw new NoErrorError("No error ocurred! This is a good Result!");
    }

    @Override
    public boolean hasValue() {
        return true;
    }

    @Override
    public T getValue() {
        return value;
    }

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
