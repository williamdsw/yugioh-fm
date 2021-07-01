
module.exports = (sequelize) => {
    const DeckCard = sequelize.define('deck_card', {}, { timestamps: false });
    return DeckCard;
};