/**   
* Copyright: Copyright (c) 2016 Asiainfo
* 
* @ClassName: AllSort.java
* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: Ben
* @date: 2016年7月3日 下午8:26:48 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2016年7月3日     Ben           v1.0.0               修改原因
*/
package com.ben.jupiter.datastructure.sort;

/**
 * @author Ben
 *
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
 
import org.apache.commons.lang.ArrayUtils;
 
public class AllSort{
    public static void main(String[] args) {
        testSuc();                                          //成功测试
        testRun(10000,100000,10000);        //性能测试
    }
    public static void testRun(int start,int end,int step){
        for(int i=start;i<=end;i=step+i){
            final int[] data=ArrayUtils.toPrimitive(getRundom(i,true)); 
            BubbleSort(data);
            SelectSort(data);
            InsertSort(data);
            radixSort(data);        //基数排序只能排（正整数）
            MergeSort(data);
            InsertSplitSort(data);
            HeapSort(data);
            QuickSort(data);
            System.out.println("");
        }
    }
    public static void testSuc(){
            final int[] data=ArrayUtils.toPrimitive(getRundom(50,true));
            System.out.println(Arrays.toString(data));
            System.out.println("插入排序:");
            System.out.println(Arrays.toString(InsertSort(data)));
            System.out.println(Arrays.toString(InsertSplitSort(data)));
            System.out.println("选择排序:");
            System.out.println(Arrays.toString(SelectSort(data)));
            System.out.println(Arrays.toString(HeapSort(data)));
            System.out.println("交换排序:");
            System.out.println(Arrays.toString(BubbleSort(data)));
            System.out.println(Arrays.toString(QuickSort(data)));
             
            System.out.println(Arrays.toString(MergeSort(data)));
            System.out.println(Arrays.toString(radixSort(data)));       //基数排序只能排（正整数）
    }
    //======================================
     
    public static int[] InsertSort(int[] sz) {
        int []data=sz;
        long beginTime=System.currentTimeMillis();
        for(int i=1;i<data.length;i++){
            for(int j=i;(j>0)&&(data[j]<data[j-1]);j--){
                swap(data,j,j-1);
            }
        }
        long endTime=System.currentTimeMillis();
        System.out.print("直接插入["+(endTime-beginTime)+"]\t\t");
        return data;
    }
    public static  int[]  InsertSplitSort(int[] sz) {
        int []data=sz;
        long beginTime=System.currentTimeMillis();
          for(int i=1;i<data.length;i++){
              int tmp = data[i];
              int min=0;   
              int big=i-1;
              while(big>=min){
                  int mid=(min+big)/2;
                  if(tmp>data[mid]){ min=mid+1;
                  }else{ big=mid-1;}
              }
              for(int j=i;j>min;j--){
                  data[j]=data[j-1];
              }
              data[big+1]=tmp;
          }
          long endTime=System.currentTimeMillis();
          System.out.print("折半插入["+(endTime-beginTime)+"]\t\t");
          return data;
    }
    public static int[] BubbleSort(int[] sz) {
        int []data=sz;
        long beginTime=System.currentTimeMillis();
        for(int i=0;i<data.length;i++){
            for(int j=i+1; j<=data.length-1; j++) {
                if(data[i] > data[j]) {      
                    swap(data,i,j);
                }
            }
        }
        long endTime=System.currentTimeMillis();
        System.out.print("冒泡["+(endTime-beginTime)+"]\t\t");
        return data;
    }
    public static int[] SelectSort(int[] sz) {
        int []data=sz;
        long beginTime=System.currentTimeMillis();
        for (int i = 0; i < data.length; i++) {
            int beginIndex = i;
            for (int j = data.length - 1; j > i; j--) {
                if (data[j] < data[beginIndex]) {
                    beginIndex = j;
                }
            }
            swap(data,i,beginIndex);
        }
        long endTime=System.currentTimeMillis();
        System.out.print("选择["+(endTime-beginTime)+"]\t\t");
        return data;
    }
    public static int[]   HeapSort (int[] sz)
    {
        int []data=sz;
        long beginTime=System.currentTimeMillis();
         int n = data.length;
        for(int i=n/2;i>=0;i--){
             keepHeap(data, n, i);
        }
          while (n > 0) {
              swap(data, 0, n-1);
              keepHeap(data, --n, 0);
          }
          long endTime=System.currentTimeMillis();
          System.out.print("堆排序["+(endTime-beginTime)+"]\t\t");
         return data;
    }
     private static void keepHeap(int[] a, int n, int i) {
         int x = a[i];
         int j = 2 * i + 1;
         while (j <= n - 1) {
               if (j < n - 1 && a[j] < a[j + 1]) ++j;
               if (a[j] > x) {
                    a[i] = a[j];
                    i = j;
                    j = 2 * i ;
               } else{break;}
          }
          a[i] = x;
    }
    public static  int[]  ShellSort(int[] sz){
        int []data=sz;
        long beginTime=System.currentTimeMillis();
        int span=data.length/7;
        if(span==0)span=1;
        while(span>=1){
            for(int i=0;i<span;i++){
                for(int j=i;j<data.length;j=j+span){
                    //组内直接插入排序   
                    int p = j-span;
                    int temp = data[j];
                    while( p >=0 && data[p] > temp){
                        data[p+span] = data[p];
                        p -=span;
                    }   
                    data[p + span] = temp;
                }
            }
            span=span/2;
        }
        long endTime=System.currentTimeMillis();
        System.out.print("希尔["+(endTime-beginTime)+"]\t\t");
        return data;
    }
    private static int[] QuickSort(int[] sz) {
        int[] data=sz;
        long beginTime=System.currentTimeMillis();
        int begin=0;
        int end=data.length-1;
         if(begin<end){
             //取中点
             int mid=(begin+end)/2;
             if(data[end]<data[begin]){swap(data, end, begin);             }
             if(data[end]<data[mid]){ swap(data, end, mid);             }
             if(data[mid]<data[begin]){  swap(data, mid, begin);             }
            int min=begin+1;
            int big=end;
             while(true){
                while(min<big && data[min]<data[begin]){min++;}
                while(min<big && data[big]>=data[begin]){big--;}
                if(min>=big){ break;  }
                swap(data, min, big);
            }
             if(data[begin]>data[min]){
                 swap(data, begin, min);
             }
         }
         long endTime=System.currentTimeMillis();
         System.out.print("快速["+(endTime-beginTime)+"]\t\t");
         return data;
    }
    public static int[]  MergeSort(int[] sz)
    {
        int []data=sz;
        long beginTime=System.currentTimeMillis();
         int[] result = merge_sort(data,0,data.length-1);
         for(int i=0;i<result.length;i++){
             data[i]=result[i];
         }
         long endTime=System.currentTimeMillis();
         System.out.print("归并["+(endTime-beginTime)+"]\t\t");
         return data;
    }
 private static  int[] merge_sort(int[] array, int start, int end){
     int[] result = new int[end-start+1];
        if(start< end){
            int mid= (start+end)/2;
            int[] left= merge_sort(array, start, mid);
            int[] right =  merge_sort(array, mid+1, end);
           result= merge(left,right);
        } else if (start == end) {
            result[0] = array[start];
        return result;
        }
        return result;
    }
   private static int[]  merge(int[] left, int[] right) {
       int[] result = new int[left.length+right.length];
        int i=0;
        int j=0;
        int k=0;
        while(i< left.length&&j< right.length){
            if(left[i]< right[j]){
                result[k++] = left[i++];
            }else{
                result[k++] = right[j++];
            }
        }
        while(i< left.length){
            result[k++] = left[i++];
        }
        while (j< right.length) {
           result[k++]= right[j++];
        }
        return result;
    }
   public static int[] radixSort(int[] sz){     
         int []data=sz;
        long beginTime=System.currentTimeMillis();
       //首先确定排序的趟数;     
         int max=data[0];     
         for(int i=1;i<data.length;i++){     
          if(data[i]>max){     
          max=data[i];     
          }     
         }     
         int time=0;     
      //判断位数;     
       while(max>0){     
          max/=10;     
           time++;     
       }     
       //建立10个队列;     
       List<ArrayList> queue=new ArrayList<ArrayList>();     
       for(int i=0;i<10;i++){     
           ArrayList<Integer> queue1=new ArrayList<Integer>();   
           queue.add(queue1);     
       }     
       //进行time次分配和收集;     
       for(int i=0;i<time;i++){     
           //分配数组元素;     
          for(int j=0;j<data.length;j++){     
               //得到数字的第time+1位数;   
              int x=data[j]%(int)Math.pow(10, i+1)/(int)Math.pow(10, i);  
              ArrayList<Integer> queue2=queue.get(x);  
              queue2.add(data[j]);  
              queue.set(x, queue2);  
       }     
       int count=0;//元素计数器;     
       //收集队列元素;     
           for(int k=0;k<10;k++){   
           while(queue.get(k).size()>0){  
               ArrayList<Integer> queue3=queue.get(k);  
               data[count]=queue3.get(0);     
                   queue3.remove(0);  
               count++;  
         }     
       }     
     }     
       long endTime=System.currentTimeMillis();
       System.out.print("基数["+(endTime-beginTime)+"]\t\t");
     return data;
    }    
    //====== 调换位置 ===============================
    private static void swap(int[] data, int x, int y) {
        int temp = data[x];
           data[x] = data[y];
           data[y] = temp;
    }
  //====== 获取随机数 ===============================
    private static Integer[] getRundom(long num,boolean math) {         //math==true   只为正数
        List<Integer> list=new ArrayList<Integer>();
        for(long i=0;i<num;i++){
              int k;
              if(Math.random()>0.5){
                  k=(int)(Math.random()*Integer.MAX_VALUE);
              }else{
                  k=(int)(Math.random()*Integer.MIN_VALUE);
                  if(math) k=(int)(Math.random()*Integer.MAX_VALUE);
              }
              list.add(k);
        }
        return list.toArray(new Integer[list.size()]);
    }
//    1.稳定性比较
//    
//    插入排序、冒泡排序、二叉树排序、二路归并排序及其他线形排序是稳定的
//     
//    选择排序、希尔排序、快速排序、堆排序是不稳定的
//     
//    2.时间复杂性比较
//     
//    插入排序、冒泡排序、选择排序的时间复杂性为O(n2)
//     
//    其它非线形排序的时间复杂性为O(nlog2n)
//     
//    线形排序的时间复杂性为O(n);
//     
//    3.辅助空间的比较
//     
//    线形排序、二路归并排序的辅助空间为O(n),其它排序的辅助空间为O(1);
//     
//    4.其它比较
//     
//    插入、冒泡排序的速度较慢，但参加排序的序列局部或整体有序时，这种排序能达到较快的速度。
//     
//    反而在这种情况下，快速排序反而慢了。
//     
//    当n较小时，对稳定性不作要求时宜用选择排序，对稳定性有要求时宜用插入或冒泡排序。
//     
//    若待排序的记录的关键字在一个明显有限范围内时,且空间允许是用桶排序。
//     
//    当n较大时，关键字元素比较随机，对稳定性没要求宜用快速排序。
//     
//    当n较大时，关键字元素可能出现本身是有序的，对稳定性有要求时，空间允许的情况下。
//     
//    宜用归并排序。
//     
//    当n较大时，关键字元素可能出现本身是有序的，对稳定性没有要求时宜用堆排序。
//     
//    *************************************************************************************
 
}

