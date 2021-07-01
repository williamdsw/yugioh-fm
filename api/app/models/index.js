const config = require('../config/db.config.js');
const Sequelize = require('sequelize');

const sequelize = new Sequelize(config.DATABASE, config.USER, config.PASSWORD, {
    host: config.HOST, dialect: config.dialect, 
    pool: {
        max: config.pool.max,
        min: config.pool.min,
        acquire: config.pool.acquire,
        idle: config.pool.idle,
    }
});

const database = {};
database.Sequelize = Sequelize;
database.sequelize = sequelize;
database.gameCharacter = require('./game-character')(sequelize);
database.deck = require('./deck')(sequelize);
database.card = require('./card')(sequelize);
database.deckCard = require('./deck-card')(sequelize);
database.guardianStar = require('./guardian-star')(sequelize);

// || Associations
database.gameCharacter.hasOne(database.deck, { foreignKey: 'character_id'});
database.deck.belongsTo(database.gameCharacter, { foreignKey: 'character_id'})
database.deck.hasMany(database.deckCard, { foreignKey: 'deck_id'});
database.deckCard.belongsTo(database.deck, { foreignKey: 'deck_id'});
database.card.hasMany(database.deckCard, { foreignKey: 'card_id'});
database.deckCard.belongsTo(database.card, { foreignKey: 'card_id'});
database.card.hasMany(database.guardianStar, { foreignKey: 'card_id'});
database.guardianStar.belongsTo(database.card, { foreignKey: 'card_id'});

module.exports = database;