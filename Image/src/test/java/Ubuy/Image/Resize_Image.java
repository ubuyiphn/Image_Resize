package Ubuy.Image;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Resize_Image 
{
	public static String inputImagePath = System.getProperty("user.dir")+"/logo-ubuy.jpg";
	public static String output_image_fixed_size = System.getProperty("user.dir")+"/output_image_fixed_size.png";
	public static String output_image_percentage = System.getProperty("user.dir")+"/output_image_percentage.png";
	public static int scalewidth = 250;
	public static int scaleheight = 250;
	public static double percent = 0.5;
    
	public static void main(String[] args) 
	{
		try
		
        {
        	Resize_Image.resize(inputImagePath, output_image_fixed_size, scalewidth, scaleheight);
        	
            Resize_Image.resize(inputImagePath, output_image_percentage, percent);
            
        }
		
        catch (IOException ex)
		
        {
        	
            System.out.println("Error resizing the image.");
            
            ex.printStackTrace();
            
        }
		
    } 
	
	
	public static void resize(String inputImagePatht,String outputImagePatht,int scaledWidtht,int scaledHeightt)throws IOException
	
	{   
		   
		File inputFile = new File(inputImagePath);
	        
	    BufferedImage inputImage = ImageIO.read(inputFile);
	      
	    BufferedImage outputImage = new BufferedImage(500,500,inputImage.getType());
	      
	    Graphics2D g2d = outputImage.createGraphics();
	        
	    g2d.drawImage(inputImage,0,0,500,500,null);
	        
	    g2d.dispose();
	        
	    ImageIO.write(outputImage, "png", new File(outputImagePatht));
	        
	}
	
	public static void resize(String inputImagePatht,String outputImagePatht, double percent) throws IOException
	
	{
		
	    File inputFile = new File(inputImagePath);
	    
	    BufferedImage inputImage = ImageIO.read(inputFile);
	    
	    int scaledWidtht = (int) (inputImage.getWidth() * percent);
	    
	    int scaledHeightt = (int) (inputImage.getHeight() * percent);
	    
	    resize(inputImagePatht, outputImagePatht, scaledWidtht, scaledHeightt);
	    
	}
	    
}
