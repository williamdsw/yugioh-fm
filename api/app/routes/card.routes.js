module.exports = (app) => {
    const controller = require('../controllers/card.controller');
    const router = require('express').Router();
    router.get('/', controller.findAll);
    router.get('/name', controller.findByName);
    router.get('/deck/:deckId', controller.findAllByDeck);
    app.use('/api/cards', router);
};