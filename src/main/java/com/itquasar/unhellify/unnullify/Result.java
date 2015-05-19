package com.itquasar.unhellify.unnullify;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

/**
 * Class to allow return value or error without using null. This class has 2
 * subclasses: {@link Ok} ans {@link Err}.
 *
 * To get the returned value, one <strong>MUST</strong> always call
 * {@link #hasValue()} first as {@link Err} throws {@link Error} when trying to
 * get his value as it has no value.
 *
 * To return a valid value using this classes, one must create an instance of
 * {@link Some}. Note that passing {@code null} to {@link Some} will throw an
 * {@link Exception} as this class was conceived to avoid returning null values.
 *
 * All exceptions throwned by this API are unchecked ({@link Error}.
 *
 * @param <T> Type to be used in values.
 * @param <E> Type to be used in errors.
 *
 * @author Guilherme I F L Weizenmann
 * @since 0.1.0
 *
 */
public abstract class Result<T, E> extends Option<T> {

    /**
     * Helper method to create {@link Ok} {@link Result}.
     *
     * @param <T> Type of value
     * @param <E> Type of error
     * @param value Value of this result
     * @return An {@link Ok} object with the given value
     */
    @SuppressFBWarnings(
            value = {"NM_METHOD_NAMING_CONVENTION"},
            justification = "Make a more fluid API"
    )
    public static <T, E> Ok<T, E> Ok(T value) {
        return new Ok<>(value);
    }

    /**
     * Helper method to create {@link Err} {@link Result}.
     *
     * @param <T> Type of value
     * @param <E> Type of error
     * @param error Error of this result
     * @return An {@link Err} object with the given value
     */
    @SuppressFBWarnings(
            value = {"NM_METHOD_NAMING_CONVENTION"},
            justification = "Make a more fluid API"
    )
    public static <T, E> Err<T, E> Err(E error) {
        return new Err<>(error);
    }

    /**
     * Checks if are some valid value.
     *
     * This methods allow check if there is a valid return value. If there are
     * no value returned (some error ocurred), <strong>MUST</strong>
     * always return {@code false}.
     *
     * @return False if this is a {@link Err} object, true otherwise.
     */
    public abstract boolean hasValue();

    /**
     * Get the value associated with this result.
     *
     * @return The value holded by this result if it is of type {@link Ok}.
     * Throws {@link com.itquasar.unhellify.unnullify.exceptions.NoValueError}
     * otherwise ({@link Err} type).
     */
    public abstract T getValue();

    /**
     * Get the error associated with this result.
     *
     * @return The error holded by this result if it is of type {@link Err}.
     * Throws {@link com.itquasar.unhellify.unnullify.exceptions.NoErrorError}
     * otherwise ({@link Ok} type).
     */
    public abstract E getError();

}
