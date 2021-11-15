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

import static com.google.common.hash.Hashing.sha512;

import java.util.Objects;
import java.util.concurrent.CompletionStage;

import com.google.common.base.Charsets;
import com.sandpolis.core.clientserver.Messages.RQ_Login;
import com.sandpolis.core.clientserver.Messages.RS_Login;
import com.sandpolis.core.net.cmdlet.Cmdlet;

/**
 * An API for logging into and out of the server.
 *
 * @author cilki
 * @since 4.0.0
 */
public final class LoginCmd extends Cmdlet<LoginCmd> {

	/**
	 * Attempt to login to a server.
	 *
	 * @param user The user's username
	 * @param pass The user's plaintext password
	 * @return An asynchronous {@link CompletionStage}
	 */
	public CompletionStage<RS_Login> login(String user, String pass) {
		Objects.requireNonNull(user);
		Objects.requireNonNull(pass);

		return request(RS_Login.class, RQ_Login.newBuilder().setUsername(user)
				// Compute a preliminary hash before PBKDF2 is applied server-side
				.setPassword(sha512().hashString(pass, Charsets.UTF_8).toString()));
	}

	/**
	 * Prepare for an asynchronous command.
	 *
	 * @return A configurable object from which all asynchronous (nonstatic)
	 *         commands in {@link LoginCmd} can be invoked
	 */
	public static LoginCmd async() {
		return new LoginCmd();
	}

	private LoginCmd() {
	}
}
