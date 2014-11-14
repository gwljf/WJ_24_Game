package com.wj.wj24game;

import java.util.ArrayList;
import java.util.List;

public class Checker {
	
	private float[] random4 = new float[4];
	
	public Checker(int[] _random4){
		random4[0] = _random4[0];
		random4[1] = _random4[1];
		random4[2] = _random4[2];
		random4[3] = _random4[3];
	}
	
	   public ArrayList<String> check() 
       {
          // 存放4个整数
          List<Float> dold = new ArrayList<Float>();
          
          // 初始化，添加四个整数
          dold.add(random4[0]);
          dold.add(random4[1]);
          dold.add(random4[2]);
          dold.add(random4[3]);
         
          // 根据四个整数得出所有的排序情况
          List<List<Float>> dd = creatNum(dold);
          

          
          // 记录所有的计算结果
          List<List<Float>> tmp2 = new ArrayList<List<Float>>();
      
          // 记录所有的表达式
          List<String> strList2 = new ArrayList<String>();
          
          // 得到所有可能的结果和表达式
          calcReuslt(dd, tmp2, strList2);
          
          // 打印出所有可能等于24的算术表达式
          
          ArrayList<String> ret = new ArrayList<String>();		// 存储所有等于24的
          int hh = 0;
          for(List<Float> l1 : tmp2){
              for(float j1 : l1){
                  if (j1 == 24)
                  {
                	  ret.add((strList2.get(hh)) + " = " + (int)j1);
                  } else if (j1 == -24)
                  {    
                      // 得数为负值时需要在表达式前加负号
                	  ret.add("-" + (strList2.get(hh)) + " = " + (int)(-j1));
                  }
                  hh++;
              }
          }
          return ret;
      }
      
      /**
       * 得到所有可能的结果和表达式
       */
      private static void calcReuslt (List<List<Float>> dd, List<List<Float>> tmp2, List<String> strList2) {
    	  
  
          for (List<Float> d : dd)
          {
              // 得到第一个和第二数字的计算结果
              List<Float> tmp0 = calcTwoNum(d.get(0), d.get(1));
  
              // 存放第一个和第二数字的表达式
              List<String> strList0 = new ArrayList<String>();
              // 得到第一个和第二数字的表达式
              creatStr(strList0, String.valueOf(d.get(0).intValue()), String.valueOf(d.get(1).intValue()), 1);
  
              // 存放第一、第二数字的计算结果和第三个数字的计算结果
              List<List<Float>> tmp1 = new ArrayList<List<Float>>();
              // 存放第一、第二数字的计算结果和第三个数字的表达式
              List<String> strList1 = new ArrayList<String>();
  
              int ii = 0;
              for(float i : tmp0){
  
                  // 得到第一、第二数字的计算结果和第三个数字的计算结果
                  tmp1.add(calcTwoNum(i, d.get(2)));
  
                  // 得到第一、第二数字的计算结果和第三个数字的表达式
                  creatStr(strList1, strList0.get(ii), String.valueOf(d.get(2).intValue()), 1);
  
                  ii++;
              }
  
              int gg = 0;
              for(List<Float> l : tmp1){
                  for(float j : l){
                      // 得到前三个数字和第四个数字的计算结果
                      tmp2.add(calcTwoNum(j, d.get(3)));
  
                      // 得到前三个数字和第四个数字的表达式
                      creatStr(strList2, strList1.get(gg), String.valueOf(d.get(3).intValue()), 0);
 
                     gg++;
                 }
             }
 
         }
     }
     /**
      * 组合表达式
      */
     private static void creatStr(List<String> l, String a, String b, float hasBracket) {
         String[] operatorArr = {"+", "-", "*", "/"};
         
         for (String opr : operatorArr)
         {
        	 // 需要括号
             if (hasBracket == 1)
             {
                 if(opr.equals("/") && b.equals("0")){
                	 continue;
                 }else{
                	 l.add("(" + a + opr + b + ")");
                 }
             } else {
            	 if(opr.equals("/") && b.equals("0")){
                	 continue;
                 }else{
                	 l.add(a + opr + b);
                 }
             }
         }
     }
 
     /**
      * 得出所有的排序情况
      */
     private static List<List<Float>> creatNum(List<Float> d) {
         List<List<Float>> a = new ArrayList<List<Float>>();
         
         if (d.size() == 1)
         {
             List<Float> dd1 = new ArrayList<Float>();
             dd1.add(d.get(0));
             a.add(dd1);
             return a;
 
         } else {
             for (int j=0;j<d.size();j++)
             {
                 List<Float> d3 = new ArrayList<Float>();
                 
                 // 将传入的List复制出来
                 for (int i=0;i<d.size();i++)
                 {
                     d3.add(d.get(i));
                 }
 
                 float x = d3.get(j);
                 d3.remove(j);
                 
                 // 递归
                 List<List<Float>> tmp1 = creatNum(d3);
                 
                 for (List<Float> l : tmp1)
                 {    
                     List<Float> d2 = new ArrayList<Float>();
                     // 添加第一位截取的数字
                     d2.add(x);
                     // 添加递归后得到的数字
                     for (float f : l)
                     {
                         d2.add(f);
                     }
                     a.add(d2);
                 }
             }
             return a;
         }
     }
 
     /**
      * 得到两个数加减乘除后的结果    
      */
     private static List<Float> calcTwoNum(float n1, float n2){
         List<Float> a = new ArrayList<Float>();
         a.add(n1 + n2);
         a.add(n1 - n2);
         a.add(n1 * n2);
         if(n2!=0){
        	 a.add(n1 / n2);
         }
          return a;
     }

}
