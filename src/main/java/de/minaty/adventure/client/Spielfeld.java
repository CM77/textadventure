package de.minaty.adventure.client;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import de.minaty.adventure.client.raeume.Raum;
import de.minaty.adventure.client.spielakteure.Spieler;

public class Spielfeld {

	private static Spielfeld instance;

	private Spielfeld() {
	}

	public static Spielfeld getInstance() {
		if (instance == null) {
			instance = new Spielfeld();
		}
		return instance;
	}

	// TODO wohin soll das?
	private List<Raum> erzeugeRaum() {
		Configuration con = new Configuration().configure().addAnnotatedClass(Raum.class);
		ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
		SessionFactory sf = con.buildSessionFactory(reg);
		Session session = sf.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			List<Raum> raeume = session.createNativeQuery("select * FROM textadventure.raum", Raum.class).list();
			tx.commit();
			return raeume;
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	private List<Raum> alleRaeume = new ArrayList<>();
	private List<Raum> aktuelleNachbarraeume = new ArrayList<>();

	// Räume

	public void setAlleRaeume() {
		alleRaeume.clear();
		List<Raum> r = erzeugeRaum();
		for (Raum ra : r) {
			alleRaeume.add(ra);
		}
	}

	public List<Raum> getAlleRaeume() {
		return alleRaeume;
	}

	public List<Raum> getNachbarraeume() {
		return aktuelleNachbarraeume;
	}

	public void initSpielfeld() { // TODO
		setAlleRaeume();
	}

	public Raum ermittleAufenthaltsraumSpieler(Spieler spieler) {
		for (Raum r : alleRaeume) {
			if (spieler.getPosition().equals(r.getPosition())) {
				return r;
			}
		}
		return null; // TODO Exception, da es immer Aufenthaltsraum geben muss
	}

	public List<Raum> ermittleDieNachbarraeume(Spieler spieler) {
		aktuelleNachbarraeume.clear();
		for (Raum r : alleRaeume) {
			if (r.getPosition().distance(spieler.getPosition()) == 1) {
				aktuelleNachbarraeume.add(r);
			}
		}
		return aktuelleNachbarraeume;
	}

	public Himmelsrichtung ermittleMoeglicheHimmelsrichtungen(Spieler spieler) {
		for (Raum r : aktuelleNachbarraeume) {
			if (r.getPosition().y == spieler.getPosition().y + 1) {
				return Himmelsrichtung.NORDEN;
			}
			if (r.getPosition().y == spieler.getPosition().y - 1) {
				return Himmelsrichtung.SUEDEN;
			}
			if (r.getPosition().x == spieler.getPosition().x + 1) {
				return Himmelsrichtung.OSTEN;
			}
			if (r.getPosition().x == spieler.getPosition().x - 1) {
				return Himmelsrichtung.WESTEN;
			}
		}
		return null; // TODO Exception
	}

}
