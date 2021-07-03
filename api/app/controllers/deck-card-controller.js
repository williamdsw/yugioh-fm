const database = require('../models');
const DeckCard = database.deckCard;

module.exports = {
    findCardsIdsByDeck(deckId, doneCallback) {
        if (!deckId || deckId <= 0) {
            doneCallback(false, 'Missing or Invalid Deck Id!');
        } 
        else {
            DeckCard.findAll({
                attributes: ['card_id'],
                where: {
                    deck_id: deckId
                },
                raw: true
            }).then(data => doneCallback(true, data)).catch(error => doneCallback(false, error.Message));
        }
    },
    findDecksIdsByCard(cardId, doneCallback) {
        if (!cardId || cardId <= 0) {
            doneCallback(false, 'Missing or Invalid Card Id!');
        } 
        else {
            DeckCard.findAll({
                attributes: ['deck_id'],
                where: {
                    card_id: cardId
                },
                raw: true
            }).then(data => doneCallback(true, data)).catch(error => doneCallback(false, error.Message));
        }
    }
};