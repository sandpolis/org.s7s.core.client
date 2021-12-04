//============================================================================//
//                                                                            //
//                         Copyright © 2015 Sandpolis                         //
//                                                                            //
//  This source file is subject to the terms of the Mozilla Public License    //
//  version 2. You may not use this file except in compliance with the MPL    //
//  as published by the Mozilla Foundation.                                   //
//                                                                            //
//============================================================================//

plugins {
	id("java-library")
	id("com.sandpolis.build.module")
	id("com.sandpolis.build.protobuf")
	id("com.sandpolis.build.publish")
}

dependencies {
	testImplementation("org.junit.jupiter:junit-jupiter-api:5.+")
	testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.+")

	if (project.getParent() == null) {
		api("com.sandpolis:core.clientagent:+")
		api("com.sandpolis:core.clientserver:+")
		implementation("com.sandpolis:core.instance:+")
	} else {
		api(project(":module:com.sandpolis.core.clientagent"))
		api(project(":module:com.sandpolis.core.clientserver"))
		implementation(project(":module:com.sandpolis.core.instance"))
	}
}
