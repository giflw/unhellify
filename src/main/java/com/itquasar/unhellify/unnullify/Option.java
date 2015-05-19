package com.itquasar.unhellify.unnullify;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

/**
 * Class to allow return no value without using null. This class has 2
 * subclasses: {@link Some} ans {@link None}.
 *
 * To get the returned value, one <strong>MUST</strong> always call
 * {@link #hasValue()} first as {@link None} throws {@link Error} when trying to
 * get his value as it has no value.
 *
 * To return a valid value using this classes, one must create an instance of
 * {@link Some}. Note that passing {@code null} to {@link Some} will throw an
 * {@link Exception} as this class was conceived to avoid returning null values.
 *
 * All exceptions throwned by this API are unchecked ({@link Error}.
 *
 * @param <T> Type to be used in values.
 *
 * @author Guilherme I F L Weizenmann
 * @since 0.1.0
 */
public abstract class Option<T> {

    /**
     * Constant that represents no value, or null, but safely.
     *
     * Can be used <code>==</code> to compare with {@link #None} as it is a
     * constant, having always the same object reference.
     *
     * Note that constant {@link #None} has the same name as the class of this
     * object: {@link None}.
     */
    @SuppressWarnings("checkstyle:constantname")
    public static final None None = new None();

    /**
     * Helper method to create {@link Some} values.
     *
     * @param <T> Type to be used in values.
     * @param v Value of this {@link Option}. Must be not <code>null</code>.
     * @return {@link Some} instance of given type.
     */
    @SuppressFBWarnings(
            value = {"NM_METHOD_NAMING_CONVENTION"},
            justification = "Make a more fluid API"
    )
    @SuppressWarnings("checkstyle:methodname")
    public static <T> Some<T> Some(T v) {
        return new Some<>(v);
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

}
