import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Ice
{
	public static HashMap<Integer, Integer> map = new LinkedHashMap<Integer, Integer>();


	public static boolean isNumeric(String str){
		   for (int i = str.length();--i>=0;){  
		       if (!Character.isDigit(str.charAt(i))){
		           return false;
		       }
		   }
		   return true;
		}
	
	public static void read()
	{
		try
		{
			FileReader fr = new FileReader("data.txt");
			BufferedReader br = new BufferedReader(fr);
			String line = "";
			String[] arrs = new String[10];
			while ((line = br.readLine()) != null)
			{
				arrs = line.split("	");
//	            System.out.println(arrs[0] + " : " + arrs[1] + " : " + arrs[2]+ " : " + arrs[3]);
				arrs[0].replace(" ", "");
				String  s[]=arrs[0].split("-");
				if(isNumeric(arrs[3])&&isNumeric(s[0]))
				{
					map.put(Integer.valueOf(s[0]), Integer.valueOf(arrs[3]));
				}
				
			}
			br.close();
			fr.close();

		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void commond1()
	{
		for (int t:map.keySet())
		{
			System.out.println(t+"   "+map.get(t));
		}
	}
	
	public static void commond2()
	{
		double sum=0;
		double ave=0;
		double sta;
		int N=map.size();
		for (int t:map.keySet())
		{
			sum+=map.get(t);
		}
		System.out.println(N);
		ave=sum/N;
		System.out.println(String.format("%.2f", ave));
		sum=0;
		for (int t:map.keySet())
		{
			sum+=(map.get(t)-ave)*(map.get(t)-ave);
		}
		sta=Math.sqrt(sum/(N-1));
		System.out.println(String.format("%.2f", sta));
	}
	
	public static void commond3(double b0,double b1)
	{
		double sum=0;
		int N=map.size();
		for (int  t:map.keySet())
		{
			sum+=(b0+b1*t-map.get(t))*(b0+b1*t-map.get(t));
		}
		System.out.println(String.format("%.2f", sum/N));
	}
	
	public static void commond4(double b0,double b1)
	{
		double sum1=0,sum2=0;
		int N=map.size();
		for (int  t:map.keySet())
		{
			sum1+=(b0+b1*t-map.get(t));
			sum2+=(b0+b1*t-map.get(t))*t;
		}
		System.out.println(String.format("%.2f", sum1/N*2));
		System.out.println(String.format("%.2f", sum2/N*2));
	}
	
	public static void commond5(double n,int T)
	{
		double b0=0,b1=0;
		double B0=0,B1=0;
		double sum1=0,sum2=0;
		int N=map.size();
		for(int i=1;i<=T;i++)
		{
			sum1=0;
			sum2=0;
			for (int  t:map.keySet())
			{
				sum1+=(b0+b1*t-map.get(t));
				sum2+=(b0+b1*t-map.get(t))*t;
			}
		    
			B0=b0-n*(sum1/N*2);
			B1=b1-n*(sum2/N*2);
			b0=B0;
			b1=B1;
			double sum=0;
			for (int  t:map.keySet())
			{
				sum+=(b0+b1*t-map.get(t))*(b0+b1*t-map.get(t));
			}
			System.out.println(String.format("%d %.2f %.2f %.2f", i,b0,b1,sum/N));
		}
	}
	
	public static void commond6()
	{
		double ave1=0,ave2=0;
		double sum1=0,sum2=0,Sum1=0,Sum2=0;
		int N=map.size();
		for (int  t:map.keySet())
		{
			sum1+=t;
			sum2+=map.get(t);
		}
		ave1=sum1/N;
		ave2=sum2/N;
		for (int  t:map.keySet())
		{
			Sum1+=(t-ave1)*(map.get(t)-ave2);
			Sum2+=(t-ave1)*(t-ave1);
		}
		double b1=Sum1/Sum2;
		double b0=ave2-b1*ave1;
		double sum=0;
		for (int  t:map.keySet())
		{
			sum+=(b0+b1*t-map.get(t))*(b0+b1*t-map.get(t));
		}
		System.out.println(String.format("%.2f %.2f %.2f",b0,b1,sum/N ));
	}
	
	public static void commond7(int T)
	{
		double ave1=0,ave2=0;
		double sum1=0,sum2=0,Sum1=0,Sum2=0;
		int N=map.size();
		for (int  t:map.keySet())
		{
			sum1+=t;
			sum2+=map.get(t);
		}
		ave1=sum1/N;
		ave2=sum2/N;
		for (int  t:map.keySet())
		{
			Sum1+=(t-ave1)*(map.get(t)-ave2);
			Sum2+=(t-ave1)*(t-ave1);
		}
		double b1=Sum1/Sum2;
		double b0=ave2-b1*ave1;
		System.out.println(b0+b1*T);
	}
	
	public static void commond8(double n,int T)
	{
		double b0=0,b1=0;
		double B0=0,B1=0;
		double sum1=0,sum2=0;
		double ave=0,std=0;
		int N=map.size();
		double x[]=new double[1000];
		double sum=0;
		for (int  t:map.keySet())
		{
			sum+=t;
		}
		ave=sum/N;
		sum=0;
		for (int t:map.keySet())
		{
			sum+=(map.get(t)-ave)*(map.get(t)-ave);
		}
		int num=0;
		
		std=Math.sqrt(sum/(N-1));
		for(int i=1;i<=T;i++)
		{
			sum1=0;
			sum2=0;
			for (int  t:map.keySet())
			{
				sum1+=(b0+b1*(t-ave)/std-map.get(t));
				sum2+=(b0+b1*(t-ave)/std-map.get(t))*(t-ave)/std;
			}
		    
			B0=b0-n*(sum1/N*2);
			B1=b1-n*(sum2/N*2);
			b0=B0;
			b1=B1;
			sum=0;
			for (int  t:map.keySet())
			{
				sum+=(b0+b1*(t-ave)/std-map.get(t))*(b0+b1*(t-ave)/std-map.get(t));
			}
			System.out.println(String.format("%d %.2f %.2f %.2f", i,b0,b1,sum/N));
		}
	}
	
	public static void commond9(double n,int T)
	{
		double b0=0,b1=0;
		double B0=0,B1=0;
		double sum1=0,sum2=0;
		double ave=0,std=0;
		int N=map.size();
		double x[]=new double[1000];
		int X[]=new int[1000];
		double sum=0;
		for (int  t:map.keySet())
		{
			sum+=t;
		}
		ave=sum/N;
		sum=0;
		for (int t:map.keySet())
		{
			sum+=(map.get(t)-ave)*(map.get(t)-ave);
		}
		std=Math.sqrt(sum/(N-1));
		int num=0;
		for (int t:map.keySet())
		{
			X[num]=t;
			x[num++]=(t-ave)/std;
		}
		for(int i=1;i<=T;i++)
		{
			sum1=(b0+b1*x[i]-map.get(X[i]));
			sum2=(b0+b1*x[i]-map.get(X[i]))*x[i];
		    
			B0=b0-n*(sum1/N*2);
			B1=b1-n*(sum2/N*2);
			b0=B0;
			b1=B1;
			sum=0;
			for (int  t:map.keySet())
			{
				sum+=(b0+b1*(t-ave)/std-map.get(t))*(b0+b1*(t-ave)/std-map.get(t));
			}
			System.out.println(String.format("%d %.2f %.2f %.2f", i,b0,b1,sum/N));
		}
	}
	
	public static void main(String args[])
	{
		read();
		String commond="";
		Scanner in=new Scanner(System.in);
		while(true)
		{
			commond=in.nextLine();
			if(commond=="")
			{
				break;
			}
			if(commond.equals("$java Ice 100"))
			{
				commond1();
			}
			if(commond.equals("$java Ice 200"))
			{
				commond2();
			}
			if(commond.contains("$java Ice 300"))
			{
				String s[]=commond.split(" ");
				int l=s.length;
				double b0=Double.valueOf(s[l-2]),b1=Double.valueOf(s[l-1]);
				commond3(b0,b1);
			}
			if(commond.contains("$java Ice 400"))
			{
				String s[]=commond.split(" ");
				int l=s.length;
				double b0=Double.valueOf(s[l-2]),b1=Double.valueOf(s[l-1]);
				commond4(b0,b1);
			}
			if(commond.contains("$java Ice 500"))
			{
				String s[]=commond.split(" ");
				int l=s.length;
				double n=Double.valueOf(s[l-2]);
				int T=Integer.valueOf(s[l-1]);
				commond5(n,T);
			}
			if(commond.equals("$java Ice 600"))
			{
				commond6();
			}
			if(commond.contains("$java Ice 700"))
			{
				String s[]=commond.split(" ");
				int l=s.length;
				int T=Integer.valueOf(s[l-1]);
				commond7(T);
			}
			if(commond.contains("$java Ice 800"))
			{
				String s[]=commond.split(" ");
				int l=s.length;
				double n=Double.valueOf(s[l-2]);
				int T=Integer.valueOf(s[l-1]);
				commond8(n,T);
			}
			if(commond.contains("$java Ice 900"))
			{
				String s[]=commond.split(" ");
				int l=s.length;
				double n=Double.valueOf(s[l-2]);
				int T=Integer.valueOf(s[l-1]);
				commond9(n,T);
			}
		}
	}
}
