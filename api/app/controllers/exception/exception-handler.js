
module.exports = (request, response, message) => {
    response.status(404).send({
        timestamp: new Date(),
        status: 404,
        error: 'Not found!',
        message,
        path: request.originalUrl
    });
};