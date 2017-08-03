package framework.displaytoolkit

/**
 * Created by Antonio Yee <yee.antonio@gmail.com> on 02/08/17.
 */

interface Subject {

	fun registerObserver(o: Observer)

	fun removeObserver(o: Observer)

	fun notifyObservers()

}