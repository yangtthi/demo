package test_code;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description:
 *
 * 两个线程分别打印26个英文字母的元音（a,e,i,o,u）和辅音（其他）,按字母序输出
 * @Author wyatt
 * @Data 2019/06/27 19:46
 */
public class SpellingThread {

    // 公平锁,用于控制线程交替
    public static Lock lock = new ReentrantLock(true);

    // 0表示可以执行元音,1表示可以执行辅音
    public static volatile int type = 0;

    public static String[] letters = {
            "a", "b", "c", "d", "e", "f", "g", "h", "i",
            "j", "k", "l", "m", "n", "o", "p", "q", "r",
            "s", "t", "u", "v", "w", "x", "y", "z"};

    public static void main(String[] args) {
        T1 t1 = new T1();
        T2 t2 = new T2();
        Thread r1 = new Thread(t1);
        Thread r2 = new Thread(t2);

        if (isYuan(letters[0])) {
            type = 0;
        } else {
            type = 1;
        }

        r2.start();
        r1.start();
    }

    // yuan
    private static class T1 implements Runnable {

        @Override
        public void run() {

            int index = nextYuanIndex(-1);

            while (index != -1 && index < letters.length) {
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {

                }
                lock.lock();
                try {
//                    System.out.println("t1争取锁,type:" + type + ",index:" + index);
                    for (; index < letters.length; ) {
                        if (type == 0) {
                            String currLetter = letters[index];
                            if (isYuan(currLetter)) {
                                System.out.println("t1:" + currLetter);
                                index++;
                            } else {
                                index = nextYuanIndex(index);
                                type = 1;
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                }catch (Exception e) {

                } finally {
//                    System.out.println("t1释放锁,type:" + type + ",index:" + index);
                    lock.unlock();
                }
            }
        }
    }


    //fu
    private static class T2 implements Runnable {
        @Override
        public void run() {
            int index = nextFuIndex(-1);
            while (index != -1 && index < letters.length) {


                try {
                    Thread.sleep(1000);
                } catch (Exception e) {

                }
                lock.lock();
//                if (index == 0)
//                    System.out.println("t2争取锁,type:" + type + ",index:" + index);
                for (; index < letters.length; ) {
                    if (type == 1) {
                        String currLetter = letters[index];
                        if (!isYuan(currLetter)) {
                            System.out.println("t2:" + currLetter);
                            index++;
                        } else {
                            index = nextFuIndex(index);
                            type = 0;
                            break;
                        }
                    } else {
                        break;
                    }
                }
//                System.out.println("t2释放锁,type:" + type + ",index:" + index);
                lock.unlock();
            }

        }
    }

    static boolean isYuan(String s) {
        switch (s) {
            case "a":
                return true;
            case "e":
                return true;
            case "i":
                return true;
            case "o":
                return true;
            case "u":
                return true;
        }
        return false;
    }


    static int nextFuIndex(int i) {
        i = i + 1;
        for (; i < letters.length; i++) {
            String currLett = letters[i];
            if (!isYuan(currLett)) {
                return i;
            }
        }
        return -1;
    }

    static int nextYuanIndex(int i) {
        i = i + 1;
        for (; i < letters.length; i++) {
            String currLett = letters[i];
            if (isYuan(currLett)) {
                return i;
            }
        }
        return -1;
    }

}
