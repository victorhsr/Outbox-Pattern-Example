FROM rabbitmq:3.6.11-management-alpine

ADD rabbitmq.conf /etc/rabbitmq/
ADD definitions.json /etc/rabbitmq/
RUN chown rabbitmq:rabbitmq /etc/rabbitmq/rabbitmq.conf /etc/rabbitmq/definitions.json

EXPOSE 15672
EXPOSE 5672