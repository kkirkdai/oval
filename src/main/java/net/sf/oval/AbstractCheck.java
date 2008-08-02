/*******************************************************************************
 * Portions created by Sebastian Thomschke are copyright (c) 2005-2008 Sebastian
 * Thomschke.
 * 
 * All Rights Reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Sebastian Thomschke - initial implementation.
 *******************************************************************************/
package net.sf.oval;

import java.util.Map;

/**
 * Partial implementation of check classes.
 * 
 * @author Sebastian Thomschke
 */
public abstract class AbstractCheck implements Check
{
	private static final long serialVersionUID = 1L;

	protected String errorCode;
	protected String message;
	protected int severity;
	protected String[] profiles;

	/**
	 * {@inheritDoc}
	 */
	public String getErrorCode()
	{
		/*
		 * if the error code has not been initialized (which might be the case when using XML configuration),
		 * construct the string based on this class' name minus the appendix "Check"
		 */
		if (errorCode == null)
		{
			final String className = getClass().getName();
			if (className.endsWith("Check"))
			{
				errorCode = className.substring(0, getClass().getName().length() - 5);
			}
			else
			{
				errorCode = className;
			}
		}
		return errorCode;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getMessage()
	{
		/*
		 * if the message has not been initialized (which might be the case when using XML configuration),
		 * construct the string based on this class' name minus the appendix "Check" plus the appendix ".violated"
		 */
		if (message == null)
		{
			final String className = getClass().getName();
			if (className.endsWith("Check"))
			{
				message = className.substring(0, getClass().getName().length() - 5) + ".violated";
			}
			else
			{
				message = className + ".violated";
			}
		}
		return message;
	}

	/**
	 * {@inheritDoc}
	 */
	public Map<String, String> getMessageVariables()
	{
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	public String[] getProfiles()
	{
		return profiles;
	}

	/**
	 * {@inheritDoc}
	 */
	public int getSeverity()
	{
		return severity;
	}

	/**
	 * {@inheritDoc}
	 */
	public void setErrorCode(final String failureCode)
	{
		errorCode = failureCode;
	}

	/**
	 * {@inheritDoc}
	 */
	public void setMessage(final String message)
	{
		this.message = message;
	}

	/**
	 * {@inheritDoc}
	 */
	public void setProfiles(final String... profiles)
	{
		this.profiles = profiles;
	}

	/**
	 * {@inheritDoc}
	 */
	public void setSeverity(final int severity)
	{
		this.severity = severity;
	}
}
