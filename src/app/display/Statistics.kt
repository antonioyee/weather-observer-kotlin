package app.display

import app.monitoring.display.weaterstationapp.WeatherData
import framework.displaytoolkit.DisplayElement
import framework.displaytoolkit.Observer

/**
 * Created by Antonio Yee <yee.antonio@gmail.com> on 02/08/17.
 */

class Statistics(weatherData: WeatherData) : Observer, DisplayElement {

	private var maxTemp: Float = 0.0F
	private var minTemp: Float = 200.toFloat()
	private var tempSum: Float = 0.0F
	private var numReadings: Int = 0.toInt()
	private var weatherData: WeatherData

	init {
		this.weatherData = weatherData
		weatherData.registerObserver(this)
	}

	override fun update(temp: Float, humidity: Float, pressure: Float) {
		tempSum += temp
		numReadings++

		if ( temp > maxTemp ) maxTemp = temp

		if ( temp < minTemp ) minTemp = temp

		display()
	}

	override fun display() {
		println("Avg/Max/Min temperature = ${tempSum / numReadings}/${maxTemp}/${minTemp}")
		println("-------------------")
	}

}