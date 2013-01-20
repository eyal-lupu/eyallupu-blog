#!/bin/bash
loopCount=$1
: ${loopCount:=10}
echo Simulating $loopCount clients

for z in $(eval echo {1..$loopCount}) ; do
	curl http://localhost:8080/get-balance &
done
