package test_code;

/**
 * @Description: 斐波那契数列
 *
 * 一条N个格子组成的直线道路，每次可以前进1格或2格；设计算法计算有多少种方式走到终点？
 *
 * 有一段楼梯有10级台阶，规定每一步只能跨一级或两级，要登上第10级台阶有几种不同的走法?
 *
 *
 * @Author wyatt
 * @Data 2019/06/27 19:33
 */
public class Fibonacci {

    public static void main(String[] args) {
        System.out.println("斐波那契数列 第10位： " + jumpFloor(10));
    }

    public static int jumpFloor(int target) {
        int[] result = {0, 1, 2};
        if(target < 3){
            return result[target];
        }
        int one = 1;
        int two = 2;
        int results = 0;
        for(int i =2; i < target; i++){
            results = one + two;
            one = two;
            two = results;
        }
        return results;
    }

}
