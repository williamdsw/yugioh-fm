module.exports = (app) => {
    const controller = require('../controllers/game-character.controller');
    const router = require('express').Router();
    router.get('/', controller.findAll);
    router.get('/:id', controller.findById);
    app.use('/api/characters', router);
};