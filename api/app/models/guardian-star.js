const { DataTypes } = require('sequelize');

module.exports = (sequelize) => {
    const GuardianStar = sequelize.define('guardian_star', {
        guardians: {
            type: DataTypes.INTEGER,
            allowNull: false,
        },
    }, { timestamps: false });

    return GuardianStar;
};