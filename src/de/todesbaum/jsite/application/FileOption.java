/*
 * jSite - a tool for uploading websites into Freenet
 * Copyright (C) 2006 David Roden
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA 02111-1307, USA.
 */

package de.todesbaum.jsite.application;

/**
 * Container for various file options.
 *
 * @author David ‘Bombe’ Roden &lt;bombe@freenetproject.org&gt;
 */
public class FileOption {

	/** The default for the insert state. */
	private static final boolean DEFAULT_INSERT = true;

	/** The default for the custom key. */
	private static final String DEFAULT_CUSTOM_KEY = "CHK@";

	/** The default container. */
	private static final String DEFAULT_CONTAINER = "";

	/** The default edition range. */
	private static final int DEFAULT_EDITION_RANGE = 3;

	/** The default for the replace edition state. */
	private static final boolean DEFAULT_REPLACE_EDITION = false;

	/** The insert state. */
	private boolean insert;

	/** The custom key. */
	private String customKey;

	/** The default MIME type. */
	private final String defaultMimeType;

	/** The current MIME type. */
	private String mimeType;

	/** The container. */
	private String container;

	/** The edition range. */
	private int editionRange;

	/** The replace edition state. */
	private boolean replaceEdition;

	/**
	 * Creates new file options.
	 *
	 * @param defaultMimeType
	 *            The default MIME type of the file
	 */
	public FileOption(String defaultMimeType) {
		insert = DEFAULT_INSERT;
		customKey = DEFAULT_CUSTOM_KEY;
		this.defaultMimeType = defaultMimeType;
		mimeType = defaultMimeType;
		container = DEFAULT_CONTAINER;
		editionRange = DEFAULT_EDITION_RANGE;
		replaceEdition = DEFAULT_REPLACE_EDITION;
	}

	/**
	 * Returns the custom key. The custom key is only used when
	 * {@link #isInsert()} returns <code>true</code>.
	 *
	 * @return The custom key
	 */
	public String getCustomKey() {
		return customKey;
	}

	/**
	 * Sets the custom key. The custom key is only used when {@link #isInsert()}
	 * returns <code>true</code>.
	 *
	 * @param customKey
	 *            The custom key
	 */
	public void setCustomKey(String customKey) {
		if (customKey == null) {
			customKey = "";
		}
		this.customKey = customKey;
	}

	/**
	 * Returns whether the file should be inserted. If a file is not inserted, a
	 * custom key has to be specified for it.
	 *
	 * @see #setCustomKey(String)
	 * @return <code>true</code> if the file should be inserted,
	 *         <code>false</code> otherwise
	 */
	public boolean isInsert() {
		return insert;
	}

	/**
	 * Sets whether the file should be inserted. If a file is not inserted, a
	 * custom key has to be specified for it.
	 *
	 * @param insert
	 *            <code>true</code> if the file should be inserted,
	 *            <code>false</code> otherwise
	 */
	public void setInsert(boolean insert) {
		this.insert = insert;
	}

	/**
	 * Sets the MIME type of the file. Setting the MIME type to
	 * <code>null</code> will set the MIME type to the default MIME type.
	 *
	 * @param mimeType
	 *            The MIME type of the file
	 */
	public void setMimeType(String mimeType) {
		if (mimeType == null) {
			mimeType = defaultMimeType;
		}
		this.mimeType = mimeType;
	}

	/**
	 * Returns the MIME type of the file. If no custom MIME type has been set,
	 * the default MIME type is returned.
	 *
	 * @return The MIME type of the file
	 */
	public String getMimeType() {
		return mimeType;
	}

	/**
	 * Returns the name of the container this file should be put in.
	 *
	 * @return The name of the container
	 */
	public String getContainer() {
		return container;
	}

	/**
	 * Sets the name of the container this file should be put in.
	 *
	 * @param container
	 *            The name of the container
	 */
	public void setContainer(String container) {
		if (container == null) {
			container = DEFAULT_CONTAINER;
		}
		this.container = container;
	}

	/**
	 * Sets whether the file should have “$[EDITION+<i>n</i>]” tags replaced.
	 *
	 * @param replaceEdition
	 *            <code>true</code> to replace tags, <code>false</code> not
	 *            to replace
	 */
	public void setReplaceEdition(boolean replaceEdition) {
		this.replaceEdition = replaceEdition;
	}

	/**
	 * Returns whether the file should have “$[EDITION+<i>n</i>]” tags
	 * replaced.
	 *
	 * @return <code>true</code> if tags should be replaced,
	 *         <code>false</code> otherwise
	 */
	public boolean getReplaceEdition() {
		return replaceEdition;
	}

	/**
	 * Sets the range of editions that should be replaced.
	 *
	 * @param editionRange
	 *            The range editions to replace
	 */
	public void setEditionRange(int editionRange) {
		this.editionRange = editionRange;
	}

	/**
	 * Returns the range of editions that should be replaced.
	 *
	 * @return The range of editions to replace
	 */
	public int getEditionRange() {
		return editionRange;
	}

	/**
	 * Returns whether the options for this file have been modified, i.e. are
	 * not at their default values.
	 *
	 * @return <code>true</code> if the options have been modified,
	 *         <code>false</code> if they are at default values
	 */
	public boolean isCustom() {
		if (insert != DEFAULT_INSERT) {
			return true;
		}
		if (!customKey.equals(DEFAULT_CUSTOM_KEY)) {
			return true;
		}
		if (!defaultMimeType.equals(mimeType)) {
			return true;
		}
		if (!DEFAULT_CONTAINER.equals(container)) {
			return true;
		}
		if (replaceEdition != DEFAULT_REPLACE_EDITION) {
			return true;
		}
		if (editionRange != DEFAULT_EDITION_RANGE) {
			return true;
		}
		return false;
	}

}