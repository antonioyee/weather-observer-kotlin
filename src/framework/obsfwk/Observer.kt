package framework.displaytoolkit

/**
 * Created by Antonio Yee <yee.antonio@gmail.com> on 02/08/17.
 */

interface Observer {

	fun update(temp: Float, humidity: Float, pressure: Float)

}