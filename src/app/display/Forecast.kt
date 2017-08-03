package app.display

import app.monitoring.display.weaterstationapp.WeatherData
import framework.displaytoolkit.DisplayElement
import framework.displaytoolkit.Observer

/**
 * Created by Antonio Yee <yee.antonio@gmail.com> on 02/08/17.
 */

class Forecast(weatherData: WeatherData) : Observer, DisplayElement {

	private var currentPressure: Float = 29.92F
	private var lastPressure: Float = 0.toFloat()
	private var weatherData: WeatherData

	init {
		this.weatherData = weatherData
		weatherData.registerObserver(this)
	}

	override fun update(temp: Float, humidity: Float, pressure: Float) {
		currentPressure = pressure

		display()
	}

	override fun display() {
		println("Forecast")

		when {
			currentPressure > lastPressure -> {
				println("Improving weather on the way!")
			}

			currentPressure == lastPressure -> {
				println("More of the same")
			}

			currentPressure < lastPressure -> {
				println("Watch out for cooler, rainy weather")
			}
		}

		println("-------------------")
	}

}