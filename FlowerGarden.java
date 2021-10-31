import java.util.*;

/*

The findFlower will return the position in the arraylist where the flower is found
The getFlowerName method returns the flower name at a particular position
The maxFlower method returns the name of the flower that exists the garden the most
The inRange method checks to see if a value is in a specified range
The ToString method will return the arraylist instance variable.
*/

public class FlowerGarden
{
	//create an arraylist instance variable
  private ArrayList<String> flowers;

	//write a constructor 		
	public FlowerGarden()
  {
    flowers = new ArrayList<String>();
  }

	//write add flower
  public void addFlower(String flowerName)
  {
    //Each String has a count and a flower name.  
    //"14 rose"   there are 14 rose flowers in the garden.
    //The addFlower method adds a new flower to the arraylist    -   adds   “00 flower name”

    //Get current count of flower
    int cnt = this.getCount(flowerName);
  
    if (cnt > 0) 
    {
      //Remove the flower as we will add it
      removeFlower(flowerName);
    }

    //Increment 1 to count
    cnt++;

    //Left Padding
    String lPad = String.format("%2s", cnt).replace(" ", "0");
    flowers.add(lPad + " " + flowerName);
  }

	//Write get count
  public int getCount(String flowerName)
  {
    int count = 0;

    for (int i = 0; i < flowers.size(); i++)
    {
      if (flowers.get(i).contains(flowerName))
      {
        //The flower is in the ArrayList
        //Get the current count
        //14 roses
        String value = flowers.get(i);
        String[] maxFlower = value.split(" ");
        //maxFlower[0] = 14
        //maxFlower[1] = Roses
        count = Integer.parseInt(maxFlower[0]);
      }
    }

    return count;
  }

  public void removeFlower(String name) 
  {
    //Remove the flower as we will add 
    //the flower with the new count
    for (int i = 0; i < flowers.size(); i++) 
    {
      if (flowers.get(i).contains(name)) 
      {
        flowers.remove(i);
      }
    }
  }

	//write get flower name
  public String getFlowerName(int index)
  {
    //run in range method
    return inRange(index);
  }

	//write in range
	public String inRange(int index)
  {
    if (index < flowers.size() -1)
    {
      return flowers.get(index);
    }
    else
    {
      return "Out of range";
    }
  }

	//write find flower
  public int findFlower(String flowerName)
  {
    System.out.println("findFlower");
    System.out.println(flowers.toString());
    System.out.println(flowerName);
    System.out.println(flowers.indexOf(flowerName));

    return flowers.indexOf(flowerName);
  }

	//write max flower	
	public String maxFlower()
  {
    //Sort the flowers so the last flower
    //will contain the max flower
    flowers.sort( Comparator.comparing( String::toString ) );
    
    //Get last flower in ArrayList
    String value = flowers.get(flowers.size() - 1);

    return value;
  }

	//write a toString
  public String toString()
  {
    return flowers.toString();
  }
}