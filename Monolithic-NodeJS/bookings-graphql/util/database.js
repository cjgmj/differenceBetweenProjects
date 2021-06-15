const Sequelize = require('sequelize');

const sequelize = new Sequelize('bookings', 'root', '', {
  dialect: 'mysql',
  host: 'localhost',
});

module.exports = sequelize;
