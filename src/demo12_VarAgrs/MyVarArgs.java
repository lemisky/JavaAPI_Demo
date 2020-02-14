package demo12_VarAgrs;

/**
 * 可变数据类型
 * JDK1.5之后出现的新特性
 * 一般在参数类型已知，而参数个数不确定时使用。
 *
 * 注意点：
 *  1.一个函数只能有一个可变参数
 *  2.一个函数如果有多个参数，可变参数必须放在末尾
 */
public class MyVarArgs {
    public static void main(String[] args) {
        //使用格式：方法名(数据类型...形参名){}
        System.out.println(sum(12, 32, 43, 54));
    }

    private static int sum(int... arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }
}
