package com.javeriana.drpaws.proyecto.repositorio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import com.javeriana.drpaws.proyecto.entidad.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;

import jakarta.transaction.Transactional;

@Profile("default")
@Controller
@Transactional
public class DataBaseInit implements ApplicationRunner {

        @Autowired
        MascotaRepository repoMascota;

        @Autowired
        UsuarioRepository repoUsuario;

        @Autowired
        VeterinarioRepository repoVeterinario;

        @Autowired
        MedicamentoRepository repoMedicamento;

        @Autowired
        TratamientoRepository repoTratamiento;

        @Autowired
        AdministradorRepository repoAdministrador;

        @Autowired
        PasswordEncoder passwordEncoder;

        @Autowired
        UserRepository usuarioRepository;

        @Autowired
        RoleRepository roleRepository;

        @Override
        public void run(ApplicationArguments args) throws Exception {

                // Creación de roles
                roleRepository.save(new Role("USUARIO"));
                roleRepository.save(new Role("VETERINARIO"));
                roleRepository.save(new Role("ADMINISTRADOR"));

                // Objetos necesarios
                UserEntity userEntity;

                // --------------------------------------------------------------------------------------------------------------------------------------------------------------------
                // ---- ADMINISTRADOR ----
                List<Administrador> saveAdministradores = new ArrayList<>();
                saveAdministradores.add(new Administrador("admin@drpaws.com", "admin"));

                for (Administrador admin : saveAdministradores) {
                        userEntity = saveUserAdministrador(admin);
                        admin.setUser(userEntity);
                        repoAdministrador.save(admin);
                }

                // --- VETERINARIOS ---

                // ...

                // Create a list to store Veterinario objects
                List<Veterinario> saveVeterinarios = new ArrayList<>();

                // Veterinario #1 - Dr. Juan Perez
                saveVeterinarios.add(new Veterinario("Cardiología", "Dr. Juan Perez", "perezj@email.com", "password1",
                                "path/to/imagevet1")); // 1

                // Veterinario #2 - Dra. Maria Rodriguez
                saveVeterinarios.add(new Veterinario("Cirugía", "Dra. Maria Rodriguez", "rodrim@email.com", "password2",
                                "path/to/imagevet2")); // 2

                // Veterinario #3 - Dr. Carlos Garcia
                saveVeterinarios.add(
                                new Veterinario("Dermatología", "Dr. Carlos Garcia", "garciac@email.com", "password3",
                                                "path/to/imagevet3")); // 3

                // Veterinario #4 - Dra. Laura Lopez
                saveVeterinarios.add(
                                new Veterinario("Oftalmología", "Dra. Laura Lopez", "lopezl@email.com", "password4",
                                                "path/to/imagevet4")); // 4

                // Veterinario #5 - Dr. Pedro Gutierrez
                saveVeterinarios.add(new Veterinario("Ortopedia", "Dr. Pedro Gutierrez", "gutierrezp@email.com",
                                "password5", "path/to/imagevet5")); // 5

                // Veterinario #6 - Dra. Isabel Morales
                saveVeterinarios.add(new Veterinario("Odontología", "Dra. Isabel Morales", "moralesi@email.com",
                                "password6", "path/to/imagevet6")); // 6

                // Veterinario #7 - Dr. Fernando Torres
                saveVeterinarios.add(
                                new Veterinario("Radiología", "Dr. Fernando Torres", "torresf@email.com", "password7",
                                                "path/to/imagevet7")); // 7

                // Veterinario #8 - Dra. Gabriela Soto
                saveVeterinarios.add(new Veterinario("Neurología", "Dra. Gabriela Soto", "sotog@email.com", "password8",
                                "path/to/imagevet8")); // 8

                // Veterinario #9 - Dr. Sergio Mendez
                saveVeterinarios.add(new Veterinario("Endocrinología", "Dr. Sergio Mendez", "mendezs@email.com",
                                "password9", "path/to/imagevet9")); // 9

                // Veterinario #10 - Dra. Rosa Maldonado
                saveVeterinarios.add(new Veterinario("Gastroenterología", "Dra. Rosa Maldonado", "maldonador@email.com",
                                "password10", "path/to/imagevet10")); // 10

                // Veterinario #11 - Dr. Alberto Ruiz
                saveVeterinarios.add(new Veterinario("Oncología", "Dr. Alberto Ruiz", "ruiza@email.com", "password11",
                                "path/to/imagevet11")); // 11

                // Veterinario #12 - Dra. Patricia Ponce
                saveVeterinarios.add(
                                new Veterinario("Urología", "Dra. Patricia Ponce", "poncep@email.com", "password12",
                                                "path/to/imagevet12")); // 12

                // Veterinario #13 - Dr. Rafael Vargas
                saveVeterinarios.add(new Veterinario("Anestesiología", "Dr. Rafael Vargas", "vargasr@email.com",
                                "password13", "path/to/imagevet13")); // 13

                // Veterinario #14 - Dra. Teresa Delgado
                saveVeterinarios.add(new Veterinario("Inmunología", "Dra. Teresa Delgado", "delgadot@email.com",
                                "password14", "path/to/imagevet14")); // 14

                // Veterinario #15 - Dr. Guillermo Navarro
                saveVeterinarios.add(new Veterinario("Hematología", "Dr. Guillermo Navarro", "navarrog@email.com",
                                "password15", "path/to/imagevet15")); // 15

                // Veterinario #16 - Dra. Alicia Ortega
                saveVeterinarios.add(new Veterinario("Fisioterapia", "Dra. Alicia Ortega", "ortegaa@email.com",
                                "password16", "path/to/imagevet16")); // 16

                // Veterinario #17 - Dr. Jorge Pena
                saveVeterinarios.add(new Veterinario("Genética", "Dr. Jorge Pena", "penaj@email.com", "password17",
                                "path/to/imagevet17")); // 17

                // Veterinario #18 - Dra. Carmen Lara
                saveVeterinarios.add(new Veterinario("Geriatría", "Dra. Carmen Lara", "larac@email.com", "password18",
                                "path/to/imagevet18")); // 18

                // Veterinario #19 - Dr. Enrique Dominguez
                saveVeterinarios.add(new Veterinario("Rehabilitación", "Dr. Enrique Dominguez", "domingueze@email.com",
                                "password19", "path/to/imagevet19")); // 19

                // Veterinario #20 - Dra. Monica Rios
                saveVeterinarios.add(new Veterinario("Nutrición", "Dra. Monica Rios", "riosm@email.com", "password20",
                                "path/to/imagevet20")); // 20

                // Loop through the list and save each Veterinario
                for (Veterinario vet : saveVeterinarios) {
                        userEntity = saveUserVeterinario(vet);
                        vet.setUser(userEntity);
                        repoVeterinario.save(vet);
                }

                // --------------------------------------------------------------------------------------------------------------------------------------------------------------------
                // --------------------------------------------------------------------------------------------------------------------------------------------------------------------
                // --------------------------------------------------------------------------------------------------------------------------------------------------------------------

                // USUARIOS
                List<Usuario> saveUsuarios = new ArrayList<>();

                // Usuario #1 - John Doe
                saveUsuarios.add(new Usuario("111111100", "John Doe", "john.doe@example.com", "+57 123 456 7890",
                                "password1", "path/to/imageuser1"));

                // Usuario #2 - Jane Doe
                saveUsuarios.add(new Usuario("111111101", "Jane Doe", "jane.doe@example.com", "+57 123 456 7891",
                                "password2", "path/to/imageuser2"));

                // Usuario #3 - Bob Smith
                saveUsuarios.add(new Usuario("111111102", "Bob Smith", "bob.smith@example.com", "+57 123 456 7892",
                                "password3", "path/to/imageuser3"));

                // Usuario #4 - Alice Johnson
                saveUsuarios.add(new Usuario("111111103", "Alice Johnson", "alice.johnson@example.com",
                                "+57 123 456 7893",
                                "password4", "path/to/imageuser4"));

                // Usuario #5 - Michael Brown
                saveUsuarios.add(new Usuario("111111104", "Michael Brown", "michael.brown@example.com",
                                "+57 123 456 7894",
                                "password5", "path/to/imageuser5"));

                // Usuario #6 - Emily Davis
                saveUsuarios.add(new Usuario("111111105", "Emily Davis", "emily.davis@example.com", "+57 123 456 7895",
                                "password6", "path/to/imageuser6"));

                // Usuario #7 - Christopher Wilson
                saveUsuarios.add(new Usuario("111111106", "Christopher Wilson", "christopher.wilson@example.com",
                                "+57 123 456 7896", "password7", "path/to/imageuser7"));

                // Usuario #8 - Olivia Moore
                saveUsuarios.add(
                                new Usuario("111111107", "Olivia Moore", "olivia.moore@example.com", "+57 123 456 7897",
                                                "password8", "path/to/imageuser8"));

                // Usuario #9 - Daniel Taylor
                saveUsuarios.add(new Usuario("111111108", "Daniel Taylor", "daniel.taylor@example.com",
                                "+57 123 456 7898",
                                "password9", "path/to/imageuser9"));

                // Usuario #10 - Sophia Anderson
                saveUsuarios.add(new Usuario("111111109", "Sophia Anderson", "sophia.anderson@example.com",
                                "+57 123 456 7899", "password10", "path/to/imageuser10"));

                // Usuario #11 - Matthew Thomas
                saveUsuarios.add(new Usuario("111111110", "Matthew Thomas", "matthew.thomas@example.com",
                                "+57 123 456 7800", "password11", "path/to/imageuser11"));

                // Usuario #12 - Ava Jackson
                saveUsuarios.add(new Usuario("111111111", "Ava Jackson", "ava.jackson@example.com", "+57 123 456 7801",
                                "password12", "path/to/imageuser12"));

                // Usuario #13 - Ethan White
                saveUsuarios.add(new Usuario("111111112", "Ethan White", "ethan.white@example.com", "+57 123 456 7802",
                                "password13", "path/to/imageuser13"));

                // Usuario #14 - Emma Harris
                saveUsuarios.add(new Usuario("111111113", "Emma Harris", "emma.harris@example.com", "+57 123 456 7803",
                                "password14", "path/to/imageuser14"));

                // Usuario #15 - Christopher Hall
                saveUsuarios.add(new Usuario("111111114", "Christopher Hall", "christopher.hall@example.com",
                                "+57 123 456 7804", "password15", "path/to/imageuser15"));

                // Usuario #16 - Madison Walker
                saveUsuarios.add(new Usuario("111111115", "Madison Walker", "madison.walker@example.com",
                                "+57 123 456 7805",
                                "password16", "path/to/imageuser16"));

                // Usuario #17 - Joseph Young
                saveUsuarios.add(
                                new Usuario("111111116", "Joseph Young", "joseph.young@example.com", "+57 123 456 7806",
                                                "password17", "path/to/imageuser17"));

                // Usuario #18 - Mia Martinez
                saveUsuarios.add(
                                new Usuario("111111117", "Mia Martinez", "mia.martinez@example.com", "+57 123 456 7807",
                                                "password18", "path/to/imageuser18"));

                // Usuario #19 - James Rodriguez
                saveUsuarios.add(new Usuario("111111118", "James Rodriguez", "james.rodriguez@example.com",
                                "+57 123 456 7808", "password19", "path/to/imageuser19"));

                // Usuario #20 - Sofia Garcia
                saveUsuarios.add(
                                new Usuario("111111119", "Sofia Garcia", "sofia.garcia@example.com", "+57 123 456 7809",
                                                "password20", "path/to/imageuser20"));

                // Usuario #21 - Michael Miller
                saveUsuarios.add(new Usuario("111111120", "Michael Miller", "michael.miller@example.com",
                                "+57 123 456 7810", "password21", "path/to/imageuser21"));

                // Usuario #22 - Emily Davis
                saveUsuarios.add(new Usuario("111111121", "Emily Davis", "emily.davis@example.com", "+57 123 456 7811",
                                "password22", "path/to/imageuser22"));

                // Usuario #23 - David Johnson
                saveUsuarios.add(new Usuario("111111122", "David Johnson", "david.johnson@example.com",
                                "+57 123 456 7812",
                                "password23", "path/to/imageuser23"));

                // Usuario #24 - Emma White
                saveUsuarios.add(new Usuario("111111123", "Emma White", "emma.white@example.com", "+57 123 456 7813",
                                "password24", "path/to/imageuser24"));

                // Usuario #25 - Matthew Wilson
                saveUsuarios.add(new Usuario("111111124", "Matthew Wilson", "matthew.wilson@example.com",
                                "+57 123 456 7814", "password25", "path/to/imageuser25"));

                // Usuario #26 - Gloria Estefan
                saveUsuarios.add(new Usuario("111111125", "Gloria Estefan", "gloria.estefan@example.com",
                                "+57 123 456 7815", "password26", "path/to/imageuser26"));

                // Usuario #27 - Elton John
                saveUsuarios.add(new Usuario("111111126", "Elton John", "elton.john@example.com", "+57 123 456 7816",
                                "password27", "path/to/imageuser27"));

                // Usuario #28 - Jake Gyllenhaal
                saveUsuarios.add(new Usuario("111111127", "Jake Gyllenhaal", "jake.gyllenhaal@example.com",
                                "+57 123 456 7817", "password28", "path/to/imageuser28"));

                // Usuario #29 - Diana Morales
                saveUsuarios.add(new Usuario("111111128", "Diana Morales", "diana.morales@example.com",
                                "+57 123 456 7818",
                                "password29", "path/to/imageuser29"));

                // Usuario #30 - Shakira Ripoll
                saveUsuarios.add(new Usuario("111111129", "Shakira Ripoll", "shakira.ripoll@example.com",
                                "+57 123 456 7819",
                                "password30", "path/to/imageuser30"));

                // Usuario #31 - Michael Fassbender
                saveUsuarios.add(new Usuario("111111130", "Michael Fassbender", "michael.fassbender@example.com",
                                "+57 123 456 7820", "password31", "path/to/imageuser31"));

                // Usuario #32 - Justin Bieber
                saveUsuarios.add(new Usuario("111111131", "Justin Bieber", "justin.bieber@example.com",
                                "+57 123 456 7821",
                                "password32", "path/to/imageuser32"));

                // Usuario #33 - David Guzman
                saveUsuarios.add(
                                new Usuario("111111132", "David Guzman", "david.guzman@example.com", "+57 123 456 7822",
                                                "password33", "path/to/imageuser33"));

                // Usuario #34 - Jennifer Lopez
                saveUsuarios.add(new Usuario("111111133", "Jennifer Lopez", "jennifer.lopez@example.com",
                                "+57 123 456 7823",
                                "password34", "path/to/imageuser34"));

                // Usuario #35 - Gabriel Mora
                saveUsuarios.add(
                                new Usuario("111111134", "Gabriel Mora", "gabriel.mora@example.com", "+57 123 456 7824",
                                                "password35", "path/to/imageuser35"));

                // Usuario #36 - Fernanda Lopes
                saveUsuarios.add(new Usuario("111111135", "Fernanda Lopes", "fernanda.lopes@example.com",
                                "+57 123 456 7825",
                                "password36", "path/to/imageuser36"));

                // Usuario #37 - Christina Aguilera
                saveUsuarios.add(new Usuario("111111136", "Christina Aguilera", "christina.aguilera@example.com",
                                "+57 123 456 7826", "password37", "path/to/imageuser37"));

                // Usuario #38 - Ben Affleck
                saveUsuarios.add(new Usuario("111111137", "Ben Affleck", "ben.affleck@example.com", "+57 123 456 7827",
                                "password38", "path/to/imageuser38"));

                // Usuario #39 - Ed Sheeran
                saveUsuarios.add(new Usuario("111111138", "Ed Sheeran", "ed.sheeran@example.com", "+57 123 456 7828",
                                "password39", "path/to/imageuser39"));

                // Usuario #40 - Fernanda Lopes
                saveUsuarios.add(new Usuario("111111139", "Fernanda Lopes", "fernanda.lopes@example.com",
                                "+57 123 456 7829",
                                "password40", "path/to/imageuser40"));

                // Usuario #41 - Jose Soto
                saveUsuarios.add(new Usuario("111111140", "Jose Soto", "jose.soto@example.com", "+57 123 456 7830",
                                "password41", "path/to/imageuser41"));

                // Usuario #42 - Andres Salamanca
                saveUsuarios.add(new Usuario("111111141", "Andres Salamanca", "andres.salamanca@example.com",
                                "+57 123 456 7831", "password42", "path/to/imageuser42"));

                // Usuario #43 - Paul Rudd
                saveUsuarios.add(new Usuario("111111142", "Paul Rudd", "paul.rudd@example.com", "+57 123 456 7832",
                                "password43", "path/to/imageuser43"));

                // Usuario #44 - Idris Elba
                saveUsuarios.add(new Usuario("111111143", "Idris Elba", "idris.elba@example.com", "+57 123 456 7833",
                                "password44", "path/to/imageuser44"));

                // Usuario #45 - Shawn Mendes
                saveUsuarios.add(
                                new Usuario("111111144", "Shawn Mendes", "shawn.mendes@example.com", "+57 123 456 7834",
                                                "password45", "path/to/imageuser45"));

                // Usuario #46 - Leonardo DiCaprio
                saveUsuarios.add(new Usuario("111111145", "Leonardo DiCaprio", "leonardo.dicaprio@example.com",
                                "+57 123 456 7835", "password46", "path/to/imageuser46"));

                // Usuario #47 - Jose Soto
                saveUsuarios.add(new Usuario("111111146", "Jose Soto", "jose.soto@example.com", "+57 123 456 7836",
                                "password47", "path/to/imageuser47"));

                // Usuario #48 - Tom Cruise
                saveUsuarios.add(new Usuario("111111147", "Tom Cruise", "tom.cruise@example.com", "+57 123 456 7837",
                                "password48", "path/to/imageuser48"));

                // Usuario #49 - Jessie J
                saveUsuarios.add(new Usuario("111111148", "Jessie J", "jessie.j@example.com", "+57 123 456 7838",
                                "password49", "path/to/imageuser49"));

                // Usuario #50 - Ariana Grande
                saveUsuarios.add(new Usuario("111111149", "Ariana Grande", "ariana.grande@example.com",
                                "+57 123 456 7839",
                                "password50", "path/to/imageuser50"));

                // Usuario #51 - Mark Johnson
                saveUsuarios.add(
                                new Usuario("111111150", "Mark Johnson", "mark.johnson@example.com", "+57 123 456 7840",
                                                "password51", "path/to/imageuser51"));

                // Usuario #52 - Natalie Davis
                saveUsuarios.add(new Usuario("111111151", "Natalie Davis", "natalie.davis@example.com",
                                "+57 123 456 7841",
                                "password52", "path/to/imageuser52"));

                // Usuario #53 - Oliver White
                saveUsuarios.add(
                                new Usuario("111111152", "Oliver White", "oliver.white@example.com", "+57 123 456 7842",
                                                "password53", "path/to/imageuser53"));

                // Usuario #54 - Lily Taylor
                saveUsuarios.add(new Usuario("111111153", "Lily Taylor", "lily.taylor@example.com", "+57 123 456 7843",
                                "password54", "path/to/imageuser54"));

                // Usuario #55 - Benjamin Martinez
                saveUsuarios.add(new Usuario("111111154", "Benjamin Martinez", "benjamin.martinez@example.com",
                                "+57 123 456 7844",
                                "password55", "path/to/imageuser55"));

                // Usuario #56 - Zoey Rodriguez
                saveUsuarios.add(new Usuario("111111155", "Zoey Rodriguez", "zoey.rodriguez@example.com",
                                "+57 123 456 7845",
                                "password56", "path/to/imageuser56"));

                // Usuario #57 - Samuel Garcia
                saveUsuarios.add(new Usuario("111111156", "Samuel Garcia", "samuel.garcia@example.com",
                                "+57 123 456 7846",
                                "password57", "path/to/imageuser57"));

                // Usuario #58 - Penelope Anderson
                saveUsuarios.add(new Usuario("111111157", "Penelope Anderson", "penelope.anderson@example.com",
                                "+57 123 456 7847",
                                "password58", "path/to/imageuser58"));

                // Usuario #59 - William Smith
                saveUsuarios.add(new Usuario("111111158", "William Smith", "william.smith@example.com",
                                "+57 123 456 7848",
                                "password59", "path/to/imageuser59"));

                // Usuario #60 - Sophia Johnson
                saveUsuarios.add(new Usuario("111111159", "Sophia Johnson", "sophia.johnson@example.com",
                                "+57 123 456 7849",
                                "password60", "path/to/imageuser60"));

                // Usuario #61 - Samuel Davis
                saveUsuarios.add(
                                new Usuario("111111160", "Samuel Davis", "samuel.davis@example.com", "+57 123 456 7850",
                                                "password61", "path/to/imageuser61"));

                // Usuario #62 - Zoe White
                saveUsuarios.add(new Usuario("111111161", "Zoe White", "zoe.white@example.com", "+57 123 456 7851",
                                "password62", "path/to/imageuser62"));

                // Usuario #63 - Oliver Taylor
                saveUsuarios.add(new Usuario("111111162", "Oliver Taylor", "oliver.taylor@example.com",
                                "+57 123 456 7852",
                                "password63", "path/to/imageuser63"));

                // Usuario #64 - Lily Martinez
                saveUsuarios.add(new Usuario("111111163", "Lily Martinez", "lily.martinez@example.com",
                                "+57 123 456 7853",
                                "password64", "path/to/imageuser64"));

                // Usuario #65 - Benjamin Rodriguez
                saveUsuarios.add(new Usuario("111111164", "Benjamin Rodriguez", "benjamin.rodriguez@example.com",
                                "+57 123 456 7854",
                                "password65", "path/to/imageuser65"));

                // Usuario #66 - Zoey Garcia
                saveUsuarios.add(new Usuario("111111165", "Zoey Garcia", "zoey.garcia@example.com", "+57 123 456 7855",
                                "password66", "path/to/imageuser66"));

                // Usuario #67 - Samuel Anderson
                saveUsuarios.add(new Usuario("111111166", "Samuel Anderson", "samuel.anderson@example.com",
                                "+57 123 456 7856",
                                "password67", "path/to/imageuser67"));

                // Usuario #68 - Penelope Smith
                saveUsuarios.add(new Usuario("111111167", "Penelope Smith", "penelope.smith@example.com",
                                "+57 123 456 7857",
                                "password68", "path/to/imageuser68"));

                // Usuario #69 - William Taylor
                saveUsuarios.add(new Usuario("111111168", "William Taylor", "william.taylor@example.com",
                                "+57 123 456 7858",
                                "password69", "path/to/imageuser69"));

                // Usuario #70 - Sophia Martinez
                saveUsuarios.add(new Usuario("111111169", "Sophia Martinez", "sophia.martinez@example.com",
                                "+57 123 456 7859",
                                "password70", "path/to/imageuser70"));

                // Usuario #71 - Samuel Rodriguez
                saveUsuarios.add(new Usuario("111111170", "Samuel Rodriguez", "samuel.rodriguez@example.com",
                                "+57 123 456 7860",
                                "password71", "path/to/imageuser71"));

                // Usuario #72 - Zoe Garcia
                saveUsuarios.add(new Usuario("111111171", "Zoe Garcia", "zoe.garcia@example.com", "+57 123 456 7861",
                                "password72", "path/to/imageuser72"));

                // Usuario #73 - Oliver Anderson
                saveUsuarios.add(new Usuario("111111172", "Oliver Anderson", "oliver.anderson@example.com",
                                "+57 123 456 7862",
                                "password73", "path/to/imageuser73"));

                // Usuario #74 - Lily Smith
                saveUsuarios.add(new Usuario("111111173", "Lily Smith", "lily.smith@example.com", "+57 123 456 7863",
                                "password74", "path/to/imageuser74"));

                // Usuario #75 - Benjamin Taylor
                saveUsuarios.add(new Usuario("111111174", "Benjamin Taylor", "benjamin.taylor@example.com",
                                "+57 123 456 7864",
                                "password75", "path/to/imageuser75"));

                // Usuario #76 - Zoey Martinez
                saveUsuarios.add(new Usuario("111111175", "Zoey Martinez", "zoey.martinez@example.com",
                                "+57 123 456 7865",
                                "password76", "path/to/imageuser76"));

                // Usuario #77 - Samuel Rodriguez
                saveUsuarios.add(new Usuario("111111176", "Samuel Rodriguez", "samuel.rodriguez@example.com",
                                "+57 123 456 7866",
                                "password77", "path/to/imageuser77"));

                // Usuario #78 - Penelope Garcia
                saveUsuarios.add(new Usuario("111111177", "Penelope Garcia", "penelope.garcia@example.com",
                                "+57 123 456 7867",
                                "password78", "path/to/imageuser78"));

                // Usuario #79 - William Anderson
                saveUsuarios.add(new Usuario("111111178", "William Anderson", "william.anderson@example.com",
                                "+57 123 456 7868",
                                "password79", "path/to/imageuser79"));

                // Usuario #80 - Sophia Smith
                saveUsuarios.add(
                                new Usuario("111111179", "Sophia Smith", "sophia.smith@example.com", "+57 123 456 7869",
                                                "password80", "path/to/imageuser80"));

                // Usuario #81 - Samuel Taylor
                saveUsuarios.add(new Usuario("111111180", "Samuel Taylor", "samuel.taylor@example.com",
                                "+57 123 456 7870",
                                "password81", "path/to/imageuser81"));

                // Usuario #82 - Zoe Martinez
                saveUsuarios.add(
                                new Usuario("111111181", "Zoe Martinez", "zoe.martinez@example.com", "+57 123 456 7871",
                                                "password82", "path/to/imageuser82"));

                // Usuario #83 - Oliver Rodriguez
                saveUsuarios.add(new Usuario("111111182", "Oliver Rodriguez", "oliver.rodriguez@example.com",
                                "+57 123 456 7872",
                                "password83", "path/to/imageuser83"));

                // Usuario #84 - Lily Garcia
                saveUsuarios.add(new Usuario("111111183", "Lily Garcia", "lily.garcia@example.com", "+57 123 456 7873",
                                "password84", "path/to/imageuser84"));

                // Usuario #85 - Benjamin Anderson
                saveUsuarios.add(new Usuario("111111184", "Benjamin Anderson", "benjamin.anderson@example.com",
                                "+57 123 456 7874",
                                "password85", "path/to/imageuser85"));

                // Usuario #86 - Zoey Smith
                saveUsuarios.add(new Usuario("111111185", "Zoey Smith", "zoey.smith@example.com", "+57 123 456 7875",
                                "password86", "path/to/imageuser86"));

                // Usuario #87 - Samuel Taylor
                saveUsuarios.add(new Usuario("111111186", "Samuel Taylor", "samuel.taylor@example.com",
                                "+57 123 456 7876",
                                "password87", "path/to/imageuser87"));

                // Usuario #88 - Penelope Martinez
                saveUsuarios.add(new Usuario("111111187", "Penelope Martinez", "penelope.martinez@example.com",
                                "+57 123 456 7877",
                                "password88", "path/to/imageuser88"));

                // Usuario #89 - William Rodriguez
                saveUsuarios.add(new Usuario("111111188", "William Rodriguez", "william.rodriguez@example.com",
                                "+57 123 456 7878",
                                "password89", "path/to/imageuser89"));

                // Usuario #90 - Sophia Garcia
                saveUsuarios.add(new Usuario("111111189", "Sophia Garcia", "sophia.garcia@example.com",
                                "+57 123 456 7879",
                                "password90", "path/to/imageuser90"));

                // Usuario #91 - Samuel Anderson
                saveUsuarios.add(new Usuario("111111190", "Samuel Anderson", "samuel.anderson@example.com",
                                "+57 123 456 7880",
                                "password91", "path/to/imageuser91"));

                // Usuario #92 - Zoe Smith
                saveUsuarios.add(new Usuario("111111191", "Zoe Smith", "zoe.smith@example.com", "+57 123 456 7881",
                                "password92", "path/to/imageuser92"));

                // Usuario #93 - Oliver Taylor
                saveUsuarios.add(new Usuario("111111192", "Oliver Taylor", "oliver.taylor@example.com",
                                "+57 123 456 7882",
                                "password93", "path/to/imageuser93"));

                // Usuario #94 - Lily Martinez
                saveUsuarios.add(new Usuario("111111193", "Lily Martinez", "lily.martinez@example.com",
                                "+57 123 456 7883",
                                "password94", "path/to/imageuser94"));

                // Usuario #95 - Benjamin Rodriguez
                saveUsuarios.add(new Usuario("111111194", "Benjamin Rodriguez", "benjamin.rodriguez@example.com",
                                "+57 123 456 7884",
                                "password95", "path/to/imageuser95"));

                // Usuario #96 - Zoey Garcia
                saveUsuarios.add(new Usuario("111111195", "Zoey Garcia", "zoey.garcia@example.com", "+57 123 456 7885",
                                "password96", "path/to/imageuser96"));

                // Usuario #97 - Samuel Anderson
                saveUsuarios.add(new Usuario("111111196", "Samuel Anderson", "samuel.anderson@example.com",
                                "+57 123 456 7886",
                                "password97", "path/to/imageuser97"));

                // Usuario #98 - Penelope Smith
                saveUsuarios.add(new Usuario("111111197", "Penelope Smith", "penelope.smith@example.com",
                                "+57 123 456 7887",
                                "password98", "path/to/imageuser98"));

                // Usuario #99 - William Taylor
                saveUsuarios.add(new Usuario("111111198", "William Taylor", "william.taylor@example.com",
                                "+57 123 456 7888",
                                "password99", "path/to/imageuser99"));

                // Usuario #100 - Sophia Martinez
                saveUsuarios.add(new Usuario("111111199", "Sophia Martinez", "sophia.martinez@example.com",
                                "+57 123 456 7889",
                                "password100", "path/to/imageuser100"));

                // Print the list of users
                for (Usuario usuario : saveUsuarios) {
                        userEntity = saveUserUsuario(usuario);
                        usuario.setUser(userEntity);
                        repoUsuario.save(usuario);
                }

                // --------------------------------------------------------------------------------------------------------------------------------------------------------------------
                // --------------------------------------------------------------------------------------------------------------------------------------------------------------------
                // --------------------------------------------------------------------------------------------------------------------------------------------------------------------

                // --- MASCOTAS ---
                // Mascota #1 - Bella

                repoMascota.save(new Mascota("Bella", "Papillon", 13, 54.2f, "Rabia", "path/to/image1"));

                // Mascota #2 - Charlie
                repoMascota.save(
                                new Mascota("Charlie", "German Shepherd", 10, 46.9f, "Distemper (Moquillo canino)",
                                                "path/to/image2"));

                // Mascota #3 - Lucy
                repoMascota.save(new Mascota("Lucy", "English Springer Spaniel", 5, 53.0f, "Sarna (ácaros)",
                                "path/to/image3"));

                // Mascota #4 - Cooper
                repoMascota.save(
                                new Mascota("Cooper", "Yorkshire Terrier", 9, 20.3f, "Enfermedad de Lyme (Borreliosis)",
                                                "path/to/image4"));

                // Mascota #5 - Luna
                repoMascota.save(new Mascota("Luna", "Labrador Retriever", 11, 4.3f, "Sarna (ácaros)",
                                "path/to/image5"));

                // Mascota #6 - Buddy
                repoMascota
                                .save(new Mascota("Buddy", "Collie", 8, 12.6f, "Enfermedad de Lyme (Borreliosis)",
                                                "path/to/image6"));

                // Mascota #7 - Daisy
                repoMascota.save(new Mascota("Daisy", "Havanese", 5, 48.2f,
                                "Traqueobronquitis infecciosa canina (Tos de las perreras)", "path/to/image7"));

                // Mascota #8 - Rocky
                repoMascota.save(
                                new Mascota("Rocky", "Miniature Schnauzer", 1, 45.4f, "Hepatitis infecciosa canina",
                                                "path/to/image8"));

                // Mascota #9 - Lola
                repoMascota.save(
                                new Mascota("Lola", "Miniature Schnauzer", 5, 43.6f, "Hepatitis infecciosa canina",
                                                "path/to/image9"));

                // Mascota #10 - Tucker
                repoMascota.save(new Mascota("Tucker", "Samoyed", 6, 18.5f, "Hepatitis infecciosa canina",
                                "path/to/image10"));

                // Mascota #11 - Sadie
                repoMascota.save(new Mascota("Sadie", "Pembroke Welsh Corgi", 3, 40.1f, "Sarna (ácaros)",
                                "path/to/image11"));

                // Mascota #12 - Bear
                repoMascota.save(new Mascota("Bear", "Chow Chow", 6, 59.0f, "Sarna (ácaros)", "path/to/image12"));

                // Mascota #13 - Moll
                repoMascota.save(new Mascota("Molly", "Labrador Retriever", 10, 36.4f, "Hepatitis infecciosa canina",
                                "path/to/image13"));

                // Mascota #14 - Duke
                repoMascota.save(new Mascota("Duke", "Australian Shepherd", 12, 32.9f, "Leptospirosis",
                                "path/to/image14"));

                // Mascota #15 - Stella
                repoMascota.save(new Mascota("Stella", "Bulldog", 12, 6.7f, "Rabia", "path/to/image15"));

                // Mascota #16 - Oliver
                repoMascota.save(new Mascota("Oliver", "Beagle", 7, 23.4f, "Rabia", "path/to/image16"));

                // Mascota #17 - Zoe
                repoMascota.save(new Mascota("Zoe", "French Bulldog", 14, 34.9f, "Rabia", "path/to/image17"));

                // Mascota #18 - Bentley
                repoMascota.save(new Mascota("Bentley", "Whippet", 4, 52.3f, "Rabia", "path/to/image18"));

                // Mascota #19 - Maggie
                repoMascota
                                .save(new Mascota("Maggie", "Chow Chow", 6, 18.9f, "Hepatitis infecciosa canina",
                                                "path/to/image19"));

                // Mascota #20 - Zeus
                repoMascota.save(new Mascota("Zeus", "Bulldog", 2, 33.7f, "Rabia", "path/to/image20"));

                // Mascota #21 - Rosie
                repoMascota.save(new Mascota("Rosie", "Labrador Retriever", 13, 37.7f,
                                "Traqueobronquitis infecciosa canina (Tos de las perreras)", "path/to/image21"));

                // Mascota #22 - Winston
                repoMascota.save(new Mascota("Winston", "Airedale Terrier", 14, 57.7f, "Sarna (ácaros)",
                                "path/to/image22"));

                // Mascota #23 - Ruby
                repoMascota.save(new Mascota("Ruby", "Doberman Pinscher", 7, 50.0f, "Enfermedad de Lyme (Borreliosis)",
                                "path/to/image23"));

                // Mascota #24 - Toby
                repoMascota.save(
                                new Mascota("Toby", "Boston Terrier", 9, 55.8f, "Distemper (Moquillo canino)",
                                                "path/to/image24"));

                // Mascota #25 - Chloe
                repoMascota.save(new Mascota("Chloe", "Miniature Schnauzer", 6, 51.5f, "Rabia", "path/to/image25"));

                // Mascota #26 - Oscar
                repoMascota.save(new Mascota("Oscar", "Akita", 12, 6.5f, "Distemper (Moquillo canino)",
                                "path/to/image26"));

                // Mascota #27 - Lily
                repoMascota.save(
                                new Mascota("Lily", "Alaskan Malamute", 10, 50.3f, "Hepatitis infecciosa canina",
                                                "path/to/image27"));

                // Mascota #28 - Rusty
                repoMascota.save(
                                new Mascota("Rusty", "Newfoundland", 9, 12.5f, "Parvovirus canino", "path/to/image28"));

                // Mascota #29 - Sophie
                repoMascota.save(
                                new Mascota("Sophie", "French Bulldog", 10, 6.5f, "Sarna (ácaros)", "path/to/image29"));

                // Mascota #30 - Jack
                repoMascota.save(new Mascota("Jack", "Bernese Mountain Dog", 5, 18.8f,
                                "Gusano del corazón (Dirofilaria immitis)", "path/to/image30"));

                // Mascota #31 - Bailey
                repoMascota.save(new Mascota("Bailey", "Brittany", 8, 16.1f, "Gusano del corazón (Dirofilaria immitis)",
                                "path/to/image31"));

                // Mascota #32 - Murphy
                repoMascota.save(
                                new Mascota("Murphy", "Airedale Terrier", 8, 22.4f, "Distemper (Moquillo canino)",
                                                "path/to/image32"));

                // Mascota #33 - Roxy
                repoMascota.save(new Mascota("Roxy", "Samoyed", 10, 47.9f, "Hepatitis infecciosa canina",
                                "path/to/image33"));

                // Mascota #34 - Leo
                repoMascota.save(new Mascota("Leo", "English Springer Spaniel", 5, 53.3f, "Hepatitis infecciosa canina",
                                "path/to/image34"));

                // Mascota #35 - Belle
                repoMascota.save(new Mascota("Belle", "Papillon", 7, 23.5f, "Sarna (ácaros)", "path/to/image35"));

                // Mascota #36 - Teddy
                repoMascota.save(new Mascota("Teddy", "Rhodesian Ridgeback", 8, 2.5f,
                                "Traqueobronquitis infecciosa canina (Tos de las perreras)", "path/to/image36"));

                // Mascota #37 - Milo
                repoMascota.save(
                                new Mascota("Milo", "English Springer Spaniel", 10, 42.0f, "Rabia", "path/to/image37"));

                // Mascota #38 - Zeke
                repoMascota.save(new Mascota("Zeke", "Rhodesian Ridgeback", 6, 32.6f,
                                "Parásitos intestinales (como lombrices)",
                                "path/to/image38"));

                // Mascota #39 - Penny
                repoMascota.save(
                                new Mascota("Penny", "Alaskan Malamute", 6, 39.8f, "Leptospirosis", "path/to/image39"));

                // Mascota #40 - Hank
                repoMascota.save(new Mascota("Hank", "Doberman Pinscher", 12, 32.9f, "Parvovirus canino",
                                "path/to/image40"));

                // Mascota #41 - Zoey
                repoMascota.save(new Mascota("Zoey", "Chow Chow", 15, 17.4f, "Parásitos intestinales (como lombrices)",
                                "path/to/image41"));

                // Mascota #42 - Gus
                repoMascota.save(new Mascota("Gus", "Boston Terrier", 7, 33.6f,
                                "Traqueobronquitis infecciosa canina (Tos de las perreras)", "path/to/image42"));

                // Mascota #43 - Nala
                repoMascota.save(new Mascota("Nala", "Chow Chow", 10, 28.3f, "Rabia", "path/to/image43"));

                // Mascota #44 - Jake
                repoMascota.save(new Mascota("Jake", "Cavalier King Charles Spaniel", 13, 18.4f,
                                "Distemper (Moquillo canino)",
                                "path/to/image44"));

                // Mascota #45 - Emma
                repoMascota.save(new Mascota("Emma", "Brittany", 2, 34.0f, "Rabia", "path/to/image45"));

                // Mascota #46 - Riley
                repoMascota.save(new Mascota("Riley", "Pug", 8, 1.9f, "Rabia", "path/to/image46"));

                // Mascota #47 - Athena
                repoMascota.save(
                                new Mascota("Athena", "Bichon Frise", 0, 31.6f, "Hepatitis infecciosa canina",
                                                "path/to/image47"));

                // Mascota #48 - Cody
                repoMascota.save(new Mascota("Cody", "West Highland White Terrier", 12, 53.0f,
                                "Enfermedad de Lyme (Borreliosis)", "path/to/image48"));

                // Mascota #49 - Abby
                repoMascota.save(
                                new Mascota("Abby", "Basset Hound", 6, 45.8f, "Enfermedad de Lyme (Borreliosis)",
                                                "path/to/image49"));

                // Mascota #50 - Bruno
                repoMascota.save(new Mascota("Bruno", "Havanese", 11, 16.3f, "Distemper (Moquillo canino)",
                                "path/to/image50"));

                // Mascota #51 - Harley
                repoMascota.save(
                                new Mascota("Harley", "Bloodhound", 13, 30.8f, "Enfermedad de Lyme (Borreliosis)",
                                                "path/to/image51"));

                // Mascota #52 - Baxter
                repoMascota.save(new Mascota("Baxter", "Cavalier King Charles Spaniel", 8, 36.3f,
                                "Traqueobronquitis infecciosa canina (Tos de las perreras)", "path/to/image52"));

                // Mascota #53 - Layla
                repoMascota.save(new Mascota("Layla", "Australian Shepherd", 2, 48.3f, "Leptospirosis",
                                "path/to/image53"));

                // Mascota #54 - Henry
                repoMascota.save(new Mascota("Henry", "Maltese", 5, 7.8f, "Hepatitis infecciosa canina",
                                "path/to/image54"));

                // Mascota #55 - Kona
                repoMascota.save(new Mascota("Kona", "Havanese", 5, 14.6f, "Rabia", "path/to/image55"));

                // Mascota #56 - Moose
                repoMascota.save(new Mascota("Moose", "Great Dane", 13, 33.6f, "Parvovirus canino", "path/to/image56"));

                // Mascota #57 - Maddie
                repoMascota.save(new Mascota("Maddie", "Collie", 5, 25.9f, "Leptospirosis", "path/to/image57"));

                // Mascota #58 - Sam
                repoMascota.save(
                                new Mascota("Sam", "Alaskan Malamute", 7, 10.6f, "Hepatitis infecciosa canina",
                                                "path/to/image58"));

                // Mascota #59 - Hazel
                repoMascota.save(new Mascota("Hazel", "Australian Shepherd", 4, 1.5f, "Parvovirus canino",
                                "path/to/image59"));

                // Mascota #60 - Rex
                repoMascota.save(new Mascota("Rex", "Golden Retriever", 5, 26.9f, "Rabia", "path/to/image60"));

                // Mascota #61 - Sasha
                repoMascota.save(new Mascota("Sasha", "Alaskan Malamute", 7, 19.1f,
                                "Parásitos intestinales (como lombrices)",
                                "path/to/image61"));

                // Mascota #62 - Lucky
                repoMascota.save(
                                new Mascota("Lucky", "Boston Terrier", 6, 22.3f, "Hepatitis infecciosa canina",
                                                "path/to/image62"));

                // Mascota #63 - Lilly
                repoMascota.save(new Mascota("Lilly", "Bichon Frise", 1, 44.1f, "Leptospirosis", "path/to/image63"));

                // Mascota #64 - Jackson
                repoMascota
                                .save(new Mascota("Jackson", "Chow Chow", 6, 8.5f, "Hepatitis infecciosa canina",
                                                "path/to/image64"));

                // Mascota #65 - Coco
                repoMascota.save(
                                new Mascota("Coco", "Rottweiler", 3, 37.9f, "Enfermedad de Lyme (Borreliosis)",
                                                "path/to/image65"));

                // Mascota #66 - Finn
                repoMascota.save(new Mascota("Finn", "Basset Hound", 13, 1.9f, "Parvovirus canino", "path/to/image66"));

                // Mascota #67 - Willow
                repoMascota.save(new Mascota("Willow", "Brittany", 9, 35.9f, "Leptospirosis", "path/to/image67"));

                // Mascota #68 - Kobe
                repoMascota.save(new Mascota("Kobe", "Saint Bernard", 3, 25.7f,
                                "Traqueobronquitis infecciosa canina (Tos de las perreras)", "path/to/image68"));

                // Mascota #69 - Lady
                repoMascota.save(new Mascota("Lady", "Papillon", 0, 48.9f, "Sarna (ácaros)", "path/to/image69"));

                // Mascota #70 - Shadow
                repoMascota.save(new Mascota("Shadow", "Dalmatian", 2, 39.0f,
                                "Traqueobronquitis infecciosa canina (Tos de las perreras)", "path/to/image70"));

                // Mascota #71 - Mia
                repoMascota.save(new Mascota("Mia", "Papillon", 13, 2.9f, "Leptospirosis", "path/to/image71"));

                // Mascota #72 - Louie
                repoMascota.save(new Mascota("Louie", "Pembroke Welsh Corgi", 5, 33.5f, "Leptospirosis",
                                "path/to/image72"));

                // Mascota #73 - Ellie
                repoMascota.save(new Mascota("Ellie", "Border Collie", 9, 22.6f, "Parvovirus canino",
                                "path/to/image73"));

                // Mascota #74 - Jasper
                repoMascota.save(new Mascota("Jasper", "Bernese Mountain Dog", 14, 41.0f, "Rabia", "path/to/image74"));

                // Mascota #75 - Cleo
                repoMascota
                                .save(new Mascota("Cleo", "Newfoundland", 6, 37.8f, "Distemper (Moquillo canino)",
                                                "path/to/image75"));

                // Mascota #76 - Diesel
                repoMascota.save(new Mascota("Diesel", "Cocker Spaniel", 2, 52.0f,
                                "Traqueobronquitis infecciosa canina (Tos de las perreras)", "path/to/image76"));

                // Mascota #77 - Piper
                repoMascota.save(new Mascota("Piper", "Cavalier King Charles Spaniel", 14, 26.5f,
                                "Enfermedad de Lyme (Borreliosis)", "path/to/image77"));

                // Mascota #78 - Ollie
                repoMascota.save(
                                new Mascota("Ollie", "Pug", 10, 34.7f, "Parásitos intestinales (como lombrices)",
                                                "path/to/image78"));

                // Mascota #79 - Gracie
                repoMascota.save(new Mascota("Gracie", "Labrador Retriever", 13, 42.4f, "Sarna (ácaros)",
                                "path/to/image79"));

                // Mascota #80 - Marley
                repoMascota.save(new Mascota("Marley", "Cocker Spaniel", 1, 36.2f,
                                "Parásitos intestinales (como lombrices)",
                                "path/to/image80"));

                // Mascota #81 - Roxy
                repoMascota.save(new Mascota("Roxy", "Samoyed", 11, 6.6f, "Leptospirosis", "path/to/image81"));

                // Mascota #82 - Sammy
                repoMascota.save(new Mascota("Sammy", "Australian Shepherd", 2, 26.3f,
                                "Enfermedad de Lyme (Borreliosis)",
                                "path/to/image82"));

                // Mascota #83 - Izzy
                repoMascota.save(new Mascota("Izzy", "Bulldog", 4, 37.4f, "Hepatitis infecciosa canina",
                                "path/to/image83"));

                // Mascota #84 - Scout
                repoMascota.save(
                                new Mascota("Scout", "Border Collie", 10, 30.8f, "Hepatitis infecciosa canina",
                                                "path/to/image84"));

                // Mascota #85 - Ginger
                repoMascota.save(new Mascota("Ginger", "Mastiff", 2, 18.3f, "Parvovirus canino", "path/to/image85"));

                // Mascota #86 - Ace
                repoMascota.save(new Mascota("Ace", "Basset Hound", 7, 22.1f, "Parvovirus canino", "path/to/image86"));

                // Mascota #87 - Dixie
                repoMascota.save(new Mascota("Dixie", "Akita", 13, 48.8f,
                                "Traqueobronquitis infecciosa canina (Tos de las perreras)", "path/to/image87"));

                // Mascota #88 - Hunter
                repoMascota.save(new Mascota("Hunter", "Saint Bernard", 5, 53.2f, "Rabia", "path/to/image88"));

                // Mascota #89 - Peaches
                repoMascota.save(new Mascota("Peaches", "Siberian Husky", 4, 51.4f, "Rabia", "path/to/image89"));

                // Mascota #90 - Bandit
                repoMascota.save(new Mascota("Bandit", "Golden Retriever", 5, 34.6f, "Sarna (ácaros)",
                                "path/to/image90"));

                // Mascota #91 - Poppy
                repoMascota.save(new Mascota("Poppy", "Great Dane", 13, 59.6f, "Parvovirus canino", "path/to/image91"));

                // Mascota #92 - Thor
                repoMascota.save(new Mascota("Thor", "Brittany", 7, 48.3f, "Sarna (ácaros)", "path/to/image92"));

                // Mascota #93 - Honey
                repoMascota.save(new Mascota("Honey", "English Springer Spaniel", 11, 56.6f,
                                "Distemper (Moquillo canino)",
                                "path/to/image93"));

                // Mascota #94 - Spike
                repoMascota.save(new Mascota("Spike", "Vizsla", 11, 38.9f, "Sarna (ácaros)", "path/to/image94"));

                // Mascota #95 - Nova
                repoMascota.save(
                                new Mascota("Nova", "Cocker Spaniel", 4, 33.4f, "Hepatitis infecciosa canina",
                                                "path/to/image95"));

                // Mascota #96 - Tank
                repoMascota.save(new Mascota("Tank", "Dalmatian", 5, 25.8f, "Sarna (ácaros)", "path/to/image96"));

                // Mascota #97 - Callie
                repoMascota.save(new Mascota("Callie", "German Shepherd", 15, 6.1f,
                                "Gusano del corazón (Dirofilaria immitis)",
                                "path/to/image97"));

                // Mascota #98 - Benny
                repoMascota.save(new Mascota("Benny", "Boston Terrier", 10, 29.0f, "Parvovirus canino",
                                "path/to/image98"));

                // Mascota #99 - Princess
                repoMascota.save(
                                new Mascota("Princess", "Rottweiler", 2, 33.6f, "Hepatitis infecciosa canina",
                                                "path/to/image99"));

                // Mascota #100 - Bruce
                repoMascota.save(new Mascota("Bruce", "Samoyed", 11, 4.9f, "Leptospirosis", "path/to/image100"));

                // Mascota #101 - Lexi
                repoMascota.save(new Mascota("Lexi", "Bulldog", 12, 7.0f, "Rabia", "path/to/image101"));

                // Mascota #102 - Maverick
                repoMascota.save(new Mascota("Maverick", "Basset Hound", 15, 2.4f, "Enfermedad de Lyme (Borreliosis)",
                                "path/to/image102"));

                // Mascota #103 - Missy
                repoMascota.save(new Mascota("Missy", "Rottweiler", 2, 30.7f, "Sarna (ácaros)", "path/to/image103"));

                // Mascota #104 - Chester
                repoMascota.save(new Mascota("Chester", "Cavalier King Charles Spaniel", 10, 11.4f,
                                "Parásitos intestinales (como lombrices)", "path/to/image104"));

                // Mascota #105 - Roxie
                repoMascota.save(new Mascota("Roxie", "Border Collie", 0, 15.1f, "Rabia", "path/to/image105"));

                // Mascota #106 - Romeo
                repoMascota.save(new Mascota("Romeo", "Labrador Retriever", 6, 57.5f, "Sarna (ácaros)",
                                "path/to/image106"));

                // Mascota #107 - Snickers
                repoMascota.save(new Mascota("Snickers", "English Springer Spaniel", 10, 29.8f, "Parvovirus canino",
                                "path/to/image107"));

                // Mascota #108 - Frankie
                repoMascota
                                .save(new Mascota("Frankie", "Whippet", 3, 28.8f, "Hepatitis infecciosa canina",
                                                "path/to/image108"));

                // Mascota #109 - Mocha
                repoMascota.save(new Mascota("Mocha", "Boxer", 5, 40.6f, "Leptospirosis", "path/to/image109"));

                // Mascota #110 - Bubba
                repoMascota.save(new Mascota("Bubba", "Shetland Sheepdog", 0, 8.7f, "Enfermedad de Lyme (Borreliosis)",
                                "path/to/image110"));

                // Mascota #111 - Angel
                repoMascota.save(
                                new Mascota("Angel", "Bloodhound", 5, 37.3f, "Enfermedad de Lyme (Borreliosis)",
                                                "path/to/image111"));

                // Mascota #112 - Dexter
                repoMascota.save(new Mascota("Dexter", "Alaskan Malamute", 4, 5.4f, "Enfermedad de Lyme (Borreliosis)",
                                "path/to/image112"));

                // Mascota #113 - Sugar
                repoMascota.save(new Mascota("Sugar", "Weimaraner", 5, 20.1f,
                                "Traqueobronquitis infecciosa canina (Tos de las perreras)", "path/to/image113"));

                // Mascota #114 - Cash
                repoMascota.save(new Mascota("Cash", "Chow Chow", 14, 4.6f, "Distemper (Moquillo canino)",
                                "path/to/image114"));

                // Mascota #115 - Holly
                repoMascota.save(new Mascota("Holly", "Akita", 15, 2.4f, "Hepatitis infecciosa canina",
                                "path/to/image115"));

                // Mascota #116 - George
                repoMascota.save(new Mascota("George", "Beagle", 2, 46.6f,
                                "Traqueobronquitis infecciosa canina (Tos de las perreras)", "path/to/image116"));

                // Mascota #117 - Cupcake
                repoMascota.save(new Mascota("Cupcake", "Basset Hound", 0, 49.7f, "Rabia", "path/to/image117"));

                // Mascota #118 - Roscoe
                repoMascota.save(new Mascota("Roscoe", "Brittany", 1, 43.6f, "Gusano del corazón (Dirofilaria immitis)",
                                "path/to/image118"));

                // Mascota #119 - Sandy
                repoMascota.save(new Mascota("Sandy", "Poodle", 15, 15.4f, "Gusano del corazón (Dirofilaria immitis)",
                                "path/to/image119"));

                // Mascota #120 - Oakley
                repoMascota.save(new Mascota("Oakley", "Afghan Hound", 13, 52.3f,
                                "Parásitos intestinales (como lombrices)",
                                "path/to/image120"));

                // Mascota #121 - Sable
                repoMascota.save(new Mascota("Sable", "Brittany", 4, 33.2f, "Parásitos intestinales (como lombrices)",
                                "path/to/image121"));

                // Mascota #122 - Otis
                repoMascota.save(new Mascota("Otis", "Samoyed", 12, 50.6f, "Rabia", "path/to/image122"));

                // Mascota #123 - Tasha
                repoMascota.save(new Mascota("Tasha", "French Bulldog", 6, 3.9f,
                                "Gusano del corazón (Dirofilaria immitis)",
                                "path/to/image123"));

                // Mascota #124 - Casey
                repoMascota.save(new Mascota("Casey", "Collie", 0, 25.6f, "Rabia", "path/to/image124"));

                // Mascota #125 - Misty
                repoMascota
                                .save(new Mascota("Misty", "Collie", 0, 17.5f, "Enfermedad de Lyme (Borreliosis)",
                                                "path/to/image125"));

                // Mascota #126 - Bucky
                repoMascota.save(new Mascota("Bucky", "Papillon", 13, 14.0f, "Rabia", "path/to/image126"));

                // Mascota #127 - Annie
                repoMascota.save(new Mascota("Annie", "Boxer", 2, 45.9f, "Gusano del corazón (Dirofilaria immitis)",
                                "path/to/image127"));

                // Mascota #128 - Smokey
                repoMascota.save(new Mascota("Smokey", "English Springer Spaniel", 12, 46.4f,
                                "Enfermedad de Lyme (Borreliosis)", "path/to/image128"));

                // Mascota #129 - Gigi
                repoMascota.save(new Mascota("Gigi", "Basset Hound", 10, 50.4f, "Rabia", "path/to/image129"));

                // Mascota #130 - Simba
                repoMascota.save(
                                new Mascota("Simba", "Bloodhound", 0, 59.6f, "Enfermedad de Lyme (Borreliosis)",
                                                "path/to/image130"));

                // Mascota #131 - Cookie
                repoMascota.save(
                                new Mascota("Cookie", "Afghan Hound", 11, 42.8f, "Hepatitis infecciosa canina",
                                                "path/to/image131"));

                // Mascota #132 - Luke
                repoMascota.save(new Mascota("Luke", "Boxer", 8, 9.2f, "Leptospirosis", "path/to/image132"));

                // Mascota #133 - Baby
                repoMascota.save(
                                new Mascota("Baby", "Shetland Sheepdog", 4, 1.8f, "Hepatitis infecciosa canina",
                                                "path/to/image133"));

                // Mascota #134 - Rocco
                repoMascota.save(new Mascota("Rocco", "Shetland Sheepdog", 14, 32.2f,
                                "Parásitos intestinales (como lombrices)",
                                "path/to/image134"));

                // Mascota #135 - Sheba
                repoMascota.save(new Mascota("Sheba", "Chihuahua", 12, 49.1f, "Leptospirosis", "path/to/image135"));

                // Mascota #136 - Harvey
                repoMascota.save(new Mascota("Harvey", "Samoyed", 9, 54.9f, "Hepatitis infecciosa canina",
                                "path/to/image136"));

                // Mascota #137 - Minnie
                repoMascota.save(new Mascota("Minnie", "Yorkshire Terrier", 0, 32.3f, "Distemper (Moquillo canino)",
                                "path/to/image137"));

                // Mascota #138 - Peanut
                repoMascota.save(new Mascota("Peanut", "Alaskan Malamute", 6, 31.4f, "Sarna (ácaros)",
                                "path/to/image138"));

                // Mascota #139 - Snickers
                repoMascota.save(
                                new Mascota("Snickers", "Dachshund", 1, 9.5f, "Parásitos intestinales (como lombrices)",
                                                "path/to/image139"));

                // Mascota #140 - Blue
                repoMascota
                                .save(new Mascota("Blue", "Newfoundland", 7, 56.4f, "Hepatitis infecciosa canina",
                                                "path/to/image140"));

                // Mascota #141 - Cinnamon
                repoMascota.save(new Mascota("Cinnamon", "Weimaraner", 12, 41.8f,
                                "Traqueobronquitis infecciosa canina (Tos de las perreras)", "path/to/image141"));

                // Mascota #142 - Gizmo
                repoMascota.save(new Mascota("Gizmo", "Samoyed", 12, 33.3f, "Distemper (Moquillo canino)",
                                "path/to/image142"));

                // Mascota #143 - Cherry
                repoMascota.save(
                                new Mascota("Cherry", "Maltese", 15, 3.9f, "Enfermedad de Lyme (Borreliosis)",
                                                "path/to/image143"));

                // Mascota #144 - Monty
                repoMascota.save(new Mascota("Monty", "Brittany", 3, 15.9f,
                                "Traqueobronquitis infecciosa canina (Tos de las perreras)", "path/to/image144"));

                // Mascota #145 - Shadow
                repoMascota.save(new Mascota("Shadow", "Collie", 12, 45.4f, "Leptospirosis", "path/to/image145"));

                // Mascota #146 - Rudy
                repoMascota
                                .save(new Mascota("Rudy", "Collie", 9, 55.7f, "Enfermedad de Lyme (Borreliosis)",
                                                "path/to/image146"));

                // Mascota #147 - Hershey
                repoMascota
                                .save(new Mascota("Hershey", "Havanese", 12, 50.8f, "Hepatitis infecciosa canina",
                                                "path/to/image147"));

                // Mascota #148 - Tyson
                repoMascota.save(new Mascota("Tyson", "Bichon Frise", 5, 49.4f, "Parvovirus canino",
                                "path/to/image148"));

                // Mascota #149 - Precious
                repoMascota.save(new Mascota("Precious", "Chow Chow", 0, 41.4f,
                                "Traqueobronquitis infecciosa canina (Tos de las perreras)", "path/to/image149"));

                // Mascota #150 - Samson
                repoMascota.save(new Mascota("Samson", "Great Dane", 5, 44.5f, "Leptospirosis", "path/to/image150"));

                // Mascota #151 - Lucky
                repoMascota.save(new Mascota("Lucky", "Collie", 9, 53.5f, "Gusano del corazón (Dirofilaria immitis)",
                                "path/to/image151"));

                // Mascota #152 - Polo
                repoMascota.save(new Mascota("Polo", "Rottweiler", 13, 42.1f, "Rabia", "path/to/image152"));

                // Mascota #153 - Pepper
                repoMascota.save(new Mascota("Pepper", "Dachshund", 4, 42.2f,
                                "Traqueobronquitis infecciosa canina (Tos de las perreras)", "path/to/image153"));

                // Mascota #154 - Champ
                repoMascota.save(
                                new Mascota("Champ", "West Highland White Terrier", 13, 5.7f, "Parvovirus canino",
                                                "path/to/image154"));

                // Mascota #155 - Caramel
                repoMascota
                                .save(new Mascota("Caramel", "Pembroke Welsh Corgi", 11, 21.0f, "Sarna (ácaros)",
                                                "path/to/image155"));

                // Mascota #156 - Major
                repoMascota.save(new Mascota("Major", "Great Dane", 8, 21.9f,
                                "Traqueobronquitis infecciosa canina (Tos de las perreras)", "path/to/image156"));

                // Mascota #157 - Trixie
                repoMascota.save(new Mascota("Trixie", "Bulldog", 6, 34.4f, "Parvovirus canino", "path/to/image157"));

                // Mascota #158 - Bingo
                repoMascota.save(new Mascota("Bingo", "Papillon", 3, 39.5f, "Parásitos intestinales (como lombrices)",
                                "path/to/image158"));

                // Mascota #159 - Muffin
                repoMascota.save(
                                new Mascota("Muffin", "German Shepherd", 5, 30.3f, "Distemper (Moquillo canino)",
                                                "path/to/image159"));

                // Mascota #160 - Sarge
                repoMascota.save(
                                new Mascota("Sarge", "Mastiff", 4, 30.9f, "Enfermedad de Lyme (Borreliosis)",
                                                "path/to/image160"));

                // Mascota #161 - Brownie
                repoMascota.save(
                                new Mascota("Brownie", "Akita", 6, 58.1f, "Enfermedad de Lyme (Borreliosis)",
                                                "path/to/image161"));

                // Mascota #162 - Nico
                repoMascota
                                .save(new Mascota("Nico", "English Springer Spaniel", 9, 58.9f, "Leptospirosis",
                                                "path/to/image162"));

                // Mascota #163 - Sierra
                repoMascota.save(
                                new Mascota("Sierra", "Afghan Hound", 13, 23.1f, "Hepatitis infecciosa canina",
                                                "path/to/image163"));

                // Mascota #164 - Beau
                repoMascota.save(new Mascota("Beau", "Beagle", 13, 37.7f, "Parásitos intestinales (como lombrices)",
                                "path/to/image164"));

                // Mascota #165 - Bonnie
                repoMascota.save(new Mascota("Bonnie", "Shetland Sheepdog", 14, 40.9f, "Rabia", "path/to/image165"));

                // Mascota #166 - Dusty
                repoMascota.save(new Mascota("Dusty", "Pembroke Welsh Corgi", 13, 58.2f,
                                "Parásitos intestinales (como lombrices)", "path/to/image166"));

                // Mascota #167 - Panda
                repoMascota.save(new Mascota("Panda", "Chihuahua", 11, 33.4f,
                                "Traqueobronquitis infecciosa canina (Tos de las perreras)", "path/to/image167"));

                // Mascota #168 - Bolt
                repoMascota.save(new Mascota("Bolt", "Poodle", 13, 4.8f,
                                "Traqueobronquitis infecciosa canina (Tos de las perreras)", "path/to/image168"));

                // Mascota #169 - Ebony
                repoMascota.save(new Mascota("Ebony", "Airedale Terrier", 2, 57.0f, "Parvovirus canino",
                                "path/to/image169"));

                // Mascota #170 - Brutus
                repoMascota.save(new Mascota("Brutus", "Weimaraner", 1, 36.6f, "Sarna (ácaros)", "path/to/image170"));

                // Mascota #171 - Dolly
                repoMascota
                                .save(new Mascota("Dolly", "Papillon", 11, 19.3f, "Distemper (Moquillo canino)",
                                                "path/to/image171"));

                // Mascota #172 - Boomer
                repoMascota.save(new Mascota("Boomer", "Cavalier King Charles Spaniel", 13, 19.4f,
                                "Hepatitis infecciosa canina", "path/to/image172"));

                // Mascota #173 - Duchess
                repoMascota.save(new Mascota("Duchess", "Border Collie", 5, 59.3f, "Rabia", "path/to/image173"));

                // Mascota #174 - Buddy
                repoMascota
                                .save(new Mascota("Buddy", "Dalmatian", 0, 13.6f, "Distemper (Moquillo canino)",
                                                "path/to/image174"));

                // Mascota #175 - Juno
                repoMascota.save(new Mascota("Juno", "Dalmatian", 10, 21.1f, "Parásitos intestinales (como lombrices)",
                                "path/to/image175"));

                // Mascota #176 - Maximus
                repoMascota.save(new Mascota("Maximus", "Basset Hound", 14, 19.4f, "Parvovirus canino",
                                "path/to/image176"));

                // Mascota #177 - Buttercup
                repoMascota.save(new Mascota("Buttercup", "Australian Shepherd", 4, 29.7f,
                                "Parásitos intestinales (como lombrices)", "path/to/image177"));

                // Mascota #178 - Nugget
                repoMascota.save(new Mascota("Nugget", "Yorkshire Terrier", 13, 51.2f,
                                "Gusano del corazón (Dirofilaria immitis)", "path/to/image178"));

                // Mascota #179 - CassieLilly
                repoMascota.save(new Mascota("CassieLilly", "Pug", 4, 23.5f, "Parásitos intestinales (como lombrices)",
                                "path/to/image179"));

                // Mascota #180 - Jackson
                repoMascota.save(new Mascota("Jackson", "Chow Chow", 12, 43.2f,
                                "Gusano del corazón (Dirofilaria immitis)",
                                "path/to/image180"));

                // Mascota #181 - Coco
                repoMascota.save(new Mascota("Coco", "Rottweiler", 3, 41.6f, "Gusano del corazón (Dirofilaria immitis)",
                                "path/to/image181"));

                // Mascota #182 - Finn
                repoMascota.save(new Mascota("Finn", "Pembroke Welsh Corgi", 13, 24.2f, "Sarna (ácaros)",
                                "path/to/image182"));

                // Mascota #183 - Willow
                repoMascota.save(new Mascota("Willow", "West Highland White Terrier", 13, 49.8f, "Leptospirosis",
                                "path/to/image183"));

                // Mascota #184 - Kobe
                repoMascota.save(new Mascota("Kobe", "Shetland Sheepdog", 2, 25.7f,
                                "Traqueobronquitis infecciosa canina (Tos de las perreras)", "path/to/image184"));

                // Mascota #185 - Lady
                repoMascota.save(new Mascota("Lady", "Chihuahua", 5, 38.3f,
                                "Traqueobronquitis infecciosa canina (Tos de las perreras)", "path/to/image185"));

                // Mascota #186 - Lilly
                repoMascota.save(new Mascota("Lilly", "Shetland Sheepdog", 0, 41.0f, "Enfermedad de Lyme (Borreliosis)",
                                "path/to/image186"));

                // Mascota #187 - Jackson
                repoMascota.save(new Mascota("Jackson", "Bichon Frise", 1, 47.4f,
                                "Gusano del corazón (Dirofilaria immitis)", "path/to/image187"));

                // Mascota #188 - Coco
                repoMascota.save(new Mascota("Coco", "Afghan Hound", 7, 59.9f, "Rabia", "path/to/image188"));

                // Mascota #189 - Finn
                repoMascota.save(new Mascota("Finn", "Border Collie", 6, 23.5f,
                                "Gusano del corazón (Dirofilaria immitis)", "path/to/image189"));

                // Mascota #190 - Willow
                repoMascota.save(new Mascota("Willow", "West Highland White Terrier", 6, 55.4f, "Sarna (ácaros)",
                                "path/to/image190"));

                // Mascota #191 - Kobe
                repoMascota.save(new Mascota("Kobe", "Bichon Frise", 15, 31.5f, "Distemper (Moquillo canino)",
                                "path/to/image191"));

                // Mascota #192 - Lady
                repoMascota.save(new Mascota("Lady", "Airedale Terrier", 10, 6.1f, "Parvovirus canino",
                                "path/to/image192"));

                // Mascota #193 - Nala
                repoMascota.save(new Mascota("Nala", "Newfoundland", 11, 36.8f,
                                "Gusano del corazón (Dirofilaria immitis)", "path/to/image193"));

                // Mascota #194 - Jake
                repoMascota.save(new Mascota("Jake", "Yorkshire Terrier", 11, 34.6f,
                                "Traqueobronquitis infecciosa canina (Tos de las perreras)", "path/to/image194"));

                // Mascota #195 - Emma
                repoMascota.save(new Mascota("Emma", "Border Collie", 1, 2.9f,
                                "Parásitos intestinales (como lombrices)", "path/to/image195"));

                // Mascota #196 - Riley
                repoMascota.save(new Mascota("Riley", "Boston Terrier", 8, 16.8f, "Enfermedad de Lyme (Borreliosis)",
                                "path/to/image196"));

                // Mascota #197 - Athena
                repoMascota.save(new Mascota("Athena", "Rhodesian Ridgeback", 10, 26.8f,
                                "Gusano del corazón (Dirofilaria immitis)", "path/to/image197"));

                // Mascota #198 - Santiago
                repoMascota.save(new Mascota("Santiago", "Shih Tzu", 15, 30.8f, "Distemper (Moquillo canino)",
                                "path/to/image198"));

                // Mascota #199 - Temistocles
                repoMascota.save(new Mascota("Temistocles", "Akita", 9, 55.6f, "Rabia", "path/to/image199"));

                // Mascota #200 - Pericles
                repoMascota.save(new Mascota("Pericles", "Poodle", 14, 35.3f, "Distemper (Moquillo canino)",
                                "path/to/image200"));

                // --------------------------------------------------------------------------------------------------------------------------------------------------------------------
                // --------------------------------------------------------------------------------------------------------------------------------------------------------------------
                // --------------------------------------------------------------------------------------------------------------------------------------------------------------------

                // Extrayendo los medicamentos desde el Excel:
                String csvFile = "static/Archivos Varios/MEDICAMENTOS_VETERINARIA.csv";
                String line;

                // Prueba para encontrar el archivo de medicamentos desde recursos
                // Sirve para no tener problemas con el directorio del usuario que corre el
                // proyecto
                ClassPathResource resource = new ClassPathResource(csvFile);
                InputStream inputStream = resource.getInputStream();

                String csvSplitBy = ";"; // Separador de las celdas, en este caso punto y coma

                try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {

                        // Opcional: omitir la primera línea si es el encabezado
                        br.readLine();

                        // System.out.println("Inicio de la lectura del archivo...");

                        while ((line = br.readLine()) != null) {
                                // System.out.println("Leyendo línea: " + line);

                                String[] medicamentoData = line.split(csvSplitBy);

                                String nombre = medicamentoData[0].replace("\"", "");
                                float precioVenta = Float
                                                .parseFloat(medicamentoData[1].replace("$", "").replace("\"", ""));
                                float precioCompra = Float
                                                .parseFloat(medicamentoData[2].replace("$", "").replace("\"", ""));
                                int unidadesDisponibles = Integer.parseInt(medicamentoData[3].replace("\"", ""));
                                int unidadesVendidas = Integer.parseInt(medicamentoData[4].replace("\"", ""));

                                // System.out.println("Creando objeto Medicamento...");
                                Medicamento medicamento = new Medicamento(nombre, precioVenta, precioCompra,
                                                unidadesDisponibles, unidadesVendidas);
                                repoMedicamento.save(medicamento);
                                // System.out.println("Guardado: " + medicamento.getNombre());
                                // System.out.println("--------------------------------------------------\n");
                        }

                } catch (IOException e) {
                        e.printStackTrace();
                } catch (Exception e) {
                        e.printStackTrace();
                }

                // --------------------------------------------------------------------------------------------------------------------------------------------------------------------
                // --------------------------------------------------------------------------------------------------------------------------------------------------------------------
                // --------------------------------------------------------------------------------------------------------------------------------------------------------------------

                Random random = new Random();

                // Obtener todas las mascotas, veterinarios, y medicamentos de la BD
                List<Mascota> mascotas = repoMascota.findAll();
                List<Veterinario> veterinarios = repoVeterinario.findAll();
                List<Medicamento> medicamentos = repoMedicamento.findAll();

                // Verificar si hay datos suficientes para asociar
                if (mascotas.isEmpty() || veterinarios.isEmpty() || medicamentos.isEmpty()) {
                        throw new IllegalStateException(
                                        "No hay suficientes mascotas/veterinarios/medicamentos en la BD");
                }

                String[] nombresTratamientos = {
                                "Cirugía de Cadera",
                                "Tratamiento Dental",
                                "Vacunación Antirrábica",
                                "Desparasitación",
                                "Quimioterapia",
                                "Radiografía",
                                "Ecografía",
                                "Operación de Tumor",
                                "Amputación",
                                "Cirugía de Ojo"
                };

                String[] descripcionesTratamientos = {
                                "Cirugía de urgencia debido a displasia de cadera",
                                "Limpieza y extracción dental debido a enfermedad periodontal",
                                "Vacunación requerida para prevenir la rabia",
                                "Eliminación de parásitos internos y externos",
                                "Serie de tratamientos para combatir el cáncer",
                                "Imágenes radiográficas para diagnosticar condiciones internas",
                                "Estudio de órganos internos mediante ultrasonido",
                                "Extirpación quirúrgica de un tumor maligno",
                                "Remoción de una extremidad para prevenir la propagación de infecciones o tumores",
                                "Procedimiento quirúrgico para tratar cataratas o lesiones oculares"
                };

                String[] tratamientoFrecuencias = {
                                "Diario",
                                "Semanal",
                                "Mensual",
                                "Trimestral",
                                "Anual",
                                "Según necesidad",
                                "Cada 3 días",
                                "Cada 2 semanas",
                                "Cada 6 meses",
                                "Personalizado"
                };

                // Para asegurar que el primer usuario tenga mascotas con tratamiento
                int indices[] = { 0, 1 };

                for (int i = 0; i < 100; i++) {

                        // Patrón constructor para la clase tratamiento
                        Tratamiento tratamientoEntity;

                        // Datos para crear tratamiento con el patrón
                        String nombreTratamiento, descripcionTratamiento, frecuencia;
                        LocalDate startDate, endDate;
                        float costo;
                        Mascota mascotaTratamiento;
                        Veterinario veterinarioTratamiento;
                        Medicamento medicamentoTratamiento;

                        // Seleccionar nombres y descripciones al azar
                        nombreTratamiento = nombresTratamientos[random.nextInt(nombresTratamientos.length)];
                        descripcionTratamiento = descripcionesTratamientos[random
                                        .nextInt(descripcionesTratamientos.length)];

                        // Seleccionar una fecha de inicio del tratamiento que sea hace un mes para
                        // estadísticas en la página
                        startDate = LocalDate.now().minusMonths(1);
                        System.out.println("startDate: " + startDate);
                        endDate = LocalDate.now();
                        System.out.println("endDate: " + endDate);

                        // Generar un costo aleatorio entre 50.000 y 950.000
                        float randomCost = (random.nextInt(950000 - 50000 + 1) + 50000) / 1000.0f;

                        // Asegurarse de que el formato siempre tiene tres dígitos después del punto
                        // decimal
                        DecimalFormat df = new DecimalFormat("#,000");
                        costo = Float.parseFloat(df.format(randomCost));

                        frecuencia = tratamientoFrecuencias[random.nextInt(tratamientoFrecuencias.length)];

                        // Obtener una mascota, veterinario, y medicamento al azar de las listas.
                        if (i < 2) {
                                // Se va a asginar un tratamiento para una del mascota del primer usuario
                                mascotaTratamiento = mascotas.get(i);
                        } else {
                                mascotaTratamiento = mascotas.get(random.nextInt(mascotas.size()));
                        }
                        veterinarioTratamiento = veterinarios.get(random.nextInt(veterinarios.size()));

                        int index = 0;
                        boolean posible = true;
                        do {
                                index = random.nextInt(medicamentos.size());
                                if (medicamentos.get(index).getUnidadesDisponibles() > 0) {
                                        medicamentos.get(index).setUnidadesDisponibles(
                                                        medicamentos.get(index).getUnidadesDisponibles() - 1);
                                        medicamentos.get(index).setUnidadesVendidas(
                                                        medicamentos.get(index).getUnidadesVendidas() + 1);
                                        posible = true;
                                } else {
                                        posible = false;
                                }
                        } while (!posible);

                        medicamentoTratamiento = medicamentos.get(index);

                        // Patrón constructor de tratamiento
                        tratamientoEntity = Tratamiento.builder().nombre(nombreTratamiento)
                                        .descripcion(descripcionTratamiento)
                                        .fechaInicio(startDate)
                                        .fechaFin(endDate)
                                        .costo(costo)
                                        .frecuencia(frecuencia)
                                        .mascota(mascotaTratamiento)
                                        .veterinario(veterinarioTratamiento)
                                        .medicamento(medicamentoTratamiento)
                                        .build();

                        System.out.println("ID de la mascota");
                        System.out.println(tratamientoEntity.getMascota().getId());
                        System.out.println("Nombre del medicamento");
                        System.out.println(tratamientoEntity.getMedicamento().getNombre());
                        // Guardar el objeto tratamiento en la base de datos.
                        repoTratamiento.save(tratamientoEntity);
                }

                // --------------------------------------------------------------------------------------------------------------------------------------------------------------------
                // --------------------------------------------------------------------------------------------------------------------------------------------------------------------
                // --------------------------------------------------------------------------------------------------------------------------------------------------------------------

                // Retrieve all Usuario objects
                List<Usuario> usuarios = repoUsuario.findAll();

                // Retrieve all Mascota objects
                // Agregado arriba - List<Mascota> mascotas = repoMascota.findAll();

                boolean hacerShuffle = true;

                // Iterate through Usuario objects
                for (Usuario usuario : usuarios) {

                        // Esta condición asegura que el usuario va a recibir mascotas que tienen tratamientos
                        if (hacerShuffle && usuario.getId() > 1) {
                                // Shuffle the list of Mascota objects to randomize their order
                                Collections.shuffle(mascotas);
                                hacerShuffle = false;
                        }
                        // Take the first two Mascota objects from the shuffled list
                        if (mascotas.size() >= 2) {

                                Mascota mascota1 = mascotas.remove(0);
                                Mascota mascota2 = mascotas.remove(0);

                                // Store the Usuario reference in the Mascota objects
                                mascota1.setUsuario(usuario);
                                mascota2.setUsuario(usuario);

                                // Save the updated Mascota objects
                                repoMascota.save(mascota1);
                                repoMascota.save(mascota2);

                        } else {
                                System.out.println("Not enough mascotas to associate with usuarios.");
                                break;
                        }
                }
                System.out.println("\n------------------------------------------------------");
                System.out.println("- - - - - - - - - REPOSITORIO CARGADO - - - - - - - - -");
                System.out.println("------------------------------------------------------\n");
        }

        private UserEntity saveUserVeterinario(Veterinario veterinario) {
                UserEntity userEntity = new UserEntity();
                userEntity.setUsername(veterinario.getEmail());
                userEntity.setPassword(passwordEncoder.encode(veterinario.getPassword()));
                Role roles = roleRepository.findByName("VETERINARIO").get();
                userEntity.setRoles(List.of(roles));
                return usuarioRepository.save(userEntity);
        }

        private UserEntity saveUserUsuario(Usuario usuario) {
                UserEntity userEntity = new UserEntity();
                userEntity.setUsername(usuario.getCedula());
                userEntity.setPassword(passwordEncoder.encode("123"));
                Role roles = roleRepository.findByName("USUARIO").get();
                userEntity.setRoles(List.of(roles));
                return usuarioRepository.save(userEntity);
        }

        private UserEntity saveUserAdministrador(Administrador admin) {
                UserEntity userEntity = new UserEntity();
                userEntity.setUsername(admin.getEmail());
                userEntity.setPassword(passwordEncoder.encode(admin.getPassword()));
                Role roles = roleRepository.findByName("ADMINISTRADOR").get();
                userEntity.setRoles(List.of(roles));
                return usuarioRepository.save(userEntity);
        }
}