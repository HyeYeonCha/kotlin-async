package completablefuture

import future.currentThread
import future.sum
import java.util.concurrent.CompletableFuture

fun main() {
    val completableFuture = CompletableFuture.supplyAsync {
        currentThread()
        Thread.sleep(2000)
        sum(100, 200)
        sum(200, 400)
    }

    println("계산 시작")
    // https://codechacha.com/ko/java-completable-future/
    // 실행하는 코드가 논블로킹으로 동작
    // supplyAsync 에서 수행한 결과가 인자로 동작
    // 마지막것이 들어오는 듯
    completableFuture.thenApplyAsync(fun(result) {
        currentThread(result.toString())
    }) // 논블로킹으로 동작

//    val result = completableFuture.get() // 블로킹으로 동작
//    println(result)


    while (!completableFuture.isDone) {
        Thread.sleep(500)
        println("계산 결과를 집계 중입니다.")
//        currentThread()
    }

    println("계산 종료")
}
