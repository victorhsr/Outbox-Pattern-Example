const ampqLocation = `amqp://${process.env.amqp_username}:${process.env.amqp_password}@${process.env.amqp_hostname}:${process.env.amqp_port}`
console.log('tentando conexao', ampqLocation);
const pendingConnection = require('amqplib').connect(ampqLocation);


pendingConnection.then(connection => connection.createChannel())
    .then(channel => {
        channel.assertQueue(process.env.user_queue)
            .then(() => {
                channel.consume(process.env.user_queue, (message) => {
                    const messageContent = JSON.parse(message.content.toString());
                    console.log(`Received message with id: '${messageContent.id}'`);
                    console.log('To have an idempotent operation, we can just look if we already have handled this message id');
                    console.log(`Full message content: ${JSON.stringify(messageContent)}`);
                    channel.ack(message)
                })
            })
    });
