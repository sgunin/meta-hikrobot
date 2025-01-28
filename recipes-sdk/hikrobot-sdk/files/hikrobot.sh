#!/bin/sh

if [ -e /opt/mvs ]; then
    LD_LIBRARY_PATH=/opt/mvs/lib:/usr/lib

    export LD_LIBRARY_PATH
    export PATH=$PATH:$LD_LIBRARY_PATH
fi
