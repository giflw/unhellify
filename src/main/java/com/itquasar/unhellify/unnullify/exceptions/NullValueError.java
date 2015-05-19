package com.itquasar.unhellify.unnullify.exceptions;

/**
 * Indicates that a given value is null be shouldn't.
 *
 * @author Guilherme I F L Weizenmann
 * @since 0.1.0
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
