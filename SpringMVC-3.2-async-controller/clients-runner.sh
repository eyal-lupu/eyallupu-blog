#!/bin/sh
loopCount=${1-10}
echo Simulating $loopCount clients

for z in $(eval echo {1..$loopCount}) ; do
	curl --max-time 500 http://localhost:8080/get-balance &
done
