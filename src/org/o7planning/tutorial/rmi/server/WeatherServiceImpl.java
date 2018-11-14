package org.o7planning.tutorial.rmi.server;
 
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Calendar;
import java.util.Date;
 
import org.o7planning.tutorial.rmi.Constants;
import org.o7planning.tutorial.rmi.WeatherData;
import org.o7planning.tutorial.rmi.WeatherService;
 
public class WeatherServiceImpl extends UnicastRemoteObject implements
      WeatherService {
  private static final long serialVersionUID = 1L;
 
  public WeatherServiceImpl() throws RemoteException {
      super();
  }
 
  @Override
  public synchronized WeatherData getWeather(Date date, String location)
          throws RemoteException {
      Calendar c = Calendar.getInstance();
      c.setTime(date);
 
      int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
 
      // Sunday, Monday
      if (dayOfWeek == 1 || dayOfWeek == 2) {
          if (location.equals(Constants.LOCATION_CHICAGO)) {
              // Rain
              return new WeatherData(date, location, Constants.WEATHER_RAIN);
          } else if (location.equals(Constants.LOCATION_HANOI)) {
              // Sunny
              return new WeatherData(date, location, Constants.WEATHER_SUNNY);
          } else if (location.equals(Constants.LOCATION_TOKYO)) {
              // Sunny
              return new WeatherData(date, location, Constants.WEATHER_SUNNY);
          }
          return new WeatherData(date, location, Constants.WEATHER_SUNNY);
      } else {
          return new WeatherData(date, location, Constants.WEATHER_SUNNY);
      }
 
  }
}