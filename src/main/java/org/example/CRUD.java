package org.example;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;


import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.mongodb.MongoClientSettings.getDefaultCodecRegistry;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Sorts.ascending;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;


public class CRUD {
    private static final String uri ="mongodb://ruben:ruben@34.207.224.126:27017/f1-2006\n";


    public static void crearPiloto(Piloto p){
        try(MongoClient mongoClient = MongoClients.create(uri)){
            CodecProvider pojoCodecProvider = PojoCodecProvider.builder().automatic(true).build();
            CodecRegistry pojoCodecRegistry = fromRegistries(getDefaultCodecRegistry(), fromProviders(pojoCodecProvider));

            MongoDatabase database = mongoClient.getDatabase("f1-2006").withCodecRegistry(pojoCodecRegistry);
            MongoCollection<Piloto> coleccionPilotos = database.getCollection("drivers", Piloto.class);

            coleccionPilotos.insertOne(p);

        }
        catch (Exception e){
            e.printStackTrace();
            e.getMessage();
        }
    }

    public static Piloto leerPiloto(int id){
        try(MongoClient mongoClient = MongoClients.create(uri)){
            CodecProvider pojoCodecProvider = PojoCodecProvider.builder().automatic(true).build();
            CodecRegistry pojoCodecRegistry = fromRegistries(getDefaultCodecRegistry(), fromProviders(pojoCodecProvider));

            MongoDatabase database = mongoClient.getDatabase("f1-2006").withCodecRegistry(pojoCodecRegistry);
            MongoCollection<Piloto> coleccionPilotos = database.getCollection("drivers", Piloto.class);

            Piloto piloto = coleccionPilotos.find(eq("driverid",id)).first();
            return piloto;

        }
        catch (Exception e){
            e.printStackTrace();
            e.getMessage();
        }
        return null;
    }

    public static List<Piloto> leerPilotos(){
        try(MongoClient mongoClient = MongoClients.create(uri)){
            CodecProvider pojoCodecProvider = PojoCodecProvider.builder().automatic(true).build();
            CodecRegistry pojoCodecRegistry = fromRegistries(getDefaultCodecRegistry(), fromProviders(pojoCodecProvider));

            MongoDatabase database = mongoClient.getDatabase("f1-2006").withCodecRegistry(pojoCodecRegistry);
            MongoCollection<Piloto> coleccionPilotos = database.getCollection("drivers", Piloto.class);

            List<Piloto> pilotos = coleccionPilotos.find().into(new ArrayList<>());
            return pilotos;

        }
        catch (Exception e){
            e.printStackTrace();
            e.getMessage();
        }
        return null;
    }

    public static void actualizarPiloto(Piloto p) {
        try (MongoClient mongoClient = MongoClients.create(uri)) {
            CodecProvider pojoCodecProvider = PojoCodecProvider.builder().automatic(true).build();
            CodecRegistry pojoCodecRegistry = fromRegistries(getDefaultCodecRegistry(), fromProviders(pojoCodecProvider));

            MongoDatabase database = mongoClient.getDatabase("f1-2006").withCodecRegistry(pojoCodecRegistry);
            MongoCollection<Piloto> coleccionPilotos = database.getCollection("drivers", Piloto.class);

            coleccionPilotos.replaceOne(eq("driverid", p.getDriverid()), p);

        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        }
    }

    public static void borrarPiloto(Piloto p){
        try (MongoClient mongoClient = MongoClients.create(uri)) {
            CodecProvider pojoCodecProvider = PojoCodecProvider.builder().automatic(true).build();
            CodecRegistry pojoCodecRegistry = fromRegistries(getDefaultCodecRegistry(), fromProviders(pojoCodecProvider));

            MongoDatabase database = mongoClient.getDatabase("f1-2006").withCodecRegistry(pojoCodecRegistry);
            MongoCollection<Piloto> coleccionPilotos = database.getCollection("drivers", Piloto.class);

            coleccionPilotos.deleteOne(eq("driverid", p.getDriverid()));

        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        }
    }

    public static void mostrarPilotosOrdenadosPorEdadDescendente() {
        try (MongoClient mongoClient = MongoClients.create(uri)) {
            CodecProvider pojoCodecProvider = PojoCodecProvider.builder().automatic(true).build();
            CodecRegistry pojoCodecRegistry = fromRegistries(getDefaultCodecRegistry(), fromProviders(pojoCodecProvider));

            MongoDatabase database = mongoClient.getDatabase("f1-2006").withCodecRegistry(pojoCodecRegistry);
            MongoCollection<Piloto> coleccionPilotos = database.getCollection("drivers", Piloto.class);

            LocalDate fechaReferencia = LocalDate.of(2006, 1, 1);

            coleccionPilotos.find().sort(ascending("dob")).forEach(piloto -> {
                LocalDate fechaNacimiento = piloto.getDob().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                int edad = Period.between(fechaNacimiento, fechaReferencia).getYears();
                System.out.println(piloto.getForename() + " " + piloto.getSurname() + " " + edad + " años");
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void mostrarPilotosConEdadMayorQue(int edad) {
        try (MongoClient mongoClient = MongoClients.create(uri)) {
            CodecProvider pojoCodecProvider = PojoCodecProvider.builder().automatic(true).build();
            CodecRegistry pojoCodecRegistry = fromRegistries(getDefaultCodecRegistry(), fromProviders(pojoCodecProvider));

            MongoDatabase database = mongoClient.getDatabase("f1-2006").withCodecRegistry(pojoCodecRegistry);
            MongoCollection<Piloto> coleccionPilotos = database.getCollection("drivers", Piloto.class);

            LocalDate fechaReferencia = LocalDate.of(2006, 1, 1);

            System.out.println("Pilotos con edad mayor o igual que " + edad + ":");

            coleccionPilotos.find().sort(ascending("dob")).forEach(p -> {
                LocalDate fechaNacimiento = p.getDob().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                int edadCalculada = Period.between(fechaNacimiento, fechaReferencia).getYears();

                if (edadCalculada >= edad) {
                    System.out.println(p.getForename() + " " + p.getSurname());
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
