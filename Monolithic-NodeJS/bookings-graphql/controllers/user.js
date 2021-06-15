const { Sequelize } = require('sequelize');

const User = require('../models/user');

exports.findAllUsers = async () => {
  return await User.findAll();
};

exports.findUsersPaginated = async ({ page, size }) => {
  const response = {};

  response.content = await User.findAll({
    limit: size,
    offset: size * page,
    order: [['name', 'ASC']],
  });

  response.pageable = {
    page,
    size,
    sort: {
      orders: [
        {
          direction: 'ASC',
          property: 'name',
        },
      ],
    },
  };

  response.total = await User.count();

  return response;
};

exports.findUserById = async ({ userId }) => {
  return await User.findByPk(userId);
};

exports.findUsersFilteredByName = async ({ name }) => {
  return await User.findAll({
    where: {
      [Sequelize.Op.or]: [
        {
          name: {
            [Sequelize.Op.like]: `%${name}%`,
          },
        },
        {
          surname: {
            [Sequelize.Op.like]: `%${name}%`,
          },
        },
      ],
    },
  });
};

exports.findUsersOrderedByName = async () => {
  return await User.findAll({ order: [['name', 'ASC']] });
};

exports.findUserFilteredByAge = async ({ age }) => {
  return User.findAll({
    where: {
      age: {
        [Sequelize.Op.lt]: age,
      },
    },
  });
};

exports.addUser = async ({ userInput }) => {
  const { name, surname, email, birthdate, age } = userInput;

  return User.create({
    name,
    surname,
    email,
    birthdate,
    age,
  });
};

exports.updateUser = async ({ userId, userInput }) => {
  const { name, surname, email, birthdate, age } = userInput;

  return await User.findByPk(userId).then((user) => {
    user.name = name;
    user.surname = surname;
    user.email = email;
    user.birthdate = birthdate;
    user.age = age;

    return user.save();
  });
};

exports.deleteUser = async ({ userId }) => {
  const user = await User.findByPk(userId);
  await User.destroy({ where: { id: userId } });

  return user;
};
