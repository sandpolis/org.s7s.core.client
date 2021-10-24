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

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.SecureRandom;
import java.util.concurrent.CompletionStage;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.KeyGenerator;

import com.sandpolis.core.clientserver.msg.MsgGroup.RQ_CreateGroup;
import com.sandpolis.core.clientserver.msg.MsgGroup.RQ_DeleteGroup;
import com.sandpolis.core.clientserver.msg.MsgGroup.RS_CreateGroup;
import com.sandpolis.core.clientserver.msg.MsgGroup.RS_DeleteGroup;
import com.sandpolis.core.instance.Group.GroupConfig;
import com.sandpolis.core.net.cmdlet.Cmdlet;

/**
 * An API for interacting with authentication groups on the server.
 *
 * @author cilki
 * @since 5.0.0
 */
public final class GroupCmd extends Cmdlet<GroupCmd> {

	/**
	 * Create a new group.
	 *
	 * @param name The group name
	 * @return An asynchronous {@link CompletionStage}
	 */
	public CompletionStage<RS_CreateGroup> create(GroupConfig config) {
		return request(RS_CreateGroup.class, RQ_CreateGroup.newBuilder());
	}

	public CompletionStage<RS_DeleteGroup> remove(String id) {
		return request(RS_DeleteGroup.class, RQ_DeleteGroup.newBuilder());
	}

	public CompletionStage<?> exportToFile(File group, String groupId, String password) throws Exception {
		KeyGenerator keyGen = KeyGenerator.getInstance("AES");
		keyGen.init(new SecureRandom(password.getBytes()));

		Cipher cipher = Cipher.getInstance("AES");
		cipher.init(Cipher.ENCRYPT_MODE, keyGen.generateKey());

		// TODO
		return null;
	}

	public CompletionStage<?> importFromFile(File group, String password) throws Exception {
		KeyGenerator keyGen = KeyGenerator.getInstance("AES");
		keyGen.init(new SecureRandom(password.getBytes()));

		Cipher cipher = Cipher.getInstance("AES");
		cipher.init(Cipher.DECRYPT_MODE, keyGen.generateKey());

		try (InputStream in = new CipherInputStream(new FileInputStream(group), cipher)) {
			GroupConfig container = GroupConfig.parseDelimitedFrom(in);
		}

		// TODO
		return null;
	}

	/**
	 * Prepare for an asynchronous command.
	 *
	 * @return A configurable object from which all asynchronous (nonstatic)
	 *         commands in {@link GroupCmd} can be invoked
	 */
	public static GroupCmd async() {
		return new GroupCmd();
	}

	private GroupCmd() {
	}
}
