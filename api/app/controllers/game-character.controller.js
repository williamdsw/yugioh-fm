const exceptionHandler = require('./exception/exception-handler');
const database = require('../models');
const Op = database.Sequelize.Op;
const GameCharacter = database.gameCharacter;
const cardController = require('./card.controller');

module.exports = {
    findAll(request, response) {
        GameCharacter.findAll().then(data => response.send(data)).catch(error => {
            const message = error.message || 'Some error occurred while retrieving characters!';
            exceptionHandler(request, response, message);
        });
    },
    findById(request, response) {
        const id = request.params.id;
        if (!id || id <= 0) {
            exceptionHandler(request, response, 'Missing or invalid Character Id!');
        } 
        else {
            GameCharacter.findByPk(id).then(data => {
                if (data != null) {
                    response.send(data);
                }
                else {
                    exceptionHandler(request, response, `Character with id ${id} doesn't exists`);
                }
            }).catch(error => {
                const message = error.message || 'Some error occurred while retrieving Character by Id!';
                exceptionHandler(request, response, message);
            });
        }
    },
    exists(id, doneCallback) {
        if (!id || id <= 0) {
            doneCallback(false);
        } 
        else {
            GameCharacter.findByPk(id).then(data => doneCallback(data != null)).catch(error => doneCallback(false));
        }
    },
    findByDeck(request, response) {
        const id = request.params.id;
        if (!id || id <= 0) {
            exceptionHandler(request, response, 'Missing or invalid Character Id!');
        } 
        else {
            GameCharacter.findByPk(id).then(data => {
                if (data != null) {
                    response.send(data);
                }
                else {
                    exceptionHandler(request, response, `Character with id ${id} doesn't exists`);
                }
            }).catch(error => {
                const message = error.message || 'Some error occurred while retrieving Character by Id!';
                exceptionHandler(request, response, message);
            });
        }
    },
};