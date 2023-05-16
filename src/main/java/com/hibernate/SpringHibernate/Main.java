package com.hibernate.SpringHibernate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hibernate.Dao.PlayersDaoImpl;

import com.hibernate.entity.Players;

/**
 * Hello world!
 *
 */
public class Main 
{
	public static void main( String[] args ) throws NumberFormatException, IOException
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
		PlayersDaoImpl bean = context.getBean("players",PlayersDaoImpl.class);
		System.out.println("Welcome");
		while(true)
		{
			BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
			System.out.println("press 1 to add");
			System.out.println("press 2 to displayAll");
			System.out.println("press 3 to displaySingle");
			System.out.println("press 4 to delete");
			System.out.println("press 5 to update");
			System.out.println("press 6 to exit");
			int c=Integer.parseInt(br.readLine());
			if(c==1)
			{
				//ADD

				System.out.println("enter name");
				String name=br.readLine();

				System.out.println("enter skills");
				String skills=br.readLine();

				Players p=new Players(name, skills);
				bean.insert(p);
			}
			else if(c==2)
			{
				List<Players> readall = bean.readall();
				for(Players p: readall)
				{
					System.out.println(p);
				}
			}
			else if(c==3)
			{
				System.out.println("Please enter the no.");
				int c1=Integer.parseInt(br.readLine());
				Players read = bean.read(c1);
				System.out.println(read);

			}
			else if(c==4)
			{
				System.out.println("Please enter the no.");
				int c2=Integer.parseInt(br.readLine());
				bean.delete(c2);
			}
			else if(c==5)
			{
				Players p2=new Players();
				p2.setId(6);
				p2.setName("pandya");
				p2.setSkills("allrounder");
				bean.update(p2);
			}
			else if (c==6)
			{
				break;
			}
		}
		System.out.println("bye bye");

	}
}
