package com.javeriana.drpaws.proyecto.repositorio;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import com.javeriana.drpaws.proyecto.entidad.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;

import jakarta.transaction.Transactional;

@Controller
@Transactional
@Profile("default")
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
        RoleRepository roleRepository;

        @Autowired
        UserRepository userRepository;

        @Override
        public void run(ApplicationArguments args) throws Exception {


                // Crear los tres roles
                roleRepository.save(new Role("USUARIO"));
                roleRepository.save(new Role("VETERINARIO"));
                roleRepository.save(new Role("ADMINISTRADOR"));
                
                Veterinario saveVeterinario;
                UserEntity userEntity;

                // Guardar en la tabla de roles
                //1. Crear un objeto
                //2. Guardarlo en la tabla USER
                //3. Agregar al objeto del paso 1, el ID obtenido en el paso 2
                //4. Guardarlo en la tabla Veterinario




                // --------------------------------------------------------------------------------------------------------------------------------------------------------------------
                // ---- ADMINISTRADOR ----
                repoAdministrador.save(new Administrador("admin@drpaws.com", "admin"));

                // --- VETERINARIOS ---
                // Veterinario #1 - Dr. Juan Perez
                saveVeterinario = new Veterinario("Cardiología", "Dr. Juan Perez", "perezj@email.com", "password1",
                                "path/to/imagevet1");
                userEntity = saveUserVeterinario(saveVeterinario);
                saveVeterinario.setUser(userEntity);
                repoVeterinario.save(saveVeterinario);

                // Veterinario #2 - Dra. Maria Rodriguez
                saveVeterinario = new Veterinario("Cirugía", "Dra. Maria Rodriguez", "rodrim@email.com", "password2",
                                "path/to/imagevet2");

                // Veterinario #3 - Dr. Carlos Garcia
                saveVeterinario = new Veterinario("Dermatología", "Dr. Carlos Garcia", "garciac@email.com",
                                "password3", "path/to/imagevet3");

                // Veterinario #4 - Dra. Laura Lopez
                saveVeterinario = new Veterinario("Oftalmología", "Dra. Laura Lopez", "lopezl@email.com",
                                "password4", "path/to/imagevet4");

                // Veterinario #5 - Dr. Pedro Gutierrez
                repoVeterinario.save(new Veterinario("Ortopedia", "Dr. Pedro Gutierrez", "gutierrezp@email.com",
                                "password5", "path/to/imagevet5"));

                // Veterinario #6 - Dra. Isabel Morales
                repoVeterinario.save(new Veterinario("Odontología", "Dra. Isabel Morales", "moralesi@email.com",
                                "password6", "path/to/imagevet6"));

                // Veterinario #7 - Dr. Fernando Torres
                repoVeterinario.save(new Veterinario("Radiología", "Dr. Fernando Torres", "torresf@email.com",
                                "password7", "path/to/imagevet7"));

                // Veterinario #8 - Dra. Gabriela Soto
                repoVeterinario.save(new Veterinario("Neurología", "Dra. Gabriela Soto", "sotog@email.com", "password8",
                                "path/to/imagevet8"));

                // Veterinario #9 - Dr. Sergio Mendez
                repoVeterinario.save(new Veterinario("Endocrinología", "Dr. Sergio Mendez", "mendezs@email.com",
                                "password9", "path/to/imagevet9"));

                // Veterinario #10 - Dra. Rosa Maldonado
                repoVeterinario.save(new Veterinario("Gastroenterología", "Dra. Rosa Maldonado", "maldonador@email.com",
                                "password10", "path/to/imagevet10"));

                // Veterinario #11 - Dr. Alberto Ruiz
                repoVeterinario.save(new Veterinario("Oncología", "Dr. Alberto Ruiz", "ruiza@email.com", "password11",
                                "path/to/imagevet11"));

                // Veterinario #12 - Dra. Patricia Ponce
                repoVeterinario.save(new Veterinario("Urología", "Dra. Patricia Ponce", "poncep@email.com",
                                "password12", "path/to/imagevet12"));

                // Veterinario #13 - Dr. Rafael Vargas
                repoVeterinario.save(new Veterinario("Anestesiología", "Dr. Rafael Vargas", "vargasr@email.com",
                                "password13", "path/to/imagevet13"));

                // Veterinario #14 - Dra. Teresa Delgado
                repoVeterinario.save(new Veterinario("Inmunología", "Dra. Teresa Delgado", "delgadot@email.com",
                                "password14", "path/to/imagevet14"));

                // Veterinario #15 - Dr. Guillermo Navarro
                repoVeterinario.save(new Veterinario("Hematología", "Dr. Guillermo Navarro", "navarrog@email.com",
                                "password15", "path/to/imagevet15"));

                // Veterinario #16 - Dra. Alicia Ortega
                repoVeterinario.save(new Veterinario("Fisioterapia", "Dra. Alicia Ortega", "ortegaa@email.com",
                                "password16", "path/to/imagevet16"));

                // Veterinario #17 - Dr. Jorge Pena
                repoVeterinario.save(new Veterinario("Genética", "Dr. Jorge Pena", "penaj@email.com", "password17",
                                "path/to/imagevet17"));

                // Veterinario #18 - Dra. Carmen Lara
                repoVeterinario.save(new Veterinario("Geriatría", "Dra. Carmen Lara", "larac@email.com", "password18",
                                "path/to/imagevet18"));

                // Veterinario #19 - Dr. Enrique Dominguez
                repoVeterinario.save(new Veterinario("Rehabilitación", "Dr. Enrique Dominguez", "domingueze@email.com",
                                "password19", "path/to/imagevet19"));

                // Veterinario #20 - Dra. Monica Rios
                repoVeterinario.save(new Veterinario("Nutrición", "Dra. Monica Rios", "riosm@email.com", "password20",
                                "path/to/imagevet20"));

                // --------------------------------------------------------------------------------------------------------------------------------------------------------------------
                // --------------------------------------------------------------------------------------------------------------------------------------------------------------------
                // --------------------------------------------------------------------------------------------------------------------------------------------------------------------

                // USUARIOS
                // Usuario #1 - Selena Gomez
                repoUsuario.save(new Usuario("111111100", "Selena Gomez", "selena-gomez@yahoo.com", "+57 269 508 6240",
                                "password1", "path/to/imageuser1"));

                // Usuario #2 - Cristina Peña
                repoUsuario.save(
                                new Usuario("111111101", "Cristina Peña", "cristina-peña@yahoo.com", "+57 540 196 5692",
                                                "password2", "path/to/imageuser2"));

                // Usuario #3 - Reese Witherspoon
                repoUsuario.save(new Usuario("111111102", "Reese Witherspoon", "reese-witherspoon@yahoo.com",
                                "+57 492 051 1235", "password3", "path/to/imageuser3"));

                // Usuario #4 - Bruno Mars
                repoUsuario.save(new Usuario("111111103", "Bruno Mars", "bruno-mars@hotmail.com", "+57 900 657 2603",
                                "password4", "path/to/imageuser4"));

                // Usuario #5 - Phil Collins
                repoUsuario.save(
                                new Usuario("111111104", "Phil Collins", "phil-collins@hotmail.com", "+57 235 239 2334",
                                                "password5", "path/to/imageuser5"));

                // Usuario #6 - Charlie Puth
                repoUsuario.save(new Usuario("111111105", "Charlie Puth", "charlie-puth@gmail.com", "+57 725 485 0559",
                                "password6", "path/to/imageuser6"));

                // Usuario #7 - Prince Rogers
                repoUsuario.save(new Usuario("111111106", "Prince Rogers", "prince-rogers@hotmail.com",
                                "+57 508 549 5570",
                                "password7", "path/to/imageuser7"));

                // Usuario #8 - Henry Cavill
                repoUsuario.save(
                                new Usuario("111111107", "Henry Cavill", "henry-cavill@outlook.com", "+57 009 465 9939",
                                                "password8", "path/to/imageuser8"));

                // Usuario #9 - James Arthur
                repoUsuario.save(
                                new Usuario("111111108", "James Arthur", "james-arthur@outlook.com", "+57 722 621 6258",
                                                "password9", "path/to/imageuser9"));

                // Usuario #10 - Iggy Azalea
                repoUsuario.save(new Usuario("111111109", "Iggy Azalea", "iggy-azalea@outlook.com", "+57 153 883 7972",
                                "password10", "path/to/imageuser10"));

                // Usuario #11 - Celine Dion
                repoUsuario.save(new Usuario("111111110", "Celine Dion", "celine-dion@outlook.com", "+57 255 740 6425",
                                "password11", "path/to/imageuser11"));

                // Usuario #12 - John Legend
                repoUsuario.save(new Usuario("111111111", "John Legend", "john-legend@gmail.com", "+57 524 524 8337",
                                "password12", "path/to/imageuser12"));

                // Usuario #13 - Madonna Ciccone
                repoUsuario.save(new Usuario("111111112", "Madonna Ciccone", "madonna-ciccone@outlook.com",
                                "+57 354 075 6752",
                                "password13", "path/to/imageuser13"));

                // Usuario #14 - Natalie Portman
                repoUsuario.save(new Usuario("111111113", "Natalie Portman", "natalie-portman@hotmail.com",
                                "+57 268 588 1644",
                                "password14", "path/to/imageuser14"));

                // Usuario #15 - Diana Morales
                repoUsuario.save(new Usuario("111111114", "Diana Morales", "diana-morales@hotmail.com",
                                "+57 561 268 1718",
                                "password15", "path/to/imageuser15"));

                // Usuario #16 - Chris Hemsworth
                repoUsuario.save(new Usuario("111111115", "Chris Hemsworth", "chris-hemsworth@gmail.com",
                                "+57 774 728 4449",
                                "password16", "path/to/imageuser16"));

                // Usuario #17 - Robbie Williams
                repoUsuario.save(new Usuario("111111116", "Robbie Williams", "robbie-williams@gmail.com",
                                "+57 453 712 6365",
                                "password17", "path/to/imageuser17"));

                // Usuario #18 - Robbie Williams
                repoUsuario.save(new Usuario("111111117", "Robbie Williams", "robbie-williams@outlook.com",
                                "+57 102 518 0975",
                                "password18", "path/to/imageuser18"));

                // Usuario #19 - Jeremy Renner
                repoUsuario.save(new Usuario("111111118", "Jeremy Renner", "jeremy-renner@hotmail.com",
                                "+57 584 397 7164",
                                "password19", "path/to/imageuser19"));

                // Usuario #20 - Jose Soto
                repoUsuario.save(new Usuario("111111119", "Jose Soto", "jose-soto@yahoo.com", "+57 387 614 6770",
                                "password20",
                                "path/to/imageuser20"));

                // Usuario #21 - Alejandro Salamanca
                repoUsuario.save(new Usuario("111111120", "Alejandro Salamanca", "alejandro-salamanca@outlook.com",
                                "+57 741 768 7901", "password21", "path/to/imageuser21"));

                // Usuario #22 - Paulina Rubio
                repoUsuario.save(
                                new Usuario("111111121", "Paulina Rubio", "paulina-rubio@gmail.com", "+57 318 682 5662",
                                                "password22", "path/to/imageuser22"));

                // Usuario #23 - Chris Evans
                repoUsuario.save(new Usuario("111111122", "Chris Evans", "chris-evans@gmail.com", "+57 617 945 8023",
                                "password23", "path/to/imageuser23"));

                // Usuario #24 - Chris Hemsworth
                repoUsuario.save(new Usuario("111111123", "Chris Hemsworth", "chris-hemsworth@hotmail.com",
                                "+57 965 587 3207",
                                "password24", "path/to/imageuser24"));

                // Usuario #25 - Kylie Minogue
                repoUsuario.save(new Usuario("111111124", "Kylie Minogue", "kylie-minogue@outlook.com",
                                "+57 128 651 8233",
                                "password25", "path/to/imageuser25"));

                // Usuario #26 - Gloria Estefan
                repoUsuario.save(new Usuario("111111125", "Gloria Estefan", "gloria-estefan@hotmail.com",
                                "+57 257 426 7253",
                                "password26", "path/to/imageuser26"));

                // Usuario #27 - Elton John
                repoUsuario.save(new Usuario("111111126", "Elton John", "elton-john@yahoo.com", "+57 087 398 7418",
                                "password27", "path/to/imageuser27"));

                // Usuario #28 - Jake Gyllenhaal
                repoUsuario.save(new Usuario("111111127", "Jake Gyllenhaal", "jake-gyllenhaal@outlook.com",
                                "+57 892 259 1975",
                                "password28", "path/to/imageuser28"));

                // Usuario #29 - Diana Morales
                repoUsuario.save(new Usuario("111111128", "Diana Morales", "diana-morales@hotmail.com",
                                "+57 250 314 0277",
                                "password29", "path/to/imageuser29"));

                // Usuario #30 - Shakira Ripoll
                repoUsuario.save(new Usuario("111111129", "Shakira Ripoll", "shakira-ripoll@gmail.com",
                                "+57 293 503 4739",
                                "password30", "path/to/imageuser30"));

                // Usuario #31 - Michael Fassbender
                repoUsuario.save(new Usuario("111111130", "Michael Fassbender", "michael-fassbender@outlook.com",
                                "+57 351 684 4230", "password31", "path/to/imageuser31"));

                // Usuario #32 - Justin Bieber
                repoUsuario.save(
                                new Usuario("111111131", "Justin Bieber", "justin-bieber@gmail.com", "+57 756 981 1661",
                                                "password32", "path/to/imageuser32"));

                // Usuario #33 - David Guzman
                repoUsuario.save(new Usuario("111111132", "David Guzman", "david-guzman@gmail.com", "+57 838 403 2528",
                                "password33", "path/to/imageuser33"));

                // Usuario #34 - Jennifer Lopez
                repoUsuario.save(new Usuario("111111133", "Jennifer Lopez", "jennifer-lopez@gmail.com",
                                "+57 137 135 6808",
                                "password34", "path/to/imageuser34"));

                // Usuario #35 - Gabriel Mora
                repoUsuario.save(new Usuario("111111134", "Gabriel Mora", "gabriel-mora@yahoo.com", "+57 688 196 5293",
                                "password35", "path/to/imageuser35"));

                // Usuario #36 - Fernanda Lopes
                repoUsuario.save(new Usuario("111111135", "Fernanda Lopes", "fernanda-lopes@gmail.com",
                                "+57 825 272 4721",
                                "password36", "path/to/imageuser36"));

                // Usuario #37 - Christina Aguilera
                repoUsuario.save(new Usuario("111111136", "Christina Aguilera", "christina-aguilera@outlook.com",
                                "+57 516 136 5571", "password37", "path/to/imageuser37"));

                // Usuario #38 - Ben Affleck
                repoUsuario.save(new Usuario("111111137", "Ben Affleck", "ben-affleck@hotmail.com", "+57 550 985 7774",
                                "password38", "path/to/imageuser38"));

                // Usuario #39 - Ed Sheeran
                repoUsuario.save(new Usuario("111111138", "Ed Sheeran", "ed-sheeran@gmail.com", "+57 238 569 6440",
                                "password39", "path/to/imageuser39"));

                // Usuario #40 - Fernanda Lopes
                repoUsuario.save(new Usuario("111111139", "Fernanda Lopes", "fernanda-lopes@yahoo.com",
                                "+57 328 098 4121",
                                "password40", "path/to/imageuser40"));

                // Usuario #41 - Jose Soto
                repoUsuario.save(new Usuario("111111140", "Jose Soto", "jose-soto@yahoo.com", "+57 811 996 9728",
                                "password41",
                                "path/to/imageuser41"));

                // Usuario #42 - Andres Salamanca
                repoUsuario.save(new Usuario("111111141", "Andres Salamanca", "andres-salamanca@yahoo.com",
                                "+57 561 586 2136",
                                "password42", "path/to/imageuser42"));

                // Usuario #43 - Paul Rudd
                repoUsuario.save(new Usuario("111111142", "Paul Rudd", "paul-rudd@gmail.com", "+57 680 017 6889",
                                "password43",
                                "path/to/imageuser43"));

                // Usuario #44 - Idris Elba
                repoUsuario.save(new Usuario("111111143", "Idris Elba", "idris-elba@outlook.com", "+57 600 216 9869",
                                "password44", "path/to/imageuser44"));

                // Usuario #45 - Shawn Mendes
                repoUsuario.save(new Usuario("111111144", "Shawn Mendes", "shawn-mendes@yahoo.com", "+57 806 491 6857",
                                "password45", "path/to/imageuser45"));

                // Usuario #46 - Leonardo DiCaprio
                repoUsuario.save(new Usuario("111111145", "Leonardo DiCaprio", "leonardo-dicaprio@yahoo.com",
                                "+57 163 447 1060", "password46", "path/to/imageuser46"));

                // Usuario #47 - Jose Soto
                repoUsuario.save(new Usuario("111111146", "Jose Soto", "jose-soto@gmail.com", "+57 491 724 5350",
                                "password47",
                                "path/to/imageuser47"));

                // Usuario #48 - Tom Cruise
                repoUsuario.save(new Usuario("111111147", "Tom Cruise", "tom-cruise@yahoo.com", "+57 407 632 2211",
                                "password48", "path/to/imageuser48"));

                // Usuario #49 - Jessie J
                repoUsuario.save(new Usuario("111111148", "Jessie J", "jessie-j@hotmail.com", "+57 789 745 8069",
                                "password49",
                                "path/to/imageuser49"));

                // Usuario #50 - Ariana Grande
                repoUsuario.save(new Usuario("111111149", "Ariana Grande", "ariana-grande@hotmail.com",
                                "+57 911 194 4887",
                                "password50", "path/to/imageuser50"));

                // Usuario #51 - Michael Fassbender
                repoUsuario.save(new Usuario("111111150", "Michael Fassbender", "michael-fassbender@gmail.com",
                                "+57 915 217 9328", "password51", "path/to/imageuser51"));

                // Usuario #52 - Enrique Iglesias
                repoUsuario.save(new Usuario("111111151", "Enrique Iglesias", "enrique-iglesias@hotmail.com",
                                "+57 602 278 8027", "password52", "path/to/imageuser52"));

                // Usuario #53 - Taylor Swift
                repoUsuario.save(
                                new Usuario("111111152", "Taylor Swift", "taylor-swift@outlook.com", "+57 195 995 5240",
                                                "password53", "path/to/imageuser53"));

                // Usuario #54 - Sergio Aguilar
                repoUsuario.save(new Usuario("111111153", "Sergio Aguilar", "sergio-aguilar@outlook.com",
                                "+57 173 073 5783",
                                "password54", "path/to/imageuser54"));

                // Usuario #55 - Luis Miguel
                repoUsuario.save(new Usuario("111111154", "Luis Miguel", "luis-miguel@hotmail.com", "+57 505 315 8612",
                                "password55", "path/to/imageuser55"));

                // Usuario #56 - Sergio Aguilar
                repoUsuario.save(new Usuario("111111155", "Sergio Aguilar", "sergio-aguilar@yahoo.com",
                                "+57 830 810 7924",
                                "password56", "path/to/imageuser56"));

                // Usuario #57 - John Legend
                repoUsuario.save(new Usuario("111111156", "John Legend", "john-legend@gmail.com", "+57 080 346 8830",
                                "password57", "path/to/imageuser57"));

                // Usuario #58 - Madonna Ciccone
                repoUsuario.save(new Usuario("111111157", "Madonna Ciccone", "madonna-ciccone@hotmail.com",
                                "+57 217 218 0208",
                                "password58", "path/to/imageuser58"));

                // Usuario #59 - Jessie J
                repoUsuario.save(new Usuario("111111158", "Jessie J", "jessie-j@gmail.com", "+57 046 402 5878",
                                "password59",
                                "path/to/imageuser59"));

                // Usuario #60 - Miley Cyrus
                repoUsuario.save(new Usuario("111111159", "Miley Cyrus", "miley-cyrus@gmail.com", "+57 251 107 5561",
                                "password60", "path/to/imageuser60"));

                // Usuario #61 - Kate Winslet
                repoUsuario.save(new Usuario("111111160", "Kate Winslet", "kate-winslet@gmail.com", "+57 506 766 7150",
                                "password61", "path/to/imageuser61"));

                // Usuario #62 - Zayn Malik
                repoUsuario.save(new Usuario("111111161", "Zayn Malik", "zayn-malik@gmail.com", "+57 967 376 4610",
                                "password62", "path/to/imageuser62"));

                // Usuario #63 - Kate Winslet
                repoUsuario.save(new Usuario("111111162", "Kate Winslet", "kate-winslet@yahoo.com", "+57 134 337 1006",
                                "password63", "path/to/imageuser63"));

                // Usuario #64 - Paula Bermudez
                repoUsuario.save(new Usuario("111111163", "Paula Bermudez", "paula-bermudez@yahoo.com",
                                "+57 300 799 0051",
                                "password64", "path/to/imageuser64"));

                // Usuario #65 - Jennifer Lopez
                repoUsuario.save(new Usuario("111111164", "Jennifer Lopez", "jennifer-lopez@hotmail.com",
                                "+57 147 355 3937",
                                "password65", "path/to/imageuser65"));

                // Usuario #66 - Jay Z Carter
                repoUsuario.save(new Usuario("111111165", "Jay Z Carter", "jay-z@outlook.com", "+57 127 266 1892",
                                "password66",
                                "path/to/imageuser66"));

                // Usuario #67 - Felipe Castro
                repoUsuario.save(
                                new Usuario("111111166", "Felipe Castro", "felipe-castro@yahoo.com", "+57 376 814 4341",
                                                "password67", "path/to/imageuser67"));

                // Usuario #68 - Chris Hemsworth
                repoUsuario.save(new Usuario("111111167", "Chris Hemsworth", "chris-hemsworth@outlook.com",
                                "+57 277 133 1176",
                                "password68", "path/to/imageuser68"));

                // Usuario #69 - Leonardo DiCaprio
                repoUsuario.save(new Usuario("111111168", "Leonardo DiCaprio", "leonardo-dicaprio@hotmail.com",
                                "+57 077 661 4732", "password69", "path/to/imageuser69"));

                // Usuario #70 - Dua Lipa
                repoUsuario.save(new Usuario("111111169", "Dua Lipa", "dua-lipa@hotmail.com", "+57 411 796 4473",
                                "password70",
                                "path/to/imageuser70"));

                // Usuario #71 - Oscar Ortiz
                repoUsuario.save(new Usuario("111111170", "Oscar Ortiz", "oscar-ortiz@hotmail.com", "+57 756 078 3735",
                                "password71", "path/to/imageuser71"));

                // Usuario #72 - Aaron Taylor-Johnson
                repoUsuario.save(new Usuario("111111171", "Aaron Taylor-Johnson", "aaron-taylor-johnson@hotmail.com",
                                "+57 632 143 1712", "password72", "path/to/imageuser72"));

                // Usuario #73 - Silvia Carreras
                repoUsuario.save(new Usuario("111111172", "Silvia Carreras", "silvia-carreras@gmail.com",
                                "+57 107 634 8954",
                                "password73", "path/to/imageuser73"));

                // Usuario #74 - Iggy Azalea
                repoUsuario.save(new Usuario("111111173", "Iggy Azalea", "iggy-azalea@hotmail.com", "+57 973 430 2772",
                                "password74", "path/to/imageuser74"));

                // Usuario #75 - George Michael
                repoUsuario.save(new Usuario("111111174", "George Michael", "george-michael@outlook.com",
                                "+57 864 300 6445",
                                "password75", "path/to/imageuser75"));

                // Usuario #76 - J Balvin
                repoUsuario.save(new Usuario("111111175", "J Balvin", "j-balvin@yahoo.com", "+57 046 678 5480",
                                "password76",
                                "path/to/imageuser76"));

                // Usuario #77 - Felipe Castro
                repoUsuario.save(
                                new Usuario("111111176", "Felipe Castro", "felipe-castro@yahoo.com", "+57 293 604 1945",
                                                "password77", "path/to/imageuser77"));

                // Usuario #78 - Jason Momoa
                repoUsuario.save(new Usuario("111111177", "Jason Momoa", "jason-momoa@yahoo.com", "+57 840 906 3111",
                                "password78", "path/to/imageuser78"));

                // Usuario #79 - Will Smith
                repoUsuario.save(new Usuario("111111178", "Will Smith", "will-smith@hotmail.com", "+57 952 188 7599",
                                "password79", "path/to/imageuser79"));

                // Usuario #80 - Luisa Gomez
                repoUsuario.save(new Usuario("111111179", "Luisa Gomez", "luisa-gomez@gmail.com", "+57 578 876 8309",
                                "password80", "path/to/imageuser80"));

                // Usuario #81 - Britney Spears
                repoUsuario.save(new Usuario("111111180", "Britney Spears", "britney-spears@yahoo.com",
                                "+57 875 420 3319",
                                "password81", "path/to/imageuser81"));

                // Usuario #82 - Beyonce Knowles
                repoUsuario.save(new Usuario("111111181", "Beyonce Knowles", "beyonce-knowles@hotmail.com",
                                "+57 738 793 7024",
                                "password82", "path/to/imageuser82"));

                // Usuario #83 - Sam Smith
                repoUsuario.save(new Usuario("111111182", "Sam Smith", "sam-smith@outlook.com", "+57 245 609 2317",
                                "password83", "path/to/imageuser83"));

                // Usuario #84 - Ariana Grande
                repoUsuario.save(
                                new Usuario("111111183", "Ariana Grande", "ariana-grande@yahoo.com", "+57 719 148 0654",
                                                "password84", "path/to/imageuser84"));

                // Usuario #85 - Chris Evans
                repoUsuario.save(new Usuario("111111184", "Chris Evans", "chris-evans@yahoo.com", "+57 926 333 7720",
                                "password85", "path/to/imageuser85"));

                // Usuario #86 - Denzel Washington
                repoUsuario.save(new Usuario("111111185", "Denzel Washington", "denzel-washington@outlook.com",
                                "+57 083 196 5308", "password86", "path/to/imageuser86"));

                // Usuario #87 - Zayn Malik
                repoUsuario.save(new Usuario("111111186", "Zayn Malik", "zayn-malik@outlook.com", "+57 397 735 9688",
                                "password87", "path/to/imageuser87"));

                // Usuario #88 - Zayn Malik
                repoUsuario.save(new Usuario("111111187", "Zayn Malik", "zayn-malik@yahoo.com", "+57 531 594 3247",
                                "password88", "path/to/imageuser88"));

                // Usuario #89 - Jay Z Carter
                repoUsuario.save(new Usuario("111111188", "Jay Z Carter", "jay-z@outlook.com", "+57 200 264 9064",
                                "password89",
                                "path/to/imageuser89"));

                // Usuario #90 - Denzel Washington
                repoUsuario.save(new Usuario("111111189", "Denzel Washington", "denzel-washington@hotmail.com",
                                "+57 185 906 1061", "password90", "path/to/imageuser90"));

                // Usuario #91 - Shakira Ripoll
                repoUsuario.save(new Usuario("111111190", "Shakira Ripoll", "shakira-ripoll@gmail.com",
                                "+57 905 117 4210",
                                "password91", "path/to/imageuser91"));

                // Usuario #92 - Troye Sivan
                repoUsuario.save(new Usuario("111111191", "Troye Sivan", "troye-sivan@yahoo.com", "+57 012 677 7248",
                                "password92", "path/to/imageuser92"));

                // Usuario #93 - Katy Perry
                repoUsuario.save(new Usuario("111111192", "Katy Perry", "katy-perry@outlook.com", "+57 319 129 0661",
                                "password93", "path/to/imageuser93"));

                // Usuario #94 - Rita Ora
                repoUsuario.save(new Usuario("111111193", "Rita Ora", "rita-ora@hotmail.com", "+57 640 421 8868",
                                "password94",
                                "path/to/imageuser94"));

                // Usuario #95 - Chris Evans
                repoUsuario.save(new Usuario("111111194", "Chris Evans", "chris-evans@hotmail.com", "+57 377 329 1348",
                                "password95", "path/to/imageuser95"));

                // Usuario #96 - Michael Jackson
                repoUsuario.save(new Usuario("111111195", "Michael Jackson", "michael-jackson@hotmail.com",
                                "+57 062 442 8940",
                                "password96", "path/to/imageuser96"));

                // Usuario #97 - Jessie J
                repoUsuario.save(new Usuario("111111196", "Jessie J", "jessie-j@outlook.com", "+57 121 237 6215",
                                "password97",
                                "path/to/imageuser97"));

                // Usuario #98 - Ana Ortegon
                repoUsuario.save(new Usuario("111111197", "Ana Ortegon", "ana-ortegon@hotmail.com", "+57 554 560 8232",
                                "password98", "path/to/imageuser98"));

                // Usuario #99 - Rihanna Fenty
                repoUsuario.save(
                                new Usuario("111111198", "Rihanna Fenty", "rihanna-fenty@gmail.com", "+57 584 072 6152",
                                                "password99", "path/to/imageuser99"));

                // Usuario #100 - Charlie Puth
                repoUsuario.save(
                                new Usuario("111111199", "Charlie Puth", "charlie-puth@hotmail.com", "+57 871 059 1751",
                                                "password100", "path/to/imageuser100"));

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

                /*
                 * // MEDICAMENTOS:
                 * // ACOLAN - (1)
                 * repoMedicamento.save(new Medicamento("ACOLAN", 151.300F, 60.520F, 4, 0));
                 * 
                 * // ACTIONIS - (2)
                 * repoMedicamento.save(new Medicamento("ACTIONIS", 155.100F, 124.080F, 4, 0));
                 * 
                 * // ACUIMIX - (3)
                 * repoMedicamento.save(new Medicamento("ACUIMIX", 114.800F, 91.840F, 4, 0));
                 * 
                 * // ADVOCIN - (4)
                 * repoMedicamento.save(new Medicamento("ADVOCIN", 147.600F, 103.320F, 1, 0));
                 * 
                 * // AEROFAR - (5)
                 * repoMedicamento.save(new Medicamento("AEROFAR", 129.000F, 64.500F, 10, 0));
                 * 
                 * // AIVLOSIN - (6)
                 * repoMedicamento.save(new Medicamento("AIVLOSIN", 164.900F, 115.430F, 10, 0));
                 * 
                 * // ALAMYCIN - (7)
                 * repoMedicamento.save(new Medicamento("ALAMYCIN", 125.800F, 100.640F, 6, 0));
                 * 
                 * // ALBIOTIC - (8)
                 * repoMedicamento.save(new Medicamento("ALBIOTIC", 79.100F, 47.460F, 2, 0));
                 * 
                 * // ALSIR - (9)
                 * repoMedicamento.save(new Medicamento("ALSIR", 182.000F, 109.200F, 4, 0));
                 * 
                 * // ALTIDOX - (10)
                 * repoMedicamento.save(new Medicamento("ALTIDOX", 133.400F, 80.040F, 4, 0));
                 * 
                 * // AMOXAL - (11)
                 * repoMedicamento.save(new Medicamento("AMOXAL", 135.500F, 108.400F, 7, 0));
                 * 
                 * // AMOXIBACTIN - (12)
                 * repoMedicamento.save(new Medicamento("AMOXIBACTIN", 86.800F, 52.080F, 1, 0));
                 * 
                 * // AMOXICILINA - (13)
                 * repoMedicamento.save(new Medicamento("AMOXICILINA", 182.900F, 109.740F, 9,
                 * 0));
                 * 
                 * // AMOXICIVEN - (14)
                 * repoMedicamento.save(new Medicamento("AMOXICIVEN", 141.600F, 70.800F, 3, 0));
                 * 
                 * // AMOXIDIAN - (15)
                 * repoMedicamento.save(new Medicamento("AMOXIDIAN", 146.800F, 102.760F, 2, 0));
                 * 
                 * // AMOXIPOL - (16)
                 * repoMedicamento.save(new Medicamento("AMOXIPOL", 58.600F, 29.300F, 3, 0));
                 * 
                 * // AMOXOIL - (17)
                 * repoMedicamento.save(new Medicamento("AMOXOIL", 50.700F, 25.350F, 4, 0));
                 * 
                 * // AMPHEN - (18)
                 * repoMedicamento.save(new Medicamento("AMPHEN", 198.200F, 158.560F, 6, 0));
                 * 
                 * // AMPIMASTINA - (19)
                 * repoMedicamento.save(new Medicamento("AMPIMASTINA", 84.500F, 59.150F, 8, 0));
                 * 
                 * // ANIMEDAZON - (20)
                 * repoMedicamento.save(new Medicamento("ANIMEDAZON", 64.000F, 44.800F, 3, 0));
                 * 
                 * // APODERM - (21)
                 * repoMedicamento.save(new Medicamento("APODERM", 182.300F, 91.150F, 3, 0));
                 * 
                 * // APRAVET - (22)
                 * repoMedicamento.save(new Medicamento("APRAVET", 93.100F, 65.170F, 1, 0));
                 * 
                 * // APSALIQ - (23)
                 * repoMedicamento.save(new Medicamento("APSALIQ", 86.100F, 34.440F, 8, 0));
                 * 
                 * // APSAMIX - (24)
                 * repoMedicamento.save(new Medicamento("APSAMIX", 52.600F, 21.040F, 6, 0));
                 * 
                 * // APSASOL - (25)
                 * repoMedicamento.save(new Medicamento("APSASOL", 142.800F, 114.240F, 5, 0));
                 * 
                 * // AQUACEN - (26)
                 * repoMedicamento.save(new Medicamento("AQUACEN", 133.500F, 93.450F, 2, 0));
                 * 
                 * // AQUACOLI - (27)
                 * repoMedicamento.save(new Medicamento("AQUACOLI", 90.200F, 45.100F, 9, 0));
                 * 
                 * // AQUADOX-S.P. - (28)
                 * repoMedicamento.save(new Medicamento("AQUADOX-S.P.", 104.500F, 41.800F, 2,
                 * 0));
                 * 
                 * // AQUAFLOR - (29)
                 * repoMedicamento.save(new Medicamento("AQUAFLOR", 151.400F, 75.700F, 10, 0));
                 * 
                 * // AQUAMICIN - (30)
                 * repoMedicamento.save(new Medicamento("AQUAMICIN", 193.000F, 77.200F, 4, 0));
                 * 
                 * // ARENTOR - (31)
                 * repoMedicamento.save(new Medicamento("ARENTOR", 190.000F, 95.000F, 7, 0));
                 * 
                 * // ASMOSERINE - (32)
                 * repoMedicamento.save(new Medicamento("ASMOSERINE", 162.000F, 97.200F, 10,
                 * 0));
                 * 
                 * // AURIZON - (33)
                 * repoMedicamento.save(new Medicamento("AURIZON", 190.200F, 152.160F, 9, 0));
                 * 
                 * // AUROFAC - (34)
                 * repoMedicamento.save(new Medicamento("AUROFAC", 177.900F, 124.530F, 6, 0));
                 * 
                 * // AVIAMOX - (35)
                 * repoMedicamento.save(new Medicamento("AVIAMOX", 141.800F, 99.260F, 8, 0));
                 * 
                 * // AVIPEN - (36)
                 * repoMedicamento.save(new Medicamento("AVIPEN", 144.200F, 57.680F, 8, 0));
                 * 
                 * // BACIPREMIX - (37)
                 * repoMedicamento.save(new Medicamento("BACIPREMIX", 188.700F, 75.480F, 10,
                 * 0));
                 * 
                 * // BACIVET - (38)
                 * repoMedicamento.save(new Medicamento("BACIVET", 155.400F, 77.700F, 4, 0));
                 * 
                 * // BAYTRIL - (39)
                 * repoMedicamento.save(new Medicamento("BAYTRIL", 110.500F, 77.350F, 9, 0));
                 * 
                 * // BAYTRILUNO - (40)
                 * repoMedicamento.save(new Medicamento("BAYTRILUNO", 118.100F, 47.240F, 9, 0));
                 * 
                 * // BENZATARD - (41)
                 * repoMedicamento.save(new Medicamento("BENZATARD", 148.700F, 89.220F, 2, 0));
                 * 
                 * // BETAMAXYL - (42)
                 * repoMedicamento.save(new Medicamento("BETAMAXYL", 155.700F, 77.850F, 2, 0));
                 * 
                 * // BETAMOX - (43)
                 * repoMedicamento.save(new Medicamento("BETAMOX", 131.000F, 65.500F, 2, 0));
                 * 
                 * // BICLOX - (44)
                 * repoMedicamento.save(new Medicamento("BICLOX", 106.400F, 85.120F, 6, 0));
                 * 
                 * // BILOVET - (45)
                 * repoMedicamento.save(new Medicamento("BILOVET", 131.300F, 105.040F, 6, 0));
                 * 
                 * // BIMOXYL - (46)
                 * repoMedicamento.save(new Medicamento("BIMOXYL", 63.000F, 31.500F, 2, 0));
                 * 
                 * // BIOTILINA - (47)
                 * repoMedicamento.save(new Medicamento("BIOTILINA", 181.800F, 109.080F, 5, 0));
                 * 
                 * // BISEPTYL - (48)
                 * repoMedicamento.save(new Medicamento("BISEPTYL", 131.900F, 79.140F, 4, 0));
                 * 
                 * // BOFLOX - (49)
                 * repoMedicamento.save(new Medicamento("BOFLOX", 53.600F, 37.520F, 8, 0));
                 * 
                 * // BORGAL - (50)
                 * repoMedicamento.save(new Medicamento("BORGAL", 167.700F, 117.390F, 6, 0));
                 * 
                 * // BOVIGAM - (51)
                 * repoMedicamento.save(new Medicamento("BOVIGAM", 125.700F, 87.990F, 1, 0));
                 * 
                 * // CADOREX - (52)
                 * repoMedicamento.save(new Medicamento("CADOREX", 143.200F, 57.280F, 8, 0));
                 * 
                 * // CALIERMUTIN - (53)
                 * repoMedicamento.save(new Medicamento("CALIERMUTIN", 76.000F, 53.200F, 8, 0));
                 * 
                 * // CALIMICINA - (54)
                 * repoMedicamento.save(new Medicamento("CALIMICINA", 113.700F, 90.960F, 7, 0));
                 * 
                 * // CANAURAL - (55)
                 * repoMedicamento.save(new Medicamento("CANAURAL", 58.500F, 40.950F, 1, 0));
                 * 
                 * // CEBIN - (56)
                 * repoMedicamento.save(new Medicamento("CEBIN", 64.400F, 38.640F, 3, 0));
                 * 
                 * // CEFABACTIN - (57)
                 * repoMedicamento.save(new Medicamento("CEFABACTIN", 142.300F, 71.150F, 4, 0));
                 * 
                 * // CEFA-CURE - (58)
                 * repoMedicamento.save(new Medicamento("CEFA-CURE", 108.800F, 76.160F, 1, 0));
                 * 
                 * // CEFAMAX - (59)
                 * repoMedicamento.save(new Medicamento("CEFAMAX", 113.500F, 56.750F, 9, 0));
                 * 
                 * // CEFA-SAFE - (60)
                 * repoMedicamento.save(new Medicamento("CEFA-SAFE", 124.700F, 99.760F, 10, 0));
                 * 
                 * // CEFASEPTIN - (61)
                 * repoMedicamento.save(new Medicamento("CEFASEPTIN", 198.800F, 99.400F, 2, 0));
                 * 
                 * // CEFAVEX - (62)
                 * repoMedicamento.save(new Medicamento("CEFAVEX", 185.500F, 148.400F, 4, 0));
                 * 
                 * // CEFENIL - (63)
                 * repoMedicamento.save(new Medicamento("CEFENIL", 139.400F, 111.520F, 7, 0));
                 * 
                 * // CEFFECT - (64)
                 * repoMedicamento.save(new Medicamento("CEFFECT", 178.300F, 142.640F, 1, 0));
                 * 
                 * // CEFQUINOR - (65)
                 * repoMedicamento.save(new Medicamento("CEFQUINOR", 96.800F, 48.400F, 7, 0));
                 * 
                 * // CEFQUITAN - (66)
                 * repoMedicamento.save(new Medicamento("CEFQUITAN", 180.200F, 126.140F, 8, 0));
                 * 
                 * // CEFTIOCYL - (67)
                 * repoMedicamento.save(new Medicamento("CEFTIOCYL", 92.400F, 64.680F, 7, 0));
                 * 
                 * // CEFTIOMAX - (68)
                 * repoMedicamento.save(new Medicamento("CEFTIOMAX", 67.600F, 54.080F, 6, 0));
                 * 
                 * // CEFTIONIL - (69)
                 * repoMedicamento.save(new Medicamento("CEFTIONIL", 107.600F, 53.800F, 6, 0));
                 * 
                 * // CEFTIOSAN - (70)
                 * repoMedicamento.save(new Medicamento("CEFTIOSAN", 165.800F, 132.640F, 10,
                 * 0));
                 * 
                 * // CEMAY - (71)
                 * repoMedicamento.save(new Medicamento("CEMAY", 109.700F, 65.820F, 8, 0));
                 * 
                 * // CENAMUTIN - (72)
                 * repoMedicamento.save(new Medicamento("CENAMUTIN", 137.600F, 96.320F, 8, 0));
                 * 
                 * // CEN-A-PEN - (73)
                 * repoMedicamento.save(new Medicamento("CEN-A-PEN", 90.300F, 63.210F, 10, 0));
                 * 
                 * // CENDOX - (74)
                 * repoMedicamento.save(new Medicamento("CENDOX", 129.700F, 77.820F, 8, 0));
                 * 
                 * // CENFLOX - (75)
                 * repoMedicamento.save(new Medicamento("CENFLOX", 108.600F, 86.880F, 8, 0));
                 * 
                 * // CENLINCO - (76)
                 * repoMedicamento.save(new Medicamento("CENLINCO", 167.300F, 100.380F, 9, 0));
                 * 
                 * // CENMICIN - (77)
                 * repoMedicamento.save(new Medicamento("CENMICIN", 76.100F, 53.270F, 1, 0));
                 * 
                 * // CENOXY - (78)
                 * repoMedicamento.save(new Medicamento("CENOXY", 58.500F, 23.400F, 1, 0));
                 * 
                 * // CENPREMIX - (79)
                 * repoMedicamento.save(new Medicamento("CENPREMIX", 143.500F, 100.450F, 3, 0));
                 * 
                 * // CENSULFATRIM - (80)
                 * repoMedicamento.save(new Medicamento("CENSULFATRIM", 92.800F, 37.120F, 7,
                 * 0));
                 * 
                 * // CENTIDOX - (81)
                 * repoMedicamento.save(new Medicamento("CENTIDOX", 163.400F, 130.720F, 7, 0));
                 * 
                 * // CENVIMOX - (82)
                 * repoMedicamento.save(new Medicamento("CENVIMOX", 55.000F, 38.500F, 1, 0));
                 * 
                 * // CEPEDOX - (83)
                 * repoMedicamento.save(new Medicamento("CEPEDOX", 160.700F, 64.280F, 9, 0));
                 * 
                 * // CEPHACARE - (84)
                 * repoMedicamento.save(new Medicamento("CEPHACARE", 58.000F, 46.400F, 4, 0));
                 * 
                 * // CEPOREX - (85)
                 * repoMedicamento.save(new Medicamento("CEPOREX", 120.900F, 48.360F, 2, 0));
                 * 
                 * // CEPRAVIN - (86)
                 * repoMedicamento.save(new Medicamento("CEPRAVIN", 117.500F, 94.000F, 4, 0));
                 * 
                 * // CEPRITECT - (87)
                 * repoMedicamento.save(new Medicamento("CEPRITECT", 98.600F, 69.020F, 1, 0));
                 * 
                 * // CEVAXEL-RTU - (88)
                 * repoMedicamento.save(new Medicamento("CEVAXEL-RTU", 57.600F, 40.320F, 7, 0));
                 * 
                 * // CITRAMOX - (89)
                 * repoMedicamento.save(new Medicamento("CITRAMOX", 104.500F, 62.700F, 8, 0));
                 * 
                 * // CLAMOXYL - (90)
                 * repoMedicamento.save(new Medicamento("CLAMOXYL", 118.100F, 82.670F, 10, 0));
                 * 
                 * // CLAVASEPTIN - (91)
                 * repoMedicamento.save(new Medicamento("CLAVASEPTIN", 51.500F, 36.050F, 4, 0));
                 * 
                 * // CLAVUBACTIN - (92)
                 * repoMedicamento.save(new Medicamento("CLAVUBACTIN", 183.900F, 128.730F, 6,
                 * 0));
                 * 
                 * // CLAVUBAY - (93)
                 * repoMedicamento.save(new Medicamento("CLAVUBAY", 156.600F, 78.300F, 10, 0));
                 * 
                 * // CLAVUCILL - (94)
                 * repoMedicamento.save(new Medicamento("CLAVUCILL", 62.700F, 43.890F, 7, 0));
                 * 
                 * // CLAVUDALE - (95)
                 * repoMedicamento.save(new Medicamento("CLAVUDALE", 52.200F, 26.100F, 10, 0));
                 * 
                 * // CLINDABACTIN - (96)
                 * repoMedicamento.save(new Medicamento("CLINDABACTIN", 186.800F, 112.080F, 1,
                 * 0));
                 * 
                 * // CLINDACUTIN - (97)
                 * repoMedicamento.save(new Medicamento("CLINDACUTIN", 133.000F, 53.200F, 9,
                 * 0));
                 * 
                 * // CLINDASEPTIN - (98)
                 * repoMedicamento.save(new Medicamento("CLINDASEPTIN", 197.200F, 118.320F, 3,
                 * 0));
                 * 
                 * // CLORAMIVET - (99)
                 * repoMedicamento.save(new Medicamento("CLORAMIVET", 179.900F, 125.930F, 7,
                 * 0));
                 * 
                 * // CLORIVEN - (100)
                 * repoMedicamento.save(new Medicamento("CLORIVEN", 152.200F, 91.320F, 10, 0));
                 * 
                 * // CLORTETRA - (101)
                 * repoMedicamento.save(new Medicamento("CLORTETRA", 110.800F, 55.400F, 8, 0));
                 * 
                 * // CLORTETRACICLINA - (102)
                 * repoMedicamento.save(new Medicamento("CLORTETRACICLINA", 52.000F, 26.000F, 7,
                 * 0));
                 * 
                 * // CLORVIOGEN - (103)
                 * repoMedicamento.save(new Medicamento("CLORVIOGEN", 112.500F, 90.000F, 6, 0));
                 * 
                 * // COBACTAN - (104)
                 * repoMedicamento.save(new Medicamento("COBACTAN", 118.500F, 71.100F, 9, 0));
                 * 
                 * // COLFIVE - (105)
                 * repoMedicamento.save(new Medicamento("COLFIVE", 71.100F, 35.550F, 4, 0));
                 * 
                 * // COLICEN - (106)
                 * repoMedicamento.save(new Medicamento("COLICEN", 199.900F, 119.940F, 2, 0));
                 * 
                 * // COLIMICINA - (107)
                 * repoMedicamento.save(new Medicamento("COLIMICINA", 91.600F, 64.120F, 1, 0));
                 * 
                 * // COLIMIX - (108)
                 * repoMedicamento.save(new Medicamento("COLIMIX", 58.800F, 41.160F, 6, 0));
                 * 
                 * // COLIMUTINA - (109)
                 * repoMedicamento.save(new Medicamento("COLIMUTINA", 87.800F, 52.680F, 9, 0));
                 * 
                 * // COLIONE - (110)
                 * repoMedicamento.save(new Medicamento("COLIONE", 195.800F, 97.900F, 4, 0));
                 * 
                 * // COLIPLUS - (111)
                 * repoMedicamento.save(new Medicamento("COLIPLUS", 102.100F, 61.260F, 3, 0));
                 * 
                 * // COLIPREMIX - (112)
                 * repoMedicamento.save(new Medicamento("COLIPREMIX", 56.100F, 33.660F, 4, 0));
                 * 
                 * // COLISOL - (113)
                 * repoMedicamento.save(new Medicamento("COLISOL", 84.400F, 50.640F, 2, 0));
                 * 
                 * // COLISTINA - (114)
                 * repoMedicamento.save(new Medicamento("COLISTINA", 181.700F, 109.020F, 6, 0));
                 * 
                 * // COLIVALL - (115)
                 * repoMedicamento.save(new Medicamento("COLIVALL", 196.000F, 156.800F, 2, 0));
                 * 
                 * // COLIVET - (116)
                 * repoMedicamento.save(new Medicamento("COLIVET", 59.300F, 47.440F, 1, 0));
                 * 
                 * // COLIXYME - (117)
                 * repoMedicamento.save(new Medicamento("COLIXYME", 177.800F, 71.120F, 3, 0));
                 * 
                 * // COLMYC - (118)
                 * repoMedicamento.save(new Medicamento("COLMYC", 168.400F, 134.720F, 9, 0));
                 * 
                 * // CONFLOX - (119)
                 * repoMedicamento.save(new Medicamento("CONFLOX", 146.900F, 117.520F, 5, 0));
                 * 
                 * // CONOFITE - (120)
                 * repoMedicamento.save(new Medicamento("CONOFITE", 190.600F, 152.480F, 10, 0));
                 * 
                 * // CONVENIA - (121)
                 * repoMedicamento.save(new Medicamento("CONVENIA", 75.700F, 60.560F, 2, 0));
                 * 
                 * // COTRISUL - (122)
                 * repoMedicamento.save(new Medicamento("COTRISUL", 78.400F, 39.200F, 3, 0));
                 * 
                 * // CUNITOTAL. - (123)
                 * repoMedicamento.save(new Medicamento("CUNITOTAL.", 128.400F, 64.200F, 8, 0));
                 * 
                 * // CURACEF - (124)
                 * repoMedicamento.save(new Medicamento("CURACEF", 99.300F, 59.580F, 4, 0));
                 * 
                 * // CYCLO - (125)
                 * repoMedicamento.save(new Medicamento("CYCLO", 82.900F, 49.740F, 10, 0));
                 * 
                 * // CYLANIC - (126)
                 * repoMedicamento.save(new Medicamento("CYLANIC", 149.000F, 104.300F, 4, 0));
                 * 
                 * // DENAGARD - (127)
                 * repoMedicamento.save(new Medicamento("DENAGARD", 77.600F, 54.320F, 5, 0));
                 * 
                 * // DEPOCILLIN - (128)
                 * repoMedicamento.save(new Medicamento("DEPOCILLIN", 94.800F, 75.840F, 2, 0));
                 * 
                 * // DEXABIOPEN - (129)
                 * repoMedicamento.save(new Medicamento("DEXABIOPEN", 123.300F, 73.980F, 10,
                 * 0));
                 * 
                 * // DFV - (130)
                 * repoMedicamento.save(new Medicamento("DFV", 129.900F, 51.960F, 9, 0));
                 * 
                 * // DIACEF - (131)
                 * repoMedicamento.save(new Medicamento("DIACEF", 162.500F, 113.750F, 8, 0));
                 * 
                 * // DIACIPRIM - (132)
                 * repoMedicamento.save(new Medicamento("DIACIPRIM", 196.700F, 157.360F, 3, 0));
                 * 
                 * // DIACOL - (133)
                 * repoMedicamento.save(new Medicamento("DIACOL", 183.900F, 110.340F, 2, 0));
                 * 
                 * // DIAMULIN - (134)
                 * repoMedicamento.save(new Medicamento("DIAMULIN", 145.300F, 116.240F, 4, 0));
                 * 
                 * // DIATRIM - (135)
                 * repoMedicamento.save(new Medicamento("DIATRIM", 84.700F, 67.760F, 4, 0));
                 * 
                 * // DIHIDROESTREPTOMICINA-IVEN - (136)
                 * repoMedicamento.save(new Medicamento("DIHIDROESTREPTOMICINA-IVEN", 134.600F,
                 * 107.680F, 2, 0));
                 * 
                 * // DILUDOX - (137)
                 * repoMedicamento.save(new Medicamento("DILUDOX", 110.000F, 88.000F, 10, 0));
                 * 
                 * // DORAXX - (138)
                 * repoMedicamento.save(new Medicamento("DORAXX", 156.300F, 125.040F, 4, 0));
                 * 
                 * // DOX - (139)
                 * repoMedicamento.save(new Medicamento("DOX", 108.300F, 54.150F, 2, 0));
                 * 
                 * // DOXBROM - (140)
                 * repoMedicamento.save(new Medicamento("DOXBROM", 133.700F, 80.220F, 3, 0));
                 * 
                 * // DOXI - (141)
                 * repoMedicamento.save(new Medicamento("DOXI", 143.000F, 85.800F, 7, 0));
                 * 
                 * // DOXI-10 - (142)
                 * repoMedicamento.save(new Medicamento("DOXI-10", 139.700F, 111.760F, 10, 0));
                 * 
                 * // DOXICICLINA - (143)
                 * repoMedicamento.save(new Medicamento("DOXICICLINA", 112.700F, 56.350F, 2,
                 * 0));
                 * 
                 * // DOXICIVALL - (144)
                 * repoMedicamento.save(new Medicamento("DOXICIVALL", 196.200F, 137.340F, 3,
                 * 0));
                 * 
                 * // DOXIDOL - (145)
                 * repoMedicamento.save(new Medicamento("DOXIDOL", 195.000F, 156.000F, 2, 0));
                 * 
                 * // DOXIDOL100 - (146)
                 * repoMedicamento.save(new Medicamento("DOXIDOL100", 123.900F, 49.560F, 2, 0));
                 * 
                 * // DOXINYL - (147)
                 * repoMedicamento.save(new Medicamento("DOXINYL", 155.500F, 93.300F, 5, 0));
                 * 
                 * // DOXIPORC - (148)
                 * repoMedicamento.save(new Medicamento("DOXIPORC", 158.400F, 110.880F, 3, 0));
                 * 
                 * // DOXIPULVIS - (149)
                 * repoMedicamento.save(new Medicamento("DOXIPULVIS", 199.400F, 99.700F, 7, 0));
                 * 
                 * // DOXMAY - (150)
                 * repoMedicamento.save(new Medicamento("DOXMAY", 68.500F, 47.950F, 4, 0));
                 * 
                 * // DOXYBACTIN - (151)
                 * repoMedicamento.save(new Medicamento("DOXYBACTIN", 112.800F, 45.120F, 8, 0));
                 * 
                 * // DOXYCARE - (152)
                 * repoMedicamento.save(new Medicamento("DOXYCARE", 173.400F, 104.040F, 9, 0));
                 * 
                 * // DOXYPREX - (153)
                 * repoMedicamento.save(new Medicamento("DOXYPREX", 192.600F, 115.560F, 9, 0));
                 * 
                 * // DOXYVETO - (154)
                 * repoMedicamento.save(new Medicamento("DOXYVETO", 162.900F, 65.160F, 3, 0));
                 * 
                 * // DRAXXIN - (155)
                 * repoMedicamento.save(new Medicamento("DRAXXIN", 156.600F, 62.640F, 9, 0));
                 * 
                 * // DYNAMUTILIN - (156)
                 * repoMedicamento.save(new Medicamento("DYNAMUTILIN", 91.800F, 45.900F, 6, 0));
                 * 
                 * // EASOTIC - (157)
                 * repoMedicamento.save(new Medicamento("EASOTIC", 177.000F, 123.900F, 5, 0));
                 * 
                 * // ECONOR - (158)
                 * repoMedicamento.save(new Medicamento("ECONOR", 108.100F, 43.240F, 9, 0));
                 * 
                 * // EFEX - (159)
                 * repoMedicamento.save(new Medicamento("EFEX", 161.100F, 96.660F, 3, 0));
                 * 
                 * // EFICUR - (160)
                 * repoMedicamento.save(new Medicamento("EFICUR", 167.100F, 83.550F, 1, 0));
                 * 
                 * // E-FLOX - (161)
                 * repoMedicamento.save(new Medicamento("E-FLOX", 143.800F, 100.660F, 5, 0));
                 * 
                 * // ENGEMICINA - (162)
                 * repoMedicamento.save(new Medicamento("ENGEMICINA", 175.000F, 70.000F, 2, 0));
                 * 
                 * // ENROCAT - (163)
                 * repoMedicamento.save(new Medicamento("ENROCAT", 186.300F, 111.780F, 5, 0));
                 * 
                 * // ENROCILL - (164)
                 * repoMedicamento.save(new Medicamento("ENROCILL", 133.500F, 66.750F, 4, 0));
                 * 
                 * // ENRODEXIL - (165)
                 * repoMedicamento.save(new Medicamento("ENRODEXIL", 137.300F, 109.840F, 7, 0));
                 * 
                 * // ENROSYVA - (166)
                 * repoMedicamento.save(new Medicamento("ENROSYVA", 169.200F, 101.520F, 4, 0));
                 * 
                 * // ENROTAB - (167)
                 * repoMedicamento.save(new Medicamento("ENROTAB", 120.600F, 96.480F, 2, 0));
                 * 
                 * // ENROTRIL - (168)
                 * repoMedicamento.save(new Medicamento("ENROTRIL", 177.600F, 142.080F, 1, 0));
                 * 
                 * // ENROTRON - (169)
                 * repoMedicamento.save(new Medicamento("ENROTRON", 143.800F, 71.900F, 9, 0));
                 * 
                 * // ENROVALL - (170)
                 * repoMedicamento.save(new Medicamento("ENROVALL", 102.900F, 41.160F, 9, 0));
                 * 
                 * // ENROVET - (171)
                 * repoMedicamento.save(new Medicamento("ENROVET", 166.400F, 116.480F, 7, 0));
                 * 
                 * // ENROX - (172)
                 * repoMedicamento.save(new Medicamento("ENROX", 178.100F, 106.860F, 6, 0));
                 * 
                 * // ENROXAL - (173)
                 * repoMedicamento.save(new Medicamento("ENROXAL", 87.800F, 70.240F, 2, 0));
                 * 
                 * // ENTEROSTREP - (174)
                 * repoMedicamento.save(new Medicamento("ENTEROSTREP", 136.300F, 109.040F, 1,
                 * 0));
                 * 
                 * // EQUIBACTIN - (175)
                 * repoMedicamento.save(new Medicamento("EQUIBACTIN", 90.100F, 54.060F, 3, 0));
                 * 
                 * // ESBANE - (176)
                 * repoMedicamento.save(new Medicamento("ESBANE", 192.100F, 115.260F, 10, 0));
                 * 
                 * // ESPECTINOCEN - (177)
                 * repoMedicamento.save(new Medicamento("ESPECTINOCEN", 118.700F, 83.090F, 5,
                 * 0));
                 * 
                 * // ESPECTINOMICINA - (178)
                 * repoMedicamento.save(new Medicamento("ESPECTINOMICINA", 58.400F, 40.880F, 4,
                 * 0));
                 * 
                 * // ESPIRAMICIL - (179)
                 * repoMedicamento.save(new Medicamento("ESPIRAMICIL", 51.700F, 36.190F, 2, 0));
                 * 
                 * // ESTREPTOLAB - (180)
                 * repoMedicamento.save(new Medicamento("ESTREPTOLAB", 139.400F, 55.760F, 6,
                 * 0));
                 * 
                 * // ESTREPTOSAL - (181)
                 * repoMedicamento.save(new Medicamento("ESTREPTOSAL", 152.200F, 91.320F, 3,
                 * 0));
                 * 
                 * // EUPENCLAV - (182)
                 * repoMedicamento.save(new Medicamento("EUPENCLAV", 136.700F, 82.020F, 8, 0));
                 * 
                 * // EUPENPLUS - (183)
                 * repoMedicamento.save(new Medicamento("EUPENPLUS", 103.200F, 61.920F, 10, 0));
                 * 
                 * 
                 * // EUPENSOL - (184)
                 * repoMedicamento.save(new Medicamento("EUPENSOL", 81.600F, 40.800F, 3, 0));
                 * 
                 * // EXABIOPEN - (185)
                 * repoMedicamento.save(new Medicamento("EXABIOPEN", 200.000F, 120.000F, 1, 0));
                 * 
                 * // EXCENEL - (186)
                 * repoMedicamento.save(new Medicamento("EXCENEL", 53.600F, 32.160F, 7, 0));
                 * 
                 * // FATROFLOX - (187)
                 * repoMedicamento.save(new Medicamento("FATROFLOX", 141.700F, 56.680F, 9, 0));
                 * 
                 * // FENOVET - (188)
                 * repoMedicamento.save(new Medicamento("FENOVET", 196.900F, 137.830F, 9, 0));
                 * 
                 * // FENOXIPEN - (189)
                 * repoMedicamento.save(new Medicamento("FENOXIPEN", 136.100F, 108.880F, 2, 0));
                 * 
                 * // FINOXALINE - (190)
                 * repoMedicamento.save(new Medicamento("FINOXALINE", 112.200F, 89.760F, 1, 0));
                 * 
                 * // FLODOEX - (191)
                 * repoMedicamento.save(new Medicamento("FLODOEX", 198.400F, 99.200F, 9, 0));
                 * 
                 * // FLOMAC - (192)
                 * repoMedicamento.save(new Medicamento("FLOMAC", 136.600F, 68.300F, 4, 0));
                 * 
                 * // FLORDOFEN - (193)
                 * repoMedicamento.save(new Medicamento("FLORDOFEN", 65.400F, 39.240F, 6, 0));
                 * 
                 * // FLORFENICEN - (194)
                 * repoMedicamento.save(new Medicamento("FLORFENICEN", 91.200F, 36.480F, 8, 0));
                 * 
                 * // FLORFENIS - (195)
                 * repoMedicamento.save(new Medicamento("FLORFENIS", 180.600F, 144.480F, 6, 0));
                 * 
                 * // FLORGANE - (196)
                 * repoMedicamento.save(new Medicamento("FLORGANE", 164.500F, 82.250F, 10, 0));
                 * 
                 * // FLORINJECT - (197)
                 * repoMedicamento.save(new Medicamento("FLORINJECT", 168.000F, 134.400F, 9,
                 * 0));
                 * 
                 * // FLORKEM - (198)
                 * repoMedicamento.save(new Medicamento("FLORKEM", 55.700F, 22.280F, 7, 0));
                 * 
                 * // FLOROLAB - (199)
                 * repoMedicamento.save(new Medicamento("FLOROLAB", 136.100F, 81.660F, 2, 0));
                 * 
                 * // FLORON - (200)
                 * repoMedicamento.save(new Medicamento("FLORON", 82.600F, 57.820F, 2, 0));
                 * 
                 * // FLORTEK - (201)
                 * repoMedicamento.save(new Medicamento("FLORTEK", 170.100F, 102.060F, 3, 0));
                 * 
                 * // FLORVEX - (202)
                 * repoMedicamento.save(new Medicamento("FLORVEX", 179.300F, 125.510F, 8, 0));
                 * 
                 * // FLOXABACTIN - (203)
                 * repoMedicamento.save(new Medicamento("FLOXABACTIN", 169.600F, 67.840F, 1,
                 * 0));
                 * 
                 * // FLOXACIVEN - (204)
                 * repoMedicamento.save(new Medicamento("FLOXACIVEN", 69.300F, 55.440F, 1, 0));
                 * 
                 * // FLOXAVEX - (205)
                 * repoMedicamento.save(new Medicamento("FLOXAVEX", 177.500F, 124.250F, 7, 0));
                 * 
                 * // FLOXICEN - (206)
                 * repoMedicamento.save(new Medicamento("FLOXICEN", 107.300F, 85.840F, 4, 0));
                 * 
                 * // FLOXYME - (207)
                 * repoMedicamento.save(new Medicamento("FLOXYME", 140.400F, 84.240F, 9, 0));
                 * 
                 * // FLUMESYVA - (208)
                 * repoMedicamento.save(new Medicamento("FLUMESYVA", 57.900F, 28.950F, 1, 0));
                 * 
                 * // FLUQUICEN - (209)
                 * repoMedicamento.save(new Medicamento("FLUQUICEN", 165.400F, 82.700F, 3, 0));
                 * 
                 * // FLUQUINOL - (210)
                 * repoMedicamento.save(new Medicamento("FLUQUINOL", 53.300F, 31.980F, 6, 0));
                 * 
                 * // FORCYL - (211)
                 * repoMedicamento.save(new Medicamento("FORCYL", 118.300F, 47.320F, 10, 0));
                 * 
                 * // FORESPIX - (212)
                 * repoMedicamento.save(new Medicamento("FORESPIX", 120.500F, 72.300F, 10, 0));
                 * 
                 * // FORMULA - (213)
                 * repoMedicamento.save(new Medicamento("FORMULA", 65.700F, 32.850F, 4, 0));
                 * 
                 * // FORTICLINA - (214)
                 * repoMedicamento.save(new Medicamento("FORTICLINA", 53.200F, 42.560F, 5, 0));
                 * 
                 * // FORTIPERAZONE - (215)
                 * repoMedicamento.save(new Medicamento("FORTIPERAZONE", 160.700F, 64.280F, 7,
                 * 0));
                 * 
                 * // FRAMICAS - (216)
                 * repoMedicamento.save(new Medicamento("FRAMICAS", 181.400F, 108.840F, 2, 0));
                 * 
                 * // GABBROCOL - (217)
                 * repoMedicamento.save(new Medicamento("GABBROCOL", 127.700F, 89.390F, 3, 0));
                 * 
                 * // GABBROVET - (218)
                 * repoMedicamento.save(new Medicamento("GABBROVET", 97.800F, 78.240F, 10, 0));
                 * 
                 * // GALACTOLIN - (219)
                 * repoMedicamento.save(new Medicamento("GALACTOLIN", 80.600F, 32.240F, 1, 0));
                 * 
                 * // GALLUDOXX - (220)
                 * repoMedicamento.save(new Medicamento("GALLUDOXX", 133.900F, 80.340F, 9, 0));
                 * 
                 * // GANADEXIL - (221)
                 * repoMedicamento.save(new Medicamento("GANADEXIL", 168.100F, 84.050F, 10, 0));
                 * 
                 * // GANAMIX - (222)
                 * repoMedicamento.save(new Medicamento("GANAMIX", 162.700F, 97.620F, 1, 0));
                 * 
                 * // GANAPORK - (223)
                 * repoMedicamento.save(new Medicamento("GANAPORK", 84.100F, 50.460F, 3, 0));
                 * 
                 * // GENTACALIER - (224)
                 * repoMedicamento.save(new Medicamento("GENTACALIER", 107.200F, 75.040F, 5,
                 * 0));
                 * 
                 * // GENTACEN - (225)
                 * repoMedicamento.save(new Medicamento("GENTACEN", 129.000F, 64.500F, 9, 0));
                 * 
                 * // GENTA-EQUINE - (226)
                 * repoMedicamento.save(new Medicamento("GENTA-EQUINE", 177.100F, 106.260F, 5,
                 * 0));
                 * 
                 * // GENTAMOX - (227)
                 * repoMedicamento.save(new Medicamento("GENTAMOX", 172.900F, 138.320F, 1, 0));
                 * 
                 * // GENTAORAL - (228)
                 * repoMedicamento.save(new Medicamento("GENTAORAL", 84.300F, 67.440F, 8, 0));
                 * 
                 * // GENTASOL - (229)
                 * repoMedicamento.save(new Medicamento("GENTASOL", 62.100F, 49.680F, 3, 0));
                 * 
                 * // GENTAVALL - (230)
                 * repoMedicamento.save(new Medicamento("GENTAVALL", 61.700F, 37.020F, 2, 0));
                 * 
                 * // GENTAVET - (231)
                 * repoMedicamento.save(new Medicamento("GENTAVET", 124.000F, 99.200F, 8, 0));
                 * 
                 * // GENTAVIN - (232)
                 * repoMedicamento.save(new Medicamento("GENTAVIN", 154.700F, 92.820F, 7, 0));
                 * 
                 * // GENTICINA - (233)
                 * repoMedicamento.save(new Medicamento("GENTICINA", 135.100F, 67.550F, 9, 0));
                 * 
                 * // GIROLAN - (234)
                 * repoMedicamento.save(new Medicamento("GIROLAN", 124.200F, 74.520F, 10, 0));
                 * 
                 * // GLUCILIN-D - (235)
                 * repoMedicamento.save(new Medicamento("GLUCILIN-D", 105.100F, 42.040F, 9, 0));
                 * 
                 * // HIDROCOL - (236)
                 * repoMedicamento.save(new Medicamento("HIDROCOL", 121.000F, 48.400F, 6, 0));
                 * 
                 * // HIDRODOX - (237)
                 * repoMedicamento.save(new Medicamento("HIDRODOX", 115.600F, 57.800F, 5, 0));
                 * 
                 * // HIDROMUTIN - (238)
                 * repoMedicamento.save(new Medicamento("HIDROMUTIN", 138.800F, 69.400F, 5, 0));
                 * 
                 * // HIDROTIL - (239)
                 * repoMedicamento.save(new Medicamento("HIDROTIL", 161.800F, 97.080F, 2, 0));
                 * 
                 * // HIPRALONA - (240)
                 * repoMedicamento.save(new Medicamento("HIPRALONA", 161.300F, 129.040F, 8, 0));
                 * 
                 * // HUVAMOX - (241)
                 * repoMedicamento.save(new Medicamento("HUVAMOX", 141.600F, 99.120F, 5, 0));
                 * 
                 * // HYMATIL - (242)
                 * repoMedicamento.save(new Medicamento("HYMATIL", 108.000F, 75.600F, 9, 0));
                 * 
                 * // HYPERSOL - (243)
                 * repoMedicamento.save(new Medicamento("HYPERSOL", 86.700F, 52.020F, 8, 0));
                 * 
                 * // ILOVET-CLOX - (244)
                 * repoMedicamento.save(new Medicamento("ILOVET-CLOX", 96.700F, 67.690F, 5, 0));
                 * 
                 * // ILOVET-DHIPEN - (245)
                 * repoMedicamento.save(new Medicamento("ILOVET-DHIPEN", 166.300F, 83.150F, 8,
                 * 0));
                 * 
                 * // ILOVETMR - (246)
                 * repoMedicamento.save(new Medicamento("ILOVETMR", 157.000F, 94.200F, 1, 0));
                 * 
                 * // ILOVET-SECADO - (247)
                 * repoMedicamento.save(new Medicamento("ILOVET-SECADO", 160.900F, 80.450F, 3,
                 * 0));
                 * 
                 * // INCREXXA - (248)
                 * repoMedicamento.save(new Medicamento("INCREXXA", 185.200F, 111.120F, 8, 0));
                 * 
                 * // INHIBACTEN - (249)
                 * repoMedicamento.save(new Medicamento("INHIBACTEN", 101.200F, 50.600F, 1, 0));
                 * 
                 * // INTERFLOX - (250)
                 * repoMedicamento.save(new Medicamento("INTERFLOX", 113.000F, 90.400F, 4, 0));
                 * 
                 * // INTERMAX-PREMEZCLA - (251)
                 * repoMedicamento.save(new Medicamento("INTERMAX-PREMEZCLA", 68.200F, 47.740F,
                 * 6, 0));
                 * 
                 * // ISATHAL - (252)
                 * repoMedicamento.save(new Medicamento("ISATHAL", 126.300F, 88.410F, 5, 0));
                 * 
                 * // IVENCILINA - (253)
                 * repoMedicamento.save(new Medicamento("IVENCILINA", 60.300F, 48.240F, 4, 0));
                 * 
                 * // KARIDOX - (254)
                 * repoMedicamento.save(new Medicamento("KARIDOX", 70.000F, 49.000F, 1, 0));
                 * 
                 * // KARIFLOX - (255)
                 * repoMedicamento.save(new Medicamento("KARIFLOX", 144.000F, 100.800F, 7, 0));
                 * 
                 * // KARIMULINA - (256)
                 * repoMedicamento.save(new Medicamento("KARIMULINA", 162.000F, 129.600F, 9,
                 * 0));
                 * 
                 * // K-DOX - (257)
                 * repoMedicamento.save(new Medicamento("K-DOX", 134.600F, 80.760F, 10, 0));
                 * 
                 * // KELACYL - (258)
                 * repoMedicamento.save(new Medicamento("KELACYL", 77.300F, 61.840F, 1, 0));
                 * 
                 * // KESIUM - (259)
                 * repoMedicamento.save(new Medicamento("KESIUM", 98.700F, 59.220F, 3, 0));
                 * 
                 * // KEYTIL - (260)
                 * repoMedicamento.save(new Medicamento("KEYTIL", 76.100F, 60.880F, 7, 0));
                 * 
                 * // K-FLOX - (261)
                 * repoMedicamento.save(new Medicamento("K-FLOX", 185.900F, 74.360F, 3, 0));
                 * 
                 * // KIN-O-FLOX - (262)
                 * repoMedicamento.save(new Medicamento("KIN-O-FLOX", 168.300F, 117.810F, 2,
                 * 0));
                 * 
                 * // LAMOX - (263)
                 * repoMedicamento.save(new Medicamento("LAMOX", 189.100F, 113.460F, 7, 0));
                 * 
                 * // LANFLOX - (264)
                 * repoMedicamento.save(new Medicamento("LANFLOX", 116.900F, 70.140F, 2, 0));
                 * 
                 * // LATROXIN - (265)
                 * repoMedicamento.save(new Medicamento("LATROXIN", 161.100F, 80.550F, 7, 0));
                 * 
                 * // LEVOFLOK - (266)
                 * repoMedicamento.save(new Medicamento("LEVOFLOK", 110.600F, 88.480F, 6, 0));
                 * 
                 * // LINALTEN - (267)
                 * repoMedicamento.save(new Medicamento("LINALTEN", 57.900F, 46.320F, 2, 0));
                 * 
                 * // LINCEX - (268)
                 * repoMedicamento.save(new Medicamento("LINCEX", 138.500F, 69.250F, 8, 0));
                 * 
                 * // LINCO - (269)
                 * repoMedicamento.save(new Medicamento("LINCO", 80.400F, 32.160F, 5, 0));
                 * 
                 * // LINCOIVEN - (270)
                 * repoMedicamento.save(new Medicamento("LINCOIVEN", 172.700F, 69.080F, 3, 0));
                 * 
                 * // LINCOLAB - (271)
                 * repoMedicamento.save(new Medicamento("LINCOLAB", 138.000F, 96.600F, 9, 0));
                 * 
                 * // LINCOMASTINA - (272)
                 * repoMedicamento.save(new Medicamento("LINCOMASTINA", 111.500F, 89.200F, 9,
                 * 0));
                 * 
                 * // LINCOMAY - (273)
                 * repoMedicamento.save(new Medicamento("LINCOMAY", 195.800F, 117.480F, 3, 0));
                 * 
                 * // LINCOMICINA - (274)
                 * repoMedicamento.save(new Medicamento("LINCOMICINA", 119.900F, 59.950F, 3,
                 * 0));
                 * 
                 * // LINCOMIX - (275)
                 * repoMedicamento.save(new Medicamento("LINCOMIX", 80.500F, 56.350F, 5, 0));
                 * 
                 * // LINCO-RES - (276)
                 * repoMedicamento.save(new Medicamento("LINCO-RES", 159.700F, 95.820F, 8, 0));
                 * 
                 * // LINCOSAN - (277)
                 * repoMedicamento.save(new Medicamento("LINCOSAN", 189.400F, 94.700F, 1, 0));
                 * 
                 * // LINCOSOL - (278)
                 * repoMedicamento.save(new Medicamento("LINCOSOL", 104.200F, 52.100F, 3, 0));
                 * 
                 * // LINCO-SPECTIN - (279)
                 * repoMedicamento.save(new Medicamento("LINCO-SPECTIN", 71.300F, 49.910F, 7,
                 * 0));
                 * 
                 * // LINCOSTRAN - (280)
                 * repoMedicamento.save(new Medicamento("LINCOSTRAN", 72.500F, 29.000F, 7, 0));
                 * 
                 * // LINCOTRIMEX - (281)
                 * repoMedicamento.save(new Medicamento("LINCOTRIMEX", 184.500F, 73.800F, 8,
                 * 0));
                 * 
                 * // LINCOVALL - (282)
                 * repoMedicamento.save(new Medicamento("LINCOVALL", 60.300F, 30.150F, 8, 0));
                 * 
                 * // LINCOXIL - (283)
                 * repoMedicamento.save(new Medicamento("LINCOXIL", 167.300F, 117.110F, 9, 0));
                 * 
                 * // LINESVALL - (284)
                 * repoMedicamento.save(new Medicamento("LINESVALL", 70.300F, 56.240F, 10, 0));
                 * 
                 * // LISMAY - (285)
                 * repoMedicamento.save(new Medicamento("LISMAY", 191.100F, 76.440F, 2, 0));
                 * 
                 * // LUNGOCIL - (286)
                 * repoMedicamento.save(new Medicamento("LUNGOCIL", 126.700F, 63.350F, 7, 0));
                 * 
                 * // LYDAXX - (287)
                 * repoMedicamento.save(new Medicamento("LYDAXX", 145.900F, 87.540F, 3, 0));
                 * 
                 * // MACROMUTIN - (288)
                 * repoMedicamento.save(new Medicamento("MACROMUTIN", 89.200F, 71.360F, 9, 0));
                 * 
                 * // MACROSYN - (289)
                 * repoMedicamento.save(new Medicamento("MACROSYN", 134.100F, 107.280F, 7, 0));
                 * 
                 * // MAMIFORT - (290)
                 * repoMedicamento.save(new Medicamento("MAMIFORT", 180.400F, 108.240F, 10, 0));
                 * 
                 * // MAMYZIN - (291)
                 * repoMedicamento.save(new Medicamento("MAMYZIN", 126.900F, 101.520F, 8, 0));
                 * 
                 * // MARBOCARE - (292)
                 * repoMedicamento.save(new Medicamento("MARBOCARE", 177.500F, 106.500F, 6, 0));
                 * 
                 * // MARBOCEN - (293)
                 * repoMedicamento.save(new Medicamento("MARBOCEN", 182.000F, 145.600F, 1, 0));
                 * 
                 * // MARBOCOLI - (294)
                 * repoMedicamento.save(new Medicamento("MARBOCOLI", 61.900F, 24.760F, 10, 0));
                 * // MARBOCYL - (295)
                 * repoMedicamento.save(new Medicamento("MARBOCYL", 117.300F, 93.840F, 5, 0));
                 * 
                 * // MARBOFLOXORAL - (296)
                 * repoMedicamento.save(new Medicamento("MARBOFLOXORAL", 141.000F, 84.600F, 8,
                 * 0));
                 * 
                 * // MARBOSOL - (297)
                 * repoMedicamento.save(new Medicamento("MARBOSOL", 119.700F, 71.820F, 4, 0));
                 * 
                 * // MARBOSYVA - (298)
                 * repoMedicamento.save(new Medicamento("MARBOSYVA", 135.500F, 94.850F, 1, 0));
                 * 
                 * // MARBOTAB - (299)
                 * repoMedicamento.save(new Medicamento("MARBOTAB", 63.900F, 51.120F, 10, 0));
                 * 
                 * // MARBOVET - (300)
                 * repoMedicamento.save(new Medicamento("MARBOVET", 83.500F, 58.450F, 5, 0));
                 * 
                 * // MARBOX - (301)
                 * repoMedicamento.save(new Medicamento("MARBOX", 197.600F, 98.800F, 5, 0));
                 * 
                 * // MARFLOQUIN - (302)
                 * repoMedicamento.save(new Medicamento("MARFLOQUIN", 127.700F, 63.850F, 5, 0));
                 * 
                 * // MARFLOXIN - (303)
                 * repoMedicamento.save(new Medicamento("MARFLOXIN", 181.500F, 127.050F, 10,
                 * 0));
                 * 
                 * // MARVETIN - (304)
                 * repoMedicamento.save(new Medicamento("MARVETIN", 128.200F, 76.920F, 8, 0));
                 * 
                 * // MASTERFLOX - (305)
                 * repoMedicamento.save(new Medicamento("MASTERFLOX", 184.700F, 92.350F, 3, 0));
                 * 
                 * // MASTERMIX - (306)
                 * repoMedicamento.save(new Medicamento("MASTERMIX", 63.100F, 50.480F, 9, 0));
                 * 
                 * // MASTIPLAN - (307)
                 * repoMedicamento.save(new Medicamento("MASTIPLAN", 145.500F, 72.750F, 5, 0));
                 * 
                 * // MASTIVET - (308)
                 * repoMedicamento.save(new Medicamento("MASTIVET", 93.700F, 37.480F, 7, 0));
                 * 
                 * // MASTORANGE - (309)
                 * repoMedicamento.save(new Medicamento("MASTORANGE", 96.600F, 57.960F, 5, 0));
                 * 
                 * // MAXYL - (310)
                 * repoMedicamento.save(new Medicamento("MAXYL", 160.100F, 112.070F, 10, 0));
                 * 
                 * // MAYCILINA - (311)
                 * repoMedicamento.save(new Medicamento("MAYCILINA", 145.600F, 87.360F, 9, 0));
                 * 
                 * // MAYCOLI - (312)
                 * repoMedicamento.save(new Medicamento("MAYCOLI", 86.400F, 69.120F, 3, 0));
                 * 
                 * // MAYDOX - (313)
                 * repoMedicamento.save(new Medicamento("MAYDOX", 84.900F, 50.940F, 7, 0));
                 * 
                 * // MAYLOSINA - (314)
                 * repoMedicamento.save(new Medicamento("MAYLOSINA", 118.300F, 82.810F, 8, 0));
                 * 
                 * // MAYMOXI - (315)
                 * repoMedicamento.save(new Medicamento("MAYMOXI", 86.700F, 69.360F, 10, 0));
                 * 
                 * // MAYMULINA - (316)
                 * repoMedicamento.save(new Medicamento("MAYMULINA", 74.100F, 29.640F, 3, 0));
                 * 
                 * // MAYPRACINA - (317)
                 * repoMedicamento.save(new Medicamento("MAYPRACINA", 70.600F, 56.480F, 1, 0));
                 * 
                 * // MAYSULPRIM - (318)
                 * repoMedicamento.save(new Medicamento("MAYSULPRIM", 125.800F, 75.480F, 5, 0));
                 * 
                 * // METAMPEN - (319)
                 * repoMedicamento.save(new Medicamento("METAMPEN", 126.100F, 75.660F, 4, 0));
                 * 
                 * // METAXOL - (320)
                 * repoMedicamento.save(new Medicamento("METAXOL", 184.200F, 73.680F, 2, 0));
                 * 
                 * // METHOXASOL - (321)
                 * repoMedicamento.save(new Medicamento("METHOXASOL", 195.400F, 136.780F, 3,
                 * 0));
                 * 
                 * // METRICURE - (322)
                 * repoMedicamento.save(new Medicamento("METRICURE", 68.700F, 48.090F, 6, 0));
                 * 
                 * // METROBACTIN - (323)
                 * repoMedicamento.save(new Medicamento("METROBACTIN", 54.200F, 27.100F, 6, 0));
                 * 
                 * // METROCARE - (324)
                 * repoMedicamento.save(new Medicamento("METROCARE", 110.300F, 66.180F, 10, 0));
                 * 
                 * // METROVIS - (325)
                 * repoMedicamento.save(new Medicamento("METROVIS", 90.700F, 54.420F, 6, 0));
                 * 
                 * // METROZENIL - (326)
                 * repoMedicamento.save(new Medicamento("METROZENIL", 181.800F, 72.720F, 1, 0));
                 * 
                 * // MICOTIL - (327)
                 * repoMedicamento.save(new Medicamento("MICOTIL", 170.600F, 85.300F, 5, 0));
                 * 
                 * // MITEX - (328)
                 * repoMedicamento.save(new Medicamento("MITEX", 168.200F, 117.740F, 1, 0));
                 * 
                 * // MOXAPULVIS - (329)
                 * repoMedicamento.save(new Medicamento("MOXAPULVIS", 95.900F, 67.130F, 6, 0));
                 * 
                 * // MULTISHIELD - (330)
                 * repoMedicamento.save(new Medicamento("MULTISHIELD", 76.700F, 30.680F, 10,
                 * 0));
                 * 
                 * // MYCOFLOR - (331)
                 * repoMedicamento.save(new Medicamento("MYCOFLOR", 117.400F, 82.180F, 10, 0));
                 * 
                 * // MYCOGAL - (332)
                 * repoMedicamento.save(new Medicamento("MYCOGAL", 109.900F, 76.930F, 1, 0));
                 * 
                 * // NAXCEL - (333)
                 * repoMedicamento.save(new Medicamento("NAXCEL", 136.600F, 95.620F, 10, 0));
                 * 
                 * // NEMICINA - (334)
                 * repoMedicamento.save(new Medicamento("NEMICINA", 98.300F, 58.980F, 6, 0));
                 * 
                 * // NEMUTIN - (335)
                 * repoMedicamento.save(new Medicamento("NEMUTIN", 55.400F, 27.700F, 2, 0));
                 * 
                 * // NEOACTIVE - (336)
                 * repoMedicamento.save(new Medicamento("NEOACTIVE", 135.500F, 81.300F, 2, 0));
                 * 
                 * // NEOCIL - (337)
                 * repoMedicamento.save(new Medicamento("NEOCIL", 124.200F, 86.940F, 2, 0));
                 * 
                 * // NEOCLOR-T - (338)
                 * repoMedicamento.save(new Medicamento("NEOCLOR-T", 77.200F, 46.320F, 8, 0));
                 * 
                 * // NEOMAY - (339)
                 * repoMedicamento.save(new Medicamento("NEOMAY", 165.400F, 82.700F, 2, 0));
                 * 
                 * // NEOMICINA - (340)
                 * repoMedicamento.save(new Medicamento("NEOMICINA", 72.000F, 50.400F, 7, 0));
                 * 
                 * // NEPTRA - (341)
                 * repoMedicamento.save(new Medicamento("NEPTRA", 159.600F, 79.800F, 5, 0));
                 * 
                 * // NEUDIAVALL - (342)
                 * repoMedicamento.save(new Medicamento("NEUDIAVALL", 148.200F, 88.920F, 2, 0));
                 * 
                 * // NEUMOVEX - (343)
                 * repoMedicamento.save(new Medicamento("NEUMOVEX", 101.400F, 81.120F, 7, 0));
                 * 
                 * // NICILAN - (344)
                 * repoMedicamento.save(new Medicamento("NICILAN", 53.200F, 21.280F, 7, 0));
                 * 
                 * // NIFENCOL - (345)
                 * repoMedicamento.save(new Medicamento("NIFENCOL", 138.800F, 69.400F, 7, 0));
                 * 
                 * // NIPOXYME - (346)
                 * repoMedicamento.save(new Medicamento("NIPOXYME", 78.400F, 31.360F, 5, 0));
                 * 
                 * // NISAMOX - (347)
                 * repoMedicamento.save(new Medicamento("NISAMOX", 177.600F, 106.560F, 2, 0));
                 * 
                 * // NISINJECT - (348)
                 * repoMedicamento.save(new Medicamento("NISINJECT", 72.700F, 36.350F, 10, 0));
                 * 
                 * // NOROCLAV - (349)
                 * repoMedicamento.save(new Medicamento("NOROCLAV", 115.500F, 46.200F, 4, 0));
                 * 
                 * // NUFLOR - (350)
                 * repoMedicamento.save(new Medicamento("NUFLOR", 76.700F, 46.020F, 2, 0));
                 * 
                 * // OCNIL - (351)
                 * repoMedicamento.save(new Medicamento("OCNIL", 163.300F, 130.640F, 9, 0));
                 * 
                 * // OCTACILLIN - (352)
                 * repoMedicamento.save(new Medicamento("OCTACILLIN", 130.800F, 65.400F, 7, 0));
                 * 
                 * // ODIMAR - (353)
                 * repoMedicamento.save(new Medicamento("ODIMAR", 101.400F, 50.700F, 5, 0));
                 * 
                 * // OPHTOCYCLINE - (354)
                 * repoMedicamento.save(new Medicamento("OPHTOCYCLINE", 174.400F, 104.640F, 8,
                 * 0));
                 * 
                 * // ORATIL - (355)
                 * repoMedicamento.save(new Medicamento("ORATIL", 188.500F, 150.800F, 1, 0));
                 * 
                 * // ORBENIN - (356)
                 * repoMedicamento.save(new Medicamento("ORBENIN", 141.300F, 70.650F, 10, 0));
                 * 
                 * // ORONDO - (357)
                 * repoMedicamento.save(new Medicamento("ORONDO", 59.400F, 35.640F, 6, 0));
                 * 
                 * // OSURNIA - (358)
                 * repoMedicamento.save(new Medicamento("OSURNIA", 110.700F, 44.280F, 10, 0));
                 * 
                 * // OTOMAX - (359)
                 * repoMedicamento.save(new Medicamento("OTOMAX", 154.200F, 92.520F, 3, 0));
                 * 
                 * // OTOTOP - (360)
                 * repoMedicamento.save(new Medicamento("OTOTOP", 54.400F, 43.520F, 5, 0));
                 * 
                 * // OTOXOLAN - (361)
                 * repoMedicamento.save(new Medicamento("OTOXOLAN", 83.500F, 58.450F, 7, 0));
                 * 
                 * // OXICIVEN - (362)
                 * repoMedicamento.save(new Medicamento("OXICIVEN", 163.500F, 98.100F, 9, 0));
                 * 
                 * // OXICLIN - (363)
                 * repoMedicamento.save(new Medicamento("OXICLIN", 97.200F, 58.320F, 3, 0));
                 * 
                 * // OXILABICICLINA - (364)
                 * repoMedicamento.save(new Medicamento("OXILABICICLINA", 114.000F, 91.200F, 10,
                 * 0));
                 * 
                 * // OXIPOL - (365)
                 * repoMedicamento.save(new Medicamento("OXIPOL", 189.400F, 113.640F, 6, 0));
                 * 
                 * // OXIRETARD - (366)
                 * repoMedicamento.save(new Medicamento("OXIRETARD", 87.700F, 35.080F, 8, 0));
                 * 
                 * // OXISAN - (367)
                 * repoMedicamento.save(new Medicamento("OXISAN", 50.500F, 20.200F, 5, 0));
                 * 
                 * // OXITETRACICLINA - (368)
                 * repoMedicamento.save(new Medicamento("OXITETRACICLINA", 156.800F, 62.720F, 7,
                 * 0));
                 * 
                 * // OXITEVALL - (369)
                 * repoMedicamento.save(new Medicamento("OXITEVALL", 89.700F, 71.760F, 8, 0));
                 * 
                 * // OXITEVE - (370)
                 * repoMedicamento.save(new Medicamento("OXITEVE", 139.900F, 69.950F, 1, 0));
                 * 
                 * // OXYGAN - (371)
                 * repoMedicamento.save(new Medicamento("OXYGAN", 82.100F, 41.050F, 10, 0));
                 * 
                 * // PANTOMICINA - (372)
                 * repoMedicamento.save(new Medicamento("PANTOMICINA", 155.200F, 62.080F, 9,
                 * 0));
                 * 
                 * // PANTOYET - (373)
                 * repoMedicamento.save(new Medicamento("PANTOYET", 106.700F, 64.020F, 4, 0));
                 * 
                 * // PARACILLIN - (374)
                 * repoMedicamento.save(new Medicamento("PARACILLIN", 81.100F, 40.550F, 5, 0));
                 * 
                 * // PAROFOR - (375)
                 * repoMedicamento.save(new Medicamento("PAROFOR", 86.400F, 43.200F, 1, 0));
                 * 
                 * // PEDERIPRA - (376)
                 * repoMedicamento.save(new Medicamento("PEDERIPRA", 95.700F, 38.280F, 6, 0));
                 * 
                 * // PEDEROL - (377)
                 * repoMedicamento.save(new Medicamento("PEDEROL", 143.900F, 57.560F, 4, 0));
                 * 
                 * // PENETHAONE - (378)
                 * repoMedicamento.save(new Medicamento("PENETHAONE", 164.700F, 115.290F, 4,
                 * 0));
                 * 
                 * // PENIVET - (379)
                 * repoMedicamento.save(new Medicamento("PENIVET", 192.700F, 134.890F, 1, 0));
                 * 
                 * // PENIVEX - (380)
                 * repoMedicamento.save(new Medicamento("PENIVEX", 115.400F, 92.320F, 1, 0));
                 * 
                 * // PERMACYL - (381)
                 * repoMedicamento.save(new Medicamento("PERMACYL", 146.400F, 87.840F, 10, 0));
                 * 
                 * // PERMAWAY - (382)
                 * repoMedicamento.save(new Medicamento("PERMAWAY", 52.100F, 20.840F, 10, 0));
                 * 
                 * // PHARMASIN - (383)
                 * repoMedicamento.save(new Medicamento("PHARMASIN", 63.200F, 37.920F, 4, 0));
                 * 
                 * // PHENOCILLIN - (384)
                 * repoMedicamento.save(new Medicamento("PHENOCILLIN", 148.100F, 74.050F, 3,
                 * 0));
                 * 
                 * // PIRSUE - (385)
                 * repoMedicamento.save(new Medicamento("PIRSUE", 172.600F, 103.560F, 4, 0));
                 * 
                 * // PLENIX - (386)
                 * repoMedicamento.save(new Medicamento("PLENIX", 119.400F, 59.700F, 7, 0));
                 * 
                 * // PLUSCOLAN - (387)
                 * repoMedicamento.save(new Medicamento("PLUSCOLAN", 127.800F, 63.900F, 4, 0));
                 * 
                 * // POSATEX - (388)
                 * repoMedicamento.save(new Medicamento("POSATEX", 90.800F, 72.640F, 4, 0));
                 * 
                 * // POTENCIL - (389)
                 * repoMedicamento.save(new Medicamento("POTENCIL", 99.100F, 49.550F, 7, 0));
                 * 
                 * // POTENMIX - (390)
                 * repoMedicamento.save(new Medicamento("POTENMIX", 170.200F, 102.120F, 3, 0));
                 * 
                 * // POWDOX - (391)
                 * repoMedicamento.save(new Medicamento("POWDOX", 186.700F, 74.680F, 3, 0));
                 * 
                 * // PRADOXIN - (392)
                 * repoMedicamento.save(new Medicamento("PRADOXIN", 156.200F, 93.720F, 4, 0));
                 * 
                 * // PRIMOX - (393)
                 * repoMedicamento.save(new Medicamento("PRIMOX", 192.000F, 76.800F, 5, 0));
                 * 
                 * // PROBENCIL - (394)
                 * repoMedicamento.save(new Medicamento("PROBENCIL", 172.400F, 137.920F, 7, 0));
                 * 
                 * // PROCACTIVE - (395)
                 * repoMedicamento.save(new Medicamento("PROCACTIVE", 113.100F, 79.170F, 5, 0));
                 * 
                 * // PROCAPEN - (396)
                 * repoMedicamento.save(new Medicamento("PROCAPEN", 83.300F, 66.640F, 10, 0));
                 * 
                 * // PROCIPEN - (397)
                 * repoMedicamento.save(new Medicamento("PROCIPEN", 109.900F, 43.960F, 10, 0));
                 * 
                 * // PROTOZOKS - (398)
                 * repoMedicamento.save(new Medicamento("PROTOZOKS", 154.200F, 77.100F, 2, 0));
                 * 
                 * // PULMOBAS - (399)
                 * repoMedicamento.save(new Medicamento("PULMOBAS", 76.900F, 61.520F, 3, 0));
                 * 
                 * // PULMODOX - (400)
                 * repoMedicamento.save(new Medicamento("PULMODOX", 184.500F, 110.700F, 4, 0));
                 * 
                 * // PULMOTIL - (401)
                 * repoMedicamento.save(new Medicamento("PULMOTIL", 176.800F, 70.720F, 2, 0));
                 * 
                 * // PULMOVALL - (402)
                 * repoMedicamento.save(new Medicamento("PULMOVALL", 91.200F, 54.720F, 4, 0));
                 * 
                 * // PULMOVET - (403)
                 * repoMedicamento.save(new Medicamento("PULMOVET", 172.800F, 86.400F, 4, 0));
                 * 
                 * // QIVITAN - (404)
                 * repoMedicamento.save(new Medicamento("QIVITAN", 99.400F, 79.520F, 9, 0));
                 * 
                 * // QUIMIOCOLI - (405)
                 * repoMedicamento.save(new Medicamento("QUIMIOCOLI", 194.100F, 77.640F, 8, 0));
                 * 
                 * // QUINOBAL - (406)
                 * repoMedicamento.save(new Medicamento("QUINOBAL", 196.700F, 98.350F, 1, 0));
                 * 
                 * // QUINOCILIN - (407)
                 * repoMedicamento.save(new Medicamento("QUINOCILIN", 134.100F, 93.870F, 6, 0));
                 * 
                 * // QUINOLCEN - (408)
                 * repoMedicamento.save(new Medicamento("QUINOLCEN", 96.100F, 57.660F, 8, 0));
                 * 
                 * // QUINOVET - (409)
                 * repoMedicamento.save(new Medicamento("QUINOVET", 186.900F, 130.830F, 5, 0));
                 * 
                 * // RESFLOR - (410)
                 * repoMedicamento.save(new Medicamento("RESFLOR", 171.900F, 103.140F, 6, 0));
                 * 
                 * // RESPIFLOR - (411)
                 * repoMedicamento.save(new Medicamento("RESPIFLOR", 138.700F, 55.480F, 9, 0));
                 * 
                 * // REVOZYN - (412)
                 * repoMedicamento.save(new Medicamento("REVOZYN", 167.700F, 134.160F, 5, 0));
                 * 
                 * // REXXOLIDE - (413)
                 * repoMedicamento.save(new Medicamento("REXXOLIDE", 87.000F, 34.800F, 1, 0));
                 * 
                 * // RHEMOX - (414)
                 * repoMedicamento.save(new Medicamento("RHEMOX", 113.900F, 68.340F, 1, 0));
                 * 
                 * // RIFACETRIL - (415)
                 * repoMedicamento.save(new Medicamento("RIFACETRIL", 76.300F, 61.040F, 8, 0));
                 * 
                 * // RILEXINE - (416)
                 * repoMedicamento.save(new Medicamento("RILEXINE", 145.800F, 116.640F, 8, 0));
                 * 
                 * // RIMASTINA - (417)
                 * repoMedicamento.save(new Medicamento("RIMASTINA", 98.400F, 39.360F, 2, 0));
                 * 
                 * // ROBUCINA - (418)
                 * repoMedicamento.save(new Medicamento("ROBUCINA", 66.300F, 46.410F, 8, 0));
                 * 
                 * // ROLAXIN - (419)
                 * repoMedicamento.save(new Medicamento("ROLAXIN", 170.900F, 85.450F, 8, 0));
                 * 
                 * // RONAXAN - (420)
                 * repoMedicamento.save(new Medicamento("RONAXAN", 75.400F, 30.160F, 8, 0));
                 * 
                 * // ROXACIN - (421)
                 * repoMedicamento.save(new Medicamento("ROXACIN", 131.500F, 65.750F, 9, 0));
                 * 
                 * // SACHET - (422)
                 * repoMedicamento.save(new Medicamento("SACHET", 132.000F, 92.400F, 5, 0));
                 * 
                 * // SELECTAN - (423)
                 * repoMedicamento.save(new Medicamento("SELECTAN", 73.300F, 29.320F, 6, 0));
                 * 
                 * // SEMELCEF - (424)
                 * repoMedicamento.save(new Medicamento("SEMELCEF", 129.800F, 64.900F, 5, 0));
                 * 
                 * // SERIFLOX - (425)
                 * repoMedicamento.save(new Medicamento("SERIFLOX", 131.500F, 105.200F, 7, 0));
                 * 
                 * // SERIOX - (426)
                 * repoMedicamento.save(new Medicamento("SERIOX", 125.600F, 100.480F, 5, 0));
                 * 
                 * // SERISEPT - (427)
                 * repoMedicamento.save(new Medicamento("SERISEPT", 184.000F, 147.200F, 5, 0));
                 * 
                 * // SOLAMOCTA - (428)
                 * repoMedicamento.save(new Medicamento("SOLAMOCTA", 97.000F, 58.200F, 4, 0));
                 * 
                 * // SOLDOXIN - (429)
                 * repoMedicamento.save(new Medicamento("SOLDOXIN", 199.100F, 139.370F, 1, 0));
                 * 
                 * // SOLIGENTAL - (430)
                 * repoMedicamento.save(new Medicamento("SOLIGENTAL", 167.700F, 100.620F, 5,
                 * 0));
                 * 
                 * // SOLUDOX - (431)
                 * repoMedicamento.save(new Medicamento("SOLUDOX", 121.000F, 96.800F, 5, 0));
                 * 
                 * // SORANOX - (432)
                 * repoMedicamento.save(new Medicamento("SORANOX", 70.800F, 56.640F, 2, 0));
                 * 
                 * // SPIR - (433)
                 * repoMedicamento.save(new Medicamento("SPIR", 133.400F, 53.360F, 3, 0));
                 * 
                 * // SPIZOBACTIN - (434)
                 * repoMedicamento.save(new Medicamento("SPIZOBACTIN", 119.100F, 95.280F, 9,
                 * 0));
                 * 
                 * // STABOX - (435)
                 * repoMedicamento.save(new Medicamento("STABOX", 73.600F, 51.520F, 8, 0));
                 * 
                 * // STOMORGYL - (436)
                 * repoMedicamento.save(new Medicamento("STOMORGYL", 72.700F, 36.350F, 2, 0));
                 * 
                 * // STRENZEN - (437)
                 * repoMedicamento.save(new Medicamento("STRENZEN", 189.900F, 151.920F, 3, 0));
                 * 
                 * // SUIDOX - (438)
                 * repoMedicamento.save(new Medicamento("SUIDOX", 59.000F, 47.200F, 7, 0));
                 * 
                 * // SULFADIM - (439)
                 * repoMedicamento.save(new Medicamento("SULFADIM", 52.800F, 26.400F, 4, 0));
                 * 
                 * // SULFAMETOX - (440)
                 * repoMedicamento.save(new Medicamento("SULFAMETOX", 175.500F, 140.400F, 10,
                 * 0));
                 * 
                 * // SULFAPREX - (441)
                 * repoMedicamento.save(new Medicamento("SULFAPREX", 62.300F, 24.920F, 6, 0));
                 * 
                 * // SULFAPRIM - (442)
                 * repoMedicamento.save(new Medicamento("SULFAPRIM", 165.000F, 66.000F, 9, 0));
                 * 
                 * // SUPER'S - (443)
                 * repoMedicamento.save(new Medicamento("SUPER'S", 51.200F, 20.480F, 2, 0));
                 * 
                 * // SUROLAN - (444)
                 * repoMedicamento.save(new Medicamento("SUROLAN", 172.600F, 120.820F, 1, 0));
                 * 
                 * // SYNULOX - (445)
                 * repoMedicamento.save(new Medicamento("SYNULOX", 195.000F, 97.500F, 9, 0));
                 * 
                 * // SYVAMOX - (446)
                 * repoMedicamento.save(new Medicamento("SYVAMOX", 110.900F, 77.630F, 3, 0));
                 * 
                 * // SYVAQUINOL - (447)
                 * repoMedicamento.save(new Medicamento("SYVAQUINOL", 160.300F, 128.240F, 5,
                 * 0));
                 * 
                 * // TABERNIL - (448)
                 * repoMedicamento.save(new Medicamento("TABERNIL", 168.600F, 118.020F, 10, 0));
                 * 
                 * // TAF - (449)
                 * repoMedicamento.save(new Medicamento("TAF", 69.900F, 48.930F, 6, 0));
                 * 
                 * // TAILAN - (450)
                 * repoMedicamento.save(new Medicamento("TAILAN", 101.400F, 50.700F, 10, 0));
                 * 
                 * // TENALINA - (451)
                 * repoMedicamento.save(new Medicamento("TENALINA", 126.700F, 101.360F, 7, 0));
                 * 
                 * // TENICOL - (452)
                 * repoMedicamento.save(new Medicamento("TENICOL", 89.700F, 35.880F, 7, 0));
                 * 
                 * // TERRALON - (453)
                 * repoMedicamento.save(new Medicamento("TERRALON", 84.400F, 33.760F, 6, 0));
                 * 
                 * // TERRAMICINA - (454)
                 * repoMedicamento.save(new Medicamento("TERRAMICINA", 196.800F, 137.760F, 5,
                 * 0));
                 * 
                 * // TETRACICLINA - (455)
                 * repoMedicamento.save(new Medicamento("TETRACICLINA", 135.000F, 108.000F, 5,
                 * 0));
                 * 
                 * // TETRALONG - (456)
                 * repoMedicamento.save(new Medicamento("TETRALONG", 61.800F, 24.720F, 10, 0));
                 * 
                 * // TETRAMAY - (457)
                 * repoMedicamento.save(new Medicamento("TETRAMAY", 109.800F, 76.860F, 2, 0));
                 * 
                 * // TETROXYVET - (458)
                 * repoMedicamento.save(new Medicamento("TETROXYVET", 80.800F, 64.640F, 1, 0));
                 * 
                 * // THERIOS - (459)
                 * repoMedicamento.save(new Medicamento("THERIOS", 52.300F, 26.150F, 7, 0));
                 * 
                 * // TIALIN - (460)
                 * repoMedicamento.save(new Medicamento("TIALIN", 81.300F, 56.910F, 3, 0));
                 * 
                 * // TIAMINVALL - (461)
                 * repoMedicamento.save(new Medicamento("TIAMINVALL", 58.100F, 29.050F, 2, 0));
                 * 
                 * // TIAMULAB - (462)
                 * repoMedicamento.save(new Medicamento("TIAMULAB", 127.600F, 102.080F, 7, 0));
                 * 
                 * // TIAMULINA - (463)
                 * repoMedicamento.save(new Medicamento("TIAMULINA", 179.800F, 143.840F, 10,
                 * 0));
                 * 
                 * // TIAMUMIX - (464)
                 * repoMedicamento.save(new Medicamento("TIAMUMIX", 181.000F, 144.800F, 4, 0));
                 * 
                 * // TILKOMAY - (465)
                 * repoMedicamento.save(new Medicamento("TILKOMAY", 107.800F, 64.680F, 6, 0));
                 * 
                 * // TILMICOSIN - (466)
                 * repoMedicamento.save(new Medicamento("TILMICOSIN", 84.200F, 42.100F, 10, 0));
                 * 
                 * // TILMICOSOL - (467)
                 * repoMedicamento.save(new Medicamento("TILMICOSOL", 199.500F, 99.750F, 4, 0));
                 * 
                 * // TILMI-KEL - (468)
                 * repoMedicamento.save(new Medicamento("TILMI-KEL", 177.500F, 142.000F, 7, 0));
                 * 
                 * // TILMIPRIL - (469)
                 * repoMedicamento.save(new Medicamento("TILMIPRIL", 198.900F, 119.340F, 6, 0));
                 * 
                 * // TILMISONE - (470)
                 * repoMedicamento.save(new Medicamento("TILMISONE", 90.600F, 54.360F, 9, 0));
                 * 
                 * // TILMOVET - (471)
                 * repoMedicamento.save(new Medicamento("TILMOVET", 156.700F, 109.690F, 4, 0));
                 * 
                 * // TILOCEN - (472)
                 * repoMedicamento.save(new Medicamento("TILOCEN", 146.000F, 87.600F, 7, 0));
                 * 
                 * // TILOMAY - (473)
                 * repoMedicamento.save(new Medicamento("TILOMAY", 68.500F, 47.950F, 10, 0));
                 * 
                 * // TILOSINA - (474)
                 * repoMedicamento.save(new Medicamento("TILOSINA", 152.300F, 106.610F, 2, 0));
                 * 
                 * // TILOSIVEN - (475)
                 * repoMedicamento.save(new Medicamento("TILOSIVEN", 144.900F, 72.450F, 7, 0));
                 * 
                 * // TILOSUL - (476)
                 * repoMedicamento.save(new Medicamento("TILOSUL", 175.200F, 140.160F, 3, 0));
                 * 
                 * // TILOVALL - (477)
                 * repoMedicamento.save(new Medicamento("TILOVALL", 166.400F, 133.120F, 5, 0));
                 * 
                 * // TILOVEX - (478)
                 * repoMedicamento.save(new Medicamento("TILOVEX", 183.500F, 73.400F, 8, 0));
                 * 
                 * // TIRSANICOL - (479)
                 * repoMedicamento.save(new Medicamento("TIRSANICOL", 123.200F, 49.280F, 9, 0));
                 * 
                 * // TIRSANORAL - (480)
                 * repoMedicamento.save(new Medicamento("TIRSANORAL", 179.100F, 107.460F, 4,
                 * 0));
                 * 
                 * // TISERGEN - (481)
                 * repoMedicamento.save(new Medicamento("TISERGEN", 103.000F, 61.800F, 6, 0));
                 * 
                 * // TORUL - (482)
                 * repoMedicamento.save(new Medicamento("TORUL", 117.700F, 70.620F, 6, 0));
                 * 
                 * // TRELACON - (483)
                 * repoMedicamento.save(new Medicamento("TRELACON", 98.700F, 59.220F, 7, 0));
                 * 
                 * // TRIDERM - (484)
                 * repoMedicamento.save(new Medicamento("TRIDERM", 114.400F, 91.520F, 6, 0));
                 * 
                 * // TRIMACROL - (485)
                 * repoMedicamento.save(new Medicamento("TRIMACROL", 52.500F, 42.000F, 3, 0));
                 * 
                 * // TRIMITOS - (486)
                 * repoMedicamento.save(new Medicamento("TRIMITOS", 57.500F, 23.000F, 10, 0));
                 * 
                 * // TRIMSULFASOL - (487)
                 * repoMedicamento.save(new Medicamento("TRIMSULFASOL", 181.400F, 90.700F, 10,
                 * 0));
                 * 
                 * // TROXXAN - (488)
                 * repoMedicamento.save(new Medicamento("TROXXAN", 180.600F, 90.300F, 5, 0));
                 * 
                 * // TSEFALEN - (489)
                 * repoMedicamento.save(new Medicamento("TSEFALEN", 178.700F, 125.090F, 10, 0));
                 * 
                 * // TULAJECT - (490)
                 * repoMedicamento.save(new Medicamento("TULAJECT", 158.100F, 110.670F, 9, 0));
                 * 
                 * // TULAVEN - (491)
                 * repoMedicamento.save(new Medicamento("TULAVEN", 95.700F, 76.560F, 3, 0));
                 * 
                 * // TULIEVE - (492)
                 * repoMedicamento.save(new Medicamento("TULIEVE", 199.800F, 119.880F, 6, 0));
                 * 
                 * // TULINOVET - (493)
                 * repoMedicamento.save(new Medicamento("TULINOVET", 134.400F, 107.520F, 10,
                 * 0));
                 * 
                 * // TULISSIN - (494)
                 * repoMedicamento.save(new Medicamento("TULISSIN", 154.700F, 123.760F, 8, 0));
                 * 
                 * // TULLAVIS - (495)
                 * repoMedicamento.save(new Medicamento("TULLAVIS", 122.000F, 97.600F, 3, 0));
                 * 
                 * // TULOXXIN - (496)
                 * repoMedicamento.save(new Medicamento("TULOXXIN", 126.300F, 88.410F, 6, 0));
                 * 
                 * // TYLMASIN - (497)
                 * repoMedicamento.save(new Medicamento("TYLMASIN", 75.300F, 45.180F, 10, 0));
                 * 
                 * // TYLUCYL - (498)
                 * repoMedicamento.save(new Medicamento("TYLUCYL", 101.300F, 60.780F, 3, 0));
                 * 
                 * // UBROLEXIN - (499)
                 * repoMedicamento.save(new Medicamento("UBROLEXIN", 144.600F, 86.760F, 8, 0));
                 * 
                 * // UBROPEN - (500)
                 * repoMedicamento.save(new Medicamento("UBROPEN", 136.600F, 68.300F, 5, 0));
                 * 
                 * // ULFAPRISOL - (501)
                 * repoMedicamento.save(new Medicamento("ULFAPRISOL", 142.300F, 85.380F, 8, 0));
                 * 
                 * // ULTRADIAZINE - (502)
                 * repoMedicamento.save(new Medicamento("ULTRADIAZINE", 121.100F, 48.440F, 7,
                 * 0));
                 * 
                 * // UNISOL - (503)
                 * repoMedicamento.save(new Medicamento("UNISOL", 172.600F, 138.080F, 10, 0));
                 * 
                 * // UTERSOL - (504)
                 * repoMedicamento.save(new Medicamento("UTERSOL", 159.500F, 63.800F, 6, 0));
                 * 
                 * // UTERTAB - (505)
                 * repoMedicamento.save(new Medicamento("UTERTAB", 147.100F, 102.970F, 1, 0));
                 * 
                 * // VERAFLOX - (506)
                 * repoMedicamento.save(new Medicamento("VERAFLOX", 100.700F, 50.350F, 4, 0));
                 * 
                 * // VETDRAX - (507)
                 * repoMedicamento.save(new Medicamento("VETDRAX", 112.000F, 67.200F, 9, 0));
                 * 
                 * // VETMULIN - (508)
                 * repoMedicamento.save(new Medicamento("VETMULIN", 198.400F, 79.360F, 1, 0));
                 * 
                 * // VETRIMOXIN - (509)
                 * repoMedicamento.save(new Medicamento("VETRIMOXIN", 68.000F, 54.400F, 7, 0));
                 * 
                 * // VIRBACTAN - (510)
                 * repoMedicamento.save(new Medicamento("VIRBACTAN", 181.900F, 145.520F, 3, 0));
                 * 
                 * // XEDEN - (511)
                 * repoMedicamento.save(new Medicamento("XEDEN", 194.700F, 116.820F, 9, 0));
                 * 
                 * // YODIMASPEN - (512)
                 * repoMedicamento.save(new Medicamento("YODIMASPEN", 136.900F, 82.140F, 1, 0));
                 * 
                 * // Z-19 - (513)
                 * repoMedicamento.save(new Medicamento("Z-19", 150.600F, 60.240F, 10, 0));
                 * 
                 * // ZACTRAN - (514)
                 * repoMedicamento.save(new Medicamento("ZACTRAN", 76.200F, 53.340F, 4, 0));
                 * 
                 * // ZELERIS - (515)
                 * repoMedicamento.save(new Medicamento("ZELERIS", 175.300F, 122.710F, 1, 0));
                 * 
                 * // Z-MULIN - (516)
                 * repoMedicamento.save(new Medicamento("Z-MULIN", 102.400F, 81.920F, 1, 0));
                 * 
                 * // ZODON - (517)
                 * repoMedicamento.save(new Medicamento("ZODON", 60.000F, 30.000F, 4, 0));
                 * 
                 * // ZOOBIOTIC - (518)
                 * repoMedicamento.save(new Medicamento("ZOOBIOTIC", 103.400F, 72.380F, 6, 0));
                 * 
                 * // ZOOTYL - (519)
                 * repoMedicamento.save(new Medicamento("ZOOTYL", 93.300F, 65.310F, 1, 0));
                 * 
                 * // ZUPREVO - (520)
                 * repoMedicamento.save(new Medicamento("ZUPREVO", 126.200F, 75.720F, 5, 0));
                 * 
                 * // FLORFEKSYL - (521)
                 * repoMedicamento.save(new Medicamento("FLORFEKSYL", 197.000F, 118.200F, 3,
                 * 0));
                 * 
                 * // TILOLAB - (522)
                 * repoMedicamento.save(new Medicamento("TILOLAB", 187.000F, 149.600F, 9, 0));
                 * 
                 * // METROTAB - (523)
                 * repoMedicamento.save(new Medicamento("METROTAB", 169.300F, 135.440F, 9, 0));
                 */

                // Extrayendo los medicamentos desde el Excel:
                String csvFile = "Archivos Varios/MEDICAMENTOS_VETERINARIA.csv";
                String line;
                String csvSplitBy = ";"; // Separador de las celdas, en este caso punto y coma

                try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

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

                for (int i = 0; i < 100; i++) {
                        Tratamiento tratamiento = new Tratamiento();

                        // Seleccionar nombres y descripciones al azar
                        tratamiento.setNombre(nombresTratamientos[random.nextInt(nombresTratamientos.length)]);
                        tratamiento.setDescripcion(
                                        descripcionesTratamientos[random.nextInt(descripcionesTratamientos.length)]);

                        LocalDate startDate = LocalDate.now().minusMonths(1); // One month ago
                        System.out.println("startDate: " + startDate);
                        LocalDate endDate = LocalDate.now();
                        System.out.println("endDate: " + endDate);

                        tratamiento.setFechaInicio(startDate);
                        tratamiento.setFechaFin(endDate);
                        // Generar un costo aleatorio entre 50.000 y 950.000
                        float randomCost = (random.nextInt(950000 - 50000 + 1) + 50000) / 1000.0f;

                        // Asegurarse de que el formato siempre tiene tres dígitos después del punto
                        // decimal
                        DecimalFormat df = new DecimalFormat("#,000");
                        randomCost = Float.parseFloat(df.format(randomCost));

                        tratamiento.setCosto(randomCost);

                        tratamiento.setFrecuencia("Semanal");

                        // Obtener una mascota, veterinario, y medicamento al azar de las listas.
                        tratamiento.setMascota(mascotas.get(random.nextInt(mascotas.size())));
                        tratamiento.setVeterinario(veterinarios.get(random.nextInt(veterinarios.size())));

                        boolean posible = true;
                        do {
                                int index = random.nextInt(medicamentos.size());
                                if (medicamentos.get(index).getUnidadesDisponibles() > 0) {
                                        medicamentos.get(index).setUnidadesDisponibles(
                                                        medicamentos.get(index).getUnidadesDisponibles() - 1);
                                        medicamentos.get(index).setUnidadesVendidas(
                                                        medicamentos.get(index).getUnidadesVendidas() + 1);
                                        tratamiento.setMedicamento(medicamentos.get(index));
                                        posible = true;
                                } else {
                                        posible = false;
                                }
                        } while (!posible);
                        System.out.println("ID de la mascota");
                        System.out.println(tratamiento.getMascota().getId());
                        System.out.println("Nombre del medicamento");
                        System.out.println(tratamiento.getMedicamento().getNombre());
                        // Guardar el objeto tratamiento en la base de datos.
                        repoTratamiento.save(tratamiento);
                }

                // --------------------------------------------------------------------------------------------------------------------------------------------------------------------
                // --------------------------------------------------------------------------------------------------------------------------------------------------------------------
                // --------------------------------------------------------------------------------------------------------------------------------------------------------------------

                // Retrieve all Usuario objects
                List<Usuario> usuarios = repoUsuario.findAll();

                // Retrieve all Mascota objects
                // Agregado arriba - List<Mascota> mascotas = repoMascota.findAll();

                // Shuffle the list of Mascota objects to randomize their order
                Collections.shuffle(mascotas);

                // Iterate through Usuario objects
                for (Usuario usuario : usuarios) {
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

        private UserEntity saveUserVeterinario(Veterinario veterinario){
                UserEntity userEntity = new UserEntity();
                userEntity.setUsername(veterinario.getEmail());
                userEntity.setPassword(passwordEncoder.encode(veterinario.getPassword()));
                Role roles = roleRepository.findByName("VETERINARIO").get();
                userEntity.setRoles(List.of(roles));
                return userRepository.save(userEntity);

        }
}