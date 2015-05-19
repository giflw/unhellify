package com.itquasar.unhellify.unnullify.exceptions;

/**
 * Indicates that an method has no value to return, problably because it
 * shouldn't be invoked by contract.
 *
 * @author Guilherme I F L Weizenmann
 * @since 2015-05-18
 *
 */
public class NoValueError extends Error {

    private static final long serialVersionUID = 1L;

    /**
     *
     * @param message Human readable message describing the error.
     */
    public NoValueError(String message) {
        super(message);
    }

}
