module.exports = (app) => {
    const controller = require('../controllers/deck.controller');
    const router = require('express').Router();
    router.get('/character', controller.findByCharacter);
    app.use('/api/decks', router);
};