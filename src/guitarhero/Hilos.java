package guitarhero;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Hilos extends Thread{
    /*SerialPort serialPort = new SerialPort();
    java.util.List<String> portsFree = serialPort.getFreeSerialPort();
    Com com1;*/
    String datoPuerto;
    
    //Hilos() throws Exception{
        /*super();
        datoPuerto = "0";
        if(portsFree.size()>0){
            Parameters parametros = new Parameters();
            parametros.setPort(portsFree.get(0));
            parametros.setBaudRate(Baud._9600);
            parametros.setParity("N");
            parametros.setMinDelayWrite(200);
            com1 = new Com(parametros);
        }
        else
            System.err.println("Puerto serie no encontrado");
    }
    
    @Override
    public void run(){
        while(true){
            int data; 
            try {
                data=com1.receiveSingleCharAsInteger();
                data&=0x00FF;
                datoPuerto=Integer.toBinaryString(data);
            } catch (Exception ex) { 
            }
        }
    }*/
}
