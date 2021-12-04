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

import com.sandpolis.core.instance.cmdlet.Cmdlet;
import com.sandpolis.core.instance.Messages.RQ_StopStream;
import com.sandpolis.core.instance.Messages.RS_StopStream;

/**
 * An API for interacting with streams on the server.
 *
 * @author cilki
 * @since 5.0.2
 */
public class StreamCmd extends Cmdlet<StreamCmd> {

	/**
	 * Stop a given stream.
	 *
	 * @param streamID The ID of the stream to stop
	 * @return An asynchronous {@link CompletionStage}
	 */
	public CompletionStage<RS_StopStream> stop(int streamID) {
		return request(RS_StopStream.class, RQ_StopStream.newBuilder().setId(streamID));
	}

	/**
	 * Prepare for an asynchronous command.
	 *
	 * @return A configurable object from which all asynchronous (nonstatic)
	 *         commands in {@link StreamCmd} can be invoked
	 */
	public static StreamCmd async() {
		return new StreamCmd();
	}

	private StreamCmd() {
	}
}
