package observerpattern

import java.util.*

class Coffee(val name: String)

// deprecated 뭐냐
// Subject (Observer 로 변경 상태 발행)
class Barista : Observable() {

    private lateinit var coffeeName: String

    fun orderCoffee(name: String) {
        this.coffeeName = name
    }

    fun makeCoffee() {
        setChanged() // Observable 의 플래그
        notifyObservers(Coffee(this.coffeeName)) // Observer 로 객체 전달
    }

}

// Observer (소비자)
class Customer(val name: String) : Observer {

    // Observer 의 동작
    override fun update(o: Observable?, arg: Any?) {
        val coffee = arg as Coffee
        println("${name}이 ${coffee.name}을 받았습니다")
        println(o)
    }
}


fun main() {
    val barista = Barista()
    barista.orderCoffee("아이스 아메리카노")

    val customer = Customer("고객1")
    val customer2 = Customer("고객2")
    val customer3 = Customer("고객3")

    barista.addObserver(customer) // Observer 등록
    barista.addObserver(customer2)
    barista.addObserver(customer3)

    barista.makeCoffee() // Observer 실행해주는 함수
}