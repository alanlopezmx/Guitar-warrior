/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alanl
 */
public class Servidor extends Thread{
    final int PUERTO = 2222;
    public ServerSocket sc;
    Socket so;
    DataOutputStream salida;
    String mensajeRecibido;
    
    public static final String VERDE = "65";
    public static final String ROJO = "83";
    public static final String AMARILLO = "74";
    public static final String AZUL = "75";
    public static final String NARANJA = "76";
    public static final String LEFT = "VK_LEFT";
    public static final String DOWN = "VK_DOWN";
    public static final String RIGHT = "VK_RIGHT";
    public static final String UP = "VK_UP";
    public static final String PAUSE = "80";
    public static final String ENTER = "VK_ENT";
    public volatile boolean running = true;
    
    public Servidor(){
        try {
            sc = new ServerSocket(PUERTO);
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        so = new Socket();
    }
    
    public void run(){
        initServer();
    }
    
    public void initServer() {
        BufferedReader entrada;
        while(running){
        try {
            //System.out.println("Esperando una conexión:");
            so = sc.accept();
            //System.out.println("Un cliente se ha conectado.");
            entrada = new BufferedReader(new InputStreamReader(so.getInputStream()));
            salida = new DataOutputStream(so.getOutputStream());
            mensajeRecibido = entrada.readLine();
            simulateKey(mensajeRecibido.trim());
            //System.out.println(mensajeRecibido.trim());
         
            //System.out.println("Cerrando conexión...");
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
            try {
                sc.close();
            } catch (IOException ex) {
                Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        }
    }
    private void simulateKey(String key) throws AWTException{
        Robot robot = new Robot();
        String keyString = key.split("-")[0];
        String motion = key.split("-")[1];
        int keyInt = 0;
        switch (keyString){
            case VERDE:
                if(guitarhero.GuitarHero.multiplayer)
                    keyInt = KeyEvent.VK_Q;
                else
                    keyInt = KeyEvent.VK_A;
                break;
            case ROJO:
                if(guitarhero.GuitarHero.multiplayer)
                    keyInt = KeyEvent.VK_W;
                else
                    keyInt = KeyEvent.VK_S;
                break;
            case AMARILLO:
                if(guitarhero.GuitarHero.multiplayer)
                    keyInt = KeyEvent.VK_Y;
                else
                    keyInt = KeyEvent.VK_Y;
                break;
            case AZUL:
                if(guitarhero.GuitarHero.multiplayer)
                    keyInt = KeyEvent.VK_U;
                else
                    keyInt = KeyEvent.VK_U;
                break;
            case NARANJA:
                if(guitarhero.GuitarHero.multiplayer)
                    keyInt = KeyEvent.VK_I;
                else
                    keyInt = KeyEvent.VK_I;
                break;
            case LEFT:
                keyInt = KeyEvent.VK_LEFT;
                break;
            case DOWN:
                keyInt = KeyEvent.VK_DOWN;
                break;
            case RIGHT:
                keyInt = KeyEvent.VK_RIGHT;
                break;
            case UP:
                keyInt = KeyEvent.VK_UP;
                break;
            case PAUSE:
                keyInt = KeyEvent.VK_P;
                break;
            case ENTER:
                keyInt = KeyEvent.VK_ENTER;
                break;
        }
        //System.out.println("Key: " + keyInt);
        if(keyInt != 0){
            if(motion.equals("r")){
                robot.keyRelease(keyInt);
            } else if(motion.equals("p")){
                robot.keyPress(keyInt);
            }
        }
    }
}