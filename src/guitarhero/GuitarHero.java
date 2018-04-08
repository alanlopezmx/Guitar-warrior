package guitarhero;
//Alan
/*import giovynet.nativelink.SerialPort;
import giovynet.serial.Baud;
import giovynet.serial.Com;
import giovynet.serial.Parameters;*/
import Server.Servidor;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class GuitarHero extends JComponent {

    public static Servidor server;
    private final static long DELAY_TIMER = 30;
    private final static long DELAY_TIMER_GAP = 60;
    private final static int ANCHO = 1300;
    private final static int ALTO = 700;
    private final static int I_ALTO = 41;
    private final static int I_LARGO = 66;
    private final static int NI_ALTO = 28;
    private final static long TMAX = 170000;
    private final static int Y_FRETS = 615;
    private final static int P_MAX = 365;
    private final static float vExpert = .243f;
    private final static int ALTO_BARRA = 175;
    private final static int Y_BARRA = 475;
    private final static int X_BARRA = 442;
    private String[] songlist;
    private final static int x = 480;
    private final static int x2 = 300;
    private final static int x3 = 750;
    private final static int X_BARRA2 = x2 - 38;
    private final static int X_BARRA3 = x3 - 38;
    private int i = 0;
    private int[] ac;
    private int[] ac2;
    private int indice;
    private int wall;
    private int wall2;
    private int wall3;
    private int puntaje;
    private int multiplicador = 1;
    private int notasCons = 0;
    private int notasTotales;
    private int acumulador;
    private int comboMaximo;
    private int notasAcertadas = 0;
    private int puntaje2;
    private int multiplicador2 = 1;
    private int notasCons2 = 0;
    private int notasTotales2;
    private int acumulador2;
    private int comboMaximo2;
    private int notasAcertadas2 = 0;
    private final int keyGreen = KeyEvent.VK_A;
    private final int keyRed = KeyEvent.VK_S;
    private final int keyYellow = KeyEvent.VK_J;
    private final int keyBlue = KeyEvent.VK_K;
    private final int keyOrange = KeyEvent.VK_L;
    private final int keyGreen2 = KeyEvent.VK_Q;
    private final int keyRed2 = KeyEvent.VK_W;
    private final int keyYellow2 = KeyEvent.VK_Y;
    private final int keyBlue2 = KeyEvent.VK_U;
    private final int keyOrange2 = KeyEvent.VK_I;
    private int step;
    private int[] color;
    private int[] color2;
    private boolean[] elimina;
    private long[] time;
    private long[] time2;
    private long[] time3;
    private long[] time4;
    private long tiempoNuevo = 0;
    private Image[] iFrets;
    private Image[] iFretsPresionadas;
    private Image[] iNotas;
    private Image[] iPress;
    private Image[] iWallpaper;
    private Image[] iBarra;
    private Image[] iFondos;
    private Image[] iFin;
    private ImageIcon youRock;
    private ImageIcon[] gifs;
    private Random rand;
    private boolean verde;
    private boolean rojo;
    private boolean amarillo;
    private boolean azul;
    private boolean naranja;
    private boolean verde2;
    private boolean rojo2;
    private boolean amarillo2;
    private boolean azul2;
    private boolean naranja2;
    private boolean cargar;
    private boolean[] acerto;
    private boolean[] acerto2;
    private boolean pausa;
    private boolean pierde;
    private boolean gana;
    private boolean juego;
    private boolean singleplayer;
    public volatile static boolean multiplayer;
    private boolean menu;
    private boolean setlist;
    private boolean editor;
    private boolean creditos;
    private boolean guitarra;
    private boolean teclado;
    private boolean sp;
    private int[] dato;
    Hilos lecturaSerial;
    ListaSimple notas;
    ListaSimple notas2;
    ListaSimple listaEditor;
    SpriteFlamas sprite;
    Keylistener oyenteTeclado;
    FileManager aNotas;
    FileManager welcome;
    FileManager lista;
    Musica musica;
    Musica theme;
    Musica musicaEditor;
    private String ruta, nombreCancion;
    private Image[] iMenu;
    private int yFlecha = 40;
    private int xPerdiste = 310;
    private int yPerdiste = 400;
    private int yFlecha_pausa = 380;
    private int yFlecha_setlist = 150;
    private int yFlecha_gana = 350;
    private int xFlecha_setlist = 180;
    private int inicioLista = 0;
    private int totalCanciones;
    private int indexsong = 1;
    private boolean[] band = new boolean[19];
    private boolean[] band2 = new boolean[5];
    private boolean[] band3 = new boolean[5];
    private boolean[] band4 = new boolean[5];
    public TimerCustom timer;
    public TimerCustom timerGap;

    public GuitarHero() throws IOException, Exception {
        server = new Servidor();
        server.start();
        for (int j = 0; j < 19; j++) {
            band[j] = false;
        }
        dato = new int[5];
        for (int i = 0; i < 4; i++) {
            dato[i] = 0;
            band2[i] = false;
            band3[i] = false;
            band4[i] = false;
        }
        musica = new Musica();
        verde2 = rojo2 = amarillo2 = azul2 = naranja2 = false;
        verde = rojo = amarillo = azul = naranja = cargar = pausa = gana = singleplayer = multiplayer = setlist = editor = creditos = juego = pierde = guitarra = teclado = sp = false;
        menu = true;
        theme = new Musica();
        musicaEditor = new Musica();
        theme.setSong(getClass().getClassLoader().getResource("resources/musica/tender surrender.wav"));
        System.out.println();
        theme.loop(Clip.LOOP_CONTINUOUSLY); // loop infinito
        iFrets = new Image[5];
        iFretsPresionadas = new Image[5];
        iNotas = new Image[5];
        iPress = new Image[5];
        iWallpaper = new Image[10];
        iBarra = new Image[3];
        iFondos = new Image[6];
        iFin = new Image[4];
        iMenu = new Image[19];
        gifs = new ImageIcon[2];
        notas = new ListaSimple();
        notas2 = new ListaSimple();
        listaEditor = new ListaSimple();
        welcome = new FileManager("resources/J_notas/welcome.txt");
        lista = new FileManager("resources/setlist/lista.txt");
        totalCanciones = lista.totalLineas();
        System.out.println("Total canciones: " + totalCanciones);
        songlist = new String[totalCanciones];
        songlist = lista.leer();
        sprite = new SpriteFlamas("/Flamas/flamitas.png", 66, 55);
        youRock = new ImageIcon("src/fin/4.gif");
        puntaje = 0;
        comboMaximo = 0;
        puntaje2 = 0;
        comboMaximo2 = 0;
        step = 500;
        color = new int[5];
        color2 = new int[5];
        time = new long[5];
        time2 = new long[5];
        time3 = new long[5];
        time4 = new long[5];
        ac = new int[5];
        ac2 = new int[5];
        acerto = new boolean[5];
        acerto2 = new boolean[5];
        elimina = new boolean[5];
        rand = new Random();
        wall = rand.nextInt(10);
        wall2 = rand.nextInt(10);
        wall3 = rand.nextInt(5);
        acumulador = 30;
        acumulador2 = 30;
        for (int i = 0; i < 4; i++) {
            color[i] = 0;
            time[i] = 0;
            time2[i] = 0;
            time3[i] = 0;
            time4[i] = 0;
            ac[i] = 0;
            acerto[i] = false;
            acerto2[i] = false;
            elimina[i] = false;
        }
        for (int i = 0; i < 5; i++) {
            URL imgStream = GuitarHero.class.getResource("/imagenes/" + i + ".png");
            iNotas[i] = ImageIO.read(imgStream);
            imgStream = GuitarHero.class.getResource("/imagenes/" + (i + 5) + ".png");
            iFrets[i] = ImageIO.read(imgStream);
            imgStream = GuitarHero.class.getResource("/imagenes/" + (i + 10) + ".png");
            iFretsPresionadas[i] = ImageIO.read(imgStream);
            imgStream = GuitarHero.class.getResource("/imagenes/" + (i + 15) + ".png");
            iPress[i] = ImageIO.read(imgStream);
        }
        for (int i = 0; i < 3; i++) {
            URL imgStream = GuitarHero.class.getResource("/imagenes/Barra " + (i + 1) + ".png");
            iBarra[i] = ImageIO.read(imgStream);
        }
        for (int j = 0; j < 10; j++) {
            URL imgStream = GuitarHero.class.getResource("/imagen/" + j + ".png");
            iWallpaper[j] = ImageIO.read(imgStream);
        }
        for (int i = 0; i < 6; i++) {
            URL imgStream = GuitarHero.class.getResource("/imagenes_fondo/" + (i) + ".png");
            iFondos[i] = ImageIO.read(imgStream);
        }
        for (int j = 0; j < 19; j++) {
                URL imgStream = GuitarHero.class.getResource("/fondo/" + j + ".png");
                iMenu[j] = ImageIO.read(imgStream);
        }
        for (int i = 0; i < 4; i++) {
            URL imgStream = GuitarHero.class.getResource("/fin/" + i + ".png");
            iFin[i] = ImageIO.read(imgStream);
        }
        for (int i = 0; i < 2; i++) {
            gifs[i] = new ImageIcon("src/gifs/" + i + ".gif");
        }
        setPreferredSize(new Dimension(ANCHO, ALTO));
        lecturaSerial = new Hilos();
        oyenteTeclado = new Keylistener();
        addKeyListener(oyenteTeclado);
        this.addFocusListener(new FocusAdapter() {
            public void focusLost(FocusEvent e) {
                if (juego) {
                    pausa = true;
                }
            }
        });
        setFocusable(true);
    }

    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        Nodo aux, aux2;

        g.drawImage(iMenu[0], 0, 0, null);
        if (menu) {
            g.drawImage(iMenu[14], 100, 50, null);
            g.drawImage(iMenu[1], 780, 40, null);
            g.drawImage(iMenu[2], 780, 120, null);
            g.drawImage(iMenu[3], 780, 200, null);
            g.drawImage(iMenu[4], 780, 280, null);
            g.drawImage(iMenu[5], 780, 360, null);
            g.drawImage(iMenu[7], 780, 440, null);
            g.drawImage(iMenu[6], 710, yFlecha, null);
        } else if (creditos) {
            g.drawImage(iMenu[12], 198, 229, null);
            g.drawImage(iMenu[13], 1190, 650, null);
        } else if (editor) {
            g.drawImage(iFondos[wall3], 0, 0, null);
            g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, .72f));
            g2d.drawImage(iWallpaper[wall], x - 5, 250, null);
            g.drawImage(iMenu[16], 960, 0, null);
            int minutos = (int) (musicaEditor.getPosition() / 60000);
            int segundos = (int) (musicaEditor.getPosition() / 1000 % 60);
            int milisegundos = (int) (musicaEditor.getPosition() % 1000);
            int minutos2 = (int) (musicaEditor.getMilisecondLength() / 60000);
            int segundos2 = (int) (musicaEditor.getMilisecondLength() / 1000 % 60);
            int milisegundos2 = (int) (musicaEditor.getMilisecondLength() % 1000);
            g.setFont(new Font("fuente", Font.BOLD, 30));
            g.setColor(Color.white);
            g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1));
            g.drawString("Tiempo: " + minutos + ":" + segundos + "." + milisegundos, 30, 60);
            g.drawString("Duracion: " + minutos2 + ":" + segundos2 + "." + milisegundos2, 30, 90);
            g.drawString("Gap: " + step, 30, 120);
            for (int i = 0; i < 5; i++) {
                g.drawImage(iFrets[i], x + I_LARGO * i, Y_FRETS, null);
            }
            for (int i = 0; i < listaEditor.tamaño; i++) {
                aux = listaEditor.indexOf(i);
                if (aux != null) {
                    switch (aux.color) {
                        case 1:
                            if (aux.pintar) {
                                g.drawImage(iNotas[0], x, aux.y, null);
                            }
                            g.setColor(aux.color2);
                            pintaLineas(g, x, aux);
                            break;
                        case 2:
                            if (aux.pintar) {
                                g.drawImage(iNotas[1], x + I_LARGO, aux.y, null);
                            }
                            g.setColor(aux.color2);
                            pintaLineas(g, x + I_LARGO, aux);
                            break;
                        case 3:
                            if (aux.pintar) {
                                g.drawImage(iNotas[2], x + I_LARGO * 2, aux.y, null);
                            }
                            g.setColor(aux.color2);
                            pintaLineas(g, x + I_LARGO * 2, aux);
                            break;
                        case 4:
                            if (aux.pintar) {
                                g.drawImage(iNotas[3], x + I_LARGO * 3, aux.y, null);
                            }
                            g.setColor(aux.color2);
                            pintaLineas(g, x + I_LARGO * 3, aux);
                            break;
                        case 5:
                            if (aux.pintar) {
                                g.drawImage(iNotas[4], x + I_LARGO * 4, aux.y, null);
                            }
                            g.setColor(aux.color2);
                            pintaLineas(g, x + I_LARGO * 4, aux);
                            break;
                    }
                }
            }
            if (musicaEditor.isActive()) {
                if (verde) {
                    g.setColor(Color.GREEN);
                    g.fillRect(x + 25, Y_FRETS - 10, 16, 10);
                }
                if (rojo) {
                    g.setColor(Color.RED);
                    g.fillRect(x + I_LARGO + 25, Y_FRETS - 10, 16, 10);
                }
                if (amarillo) {
                    g.setColor(Color.YELLOW);
                    g.fillRect(x + I_LARGO * 2 + 25, Y_FRETS - 10, 16, 10);
                }
                if (azul) {
                    g.setColor(Color.BLUE);
                    g.fillRect(x + I_LARGO * 3 + 25, Y_FRETS - 10, 16, 10);
                }
                if (naranja) {
                    g.setColor(Color.ORANGE);
                    g.fillRect(x + I_LARGO * 4 + 25, Y_FRETS - 10, 16, 10);
                }
            }
        } else if (setlist) {
            String[] auxi;
            g.drawImage(iMenu[15], 70, 20, null);
            g.drawImage(iFin[3], 800, 30, null);
            g.setColor(Color.white);
            g.setFont(new Font("fuente", Font.BOLD, 30));
            int z = 0;
            if (totalCanciones > 6) {
                for (int i = inicioLista; i < inicioLista + 6; i++) {
                    auxi = songlist[i].split("-");
                    g.drawString(auxi[0], 780, (z * 50) + 150);
                    z++;
                }
            } else {
                for (int i = 0; i < totalCanciones; i++) {
                    auxi = songlist[i].split("-");
                    g.drawString(auxi[0], 780, (i * 50) + 150);
                }
            }

            g.drawImage(iMenu[10], 730, yFlecha_setlist - 20, null);
            if (sp) {
                g.drawImage(iMenu[18], 250, 550, null);
                g.drawImage(iMenu[17], 750, 550, null);
                g.drawImage(iMenu[6], xFlecha_setlist, 550, null);
            }
        } else if (singleplayer) {
            g.drawImage(iFondos[wall3], 0, 0, null);
            if (guitarra) {
                if (!gana && !pierde) {
                    g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, .72f));// transparencia
                    if (pausa) {
                        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, .30f));
                    }
                    g2d.drawImage(iWallpaper[wall], x - 5, 250, null);
                    if (!pausa) {
                        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1));
                    }
                    for (int i = 0; i < notas.tamaño; i++) {
                        aux = notas.indexOf(i);
                        if (aux != null) {
                            switch (aux.color) {
                                case 1:
                                    if (aux.pintar) {
                                        g.drawImage(iNotas[0], x, aux.y, null);
                                    }
                                    g.setColor(aux.color2);
                                    pintaLineas(g, x, aux);
                                    break;
                                case 2:
                                    if (aux.pintar) {
                                        g.drawImage(iNotas[1], x + I_LARGO, aux.y, null);
                                    }
                                    g.setColor(aux.color2);
                                    pintaLineas(g, x + I_LARGO, aux);
                                    break;
                                case 3:
                                    if (aux.pintar) {
                                        g.drawImage(iNotas[2], x + I_LARGO * 2, aux.y, null);
                                    }
                                    g.setColor(aux.color2);
                                    pintaLineas(g, x + I_LARGO * 2, aux);
                                    break;
                                case 4:
                                    if (aux.pintar) {
                                        g.drawImage(iNotas[3], x + I_LARGO * 3, aux.y, null);
                                    }
                                    g.setColor(aux.color2);
                                    pintaLineas(g, x + I_LARGO * 3, aux);
                                    break;
                                case 5:
                                    if (aux.pintar) {
                                        g.drawImage(iNotas[4], x + I_LARGO * 4, aux.y, null);
                                    }
                                    g.setColor(aux.color2);
                                    pintaLineas(g, x + I_LARGO * 4, aux);
                                    break;
                            }
                        }
                    }
                    for (int i = 0; i < 5; i++) {
                        g.drawImage(iFrets[i], x + I_LARGO * i, Y_FRETS, null);
                    }
                    if ((color2[0] == 1 && (tiempoNuevo - time3[0]) <= TMAX) || (color2[0] == 1 && dato[0] == 1 && acerto2[0] == true)) {
                        g.drawImage(iPress[0], x3, Y_FRETS, null);
                        sprite.setPosicion(x3, Y_FRETS - 28);
                        sprite.pintar(g);
                        tiempoTranscurrido2(0);
                        sumandoPuntaje2(0);
                    }
                    if ((color2[1] == 2 && (tiempoNuevo - time3[1]) <= TMAX) || (color2[1] == 2 && dato[1] == 1 && acerto2[1] == true)) {
                        g.drawImage(iPress[1], x3 + I_LARGO, Y_FRETS, null);
                        sprite.setPosicion(x3 + I_LARGO, Y_FRETS - 28);
                        sprite.pintar(g);
                        tiempoTranscurrido2(1);
                        sumandoPuntaje2(1);
                    }
                    if ((color2[2] == 3 && (tiempoNuevo - time3[2]) <= TMAX) || (color2[2] == 3 && dato[2] == 1 && acerto2[2] == true)) {
                        g.drawImage(iPress[2], x3 + I_LARGO * 2, Y_FRETS, null);
                        sprite.setPosicion(x3 + I_LARGO * 2, Y_FRETS - 28);
                        sprite.pintar(g);
                        tiempoTranscurrido2(2);
                        sumandoPuntaje2(2);
                    }
                    if ((color2[3] == 4 && (tiempoNuevo - time3[3]) <= TMAX) || (color2[3] == 4 && dato[3] == 1 && acerto2[3] == true)) {
                        g.drawImage(iPress[3], x3 + I_LARGO * 3, Y_FRETS, null);
                        sprite.setPosicion(x3 + I_LARGO * 3, Y_FRETS - 28);
                        sprite.pintar(g);
                        tiempoTranscurrido2(3);
                        sumandoPuntaje2(3);
                    }
                    if ((color2[4] == 5 && (tiempoNuevo - time3[4]) <= TMAX) || (color2[4] == 5 && dato[4] == 1 && acerto2[4] == true)) {
                        g.drawImage(iPress[4], x3 + I_LARGO * 4, Y_FRETS, null);
                        sprite.setPosicion(x3 + I_LARGO * 4, Y_FRETS - 28);
                        sprite.pintar(g);
                        tiempoTranscurrido2(4);
                        sumandoPuntaje2(4);
                    }
                    if (dato[0] == 0) {
                        color2[0] = 0;
                    }
                    if (dato[1] == 0) {
                        color2[1] = 0;
                    }
                    if (dato[2] == 0) {
                        color2[2] = 0;
                    }
                    if (dato[3] == 0) {
                        color2[3] = 0;
                    }
                    if (dato[4] == 0) {
                        color2[4] = 0;
                    }
                    if (dato[0] == 1 && color2[0] == 0) {
                        g.drawImage(iFretsPresionadas[0], x, Y_FRETS, null);
                    }
                    if (dato[1] == 1 && color2[1] == 0) {
                        g.drawImage(iFretsPresionadas[1], x + I_LARGO, Y_FRETS, null);
                    }
                    if (dato[2] == 1 && color2[2] == 0) {
                        g.drawImage(iFretsPresionadas[2], x + I_LARGO * 2, Y_FRETS, null);
                    }
                    if (dato[3] == 1 && color2[3] == 0) {
                        g.drawImage(iFretsPresionadas[3], x + I_LARGO * 3, Y_FRETS, null);
                    }
                    if (dato[4] == 1 && color2[4] == 0) {
                        g.drawImage(iFretsPresionadas[4], x + I_LARGO * 4, Y_FRETS, null);
                    }
                    sprite.setFrame((i++) / 5);
                    if (i > 20) {
                        i = 0;
                    }
                    if (acumulador2 >= 0 && acumulador2 < 21) {
                        g.drawImage(iBarra[2], X_BARRA, Y_BARRA, null);
                    }
                    if (acumulador2 >= 21 && acumulador2 < 41) {
                        g.drawImage(iBarra[1], X_BARRA, Y_BARRA, null);
                    }
                    if (acumulador2 >= 41 && acumulador2 < 61) {
                        g.drawImage(iBarra[0], X_BARRA, Y_BARRA, null);
                    }
                    pintaBarra(g, X_BARRA, 1);
                    g.setColor(Color.red);
                    g.setFont(new Font("fuente", Font.BOLD, 30));
                    g.drawString("Puntaje: " + puntaje, 840, 600);
                    g.setFont(new Font("fuente", Font.BOLD, 20));
                    g.drawString("Notas Seguidas: " + notasCons, 840, 640);
                    g.setFont(new Font("fuente", Font.BOLD, 30));
                    g.drawString("X" + multiplicador2, x + I_LARGO * 2 + 15, Y_FRETS + I_ALTO * 2);
                    gifs[0].paintIcon(this, g, X_BARRA - 150, Y_BARRA + 30);
                    gifs[1].paintIcon(this, g, 780, 250);
                    if (pausa) {
                        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1));
                        g.drawImage(iMenu[8], x - 25, 180, null);
                        g.drawImage(iMenu[9], x + 25, 380, null);
                        g.drawImage(iMenu[7], x + 25, 460, null);
                        g.drawImage(iMenu[6], x - 55, yFlecha_pausa, null);
                    }
                }
            } else {
                if (!gana && !pierde) {
                    g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, .72f));// transparencia
                    if (pausa) {
                        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, .30f));
                    }
                    g2d.drawImage(iWallpaper[wall], x - 5, 250, null);
                    if (!pausa) {
                        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1));
                    }
                    for (int i = 0; i < notas.tamaño; i++) {
                        aux = notas.indexOf(i);
                        if (aux != null) {
                            switch (aux.color) {
                                case 1:
                                    if (aux.pintar) {
                                        g.drawImage(iNotas[0], x, aux.y, null);
                                    }
                                    g.setColor(aux.color2);
                                    pintaLineas(g, x, aux);
                                    break;
                                case 2:
                                    if (aux.pintar) {
                                        g.drawImage(iNotas[1], x + I_LARGO, aux.y, null);
                                    }
                                    g.setColor(aux.color2);
                                    pintaLineas(g, x + I_LARGO, aux);
                                    break;
                                case 3:
                                    if (aux.pintar) {
                                        g.drawImage(iNotas[2], x + I_LARGO * 2, aux.y, null);
                                    }
                                    g.setColor(aux.color2);
                                    pintaLineas(g, x + I_LARGO * 2, aux);
                                    break;
                                case 4:
                                    if (aux.pintar) {
                                        g.drawImage(iNotas[3], x + I_LARGO * 3, aux.y, null);
                                    }
                                    g.setColor(aux.color2);
                                    pintaLineas(g, x + I_LARGO * 3, aux);
                                    break;
                                case 5:
                                    if (aux.pintar) {
                                        g.drawImage(iNotas[4], x + I_LARGO * 4, aux.y, null);
                                    }
                                    g.setColor(aux.color2);
                                    pintaLineas(g, x + I_LARGO * 4, aux);
                                    break;
                            }
                        }
                    }
                    for (int i = 0; i < 5; i++) {
                        g.drawImage(iFrets[i], x + I_LARGO * i, Y_FRETS, null);
                    }
                    if ((color[0] == 1 && (tiempoNuevo - time[0]) <= TMAX) || (color[0] == 1 && verde && acerto[0] == true)) {
                        g.drawImage(iPress[0], x, Y_FRETS, null);
                        sprite.setPosicion(x, Y_FRETS - 28);
                        sprite.pintar(g);
                        tiempoTranscurrido(0);
                        sumandoPuntaje(0);
                    }
                    if ((color[1] == 2 && (tiempoNuevo - time[1]) <= TMAX) || (color[1] == 2 && rojo && acerto[1] == true)) {
                        g.drawImage(iPress[1], x + I_LARGO, Y_FRETS, null);
                        sprite.setPosicion(x + I_LARGO, Y_FRETS - 28);
                        sprite.pintar(g);
                        tiempoTranscurrido(1);
                        sumandoPuntaje(1);
                    }
                    if ((color[2] == 3 && (tiempoNuevo - time[2]) <= TMAX) || (color[2] == 3 && amarillo && acerto[2] == true)) {
                        g.drawImage(iPress[2], x + I_LARGO * 2, Y_FRETS, null);
                        sprite.setPosicion(x + I_LARGO * 2, Y_FRETS - 28);
                        sprite.pintar(g);
                        tiempoTranscurrido(2);
                        sumandoPuntaje(2);
                    }
                    if ((color[3] == 4 && (tiempoNuevo - time[3]) <= TMAX) || (color[3] == 4 && azul && acerto[3] == true)) {
                        g.drawImage(iPress[3], x + I_LARGO * 3, Y_FRETS, null);
                        sprite.setPosicion(x + I_LARGO * 3, Y_FRETS - 28);
                        sprite.pintar(g);
                        tiempoTranscurrido(3);
                        sumandoPuntaje(3);
                    }
                    if ((color[4] == 5 && (tiempoNuevo - time[4]) <= TMAX) || (color[4] == 5 && naranja && acerto[4] == true)) {
                        g.drawImage(iPress[4], x + I_LARGO * 4, Y_FRETS, null);
                        sprite.setPosicion(x + I_LARGO * 4, Y_FRETS - 28);
                        sprite.pintar(g);
                        tiempoTranscurrido(4);
                        sumandoPuntaje(4);
                    }
                    if (verde == false) {
                        color[0] = 0;
                    }
                    if (rojo == false) {
                        color[1] = 0;
                    }
                    if (amarillo == false) {
                        color[2] = 0;
                    }
                    if (azul == false) {
                        color[3] = 0;
                    }
                    if (naranja == false) {
                        color[4] = 0;
                    }

                    if (dato[0] == 1 || verde && color[0] == 0) {
                        g.drawImage(iFretsPresionadas[0], x, Y_FRETS, null);
                    }
                    if (dato[1] == 1 || rojo && color[1] == 0) {
                        g.drawImage(iFretsPresionadas[1], x + I_LARGO, Y_FRETS, null);
                    }
                    if (dato[2] == 1 || amarillo && color[2] == 0) {
                        g.drawImage(iFretsPresionadas[2], x + I_LARGO * 2, Y_FRETS, null);
                    }
                    if (dato[3] == 1 || azul && color[3] == 0) {
                        g.drawImage(iFretsPresionadas[3], x + I_LARGO * 3, Y_FRETS, null);
                    }
                    if (dato[4] == 1 || naranja && color[4] == 0) {
                        g.drawImage(iFretsPresionadas[4], x + I_LARGO * 4, Y_FRETS, null);
                    }
                    sprite.setFrame((i++) / 5);
                    if (i > 20) {
                        i = 0;
                    }
                    if (acumulador >= 0 && acumulador < 21) {
                        g.drawImage(iBarra[2], X_BARRA, Y_BARRA, null);
                    }
                    if (acumulador >= 21 && acumulador < 41) {
                        g.drawImage(iBarra[1], X_BARRA, Y_BARRA, null);
                    }
                    if (acumulador >= 41 && acumulador < 61) {
                        g.drawImage(iBarra[0], X_BARRA, Y_BARRA, null);
                    }
                    pintaBarra(g, X_BARRA, 1);
                    g.setColor(Color.red);
                    g.setFont(new Font("fuente", Font.BOLD, 30));
                    g.drawString("Puntaje: " + puntaje, 840, 600);
                    g.setFont(new Font("fuente", Font.BOLD, 20));
                    g.drawString("Notas Seguidas: " + notasCons, 840, 640);
                    g.setColor(Color.white);
                    g.setFont(new Font("fuente", Font.BOLD, 30));
                    g.drawString("X" + multiplicador, x + I_LARGO * 2 + 15, Y_FRETS + I_ALTO * 2);
                    gifs[0].paintIcon(this, g, X_BARRA - 150, Y_BARRA + 30);
                    gifs[1].paintIcon(this, g, 780, 250);
                    if (pausa) {
                        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1));
                        g.drawImage(iMenu[8], x - 25, 180, null);
                        g.drawImage(iMenu[9], x + 25, 380, null);
                        g.drawImage(iMenu[7], x + 25, 460, null);
                        g.drawImage(iMenu[6], x - 55, yFlecha_pausa, null);
                    }
                }
            }
            if (gana) {
                pintaGanaste(g);
            }
            if (pierde) {
                pintaPerdiste(g);
            }
        } else if (multiplayer) {
            g.drawImage(iFondos[wall3], 0, 0, null);
            if (!gana && !pierde) {
                g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, .72f));// transparencia
                if (pausa) {
                    g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, .30f));
                }
                g2d.drawImage(iWallpaper[wall], x2 - 5, 250, null);
                g2d.drawImage(iWallpaper[wall2], x3 - 5, 250, null);
                if (!pausa) {
                    g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1));
                }
                for (int i = 0; i < notas.tamaño; i++) {
                    aux = notas.indexOf(i);
                    if (aux != null) {
                        switch (aux.color) {
                            case 1:
                                if (aux.pintar) {
                                    g.drawImage(iNotas[0], x2, aux.y, null);
                                }
                                g.setColor(aux.color2);
                                pintaLineas(g, x2, aux);
                                break;
                            case 2:
                                if (aux.pintar) {
                                    g.drawImage(iNotas[1], x2 + I_LARGO, aux.y, null);
                                }
                                g.setColor(aux.color2);
                                pintaLineas(g, x2 + I_LARGO, aux);
                                break;
                            case 3:
                                if (aux.pintar) {
                                    g.drawImage(iNotas[2], x2 + I_LARGO * 2, aux.y, null);
                                }
                                g.setColor(aux.color2);
                                pintaLineas(g, x2 + I_LARGO * 2, aux);
                                break;
                            case 4:
                                if (aux.pintar) {
                                    g.drawImage(iNotas[3], x2 + I_LARGO * 3, aux.y, null);
                                }
                                g.setColor(aux.color2);
                                pintaLineas(g, x2 + I_LARGO * 3, aux);
                                break;
                            case 5:
                                if (aux.pintar) {
                                    g.drawImage(iNotas[4], x2 + I_LARGO * 4, aux.y, null);
                                }
                                g.setColor(aux.color2);
                                pintaLineas(g, x2 + I_LARGO * 4, aux);
                                break;
                        }
                    }
                }
                for (int i = 0; i < notas2.tamaño; i++) {
                    aux2 = notas2.indexOf(i);
                    if (aux2 != null) {
                        switch (aux2.color) {
                            case 1:
                                if (aux2.pintar) {
                                    g.drawImage(iNotas[0], x3, aux2.y, null);
                                }
                                g.setColor(aux2.color2);
                                pintaLineas(g, x3, aux2);
                                break;
                            case 2:
                                if (aux2.pintar) {
                                    g.drawImage(iNotas[1], x3 + I_LARGO, aux2.y, null);
                                }
                                g.setColor(aux2.color2);
                                pintaLineas(g, x3 + I_LARGO, aux2);
                                break;
                            case 3:
                                if (aux2.pintar) {
                                    g.drawImage(iNotas[2], x3 + I_LARGO * 2, aux2.y, null);
                                }
                                g.setColor(aux2.color2);
                                pintaLineas(g, x3 + I_LARGO * 2, aux2);
                                break;
                            case 4:
                                if (aux2.pintar) {
                                    g.drawImage(iNotas[3], x3 + I_LARGO * 3, aux2.y, null);
                                }
                                g.setColor(aux2.color2);
                                pintaLineas(g, x3 + I_LARGO * 3, aux2);
                                break;
                            case 5:
                                if (aux2.pintar) {
                                    g.drawImage(iNotas[4], x3 + I_LARGO * 4, aux2.y, null);
                                }
                                g.setColor(aux2.color2);
                                pintaLineas(g, x3 + I_LARGO * 4, aux2);
                                break;
                        }
                    }
                }
                for (int i = 0; i < 5; i++) {
                    g.drawImage(iFrets[i], x2 + I_LARGO * i, Y_FRETS, null);
                }
                for (int i = 0; i < 5; i++) {
                    g.drawImage(iFrets[i], x3 + I_LARGO * i, Y_FRETS, null);
                }
                if ((color[0] == 1 && (tiempoNuevo - time[0]) <= TMAX) || (color[0] == 1 && verde && acerto[0] == true)) {
                    g.drawImage(iPress[0], x2, Y_FRETS, null);
                    sprite.setPosicion(x2, Y_FRETS - 28);
                    sprite.pintar(g);
                    tiempoTranscurrido(0);
                    sumandoPuntaje(0);
                }
                if ((color[1] == 2 && (tiempoNuevo - time[1]) <= TMAX) || (color[1] == 2 && rojo && acerto[1] == true)) {
                    g.drawImage(iPress[1], x2 + I_LARGO, Y_FRETS, null);
                    sprite.setPosicion(x2 + I_LARGO, Y_FRETS - 28);
                    sprite.pintar(g);
                    tiempoTranscurrido(1);
                    sumandoPuntaje(1);
                }
                if ((color[2] == 3 && (tiempoNuevo - time[2]) <= TMAX) || (color[2] == 3 && amarillo && acerto[2] == true)) {
                    g.drawImage(iPress[2], x2 + I_LARGO * 2, Y_FRETS, null);
                    sprite.setPosicion(x2 + I_LARGO * 2, Y_FRETS - 28);
                    sprite.pintar(g);
                    tiempoTranscurrido(2);
                    sumandoPuntaje(2);
                }
                if ((color[3] == 4 && (tiempoNuevo - time[3]) <= TMAX) || (color[3] == 4 && azul && acerto[3] == true)) {
                    g.drawImage(iPress[3], x2 + I_LARGO * 3, Y_FRETS, null);
                    sprite.setPosicion(x2 + I_LARGO * 3, Y_FRETS - 28);
                    sprite.pintar(g);
                    tiempoTranscurrido(3);
                    sumandoPuntaje(3);
                }
                if ((color[4] == 5 && (tiempoNuevo - time[4]) <= TMAX) || (color[4] == 5 && naranja && acerto[4] == true)) {
                    g.drawImage(iPress[4], x2 + I_LARGO * 4, Y_FRETS, null);
                    sprite.setPosicion(x2 + I_LARGO * 4, Y_FRETS - 28);
                    sprite.pintar(g);
                    tiempoTranscurrido(4);
                    sumandoPuntaje(4);
                }
                if (verde == false) {
                    color[0] = 0;
                }
                if (rojo == false) {
                    color[1] = 0;
                }
                if (amarillo == false) {
                    color[2] = 0;
                }
                if (azul == false) {
                    color[3] = 0;
                }
                if (naranja == false) {
                    color[4] = 0;
                }

                if ((color2[0] == 1 && (tiempoNuevo - time3[0]) <= TMAX) || (color2[0] == 1 && dato[0] == 1 && acerto2[0] == true)) {
                    g.drawImage(iPress[0], x3, Y_FRETS, null);
                    sprite.setPosicion(x3, Y_FRETS - 28);
                    sprite.pintar(g);
                    tiempoTranscurrido2(0);
                    sumandoPuntaje2(0);
                }
                if ((color2[1] == 2 && (tiempoNuevo - time3[1]) <= TMAX) || (color2[1] == 2 && dato[1] == 1 && acerto2[1] == true)) {
                    g.drawImage(iPress[1], x3 + I_LARGO, Y_FRETS, null);
                    sprite.setPosicion(x3 + I_LARGO, Y_FRETS - 28);
                    sprite.pintar(g);
                    tiempoTranscurrido2(1);
                    sumandoPuntaje2(1);
                }
                if ((color2[2] == 3 && (tiempoNuevo - time3[2]) <= TMAX) || (color2[2] == 3 && dato[2] == 1 && acerto2[2] == true)) {
                    g.drawImage(iPress[2], x3 + I_LARGO * 2, Y_FRETS, null);
                    sprite.setPosicion(x3 + I_LARGO * 2, Y_FRETS - 28);
                    sprite.pintar(g);
                    tiempoTranscurrido2(2);
                    sumandoPuntaje2(2);
                }
                if ((color2[3] == 4 && (tiempoNuevo - time3[3]) <= TMAX) || (color2[3] == 4 && dato[3] == 1 && acerto2[3] == true)) {
                    g.drawImage(iPress[3], x3 + I_LARGO * 3, Y_FRETS, null);
                    sprite.setPosicion(x3 + I_LARGO * 3, Y_FRETS - 28);
                    sprite.pintar(g);
                    tiempoTranscurrido2(3);
                    sumandoPuntaje2(3);
                }
                if ((color2[4] == 5 && (tiempoNuevo - time3[4]) <= TMAX) || (color2[4] == 5 && dato[4] == 1 && acerto2[4] == true)) {
                    g.drawImage(iPress[4], x3 + I_LARGO * 4, Y_FRETS, null);
                    sprite.setPosicion(x3 + I_LARGO * 4, Y_FRETS - 28);
                    sprite.pintar(g);
                    tiempoTranscurrido2(4);
                    sumandoPuntaje2(4);
                }
                if (verde2 == false) {
                    color2[0] = 0;
                }
                if (rojo2 == false) {
                    color2[1] = 0;
                }
                if (amarillo2 == false) {
                    color2[2] = 0;
                }
                if (azul2 == false) {
                    color2[3] = 0;
                }
                if (naranja2 == false) {
                    color2[4] = 0;
                }

                if (verde && color[0] == 0) {
                    g.drawImage(iFretsPresionadas[0], x2, Y_FRETS, null);
                }
                if (rojo && color[1] == 0) {
                    g.drawImage(iFretsPresionadas[1], x2 + I_LARGO, Y_FRETS, null);
                }
                if (amarillo && color[2] == 0) {
                    g.drawImage(iFretsPresionadas[2], x2 + I_LARGO * 2, Y_FRETS, null);
                }
                if (azul && color[3] == 0) {
                    g.drawImage(iFretsPresionadas[3], x2 + I_LARGO * 3, Y_FRETS, null);
                }
                if (naranja && color[4] == 0) {
                    g.drawImage(iFretsPresionadas[4], x2 + I_LARGO * 4, Y_FRETS, null);
                }

                if (dato[0] == 1 || verde2 && color2[0] == 0) {
                    g.drawImage(iFretsPresionadas[0], x3, Y_FRETS, null);
                }
                if (dato[1] == 1 || rojo2 && color2[1] == 0) {
                    g.drawImage(iFretsPresionadas[1], x3 + I_LARGO, Y_FRETS, null);
                }
                if (dato[2] == 1 || amarillo2 && color2[2] == 0) {
                    g.drawImage(iFretsPresionadas[2], x3 + I_LARGO * 2, Y_FRETS, null);
                }
                if (dato[3] == 1 || azul2 && color2[3] == 0) {
                    g.drawImage(iFretsPresionadas[3], x3 + I_LARGO * 3, Y_FRETS, null);
                }
                if (dato[4] == 1 || naranja2 && color2[4] == 0) {
                    g.drawImage(iFretsPresionadas[4], x3 + I_LARGO * 4, Y_FRETS, null);
                }

                sprite.setFrame((i++) / 5);
                if (i > 20) {
                    i = 0;
                }
                if (acumulador >= 0 && acumulador < 21) {
                    g.drawImage(iBarra[2], X_BARRA2, Y_BARRA, null);
                }
                if (acumulador >= 21 && acumulador < 41) {
                    g.drawImage(iBarra[1], X_BARRA2, Y_BARRA, null);
                }
                if (acumulador >= 41 && acumulador < 61) {
                    g.drawImage(iBarra[0], X_BARRA2, Y_BARRA, null);
                }
                if (acumulador2 >= 0 && acumulador2 < 21) {
                    g.drawImage(iBarra[2], X_BARRA3, Y_BARRA, null);
                }
                if (acumulador2 >= 21 && acumulador2 < 41) {
                    g.drawImage(iBarra[1], X_BARRA3, Y_BARRA, null);
                }
                if (acumulador2 >= 41 && acumulador2 < 61) {
                    g.drawImage(iBarra[0], X_BARRA3, Y_BARRA, null);
                }
                pintaBarra(g, X_BARRA2, 1);
                pintaBarra(g, X_BARRA3, 2);
                pintaPuntaje(g);
                pintaPuntaje2(g);
                gifs[0].paintIcon(this, g, X_BARRA2 - 150, Y_BARRA - 50);
                gifs[1].paintIcon(this, g, 1050, 250);
                if (pausa) {
                    g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1));
                    g.drawImage(iMenu[8], x - 25, 180, null);
                    g.drawImage(iMenu[9], x + 25, 380, null);
                    g.drawImage(iMenu[7], x + 25, 460, null);
                    g.drawImage(iMenu[6], x - 55, yFlecha_pausa, null);
                }
            }
            if (gana) {
                pintaGanaste(g);
            }
            if (pierde) {
                pintaPerdiste(g);
            }
        }
    }

    public void pintaBarra(Graphics g, int x, int i) {
        if (i == 1) {
            g.setColor(Color.white);
            g.fillRect(x - 3, (int) ((Y_BARRA + ALTO_BARRA) - Math.round(2.916 * acumulador)), 40, 5);
        } else {
            g.setColor(Color.white);
            g.fillRect(x - 3, (int) ((Y_BARRA + ALTO_BARRA) - Math.round(2.916 * acumulador2)), 40, 5);
        }
    }

    public void pintaPuntaje(Graphics g) {
        g.setColor(Color.white);
        g.setFont(new Font("fuente", Font.BOLD, 30));
        g.drawString("Puntaje: " + puntaje, 50, 600);
        g.setFont(new Font("fuente", Font.BOLD, 20));
        g.drawString("Notas Seguidas: " + notasCons, 50, 640);
        g.setFont(new Font("fuente", Font.BOLD, 30));
        g.setColor(Color.white);
        g.drawString("X" + multiplicador, x2 + I_LARGO * 2 + 15, Y_FRETS + I_ALTO * 2);
    }

    public void pintaPuntaje2(Graphics g) {
        g.setColor(Color.white);
        g.setFont(new Font("fuente", Font.BOLD, 30));
        g.drawString("Puntaje: " + puntaje2, 1100, 600);
        g.setFont(new Font("fuente", Font.BOLD, 20));
        g.drawString("Notas Seguidas: " + notasCons2, 1100, 640);
        g.setFont(new Font("fuente", Font.BOLD, 30));
        g.setColor(Color.white);
        g.drawString("X" + multiplicador2, x3 + I_LARGO * 2 + 15, Y_FRETS + I_ALTO * 2);
    }

    public void pintaGanaste(Graphics g) {
        g.drawImage(iFin[0], x - 300, 140, null);
        youRock.paintIcon(this, g, x - 330, 50);
        g.setColor(Color.black);
        g.fillRect(x + 300, 70, 450, 200);
        g.setColor(Color.white);
        g.setFont(new Font("fuente", Font.ROMAN_BASELINE, 40));
        g.drawString("Puntuacion: " + puntaje, x + 330, 120);
        g.drawString("Combo maximo: " + comboMaximo, x + 330, 160);
        g.setColor(Color.red);
        g.drawString("Porcentaje: " + Math.round((notasAcertadas * 100) / notasTotales) + "%", x + 330, 200);
        g.setColor(Color.white);
        g.drawString("Acertadas: " + notasAcertadas, x + 330, 240);
        g.drawImage(iMenu[11], x + 30, 350, null);
        g.drawImage(iFin[3], x + 30, 430, null);
        g.drawImage(iMenu[7], x + 30, 510, null);
        g.drawImage(iMenu[6], x - 40, yFlecha_gana, null);

    }

    public void pintaPerdiste(Graphics g) {
        g.drawImage(iFin[1], x - 25, 140, null);
        g.drawImage(iFin[2], x - 100, 400, null);
        g.drawImage(iFin[3], x + 20, 500, null);
        g.drawImage(iMenu[6], xPerdiste, yPerdiste, null);

    }

    public void pintaLineas(Graphics g, int x, Nodo aux) {
        int yaux = 0;// variable utilizada para la posicion en y del rectangulo desde la esquina superior izquierda
        int lfija = Math.round(aux.duracion * vExpert); //longitud final de la duracion, estab es la duracion que deberia tener todo el rectangulo
        if (aux.duracion != 0) { //las notas sin duracion no tienen  los rectangulos
            if (aux.y <= 0) { // soluciona errores del tamaño del rectangulo en el modo editor
                aux.laux = 0;
            }

            if (Math.round(aux.duracion * vExpert) > P_MAX) { // verificamos si la longitud es mayor a 350 que es nuestro P_MAX que es la distancia en pixeles desde donde salen las notas hatsa los frets
                if (aux.laux < lfija) // preguntamos que si la longitud auxiliar es mayor a la maxima, si es asi se va incrementando conforme aumenta ya
                {
                    aux.laux = aux.y - 250; // aqui aumentamos la longitud auxiliar
                } else {
                    aux.laux = lfija; // si la longitud es igual o mayor a la longitud mas grande se queda en esa longitud
                }
                yaux = aux.y - aux.laux;  // la posicion de y del rectangulo que la tomamos desde la posicion de y de la nota - la longitud del rectangulo que por cierto tiempo sera 250 que es de donde salen las notas
                if (yaux + aux.laux > Y_FRETS) { // preguntamos que si las notas se pasaron de los frets en y es decir la esquina de hasta abajo del rectangulo
                    if (yaux <= 250) { // utilizamos esto para evitar errores al regresar en el modo editor
                        if (aux.y >= Y_FRETS) // si y de las notas se pasa de los fretas
                        {
                            g.fillRect(x + 25, 250, 16, 365); // dibujamos un rectango en la posicion en x  deseada pero de tamaño fijo que seria P_MAX
                        } else {
                            g.fillRect(x + 25, 250, 16, aux.y - 250); // si no dibujamos un rectangulo de tamaño menor conforme a la posicion en y
                        }
                    } else {
                        g.fillRect(x + 25, yaux, 16, aux.laux - (aux.y - Y_FRETS));   //esto lo usamos para dibuja run rectangulo y que este no se pase de los frets y que vaya aumentando y disminuyendo su tamaño en funcion d ela posicion en y y la longitud auxiliar
                    }
                } else {
                    if (yaux <= 250) {
                        if (aux.y >= Y_FRETS) {
                            g.fillRect(x + 25, 250, 16, 365);
                        } else {
                            g.fillRect(x + 25, 250, 16, aux.y - 250);
                        }
                    } else {
                        g.fillRect(x + 25, yaux, 16, aux.laux);
                    }
                }

            } else {// es si el rectangulo es menor a 350
                if (aux.laux < lfija) {
                    aux.laux = aux.y - 250;
                } else {
                    aux.laux = lfija;
                }
                yaux = aux.y - aux.laux;
                if (yaux + aux.laux > Y_FRETS) {
                    if (yaux <= 250) {
                        g.fillRect(x + 25, 250, 16, aux.y - 250); // utilizamos el mismo argumento para calcular el tamaño de los rectangulos
                    } else {
                        g.fillRect(x + 25, yaux, 16, aux.laux - (aux.y - Y_FRETS)); // misma funcion de el if anterior
                    }
                } else {
                    if (yaux <= 250) {
                        g.fillRect(x + 25, 250, 16, aux.y - 250);
                    } else {
                        g.fillRect(x + 25, yaux, 16, aux.laux);
                    }
                }
            }
        }
    }

    public void realesed() {
        Nodo aux;
        if (dato[0] == 0) {
            if (acerto2[0] == true) {
                aux = notas.indexOf(ac2[0]);
                if (aux != null) {
                    aux.color2 = Color.GRAY;
                }
                ac2[0] = 0;
                acerto2[0] = false;
            }
        }

        if (dato[1] == 0) {
            if (acerto2[1] == true) {
                aux = notas.indexOf(ac2[1]);
                if (aux != null) {
                    aux.color2 = Color.GRAY;
                }
                ac2[1] = 0;
                acerto2[1] = false;
            }
        }

        if (dato[2] == 0) {
            if (acerto2[2] == true) {
                aux = notas.indexOf(ac2[2]);
                if (aux != null) {
                    aux.color2 = Color.GRAY;
                }
                ac2[2] = 0;
                acerto2[2] = false;
            }
        }

        if (dato[3] == 0) {
            if (acerto2[3] == true) {
                aux = notas.indexOf(ac2[3]);
                if (aux != null) {
                    aux.color2 = Color.GRAY;
                }
                ac2[3] = 0;
                acerto2[3] = false;
            }
        }

        if (dato[4] == 0) {
            if (acerto[4] == true) {
                aux = notas.indexOf(ac2[4]);
                if (aux != null) {
                    aux.color2 = Color.GRAY;
                }
                ac2[4] = 0;
                acerto[4] = false;
            }
        }

    }

    public void cicloPrincipalJuego() throws Exception {
        /*if(lecturaSerial.portsFree.size()>0)
            lecturaSerial.start();*/
        while (true) {
            /*if(lecturaSerial.portsFree.size()>0){
                realesed();
                switch(lecturaSerial.datoPuerto.length()){
                    case 1:
                        if(lecturaSerial.datoPuerto.equals("1"))
                            dato[0]=1;
                        else{
                            for (int j = 0; j < 5; j++) {
                                dato[j]=0;
                            }     
                        }
                        break;
                    case 2:
                        char[] aux = lecturaSerial.datoPuerto.toCharArray();
                        if(aux[0]=='1') dato[1]=1; else dato[1]=0;
                        if(aux[1]=='1') dato[0]=1; else dato[0]=0;
                        break;
                    case 3:
                        aux = lecturaSerial.datoPuerto.toCharArray();
                        if(aux[0]=='1') dato[2]=1; else dato[2]=0;
                        if(aux[1]=='1') dato[1]=1; else dato[1]=0;
                        if(aux[2]=='1') dato[0]=1; else dato[0]=0;
                        break;
                    case 4:
                        aux = lecturaSerial.datoPuerto.toCharArray();
                        if(aux[0]=='1') dato[3]=1; else dato[3]=0;
                        if(aux[1]=='1') dato[2]=1; else dato[2]=0;
                        if(aux[2]=='1') dato[1]=1; else dato[1]=0;
                        if(aux[3]=='1') dato[0]=1; else dato[0]=0;
                        break;
                    case 5:
                        aux = lecturaSerial.datoPuerto.toCharArray();
                        if(aux[0]=='1') dato[4]=1; else dato[4]=0;
                        if(aux[1]=='1') dato[3]=1; else dato[3]=0;
                        if(aux[2]=='1') dato[2]=1; else dato[2]=0;
                        if(aux[3]=='1') dato[1]=1; else dato[1]=0;
                        if(aux[4]=='1') dato[0]=1; else dato[0]=0;
                        break;
                }
                if (dato[0]!=0 || dato[1]!=0 || dato[2]!=0 || dato[3]!=0 || dato[4]!=0){
                    if (dato[0]==1){
                        evento2(0);
                    }
                    if (dato[1]==1){
                        evento2(1);
                    }
                    if (dato[2]==1){
                        evento2(2);
                    }
                    if (dato[3]==1){
                        evento2(3);
                    }
                    if (dato[4]==1){
                        evento2(4);
                    }
                }
            }*/
            if (menu || setlist || creditos || gana) {
                if (!theme.isActive()) {
                    theme.play();
                }
            } else {
                theme.pause();
            }
            if (editor) {
                setY();
            }
            if (juego) {
                if (!pausa) {
                    musica.play();
                    if (notas.tamaño != 0) {
                        setY();
                    } else {
                        gana = true;
                        juego = false;
                        if (notasCons > comboMaximo) {
                            comboMaximo = notasCons;
                        }
                        musica.close();
                    }
                } else {
                    musica.pause();
                }
                if (pierde) {
                    juego = false;
                    musica.pause();
                }
            }
            dibuja();
        }

    }

    private void dibuja() throws Exception {
        SwingUtilities.invokeAndWait(new Runnable() {
            public void run() {
                paintImmediately(0, 0, ANCHO, ALTO);
            }
        });
    }

    private boolean acertar(Nodo nota, int keyCode) { // se verifica si se acerto
        // la nota en un intervalo de tiempo determinado, lo comprobamos por pixeles
        if (keyCode == keyGreen && nota.color == 1 && verde && (nota.y + NI_ALTO >= (Y_FRETS) && nota.y <= (Y_FRETS + I_ALTO) && nota.pintar == true)) {
            return true;
        } else if (keyCode == keyRed && nota.color == 2 && rojo && (nota.y + NI_ALTO >= (Y_FRETS) && nota.y <= (Y_FRETS + I_ALTO) && nota.pintar == true)) {
            return true;
        } else if (keyCode == keyYellow && nota.color == 3 && amarillo && (nota.y + NI_ALTO >= (Y_FRETS) && nota.y <= (Y_FRETS + I_ALTO) && nota.pintar == true)) {
            return true;
        } else if (keyCode == keyBlue && nota.color == 4 && azul && (nota.y + NI_ALTO >= (Y_FRETS) && nota.y <= (Y_FRETS + I_ALTO) && nota.pintar == true)) {
            return true;
        } else if (keyCode == keyOrange && nota.color == 5 && naranja && (nota.y + NI_ALTO >= (Y_FRETS) && nota.y <= (Y_FRETS + I_ALTO) && nota.pintar == true)) {
            return true;
        }

        return false;
    }

    private boolean acertar2(Nodo nota, int keyCode) { // se verifica si se acerto
        // la nota en un intervalo de tiempo determinado, lo comprobamos por pixeles
        if (keyCode == keyGreen2 && nota.color == 1 && verde2 && (nota.y + NI_ALTO >= (Y_FRETS) && nota.y <= (Y_FRETS + I_ALTO) && nota.pintar == true)) {
            return true;
        } else if (keyCode == keyRed2 && nota.color == 2 && rojo2 && (nota.y + NI_ALTO >= (Y_FRETS) && nota.y <= (Y_FRETS + I_ALTO) && nota.pintar == true)) {
            return true;
        } else if (keyCode == keyYellow2 && nota.color == 3 && amarillo2 && (nota.y + NI_ALTO >= (Y_FRETS) && nota.y <= (Y_FRETS + I_ALTO) && nota.pintar == true)) {
            return true;
        } else if (keyCode == keyBlue2 && nota.color == 4 && azul2 && (nota.y + NI_ALTO >= (Y_FRETS) && nota.y <= (Y_FRETS + I_ALTO) && nota.pintar == true)) {
            return true;
        } else if (keyCode == keyOrange2 && nota.color == 5 && naranja2 && (nota.y + NI_ALTO >= (Y_FRETS) && nota.y <= (Y_FRETS + I_ALTO) && nota.pintar == true)) {
            return true;
        }

        return false;
    }

    private void setY() throws IOException {// funcion que esta constantemente cambiando
        //los y de todos los nodos de las lista
        Nodo aux;
        int tiempo = 0; // tiempo actual de la cancion en milisegundos
        float yAuxiliar = 0;//posicion en y auxiliar
        if (singleplayer || multiplayer) {
            for (int i = 0; i < notas.tamaño; i++) {
                yAuxiliar = 0;
                aux = notas.indexOf(i);
                tiempo = musica.getPosition(); // aqui se guarda el tiempo
                if (aux.tiempo - 1500 <= (musica.getPosition())) {// cuando la nota debe llegar al fret en determinado tiempo hacemos que salga en pantalla 1.5 segundos antes
                    yAuxiliar = 250 + (tiempo - aux.tiempo + 1500) * vExpert; // formula usada para mover la y de esa nota en funcion del tiempo y d euna velocidad definida para que recorra los pixeles necesarios hasta llegar al fret
                    aux.y = Math.round(yAuxiliar);
                }
                if (acerto[aux.color - 1] == false && aux.y > Y_FRETS + I_ALTO) { //si no la acierta y se pasa de los frets entonces pone el color en gris correspondiente al rectangulo
                    aux.color2 = Color.GRAY;
                }
                satura(aux, i, 1);
            }
        }
        if (multiplayer) {
            for (int i = 0; i < notas2.tamaño; i++) {
                yAuxiliar = 0;
                aux = notas2.indexOf(i);
                tiempo = musica.getPosition(); // aqui se guarda el tiempo
                if (aux.tiempo - 1500 <= (musica.getPosition())) {
                    yAuxiliar = 250 + (tiempo - aux.tiempo + 1500) * vExpert;
                    aux.y = Math.round(yAuxiliar);
                }
                if (acerto2[aux.color - 1] == false && aux.y > Y_FRETS + I_ALTO) {
                    aux.color2 = Color.GRAY;
                }
                satura(aux, i, 2);
            }
        } else if (editor) {
            for (int i = 0; i < listaEditor.tamaño; i++) {
                yAuxiliar = 0;
                aux = listaEditor.indexOf(i);
                tiempo = musicaEditor.getPosition(); // aqui se guarda el tiempo
                if (aux.tiempo - 1500 <= (musicaEditor.getPosition())) {
                    yAuxiliar = 250 + (tiempo - aux.tiempo + 1500) * vExpert;
                    aux.y = Math.round(yAuxiliar);
                } else {
                    aux.y = -I_ALTO;
                }
            }
        }
    }

    public void cargarNotas() throws IOException {// funcion para cargar en las listas las notas
        if (!cargar) {
            String[] totalNotas = aNotas.leer();
            String[] aux;
            for (int i = 0; i < aNotas.totalLineas(); i++) {
                if (!totalNotas[i].equals("")) {
                    aux = totalNotas[i].split(" "); // gardamos en un vector de srings la nota el tiempo y duracion por separado
                    notas.addLast(Integer.parseInt(aux[0]), Integer.parseInt(aux[1]), Integer.parseInt(aux[2]), -I_LARGO, i); // añadimos al final d ela lista los datos que acabamos de obtener
                    if (multiplayer) {
                        notas2.addLast(Integer.parseInt(aux[0]), Integer.parseInt(aux[1]), Integer.parseInt(aux[2]), -I_LARGO, i); // utilizamos la clase Integer para que nos convierta losn strings en numeros enteros
                    }
                    if (editor) {
                        listaEditor.addLast(Integer.parseInt(aux[0]), Integer.parseInt(aux[1]), Integer.parseInt(aux[2]), -I_LARGO, i);
                    }
                }
            }
            notasTotales = notas.tamaño;
            cargar = true;
        }
    }

    private void satura(Nodo nota, int posicion, int indice) { // funcion usada para eliminar nodos
        //si ya pasaron la pantalla
        if (indice == 1) { // si es single player
            if (nota.y > Y_FRETS + I_ALTO) { // si las notas pasan de los frets decrementamos nuestro vector ac que es dond eguardamos los index de los nodos
                for (int j = 0; j < 5; j++) {
                    if (ac[j] != 0) {
                        ac[j]--;
                    }
                }
            }
            if (nota.tiempo <= musica.getPosition() - 250) { // si el tiempo mas su duracion se pasa de la posicion actual de la musica con una tolerancia de 250 ms se elimina esta nota de la lista enlazada
                if (nota.y >= ALTO + nota.duracion * vExpert) {
                    notas.deleteSel(posicion);
                    band2[nota.color - 1] = false;
                }
                Nodo aux;
                if (nota.pintar == true && band2[nota.color - 1] == false) { // si la nota sigue pintada sigbnifica que no la acerto y como arriba preguntamos si se paso de los frets entonces decrementamos todos los stats
                    if (notasCons > comboMaximo) // guardamos siempre el combo maximo
                    {
                        comboMaximo = notasCons;
                    }
                    notasCons = 0;
                    multiplicador = 1;
                    if (acumulador > 0) {
                        acumulador -= 2;
                    }
                    if (acumulador <= 0) {
                        //pierde=true;
                        acumulador = 0;
                    }
                    for (int i = 0; i < notas.tamaño; i++) { // en este for cargamos todas las notas en un nodo auxiliar
                        aux = notas.indexOf(i);
                        if (aux != null) {
                            aux.index = i;
                        }
                    }
                    band2[nota.color - 1] = true; // variabe usada para saber si la acerto o no
                }
            }
        } else { // si es multiplayer y jugador 2
            if (nota.y > Y_FRETS + I_ALTO) {
                for (int j = 0; j < 5; j++) {
                    if (ac2[j] != 0) {
                        ac2[j]--;
                    }
                }
            }
            if (nota.tiempo <= musica.getPosition() - 250) {
                Nodo aux;
                if (nota.y >= ALTO + nota.duracion * vExpert) {
                    notas2.deleteSel(posicion);
                    band4[nota.color - 1] = false;
                }
                if (nota.pintar == true && band4[nota.color - 1] == false) {
                    if (notasCons2 > comboMaximo2) {
                        comboMaximo2 = notasCons2;
                    }
                    notasCons2 = 0;
                    multiplicador2 = 1;
                    if (acumulador2 > 0) {
                        acumulador2 -= 2;
                    }
                    if (acumulador2 <= 0) {
                        //pierde=true;
                        acumulador2 = 0;
                    }
                }
                for (int i = 0; i < notas2.tamaño; i++) {
                    aux = notas2.indexOf(i);
                    aux.index = i;
                }
                band4[nota.color - 1] = true; // variabe usada para saber si la acerto o no
            }
        }
    }

    public void muestraDialogoArchivo() throws LineUnavailableException, UnsupportedAudioFileException, IOException {
        File archivo;
        File archivo2;
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        JFileChooser dialogo = new JFileChooser(); // creamos una ventana para elegir el archivo
        dialogo.setDialogTitle("Elige Cancion"); // titulo d ela ventana
        dialogo.setAcceptAllFileFilterUsed(false); // quitamos el filtro de todos los archivos
        dialogo.setFileFilter(new FileNameExtensionFilter("AIF", "aif")); // clocamos los filtros de los unicos archivos que puede leer la libreria clip
        dialogo.setFileFilter(new FileNameExtensionFilter("AU", "au"));
        dialogo.setFileFilter(new FileNameExtensionFilter("Wave", "wav"));
        dialogo.setVisible(true);
        int seleccion = dialogo.showOpenDialog(null);
        if (seleccion == JFileChooser.APPROVE_OPTION) { // este evento sucede cuando da click en aceptar
            String[] aux;
            archivo = dialogo.getSelectedFile(); // en un objeto tipo File guardamos el archivo seleccionado
            ruta = archivo.getPath(); // obtenemos la ruta
            char auxi[] = ruta.toCharArray();
            for (int j = 0; j < auxi.length; j++) {
                if (auxi[j] == '\\') // cambiamos las diagonales hacia la izquierda por diagonales hacia la derecha
                {
                    auxi[j] = '/';
                }
            }
            ruta = new String(auxi); // guardamos la rutab con las diagonales correctas
            nombreCancion = archivo.getName(); // guardamos el nombre del archivo
            aux = nombreCancion.split("\\."); // usamos el split para obtener en vector de archivos strings divididos por punto
            archivo2 = new File("resources/J_notas/" + aux[0] + ".txt"); // hacemos un archivo de la ruta que tenemos ara guardar las notas
            System.out.println("ruta: " + ruta);
            musicaEditor = new Musica();
            musicaEditor.setSong(archivo);
            editor = true;
            menu = false;
            System.out.println("archivo2: " + archivo2.getAbsolutePath());
            if (archivo2.exists()) {// verificamos i ela rchvio existe entonces usamos ese archivo si no lo creamos
                aNotas = new FileManager("resources/J_notas/" + aux[0] + ".txt");
                cargarNotas();
            }

        }
    }

    public static void main(String[] args) throws Exception {
        JFrame jf = new JFrame("GUITAR");
        final GuitarHero demo1 = new GuitarHero();
        jf.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                /*try {
                    demo1.lecturaSerial.com1.close();
                } catch (Exception ex) {}*/
                System.exit(0);

            }
        });
        jf.setResizable(false);
        jf.getContentPane().add(demo1);
        jf.pack();
        //jf.setLocationRelativeTo(null);
        jf.setVisible(true);
        demo1.cicloPrincipalJuego();
    }

    public class Keylistener extends KeyAdapter { // clase anidada para el oyente del teclado

        Nodo[] nodosAux = new Nodo[5]; // los utilizamos para guardar el tiempo inicial y al final cuando suelta la tecla le retsamos los tiempos para guardarlos en el nodo en duracion esto para el modo editor
        int vec1[] = new int[5]; // tiempo que se toma el presionar la tecla
        int vec2[] = new int[5]; // tiempo que se toma al soltar la tecla
        Nodo[] nodosAux2 = new Nodo[5]; // los utilizamos para guardar el tiempo inicial y al final cuando suelta la tecla le retsamos los tiempos para guardarlos en el nodo en duracion esto para el modo editor
        int vec3[] = new int[5]; // tiempo que se toma el presionar la tecla
        int vec4[] = new int[5]; // tiempo que se toma al soltar la tecla

        Keylistener() {
            for (int j = 0; j < 5; j++) {
                vec1[j] = 0;
                vec2[j] = 0;
                vec3[j] = 0;
                vec4[j] = 0;
            }
        }

        public void keyPressed(KeyEvent e) {
            if (!pausa) {
                actualiza(e.getKeyCode(), true);
            } else {
                verde = rojo = amarillo = azul = naranja = false;
            }
            /*if (multiplayer){
                evento(e.getKeyCode());
            }*/
            if (e.getKeyCode() == keyGreen || e.getKeyCode() == keyRed || e.getKeyCode() == keyYellow || e.getKeyCode() == keyBlue || e.getKeyCode() == keyOrange) {
                if (!band[e.getKeyCode() - 65]) {
                    if (juego) {
                        evento(e.getKeyCode());
                    }
                    if (editor) {
                        band[e.getKeyCode() - 65] = true;
                        if (musicaEditor.isActive()) {
                            switch (e.getKeyCode()) {
                                case keyGreen:
                                    vec1[0] = musicaEditor.getPosition();
                                    break;
                                case keyRed:
                                    vec1[1] = musicaEditor.getPosition();
                                    break;
                                case keyYellow:
                                    vec1[2] = musicaEditor.getPosition();
                                    break;
                                case keyBlue:
                                    vec1[3] = musicaEditor.getPosition();
                                    break;
                                case keyOrange:
                                    vec1[4] = musicaEditor.getPosition();
                                    break;
                            }
                        }
                        switch (e.getKeyCode()) {
                            case keyGreen:
                                Nodo buscado = listaEditor.buscaTiempo(musicaEditor.getPosition(), 1);
                                if (buscado == null) {
                                    nodosAux[0] = añadeListaEditor(1);
                                } else {
                                    listaEditor.deleteNodo(buscado);
                                }
                                break;
                            case keyRed:
                                buscado = listaEditor.buscaTiempo(musicaEditor.getPosition(), 2);
                                if (buscado == null) {
                                    nodosAux[1] = añadeListaEditor(2);
                                } else {
                                    listaEditor.deleteNodo(buscado);
                                }
                                break;
                            case keyYellow:
                                buscado = listaEditor.buscaTiempo(musicaEditor.getPosition(), 3);
                                if (buscado == null) {
                                    nodosAux[2] = añadeListaEditor(3);
                                } else {
                                    listaEditor.deleteNodo(buscado);
                                }
                                break;
                            case keyBlue:
                                buscado = listaEditor.buscaTiempo(musicaEditor.getPosition(), 4);
                                if (buscado == null) {
                                    nodosAux[3] = añadeListaEditor(4);
                                } else {
                                    listaEditor.deleteNodo(buscado);
                                }
                                break;
                            case keyOrange:
                                buscado = listaEditor.buscaTiempo(musicaEditor.getPosition(), 5);
                                if (buscado == null) {
                                    nodosAux[4] = añadeListaEditor(5);
                                } else {
                                    listaEditor.deleteNodo(buscado);
                                }
                                break;
                        }
                    }
                }
            }
            if (multiplayer && (e.getKeyCode() == keyGreen2 || e.getKeyCode() == keyRed2 || e.getKeyCode() == keyYellow2 || e.getKeyCode() == keyBlue2 || e.getKeyCode() == keyOrange2)) {
                if (!band3[getIndexColor(e.getKeyCode())]) {
                    if (juego) {
                        evento2(e.getKeyCode());
                    }
                }
            }

            if (editor) {
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    TimerTask task = new TimerTask() {
                        @Override
                        public void run() {
                            if (!musicaEditor.isActive()) {
                                musicaEditor.setMilisecondPosition(musicaEditor.getPosition() + step);
                                if (verde) {
                                    nodosAux[0].duracion += step;
                                }
                                if (rojo) {
                                    nodosAux[1].duracion += step;
                                }
                                if (amarillo) {
                                    nodosAux[2].duracion += step;
                                }
                                if (azul) {
                                    nodosAux[3].duracion += step;
                                }
                                if (naranja) {
                                    nodosAux[4].duracion += step;
                                }
                            }
                        }

                    };

                    timer = new TimerCustom(DELAY_TIMER, task);
                    timer.run();
                }
                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    TimerTask task2 = new TimerTask() {

                        @Override
                        public void run() {
                            if (!musicaEditor.isActive()) { // si se esta reproduciendo
                                musicaEditor.setMilisecondPosition(musicaEditor.getPosition() - step); // ponemos la posicion menos el salto
                            }
                        }
                    };
                    timer = new TimerCustom(DELAY_TIMER, task2);
                    timer.run();
                }

                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    TimerTask task3 = new TimerTask() {

                        @Override
                        public void run() {
                            if (step > 50) {
                                step -= 50;
                            }
                        }
                    };
                    timerGap = new TimerCustom(DELAY_TIMER_GAP, task3);
                    timerGap.run();

                }
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    TimerTask task4 = new TimerTask() {

                        @Override
                        public void run() {
                            if (step < 2000) {
                                step += 50;
                            }
                        }
                    };
                    timerGap = new TimerCustom(DELAY_TIMER_GAP, task4);
                    timerGap.run();
                }
            }
        }

        public int getIndexColor(int tecla) {
            int index = 0;
            switch (tecla) {
                case keyGreen2:
                    index = 0;
                    break;
                case keyRed2:
                    index = 1;
                    break;
                case keyYellow2:
                    index = 2;
                    break;
                case keyBlue2:
                    index = 3;
                    break;
                case keyOrange2:
                    index = 4;
                    break;
            }
            return index;
        }

        public void keyReleased(KeyEvent e) {
            if (!pausa) {
                actualiza(e.getKeyCode(), false);
            } else {
                verde = rojo = amarillo = azul = naranja = verde2 = rojo2 = amarillo2 = naranja2 = azul2 = false;
            }
            if (e.getKeyCode() == keyGreen2 || e.getKeyCode() == keyRed2 || e.getKeyCode() == keyYellow2 || e.getKeyCode() == keyBlue2 || e.getKeyCode() == keyOrange2) {
                band3[getIndexColor(e.getKeyCode())] = false;
            }
            if (e.getKeyCode() == keyGreen || e.getKeyCode() == keyRed || e.getKeyCode() == keyYellow || e.getKeyCode() == keyBlue || e.getKeyCode() == keyOrange) {
                band[e.getKeyCode() - 65] = false;
                if (editor) {
                    if (musicaEditor.isActive()) {
                        switch (e.getKeyCode()) {
                            case keyGreen:
                                vec2[0] = musicaEditor.getPosition();
                                if (vec2[0] - vec1[0] > 200) {
                                    nodosAux[0].duracion = vec2[0] - vec1[0];
                                }
                                break;
                            case keyRed:
                                vec2[1] = musicaEditor.getPosition();
                                if (vec2[1] - vec1[1] > 200) {
                                    nodosAux[1].duracion = vec2[1] - vec1[1];
                                }
                                break;
                            case keyYellow:
                                vec2[2] = musicaEditor.getPosition();
                                if (vec2[2] - vec1[2] > 200) {
                                    nodosAux[2].duracion = vec2[2] - vec1[2];
                                }
                                break;
                            case keyBlue:
                                vec2[3] = musicaEditor.getPosition();
                                if (vec2[3] - vec1[3] > 200) {
                                    nodosAux[3].duracion = vec2[3] - vec1[3];
                                }
                                break;
                            case keyOrange:
                                vec2[4] = musicaEditor.getPosition();
                                if (vec2[4] - vec1[4] > 200) {
                                    nodosAux[4].duracion = vec2[4] - vec1[4];
                                }
                                break;
                        }
                    }

                }
            }
            Nodo aux;
            switch (e.getKeyCode()) {
                case KeyEvent.VK_A:
                    nodosAux[0] = null;
                    if (acerto[0] == true) {
                        aux = notas.indexOf(ac[0]);
                        if (aux != null) {
                            aux.color2 = Color.GRAY;
                        }
                        ac[0] = 0;
                        acerto[0] = false;
                    }

                    break;

                case KeyEvent.VK_S:
                    nodosAux[1] = null;
                    if (acerto[1] == true) {
                        aux = notas.indexOf(ac[1]);
                        if (aux != null) {
                            aux.color2 = Color.GRAY;
                        }
                        ac[1] = 0;
                        acerto[1] = false;
                    }
                    break;

                case KeyEvent.VK_J:
                    nodosAux[2] = null;
                    if (acerto[2] == true) {
                        aux = notas.indexOf(ac[2]);
                        if (aux != null) {
                            aux.color2 = Color.GRAY;
                        }
                        ac[2] = 0;
                        acerto[2] = false;
                    }
                    break;

                case KeyEvent.VK_K:
                    nodosAux[3] = null;
                    if (acerto[3] == true) {
                        aux = notas.indexOf(ac[3]);
                        if (aux != null) {
                            aux.color2 = Color.GRAY;
                        }
                        ac[3] = 0;
                        acerto[3] = false;
                    }
                    break;

                case KeyEvent.VK_L:
                    nodosAux[4] = null;
                    if (acerto[4] == true) {
                        aux = notas.indexOf(ac[4]);
                        if (aux != null) {
                            aux.color2 = Color.GRAY;
                        }
                        ac[4] = 0;
                        acerto[4] = false;
                    }
                    break;
                case keyGreen2:
                    nodosAux2[0] = null;
                    if (acerto2[0] == true) {
                        aux = notas2.indexOf(ac2[0]);
                        if (aux != null) {
                            aux.color2 = Color.GRAY;
                        }
                        ac2[0] = 0;
                        acerto2[0] = false;
                    }

                    break;

                case keyRed2:
                    nodosAux2[1] = null;
                    if (acerto2[1] == true) {
                        aux = notas2.indexOf(ac2[1]);
                        if (aux != null) {
                            aux.color2 = Color.GRAY;
                        }
                        ac2[1] = 0;
                        acerto2[1] = false;
                    }
                    break;

                case keyYellow2:
                    nodosAux2[2] = null;
                    if (acerto2[2] == true) {
                        aux = notas2.indexOf(ac2[2]);
                        if (aux != null) {
                            aux.color2 = Color.GRAY;
                        }
                        ac2[2] = 0;
                        acerto2[2] = false;
                    }
                    break;

                case keyBlue2:
                    nodosAux2[3] = null;
                    if (acerto2[3] == true) {
                        aux = notas2.indexOf(ac2[3]);
                        if (aux != null) {
                            aux.color2 = Color.GRAY;
                        }
                        ac2[3] = 0;
                        acerto2[3] = false;
                    }
                    break;

                case keyOrange2:
                    nodosAux2[4] = null;
                    if (acerto2[4] == true) {
                        aux = notas2.indexOf(ac2[4]);
                        if (aux != null) {
                            aux.color2 = Color.GRAY;
                        }
                        ac2[4] = 0;
                        acerto2[4] = false;
                    }
                    break;
            }
            if (e.getKeyCode() == KeyEvent.VK_P && pausa) {
                pausa = false;
            } else if (e.getKeyCode() == KeyEvent.VK_P && !pausa) {
                pausa = true;
            }
            if (e.getKeyCode() == KeyEvent.VK_UP) {
                if (menu) {
                    if (yFlecha == 40) {
                        yFlecha = 440;
                    } else {
                        yFlecha -= 80;
                    }
                }
                if (setlist) {
                    if (yFlecha_setlist == 150 && indexsong == 1) {
                        //yFlecha_setlist=5*50+150;
                        if (totalCanciones <= 6) {
                            yFlecha_setlist += (totalCanciones - 1) * 50;
                        } else {
                            yFlecha_setlist = 5 * 50 + 150;
                        }
                        indexsong = totalCanciones;
                        inicioLista = totalCanciones - 6;
                    } else {
                        if (yFlecha_setlist == 150) {
                            inicioLista--;
                            indexsong--;
                        } else {
                            yFlecha_setlist -= 50;
                            indexsong--;
                        }
                    }
                }
                if (pierde) {
                    if (xPerdiste == 310 && yPerdiste == 400) {
                        xPerdiste = 420;
                        yPerdiste = 500;
                    } else {
                        xPerdiste = 310;
                        yPerdiste = 400;
                    }
                }
                if (pausa) {
                    if (yFlecha_pausa == 380) {
                        yFlecha_pausa = 460;
                    } else {
                        yFlecha_pausa = 380;
                    }
                }
                if (gana) {
                    if (yFlecha_gana == 350) {
                        yFlecha_gana = 510;
                    } else {
                        yFlecha_gana -= 80;
                    }
                }
                if (editor) {
                    timer.destroy();

                }

            }
            if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                if (menu) {
                    if (yFlecha == 440) {
                        yFlecha = 40;
                    } else {
                        yFlecha += 80;
                    }
                }
                if (setlist) {
                    if ((totalCanciones <= 6 && yFlecha_setlist == (totalCanciones - 1) * 50 + 150 && indexsong == totalCanciones) || (yFlecha_setlist == 5 * 50 + 150 && indexsong == totalCanciones)) {
                        yFlecha_setlist = 150;
                        indexsong = 1;
                        inicioLista = 0;
                    } else {
                        if (yFlecha_setlist == 5 * 50 + 150) {
                            inicioLista++;

                            indexsong++;
                        } else {
                            yFlecha_setlist += 50;
                            indexsong++;
                        }

                    }
                }
                if (pierde) {
                    if (xPerdiste == 420 && yPerdiste == 500) {
                        xPerdiste = 310;
                        yPerdiste = 400;
                    } else {
                        xPerdiste = 420;
                        yPerdiste = 500;
                    }
                }
                if (pausa) {
                    if (yFlecha_pausa == 380) {
                        yFlecha_pausa = 460;
                    } else {
                        yFlecha_pausa = 380;
                    }
                }
                if (gana) {
                    if (yFlecha_gana == 510) {
                        yFlecha_gana = 350;
                    } else {
                        yFlecha_gana += 80;
                    }
                }
                if (editor) {
                    timer.destroy();

                }

            }
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                if (setlist && !juego) {
                    borraLista();
                    setlist = false;
                    int z = indexsong - 1;//(yFlecha_setlist-150)/50;
                    String[] auxi;
                    auxi = songlist[z].split("-");
                    if (z == 0) {
                        wall3 = 4;
                    } else if (z == 1) {
                        wall3 = 1;
                    } else {
                        rand = new Random();
                        wall3 = rand.nextInt(5);
                    }
                    aNotas = new FileManager("resources/J_notas/" + auxi[0] + ".txt");
                    try {
                        musica.setSong(auxi[1]);
                    } catch (LineUnavailableException | UnsupportedAudioFileException | IOException ex) {
                        Logger.getLogger(GuitarHero.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    juego = true;
                    if (yFlecha == 40) {
                        singleplayer = true;
                    }
                    if (yFlecha == 120) {
                        multiplayer = true;
                    }
                    if (xFlecha_setlist == 180) {
                        teclado = true;
                    }
                    if (xFlecha_setlist == 680) {
                        teclado = true;

                    }
                    try {
                        cargarNotas();
                    } catch (IOException ex) {
                    }
                    musica.setInicio();
                    musica.play();
                }
                if (menu) {
                    if (yFlecha == 40) {
                        menu = false;
                        setlist = true;
                        sp = true;
                    }
                    if (yFlecha == 120) {
                        menu = false;
                        setlist = true;
                    }
                    if (yFlecha == 200) {

                    }
                    if (yFlecha == 280) {
                        try {
                            muestraDialogoArchivo();
                        } catch (LineUnavailableException | UnsupportedAudioFileException | IOException ex) {
                            Logger.getLogger(GuitarHero.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    if (yFlecha == 360) {
                        menu = false;
                        creditos = true;
                    }
                    if (yFlecha == 440) {
                        System.exit(0);
                    }
                }
                if (pierde) {
                    if (xPerdiste == 310) {
                        borraLista();
                        reiniciaStats();
                        try {
                            cargarNotas();
                        } catch (IOException ex) {
                        }
                        musica.setInicio();
                        musica.play();
                    }
                    if (xPerdiste == 420) {
                        borraLista();
                        reiniciaStats();
                        if (singleplayer) {
                            singleplayer = false;
                        }
                        if (multiplayer) {
                            multiplayer = false;
                            yFlecha = 120;
                        }
                        setlist = true;
                        juego = false;
                        musica.pause();
                    }
                }
                if (pausa && !menu && !setlist && !creditos) {
                    if (yFlecha_pausa == 380) {
                        borraLista();
                        reiniciaStats();
                        try {
                            cargarNotas();
                        } catch (IOException ex) {
                        }
                        musica.setInicio();
                        musica.play();
                    }
                    if (yFlecha_pausa == 460) {
                        borraLista();
                        reiniciaStats();
                        menu = true;
                        if (singleplayer) {
                            singleplayer = false;
                        }
                        if (multiplayer) {
                            multiplayer = false;
                        }
                        juego = false;
                        setlist = false;
                        musica.pause();
                    }
                }
                if (gana) {
                    if (yFlecha_gana == 350) {
                        borraLista();
                        reiniciaStats();
                        menu = true;
                        if (singleplayer) {
                            singleplayer = false;
                        }
                        if (multiplayer) {
                            multiplayer = false;
                        }
                        juego = false;
                        setlist = false;
                    }
                    if (yFlecha_gana == 430) {
                        borraLista();
                        reiniciaStats();
                        if (singleplayer) {
                            singleplayer = false;
                        }
                        if (multiplayer) {
                            multiplayer = false;
                            yFlecha = 120;
                        }
                        setlist = true;
                        juego = false;
                    }
                    if (yFlecha_gana == 510) {
                        System.exit(0);
                    }
                }
            }
            if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                if (editor) {
                    timerGap.destroy();
                }
                /*if (setlist) {
                    if (xFlecha_setlist == 180) {
                        xFlecha_setlist = 680;
                    } else {
                        xFlecha_setlist = 180;
                    }
                }*/
            }
            if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                if (editor) {
                    timerGap.destroy();
                }
                /*if (setlist) {
                    if (xFlecha_setlist == 180) {
                        xFlecha_setlist = 680;
                    } else {
                        xFlecha_setlist = 180;
                    }
                }*/
            }
            if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                if (editor) {
                    if (musicaEditor.isActive()) {
                        musicaEditor.pause();
                    } else {
                        musicaEditor.play();
                    }
                }
            }
            if (e.getKeyCode() == KeyEvent.VK_1) {
                if (editor) {
                    Nodo buscado = listaEditor.buscaNodoAnt(musicaEditor.getPosition());
                    if (buscado != null) {
                        musicaEditor.setMilisecondPosition(buscado.tiempo);
                    }
                }
            }
            if (e.getKeyCode() == KeyEvent.VK_2) {
                if (editor) {
                    Nodo buscado = listaEditor.buscaNodoSig(musicaEditor.getPosition());
                    if (buscado != null) {
                        musicaEditor.setMilisecondPosition(buscado.tiempo);
                    }
                }
            }
            if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                if (creditos) {
                    creditos = false;
                    menu = true;
                }
                if (setlist) {
                    menu = true;
                    setlist = false;
                }
                if (editor) {
                    borraLista();
                    cargar = false;
                    menu = true;
                    editor = false;
                }
            }
            if (e.getKeyCode() == KeyEvent.VK_R && editor) { // para guardar el archivo en el modo editor
                String[] cancion;
                cancion = nombreCancion.split("\\.");
                try {
                    guardar(cancion[0]);
                    totalCanciones = lista.totalLineas();
                    songlist = new String[totalCanciones];
                    songlist = lista.leer();
                } catch (IOException ex) {
                }

            }
            if (e.getKeyCode() == KeyEvent.VK_3) { // elimna el nodo anterior en el modo editor
                Nodo buscado = listaEditor.buscaNodoAnt(musicaEditor.getPosition());
                if (buscado != null) {
                    listaEditor.deleteNodo(buscado);
                }

            }
            if (e.getKeyCode() == KeyEvent.VK_4) { // elimina el nodo siguiente en el modo editor
                Nodo buscado = listaEditor.buscaNodoSig(musicaEditor.getPosition());
                if (buscado != null) {
                    listaEditor.deleteNodo(buscado);
                }
            }
            if (e.getKeyCode() == KeyEvent.VK_5) { // elimina todas las notas
                listaEditor.deleteAll();
            }
        }

        private void actualiza(int keyCode, boolean pressed) {
            switch (keyCode) {
                case KeyEvent.VK_A:
                    verde = pressed;
                    break;
                case KeyEvent.VK_S:
                    rojo = pressed;
                    break;
                case KeyEvent.VK_J:
                    amarillo = pressed;
                    break;
                case KeyEvent.VK_K:
                    azul = pressed;
                    break;
                case KeyEvent.VK_L:
                    naranja = pressed;
                    break;
                case KeyEvent.VK_Q:
                    verde2 = pressed;
                    break;
                case KeyEvent.VK_W:
                    rojo2 = pressed;
                    break;
                case KeyEvent.VK_Y:
                    amarillo2 = pressed;
                    break;
                case KeyEvent.VK_U:
                    azul2 = pressed;
                    break;
                case KeyEvent.VK_I:
                    naranja2 = pressed;
                    break;
            }
        }

        public void evento(int keyCode) { // en esta parte vemos si hay un evento de teclado y por 
            if (!pausa) { // lo tanto se eliminara el nodo correspondiente solo si existe un evento.
                Nodo aux;
                Nodo aux4 = null;
                Nodo aux3 = null;
                int tiempo = 0; // tiempo actual de la cancion en milisegundos
                float yAuxiliar = 0;//posicion en y auxiliar
                for (int i = 0; i < notas.tamaño; i++) {
                    yAuxiliar = 0;// variable usada para colocar a cada uno de los nodos tipo Lista
                    // su respectiva "y" correspondiente a la formula usada
                    aux = notas.indexOf(i); // se guarda las notas en un nodo auxiliar
                    tiempo = musica.getPosition(); // aqui se guarda el tiempo
                    if (aux.tiempo - 1500 <= (musica.getPosition())) { // formula usada para que recorra
                        // la nota desde la pantalla superior hasta el fret en 2 segundos
                        yAuxiliar = 250 + (tiempo - aux.tiempo + 1500) * vExpert; // aqui se guarda la y
                        // correspondiente a la formula usada
                        aux.y = Math.round(yAuxiliar);
                    }
                    if (acertar(aux, keyCode) && aux.duracion == 0) { // se verifica si se acerto la nota, se elimina el nodo
                        Nodo aux2;
                        aux3 = aux;
                        notas.deleteSel(i);
                        for (int j = 0; j < notas.tamaño; j++) {
                            aux2 = notas.indexOf(j);
                            if (aux2 != null) {
                                aux2.index = j;
                            }
                        }
                        for (int j = 0; j < 5; j++) {
                            if (ac[j] != 0) {
                                ac[j]--;
                            }
                        }
                        color[aux.color - 1] = aux.color;
                        time[aux.color - 1] = musica.getMicroPosition();
                        puntaje += (5 * multiplicador);
                        notasCons++;
                        notasAcertadas++;
                        if (acumulador < 60) {
                            acumulador++;
                        }
                        if (notasCons % 10 == 0 && multiplicador < 4) {
                            multiplicador++;
                        }
                    }
                    if (acertar(aux, keyCode) && aux.duracion != 0) {
                        aux3 = aux;
                        color[aux.color - 1] = aux.color;
                        time[aux.color - 1] = musica.getMicroPosition() + aux.duracion * 1000;
                        time2[aux.color - 1] = musica.getPosition();
                        acerto[aux.color - 1] = true;
                        ac[aux.color - 1] = aux.index;
                        aux.pintar = false;
                        puntaje += (5 * multiplicador);
                        notasCons++;
                        notasAcertadas++;
                        if (acumulador < 60) {
                            acumulador++;
                        }
                        if (notasCons % 10 == 0 && multiplicador < 4) {
                            multiplicador++;
                        }
                    }
                }
                if (aux3 == null && (keyCode == keyGreen || keyCode == keyRed || keyCode == keyYellow || keyCode == keyBlue || keyCode == keyOrange) && !pausa) {
                    if (notasCons > comboMaximo) {
                        comboMaximo = notasCons;
                    }
                    notasCons = 0;
                    multiplicador = 1;
                    if (acumulador > 0) {
                        acumulador -= 2;
                    }
                    if (acumulador <= 0) {
                        pierde=true;
                        acumulador = 0;
                    }

                }
                /*if (multiplayer) {
                    tiempo = 0; // tiempo actual de la cancion en milisegundos
                    yAuxiliar = 0;//posicion en y auxiliar
                    for (int i = 0; i < notas2.tamaño; i++) {
                        yAuxiliar = 0;// variable usada para colocar a cada uno de los nodos tipo Lista
                        // su respectiva "y" correspondiente a la formula usada
                        aux = notas2.indexOf(i); // se guarda las notas en un nodo auxiliar
                        tiempo = musica.getPosition(); // aqui se guarda el tiempo
                        if (aux.tiempo - 1500 <= (musica.getPosition())) { // formula usada para que recorra
                            // la nota desde la pantalla superior hasta el fret en 2 segundos
                            yAuxiliar = 250 + (tiempo - aux.tiempo + 1500) * vExpert; // aqui se guarda la y
                            // correspondiente a la formula usada
                            aux.y = Math.round(yAuxiliar);
                        }
                        if (acertar2(aux, keyCode) && aux.duracion == 0) { // se verifica si se acerto la nota, se elimina el nodo

                            Nodo aux2;
                            aux4 = aux;
                            notas2.deleteSel(i);
                            for (int j = 0; j < notas2.tamaño; j++) {
                                aux2 = notas2.indexOf(j);
                                if (aux2 != null) {
                                    aux2.index = j;
                                }
                            }
                            for (int j = 0; j < 5; j++) {
                                if (ac2[j] != 0) {
                                    ac2[j]--;
                                }
                            }
                            color2[aux.color - 1] = aux.color;
                            time3[aux.color - 1] = musica.getMicroPosition();
                            puntaje2 += (5 * multiplicador2);
                            notasCons2++;
                            notasAcertadas2++;
                            if (acumulador2 < 60) {
                                acumulador2++;
                            }
                            if (notasCons2 % 10 == 0 && multiplicador2 < 4) {
                                multiplicador2++;
                            }
                        }
                        if (acertar2(aux, keyCode) && aux.duracion != 0) {
                            aux4 = aux;
                            color2[aux.color - 1] = aux.color;
                            time3[aux.color - 1] = musica.getMicroPosition() + aux.duracion * 1000;
                            time4[aux.color - 1] = musica.getPosition();
                            acerto2[aux.color - 1] = true;
                            ac2[aux.color - 1] = aux.index;
                            aux.pintar = false;
                            puntaje2 += (5 * multiplicador);
                            notasCons2++;
                            notasAcertadas2++;
                            if (acumulador2 < 60) {
                                acumulador2++;
                            }
                            if (notasCons2 % 10 == 0 && multiplicador2 < 4) {
                                multiplicador2++;
                            }
                        }
                    }
                    if (aux4 == null && (keyCode == keyGreen2 || keyCode == keyRed2 || keyCode == keyYellow2 || keyCode == keyBlue2 || keyCode == keyOrange2) && !pausa) {
                        if (notasCons2 > comboMaximo2) {
                            comboMaximo2 = notasCons2;
                        }
                        notasCons2 = 0;
                        multiplicador2 = 1;
                        if (acumulador2 > 0) {
                            acumulador2 -= 2;
                        }
                        if (acumulador2 <= 0) {
                            //pierde = true;
                            acumulador2 = 0;
                        }
                    }
                    band2[getIndexColor(keyCode)] = true;
                }*/
                if ((keyCode == keyGreen || keyCode == keyRed || keyCode == keyYellow || keyCode == keyBlue || keyCode == keyOrange) && !pausa) {
                    band[keyCode - 65] = true;
                }

            }
        }

        public void evento2(int keyCode) {
            int tiempo;
            float yAuxiliar;
            Nodo aux, aux4 = null;
            tiempo = 0; // tiempo actual de la cancion en milisegundos
            yAuxiliar = 0;//posicion en y auxiliar
            for (int i = 0; i < notas2.tamaño; i++) {
                yAuxiliar = 0;// variable usada para colocar a cada uno de los nodos tipo Lista
                // su respectiva "y" correspondiente a la formula usada
                aux = notas2.indexOf(i); // se guarda las notas en un nodo auxiliar
                tiempo = musica.getPosition(); // aqui se guarda el tiempo
                if (aux.tiempo - 1500 <= (musica.getPosition())) { // formula usada para que recorra
                    // la nota desde la pantalla superior hasta el fret en 2 segundos
                    yAuxiliar = 250 + (tiempo - aux.tiempo + 1500) * vExpert; // aqui se guarda la y
                    // correspondiente a la formula usada
                    aux.y = Math.round(yAuxiliar);
                }
                if (acertar2(aux, keyCode) && aux.duracion == 0) { // se verifica si se acerto la nota, se elimina el nodo para el jugador 2
                    Nodo aux2;
                    aux4 = aux;
                    notas2.deleteSel(i);
                    for (int j = 0; j < notas2.tamaño; j++) {
                        aux2 = notas2.indexOf(j);
                        if (aux2 != null) {
                            aux2.index = j;
                        }
                    }
                    for (int j = 0; j < 5; j++) {
                        if (ac2[j] != 0) {
                            ac2[j]--;
                        }
                    }
                    color2[aux.color - 1] = aux.color;
                    time3[aux.color - 1] = musica.getMicroPosition();
                    puntaje2 += (5 * multiplicador2);
                    notasCons2++;
                    notasAcertadas2++;
                    if (acumulador2 < 60) {
                        acumulador2++;
                    }
                    if (notasCons2 % 10 == 0 && multiplicador2 < 4) {
                        multiplicador2++;
                    }
                }
                if (acertar2(aux, keyCode) && aux.duracion != 0) { // es por ci tiene duracion la nota
                    aux4 = aux;
                    color2[aux.color - 1] = aux.color;
                    time3[aux.color - 1] = musica.getMicroPosition() + aux.duracion * 1000;
                    time4[aux.color - 1] = musica.getPosition();
                    acerto2[aux.color - 1] = true;
                    ac2[aux.color - 1] = aux.index;
                    aux.pintar = false;
                    puntaje2 += (5 * multiplicador);
                    notasCons2++;
                    notasAcertadas2++;
                    if (acumulador2 < 60) {
                        acumulador2++;
                    }
                    if (notasCons2 % 10 == 0 && multiplicador2 < 4) {
                        multiplicador2++;
                    }
                }
            }
            if (aux4 == null && (keyCode == keyGreen2 || keyCode == keyRed2 || keyCode == keyYellow2 || keyCode == keyBlue2 || keyCode == keyOrange2) && !pausa) {
                if (notasCons2 > comboMaximo2) {
                    comboMaximo2 = notasCons2;
                }
                notasCons2 = 0;
                multiplicador2 = 1;
                if (acumulador2 > 0) {
                    acumulador2 -= 2;
                }
                if (acumulador2 <= 0) {
                    //pierde = true;
                    acumulador2 = 0;
                }
            }
            band3[getIndexColor(keyCode)] = true;
        }
    }

    public void guardar(String nombre) throws IOException {
        Nodo aux;
        for (int i = 0; i < listaEditor.tamaño; i++) {
            aux = listaEditor.indexOf(i);
            aux.index = i;
        }
        FileManager aEditor = new FileManager("/" + new File("resources/J_notas/" + nombre + ".txt").getAbsolutePath()); // creamos el archivo 
        aEditor.crear(listaEditor); // utilizamos la lista para que te cree el archivo
        aEditor = new FileManager("/" + new File("resources/setlist/lista.txt").getAbsolutePath());
        System.out.println("Guardar: " + aEditor.nArchivo);
        if (aEditor.busca(nombre) == false) { // busca el nombre para que solo lo añada a nuestro setlist si no esta
            aEditor.añadir(nombre, ruta);
        }
        JOptionPane.showMessageDialog(null, "Archivo Guardado"); // muestar un dialogo en pantalla 

    }

    public void tiempoTranscurrido(int a) {
        tiempoNuevo = musica.getMicroPosition();
        if (tiempoNuevo - time[a] > TMAX) {
            time[a] = 0;
            for (int i = 0; i <= 4; i++) {
                color[i] = 0;
            }
            acerto[a] = false;
        }
    }

    public void sumandoPuntaje(int a) { // utilizamos la funcion para que sume puntaje en las notas con duracion cada 300 ms
        tiempoNuevo = musica.getPosition();
        if (time2[a] != 0) {
            if (tiempoNuevo - time2[a] > 300 && tiempoNuevo - time2[a] < 400) {
                puntaje += (1 * multiplicador);
                time2[a] = tiempoNuevo;
            }
            if (tiempoNuevo - time2[a] > 400) {
                puntaje += (1 * multiplicador);
                time2[a] = tiempoNuevo;
            }
        }
    }

    public void tiempoTranscurrido2(int a) {
        tiempoNuevo = musica.getMicroPosition();
        if (tiempoNuevo - time3[a] > TMAX) {
            time3[a] = 0;
            for (int i = 0; i <= 4; i++) {
                color2[i] = 0;
            }
            acerto2[a] = false;
        }
    }

    public void sumandoPuntaje2(int a) {
        tiempoNuevo = musica.getPosition();
        if (time4[a] != 0) {
            if (tiempoNuevo - time4[a] > 300 && tiempoNuevo - time4[a] < 400) {
                puntaje2 += (1 * multiplicador2);
                time4[a] = tiempoNuevo;
            }
            if (tiempoNuevo - time4[a] > 400) {
                puntaje2 += (1 * multiplicador2);
                time4[a] = tiempoNuevo;
            }
        }
    }

    public void reiniciaStats() {
        System.out.println("Reiniciaro stats");
        juego = true;
        pierde = cargar = pausa = gana = sp = teclado = guitarra = false;
        puntaje = 0;
        comboMaximo = 0;
        puntaje2 = 0;
        comboMaximo2 = 0;
        acumulador = 30;
        acumulador2 = 30;
        yFlecha = 40;
        xPerdiste = 310;
        yPerdiste = 400;
        yFlecha_pausa = 380;
        yFlecha_setlist = 150;
        yFlecha_gana = 350;
        inicioLista = 0;
        indexsong = 1;
        notasCons = 0;
        notasCons2 = 0;
        notasAcertadas = 0;
        notasAcertadas2 = 0;
        for (int i = 0; i < 4; i++) {
            color[i] = 0;
            time[i] = 0;
            time2[i] = 0;
            time3[i] = 0;
            time4[i] = 0;
            ac[i] = 0;
            acerto[i] = false;
            acerto2[i] = false;
            elimina[i] = false;
        }
    }

    public void borraLista() {
        notas.deleteAll();
        notas2.deleteAll();
        listaEditor.deleteAll();
    }

    public Nodo añadeListaEditor(int color) { // se van añadiendo los nodos mientras se manipula el editor
        Nodo aux = listaEditor.buscaNodoAnt(musicaEditor.getPosition());
        Nodo aux2 = null;
        Nodo aux3 = null;
        if (aux != null) {
            aux2 = listaEditor.indexOf(listaEditor.tamaño - 1);
            if (aux.tiempo >= aux2.tiempo) {
                aux3 = listaEditor.addLast(color, musicaEditor.getPosition(), 0, -I_ALTO, 0);
            } else {
                aux3 = listaEditor.addNext(aux, color, musicaEditor.getPosition(), 0, -I_ALTO, 0);
            }
        } else {
            aux3 = listaEditor.addLast(color, musicaEditor.getPosition(), 0, -I_ALTO, 0);
        }
        return aux3;
    }

}
