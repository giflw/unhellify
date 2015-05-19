package com.itquasar.unhellify.unnullify;

import com.itquasar.unhellify.unnullify.exceptions.NoValueError;
import com.itquasar.unhellify.unnullify.exceptions.NullValueError;
import java.util.Objects;

/**
 *
 * @param <T> Type to be used in values.
 * @param <E> Type to be used in errors.
 *
 * @author Guilherme I F L Weizenmann
 * @since 2015-05-18
 *
 */
public class Err<T, E> extends Result<T, E> {

    private final E error;

    public Err(E error) {
        if (error == null) {
            throw new NullValueError("Null value is not allowed in Err as error object (extends Result)");
        }
        this.error = error;
    }

    @Override
    public E getError() {
        return error;
    }

    @Override
    public boolean hasValue() {
        return false;
    }

    @Override
    public T getValue() {
        throw new NoValueError("There is no value to get! Err (extends Result) has no value!");
    }

    @Override
    public String toString() {
        return "Err(" + error + ")";
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.error);
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
        final Err<?, ?> other = (Err<?, ?>) obj;
        return Objects.equals(this.error, other.getError());
    }

}
