/*******************************************************************************
 * Copyright 2017
 * Ubiquitous Knowledge Processing (UKP) Lab
 * Technische Universität Darmstadt
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package de.tudarmstadt.ukp.wikipedia.revisionmachine.common.util;

/**
 * This utitly class contains some surrogate related methods.
 *
 *
 *
 */
public class Surrogates
{

	/** No object - utility class */
	private Surrogates()
	{
	}

	/**
	 * Returns whether a surrogate character was contained in the specified
	 * input.
	 *
	 * @param input
	 *            input
	 * @return if a surrogate character was contained or not
	 */
	public static boolean scan(final char[] input)
	{

		int surLow = 0xD800;
		int surHgh = 0xDFFF;

		int end = input.length;
		for (int i = 0; i < end; i++) {
			if ((int) input[i] >= surLow && input[i] <= surHgh) {
				return true;
			}
		}

		return false;
	}

	/**
	 * Replaces all surrogates characters with '?'.
	 *
	 * @param input
	 *            input
	 * @return input with '?' instead of surrogates characters
	 */
	public static char[] replace(final char[] input)
	{

		int surLow = 0xD800;
		int surHgh = 0xDFFF;

		int end = input.length;
		char[] output = new char[end];

		for (int i = 0; i < end; i++) {
			if ((int) input[i] >= surLow && input[i] <= surHgh) {
				output[i] = '?';
			}
			else {
				output[i] = input[i];
			}
		}

		return output;
	}
}