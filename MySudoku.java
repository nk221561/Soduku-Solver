
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;


public class MySudoku 
{
	public static byte[][] sudoku = new byte[729][82];  
	public static byte step = 0; 
	
	private static final int WindowWidth = 790; 
	private static final int WindowHeight = 650;  
	
    public static void ShowGUI() 
	 {
    	    Smethods.start(sudoku); 
    	   
		    final byte border = 14;  
		    JFrame f = new JFrame("Sudoku v3.0");
	        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        BufferedImage image = null;
	            try {
					image = ImageIO.read(new File("sudoku.png"));
				} catch (IOException e) {
				}//end of try/catch
	        f.setResizable(false);  
	        f.setIconImage(image);
		    f.setSize(WindowWidth, WindowHeight);  
		    f.setLocation(0, 0); 
		    f.setLayout(new BorderLayout());  		   
		    
		    f.add(new SPanel(new Dimension(WindowWidth,border)),  BorderLayout.NORTH);
		    f.add(new SPanel(new Dimension(WindowWidth,border)),  BorderLayout.SOUTH);
		    f.add(new SPanel(new Dimension(border,WindowHeight)),   BorderLayout.EAST);
		    f.add(new SPanel(new Dimension(0,WindowHeight)),   BorderLayout.WEST);  

	        DisplayPanel dp =new  DisplayPanel();
	        dp.setBackground(Color.WHITE);  
	        f.add(dp, BorderLayout.CENTER); 
	      
	        f.setVisible(true);	
	 }//end of show gui method
		    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	ShowGUI(); 
            }			
        });  
    }
    
}

