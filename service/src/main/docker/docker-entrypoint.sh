#!/bin/bash

# linking the config container using --link <container-id>:config is injecting
# + environment variable CONFIG_PORT_8888_TCP_PORT
# + hostname config into /etc/hosts
#exec java -jar service-@version@-exec.jar --spring.cloud.config.uri=http://config:$CONFIG_PORT_8888_TCP_PORT

# running the config and the service container in the network cloud
# provides DNS to all containers in this network
# docker network create --driver bridge cloud
exec java -jar service-@version@-exec.jar --spring.cloud.config.uri=http://config:8888