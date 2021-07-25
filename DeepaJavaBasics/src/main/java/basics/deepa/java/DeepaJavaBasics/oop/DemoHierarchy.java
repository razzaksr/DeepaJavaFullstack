package basics.deepa.java.DeepaJavaBasics.oop;

import java.util.Arrays;

public class DemoHierarchy 
{
	public static void main(String[] args) 
	{
		/*Youtube you2=new Youtube("razaksrmd@gmail.com","987654321");
		you2.show();you2.addVideo("Eifel tower");you2.addVideo("Jallikattu");you2.addVideo("Mars");
		you2.addVideo("Solar system");
		you2.show();
		System.out.println(you2.info());
		
		PlayStore play=new PlayStore();
		play.setEmail("sabariragu@gmail.com");
		play.setPass("sabarinathan");
		play.list();
		play.receive("GPay");
		System.out.println("Download count: "+Arrays.toString(play.getDownload()));
		*/
		Google google=new Youtube("razaksrmd@gmail.com","salem");
		System.out.println(google.info());;
		google=new PlayStore();
		google.setEmail("sabariragu@gmail.com");
		google.setPass("sabarisalem");
		System.out.println(google.info());;
	}
}

class PlayStore extends Google
{
	private static String[] all= {"Free fire","Faug","Temple run","Die hard","Clashofclans","Whatsapp","Insta",
			"ICICI","Axis Aha","SBI Yonu","GPay","PhonePay","BharatPay","Paytm"};
	
	
	
	public static String[] getAll() {
		return all;
	}
	public static void setAll(String[] all) {
		PlayStore.all = all;
	}

	private String[] download=new String[10];
	
	public String[] getDownload() {
		return download;
	}
	public void setDownload(String[] download) {
		this.download = download;
	}
	public void list() {
		if(getEmail()!=null) {
			System.out.println(Arrays.toString(all));
		}
		else {
			System.out.println("Login first");
		}
	}
	
	public void receive(String app)
	{
		if(getEmail()!=null)
		{
			if(Arrays.toString(all).contains(app)) {
				for(int pos=0;pos<download.length;pos++)
				{
					if(download[pos]==null||download[pos]=="")
					{
						download[pos]=app;
						System.out.println(app+" has downloaded successfully");
						break;
					}
				}
				}
				else
				{
					System.out.println(app+" not in PlayStore");
				}
		}
		else {
			System.out.println("login first");
		}
	}
}