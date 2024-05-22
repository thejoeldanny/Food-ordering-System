import java.util.*;
public class Hotel
{
	static int id[] = { 1, 2, 3, 4, 5, 6 };
	public static void main (String[] args)
	{
		String list[] = {"Items", "MRP", "Quantity", "Cost", "Hotel"};
		int total = 0;
		String dishes[] = { "Chicken Tikka", "Chicken 65", "Chicken Biriyani", "Beef tawa curry", "Chilli Beef", "Beef Fried Rice"};
		int rate[] = {90, 100, 140, 65, 100, 120};
		String hotel[] ={"Taj Coromandel", "ITC Grand Chola", "SS Hyderabad", "Khader Bhai"};
		int ptr = 0;
		Scanner S = new Scanner (System.in);
		int invoice[] = new int[20];
		while (true)
		{
			System.out.println ("Choose your dish:");
			for (int i = 0; i < dishes.length; i++)
				System.out.printf ("%-3d %-20s %-10d%n", id[i], dishes[i], rate[i]);
			System.out.println ("Enter the id: ");
			int pid = S.nextInt ();
			invoice[ptr] = pid;
			ptr++;
			System.out.println ("Enter the quantity: ");
			int quantity = S.nextInt();
			invoice[ptr] = quantity;
			ptr++;
			for (int i = 0; i < hotel.length; i++)
				System.out.println ((i+1)+ " " + hotel[i]);
			System.out.println("Choose Hotel: ");
			int hid = S.nextInt();
			invoice[ptr] = hid-1;
			ptr++;
			System.out.println ("Do you want to continue: (1/0)");
			int res = S.nextInt();
			if (res == 0)
				break;
		}
		for (int i = 0; i < ptr; i=i+3)
		{
			invoice[i + 1] *= rate[getIndex(invoice[i])];
			total += invoice[i+1];
		}
		System.out.println ("*****Invoice*****");
		System.out.printf ("%-20s %-20s %-20s %-20s %-20s%n", list[0], list[1], list[2], list[3], list[4]);
		for (int i = 0; i < ptr; i = i + 3)
		{
			int index = getIndex (invoice[i]);
			int q = invoice[i + 1] / rate[index];
			System.out.printf ("%-20s %-20d %-20d %-20d %-20s%n", dishes[index], rate[index], q, invoice[i + 1], hotel[invoice[i+2]]);
		}
		System.out.println ("Total: ₹" + total);
		System.out.println ("Your food will arrive shortly!!!\nEnjoy your food!!");
	}
	static int getIndex (int k)
	{
		for (int i = 0; i < 6; i++)
		{
			if (id[i] == k)
				return i;
		}
		return -1;
	}
}
