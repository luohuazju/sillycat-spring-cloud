#!/bin/sh

PID=$(ps -ef | grep "lib/spring-boot-restful" | grep -v grep | awk '{ print $2 }')

if test -n "${PID}"; then
	sudo kill -9 ${PID};
fi