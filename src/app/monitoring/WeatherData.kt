package app.monitoring.display.weaterstationapp

import framework.displaytoolkit.Observer
import framework.displaytoolkit.Subject

/**
 * Created by Antonio Yee <yee.antonio@gmail.com> on 02/08/17.
 */

class WeatherData: Subject {

	private val observers: ArrayList<Observer> = ArrayList()
	private var temperature: Float = 0.toFloat()
	private var humidity: Float = 0.toFloat()
	private var pressure: Float = 0.toFloat()

	override fun registerObserver(o: Observer) {
		observers.add(o)
	}

	override fun removeObserver(o: Observer) {
		val index = observers.indexOf(o)

		if ( index >= 0 ) {
			observers.removeAt(index)
		}
	}

	override fun notifyObservers() {
		for ( i in 0..observers.size - 1 ) {
			val observer: Observer = observers.get(i)

			observer.update(temperature, humidity, pressure)
		}
	}

	fun measurementsChanged() {
		notifyObservers()
	}

	fun setMeasurements(temperature: Float, humidity: Float, pressure: Float) {
		this.temperature = temperature
		this.humidity = humidity
		this.pressure = pressure

		measurementsChanged()
	}

}