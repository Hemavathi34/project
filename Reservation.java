import java.util.Scanner;
public class Reservation {
	public static void bookedTicket(Passanger p)
	{
		TicketBook tb=new TicketBook();
		//---------------------------------------------------------------------
		if(TicketBook.aWL==0)
		{
			System.out.println("No tickets available");
			return;
		}
		else if(p.Age>60 && TicketBook.aLB>0)
		{
			System.out.println("You are a senior citizen, so we arrange a lowerberth");
			tb.bookedTicket(p, (TicketBook.lbp.get(0)),"L");
			TicketBook.lbp.remove(0);
			TicketBook.aLB--;
		}
		else if(p.cname !=("null")&& TicketBook.aLB>0)
		{
			System.out.println("You have a child,so we arrange the lowerberth");
			tb.bookedTicket(p, (TicketBook.lbp.get(0)),"L");
			TicketBook.lbp.remove(0);
			TicketBook.aLB--;
			
		}
				
		//------------------------------Berths--------------------------------
		if((p.bp.equals("L")&&TicketBook.aLB>0)||(p.bp.equals("M")&&TicketBook.aMB>0)||(p.bp.equals("U")&&TicketBook.aUB>0))
		{
			if(p.bp.equals("L"))
			{
				System.out.println("Lower Berth given");
				tb.bookedTicket(p,(TicketBook.lbp.get(0)),"L");
				TicketBook.lbp.remove(0);
				TicketBook.aLB--;
			}
			else if(p.bp.equals("M"))
			{
				System.out.println("Middle Berth given");
				tb.bookedTicket(p,(TicketBook.mbp.get(0)),"M");
				TicketBook.mbp.remove(0);
				TicketBook.aMB--;
			}
			else if(p.bp.equals("U"))
			{
				System.out.println("Upper Berth given");
				tb.bookedTicket(p,(TicketBook.ubp.get(0)),"U");
				TicketBook.ubp.remove(0);
				TicketBook.aUB--;
				
			}
		}
		//---------------------------------Available tickets given-------------
			else if(TicketBook.aLB>0)
			{
				System.out.println("Lower Berth given");
				tb.bookedTicket(p,(TicketBook.lbp.get(0)),"L");
				TicketBook.lbp.remove(0);
				TicketBook.aLB--;
			}
			else if(TicketBook.aMB>0)
			{
				System.out.println("Middle Berth given");
				tb.bookedTicket(p,(TicketBook.mbp.get(0)),"M");
				TicketBook.mbp.remove(0);
				TicketBook.aMB--;
			}
			else if(TicketBook.aUB>0)
			{
				System.out.println("Upper Berth given");
				tb.bookedTicket(p,(TicketBook.ubp.get(0)),"U");
				TicketBook.ubp.remove(0);
				TicketBook.aUB--;
			}
			else if(TicketBook.aRAC>0)
			{
				System.out.println("RAC given");
				tb.RACticket(p,(TicketBook.racp.get(0)),"RAC");
				TicketBook.racp.remove(0);
				TicketBook.aRAC--;
			}
			else if(TicketBook.aWL>0)
			{
				System.out.println("Waiting list given");
				tb.waitingticket(p,(TicketBook.wlp.get(0)),"WL");
				TicketBook.wlp.remove(0);
				TicketBook.aWL--;
				
			}
		}
	//---------------------------cancel tickets--------------//
	public static void cancelTicket(int id)
	{
		TicketBook tb=new TicketBook();
		if(!tb.passanger_stored_data.containsKey(id))
		{
			System.out.println("Passanger Id is not found");
		}
		else 
		{
			tb.cancelTicket(id);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Scanner sc=new Scanner(System.in);

boolean loop=true;
while(loop)
{
	System.out.println("1. Book \n2. Cancel \n3. Avaliable tickets \n4. Booked tickets \n5. Exit");
	int choice=sc.nextInt();
	switch(choice)
	{
	case 1:
	{
		System.out.println("Enter the passanger name:");
		String name=sc.next();
		System.out.println("Enter the age:");
		int Age=sc.nextInt();
		System.out.println("Enter the Gender: F/M");
		String Gender=sc.next();
		if(Gender.equals("F"))
		{
			System.out.println("1. If you have a child, press 1 \n 2. If you haven't a child, press 2");
			int gchoice=sc.nextInt();
			if(gchoice==1)
			{
				System.out.println("Enter your child name:");
				String cname=sc.next();
				System.out.println("Enter your child Age:");
				int cage=sc.nextInt();
				System.out.println("Enter the passenger Berth preference:[L,M,U]");
				String bp=sc.next();
				Passanger p=new Passanger(name,Age,Gender,cname,cage,bp);
				bookedTicket(p);
			}
			else if(gchoice==2)
			{
				System.out.println("Enter the passanger berth preference:[L,M,U]");
				String bp=sc.next();
				String cname="null";
				int cage=0;
				Passanger p= new Passanger(name, Age, Gender, cname,cage,bp);
				bookedTicket(p);
			}
		}
		if(Gender.equals("M"))
		{
			System.out.println("Enter the Passanger berth preference:[L,M,U]");
			String bp=sc.next();
			String cname="null";
			int cage=0;
			Passanger p=new Passanger(name,Age,Gender,cname,cage,bp);
			bookedTicket(p);
		}
		
		
		
		break;
	}
	case 2:
	{
		System.out.println("Enter the passanger ID:");
		int id=sc.nextInt();
		cancelTicket(id);
		break;
	}
	case 3:
	{
		TicketBook tb=new TicketBook();
		tb.availableTickets();
		break;
	}
	case 4:
	{
		TicketBook ticketbook=new TicketBook();
		ticketbook.passangersDetail();
	}
		
	case 5:
	{
		loop=false;
		break;
	}
	}
}
	}

}
