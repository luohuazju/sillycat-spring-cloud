package com.sillycat.springboot.restfulapi.akka.base;

import com.sillycat.springboot.restfulapi.akka.msg.OutOfBudgetMsg;
import com.typesafe.config.Config;

import akka.actor.ActorSystem;
import akka.dispatch.PriorityGenerator;
import akka.dispatch.UnboundedPriorityMailbox;

public class PriorityMailbox extends UnboundedPriorityMailbox {

	public PriorityMailbox(ActorSystem.Settings settings, Config config) {

		// Create a new PriorityGenerator, lower priority means more important
		super(new PriorityGenerator() {

			@Override
			public int gen(Object message) {
				if (message instanceof OutOfBudgetMsg) {
					return ((OutOfBudgetMsg) message).getPriority();
				} else {
					// default
					return 100;
				}
			}
		});

	}
}
