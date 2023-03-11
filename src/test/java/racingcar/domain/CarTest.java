package racingcar.domain;

import org.junit.jupiter.api.Test;

import java.util.concurrent.*;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {
    @Test
    void 자동차는_멀티스레드에_안전하다() throws InterruptedException, BrokenBarrierException {
        // given
        int nThreads = 100;
        ExecutorService executorService = Executors.newFixedThreadPool(nThreads);
        CyclicBarrier cyclicBarrier = new CyclicBarrier(nThreads + 1);
        Car car = new Car(new CarName("jh"));
        MockMoveConditionStrategy mockMoveConditionStrategy = new MockMoveConditionStrategy();

        // when
        for (int j = 0; j < nThreads; j++) {
            executorService.submit(() -> {
                try {
                    cyclicBarrier.await();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }

                for (int i = 0; i < 10_000; i++) {
                    car.move(mockMoveConditionStrategy);
                }
            });
        }

        //then
        cyclicBarrier.await();
        executorService.shutdown();
        executorService.awaitTermination(10, TimeUnit.SECONDS);
        assertEquals(nThreads * 10_000, car.getMovementCount());
    }

    static class MockMoveConditionStrategy implements MoveConditionStrategy {

        @Override
        public boolean canMove() {
            return true;
        }
    }
}