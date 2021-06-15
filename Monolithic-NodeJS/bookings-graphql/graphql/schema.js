const { buildSchema } = require('graphql');

module.exports = buildSchema(`
    type Query  {
        findAllUsers: [User!]
        findUsersPaginated(page: Int, size: Int): UserPaged!
        findUserById(userId: Int!): User!
        findUsersFilteredByName(name: String!): [User!]
        findUsersOrderedByName: [User!]
        findUserFilteredByAge(age: Int!): [User!]
        findAllRooms: [Room!]
        findBookingsByRoom(roomId: Int!): [Booking!]
        findBookingsBetweenDates(from: Date!, to: Date!): [Booking!]
        findBookingsByUser(name: String!, surname: String!): [Booking!]
        findBookingsByReasonNull: [Booking!]
        findBookingsAfterDate(date: Date!): [Booking!]
        findBookingsAccepted: [Booking!]
    }

    type Mutation {
        addUser(userInput: UserInput!): User!
        updateUser(userId: Int!, userInput: UserInput!): User!
        deleteUser(userId: Int!): User!
        bookingRoom(bookingInput: BookingInput!): Booking!
    }

    scalar Date

    type Room {
        id: ID!
        name: String!
        number: String!
        place: String!
    }

    type User {
        id: ID!
        name: String!
        surname: String!
        email: String!
        birthdate: Date
        age: Int!
    }

    type UserPaged {
        content: [User!]
        pageable: PageRequest!
        total: Int!
    }

    type Booking {
        id: ID!
        user: User!
        room: Room!
        date: Date!
        reason: String
        accepted: Boolean!
        booking: Date!
    }

    type PageRequest {
        page: Int!
        size: Int!
        sort: Sort
    }

    type Sort {
        orders: [Order]
    }

    type Order {
        direction: String
        property: String!
    }

    input UserInput {
        name: String!
        surname: String!
        email: String!
        birthdate: Date!
        age: Int!
    }

    input BookingInput {
        userId: Int!
        roomId: Int!
        date: Date!
        reason: String!
        accepted: Boolean
    }
`);
