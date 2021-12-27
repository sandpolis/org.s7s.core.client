//============================================================================//
//                                                                            //
//            Copyright © 2015 - 2022 Sandpolis Software Foundation           //
//                                                                            //
//  This source file is subject to the terms of the Mozilla Public License    //
//  version 2. You may not use this file except in compliance with the MPLv2. //
//                                                                            //
//============================================================================//
package org.s7s.core.client.cmd;

import java.util.concurrent.CompletionStage;

import org.s7s.core.protocol.Listener.RQ_CreateListener;
import org.s7s.core.protocol.Listener.RQ_DeleteListener;
import org.s7s.core.protocol.Listener.RS_CreateListener;
import org.s7s.core.protocol.Listener.RS_DeleteListener;
import org.s7s.core.instance.cmdlet.Cmdlet;

/**
 * An API for interacting with listeners on the server.
 *
 * @author cilki
 * @since 4.0.0
 */
public final class ListenerCmd extends Cmdlet<ListenerCmd> {

	/**
	 * Add a new listener on the server.
	 *
	 * @param config The listener configuration
	 * @return An asynchronous {@link CompletionStage}
	 */
	public CompletionStage<RS_CreateListener> create() {
		return request(RS_CreateListener.class, RQ_CreateListener.newBuilder());
	}

	/**
	 * Stop and remove a listener on the server.
	 *
	 * @param id The listener ID
	 * @return An asynchronous {@link CompletionStage}
	 */
	public CompletionStage<RS_DeleteListener> remove(int id) {
		return request(RS_DeleteListener.class, RQ_DeleteListener.newBuilder());
	}

	/**
	 * Prepare for an asynchronous command.
	 *
	 * @return A configurable object from which all asynchronous (nonstatic)
	 *         commands in {@link ListenerCmd} can be invoked
	 */
	public static ListenerCmd async() {
		return new ListenerCmd();
	}

	private ListenerCmd() {
	}
}
