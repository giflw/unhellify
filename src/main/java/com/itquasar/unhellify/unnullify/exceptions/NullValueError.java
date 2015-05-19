package com.itquasar.unhellify.unnullify.exceptions;

/**
 * Indicates that a given value is null be shouldn't.
 *
 * @author Guilherme I F L Weizenmann
 * @since 2015-05-18
 *
 */
public class NullValueError extends Error {

    private static final long serialVersionUID = 1L;

    /**
     *
     * @param message Human readable message describing the error.
     */
    public NullValueError(String message) {
        super(message);
    }

}
