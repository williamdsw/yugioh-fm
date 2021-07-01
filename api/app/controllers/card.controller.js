const exceptionHandler = require('./exception/exception-handler');
const database = require('../models');
const Card = database.card;
const Op = database.Sequelize.Op;

module.exports = {
    findAll(request, response) {
        Card.findAll().then(data => response.send(data)).catch(error => {
            const message = error.message || 'Some error occurred while retrieving cards!';
            exceptionHandler(request, response, message);
        });
    },
    findByName(request, response) {
        const v = request.query.v;
        const condition = (v ? { name : { [Op.like]: `%${v}%` } } : null);
        Card.findAll({ where: condition }).then(data => response.send(data)).catch(error => {
            const message = error.message || 'Some error occurred while retrieving cards by name!';
            exceptionHandler(request, response, message);
        });
    }
};
