const Sequelize = require('sequelize');

const sequelize = require('../util/database');

const Room = sequelize.define('room', {
  id: {
    type: Sequelize.INTEGER,
    autoIncrement: true,
    allowNull: false,
    primaryKey: true,
  },
  name: Sequelize.STRING,
  number: Sequelize.STRING,
  place: Sequelize.STRING,
});

module.exports = Room;
