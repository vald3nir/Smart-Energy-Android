package com.vald3nir.smart_energy.data.repository

import com.mongodb.MongoException
import com.mongodb.kotlin.client.coroutine.MongoClient
import com.mongodb.kotlin.client.coroutine.MongoDatabase
import org.bson.BsonInt64
import org.bson.Document


class MongoAPI {

    fun setup() {
        val connectionString =
            "mongodb+srv://dev:Em4SWKrUDatZ83b@smartenergycluster.jsanh.mongodb.net/EnergyConsumption?retryWrites=true&w=majority"
        val client = MongoClient.create(connectionString = connectionString)

        val databaseName = "sample_restaurants"
        val db: MongoDatabase = client.getDatabase(databaseName = databaseName)
    }

    suspend fun setupConnection(
        databaseName: String = "sample_restaurants",
        connectionEnvVariable: String = "MONGODB_URI"
    ): MongoDatabase? {
        val connectString = if (System.getenv(connectionEnvVariable) != null) {
            System.getenv(connectionEnvVariable)
        } else {
            "mongodb+srv://<usename>:<password>@cluster0.sq3aiau.mongodb.net/?retryWrites=true&w=majority"
        }

        val client = MongoClient.create(connectionString = connectString)
        val database = client.getDatabase(databaseName = databaseName)

        return try {
            // Send a ping to confirm a successful connection
            val command = Document("ping", BsonInt64(1))
            database.runCommand(command)
            println("Pinged your deployment. You successfully connected to MongoDB!")
            database
        } catch (me: MongoException) {
            System.err.println(me)
            null
        }
    }

}