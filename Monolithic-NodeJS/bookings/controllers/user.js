const { Sequelize } = require('sequelize');

const User = require('../models/user');

exports.getUsers = (req, res, next) => {
  User.findAll()
    .then((users) => res.json({ users }))
    .catch((err) => console.log(err));
};

exports.getUsersPage = (req, res, next) => {
  const numPage = Number(req.query.numPage);
  const pageSize = Number(req.query.pageSize);

  User.findAll({
    limit: pageSize,
    offset: pageSize * numPage,
  })
    .then((users) => res.json({ users }))
    .catch((err) => console.log(err));
};

exports.getUserById = (req, res, next) => {
  const id = req.params.id;

  User.findByPk(id)
    .then((user) => {
      res.json({ user });
    })
    .catch((err) => console.log(err));
};

exports.getUserLike = (req, res, next) => {
  const text = req.params.text;

  User.findAll({
    where: {
      name: {
        [Sequelize.Op.like]: `%${text}%`,
      },
    },
  })
    .then((users) => res.json({ users }))
    .catch((err) => console.log(err));
};

exports.getUserOrderName = (req, res, next) => {
  User.findAll({ order: [['name', 'ASC']] })
    .then((users) => res.json({ users }))
    .catch((err) => console.log(err));
};

exports.getUserMinor = (req, res, next) => {
  const age = req.params.age;

  User.findAll({
    where: {
      age: {
        [Sequelize.Op.lt]: age,
      },
    },
  })
    .then((users) => res.json(users))
    .catch((err) => console.log(err));
};

exports.postUser = (req, res, next) => {
  const { name, surname, email, birthdate, age } = req.body;

  User.create({
    name,
    surname,
    email,
    birthdate,
    age,
  })
    .then((user) => res.json({ user }))
    .catch((err) => console.log(err));
};

exports.putUser = (req, res, next) => {
  const { id, name, surname, email, birthdate, age } = req.body;

  User.findByPk(id)
    .then((user) => {
      user.name = name;
      user.surname = surname;
      user.email = email;
      user.birthdate = birthdate;
      user.age = age;

      return user.save();
    })
    .then((user) => res.json(user))
    .catch((err) => console.log(err));
};

exports.deleteUser = (req, res, next) => {
  const id = req.params.id;

  User.destroy({ where: { id } })
    .then(() => res.status(204).json())
    .catch((err) => console.log(err));
};
