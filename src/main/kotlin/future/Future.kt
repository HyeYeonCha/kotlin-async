package future

import java.util.concurrent.Callable
import java.util.concurrent.Executors

fun sum(a: Int, b: Int) = a + b
fun currentThread(message: String = "") = println("current Thread: ${Thread.currentThread().name} / message : $message")
fun main() {
    // 쓰레드 풀 생성
    val pool = Executors.newSingleThreadExecutor()
    // callable interface
    val future = pool.submit(Callable {
        currentThread()
        sum(100, 200)
    })

    currentThread()
    println("계산 시작")
    val futureResult = future.get() // 비동기 작업의 결과를 기다린다.
    println(futureResult)
    currentThread()
    println("계산 종료")
}
