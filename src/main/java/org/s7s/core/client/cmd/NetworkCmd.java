//============================================================================//
//                                                                            //
//            Copyright © 2015 - 2022 Sandpolis Software Foundation           //
//                                                                            //
//  This source file is subject to the terms of the Mozilla Public License    //
//  version 2. You may not use this file except in compliance with the MPLv2. //
//                                                                            //
//============================================================================//
package org.s7s.core.client.cmd;

import org.s7s.core.instance.cmdlet.Cmdlet;

/**
 * Contains network commands.
 *
 * @author cilki
 * @since 5.0.0
 */
public final class NetworkCmd extends Cmdlet<NetworkCmd> {

	/**
	 * Prepare for an asynchronous command.
	 *
	 * @return A configurable object from which all asynchronous (nonstatic)
	 *         commands in {@link NetworkCmd} can be invoked
	 */
	public static NetworkCmd async() {
		return new NetworkCmd();
	}

	private NetworkCmd() {
	}
}
