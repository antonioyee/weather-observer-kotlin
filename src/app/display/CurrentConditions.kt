package app.monitoring.display.weaterstationapp

import framework.displaytoolkit.DisplayElement
import framework.displaytoolkit.Observer
import framework.displaytoolkit.Subject

/**
 * Created by Antonio Yee <yee.antonio@gmail.com> on 02/08/17.
 */

class CurrentConditions(weatherData: Subject) : Observer, DisplayElement {

	private val weatherData: Subject
	private var temperature: Float = 0.toFloat()
	private var humidity: Float = 0.toFloat()

	init {
		this.weatherData = weatherData
		weatherData.registerObserver(this)
	}

	override fun update(temp: Float, humidity: Float, pressure: Float) {
		this.temperature = temperature
		this.humidity = humidity

		display()
	}

	override fun display() {
		println("Current conditions: ${temperature}F degrees and ${humidity}% humidity")
		println("-------------------")
	}

}