package com.itquasar.unhellify.unnullify.exceptions;

/**
 * Indicates that no error is available to be retrived by method. Probably that
 * method shouldn't be invoked by contract.
 *
 * @author Guilherme I F L Weizenmann
 * @since 0.1.0
 *
 */
public class NoErrorError extends Error {

    @SuppressWarnings("checkstyle:javadocvariable")
    private static final long serialVersionUID = 1L;

    /**
     *
     * @param message Human readable message describing the error.
     */
    @SuppressWarnings("checkstyle:finalparameters")
    public NoErrorError(String message) {
        super(message);
    }

}
