package leetcode.recursion;

/**
 * 390. 消除游戏
 *
 列表 arr 由在范围 [1, n] 中的所有整数组成，并按严格递增排序。请你对 arr 应用下述算法：

 从左到右，删除第一个数字，然后每隔一个数字删除一个，直到到达列表末尾。
 重复上面的步骤，但这次是从右到左。也就是，删除最右侧的数字，然后剩下的数字每隔一个删除一个。
 不断重复这两步，从左到右和从右到左交替进行，直到只剩下一个数字。
 给你整数 n ，返回 arr 最后剩下的数字。

 示例 1：

 输入：n = 9
 输出：6
 解释：
 arr = [1, 2, 3, 4, 5, 6, 7, 8, 9]
 arr = [2, 4, 6, 8]
 arr = [2, 6]
 arr = [6]

 示例 2：
 输入：n = 1
 输出：1

 提示：

 1 <= n <= 109
 */
public class EliminationGame {

    public static void main(String[] args) {
        int i = new EliminationGame().lastRemaining(9);
        System.out.println(i);
    }

    /**
     *
     * 这个算法的关键在于将该跳跃游戏转换成了一个等差数列
     * 我们每次删除完都只需要关系该等差数量第一个元素是什么就行了
     * 当该数列里只有一个元素时就代表删完了，返回该元素
     *
     * 这里我们初始化一个等差数列
     * a1=1，每两项之间的差step(公差)为1，等差数列一开始有n个元素，而cnt为数列内元素的个数为n，an为数列中最后一个元素为a1+step*(cnt-1)
     * k为这是第几次删除，初始值应该是0
     * 每经过一次删除step(公差)的值应该乘2，而数列内元素的个数cnt应该除2
     * 当数列内元素的个数cnt为1时可以返回了
     */
    public int lastRemaining(int n) {
        int a1 = 1,step = 1,cnt = n,k = 0;

        while (cnt > 1){
            //这里我们来分情况讨论a1的值
            if (k % 2 == 0){
                //如果k是偶数，则从左向右删除

                //如果元素数目cnt为奇数，则两端的元素都会被删除
                //如果元素数目cnt为偶数，则首端元素会被删除，末端元素不会被删除
                //因此无论如何a1都会被删除，下一次删除时的a1为该次的a2
                a1 = a1 + step;
            }else {
                //如果k是奇数，则从右向左删除

                //如果元素数目cnt为奇数，则两端的元素都会被删除
                //如果元素数目cnt为偶数，则首端元素不会被删除，末端元素会被删除
                //因此当元素数目cnt为奇数时a1会被删除，下一次删除时的a1为该次的a2
                //而当元素数目cnt为偶数时a1不会被删除，可以保留当前a1
                if (cnt % 2 != 0){
                    a1 = a1 + step;
                }
            }
            k++;
            //每经过一次删除step(公差)的值应该乘2，而数列内元素的个数cnt应该除2
            //这里是防止越界用位运算代替乘除2
            step = step << 1;
            cnt = cnt >> 1;
        }

        return a1;
    }
}

//以下解法无错误但会超时
//class Solution {
//    int[] nList;
//    public int lastRemaining(int n) {
//        nList = new int[n+1];
//        for (int i = 0; i < nList.length;i++){
//            nList[i] = i;
//        }
//        elimination(1, 1, 1, n);
//        int result = 0;
//        for (int i:nList){
//            if (i != 0){
//                result = i;
//                break;
//            }
//        }
//        return result;
//    }
//
//    /**
//     *
//     * @param subscript 数组当前该访问的下标
//     * @param shouldRemove 应该把当前下标元素移除吗
//     * @param isPositive 当前访问是否为正序
//     */
//    public void elimination(int subscript, int shouldRemove, int isPositive, int notZero){
//        //退出条件(非0元素个数为1)
//        if (notZero == 1 || notZero == 0){
//            return;
//        }
//        //当前下标元素移除(数组该下标元素置为0)
//        if (shouldRemove == 1){
//            nList[subscript] = 0;
//            notZero--;
//        }
//        shouldRemove = -shouldRemove;
//        if (isPositive == 1){
//            subscript++;
//        }else {
//            subscript--;
//        }
//        //一次消除到头,判断下一次应该为正序还是逆序
//        if (subscript == nList.length){
//            isPositive = -isPositive;
//            subscript--;
//            shouldRemove = 1;
//            int[] temp = new int[notZero+1];
//            int j = 1;
//            for (int i = 0 ;i < nList.length; i++){
//                if (nList[i] != 0){
//                    temp[j] = nList[i];
//                    j++;
//                }
//            }
//            nList = temp;
//            subscript = nList.length-1;
//        }else if (subscript == 0){
//            isPositive = -isPositive;
//            subscript++;
//            shouldRemove = 1;
//            int[] temp = new int[notZero+1];
//            int j = 1;
//            for (int i = 0 ;i < nList.length; i++){
//                if (nList[i] != 0){
//                    temp[j] = nList[i];
//                    j++;
//                }
//            }
//            nList = temp;
//            subscript = 1;
//        }
//        elimination(subscript, shouldRemove, isPositive, notZero);
//    }
//}
