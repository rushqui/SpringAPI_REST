package com.rushqui.hibernate;

import java.util.List;

import com.rushqui.hibernate.dao.SingerDaoImpl;
import com.rushqui.hibernate.model.Singer;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    /*   SessionFactory sessionFactory;
        Configuration configuration = new Configuration();
        configuration.configure();
    	sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
     */ 
        Singer singer = new Singer("Daemon Albarn","Avatar");	
        SingerDaoImpl singerDaoImpl = new SingerDaoImpl();
        singerDaoImpl.saveSinger(singer);	
      
        List<Singer> singers = singerDaoImpl.findAllSingers();
        for (Singer s : singers) {
			System.out.println("Nombre: " + s.getName());
		}
        
        singer = singerDaoImpl.findSingerById((long)2);
        
        System.out.println(singer.getName());
        
        
      /*  public void updateTeacher(Teacher teacher) {
    		// TODOAuto-generated method stub
    		platziSession.getSession().update(teacher);
    		platziSession.getSession().getTransaction().commit();
       }
       
       	teacher = teacherDaoImp.findById((long) 3);
		teacher.setName("Jose Manuel Castellanos");
		teacherDaoImp.updateTeacher(teacher);
     */
        
        
      //Album album = new Album("Is This It","Last Nite", 2001, "some cover");
     /* session.beginTransaction();
        session.save(album);
        session.getTransaction().commit();
        session.close();
     */   
        
    }
}		
