package com.itquasar.unhellify.unnullify;

/**
 * Class to allow return value or error without using null. This class has 2
 * subclasses: {@link Ok} ans {@link Err}.
 *
 * To get the returned value, one <strong>MUST</strong> always call {@link #hasValue()
 * } first as {@link Err} throws {@link Error} when trying to get his value as
 * it has no value.
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
 * @since 2015-05-18
 *
 */
public abstract class Result<T, E> extends Option<T> {
    
    public static <T, E> Ok<T,E> Ok(T value){
        return new Ok<>(value);
    }
    
    public static <T, E> Err<T,E> Err(E error){
        return new Err<>(error);
    }

    /**
     * * Checks if are some valid value.
     *
     * This methods allow check if there is a valid return value. If there are
     * no value returned ({@code null}, for example), <strong>MUST</strong>
     * always return {@code false}.
     *
     * @return False if this is a {@link None} object, true otherwise.
     */
    public abstract boolean hasValue();

    /**
     *
     * @return The value holded by this option if it is of type {@link Some}.
     * Throws {@link Error} otherwise ({@link None} type).
     */
    public abstract T getValue();

    public abstract E getError();

}
