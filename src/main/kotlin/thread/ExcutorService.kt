package thread

import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

fun main() {
    // 쓰레드 5개로 유지
    // 쓰레드 풀을 생성해주는 팩토리 함수
    val pool: ExecutorService = Executors.newFixedThreadPool(5)
    try {
        for (i in 0..5) {
            pool.execute {
                println("current-thread-name : ${Thread.currentThread().name}")
            }
        }
    } finally {
        pool.shutdown()
    }
    println("current-thread-name : ${Thread.currentThread().name}")
}
