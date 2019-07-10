/**
 * 
 */
package io.atmecs.exceptions;

/**
 * @author ruchira.more
 *
 */
public class StatusNotFoundException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public StatusNotFoundException(String exception) {
	    super(exception);
	  }
}
