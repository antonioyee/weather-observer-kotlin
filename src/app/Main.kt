package app.monitoring.display.weaterstationapp

import app.display.Forecast
import app.display.Statistics

/**
 * Created by Antonio Yee <yee.antonio@gmail.com> on 02/08/17.
 */

fun main(args: Array<String>) {
	val weatherData: WeatherData = WeatherData()

	val currentConditions: CurrentConditions = CurrentConditions(weatherData)
	val statistics: Statistics = Statistics(weatherData)
	val forecast: Forecast = Forecast(weatherData)

	weatherData.setMeasurements(80f, 65f, 30.4f)
	weatherData.setMeasurements(82f, 70f, 29.2f)
	weatherData.setMeasurements(78f, 90f, 29.2f)

}