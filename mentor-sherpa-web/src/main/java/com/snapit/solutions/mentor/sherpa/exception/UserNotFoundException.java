/*
 * Property of SnapIT Solutions.
 */
package com.snapit.solutions.mentor.sherpa.exception;

/**
 *
 * @author Sudheer.Parasker@SnapIT.Solutions
 */
public final class UserNotFoundException extends RuntimeException {
 public UserNotFoundException() {
        super();
    }

    public UserNotFoundException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public UserNotFoundException(final String message) {
        super(message);
    }

    public UserNotFoundException(final Throwable cause) {
        super(cause);
    }   
}
