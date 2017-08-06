package app.display

import app.monitoring.display.weaterstationapp.WeatherData
import framework.displaytoolkit.DisplayElement
import framework.displaytoolkit.Observer

/**
 * Created by Antonio Yee <yee.antonio@gmail.com> on 04/08/17.
 */

class HeatIndex(weatherData: WeatherData) : Observer, DisplayElement {

	private var heatIndex: Float = 0.0.toFloat()
	private var weatherData: WeatherData

	init {
		this.weatherData = weatherData
		weatherData.registerObserver(this)

	}

	override fun update(temp: Float, humidity: Float, pressure: Float) {
		heatIndex = computeHeatIndex(temp, humidity)
		display()
	}

	fun computeHeatIndex(t: Float, rh: Float): Float {
		val index = ((16.923 + (0.185212 * t) + (5.37941 * rh) - (0.100254 * t * rh)
				+ (0.00941695 * (t * t)) + (0.00728898 * (rh * rh))
				+ (0.000345372 * (t * t * rh)) - (0.000814971 * (t * rh * rh)) +
				(0.0000102102 * (t * t * rh * rh)) - (0.000038646 * (t * t * t)) + (0.0000291583 *
				(rh * rh * rh)) + (0.00000142721 * (t * t * t * rh)) +
				(0.000000197483 * (t * rh * rh * rh)) - (0.0000000218429 * (t * t * t * rh * rh)) +
				0.000000000843296 * (t * t * rh * rh * rh)) -
				(0.0000000000481975 * (t * t * t * rh * rh * rh)));

		return index.toFloat();
	}

	override fun display() {
		println("Heat index is $heatIndex")
	}

}