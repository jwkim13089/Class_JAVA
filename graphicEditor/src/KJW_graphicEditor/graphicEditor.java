package KJW_graphicEditor;

import java.awt.BorderLayout;
//import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;




public class graphicEditor extends JFrame implements ActionListener {
	public JPanel colormonitorPanel;
	public JLabel label;
	public JLabel label2;
	MyPanel canvas;
	private JButton buttonLINE;
	private JButton buttonRECT;
	private JButton buttonOVAL;
	private JButton buttonTRIA;
	private JButton buttonBRUSH;
	private JButton buttonPen;
	private JButton buttonIMG;
	private JButton buttonERAS;
	private JButton buttonRESET;
	public static String draw = "NULL";
	public static String restart = "NULL";
	private JButton buttonRED;
	private JButton buttonORANGE;
	private JButton buttonYELLOW;
	private JButton buttonGREEN;
	private JButton buttonBLUE;
	private JButton buttonMAGENTA;
	private JButton buttonBLACK;
	private JButton buttonDARKGRAY;
	private JButton ButtonGRAY;
	private JButton ButtonLIGHTGRAY;
	private JButton ButtonWHITE;
	private JButton ButtonPINK;
	public static String colorname = "BLACK";
	public static Color color/* = Color.BLACK*/ ;
	public static String imagefile;
	public static String fileNameIMG;
	public static String IMGFile;
	public static String monitor;
	private JSlider sliderSIZE;
	public static int linesize;
	//public static Color monitorcolor;
	JFileChooser fc;
	public String lineIMG;
	public String rectIMG;
	public String ovalIMG;
	public String triaIMG;
	public String brushIMG;
	public String penIMG;
	public String textIMG;
	public String imgIMG;
	public String erasIMG;

	public graphicEditor() {
		
		setSize(1100, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("PAINT");
		fc = new JFileChooser();
		
		lineIMG = "./icon/직선.PNG";
		rectIMG = "./icon/사각형.PNG";
		ovalIMG = "./icon/원.PNG";
		triaIMG = "./icon/삼각형.PNG";
		brushIMG = "./icon/붓.PNG";
		penIMG = "./icon/연필.PNG";
		imgIMG = "./icon/이미지.PNG";
		erasIMG = "./icon/지우개.PNG";
		

//		//rectIMG
//		try {
//			triaIMG = "C:\\Users\\spark\\Desktop\\삼각형.PNG";
//		}
//		catch(Exception e) {
//			triaIMG = "D:\\한남대\\2학년 2학기\\정보통신공학과\\자바프로그래밍\\자바 그림판\\KJW\\삼각형.PNG";
//		}
//		//brushIMG
//		try {
//			brushIMG = "C:\\Users\\spark\\Desktop\\붓.PNG";
//		}
//		catch(Exception e) {
//			brushIMG = "D:\\한남대\\2학년 2학기\\정보통신공학과\\자바프로그래밍\\자바 그림판\\KJW\\붓.PNG";
//		}
//		//penIMG
//		try {
//			penIMG = "C:\\Users\\spark\\Desktop\\연필.PNG";
//		}
//		catch(Exception e) {
//			penIMG = "D:\\한남대\\2학년 2학기\\정보통신공학과\\자바프로그래밍\\자바 그림판\\KJW\\연필.PNG";
//		}
//		//imgIMG
//		try {
//			imgIMG = "C:\\Users\\spark\\Desktop\\이미지.PNG";
//		}
//		catch(Exception e) {
//			imgIMG = "D:\\한남대\\2학년 2학기\\정보통신공학과\\자바프로그래밍\\자바 그림판\\KJW\\이미지.PNG";
//		}
//		//erasIMG
//		try {
//			erasIMG = "C:\\Users\\spark\\Desktop\\지우개.PNG";
//		}
//		catch(Exception e) {
//			erasIMG = "D:\\한남대\\2학년 2학기\\정보통신공학과\\자바프로그래밍\\자바 그림판\\KJW\\지우개.PNG";
//		}
//		
		//toolboxPanel - shapePanel, resetPanel
		JPanel toolboxPanel = new JPanel();
		toolboxPanel.setBackground(Color.lightGray);
        toolboxPanel.setLayout(new BorderLayout());
        toolboxPanel.setPreferredSize(new Dimension(100, 80));
        add(toolboxPanel, BorderLayout.NORTH);
        
        JPanel shapePanel = new JPanel();
        shapePanel.setBackground(Color.lightGray);
        shapePanel.setLayout(new FlowLayout(40,15,15));
        shapePanel.setPreferredSize(new Dimension(950, 80));
        toolboxPanel.add(shapePanel,BorderLayout.WEST);
        /////button추가/////
        
        ////직선
        ImageIcon iconLINE = new ImageIcon(lineIMG);
        buttonLINE = new JButton(iconLINE);
        buttonLINE.setPreferredSize(new Dimension(50,50));
        buttonLINE.addActionListener(new ToolListener());
        shapePanel.add(buttonLINE);
        ////사각형
        ImageIcon iconRECT = new ImageIcon(rectIMG);
        buttonRECT = new JButton(iconRECT);
        buttonRECT.setPreferredSize(new Dimension(50,50));
        buttonRECT.addActionListener(new ToolListener());
        shapePanel.add(buttonRECT);
        ////원
        ImageIcon iconOVAL = new ImageIcon(ovalIMG);
        buttonOVAL = new JButton(iconOVAL);
        buttonOVAL.setPreferredSize(new Dimension(50,50));
        buttonOVAL.addActionListener(new ToolListener());
        shapePanel.add(buttonOVAL);
        ////삼각형
        ImageIcon iconTRIA = new ImageIcon(triaIMG);
        buttonTRIA = new JButton(iconTRIA);
        buttonTRIA.setPreferredSize(new Dimension(50,50));
        buttonTRIA.addActionListener(new ToolListener());
        shapePanel.add(buttonTRIA);
        ////붓
        ImageIcon iconBRUSH = new ImageIcon(brushIMG);
        buttonBRUSH = new JButton(iconBRUSH);
        buttonBRUSH.setPreferredSize(new Dimension(50,50));
        buttonBRUSH.addActionListener(new ToolListener());
        shapePanel.add(buttonBRUSH);
        ////연필
        ImageIcon iconPEN = new ImageIcon(penIMG);
        buttonPen = new JButton(iconPEN);
        buttonPen.setPreferredSize(new Dimension(50,50));
        buttonPen.addActionListener(new ToolListener());
        shapePanel.add(buttonPen);
        ////이미지
        ImageIcon iconIMG = new ImageIcon(imgIMG);
        buttonIMG = new JButton(iconIMG);
        buttonIMG.setPreferredSize(new Dimension(50,50));
        buttonIMG.addActionListener(new ToolListener());
//        buttonIMG.addActionListener(new ActionListener() {
//
//            public void actionPerformed(ActionEvent e) {
//
//                new bringIMG(); 
//            }
//        });
        shapePanel.add(buttonIMG);
        ////지우개
        ImageIcon iconERAS = new ImageIcon(erasIMG);
        buttonERAS = new JButton(iconERAS);
        buttonERAS.setPreferredSize(new Dimension(50,50));
        buttonERAS.addActionListener(new ToolListener());
        shapePanel.add(buttonERAS);
        
        JPanel resetPanel = new JPanel();
        resetPanel.setBackground(Color.lightGray);
        resetPanel.setLayout(new FlowLayout(40,15,25));
        resetPanel.setPreferredSize(new Dimension(100,80));
        toolboxPanel.add(resetPanel,BorderLayout.EAST);
        /////button추가/////
        buttonRESET = new JButton("RESET");
        buttonRESET.setBackground(Color.red);
        buttonRESET.addActionListener(new ToolListener());
        resetPanel.add(buttonRESET);
        
        //detailPanel - leftPanel(colorPanel,colormonitorPanel), rightPanel(sizePanel,sizemonitorPanel)
        JPanel detailPanel = new JPanel();
        detailPanel.setLayout(new BorderLayout());
        detailPanel.setPreferredSize(new Dimension(100, 100));
        add(detailPanel, BorderLayout.SOUTH);
       
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BorderLayout());
        leftPanel.setPreferredSize(new Dimension(530, 80));
        detailPanel.add(leftPanel,BorderLayout.WEST);
        
        JPanel colorPanel = new JPanel();
        colorPanel.setLayout(new GridLayout(0,6));
        colorPanel.setPreferredSize(new Dimension(400, 80));
        leftPanel.add(colorPanel,BorderLayout.WEST);
        /////button추가/////
        ////RED 색상
        buttonRED = new JButton();
        buttonRED.setBackground(Color.RED);
        buttonRED.addActionListener(new ColorListener());
        colorPanel.add(buttonRED);
        ////ORANGE 색상
        buttonORANGE = new JButton();
        buttonORANGE.setBackground(Color.ORANGE);
        buttonORANGE.addActionListener(new ColorListener());
        colorPanel.add(buttonORANGE);
        ////YELLOW 색상
        buttonYELLOW = new JButton();
        buttonYELLOW.setBackground(Color.YELLOW);
        buttonYELLOW.addActionListener(new ColorListener());
        colorPanel.add(buttonYELLOW);
        ////GREEN 색상
        buttonGREEN = new JButton();
        buttonGREEN.setBackground(Color.GREEN);
        buttonGREEN.addActionListener(new ColorListener());
        colorPanel.add(buttonGREEN);
        ////BLUE 색상
        buttonBLUE = new JButton();
        buttonBLUE.setBackground(Color.BLUE);
        buttonBLUE.addActionListener(new ColorListener());
        colorPanel.add(buttonBLUE);
        ////MAGENTA 색상
        buttonMAGENTA = new JButton();
        buttonMAGENTA.setBackground(Color.MAGENTA);
        buttonMAGENTA.addActionListener(new ColorListener());
        colorPanel.add(buttonMAGENTA);
        ////BLACK 색상
        buttonBLACK = new JButton();
        buttonBLACK.setBackground(Color.BLACK);
        buttonBLACK.addActionListener(new ColorListener());
        colorPanel.add(buttonBLACK);
        ////DARKGRAY 색상
        buttonDARKGRAY = new JButton();
        buttonDARKGRAY.setBackground(Color.darkGray);
        buttonDARKGRAY.addActionListener(new ColorListener());
        colorPanel.add(buttonDARKGRAY);
        ////GRAY 색상
        ButtonGRAY = new JButton();
        ButtonGRAY.setBackground(Color.GRAY);
        ButtonGRAY.addActionListener(new ColorListener());
        colorPanel.add(ButtonGRAY);
        ////LIGHTGRAY 색상
        ButtonLIGHTGRAY = new JButton();
        ButtonLIGHTGRAY.setBackground(Color.lightGray);
        ButtonLIGHTGRAY.addActionListener(new ColorListener());
        colorPanel.add(ButtonLIGHTGRAY);
        ////WHITE 색상
        ButtonWHITE = new JButton();
        ButtonWHITE.setBackground(Color.WHITE);
        ButtonWHITE.addActionListener(new ColorListener());
        colorPanel.add(ButtonWHITE);
        ////PINK 색상
        ButtonPINK = new JButton();
        ButtonPINK.setBackground(Color.PINK);
        ButtonPINK.addActionListener(new ColorListener());
        colorPanel.add(ButtonPINK);
        
        colormonitorPanel = new JPanel();
        colormonitorPanel.setBackground(Color.BLACK);
        colormonitorPanel.setLayout(new GridLayout(0,1));
        colormonitorPanel.setPreferredSize(new Dimension(110, 80));
        leftPanel.add(colormonitorPanel,BorderLayout.EAST);
    	label = new JLabel(new ImageIcon(monitor));
        colormonitorPanel.add(label);
 
        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new BorderLayout());
        rightPanel.setPreferredSize(new Dimension(530, 80));
        detailPanel.add(rightPanel,BorderLayout.EAST);
        
        JPanel sizePanel = new JPanel();
        sizePanel.setLayout(new BorderLayout());
        sizePanel.setBackground(Color.BLACK);
        sizePanel.setPreferredSize(new Dimension(400, 80));
        rightPanel.add(sizePanel,BorderLayout.WEST);
        /////slider 추가 /////
        sliderSIZE = new JSlider(0,20,0);
        sliderSIZE.setMajorTickSpacing(1);
        sliderSIZE.setPaintTicks(true);
        sliderSIZE.setPaintLabels(true);
        sliderSIZE.addChangeListener(new sizeChanged());
        sizePanel.add(sliderSIZE);
        //***********************************************************************************************
        JPanel sizemonitorPanel = new JPanel();
        sizemonitorPanel.setBackground(Color.BLACK);
        sizemonitorPanel.setLayout(new GridLayout(0,1));
        sizemonitorPanel.setPreferredSize(new Dimension(110, 80));
        rightPanel.add(sizemonitorPanel,BorderLayout.EAST);
        label2 = new JLabel(new ImageIcon(monitor));
        sizemonitorPanel.add(label2);
        
        
        MyPanel canvas = new MyPanel();
        canvas.setBackground(Color.WHITE);
        add(canvas, BorderLayout.CENTER);
		setVisible(true);
		
	}

	//private class ToolListener implements ActionListener {
	public class ToolListener implements ActionListener {
		MyPanel canvas= new MyPanel();
		
		//graphicEditor gp = new graphicEditor();
		
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == buttonLINE) {
				draw = "LINE";
				monitor = lineIMG;
				label.setIcon(new ImageIcon(monitor));
				label2.setIcon(new ImageIcon(monitor));
				//gp.label.setIcon(new ImageIcon(monitor));
				
			}
			else if(e.getSource() == buttonRECT) {
				draw = "RECT";
				monitor = rectIMG;
				label.setIcon(new ImageIcon(monitor));
				label2.setIcon(new ImageIcon(monitor));
				
			}
			else if(e.getSource() == buttonOVAL) {
				draw = "OVAL";
				monitor = ovalIMG;
				label.setIcon(new ImageIcon(monitor));
				label2.setIcon(new ImageIcon(monitor));
				
			}
			else if(e.getSource() == buttonTRIA) {
				draw = "TRIA";
				monitor = triaIMG;
				label.setIcon(new ImageIcon(monitor));
				label2.setIcon(new ImageIcon(monitor));
			}
			else if(e.getSource() == buttonBRUSH) {
				draw = "BRUSH";
				monitor = brushIMG;
				label.setIcon(new ImageIcon(monitor));
				label2.setIcon(new ImageIcon(monitor));
			}
			else if(e.getSource() == buttonPen) {
				draw = "PEN";
				monitor = penIMG;
				label.setIcon(new ImageIcon(monitor));
				label2.setIcon(new ImageIcon(monitor));
			}
			else if(e.getSource() == buttonIMG) {
				draw = "IMG";
				monitor = imgIMG;
				label.setIcon(new ImageIcon(monitor));
				label2.setIcon(new ImageIcon(monitor));
				int returnVal = fc.showSaveDialog(null);
				if(returnVal == JFileChooser.APPROVE_OPTION ) {
					File file = fc.getSelectedFile();
					IMGFile = (file).toString();
					
				}
			}
			else if(e.getSource() == buttonERAS) {
				draw = "ERAS";
				monitor = erasIMG;
				label2.setIcon(new ImageIcon(monitor));
				label.setIcon(new ImageIcon(monitor));
			}
			else if(e.getSource() == buttonRESET) {
				restart = "RESET";
				monitor = "null";
				label.setIcon(new ImageIcon(monitor));
				label2.setIcon(new ImageIcon(monitor));
				/*System.out.println(canvas.toolList);
				System.out.println(canvas.freelineList);
				System.out.println(canvas.eraseList);
				canvas.toolList.clear();
				canvas.freelineList.clear();
				canvas.eraseList.clear();
				canvas.restart*/
				//draw = "reset;
				//canvas.resetPaint();
			}
			else {
				draw = "NULL";
			}
		}
	}
	
	public class ColorListener implements ActionListener {
		MyPanel canvas = new MyPanel();
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == buttonRED) {
//				System.out.println("R");
				color = Color.RED;
				colorname = "RED";
				//monitorcolor = Color.RED;
				colormonitorPanel.setBackground(Color.RED);
			}
			else if(e.getSource() == buttonORANGE) {
//				System.out.println("O");
				color = Color.ORANGE;
				colorname = "ORANGE";
				//monitorcolor = Color.ORANGE;
				colormonitorPanel.setBackground(Color.ORANGE);
			}
			else if(e.getSource() == buttonYELLOW) {
//				System.out.println("Y");
				color = Color.YELLOW;
				colorname = "YELLOW";
				//monitorcolor = Color.YELLOW;
				colormonitorPanel.setBackground(Color.YELLOW);
			}
			else if(e.getSource() == buttonGREEN) {
//				System.out.println("G");
				color = Color.GREEN;
				colorname = "GREEN";
				//monitorcolor = Color.GREEN;
				colormonitorPanel.setBackground(Color.GREEN);
			}
			else if(e.getSource() == buttonBLUE) {
//				System.out.println("B");
				color = Color.BLUE;
				colorname = "BLUE";
				//monitorcolor = Color.BLUE;
				colormonitorPanel.setBackground(Color.BLUE);
			}
			else if(e.getSource() == buttonMAGENTA) {
//				System.out.println("M");
				color = Color.MAGENTA;
				colorname = "MAGENTA";
				//monitorcolor = Color.MAGENTA;
				colormonitorPanel.setBackground(Color.MAGENTA);
			}
			else if(e.getSource() == buttonBLACK) {
//				System.out.println("B");
				color = Color.BLACK;
				colorname = "BLACK";
				//monitorcolor = Color.BLACK;
				colormonitorPanel.setBackground(Color.BLACK);
			}
			else if(e.getSource() == buttonDARKGRAY) {
//				System.out.println("D");
				color = Color.darkGray;
				colorname = "darkGray";
				//monitorcolor = Color.darkGray;
				colormonitorPanel.setBackground(Color.darkGray);
			}
			else if(e.getSource() == ButtonGRAY) {
//				System.out.println("G");
				color = Color.GRAY;
				colorname = "GRAY";
				//monitorcolor = Color.GRAY;
				colormonitorPanel.setBackground(Color.GRAY);
			}
			else if(e.getSource() == ButtonLIGHTGRAY) {
//				System.out.println("L");
				color = Color.lightGray;
				colorname = "lightGray";
				//monitorcolor = Color.lightGray;
				colormonitorPanel.setBackground(Color.lightGray);
			}
			else if(e.getSource() == ButtonWHITE) {
//				System.out.println("W");
				color = Color.WHITE;
				colorname = "WHITE";
				//monitorcolor = Color.WHITE;
				colormonitorPanel.setBackground(Color.WHITE);
			}
			else if(e.getSource() == ButtonPINK) {
//				System.out.println("P");
				color = Color.PINK;
				colorname = "PINK";
				//monitorcolor = Color.PINK;
				colormonitorPanel.setBackground(Color.PINK);
			}
		}
	}

			
	public class sizeChanged implements ChangeListener {

		@Override
		public void stateChanged(ChangeEvent e) {
			//MyPanel canvas= new MyPanel();

			JSlider source = (JSlider) e.getSource();
			if(!source.getValueIsAdjusting() ) {
				linesize = (int)source.getValue();
			}
			
		}
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
	}


	


}
