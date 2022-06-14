package com.github.base.annotation;

public class TestAnnotation
{
    enum Color
    {
        RED, GREEN, BLUE;
    }
 
    // 执行输出结果
    public static void main(String[] args)
    {
        Color c1 = Color.RED; 
        System.out.println(c1); // RED
        
        for (Color myVar : Color.values()) {
            // RED
            // GREEN
            // BLUE
      		System.out.println(myVar);
    	}
        
        Color myVar = Color.BLUE;
        switch(myVar) {
            case RED:
                System.out.println("红色");
                break;
            case GREEN:
                System.out.println("绿色");
                break;
            case BLUE:
                System.out.println("蓝色");  // 蓝色
                break;
        }

        // values(), ordinal(), valueOf()方法
        // 调用 values()
        Color[] arr = Color.values();
        // 迭代枚举
        for (Color col : arr)
        {
            // 查看索引
            // RED at index 0
            // GREEN at index 1
            // BLUE at index 2
            System.out.println(col + " at index " + col.ordinal());
        }
        // 使用 valueOf() 返回枚举常量，不存在的会报错 IllegalArgumentException
        System.out.println(Color.valueOf("RED"));  // RED
        // System.out.println(Color.valueOf("WHITE"));
    }
}