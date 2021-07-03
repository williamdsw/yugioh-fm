const exceptionHandler = require('./exception/exception-handler');
const database = require('../models');
const Card = database.card;
const GameCharacter = database.gameCharacter;
const Op = database.Sequelize.Op;
const deckCardController = require('./deck-card-controller');
const deckController = require('./deck.controller');

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
    },
    findAllByDeck(request, response) {
        const deckId = request.params.deckId;
        deckCardController.findCardsIdsByDeck(deckId, (success, content) => {
            if (!success) {
                exceptionHandler(request, response, content);
            }
            else {
                const cardsIds = content.map(v => v.card_id);
                Card.findAll({
                    where: {
                        id: {
                            [Op.in]: cardsIds
                        }
                    }
                }).then(data => response.send(data)).catch(error => {
                    const message = error.message || 'Some error occurred while retrieving cards by name!';
                    exceptionHandler(request, response, message);
                });
            }
        });
    },
    findCharactersByCard(request, response) {
        const cardId = request.params.cardId;
        if (!cardId || cardId <= 0) {
            exceptionHandler(request, response, 'Missing or invalid Card Id!');
        } 
        else {
            deckController.findDeckIdsByCard(cardId, (success, content) => {
                if (!success) {
                    exceptionHandler(request, response, content);
                }
                else {
                    const characterIds = content.map(v => v.character_id);
                    GameCharacter.findAll({
                        where: {
                            id: {
                                [Op.in]: characterIds
                            }
                        }
                    }).then(data => response.send(data)).catch(error => {
                        const message = error.message || 'Some error occurred while retrieving Characters by Card Id!';
                        exceptionHandler(request, response, message);
                    });
                }
            });
        }
    }
};
