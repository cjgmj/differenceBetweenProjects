const Sequelize = require('sequelize');

const sequelize = require('../util/database');

const Booking = sequelize.define(
  'booking',
  {
    id: {
      type: Sequelize.INTEGER,
      autoIncrement: true,
      allowNull: false,
      primaryKey: true,
    },
    date: Sequelize.DATE,
    reason: Sequelize.STRING,
    accepted: Sequelize.BOOLEAN,
    booking: Sequelize.DATE,
  },
  {
    timestamps: false,
  }
);

module.exports = Booking;
