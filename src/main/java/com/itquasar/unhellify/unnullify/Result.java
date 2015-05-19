package com.itquasar.unhellify.unnullify;

/**
 * Class to allow return no value without using null. This class has 2
 * subclasses: {@link Some} ans {@link None}.
 *
 * To get the returned value, one <strong>MUST</strong> always call {@link #hasValue()
 * } first as {@link None} throws {@link Error} when trying to get his value as
 * with it has no value.
 *
 * To return a valid value using this classes, one must create an instance of
 * {@link Some}. Note that passing {@code null} to {@link Some} will throw an
 * {@link Exception} as this class was conceived to avoid returning null values.
 *
 * All exceptions throwned by this API are unchecked ({@link Error}.
 *
 * @author Guilherme I F L Weizenmann <guilherme@itquasar.com>
 * @since 2015-05-18
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
    public static final None None = new None();

    /**
     * Helper method to create {@link Some} values.
     *
     * @param <T>
     * @param v Value of this {@link Option}. Must be not <code>null</code>.
     * @return
     */
    public static <T> Some<T> Some(T v) {
        return new Some<T>(v);
    }

    /**
     *
     * Checks if are some valid value.
     *
     * This methods allow check if there is a valid return value. If the value
     * is <code>null</code>, <strong>MUST</strong> always return
     * <code>false</code>.
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
