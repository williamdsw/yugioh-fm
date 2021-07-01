const exceptionHandler = require('./exception/exception-handler');
const database = require('../models');
const GameCharacter = database.gameCharacter;

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
            GameCharacter.findByPk(id).then(data => response.send(data)).catch(error => {
                const message = error.message || 'Some error occurred while retrieving Character by Id!';
                exceptionHandler(request, response, message);
            });
        }
    }
};