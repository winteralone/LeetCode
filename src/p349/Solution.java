package p349;

import java.util.*;

public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int [] src = nums1;
        int [] target = nums2;
        if (nums1.length > nums2.length) {
            // 取较短的数组为基准
            src = nums2;
            target = nums1;
        }
        Map<Integer, Integer> srcMap = new HashMap<>();
        for (int i : src) {
            if (!srcMap.containsKey(i)) {
                srcMap.put(i, 1);
            }
        }
        int count = 0;
        for (int i: target) {
            Integer value = srcMap.get(i);
            if (value != null && value != 2) {
                srcMap.put(i, 2);
                count++;
            }
        }
        int [] result = new int[count];
        int offset = 0;
        for (Integer i: srcMap.keySet()) {
            if(srcMap.get(i).equals(2)) {
                result[offset] = i;
                offset++;
            }
        }
        return result;
    }
}
