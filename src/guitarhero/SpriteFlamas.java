package guitarhero;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class SpriteFlamas {
    private Point posicion;
    private BufferedImage image;
    private int frame = 0;
    private int width;
    private int height;
    private int tw;
    int th;
    
    public SpriteFlamas(String spriteName, int spriteWidth, int spriteHeight){
        posicion = new Point();
        try{
            image = ImageIO.read(getClass().getResourceAsStream(spriteName));
            width = spriteWidth;
            height =  spriteHeight;
            tw = image.getWidth() / width;
            th = image.getHeight() / height;
        }
        catch (IOException ex) {}
    }
    
    public void setFrame(int index){
        frame = index;
    }
    
    public void pintar(Graphics g){
        int x = posicion.x;
        int y = posicion.y;
        
        int i = frame % tw;
        int j = frame / tw;
        
        g.drawImage(image, x, y, x + width, y + height, i * width, j * height, (i+1) * width, (j+1) * height, null);
    }
        
    public void setPosicion(int x, int y){
        posicion.setLocation(x, y);
    }
    
    public int getWidth(){
        return width;
    }
    
    public int getHeight(){
        return height;
    }
}
