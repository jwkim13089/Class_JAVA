package KJW_graphicEditor;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;


//Tool 공통
class Tool {
//	int x, y, w, h;
//	int xpp[] ;
//	int ypp[] ;
//	Color color;
//	int linesize;
//	ImageIcon image;
	
	int x, y, w, h;
	int xpp[] ;
	int ypp[] ;
	Color colorck;
	BasicStroke linesizeck;
	ImageIcon image;
	int xpoints[];
	int ypoints[];
	int npoints;


//	public Tool(int x, int y, int w, int h, int[] xp, int[] yp, Color palette, int thick, ImageIcon imgfile) {
//		this.x = x;
//		this.y = y;
//		this.w = w;
//		this.h = h;
//		this.xpp = xp;
//		this.ypp = yp;
//		this.color = palette;
//		this.linesize = thick;
//		this.image = imgfile;
//
//	}
	public Tool(int x, int y, int w, int h, int[] xp, int[] yp, Color palette, BasicStroke thick, ImageIcon imgfile, int[] xfree, int[] yfree, int nfree) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.xpp = xp;
		this.ypp = yp;
		this.colorck = palette;
		this.linesizeck = thick;
		this.image = imgfile;
		this.xpoints = xfree;
		this.ypoints = yfree;
		this.npoints = nfree;

	}
	
	void draw(Graphics g) {}
	void draw2(Graphics2D g2) {}
}
	
//Line Button 클릭 시
class Line extends Tool {
	public Line(int x, int y, int w, int h, int xp[], int yp[], Color palette, BasicStroke thick, ImageIcon imgfile, int[] xfree, int[] yfree, int nfree) {
		super(x,y,w,h,xp,yp,palette,thick,imgfile,xfree,yfree,nfree);
	}
	void draw(Graphics g)
    {
        g.drawLine(x, y, x+w, y+h);
//        g2.setStroke(new BasicStroke(graphicEditor.linesize,BasicStroke.CAP_ROUND,0));
    }
	void draw2(Graphics2D g2) 
	{
		g2.setStroke(linesizeck);
		g2.setColor(colorck);
	}
}

//Rect Button 클릭 시
class Rect extends Tool {
	public Rect(int x, int y, int w, int h, int xp[], int yp[], Color palette, BasicStroke thick, ImageIcon imgfile, int[] xfree, int[] yfree, int nfree) {
		super(x,y,w,h,xp,yp,palette,thick,imgfile,xfree,yfree,nfree);
	}
	void draw(Graphics g)
    {
        g.drawRect(x, y, w, h);
    }
	void draw2(Graphics2D g2) 
	{
		g2.setStroke(linesizeck);
		g2.setColor(colorck);
	}
}

//Oval Button 클릭 시
class Oval extends Tool {
	public Oval(int x, int y, int w, int h, int xp[], int yp[], Color palette, BasicStroke thick, ImageIcon imgfile, int[] xfree, int[] yfree, int nfree) {
		super(x,y,w,h,xp,yp,palette,thick,imgfile,xfree,yfree,nfree);
	}
	void draw(Graphics g)
    {
        g.drawOval(x, y, w, h);
    }
	void draw2(Graphics2D g2) 
	{
		g2.setStroke(linesizeck);
		g2.setColor(colorck);
	}
}

//Tria Button 클릭 시
class Tria extends Tool {
	public Tria(int x, int y, int w, int h, int xp[], int yp[], Color palette, BasicStroke thick, ImageIcon imgfile, int[] xfree, int[] yfree, int nfree) {
		super(x,y,w,h,xp,yp,palette,thick,imgfile,xfree,yfree,nfree);
	}
	void draw(Graphics g)
    {
        g.drawPolygon(xpp,ypp,3);
    }
	void draw2(Graphics2D g2) 
	{
		g2.setStroke(linesizeck);
		g2.setColor(colorck);
		//g2.setStroke(linesizeck);
		//g2.setColor(colorck);
	}
}

//Brush Button 클릭 시
class Brush extends Tool {
	public Brush(int x, int y, int w, int h, int xp[], int yp[], Color palette, BasicStroke thick, ImageIcon imgfile, int[] xfree, int[] yfree, int nfree) {
		super(x,y,w,h,xp,yp,palette,thick,imgfile,xfree,yfree,nfree);
	}
	void draw(Graphics g)
    {
        g.drawPolyline(xpoints, ypoints, npoints);
    }
	void draw2(Graphics2D g2) 
	{
		g2.setStroke(linesizeck);
		g2.setColor(colorck);
	}
}

//Pen Button 클릭 시
class Pen extends Tool{
	public Pen(int x, int y, int w, int h, int xp[], int yp[], Color palette, BasicStroke thick, ImageIcon imgfile, int[] xfree, int[] yfree, int nfree) {
		super(x,y,w,h,xp,yp,palette,thick,imgfile,xfree,yfree,nfree);
	}
	void draw(Graphics g)
    {
		 g.drawPolyline(xpoints, ypoints, npoints);
    }
	void draw2(Graphics2D g2) 
	{
		g2.setStroke(linesizeck);
		g2.setColor(colorck);
	}
}

//Img Button 클릭 시
class Img extends Tool {
	public Img(int x, int y, int w, int h, int xp[], int yp[], Color palette, BasicStroke thick, ImageIcon imgfile, int[] xfree, int[] yfree, int nfree) {
		super(x,y,w,h,xp,yp,palette,thick,imgfile,xfree,yfree,nfree);
	}
	void draw(Graphics g)
    {
//		image = new ImageIcon((graphicEditor.IMGFile).toString());
	    g.drawImage(image.getImage(), x,y,w,h,null);
    }
	
}

//Eras Button 클릭 시
class Eras extends Tool{
	public Eras(int x, int y, int w, int h, int xp[], int yp[], Color palette, BasicStroke thick, ImageIcon imgfile, int[] xfree, int[] yfree, int nfree) {
		super(x,y,w,h,xp,yp,palette,thick,imgfile,xfree,yfree,nfree);
	}
	void draw(Graphics g)
    {
       g.drawPolyline(xpoints, ypoints, npoints);
    }
	void draw2(Graphics2D g2) 
	{
		g2.setStroke(linesizeck);
		g2.setColor(colorck);
	}
}

//RESET Button 클릭 시
class Reset {
	

}


public class MyPanel extends JPanel implements MouseListener, MouseMotionListener {
	
	int x, y, w, h, px,py,dx,dy;
	int xp[];
	int yp[];
	Color colorck/* = graphicEditor.color */;
	BasicStroke linesizeck /* = graphicEditor.linesize */;
	ImageIcon image;
	int xpoints[];
	int ypoints[];
	int npoints;
	Color brushcolor;
	
	ArrayList<Tool> toolList;
	
	Polygon freeline;
	ArrayList<Polygon> freelineList;
	
	Polygon erase;
	ArrayList<Polygon> eraseList;


	public MyPanel()
    {
		
        addMouseListener(this);
        addMouseMotionListener(this);
        
        toolList = new ArrayList<>();
        
		freeline = null;
		freelineList = new ArrayList<>();
		
		erase = null;
		eraseList = new ArrayList<>();
    }
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
    	Graphics2D g2 = (Graphics2D) g;
    	
    	g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//    	g2.setStroke(new BasicStroke(linesizeck,BasicStroke.CAP_ROUND,0));
    	linesizeck = new BasicStroke(graphicEditor.linesize,BasicStroke.CAP_ROUND,0);
    	g2.setStroke(linesizeck);
    	colorck = graphicEditor.color;
    	g2.setColor(colorck);
    	
    	switch(graphicEditor.draw)
    	{
    	case "LINE" :
    		g.drawLine(x, y, x+w, y+h);
//    		g2.setStroke(new BasicStroke(graphicEditor.linesize,BasicStroke.CAP_ROUND,0));
//    		linesizeck = new BasicStroke(graphicEditor.linesize,BasicStroke.CAP_ROUND,0);
//    		g2.setStroke(linesizeck);
//    		g2.setColor(colorck);
    		linesizeck = new BasicStroke(graphicEditor.linesize,BasicStroke.CAP_ROUND,0);
    		colorck = graphicEditor.color;
    		break;
    	case "RECT" :
    		g.drawRect(x, y, w, h);
//    		g2.setStroke(new BasicStroke(graphicEditor.linesize,BasicStroke.CAP_ROUND,0));
//    		linesizeck = new BasicStroke(graphicEditor.linesize,BasicStroke.CAP_ROUND,0);
//    		g2.setStroke(linesizeck);
//    		g2.setColor(colorck);
    		linesizeck = new BasicStroke(graphicEditor.linesize,BasicStroke.CAP_ROUND,0);
    		colorck = graphicEditor.color;
    		break;
    	case "OVAL" :
    		g.drawOval(x, y, w, h);
//    		g2.setStroke(new BasicStroke(graphicEditor.linesize,BasicStroke.CAP_ROUND,0));
//    		linesizeck = new BasicStroke(graphicEditor.linesize,BasicStroke.CAP_ROUND,0);
//    		g2.setStroke(linesizeck);
//    		g2.setColor(colorck);
    		linesizeck = new BasicStroke(graphicEditor.linesize,BasicStroke.CAP_ROUND,0);
    		colorck = graphicEditor.color;
    		break;
    	case "TRIA" :
    		g.drawPolygon(xp,yp, 3);
//    		g2.setStroke(new BasicStroke(graphicEditor.linesize,BasicStroke.CAP_ROUND,0));
//    		linesizeck = new BasicStroke(graphicEditor.linesize,BasicStroke.CAP_ROUND,0);
//    		g2.setStroke(linesizeck);
//    		g2.setColor(colorck);
    		linesizeck = new BasicStroke(graphicEditor.linesize,BasicStroke.CAP_ROUND,0);
    		colorck = graphicEditor.color;
    		break;
    	case "BRUSH" :
    		if(freeline != null) {
    		g.drawPolyline(freeline.xpoints, freeline.ypoints, freeline.npoints);
//    		System.out.println("xpoints : "+ freeline.xpoints);
//    		System.out.println("ypoints : "+ freeline.ypoints);
//    		System.out.println("npoints : "+ freeline.npoints);
//    		System.out.println("linesize : "+ graphicEditor.linesize);
//    		System.out.println("colorname : "+ graphicEditor.colorname);
//			g2.setStroke(new BasicStroke(graphicEditor.linesize,BasicStroke.CAP_ROUND,0));
//    		linesizeck = new BasicStroke(graphicEditor.linesize,BasicStroke.CAP_ROUND,0);
//    		g2.setStroke(linesizeck);
    		linesizeck = new BasicStroke(graphicEditor.linesize,BasicStroke.CAP_ROUND,0);
			switch(graphicEditor.colorname) {
			case "RED" :
				//g2.setColor(new Color(255,0,0,122));
				colorck = new Color(255,0,0,122);
//				g2.setColor(brushcolor);
				break;
    		case "ORANGE" :
//    			g2.setColor(new Color(255,200,0,122));
    			colorck = new Color(255,200,0,122);
//    			g2.setColor(brushcolor);
    			break;
    		case "YELLOW" :
//				g2.setColor(new Color(255,255,0,122));
    			colorck = new Color(255,255,0,122);
//				g2.setColor(brushcolor);
				break;
    		case "GREEN" :
//    			g2.setColor(new Color(0,255,0,122));
    			colorck = new Color(0,255,0,122);
//    			g2.setColor(brushcolor);
    			break;
    		case "BLUE" :
//				g2.setColor(new Color(0,0,255,122));
    			colorck = new Color(0,0,255,122);
//				g2.setColor(brushcolor);
				break;
    		case "MAGENTA" :
//    			g2.setColor(new Color(255,0,255,122));
    			colorck = new Color(255,0,255,122);
//    			g2.setColor(brushcolor);
    			break;
    		case "BLACK" :
//				g2.setColor(new Color(0,0,0,122));
    			colorck = new Color(0,0,0,122);
//				g2.setColor(brushcolor);
				break;
    		case "darkGray" :
//    			g2.setColor(new Color(64,64,64,122));
    			colorck = new Color(64,64,64,122);
//    			g2.setColor(brushcolor);
    			break;
    		case "GRAY" :
//				g2.setColor(new Color(128,128,128,122));
    			colorck = new Color(128,128,128,122);
//				g2.setColor(brushcolor);
				break;
    		case "lightGray" :
//    			g2.setColor(new Color(192,192,192,122));
    			colorck = new Color(192,192,192,122);
//    			g2.setColor(brushcolor);
    			break;
    		case "WHITE" :
//				g2.setColor(new Color(255,255,255,122));
    			colorck = new Color(255,255,255,122);
//				g2.setColor(brushcolor);
				break;
    		case "PINK" :
//    			g2.setColor(new Color(255,175,175,122));
    			colorck = new Color(255,175,175,122);
//    			g2.setColor(brushcolor);
    			break;
    		default :
//    			g2.setColor(new Color(0,0,0,122));
    			colorck = new Color(0,0,0,122);
//    			g2.setColor(brushcolor);
    			break;
    		}
			g2.setColor(colorck);
    	}	//1213 수정
			break;
    	case "PEN" :
    		if(freeline != null)
    			g.drawPolyline(freeline.xpoints, freeline.ypoints, freeline.npoints);
//    			g2.setStroke(new BasicStroke(graphicEditor.linesize,BasicStroke.CAP_ROUND,0));
//    			linesizeck = new BasicStroke(graphicEditor.linesize,BasicStroke.CAP_ROUND,0);
//    			g2.setStroke(linesizeck);
//    			g2.setColor(colorck);
    			linesizeck = new BasicStroke(graphicEditor.linesize,BasicStroke.CAP_ROUND,0);
    			colorck = graphicEditor.color;
    			break;
    	case "IMG" :
    		image = new ImageIcon((graphicEditor.IMGFile).toString());
    		g.drawImage(image.getImage(), x,y,w,h,null);
//			g2.setStroke(new BasicStroke(linesize,BasicStroke.CAP_ROUND,0));
    		break;
    	case "ERAS" :
    		
    		//g2.setColor(Color.BLACK);
    		//g2.setStroke(new BasicStroke(100,BasicStroke.CAP_ROUND,0));
    		if(erase != null)
    			g.drawPolyline(erase.xpoints, erase.ypoints, erase.npoints);
//    			g2.setStroke(new BasicStroke(graphicEditor.linesize,BasicStroke.CAP_ROUND,0));
//    			linesizeck = new BasicStroke(graphicEditor.linesize,BasicStroke.CAP_ROUND,0);
//    			g2.setStroke(linesizeck);
//    			colorck = Color.white;
//    			g2.setColor(colorck);
    			linesizeck = new BasicStroke(graphicEditor.linesize,BasicStroke.CAP_ROUND,0);
        		colorck = Color.WHITE;
    		break;
    	case "NULL" :
    		break;
    	}
    	
    	
        for( Tool r:toolList) {
        	r.draw(g);
        	r.draw2(g2);
        }
            
        for(Polygon f: freelineList ) {
            g.drawPolyline(f.xpoints, f.ypoints, f.npoints);
            //g2.drawPolyline(f.xpoints, f.ypoints, f.npoints);
            g2.setStroke(linesizeck);
            g2.setColor(colorck);
		}
        for(Polygon er: eraseList ) {
            g.drawPolyline(er.xpoints, er.ypoints, er.npoints);
            g2.setStroke(linesizeck);
            g2.setColor(colorck);
		}
    }

	@Override
	public void mouseDragged(MouseEvent e) {
		
        
        switch(graphicEditor.draw)
    	{
    	case "LINE" :
    		dx = e.getX();
    		dy = e.getY();
    		w = dx - px;
            h = dy - py;
            //g2.setColor(graphicEditor.color);
    		break;
    	case "RECT" :
    		dx = e.getX();
    		dy = e.getY();
    		w = dx - px;
            h = dy - py;
            if(w < 0) {
            	dx = x = e.getX();
            	w = -w;
            	}
            	if(h < 0) {
            		dy = y = e.getY();
            		h = -h;
            	}

    		break;
    	case "OVAL" :
    		dx = e.getX();
    		dy = e.getY();
    		w = dx - px;
            h = dy - py;
            if(w < 0) {
            	dx = x = e.getX();
            	w = -w;
            	}
            	if(h < 0) {
            		dy = y = e.getY();
            		h = -h;
            	}

    		break;
    	case "TRIA" :
    		dx = e.getX();
    		dy = e.getY();
    		w = dx - px;
            h = dy - py;
            if(w < 0) {
            	dx = x = e.getX();
            	w = -w;
            	}
            	if(h < 0) {
            		dy = y = e.getY();
            		h = -h;
            	}
            xp = new int[] {(px+dx)/2,px,dx};
            yp = new int[] {py,dy,dy};

    		break;
    	case "BRUSH" :
    		freeline.addPoint(e.getX(), e.getY());
    		//repaint();
    		break;
    	case "PEN" :
    		freeline.addPoint(e.getX(), e.getY());
    		break;
    	case "IMG" :
    		dx = e.getX();
    		dy = e.getY();
    		w = dx - px;
            h = dy - py;
            if(w < 0) {
            	dx = x = e.getX();
            	w = -w;
            	}
            	if(h < 0) {
            		dy = y = e.getY();
            		h = -h;
            	}

    		break;
    	case "ERAS" :
    		erase.addPoint(e.getX(), e.getY());
    		break;
    	default:
    		break;
    	}
        repaint();
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		

		if (graphicEditor.restart == "RESET") {
			toolList.clear();
			freelineList.clear();
			eraseList.clear();
			graphicEditor.restart = "NULL";
			graphicEditor.draw = "NULL";
		}
			
		repaint();

	}
	
	
	@Override
	public void mousePressed(MouseEvent e) {
        switch(graphicEditor.draw)
    	{
    	case "BRUSH" : // 1213 수정
    		freeline = new Polygon();
            freeline.addPoint(e.getX(), e.getY());
    	case "PEN" :
    		freeline = new Polygon();
            freeline.addPoint(e.getX(), e.getY());
    		break;
    	case "ERAS" :
    		erase = new Polygon();
    		erase.addPoint(e.getX(), e.getY());
    		break;
    	default :
    		px = x = e.getX();
            py = y = e.getY();
            break;
    	}
       // repaint(); 
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		Tool t;
		
    	switch(graphicEditor.draw)
    	{
    	case "LINE" :
    		t = new Line(x,y,w,h,xp,yp,colorck,linesizeck,image,xpoints,ypoints,npoints);
			toolList.add(t);
    		break;
    	case "RECT" :
    		t = new Rect(x,y,w,h,xp,yp,colorck,linesizeck,image,xpoints,ypoints,npoints);
			toolList.add(t);
    		break;
    	case "OVAL" :
    		t = new Oval(x,y,w,h,xp,yp,colorck,linesizeck,image,xpoints,ypoints,npoints);
			toolList.add(t);
    		break;
    	case "TRIA" :
    		t = new Tria(x,y,w,h,xp,yp,colorck,linesizeck,image,xpoints,ypoints,npoints);
    		toolList.add(t);
    		break;
    	case "BRUSH" :
    		t = new Brush(x,y,w,h,xp,yp,colorck,linesizeck,image,xpoints,ypoints,npoints);
    		toolList.add(t);
    		freelineList.add(freeline);
    		//freeline = null;
    		break;
    	case "PEN" :
    		t = new Pen(x,y,w,h,xp,yp,colorck,linesizeck,image,xpoints,ypoints,npoints);
    		toolList.add(t);
    		freelineList.add(freeline);
    		//freeline = null;
    		break;
    	case "IMG" :
    		t = new Img(x,y,w,h,xp,yp,colorck,linesizeck,image,xpoints,ypoints,npoints);
    		toolList.add(t);
    		break;
    	case "ERAS" :
    		t = new Eras(x,y,w,h,xp,yp,colorck,linesizeck,image,xpoints,ypoints,npoints);
    		toolList.add(t);
    		eraseList.add(erase);
    		//erase = null;
    		break;
//    	case "reset":
//    		resetPaint();
//    		break;
    	default:
    		break;
    	}
//    	System.out.println("두께" + graphicEditor.linesize);
//		System.out.println("release1: " + toolList);
//		System.out.println("release2: " + freelineList);
//		System.out.println("release3: " + eraseList);
//		System.out.println(" ");
    	repaint();
	}
	

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}
//	public void resetPaint(){
//
//		if(this.toolList.size() == 0)
//			System.out.println("toolList is null");
//		else
//			System.out.println("t : " + this.toolList);
//		for(int i=0 ; i < toolList.size(); i++) {
//			System.out.println(toolList.get(i));
//		}
//
//		System.out.println("1234567890");
//		this.toolList.clear();
//		//freelineList.clear();
//		//eraseList.clear();
//		repaint();
//		
//	}

}


