FROM martinahrer/oracle-java8

ADD service-@version@-exec.jar service-@version@-exec.jar
ADD docker-entrypoint.sh docker-entrypoint.sh
RUN chmod 700 docker-entrypoint.sh

EXPOSE 8080

CMD ["./docker-entrypoint.sh"]