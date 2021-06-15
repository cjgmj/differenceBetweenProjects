const express = require('express');

const sequelize = require('./util/database');

const { graphqlHTTP } = require('express-graphql');
const graphqlSchema = require('./graphql/schema');
const graphqlResolver = require('./graphql/resolvers');

const User = require('./models/user');
const Room = require('./models/room');
const Booking = require('./models/booking');

const app = express();

// ¿Es necesario?
app.use(express.urlencoded({ extended: false }));
app.use(express.json());

app.use(
  '/graphql',
  graphqlHTTP({
    schema: graphqlSchema,
    rootValue: graphqlResolver,
    graphiql: true,
    customFormatErrorFn(err) {
      if (!err.originalError) {
        return err; // Error por defecto
      }

      const data = err.originalError.data;
      const message = err.message || 'An error occurred.';
      const code = err.originalError.code || 500;

      return { message, status: code, data };
    },
  })
);

Booking.belongsTo(User);
Booking.belongsTo(Room);

sequelize
  .sync()
  .then(() => app.listen(8080))
  .catch((err) => console.log(err));
