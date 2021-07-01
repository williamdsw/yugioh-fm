const { DataTypes } = require('sequelize');

module.exports = (sequelize) => {
    const Deck = sequelize.define('deck', {
        id: {
            type: DataTypes.INTEGER,
            allowNull: false,
            autoIncrement: true,
            primaryKey: true
        },
    }, { timestamps: false });

    return Deck;
};