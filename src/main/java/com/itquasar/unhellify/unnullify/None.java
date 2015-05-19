package com.itquasar.unhellify.unnullify;

import com.itquasar.unhellify.unnullify.exceptions.NoValueError;

/**
 * This class represents an {@link Option} with no value. So, one doesn't need
 * to return null and can safely check if has a value or not, using
 * {@link #hasValue()}.
 *
 * This class <strong>MUST NEVER</strong> be instantiated. Use
 * {@link Option#None} constant instead!
 *
 * To use the constant that represents no value in a more fluid syntax, import
 * the static {@link Option#None}.
 *
 * @param <T> Type to be used in values.
 *
 * @author Guilherme I F L Weizenmann
 * @since 2015-05-18
 */
final class None<T> extends Option<T> {

    /**
     * Constructs an None object. Use {@link Option#None} constant instead.
     */
    protected None() {
    }

    /**
     * Checks if are some valid value.
     *
     * @return Always false.
     */
    @Override
    public boolean hasValue() {
        return false;
    }

    /**
     *
     * @return Nothing! Always throws {@link Error}.
     *
     */
    @Override
    public T getValue() {
        throw new NoValueError(
                "There is no value to get! None (extends Option) has no value!"
        );
    }

    /**
     * @return {@literal "None()"}
     */
    @Override
    public String toString() {
        return "None()";
    }

}
