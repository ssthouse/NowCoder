package company.QuNar.Num1;

import java.util.*;

/**
 * Created by ssthouse on 2016/9/27.
 */
public class LocalCache {


    /**
     * 用于保存单个的数据
     */
    class Bean {
        long timeStamp;
        int weight;
        Object value;

        //构造方法
        public Bean(long timeStamp, int weight, Object value) {
            this.timeStamp = timeStamp;
            this.weight = weight;
            this.value = value;
        }

//        //获取综合权重
//        public int getWeight() {
//            //返回综合的排序指标
//            return weight * k - timeStamp;
//        }
    }

    /**
     * 缓存大小
     */
    private int mSize;

    /**
     * 存放缓存的list
     */
    private Map<String, Bean> mMap;

    public LocalCache(int size) {
        this.mSize = size;
        this.mMap = new HashMap<>();
    }

    /**
     * 保存存入时间, 保存权重 保存使用时间
     */
//
//    public void add(String key, Object value, int weight) {
//        if (mMap.size() == mSize) {
//            //删除mMap中综合权重最低的Bean
//            Bean minValueBean = null;
//            for (Bean bean : mMap.values()) {
//                if (bean.getWeight() < minValueBean.getWeight()) {
//                    minValueBean = bean;
//                }
//            }
//            mMap.remove(minValueBean);
//            //添加当前Bean
//            mMap.put(key, new Bean(System.currentTimeMillis(), weight, value));
//            return;
//        }
//        //直接添加
//        mMap.put(key, new Bean(System.currentTimeMillis(), weight, value));
//    }


}
