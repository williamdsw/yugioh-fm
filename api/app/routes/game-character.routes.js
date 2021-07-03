module.exports = (app) => {
    const controller = require('../controllers/game-character.controller');
    const cardController = require('../controllers/card.controller');
    const router = require('express').Router();
    router.get('/', controller.findAll);
    router.get('/:id', controller.findById);
    router.get('/card/:cardId', cardController.findCharactersByCard);
    app.use('/api/characters', router);
};