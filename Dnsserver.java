package app;
import java.net.*;
import java.io.*;
public class Dnsserver {
	DataOutputStream ipaddress;
	DataInputStream domainname;
	static ServerSocket sock;
	FileWriter datain;
	FileReader domain;
	BufferedWriter writedomain;
	BufferedReader readip;
	public final static int port = 5788;
	char[] array = new char[30];
	public void setnet(){
			try{
				System.out.println("Connecting....");
			Socket client = sock.accept();
			while(client.isConnected()){
			domainname = new DataInputStream(client.getInputStream());
			String domainadd = domainname.readUTF();
			/*domain = new FileReader("Client.txt");
			readip = new BufferedReader(domain);
			String getdomain = readip.readLine();
			for(int i=0;i<domainadd.length();i++){
				for(int j=0;j<getdomain.length();j++){
				//if(getdomain.charAt(j)==domainadd.charAt(i)){
					if(getdomain.charAt(j)==','){
						for(int k=j;k<getdomain.length();k++){
							if(getdomain.charAt(j)=='<'){
								for(int l=k;l<j;l++){
								System.out.print(getdomain.charAt(k+1));}
							}
							
					}
						
						
					}
				}
			//	}
				//}*/
			switch(domainadd)
			{
			case "www.google.com":
				ipaddress = new DataOutputStream(client.getOutputStream());
				ipaddress.writeUTF("172.217.11.174");
				ipaddress.flush();
				System.out.print("Send ip.");
				break;
			case "www.facebook.com":
				ipaddress = new DataOutputStream(client.getOutputStream());
				ipaddress.writeUTF("32.37.14.143");
				ipaddress.flush();
				System.out.print("Send ip.");
				break;
			default :
				System.out.print("Wrong Domain Name");
				break;
				}}}catch(IOException ex){}

		
	}
	public static void main(String args[]){
		
		Dnsserver dns = new Dnsserver();
		try {
			sock = new ServerSocket(port);
			System.out.println("DNS SERVER STARTED");
			
		} catch (IOException e) {}
		int random = 1;
		while(random == 1){
		dns.setnet();
		}
	}

	}

