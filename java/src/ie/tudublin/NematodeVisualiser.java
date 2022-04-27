package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

public class NematodeVisualiser extends PApplet
{

	ArrayList<Nematode>nematodes = new ArrayList<Nematode>();

	public void keyPressed()
	{		
		if (keyCode == LEFT)
		{
		}		
	}


	public void settings()
	{
		size(800, 800);
		
	}

	public void setup() 
	{
		colorMode(HSB);
		background(0);
		smooth();	
		loadNematodes();
		printNematodes();			
	}
	

	public void loadNematodes()
	{
		Table table = loadTable("nematodes.csv", "header");

		for(TableRow row:table.rows()) {

			Nematode nematode = new Nematode(row);
			nematodes.add(nematode);
		}
	}

	public void printNematodes(){
		for(Nematode n:nematodes) {
			System.out.println(n);
		}
		
	}


	public void draw()
	{	
		background(0);
		printNematodes();
	}
}
