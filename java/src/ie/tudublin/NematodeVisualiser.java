package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

public class NematodeVisualiser extends PApplet
{

	ArrayList<Nematode>nematodes = new ArrayList<Nematode>();
	int option = 0;

	public void keyPressed()
	{		
		if (keyCode == LEFT)
		{
			if(option == 0)
			{
				option = nematodes.size() - 1;
			}
			option --;
		}
		if (keyCode == RIGHT)
		{
			if (option == nematodes.size() - 1)
			{
				option = 0;
			}
				option ++;
		}		
	}


	public void settings()
	{
		size(600, 600);
		
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

	public void displayNematodes(){
		Nematode n = nematodes.get(option);
		for (int i = 0; i < n.getLength(); i++){
				int x = width / 2;
				int y;
				if( i == 0){
					y = 100;
				} else {
					y = i * 50;
				}
				stroke(255, 255, 255);
				noFill();
				circle(x, y, 50);
			}

		String name = nematodes.get(option).getName();
		textSize(50);
		fill(255);
		text(name, 200, 500);
		textAlign(CENTER);
		

	}

	public void draw()
	{
		background(0);
		displayNematodes();	
	}
}
