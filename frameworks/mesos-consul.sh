#!/bin/sh
echo<<EOF
{
"args": [
"--zk=${MINIMESOS_ZOOKEEPER}",
"--consul=1",
"--consul-ip=${MINIMESOS_CONSUL_IP}"
],  
"container": {
"type": "DOCKER",
"docker": {
"network": "BRIDGE",
"image": "ciscocloud/mesos-consul:latest"
}   
},  
"id": "mesos-consul",
"instances": 1,
"cpus": 0.1,
"mem": 256
}
EOF;
