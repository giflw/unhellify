/**
 * All custom {@code Exception} and {@code Error} resides on package
 * {@code exceptions}.
 *
 * Any class that extends {@code Error} are used to get
 * <em>unchecked exceptions</em> (the ones that don't need try/catch blocks), as
 * they are throwned when contract is not followed.
 *
 * Any class that extends {@code Exception} must be caught or throwned again, as
 * they represent errors that <strong>MUST</strong> be handled outside the
 * library by contratct.
 *
 * @author Guilherme I F L Weizenmann
 * @since 0.1.0
 */
package com.itquasar.unhellify.unnullify.exceptions;
