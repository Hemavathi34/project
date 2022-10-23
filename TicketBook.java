import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Map;
import java.util.HashMap;

public class TicketBook {
	static int aLB=2;//available berth
	static int aMB=2;
	static int aUB=2;
	static int aRAC=1;
	static int aWL=1;
	static List<Integer> lbp=new ArrayList<Integer>(Arrays.asList(1,2));
	static List<Integer> mbp=new ArrayList<Integer>(Arrays.asList(1,2));
	static List<Integer> ubp=new ArrayList<Integer>(Arrays.asList(1,2));
	static List<Integer> racp=new ArrayList<Integer>(Arrays.asList(1));
	static List<Integer> wlp=new ArrayList<Integer>(Arrays.asList(1));
	
    static Queue<Integer> wlList=new LinkedList<Integer>();
	static Queue<Integer> raclist=new LinkedList<Integer>();
	
	static List<Integer> bookedTickets= new ArrayList<Integer>();
	
	static Map<Integer,Passanger> passanger_stored_data=new HashMap<Integer,Passanger>();
	
	public void bookedTicket(Passanger p,int snumber,String allotedberth)
	{
		p.number=snumber;
		p.alloted=allotedberth;
		passanger_stored_data.put(p.passangerId, p);
		bookedTickets.add(p.passangerId);
		System.out.println("passanger ID:"+p.passangerId);
		System.out.println("passanger name:"+p.name);
		System.out.println("passanger ID:"+p.Age);
		System.out.println("passanger ID:"+p.Gender);
		System.out.println("Alloted berth:"+snumber+allotedberth);
		System.out.println("-------------------------Booked Sucessfully");
		
	}
	public void RACticket(Passanger p,int snumber,String RACberth )
	{
		p.number=snumber;
		p.alloted=RACberth;
		passanger_stored_data.put(p.passangerId, p);
		raclist.add(p.passangerId);
		System.out.println("passanger ID:"+p.passangerId);
		System.out.println("passanger name:"+p.name);
		System.out.println("passanger ID:"+p.Age);
		System.out.println("passanger ID:"+p.Gender);
		System.out.println("Alloted berth:"+snumber+RACberth);
		System.out.println("-------------------------RACberth given");
		
		
	}
	public void waitingticket(Passanger p,int snumber,String waitingberth )
	{
		p.number=snumber;
		p.alloted=waitingberth;
		passanger_stored_data.put(p.passangerId, p);
		wlList.add(p.passangerId);
		System.out.println("passanger ID:"+p.passangerId);
		System.out.println("passanger name:"+p.name);
		System.out.println("passanger age:"+p.Age);
		System.out.println("passanger gender:"+p.Gender);
		System.out.println("Alloted berth:"+snumber+wlList);
		System.out.println("-------------------------You are in waiting list");
		
	}
	//---------------------------------------------------------
	public static void  cancelTicket(int passangerId) {
		Passanger p= passanger_stored_data.get(passangerId);
		passanger_stored_data.remove(passangerId);
		int psnumber=p.number;
		System.out.println("------------------------cancelled successfully!");
		if(p.alloted.equals("L"))
			
		{
		   lbp.add(psnumber);
		   aLB++;
		}
		else if(p.alloted.equals("M"))
		{
		    mbp.add(psnumber);
		    aMB++;
		}
		else if(p.alloted.equals("U"))
		{
			ubp.add(psnumber);
			aUB++;
		}
		if(raclist.size()>0)
		{
			Passanger passangerfromrac=passanger_stored_data.get(raclist.poll());
			int pracsnumber=passangerfromrac.number;
			racp.add(pracsnumber);
			raclist.remove(passangerfromrac.passangerId);
			aRAC++;
			
			if(wlList.size()>0)
			{
				Passanger pwfl=passanger_stored_data.get(wlList.poll());
				int pwlnumber=pwfl.number;
				wlp.add(pwlnumber);
				wlList.remove(pwfl.passangerId);
				
				pwfl.number=racp.get(0);
				pwfl.alloted="RAC";
				raclist.add(pwfl.passangerId);
				aWL++;
				aRAC--;
				
			}
			Reservation.bookedTicket(passangerfromrac);
			
		}
	}
	public void availableTickets()
	{
		System.out.println("The Lower Berth Ticket is:"+aLB);
		System.out.println("The Middle Berth Ticket is:"+aMB);
		System.out.println("The Upper Berth Ticket is:"+aUB);
		System.out.println("The RAC Ticket is:"+aRAC);
		System.out.println("The Waiting List  Ticket is:"+aWL);
	}
	public void passangersDetail()
	{
		if(passanger_stored_data.size()==0)
		{
			System.out.println("No passanger details found");
		}
		else 
		{
			for(Passanger p:passanger_stored_data.values())
			{
				System.out.println("Passanger Id:"+p.passangerId);
				System.out.println("Passanger name:"+p.name);
				System.out.println("Passanger age:"+p.Age);
				System.out.println("Passanger gender:"+p.Gender);
				System.out.println("Alloted berth:"+p.number+p.alloted);
				System.out.println("==================================");
				
			}
						
		}
					
	}
	
	
	
	


	

}
