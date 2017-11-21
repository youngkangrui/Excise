package mypack;

public class BookDetails {
	private String id=null;
	private String title=null;
	private float price=0;
	private String name=null;
	private int year=0;
	private String description=null;
	private int amount=0;
	BookDetails(String a,String b,String c,float d,int e,String f,int g){
		id=a; 
		title=b;
		name=c;
		price=d;
		year=e;
		description=f;
		amount=g;
	}
	public String getTitle(){
		return title;
	}
	public String getName(){
		return name;
	}
	public float getPrice(){
		return price;
	}
	public int getYear(){
		return year;
	}
	public String getId(){
		return id;
	}
	public String getDescription(){
		return description;
	}
	public int getAmount(){
		return amount;
	}
	
	
}
