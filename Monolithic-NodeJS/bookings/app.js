const express = require('express');
const bodyParser = require('body-parser');

const sequelize = require('./util/database');

const User = require('./models/user');
const Room = require('./models/room');
const Booking = require('./models/booking');

const app = express();

const userRoutes = require('./routes/user');
const roomRoutes = require('./routes/room');
const bookingRoutes = require('./routes/booking');

app.use(bodyParser.urlencoded({ extended: false }));
app.use(bodyParser.json());

app.use('/users', userRoutes);
app.use('/rooms', roomRoutes);
app.use('/bookings', bookingRoutes);

Booking.belongsTo(User);
Booking.belongsTo(Room);

sequelize
  .sync()
  .then(() => app.listen(8080))
  .catch((err) => console.log(err));
