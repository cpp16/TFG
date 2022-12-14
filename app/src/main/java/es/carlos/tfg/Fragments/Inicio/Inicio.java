package es.carlos.tfg.Fragments.Inicio;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import es.carlos.tfg.BaseDatos.BDPregunta;
import es.carlos.tfg.BaseDatos.BDResultados;
import es.carlos.tfg.BaseDatos.BDRetos;
import es.carlos.tfg.BaseDatos.BDUsuarios;
import es.carlos.tfg.Fragments.Login.Login;
import es.carlos.tfg.Fragments.Selectores.SelectorNivel;
import es.carlos.tfg.Fragments.Selectores.SelectorTipo;
import es.carlos.tfg.R;

public class Inicio extends AppCompatActivity {
    public Inicio(){
        super(R.layout.activity_inicio);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BDRetos bdRetos = new BDRetos(this);
        SQLiteDatabase db = bdRetos.getWritableDatabase();
        db.execSQL("create table if not exists retos (id INTEGER PRIMARY KEY AUTOINCREMENT, pregunta TEXT, respuestaA TEXT, respuestaB TEXT, respuestaC TEXT, respuestaOK TEXT, nivel INTEGER, tipo TEXT)");
        if(!bdRetos.checkIfDbExists()){
            insertarRetos();
        }

        BDUsuarios bdUsuarios = new BDUsuarios(this);
        SQLiteDatabase db2 = bdUsuarios.getWritableDatabase();
        db2.execSQL("create table if not exists usuarios (id INTEGER PRIMARY KEY AUTOINCREMENT, usuario TEXT, email TEXT, password TEXT)");

        BDResultados bdResultados = new BDResultados(this);
        SQLiteDatabase db3 = bdResultados.getWritableDatabase();
        db3.execSQL("create table if not exists resultados (id INTEGER PRIMARY KEY AUTOINCREMENT, id_usuario INTEGER, fecha_hora TEXT, aciertos INTEGER, fallos INTEGER, preguntas TEXT, respuestas TEXT)");

        BDPregunta bdPregunta = new BDPregunta(this);
        SQLiteDatabase db4 = bdPregunta.getWritableDatabase();
        db4.execSQL("create table if not exists pregunta (id INTEGER PRIMARY KEY AUTOINCREMENT, id_reto integer, pregunta TEXT, respuestaA TEXT, respuestaB TEXT, respuestaC TEXT, respuestaOK TEXT)");

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .setReorderingAllowed(true)
                    .add(R.id.fragmentContainerView, Login.class, null)
                    .commit();
        }
    }

    private void insertarRetos(){
        BDRetos bd = new BDRetos(this);

        //Retos Cultura General
        bd.insertarReto("¿Cual es el nombre del rio mas largo del mundo?", "Rio Amazonas", "Rio Nilo", "Rio Amazonas", "Rio Danubio", 1, "CulturaGeneral");
        bd.insertarReto("¿Cual es el oceano mas grande del mundo?", "Oceano Pacifico", "Oceano Pacifico", "Oceano Indico", "Oceano Atlantico", 1, "CulturaGeneral");
        bd.insertarReto("¿Cual es el pais mas grande de mundo?", "Rusia", "China", "Rusia", "India", 1, "CulturaGeneral");
        bd.insertarReto("¿Cual es el pais con forma de bota?", "Italia", "España", "Honduras", "Italia", 1, "CulturaGeneral");
        bd.insertarReto("¿Cual es el pais mas poblado de la tierra?", "China", "Estados Unidos", "China", "Rusia", 1, "CulturaGeneral");
        bd.insertarReto("¿Cual es la ciudad de los rascacielos?", "Nueva York", "Tokio", "Nueva York", "Hong Kong", 1, "CulturaGeneral");
        bd.insertarReto("¿Cual es la nacion mas pequeña del mundo?", "El Vaticano", "Andorra", "Monaco", "El Vaticano", 1, "CulturaGeneral");
        bd.insertarReto("¿Cual es la cascada mas alta del mundo?", "El Salto del Angel", "El Salto del Angel", "Cataratas de Iguazu", "Cataratas del Niagara", 1, "CulturaGeneral");
        bd.insertarReto("¿Cuando termino la II Guerra Mundial?", "1945", "1945", "1947", "1943", 1, "CulturaGeneral");
        bd.insertarReto("¿En que año llegó Cristobal Colon a America?", "1492", "1429", "1492", "1592", 1, "CulturaGeneral");
        bd.insertarReto("¿Cual es el libro sagrado de los musulmanes?", "El Coran", "La Biblia", "El Talmud", "El Coran", 1, "CulturaGeneral");
        bd.insertarReto("¿A que se denomina septimo arte?", "Cine", "Pintura", "Escultura", "Cine", 1, "CulturaGeneral");
        bd.insertarReto("¿Que es un melomano?", "Un amante de la musica", "Un amante de la musica", "Un amante del cine", "Un amante de los comics", 1, "CulturaGeneral");
        bd.insertarReto("¿Cuales son las notas musicales?", "Do, Re, Mi, Fa, Sol, La, Si", "Do, Re, Mi", "Do, Re, Mi, Sol, La, Si, Do", "Do, Re, Mi, Fa, Sol, La, Si", 1, "CulturaGeneral");
        bd.insertarReto("¿Como se denomina al resultado de una multiplicacion?", "Producto", "Multiplo", "Resultado", "Producto", 1, "CulturaGeneral");
        bd.insertarReto("¿Como se denomina al tipo de triangulo que tiene sus tres lados iguales?", "Equilatero", "Isosceles", "Equilatero", "Recto", 1, "CulturaGeneral");
        bd.insertarReto("¿Que rama de la biologia estudia a los animales?", "Zoologia", "Zoologia", "Fauna", "Medicina", 1, "CulturaGeneral");
        bd.insertarReto("¿Cuantas patas tiene una araña?", "8", "6", "10", "8", 1, "CulturaGeneral");
        bd.insertarReto("¿Cual es el animal mas rapido del mundo?", "Guepardo", "Condor", "Leopardo", "Guepardo", 1, "CulturaGeneral");
        bd.insertarReto("¿Como se denomina a los animales que nacen de un huevo?", "Oviparos", "Hueviparos", "Viviparos", "Oviparos", 1, "CulturaGeneral");
        bd.insertarReto("¿Cuales son los colores primarios?", "Rojo, amarillo y azul", "Rojo, amarillo y azul", "Verde, naranja y morado", "Blanco y negro", 1, "CulturaGeneral");
        bd.insertarReto("¿Cual es la cordillera mas larga del mundo?", "Cordillera de los Andes", "Everest", "Cordillera de los Andes", "Sierra Morena", 1, "CulturaGeneral");
        bd.insertarReto("¿Cual es el organo mas grande del cuerpo humano?", "Piel", "Intestino Delgado", "Piel", "Estomago", 1, "CulturaGeneral");
        bd.insertarReto("¿De que color es la sangre cuando esta dentro de tu organismo?", "Roja", "Roja", "Verde", "Azul", 1, "CulturaGeneral");
        bd.insertarReto("¿Cual es el continente mas grande del planeta?", "Asia", "Europa", "Asia", "Oceania", 1, "CulturaGeneral");
        bd.insertarReto("¿Cual es la capital de Nicaragua?", "Managua", "Santiago", "Brasilia", "Managua", 2, "CulturaGeneral");
        bd.insertarReto("¿En que pais se encuentra Medellin?", "Colombia", "Colombia", "Venezuela", "Peru", 2, "CulturaGeneral");
        bd.insertarReto("¿Cual es la ciudad italiana conocida como 'la novia del mar'?", "Roma", "Florencia", "Venecia", "", 2, "CulturaGeneral");
        bd.insertarReto("¿Cual es la capital de Pakistan?", "Islambad", "Bagdag", "Islambad", "Marrakech", 2, "CulturaGeneral");
        bd.insertarReto("¿Quien era el general de los nazis en la II Guerra Mundial?", "Adolf Hitler", "Benito Mussolini", "Adolf Hitler", "Heinrich Himmler", 2, "CulturaGeneral");
        bd.insertarReto("¿En que pais se uso la primera bomba atomica?", "Japon", "Rusia", "Estados Unidos", "Japon", 2, "CulturaGeneral");
        bd.insertarReto("¿Cual es el idioma mas antiguo que pervive en Europa?", "Vasco", "Vasco", "Ingles", "Frances", 2, "CulturaGeneral");
        bd.insertarReto("¿Cual fue el primer hombre en ir a la luna?", "Neil Armstrong", "Louis Armstrong", "Neil Armstrong", "Michael Armstrong", 2, "CulturaGeneral");
        bd.insertarReto("¿De que año es la primera constitucion española conocida como 'La Pepa'?", "1812", "1812", "1835", "1978", 2, "CulturaGeneral");
        bd.insertarReto("¿Quien escribio La Odisea?", "Homero", "Homero", "Virgilio", "Cervantes", 2, "CulturaGeneral");
        bd.insertarReto("¿Cual es la obra mas importante de la literatura en español?", "Don Quijote de la Mancha", "El Principito", "Don Quijote de la Mancha", "Cien años de soledad", 2, "CulturaGeneral");
        bd.insertarReto("¿Como se llama el Himno Nacional de Francia?", "La Marsellesa", "La Internacional", "La Marsellesa", "La solitaria", 2, "CulturaGeneral");
        bd.insertarReto("¿Quien escribio 'Cien años de soledad'?", "Gabriel Garcia Marquez", "Gabriel Garcia Marquez", "Mario Vargas Llosa", "Camilo Jose Cela", 2, "CulturaGeneral");
        bd.insertarReto("¿Quien pinto 'La noche estrellada'?", "Vincent van Gogh", "Vincent van Gogh", "Rembrandt", "Velazquez", 2, "CulturaGeneral");
        bd.insertarReto("¿Quien es denominado el Rey del Rock and Roll en Estados Unidos?", "Elvis Presley", "Bruce Springsteen", "Michael Jackson", "Elvis Presley", 2, "CulturaGeneral");
        bd.insertarReto("¿A cuanto equivale el numero Pi?", "3.1416", "3.1614", "3.1416", "3.416", 2, "CulturaGeneral");
        bd.insertarReto("¿Cual fue el primer metal que emplearon los seres humanos?", "Cobre", "Bronce", "Acero", "Cobre", 2, "CulturaGeneral");
        bd.insertarReto("¿Cual es el primero de los numeros primos?", "2", "0", "1", "2", 2, "CulturaGeneral");
        bd.insertarReto("¿Cual es el primer elemento de la Tabla Periodica?", "Hidrogeno", "Helio", "Argon", "Hidrogeno", 2, "CulturaGeneral");
        bd.insertarReto("¿Cual es el unico mamifero que puede volar?", "Murcielago", "Muricelago", "Avestruz", "Aguila", 2, "CulturaGeneral");
        bd.insertarReto("¿Como se llama el proceso por medio del cual las plantas obtienen su alimento?", "Fotosintesis", "Biosintesis", "Fotosintesis", "Luminosintesis", 2, "CulturaGeneral");
        bd.insertarReto("¿Cual es el ave voladora mas grande del mundo?", "Condor Andino", "Aguila Real", "Condor Andino", "Halcon", 2, "CulturaGeneral");
        bd.insertarReto("¿Cual es la rama de la biologia que estudia las plantas?", "Botanica", "Zoologoa", "Botanica", "Mineralogia", 2, "CulturaGeneral");
        bd.insertarReto("¿Cual es la capital de Bielorrusia?", "Minsk", "Minsk", "Paris", "Caracas", 2, "CulturaGeneral");
        bd.insertarReto("¿Donde se encuentra el Monte Fuji?", "Japon", "China", "Japon", "Tailandia", 2, "CulturaGeneral");
        bd.insertarReto("¿En que pais se encuentra ubicada la Casa Rosada?", "Argentina", "Argentina", "Chile", "Brasil", 3, "CulturaGeneral");
        bd.insertarReto("¿En que continente se encuentra Surinam?", "America del Sur", "Africa", "America del Sur", "Oceania", 3, "CulturaGeneral");
        bd.insertarReto("¿Cual es la unica ciudad que esta en dos continentes distintos?", "Estambul", "Moscu", "Estambul", "Berlin", 3, "CulturaGeneral");
        bd.insertarReto("¿Cual es la segunda montaña mas alta del mundo?", "K2", "K2", "K1", "K3", 3, "CulturaGeneral");
        bd.insertarReto("¿Quien es el padre del psicoanalisis?", "Sigmund Freud", "Sigmund Freud", "Carl Gustav Jung", "Skinner", 3, "CulturaGeneral");
        bd.insertarReto("¿Como se llama la primera mujer que viajo al espacio?", "Valentina Tereshkova", "Valentina Tereshkova", "Alexandra Tereshkova", "Amanda Tereshkova", 3, "CulturaGeneral");
        bd.insertarReto("¿En que guerra participo Juana de Arco?", "Guerra de los 100 años", "Guerra de la independencia francesa", "Guerra de los 100 años", "Guerra Civil Española", 3, "CulturaGeneral");
        bd.insertarReto("¿Quien fue el primer emperador romano?", "Cesar Augusto", "Cesar Augusto", "Julio Cesar", "Marco Aurelio", 3, "CulturaGeneral");
        bd.insertarReto("¿En que isla murio Napoleon?", "Santa Elena", "Sicilia", "Santa Elena", "Creta", 3, "CulturaGeneral");
        bd.insertarReto("¿Que año solo tuvo 355 dias?", "1582", "1615", "1615", "1823", 3, "CulturaGeneral");
        bd.insertarReto("¿Quien pinto el famoso cuadro 'La Ultima Cena'?", "Leonardo da Vinci", "Rembrandt", "Velazquez", "Leonardo da Vinci", 3, "CulturaGeneral");
        bd.insertarReto("¿Como se llama la estrofa poetica que esta conformada por 10 versos de 8 silabas cada uno?", "Decima espinela", "Decima espinera", "Decasilabo", "Decasilabo octogonal", 3, "CulturaGeneral");
        bd.insertarReto("¿Cual es el nombre de la artista mexicana conocida como 'la Doña'?", "Maria Felix", "Maria Felix", "Paulina Rubio", "Frida Kahlo", 3, "CulturaGeneral");
        bd.insertarReto("¿En que año murio Kurt Cobain?", "1994", "1996", "1994", "1998", 3, "CulturaGeneral");
        bd.insertarReto("¿Quien compuso Los Conciertos de Branderburgo?", "Bach", "Mozart", "Beethoven", "Bach", 3, "CulturaGeneral");
        bd.insertarReto("¿Cual es el elemento quimico mas abundante en la corteza terrestre?", "Oxigeno", "Oxigeno", "Nitrogeno", "Carbono", 3, "CulturaGeneral");
        bd.insertarReto("¿Como se le denomina al centro de un atomo?", "Nucleo", "Electron", "Nucleo", "Proton", 3, "CulturaGeneral");
        bd.insertarReto("¿Cual es el gas que se encuentra en mayor cantidad en el aire que respiramos?", "Nitrogeno", "Nitrogeno", "Oxigeno", "Carbono", 3, "CulturaGeneral");
        bd.insertarReto("¿Cual es el simbolo quimico del oro?", "Au", "Or", "Au", "Ao", 3, "CulturaGeneral");
        bd.insertarReto("¿Que es el cobalto?", "Un mineral", "Un mineral", "un vegetal", "un animal", 3, "CulturaGeneral");
        bd.insertarReto("¿Que se le agrega al hierro para hacer acero?", "Carbono", "Oxigeno", "Carbono", "Nitrogeno", 3, "CulturaGeneral");
        bd.insertarReto("¿En que parte del cuerpo se produce la insulina?", "Pancreas", "Higado", "Pulmones", "Pancreas", 3, "CulturaGeneral");
        bd.insertarReto("¿Cuantos corazones tiene un pulpo?", "3", "1", "Ninguno", "3", 3, "CulturaGeneral");
        bd.insertarReto("¿Cuantos huesos tiene en total un ser humano?", "206", "60", "206", "416", 3, "CulturaGeneral");
        bd.insertarReto("¿Cuantos paises reconocidos existen en todo el mundo?", "195", "193", "201", "195", 3, "CulturaGeneral");

        //Retos Geografia
        bd.insertarReto("¿En que pais se puede visitar Machu Picchu?", "Peru", "Colombia", "Peru", "Mexico", 1, "Geografia");
        bd.insertarReto("¿En que cordillera se encuentra el Monte Everest?", "Himalaya", "Himalaya", "Cordillera de Los Andes", "Montes Urales", 1, "Geografia");
        bd.insertarReto("¿Cuales son los continentes de la tierra?", "Africa, Antartida, Asia, Oceania, Europa y America", "Africa, Asia y Europa", "Africa, Antartida, Asia, Oceania, Europa y America", "Europa y Asia", 1, "Geografia");
        bd.insertarReto("¿Cuales son los cinco oceanos del mundo?", "Artico, Atlantico, Indico, Pacifico y Antartico", "Pacifico, Atlantico e Indico", "Artico, Atlantico, Mediterraneo, Pacifico y Antartico", "Artico, Atlantico, Indico, Pacifico y Antartico", 1, "Geografia");
        bd.insertarReto("¿Cual es el pais mas grande de Sudamerica?", "Brasil", "Argentina", "Brasil", "Chile", 1, "Geografia");
        bd.insertarReto("¿Cual es la isla mas grande del mundo?", "Groelandia", "Noruega", "Suecia", "Groelandia", 1, "Geografia");
        bd.insertarReto("¿Que estrecho separa Marruecos de España?", "Estrecho de Gibraltar", "Estrecho de Magallanes", "Estrecho de Gibraltar", "Canal de la Mancha", 1, "Geografia");
        bd.insertarReto("¿Cual es el continente mas grande de la tierra?", "Asia", "Asia", "Europa", "America", 1, "Geografia");
        bd.insertarReto("¿Cual es la capital de Australia?", "Canberra", "Melbourne", "Camberra", "Sidney", 1, "Geografia");
        bd.insertarReto("¿En que peninsula se encuentra la ciudad mexicana de Tulum?", "Peninsula de Yucatan", "Peninsula de Yucatan", "Peninsula de Baja California", "Peninsula de Jutlandia", 1, "Geografia");
        bd.insertarReto("¿De que pais es capital la ciudad de Viena?", "Austria", "Austria", "Suiza", "Belgica", 1, "Geografia");
        bd.insertarReto("¿Cual es el idioma oficial de Brasil?", "Portugues", "Español", "Portugues", "Ingles", 1, "Geografia");
        bd.insertarReto("¿Cual es el punto mas profundo de los oceanos de la Tierra?", "Fosa de las Marianas", "Abismo Brownson", "Abismo de Challenger", "Fosa de las Marianas", 1, "Geografia");
        bd.insertarReto("¿Que pais asiatico tiene a Kuala Lumpur como su capital?", "Malasia", "Malasia", "Tailandia", "Laos", 1, "Geografia");
        bd.insertarReto("¿Que rio atraviesa Paris?", "rio Sena", "rio Rin", "rio Sena", "rio Aller", 1, "Geografia");
        bd.insertarReto("Junto con España y Francia, ¿cual es el otro pais que tienen costas tanto del Atlantico como del Mediterraneo?", "Marruecos", "Marruecos", "Portugal", "Italia", 1, "Geografia");
        bd.insertarReto("¿Cual es el oceano mas grande del mundo en superficie?", "oceano Pacifico", "oceano Atlantico", "oceano Pacifico", "oceano Indico", 1, "Geografia");
        bd.insertarReto("¿El nombre de que pais se origina a partir de una linea de latitud?", "Ecuador", "Ecuador", "Peru", "Chile", 1, "Geografia");
        bd.insertarReto("¿Que pais se encuentra en los Pirineos entre España y Francia?", "Andorra", "Andorra", "Portugal", "Monaco", 1, "Geografia");
        bd.insertarReto("¿De que pais forma parte Cataluña?", "España", "Portugal", "Francia", "España", 1, "Geografia");
        bd.insertarReto("¿Cual es el pais mas pequeño del mundo?", "Ciudad del Vaticano", "Ciudad del Vaticano", "San Marino", "Andorra", 1, "Geografia");
        bd.insertarReto("¿Cuantos oceanos hay en la Tierra?", "5", "3", "6", "5", 1, "Geografia");
        bd.insertarReto("¿Cual es la montaña mas alta de la Tierra?", "Monte Everest", "Monte K2", "Monte Everest", "Monte Lhotse", 1, "Geografia");
        bd.insertarReto("¿Que continente es el mas grande?", "Asia", "Asia", "Europa", "Africa", 1, "Geografia");
        bd.insertarReto("¿Cual es la capital de Suiza?", "Berna", "Zurich", "Berna", "Ginebra", 1, "Geografia");
        bd.insertarReto("¿Donde desemboca el rio Amazonas?", "Oceano Atlantico", "Oceano Indico", "Oceano Pacifico", "Oceano Atlantico", 2, "Geografia");
        bd.insertarReto("¿Cual es el desierto mas grande del mundo?", "La Antartida", "Desierto del Sahara", "Desierto de Gobi", "La Antartida", 2, "Geografia");
        bd.insertarReto("¿Cual es el principal rio que recorre el Gran Cañon de Estados Unidos?", "Rio Colorado", "Rio Colorado", "Rio Rin", "Rio Nilo", 2, "Geografia");
        bd.insertarReto("¿En que ciudad se encuentra la Puerta de Brandeburgo?", "Berlin", "Berlin", "Munich", "Paris", 2, "Geografia");
        bd.insertarReto("¿Donde se encuentra el rio Tamesis?", "Londres", "Paris", "Londres", "Venecia", 2, "Geografia");
        bd.insertarReto("¿Cual es el pais mas grande de la Peninsula Arabiga?", "Arabia Saudita", "Arabia Saudita", "Emiratos Arabes Unidos", "Catar", 2, "Geografia");
        bd.insertarReto("¿Que rio discurre por Roma?", "rio Tiber", "rio Danubio", "rio Tiber", "rio Tamesis", 2, "Geografia");
        bd.insertarReto("¿Que continente contiene la mayor cantidad de agua dulce?", "Antartida", "Europa", "Asia", "Antartida", 2, "Geografia");
        bd.insertarReto("¿Cual es la ciudad mas grande que conecta dos continentes?", "Estanbul", "Estanbul", "Moscu", "Kiev", 2, "Geografia");
        bd.insertarReto("¿Que pais europeo se encuentra mas al oeste?", "Islandia", "Islandia", "Reino Unido", "Portugal", 2, "Geografia");
        bd.insertarReto("¿Que oceano alberga el 75% de los volcanes de la Tierra?", "oceano Pacifico", "oceano Indico", "oceano Pacifico", "oceano Atlantico", 2, "Geografia");
        bd.insertarReto("¿Que nacion africana tiene mas piramides?", "Sudan", "Egipto", "Sudan", "Marruecos", 2, "Geografia");
        bd.insertarReto("¿Cual es el pais mas poblado de Africa?", "Nigeria", "Nigeria", "Senegal", "Costa de Marfil", 2, "Geografia");
        bd.insertarReto("¿En que pais se encuentra Transilvania?", "Rumania", "Bulgaria", "Rumania", "Croacia", 2, "Geografia");
        bd.insertarReto("¿Cual es el pais mas pequeño de America del Sur?", "Surinam", "Bolivia", "Surinam", "Venezuela", 2, "Geografia");
        bd.insertarReto("¿Que pais ocupa mas de la mitad de la costa occidental de America del Sur?", "Chile", "Argentina", "Chile", "Brasil", 2, "Geografia");
        bd.insertarReto("¿De que pais son los maories?", "Nueva Zelanda", "Australia", "Samoa", "Nueva Zelanda", 2, "Geografia");
        bd.insertarReto("¿Que pais tiene mas costa?", "Canada", "Canada", "Australia", "Rusia", 2, "Geografia");
        bd.insertarReto("¿Que continente se encuentra en los cuatro hemisferios?", "Africa", "Asia", "Europa", "Africa", 2, "Geografia");
        bd.insertarReto("¿En que oceano se encuentran las islas Maldivas?", "oceano Indico", "oceano Atlantico", "oceano Pacifico", "oceano Indico", 2, "Geografia");
        bd.insertarReto("¿Que oceano rodea Hawai?", "oceano Pacifico", "oceano Pacifico", "oceano Atlantico", "oceano Indico", 2, "Geografia");
        bd.insertarReto("¿Cual es el rio mas grande de la India?", "rio Ganges", "rio Godavari", "rio Indo", "rio Ganges", 2, "Geografia");
        bd.insertarReto("¿En que mar desemboca el rio Nilo?", "mar Mediterraneo", "mar Muerto", "mar Mediterraneo", "mar Rojo", 2, "Geografia");
        bd.insertarReto("¿Cual es la ciudad mas grande de Escocia?", "Glasgow", "Glasgow", "Edimburgo", "Aberdeen", 2, "Geografia");
        bd.insertarReto("¿Con que pais comparte Chile la mayor parte de su territorio?", "Argentina", "Argentina", "Brasil", "Peru", 2, "Geografia");
        bd.insertarReto("¿Cual es la ciudad mas antigua del mundo?", "Damasco", "Damasco", "Roma", "Jerusalen", 3, "Geografia");
        bd.insertarReto("¿Cual es la isla mas grande del mar Caribe?", "Cuba", "Puerto Rico", "Cuba", "Republica Dominicana", 3, "Geografia");
        bd.insertarReto("¿Que nombre se le da a la parte norte de China?", "Manchuria", "Manchuria", "Mongolia", "Norteños", 3, "Geografia");
        bd.insertarReto("¿Que pais tiene mas volcanes?", "Estados Unidos", "Chile", "Estados Unidos", "Argentina", 3, "Geografia");
        bd.insertarReto("¿Que volcan se encuentra cerca de la antigua ciudad de Pompeya?", "Monte Vesubio", "Caldera de Yellowstone", "Monte Vesubio", "Dorsal de Cumbre Vieja", 3, "Geografia");
        bd.insertarReto("¿Que ciudad se conocia antes como Nueva Amsterdam?", "Nueva York", "Washington D.C.", "California", "Nueva York", 3, "Geografia");
        bd.insertarReto("¿Que continente se conocia como Alkebulan?", "Africa", "Africa", "America", "Oceania", 3, "Geografia");
        bd.insertarReto("¿Que montaña es apodada como la 'Montaña Salvaje'?", "K2", "K1", "K2", "K3", 3, "Geografia");
        bd.insertarReto("¿Cual es el lago mas profundo del mundo?", "Lago Baikal", "Lago Titicaca", "Lago Baikal", "Lago Ness", 3, "Geografia");
        bd.insertarReto("¿Que via artificial conecta el oceano Pacifico con el oceano Atlantico?", "Canal de Panama", "Canal de Panama", "Canal de la Mancha", "Canal de Suez", 3, "Geografia");
        bd.insertarReto("¿Que mar rodea la isla mexicana de Cozumel?", "Mar Caribe", "Mar Mediterraneo", "Mar Muerto", "Mar Caribe", 3, "Geografia");
        bd.insertarReto("¿Que ciudad tuvo una vez el nombre de Leningrado?", "San Petersburgo", "Moscu", "Sochi", "San Petersburgo", 3, "Geografia");
        bd.insertarReto("¿Cual es el punto natural mas bajo en Mexico?", "Laguna Salada", "Cozumel", "Tijuana", "Laguna Salada", 3, "Geografia");
        bd.insertarReto("¿En que pais se encuentra la selva negra?", "Alemania", "Brasil", "Alemania", "Peru", 3, "Geografia");
        bd.insertarReto("¿En que ciudad se encuentra el Taj Mahal?", "Agra", "Calcuta", "Jalpur", "Agra", 3, "Geografia");
        bd.insertarReto("¿Que termino se usa para describir la masa de tierra unica e ininterrumpida que formaba la Tierra hace 100 millones de años?", "Pangea", "Pangea", "Ur", "Rodinia", 3, "Geografia");
        bd.insertarReto("¿Cual es el pico mas alto en Argentina?", "Aconcagua", "Volcan Ata", "Aconcagua", "Monte Pissis", 3, "Geografia");
        bd.insertarReto("¿En que estado de Estados Unidos se encuentra la cuidad de Metropolis?", "Illinois", "Illinois", "Florida", "Texas", 3, "Geografia");
        bd.insertarReto("¿Que pais africano sirvio de escenario para Tattoine en Star Wars?", "Tunez", "Tunez", "Egipto", "Marruecos", 3, "Geografia");
        bd.insertarReto("¿Que canal conecta el mar Mediterraneo y el mar Rojo?", "Canal de Suez", "Canal de Suez", "Canal de la Mancha", "Canal de Panama", 3, "Geografia");
        bd.insertarReto("¿Cual es el mar mas frio de la Tierra?", "mar Blanco", "mar Blanco", "mar de Noruega", "mar del Norte", 3, "Geografia");
        bd.insertarReto("¿Cual es el monte mas alto de America del Norte?", "Monte Denali", "Monte Denali", "Monte Logan", "Nonte San Elias", 3, "Geografia");
        bd.insertarReto("¿Cual es la isla mas grande del mar Mediterraneo?", "Sicilia", "Chipre", "Malta", "Sicilia", 3, "Geografia");
        bd.insertarReto("¿Que pais tiene mas lagos naturales?", "Canada", "Canada", "Estados Unidos", "Alemania", 3, "Geografia");
        bd.insertarReto("¿Que rio atraviesa Bagdad?", "rio Tigris", "rio Eufrates", "rio Obi", "rio Tigris", 3, "Geografia");

        //Retos Historia
        bd.insertarReto("¿Que inició la II Guerra Mundial?", "Alemania invadio Polonia", "Alemania invadio Polonia", "El asesinato del archiduque Francisco Fernando", "Hitler invadio Austria", 1, "Historia");
        bd.insertarReto("¿Donde se han encontrado principalmente pinturas del periodo Paleolitico?", "En cuevas", "No existen pinturas procedentes del Paleolitico", "En cuevas", "En vasijas decoradas", 1, "Historia");
        bd.insertarReto("¿Como comenzo la I Guerra Mundial?", "Con el asesinato del archiduque Francisco Fernando", "Con el intento de asesinato del principe belga Leopold", "Con el asesinato del archiduque Francisco Fernando", "COn la batalla de Gallipoli", 1, "Historia");
        bd.insertarReto("¿En que año descubrio Cristobal Colon America?", "1492", "1492", "1592", "1498", 1, "Historia");
        bd.insertarReto("¿De que año es la primera Constitucion española, la Pepa?", "1812", "1978", "1812", "1931", 1, "Historia");
        bd.insertarReto("¿En que año cayo el Imperio Romano de Occidente?", "476 d.C.", "572 d.C.", "476 d.C.", "27 a.C.", 1, "Historia");
        bd.insertarReto("¿Quien fue el primer hombre que piso la luna?", "Neil Armstrong", "Valentina Tereshckova", "Neil Armstrong", "Buzz Aldrin", 1, "Historia");
        bd.insertarReto("¿En que pais se inicio la Revolucion Industrial?", "Gran Bretaña", "Francia", "Italia", "Gran Bretaña", 1, "Historia");
        bd.insertarReto("¿Quien invento la imprenta?", "Johannes Gutenberg", "Los antiguos chinos", "Johannes Gutenberg", "Thomas Edison", 1, "Historia");
        bd.insertarReto("¿En que año termino la II Guerra Mundial?", "1945", "1945", "1947", "1943", 1, "Historia");
        bd.insertarReto("¿Como llamaron los romanos a la Peninsula Iberica?", "Hispania", "Iberix", "Lusitania", "Hispania", 1, "Historia");
        bd.insertarReto("¿Cuantas republicas ha habido en la España Contemporanea?", "Dos", "Una", "Ninguna", "Dos", 1, "Historia");
        bd.insertarReto("¿En que año estallo la Guerra Civil Española?", "1936", "1936", "1937", "1939", 1, "Historia");
        bd.insertarReto("¿En que periodo de la historia se empezaron a domesticar los animales?", "Neolitico", "Paleolitico", "Neolitico", "Edad de los Metales", 1, "Historia");
        bd.insertarReto("¿En que lugar del mundo se origino la humanidad?", "Africa", "Africa", "Europa", "Asia", 1, "Historia");
        bd.insertarReto("¿Quien fue el ultimo emperador romano en occidente?", "Romulo Augustulo", "Julio Cesar", "Romulo Augustulo", "Neron", 1, "Historia");
        bd.insertarReto("¿A que general dio el poder Alfonso XIII en 1923?", "Miguel Primo de Rivera", "Francisco Franco", "Miguel Primo de Rivera", "Jose Antonio Primo de Rivera", 1, "Historia");
        bd.insertarReto("¿Que conflicto armado pone fin a la dinastia de los Austrias en España?", "Guerra de Sucesion", "Guerra de Sucesion", "Guerra de Independencia", "Guerra Civil", 1, "Historia");
        bd.insertarReto("¿Como se llamo el primer presidente de la democracia española despues del franquismo?", "Adolfo Suarez", "Felipe Gonzalez", "Leopoldo Calvo-Sotelo", "Adolfo Suarez", 1, "Historia");
        bd.insertarReto("Cuanto duro la II Republica Española", "8 años", "5 años", "8 años", "10 años", 1, "Historia");
        bd.insertarReto("¿Cual era la moneda utilizada en España antes del euro?", "La peseta", "El franco", "La peseta", "El duro", 1, "Historia");
        bd.insertarReto("La caida de Constantinopla significo el fin del Imperio Bizantino, ¿en que año sucedio?", "1453", "1492", "1473", "1453", 1, "Historia");
        bd.insertarReto("¿En que año llego el hombre a la luna?", "1969", "1985", "1969", "1956", 1, "Historia");
        bd.insertarReto("¿En que año se disolvio la Union Sovietica?", "1991", "1991", "2003", "1999", 1, "Historia");
        bd.insertarReto("¿Que carabela no regreso del primer viaje de Colon al Nuevo Mundo?", "Santa Maria", "La niña", "La pinta", "Santa Maria", 1, "Historia");
        bd.insertarReto("¿De que nacionalidad era Juana de Arco?", "Francesa", "Inglesa", "Italiana", "Francesa", 2, "Historia");
        bd.insertarReto("¿Quien dibujo al famoso hombre de Vitrubio?", "Leonardo da Vinci", "Miguel Angel", "Leonardo da Vinci", "Rubens", 2, "Historia");
        bd.insertarReto("¿De que nacionalidad era Adolf Hitler?", "Austriaco", "Aleman", "Polaco", "Austriaco", 2, "Historia");
        bd.insertarReto("¿Cual es el antiguo nombre de San Petersburgo?", "Leningrado", "San Petersburgo", "Stalingrado", "Leningrado", 2, "Historia");
        bd.insertarReto("¿Que isla genero un conflicto entre Reino Unido y Argentina?", "Las islas Malvinas", "Las islas Malvinas", "Islote Perejil", "Islas Marianas", 2, "Historia");
        bd.insertarReto("¿De que nacionalidad era Ernesto Che Guevara?", "Argentino", "Argentino", "Boliviano", "Mexicano", 2, "Historia");
        bd.insertarReto("¿Que presidente estadounidense fue asesinado en Dallas?", "John F. Kennedy", "John F. Kennedy", "Robert Kennedy", "Abraham Lincoln", 2, "Historia");
        bd.insertarReto("¿Que funcion tenian las piramides?", "Eran monumentos funerarios", "Eran monumentos funerarios", "Eran monumentos en honor a los dioses", "Eran monumentos para honrar en vida a sus faraones", 2, "Historia");
        bd.insertarReto("¿Donde tuvo lugar la revolucion de los misiles?", "Cuba", "Panama", "Colombia", "Cuba", 2, "Historia");
        bd.insertarReto("¿Quien fue el dictador italiano que lideraba Italia al comienzo de la II Guerra Mundial?", "Benito Mussolini", "Benito Mussolini", "Victor Manuel II", "Humberto I", 2, "Historia");
        bd.insertarReto("¿Que volcan devasto Pompeya?", "El Vesubio", "El Etna", "El Vesubio", "El Santa Helena", 2, "Historia");
        bd.insertarReto("¿?Cual era la capital del Imperio Inca", "Cuzco", "Cuzco", "Quito", "Machu Picchu", 2, "Historia");
        bd.insertarReto("¿Cuando se produjo principalmente el Siglo de Oro?", "Siglo XVI", "Siglo XVI", "Siglo XVII", "Sigo XV", 2, "Historia");
        bd.insertarReto("¿Quien fue el primer emperador romano?", "Cesar Augusto", "Julio Cesar", "Cesar Augusto", "Neron", 2, "Historia");
        bd.insertarReto("¿Que rey encargo 'Las Meninas'?", "Felipe IV", "Felipe IV", "Felipe III", "Carlos III", 2, "Historia");
        bd.insertarReto("¿Por que condeno la Iglesia a Galileo Galilei?", "Por decir que la Tierra giraba alrededor del Sol", "Por negar la existencia de Dios", "Por decir que la Tierra giraba alrededor del Sol", "Por decir que la Tierra era el centro del universo", 2, "Historia");
        bd.insertarReto("¿Cual de estos hechos es mas antiguo?", "Nacimiento de Confucio", "Nacimiento de Confucio", "Nacimiento de Mahoma", "Nacimiento de Jesucristo", 2, "Historia");
        bd.insertarReto("¿Que pueblos llegaron a la Peninsula Iberica en el primer milenio a.C.?", "Fenicios, Griegos y Cartaginenses", "Fenicios, Griegos y Cartaginenses", "Vikingos", "Celtas y Romanos", 2, "Historia");
        bd.insertarReto("¿Cuando llegaron los romanos a la Peninsula Iberica?", "Durante las Guerras Punicas, en el sigo III a.C.", "Durante las Guerras Punicas, en el sigo III a.C.", "A partir del año 19 a.C.", "En el año 409 d. C.", 2, "Historia");
        bd.insertarReto("Tras los visigodos, ¿que otro pueblo conquisto la Peninsula Iberica?", "Los musulmanes", "Los musulmanes", "Los celtas", "Los vikingos", 2, "Historia");
        bd.insertarReto("¿Con que hecho se puso fin a la Reconquista?", "Con la toma de Grananda por parte de los Reyes Catolicos", "Con la Batalla de las Navas de Tolosa", "Con la toma de Grananda por parte de los Reyes Catolicos", "Con la division del califato en los Reinos de Taifas", 2, "Historia");
        bd.insertarReto("¿Que fue la armada invencible?", "El ejercito naval español en epoca de Felipe II", "Un batallon español en la I Guerra Mundial", "El ejercito con el que lucho Napoleon antes de invadir España", "El ejercito naval español en epoca de Felipe II", 2, "Historia");
        bd.insertarReto("¿Por que acabo la dinastia de los Austrias y llegaron los Borbones a España?", "Porque Carlos II murio sin descencia y termino la dinastia de los Austrias", "Porque los Borbones reclamaron el trono a los Austrias", "Porque Felipe V (Borbon) se caso con la unica heredera de los Austrias", "Porque Carlos II murio sin descencia y termino la dinastia de los Austrias", 2, "Historia");
        bd.insertarReto("¿Que fue la Guerra de la Independencia Española?", "El conflicto entre España, Inglaterra y Portugal contra el dominio frances", "El levantamiento de las colonias de ultramar contra el dominio español", "El conflicto entre España, Inglaterra y Portugal contra el dominio frances", "Se le llama asi a la guerra con Cuba", 2, "Historia");
        bd.insertarReto("¿A que se le llama la transicion democratica?", "La etapa en la que España dejo atras la dictadura y comenzo la democracia", "La etapa en la que inicio su gobierno el PSOE de Felipe Gonzalez", "La etapa en la que España dejo atras la dictadura y comenzo la democracia", "A la etapa final tras la II Guerra Mundial", 2, "Historia");
        bd.insertarReto("¿Que famoso filosofo fue maestro de Alejandro Magno durante cinco años?", "Aristoteles", "Socrates", "Aristoteles", "Platon", 3, "Historia");
        bd.insertarReto("¿Quien fue el ultimo zar de Rusia?", "Nicolas II", "Nicolas II", "Pedro I el Grande", "Alejandro II", 3, "Historia");
        bd.insertarReto("¿A que emperador romano asesino un grupo de senadores?", "Julio Cesar", "Julio Cesar", "Neron", "Caligula", 3, "Historia");
        bd.insertarReto("¿Que insitucion eclesiastica mando a la hoguera a hombres y mujeres por brujos, impuros y herejes?", "La Santa Inquisicion", "La orden del temple", "La Santa Inquisicion", "El tribunal de la Rota", 3, "Historia");
        bd.insertarReto("¿Que famosa batalla perdio y dejo humillado a Napoleon Bonaparte?", "Batalla de Waterloo", "Batalla de Waterloo", "Batalla de Austerlitz", "La campaña de Trafalgar", 3, "Historia");
        bd.insertarReto("¿Quien fue el primer presidente de los Estados Unidos?", "George Washington", "Thomas Jefferson", "John Adams", "George Washington", 3, "Historia");
        bd.insertarReto("¿Quien fue el primer explorador occidental en llegar a China?", "Los antiguos romanos", "Marco Polo", "Los antiguos romanos", "Juan de la Cosa", 3, "Historia");
        bd.insertarReto("¿A quien nombro senador Caligula?", "A su caballo", "A su perro", "A su lacayo", "A su caballo", 3, "Historia");
        bd.insertarReto("¿Que imperio conquisteo el antiguo Egipto en el año 30 a.C.?", "El imperio romano", "El imperio otomano", "El imperio bizantino", "El imperio romano", 3, "Historia");
        bd.insertarReto("¿Cual era la Republica Federal Alemana?", "Bonn", "Berlin", "Bonn", "Munich", 3, "Historia");
        bd.insertarReto("¿Quien inicio la Revolucion cultural china?", "Mao Zedong", "Deng Xiaoping", "Mao Zedong", "Jiang Zemin", 3, "Historia");
        bd.insertarReto("¿Que ciudad fundaron los aztecas?", "Tenochtitlan", "Tulum", "Tenochtitlan", "Chichen Itza", 3, "Historia");
        bd.insertarReto("¿Como se llamo al levantamiento que acabo con la dictadura de Salazar en Portugal?", "La Revolucion de los Claveles", "La Revolucion de los Claveles", "La Revolucion de los Tulipanes", "La Revolucion de las Rosas", 3, "Historia");
        bd.insertarReto("¿Como se llama al avion mas rapido del mundo que dejo de volar tras un fatidico accidente aereo?", "El Concorde", "El Eurofighter", "El Messerschmitt", "El Concorde", 3, "Historia");
        bd.insertarReto("¿En que guerra participo Juana de Arco?", "La Guerra de los 100 años", "Primera Cruzada", "Guerras Napoleonicas", "La Guerra de los 100 años", 3, "Historia");
        bd.insertarReto("¿Como se llamaba el padre de Alejandro Magno?", "Filipo II de Macedonia", "Ptolomeo I", "Filipo II de Macedonia", "Filipo I de Grecia", 3, "Historia");
        bd.insertarReto("¿Como se llamaba el cañon aleman mas famoso en la I Guerra Mundial?", "Gran Berta", "Luftwaffe", "Enola Gay", "Gran Berta", 3, "Historia");
        bd.insertarReto("¿Que faraon era el marido de Nefertiti?", "Akenaton", "Tutankamon", "Ramses II", "Akenaton", 3, "Historia");
        bd.insertarReto("¿En que isla murio Napoleon?", "Santa Elena", "Cerdeña", "Santa Elena", "Elba", 3, "Historia");
        bd.insertarReto("¿Quienes lucharon en la Batalla de Maraton?", "Griegos y Persas", "Griegos y Espartanos", "Romanos y Cartaginenses", "Griegos y Persas", 3, "Historia");
        bd.insertarReto("¿Quien fue llamado 'Rey Sol' al que se le atribuye la frase 'El Estado soy yo'?", "Luis XIV de Francia", "Carlos IX de Francia", "Felipe I de Francia", "Luis XIv de Francia", 3, "Historia");
        bd.insertarReto("¿Cual de estas no es una de las 7 maravillas del mundo antiguo?", "Partenon", "Partenon", "Gran Piramide de Guiza", "Templo de Artemisa", 3, "Historia");
        bd.insertarReto("¿Cual fue el primer estado historico conocido en la Peninsula Iberica?", "Tartessos", "Numantia", "Tartessis", "Sagunto", 3, "Historia");
        bd.insertarReto("¿Quien instauro la Inquisicion en España?", "Los Reyes Catolicos", "Los Reyes Catolicos", "Carlos I", "Felipe II", 3, "Historia");
        bd.insertarReto("¿Quien reino en España tras la muerte de Fernando el Catolico?", "Carlos I de España y V de Alemania", "Juana la Loca", "Felipe II", "Carlos I de España y V de Alemania", 3, "Historia");
    }
}