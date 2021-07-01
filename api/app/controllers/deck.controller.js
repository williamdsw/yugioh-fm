const formidable = require('formidable');
const exceptionHandler = require('./exception/exception-handler');
const database = require('../models');
const Deck = database.deck;

module.exports = {
    findByCharacter(request, response) {
        const form = new formidable.IncomingForm();
        form.parse(request, (error, fields) => {
            if (error) {
                exceptionHandler(request, response, error);
            } 
            else {
                const characterId = fields.characterId;
                if (!characterId || characterId <= 0) {
                    exceptionHandler(request, response, 'Missing or invalid Character Id!');
                } else {
                    Deck.findOne({ where: { character_id : characterId }}).then(data => response.send(data)).catch(error => {
                        const message = error.message || 'Some error occurred while retrieving deck by character!';
                        exceptionHandler(request, response, message);
                    });
                }
            }
        });
    }
};