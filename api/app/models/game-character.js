const { DataTypes } = require('sequelize');

module.exports = (sequelize) => {
    const GameCharacter = sequelize.define('game_character', {
        id: {
            type: DataTypes.INTEGER,
            allowNull: false,
            autoIncrement: true,
            primaryKey: true
        },
        name: {
            type: DataTypes.STRING,
            allowNull: false
        },
        imageUrl: {
            type: DataTypes.STRING,
            allowNull: false,
            field: 'image_url'
        }
    }, { timestamps: false });

    return GameCharacter;
};