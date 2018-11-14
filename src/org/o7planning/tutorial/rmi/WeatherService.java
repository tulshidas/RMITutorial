package org.o7planning.tutorial.rmi;
 
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;
 
 
 
public interface WeatherService extends Remote {
  
  // Method to retrieve weather information.
  public WeatherData getWeather(Date date, String location)
          throws RemoteException;
}