package com.hst.devus.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Copyright 2021 NHN Corp. All rights Reserved.
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 * @author hyungyu.lee@nhn.com
 * @date 2021-05-24
 */
@Component
public class Test implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(Test.class);

	@Override
	public void run(String... args) throws Exception {
		log.info("What the Fuck?");
	}
}
