package com.itquasar.unhellify.unnullify.exceptions;

/**
 * Indicates that an method has no value to return, problably because it
 * shouldn't be invoked by contract.
 *
 * @author Guilherme I F L Weizenmann
 * @since 0.1.0
 *
 */
public class NoValueError extends Error {

    @SuppressWarnings("checkstyle:javadocvariable")
    private static final long serialVersionUID = 1L;

    /**
     *
     * @param message Human readable message describing the error.
     */
    @SuppressWarnings("checkstyle:finalparameters")
    public NoValueError(String message) {
        super(message);
    }

}
