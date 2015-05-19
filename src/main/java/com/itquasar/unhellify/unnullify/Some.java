package com.itquasar.unhellify.unnullify;

import com.itquasar.unhellify.unnullify.exceptions.NullValueError;
import java.util.Objects;

/**
 * This class represents an {@link Option} with some value. So, one must create
 * a new instance of { @link Some} to return a non {@code null} value in a null
 * safe manner. This class return {@code true} for {@link #hasValue()}.
 *
 * To use this class in a more fluid syntax, import the static method
 * {@link Option#Some(Object) }.
 *
 * @param <T> Type to be used in values.
 *
 * @author Guilherme I F L Weizenmann
 * @since 2015-05-18
 */
final class Some<T> extends Option<T> {

    /**
     * The value holded by this {@link Option}.
     */
    private final T value;

    /**
     *
     * @param value Not {@code null} value, otherwise throws {@link Error}.
     */
    public Some(T value) {
        if (value == null) {
            throw new NullValueError(
                    "Null value is not allowed in Some (extends Option)"
            );
        }
        this.value = value;
    }

    /**
     * Checks if are some valid value.
     *
     * @return {@code true}, always.
     */
    @Override
    public boolean hasValue() {
        return true;
    }

    /**
     *
     * @return The value holded by this {@link Option}. Will be always not
     * {@code null}.
     */
    @Override
    public T getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Some(" + value + ")";
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.value);
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
        final Some<?> other = (Some<?>) obj;
        if (!Objects.equals(this.value, other.getValue())) {
            return false;
        }
        return true;
    }

}
