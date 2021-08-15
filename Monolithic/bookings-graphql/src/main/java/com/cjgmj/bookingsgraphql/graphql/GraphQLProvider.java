package com.cjgmj.bookingsgraphql.graphql;

import java.io.IOException;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import graphql.schema.idl.TypeRuntimeWiring;
import graphql.schema.idl.errors.SchemaProblem;

@Component
public class GraphQLProvider {

	@Autowired
	private GraphQLDataFetchers graphQLDataFetchers;

	@Value("classpath:schema.graphqls")
	private Resource resource;

	private GraphQL graphQL;

	@PostConstruct
	public void init() throws SchemaProblem, IOException {
		final GraphQLSchema graphQLSchema = this.buildSchema();
		this.graphQL = GraphQL.newGraphQL(graphQLSchema).build();
	}

	private GraphQLSchema buildSchema() throws SchemaProblem, IOException {
		final TypeDefinitionRegistry typeRegistry = new SchemaParser().parse(this.resource.getInputStream());
		final SchemaGenerator schemaGenerator = new SchemaGenerator();

		return schemaGenerator.makeExecutableSchema(typeRegistry, this.buildWiring());
	}

	private RuntimeWiring buildWiring() {
		return RuntimeWiring.newRuntimeWiring().scalar(CustomScalars.LOCAL_DATE_TIME).scalar(CustomScalars.LOCAL_DATE)
				.type(TypeRuntimeWiring.newTypeWiring("Query").dataFetcher("findAllUsers",
						this.graphQLDataFetchers.getFindAllUsersDataFetcher()))
				.type(TypeRuntimeWiring.newTypeWiring("Query").dataFetcher("findUsersPaginated",
						this.graphQLDataFetchers.getFindUsersPaginatedDataFetcher()))
				.type(TypeRuntimeWiring.newTypeWiring("Query").dataFetcher("findUserById",
						this.graphQLDataFetchers.getFindUserByIdDataFetcher()))
				.type(TypeRuntimeWiring.newTypeWiring("Query").dataFetcher("findUsersFilteredByName",
						this.graphQLDataFetchers.getFindUsersFilteredByNameDataFetcher()))
				.type(TypeRuntimeWiring.newTypeWiring("Query").dataFetcher("findUsersOrderedByName",
						this.graphQLDataFetchers.getFindUserOrderedByNameDataFetcher()))
				.type(TypeRuntimeWiring.newTypeWiring("Query").dataFetcher("findUserFilteredByAge",
						this.graphQLDataFetchers.getFindUserFilteredByAgeDataFetcher()))
				.type(TypeRuntimeWiring.newTypeWiring("Query").dataFetcher("findAllRooms",
						this.graphQLDataFetchers.getFindAllRoomsDataFetcher()))
				.type(TypeRuntimeWiring.newTypeWiring("Mutation").dataFetcher("addUser",
						this.graphQLDataFetchers.getAddUserDataFetcher()))
				.type(TypeRuntimeWiring.newTypeWiring("Mutation").dataFetcher("updateUser",
						this.graphQLDataFetchers.getUpdateUserDataFetcher()))
				.type(TypeRuntimeWiring.newTypeWiring("Mutation").dataFetcher("deleteUser",
						this.graphQLDataFetchers.getDeleteUserDataFetcher()))
				.type(TypeRuntimeWiring.newTypeWiring("Mutation").dataFetcher("bookingRoom",
						this.graphQLDataFetchers.getBookingRoomDataFetcher()))
				.type(TypeRuntimeWiring.newTypeWiring("Query").dataFetcher("findBookingsByRoom",
						this.graphQLDataFetchers.getFindBookingsByRoomDataFetcher()))
				.type(TypeRuntimeWiring.newTypeWiring("Query").dataFetcher("findBookingsBetweenDates",
						this.graphQLDataFetchers.getFindBookingsBetweenDatesDataFetcher()))
				.type(TypeRuntimeWiring.newTypeWiring("Query").dataFetcher("findBookingsByUser",
						this.graphQLDataFetchers.getFindBookingsByUserDataFetcher()))
				.type(TypeRuntimeWiring.newTypeWiring("Query").dataFetcher("findBookingsByReasonNull",
						this.graphQLDataFetchers.getFindBookingsByReasonNullDataFetcher()))
				.type(TypeRuntimeWiring.newTypeWiring("Query").dataFetcher("findBookingsAfterDate",
						this.graphQLDataFetchers.getFindBookingsAfterDateDataFetcher()))
				.type(TypeRuntimeWiring.newTypeWiring("Query").dataFetcher("findBookingsAccepted",
						this.graphQLDataFetchers.getFindBookingsAcceptedDataFetcher()))
				.type(TypeRuntimeWiring.newTypeWiring("Booking").dataFetcher("user",
						this.graphQLDataFetchers.getFindBookingUserDataFetcher()))
				.type(TypeRuntimeWiring.newTypeWiring("Booking").dataFetcher("room",
						this.graphQLDataFetchers.getFindBookingRoomDataFetcher()))
				.build();
	}

	@Bean
	public GraphQL graphQL() {
		return this.graphQL;
	}

}
