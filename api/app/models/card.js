const { DataTypes } = require('sequelize');

module.exports = (sequelize) => {
    const Card = sequelize.define('card', {
        id: {
            type: DataTypes.INTEGER,
            allowNull: false,
            autoIncrement: true,
            primaryKey: true
        },
        number: {
            type: DataTypes.STRING,
            allowNull: false,
        },
        name: {
            type: DataTypes.STRING,
            allowNull: false,
        },
        description: {
            type: DataTypes.STRING,
            allowNull: false,
        },
        cardType: {
            type: DataTypes.INTEGER,
            allowNull: false,
            field: 'card_type'
        },
        monsterType: {
            type: DataTypes.INTEGER,
            field: 'monster_type'
        },
        level: DataTypes.INTEGER,
        atk: DataTypes.INTEGER,
        def: DataTypes.INTEGER,
        password: {
            type: DataTypes.STRING,
            allowNull: false,
        },
        starChipCost: {
            type: DataTypes.DOUBLE,
            allowNull: false,
            field: 'star_chip_cost'
        },
        imageUrl: {
            type: DataTypes.STRING,
            allowNull: false,
            field: 'image_url'
        },
    }, { timestamps: false });

    return Card;
};