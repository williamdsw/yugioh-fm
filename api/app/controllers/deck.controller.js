const formidable = require('formidable');
const exceptionHandler = require('./exception/exception-handler');
const database = require('../models');
const Deck = database.deck;
const Op = database.Sequelize.Op;
const gameCharacterController = require('./game-character.controller');
const deckCardController = require('./deck-card-controller');

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
                } 
                else {
                    gameCharacterController.exists(characterId, (exists) => {
                        if (exists) {
                            Deck.findOne({
                                where: {
                                    character_id: characterId
                                }
                            }).then(data => response.send(data)).catch(error => {
                                const message = error.message || 'Some error occurred while retrieving deck by character!';
                                exceptionHandler(request, response, message);
                            });
                        } 
                        else {
                            exceptionHandler(request, response, `Character with id ${characterId} doesn't exists`);
                        }
                    });
                }
            }
        });
    },
    findDeckIdsByCard(cardId, doneCallback) {
        if (!cardId || cardId <= 0) {
            doneCallback(false, 'Missing or invalid Card Id');
        }
        else {
            deckCardController.findDecksIdsByCard(cardId, (success, content) => {
                if (!success) {
                    doneCallback(false, content.message);
                }
                else {
                    const deckIds = content.map(v => v.deck_id);
                    Deck.findAll({
                        attributes: ['character_id'],
                        where: {
                            id: {
                                [Op.in]: deckIds
                            }
                        }
                    }).then(data => doneCallback(true, data)).catch(error => doneCallback(false, error.Message));
                }
            });
        }
    }
};