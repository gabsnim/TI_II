package maven.demo;

public class Champ 
{

	    private int id;
	    private String name;
	    private String classe;
	    private String price;

	    public Champ() {}

	    public Champ(int id, String name, String classe, String price)
	    {
	        this.id = id;
	        this.name = name;
	        this.classe = classe;
	        this.price = price;
	    }

	    public int getId()
	    {
	        return id;
	    }

	    public void setId(int id)
	    {
	        this.id = id;
	    }


	    public String getName()
	    {
	        return name;
	    }

	    public void setName(String name)
	    {
	        this.name = name;
	    }


	    public String getClasse()
	    {
	        return classe;
	    }

	    public void setClasse(String classe)
	    {
	        this.classe = classe;
	    }


	    public String getPrice() 
	    {
	        return price;
	    }

	    public void setPrice(String price)
	    {
	        this.price = price;
	    }
	    
	    public String toString()
	    {
	    	return "Champ{" + "id=" + id + ", champ='" + name + '\'' + ", classe='" + classe + '\'' + ", price='" + price + '\'' + '}';
	    }
	

}
