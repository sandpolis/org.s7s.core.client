//============================================================================//
//                                                                            //
//                         Copyright © 2015 Sandpolis                         //
//                                                                            //
//  This source file is subject to the terms of the Mozilla Public License    //
//  version 2. You may not use this file except in compliance with the MPL    //
//  as published by the Mozilla Foundation.                                   //
//                                                                            //
//============================================================================//
package com.sandpolis.core.client.cmd;

import java.util.concurrent.CompletionStage;

import com.sandpolis.core.clientserver.msg.MsgListener.RQ_CreateListener;
import com.sandpolis.core.clientserver.msg.MsgListener.RQ_DeleteListener;
import com.sandpolis.core.clientserver.msg.MsgListener.RS_CreateListener;
import com.sandpolis.core.clientserver.msg.MsgListener.RS_DeleteListener;
import com.sandpolis.core.instance.Listener.ListenerConfig;
import com.sandpolis.core.net.cmdlet.Cmdlet;

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
	public CompletionStage<RS_CreateListener> create(ListenerConfig config) {
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
