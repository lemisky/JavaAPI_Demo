package demo13;

import java.util.HashMap;
import java.util.Map;

public class MyForEach {
    public static void main(String[] args) {
//        for(String s:map.ketSet())
        //如上，关于foreach循环中，上诉keySet()会多次执行吗？
        //测试方法，写个map,下个断点
        Map<String,String> map=new HashMap<>();
        map.put("1","科尔森");
        map.put("2","斯凯");
        map.put("3","韩立");
        map.put("4","唐三");
        for (String key :
                map.keySet()) {
            System.out.println(key+":"+map.get(key));
        }
        //事实证明，不会多次执行keySet()方法，此写法是靠谱的
    }
}
