package com.itquasar.unhellify.unnullify.exceptions;

/**
 * Indicates that no error is available to be retrived by method. Probably that
 * method shouldn't be invoked by contract.
 *
 * @author Guilherme I F L Weizenmann
 * @since 2015-05-18
 *
 */
public class NoErrorError extends Error {

    private static final long serialVersionUID = 1L;

    /**
     *
     * @param message Human readable message describing the error.
     */
    public NoErrorError(String message) {
        super(message);
    }

}
