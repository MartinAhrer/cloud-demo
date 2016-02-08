FROM martinahrer/oracle-java8

ADD config-@version@-exec.jar config-@version@-exec.jar
ADD docker-entrypoint.sh docker-entrypoint.sh
RUN chmod 700 docker-entrypoint.sh
EXPOSE 8888

CMD ["./docker-entrypoint.sh"]