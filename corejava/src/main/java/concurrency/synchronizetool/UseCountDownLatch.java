package concurrency.synchronizetool;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * 等待多个并发事件完成 CountDownLatch
 */
public class UseCountDownLatch {


    public static void main(String[] args) {

        VideoConference conference = new VideoConference(10);

        new Thread(conference).start();

        for (int i = 0; i < 10; i++) {
            new Thread(new Participant(conference, "Participant " + i)).start();
        }

    }

    public static class Participant implements Runnable {


        private VideoConference conference;

        private String name;

        public Participant(VideoConference conference, String name) {
            this.conference = conference;
            this.name = name;
        }

        @Override
        public void run() {
            Long duration = (long) (Math.random() * 10);
            try {
                TimeUnit.SECONDS.sleep(duration);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            conference.arrive(name);

        }
    }

    /**
     * This class implements the countDownLatch of the Videoconference
     * <p/>
     * It uses a CountDownLatch to control the arrival of all the
     * participants in the conference.
     */
    public static class VideoConference implements Runnable {


        private final CountDownLatch countDownLatch;


        public VideoConference(int number) {
            this.countDownLatch = new CountDownLatch(number);
        }


        public void arrive(String name) {
            System.out.printf("%s has arrived.\n", name);
            countDownLatch.countDown();
            System.out.printf("VideoConference: Waiting for %d participants.\n", countDownLatch.getCount());
        }

        @Override
        public void run() {
            System.out.printf("VideoConference: Initialization: %d participants.\n", countDownLatch.getCount());
            try {
                countDownLatch.await();
                System.out.printf("VideoConference: All the participants have come\n");
                System.out.printf("VideoConference: Let's start...\n");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }

}
