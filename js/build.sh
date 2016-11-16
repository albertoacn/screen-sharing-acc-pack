#!/bin/bash
set -e
task="$1"

if [[ -d opentok.js-screen-sharing ]]
then
	cd opentok.js-screen-sharing
	gulp dist
	gulp zip

else
	echo "Please run this script from 'JS'."
	exit 1
fi

if [ "$task" == "-t" ]; then
        grunt karma:prod
fi
