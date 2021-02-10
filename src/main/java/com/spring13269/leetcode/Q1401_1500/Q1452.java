package com.spring13269.leetcode.Q1401_1500;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Q1452
 *
 * @author : zengle.huang@hand-china.com 2020/12/30
 */
public class Q1452 {
    /**
     * 给你一个数组 favoriteCompanies ，其中 favoriteCompanies[i] 是第 i 名用户收藏的公司清单（下标从 0 开始）。
     * 请找出不是其他任何人收藏的公司清单的子集的收藏清单，并返回该清单下标。下标需要按升序排列。
     *  
     * 示例 1：
     * 输入：favoriteCompanies = [["leetcode","google","facebook"],["google","microsoft"],["google","facebook"],["google"],["amazon"]]
     * 输出：[0,1,4]
     * 解释：
     * favoriteCompanies[2]=["google","facebook"] 是 favoriteCompanies[0]=["leetcode","google","facebook"] 的子集。
     * favoriteCompanies[3]=["google"] 是 favoriteCompanies[0]=["leetcode","google","facebook"] 和 favoriteCompanies[1]=["google","microsoft"] 的子集。
     * 其余的收藏清单均不是其他任何人收藏的公司清单的子集，因此，答案为 [0,1,4] 。
     * 示例 2：
     * 输入：favoriteCompanies = [["leetcode","google","facebook"],["leetcode","amazon"],["facebook","google"]]
     * 输出：[0,1]
     * 解释：favoriteCompanies[2]=["facebook","google"] 是 favoriteCompanies[0]=["leetcode","google","facebook"] 的子集，因此，答案为 [0,1] 。
     * 示例 3：
     * 输入：favoriteCompanies = [["leetcode"],["google"],["facebook"],["amazon"]]
     * 输出：[0,1,2,3]
     *
     * 提示：
     * 1 <= favoriteCompanies.length <= 100
     * 1 <= favoriteCompanies[i].length <= 500
     * 1 <= favoriteCompanies[i][j].length <= 20
     * favoriteCompanies[i] 中的所有字符串 各不相同 。
     * 用户收藏的公司清单也 各不相同 ，也就是说，即便我们按字母顺序排序每个清单， favoriteCompanies[i] != favoriteCompanies[j] 仍然成立。
     * 所有字符串仅包含小写英文字母。
     */
    public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        if (favoriteCompanies == null || favoriteCompanies.isEmpty()) {
            return Collections.emptyList();
        }
        Map<Integer, Set<String>> allParentMap = new HashMap<>(favoriteCompanies.size());

        allParentMap.put(0, new HashSet<>(favoriteCompanies.get(0)));
        for (int i = 1; i < favoriteCompanies.size(); i++) {
            List<String> favoriteCompany = favoriteCompanies.get(i);
            Set<String> curFav = new HashSet<>(favoriteCompany);
            boolean match = false;
            Iterator<Map.Entry<Integer, Set<String>>> iterator = allParentMap.entrySet().iterator();
            while (iterator.hasNext()) {
            //for (Map.Entry<Integer, Set<String>> integerSetEntry : allParentMap.entrySet()) {
                Map.Entry<Integer, Set<String>> integerSetEntry = iterator.next();
                Set<String> compareSet = integerSetEntry.getValue();
                if (compareSet.size() > curFav.size()) {
                    if (compareSet.containsAll(curFav)) {
                        match = true;
                        break;
                    }
                } else {
                    if (curFav.containsAll(compareSet)) {
                        //allParentMap.remove(integerSetEntry.getKey());
                        iterator.remove();
                    }
                }
            }
            if (!match) {
                allParentMap.put(i, curFav);
            }
        }
        return allParentMap.keySet().stream().sorted().collect(Collectors.toList());
    }

    public static void main(String[] args) {
        Q1452 q = new Q1452();
        /*q.peopleIndexes(Arrays.asList(
                Arrays.asList("arrtztkotazhufrsfczr","knzgidixqgtnahamebxf","zibvccaoayyihidztflj"),
                Arrays.asList("cffiqfviuwjowkppdajm","owqvnrhuzwqohquamvsz"),
                Arrays.asList("knzgidixqgtnahamebxf","owqvnrhuzwqohquamvsz","qzeqyrgnbplsrgqnplnl"),
                Arrays.asList("arrtztkotazhufrsfczr","cffiqfviuwjowkppdajm"),
                Arrays.asList("arrtztkotazhufrsfczr","knzgidixqgtnahamebxf","owqvnrhuzwqohquamvsz","qzeqyrgnbplsrgqnplnl","zibvccaoayyihidztflj")));
        */
        List<Integer> result = q.peopleIndexes(Arrays.asList(
                Arrays.asList("jrokuoapwpeanmfjrwmg","ymiankekcgmgmtqrcvuo"),Arrays.asList("bntnsfwekgepnkyyalll","civnxhpuibmlmongbjhe","gtmklvmybvmcfpeljfbw","kgyfognlejzsfoasfxud","uwgtyovfaygbacmzlngf","xcarwrpstrehbrzjnzvs","yhctijqybjppwfcvsqrg","zjsrkbjgioqxqhyakodc"),Arrays.asList("anbhbmdllrtemqudxkpu","aohmrcntsmalqjhmpmlb","blphtuwbbapooynhmfdh","bntnsfwekgepnkyyalll","bssqkjcrthsufevxnutk","civnxhpuibmlmongbjhe","frpqxqnbegajnwcfuamj","gdezmdmyqsxzyhoyprcf","gtmklvmybvmcfpeljfbw","jjhadgnvjpyizjduoeik","jrokuoapwpeanmfjrwmg","kgyfognlejzsfoasfxud","mxkbsygzyvdvuehlewqo","nlibewwuqjlzkmfybokf","oislrkqlsbfnhpulvixx","pollltqxrgyrehnzvchi","svmzxwahupklojcbqkfe","thpftnrmdjyctofsnpue","uwgtyovfaygbacmzlngf","xcarwrpstrehbrzjnzvs","xczymewubebxjikbceeh","yalbsoeypmgxgtbkgpix","yhctijqybjppwfcvsqrg","ymiankekcgmgmtqrcvuo","zjsrkbjgioqxqhyakodc"),Arrays.asList("anbhbmdllrtemqudxkpu","aohmrcntsmalqjhmpmlb","blphtuwbbapooynhmfdh","bntnsfwekgepnkyyalll","bssqkjcrthsufevxnutk","frpqxqnbegajnwcfuamj","gdezmdmyqsxzyhoyprcf","gtmklvmybvmcfpeljfbw","jjhadgnvjpyizjduoeik","jrokuoapwpeanmfjrwmg","oislrkqlsbfnhpulvixx","pollltqxrgyrehnzvchi","qejefjqhzzvjzotgqgwb","thpftnrmdjyctofsnpue","uwgtyovfaygbacmzlngf","xczymewubebxjikbceeh","yalbsoeypmgxgtbkgpix","yhctijqybjppwfcvsqrg","ymiankekcgmgmtqrcvuo","zjsrkbjgioqxqhyakodc"),Arrays.asList("anbhbmdllrtemqudxkpu","aohmrcntsmalqjhmpmlb","bntnsfwekgepnkyyalll","bssqkjcrthsufevxnutk","civnxhpuibmlmongbjhe","ekvvxrvjtsonvjlxkiho","gtmklvmybvmcfpeljfbw","jjhadgnvjpyizjduoeik","jrokuoapwpeanmfjrwmg","kgyfognlejzsfoasfxud","mxkbsygzyvdvuehlewqo","pollltqxrgyrehnzvchi","svmzxwahupklojcbqkfe","thpftnrmdjyctofsnpue","xcarwrpstrehbrzjnzvs","xczymewubebxjikbceeh","yalbsoeypmgxgtbkgpix","yhctijqybjppwfcvsqrg","zjsrkbjgioqxqhyakodc"),Arrays.asList("blphtuwbbapooynhmfdh","bntnsfwekgepnkyyalll","bssqkjcrthsufevxnutk","civnxhpuibmlmongbjhe","ekvvxrvjtsonvjlxkiho","frpqxqnbegajnwcfuamj","gdezmdmyqsxzyhoyprcf","gtmklvmybvmcfpeljfbw","jjhadgnvjpyizjduoeik","jrokuoapwpeanmfjrwmg","mxkbsygzyvdvuehlewqo","nlibewwuqjlzkmfybokf","qejefjqhzzvjzotgqgwb","svmzxwahupklojcbqkfe","xcarwrpstrehbrzjnzvs","yalbsoeypmgxgtbkgpix","yhctijqybjppwfcvsqrg","ymiankekcgmgmtqrcvuo"),Arrays.asList("anbhbmdllrtemqudxkpu","nlibewwuqjlzkmfybokf","svmzxwahupklojcbqkfe","yhctijqybjppwfcvsqrg"),Arrays.asList("anbhbmdllrtemqudxkpu","aohmrcntsmalqjhmpmlb","civnxhpuibmlmongbjhe","jrokuoapwpeanmfjrwmg","nlibewwuqjlzkmfybokf","pollltqxrgyrehnzvchi","qejefjqhzzvjzotgqgwb","svmzxwahupklojcbqkfe","uwgtyovfaygbacmzlngf","xcarwrpstrehbrzjnzvs","xczymewubebxjikbceeh","yalbsoeypmgxgtbkgpix","yhctijqybjppwfcvsqrg","ymiankekcgmgmtqrcvuo"),Arrays.asList("anbhbmdllrtemqudxkpu","aohmrcntsmalqjhmpmlb","blphtuwbbapooynhmfdh","bntnsfwekgepnkyyalll","bssqkjcrthsufevxnutk","civnxhpuibmlmongbjhe","ekvvxrvjtsonvjlxkiho","gdezmdmyqsxzyhoyprcf","gtmklvmybvmcfpeljfbw","jjhadgnvjpyizjduoeik","jrokuoapwpeanmfjrwmg","kgyfognlejzsfoasfxud","mxkbsygzyvdvuehlewqo","nlibewwuqjlzkmfybokf","oislrkqlsbfnhpulvixx","pollltqxrgyrehnzvchi","qejefjqhzzvjzotgqgwb","svmzxwahupklojcbqkfe","thpftnrmdjyctofsnpue","uwgtyovfaygbacmzlngf","xcarwrpstrehbrzjnzvs","xczymewubebxjikbceeh","yalbsoeypmgxgtbkgpix","ymiankekcgmgmtqrcvuo"),Arrays.asList("aohmrcntsmalqjhmpmlb","kgyfognlejzsfoasfxud","pollltqxrgyrehnzvchi","uwgtyovfaygbacmzlngf"),Arrays.asList("jrokuoapwpeanmfjrwmg","kgyfognlejzsfoasfxud","qejefjqhzzvjzotgqgwb","svmzxwahupklojcbqkfe","uwgtyovfaygbacmzlngf"),Arrays.asList("aohmrcntsmalqjhmpmlb","bssqkjcrthsufevxnutk","jjhadgnvjpyizjduoeik","jrokuoapwpeanmfjrwmg","kgyfognlejzsfoasfxud","nlibewwuqjlzkmfybokf","pollltqxrgyrehnzvchi","svmzxwahupklojcbqkfe","thpftnrmdjyctofsnpue","xczymewubebxjikbceeh","yalbsoeypmgxgtbkgpix","yhctijqybjppwfcvsqrg","ymiankekcgmgmtqrcvuo"),Arrays.asList("anbhbmdllrtemqudxkpu","aohmrcntsmalqjhmpmlb","blphtuwbbapooynhmfdh","bssqkjcrthsufevxnutk","civnxhpuibmlmongbjhe","ekvvxrvjtsonvjlxkiho","frpqxqnbegajnwcfuamj","gtmklvmybvmcfpeljfbw","jrokuoapwpeanmfjrwmg","kgyfognlejzsfoasfxud","mxkbsygzyvdvuehlewqo","nlibewwuqjlzkmfybokf","oislrkqlsbfnhpulvixx","pollltqxrgyrehnzvchi","qejefjqhzzvjzotgqgwb","svmzxwahupklojcbqkfe","thpftnrmdjyctofsnpue","uwgtyovfaygbacmzlngf","xcarwrpstrehbrzjnzvs","xczymewubebxjikbceeh","yalbsoeypmgxgtbkgpix","yhctijqybjppwfcvsqrg","ymiankekcgmgmtqrcvuo","zjsrkbjgioqxqhyakodc"),Arrays.asList("anbhbmdllrtemqudxkpu","bntnsfwekgepnkyyalll","ekvvxrvjtsonvjlxkiho","frpqxqnbegajnwcfuamj","gdezmdmyqsxzyhoyprcf","jjhadgnvjpyizjduoeik","jrokuoapwpeanmfjrwmg","kgyfognlejzsfoasfxud","oislrkqlsbfnhpulvixx","pollltqxrgyrehnzvchi","qejefjqhzzvjzotgqgwb","svmzxwahupklojcbqkfe","thpftnrmdjyctofsnpue","xcarwrpstrehbrzjnzvs","xczymewubebxjikbceeh","ymiankekcgmgmtqrcvuo"),Arrays.asList("bssqkjcrthsufevxnutk","frpqxqnbegajnwcfuamj","gdezmdmyqsxzyhoyprcf","kgyfognlejzsfoasfxud","pollltqxrgyrehnzvchi","thpftnrmdjyctofsnpue","uwgtyovfaygbacmzlngf","yalbsoeypmgxgtbkgpix","ymiankekcgmgmtqrcvuo","zjsrkbjgioqxqhyakodc"),Arrays.asList("anbhbmdllrtemqudxkpu","aohmrcntsmalqjhmpmlb","blphtuwbbapooynhmfdh","bntnsfwekgepnkyyalll","civnxhpuibmlmongbjhe","ekvvxrvjtsonvjlxkiho","gtmklvmybvmcfpeljfbw","jrokuoapwpeanmfjrwmg","mxkbsygzyvdvuehlewqo","nlibewwuqjlzkmfybokf","pollltqxrgyrehnzvchi","qejefjqhzzvjzotgqgwb","svmzxwahupklojcbqkfe","thpftnrmdjyctofsnpue","xcarwrpstrehbrzjnzvs","xczymewubebxjikbceeh","yhctijqybjppwfcvsqrg","zjsrkbjgioqxqhyakodc"),Arrays.asList("blphtuwbbapooynhmfdh","frpqxqnbegajnwcfuamj","jrokuoapwpeanmfjrwmg","nlibewwuqjlzkmfybokf","thpftnrmdjyctofsnpue","xcarwrpstrehbrzjnzvs","xczymewubebxjikbceeh","yhctijqybjppwfcvsqrg","ymiankekcgmgmtqrcvuo"),Arrays.asList("blphtuwbbapooynhmfdh","bssqkjcrthsufevxnutk","civnxhpuibmlmongbjhe","frpqxqnbegajnwcfuamj","gdezmdmyqsxzyhoyprcf","gtmklvmybvmcfpeljfbw","jrokuoapwpeanmfjrwmg","kgyfognlejzsfoasfxud","nlibewwuqjlzkmfybokf","pollltqxrgyrehnzvchi","xcarwrpstrehbrzjnzvs","zjsrkbjgioqxqhyakodc"),Arrays.asList("anbhbmdllrtemqudxkpu","aohmrcntsmalqjhmpmlb","blphtuwbbapooynhmfdh","bntnsfwekgepnkyyalll","bssqkjcrthsufevxnutk","civnxhpuibmlmongbjhe","ekvvxrvjtsonvjlxkiho","gtmklvmybvmcfpeljfbw","jjhadgnvjpyizjduoeik","jrokuoapwpeanmfjrwmg","kgyfognlejzsfoasfxud","nlibewwuqjlzkmfybokf","oislrkqlsbfnhpulvixx","pollltqxrgyrehnzvchi","qejefjqhzzvjzotgqgwb","uwgtyovfaygbacmzlngf","xcarwrpstrehbrzjnzvs","xczymewubebxjikbceeh","yhctijqybjppwfcvsqrg"),Arrays.asList("aohmrcntsmalqjhmpmlb","blphtuwbbapooynhmfdh","bntnsfwekgepnkyyalll","gtmklvmybvmcfpeljfbw","qejefjqhzzvjzotgqgwb","svmzxwahupklojcbqkfe","thpftnrmdjyctofsnpue","xcarwrpstrehbrzjnzvs"),Arrays.asList("anbhbmdllrtemqudxkpu","blphtuwbbapooynhmfdh","bssqkjcrthsufevxnutk","ekvvxrvjtsonvjlxkiho","gdezmdmyqsxzyhoyprcf","jjhadgnvjpyizjduoeik","jrokuoapwpeanmfjrwmg","nlibewwuqjlzkmfybokf","oislrkqlsbfnhpulvixx","pollltqxrgyrehnzvchi","svmzxwahupklojcbqkfe","uwgtyovfaygbacmzlngf","xczymewubebxjikbceeh","ymiankekcgmgmtqrcvuo"),Arrays.asList("civnxhpuibmlmongbjhe","pollltqxrgyrehnzvchi","yhctijqybjppwfcvsqrg","zjsrkbjgioqxqhyakodc"),Arrays.asList("anbhbmdllrtemqudxkpu","blphtuwbbapooynhmfdh","bssqkjcrthsufevxnutk","ekvvxrvjtsonvjlxkiho","frpqxqnbegajnwcfuamj","gtmklvmybvmcfpeljfbw","mxkbsygzyvdvuehlewqo","oislrkqlsbfnhpulvixx","svmzxwahupklojcbqkfe","uwgtyovfaygbacmzlngf","zjsrkbjgioqxqhyakodc"),Arrays.asList("anbhbmdllrtemqudxkpu","aohmrcntsmalqjhmpmlb","blphtuwbbapooynhmfdh","civnxhpuibmlmongbjhe","ekvvxrvjtsonvjlxkiho","gdezmdmyqsxzyhoyprcf","gtmklvmybvmcfpeljfbw","jjhadgnvjpyizjduoeik","jrokuoapwpeanmfjrwmg","mxkbsygzyvdvuehlewqo","nlibewwuqjlzkmfybokf","oislrkqlsbfnhpulvixx","pollltqxrgyrehnzvchi","qejefjqhzzvjzotgqgwb","svmzxwahupklojcbqkfe","thpftnrmdjyctofsnpue","uwgtyovfaygbacmzlngf","xcarwrpstrehbrzjnzvs","xczymewubebxjikbceeh","yhctijqybjppwfcvsqrg","ymiankekcgmgmtqrcvuo","zjsrkbjgioqxqhyakodc"),Arrays.asList("anbhbmdllrtemqudxkpu","aohmrcntsmalqjhmpmlb","civnxhpuibmlmongbjhe","gdezmdmyqsxzyhoyprcf","jjhadgnvjpyizjduoeik","jrokuoapwpeanmfjrwmg","mxkbsygzyvdvuehlewqo","thpftnrmdjyctofsnpue","uwgtyovfaygbacmzlngf","xczymewubebxjikbceeh","yalbsoeypmgxgtbkgpix","yhctijqybjppwfcvsqrg","ymiankekcgmgmtqrcvuo"),Arrays.asList("anbhbmdllrtemqudxkpu","aohmrcntsmalqjhmpmlb","blphtuwbbapooynhmfdh","bntnsfwekgepnkyyalll","bssqkjcrthsufevxnutk","civnxhpuibmlmongbjhe","ekvvxrvjtsonvjlxkiho","frpqxqnbegajnwcfuamj","gdezmdmyqsxzyhoyprcf","gtmklvmybvmcfpeljfbw","jjhadgnvjpyizjduoeik","jrokuoapwpeanmfjrwmg","kgyfognlejzsfoasfxud","mxkbsygzyvdvuehlewqo","nlibewwuqjlzkmfybokf","pollltqxrgyrehnzvchi","qejefjqhzzvjzotgqgwb","thpftnrmdjyctofsnpue","xczymewubebxjikbceeh","yalbsoeypmgxgtbkgpix","yhctijqybjppwfcvsqrg","zjsrkbjgioqxqhyakodc"),Arrays.asList("anbhbmdllrtemqudxkpu","blphtuwbbapooynhmfdh","bntnsfwekgepnkyyalll","bssqkjcrthsufevxnutk","civnxhpuibmlmongbjhe","ekvvxrvjtsonvjlxkiho","frpqxqnbegajnwcfuamj","gdezmdmyqsxzyhoyprcf","gtmklvmybvmcfpeljfbw","jjhadgnvjpyizjduoeik","jrokuoapwpeanmfjrwmg","mxkbsygzyvdvuehlewqo","pollltqxrgyrehnzvchi","qejefjqhzzvjzotgqgwb","thpftnrmdjyctofsnpue","xcarwrpstrehbrzjnzvs","xczymewubebxjikbceeh","yalbsoeypmgxgtbkgpix","yhctijqybjppwfcvsqrg","ymiankekcgmgmtqrcvuo","zjsrkbjgioqxqhyakodc"),Arrays.asList("blphtuwbbapooynhmfdh","frpqxqnbegajnwcfuamj","mxkbsygzyvdvuehlewqo","svmzxwahupklojcbqkfe","uwgtyovfaygbacmzlngf","zjsrkbjgioqxqhyakodc"),Arrays.asList("anbhbmdllrtemqudxkpu","aohmrcntsmalqjhmpmlb","blphtuwbbapooynhmfdh","bntnsfwekgepnkyyalll","civnxhpuibmlmongbjhe","ekvvxrvjtsonvjlxkiho","gdezmdmyqsxzyhoyprcf","gtmklvmybvmcfpeljfbw","jrokuoapwpeanmfjrwmg","kgyfognlejzsfoasfxud","mxkbsygzyvdvuehlewqo","nlibewwuqjlzkmfybokf","oislrkqlsbfnhpulvixx","pollltqxrgyrehnzvchi","qejefjqhzzvjzotgqgwb","svmzxwahupklojcbqkfe","uwgtyovfaygbacmzlngf","xcarwrpstrehbrzjnzvs","yalbsoeypmgxgtbkgpix","yhctijqybjppwfcvsqrg","ymiankekcgmgmtqrcvuo","zjsrkbjgioqxqhyakodc"),Arrays.asList("bssqkjcrthsufevxnutk","civnxhpuibmlmongbjhe","ekvvxrvjtsonvjlxkiho","jrokuoapwpeanmfjrwmg","kgyfognlejzsfoasfxud","pollltqxrgyrehnzvchi","qejefjqhzzvjzotgqgwb","thpftnrmdjyctofsnpue","uwgtyovfaygbacmzlngf")
,Arrays.asList("aohmrcntsmalqjhmpmlb","frpqxqnbegajnwcfuamj","gtmklvmybvmcfpeljfbw","nlibewwuqjlzkmfybokf","pollltqxrgyrehnzvchi","thpftnrmdjyctofsnpue","yalbsoeypmgxgtbkgpix","yhctijqybjppwfcvsqrg","ymiankekcgmgmtqrcvuo")
,Arrays.asList("gdezmdmyqsxzyhoyprcf","kgyfognlejzsfoasfxud","mxkbsygzyvdvuehlewqo","pollltqxrgyrehnzvchi","qejefjqhzzvjzotgqgwb","yalbsoeypmgxgtbkgpix","zjsrkbjgioqxqhyakodc")
,Arrays.asList("anbhbmdllrtemqudxkpu","frpqxqnbegajnwcfuamj","mxkbsygzyvdvuehlewqo","pollltqxrgyrehnzvchi","qejefjqhzzvjzotgqgwb","thpftnrmdjyctofsnpue","uwgtyovfaygbacmzlngf","xczymewubebxjikbceeh","yhctijqybjppwfcvsqrg","ymiankekcgmgmtqrcvuo")
,Arrays.asList("anbhbmdllrtemqudxkpu","bssqkjcrthsufevxnutk","gdezmdmyqsxzyhoyprcf","jrokuoapwpeanmfjrwmg","kgyfognlejzsfoasfxud","nlibewwuqjlzkmfybokf")
,Arrays.asList("aohmrcntsmalqjhmpmlb","blphtuwbbapooynhmfdh","civnxhpuibmlmongbjhe","gdezmdmyqsxzyhoyprcf","gtmklvmybvmcfpeljfbw","jjhadgnvjpyizjduoeik","jrokuoapwpeanmfjrwmg","kgyfognlejzsfoasfxud","nlibewwuqjlzkmfybokf","oislrkqlsbfnhpulvixx","pollltqxrgyrehnzvchi","qejefjqhzzvjzotgqgwb","thpftnrmdjyctofsnpue","uwgtyovfaygbacmzlngf","xcarwrpstrehbrzjnzvs","xczymewubebxjikbceeh","yalbsoeypmgxgtbkgpix","yhctijqybjppwfcvsqrg","ymiankekcgmgmtqrcvuo","zjsrkbjgioqxqhyakodc")
,Arrays.asList("aohmrcntsmalqjhmpmlb","bssqkjcrthsufevxnutk","mxkbsygzyvdvuehlewqo","nlibewwuqjlzkmfybokf")
,Arrays.asList("mxkbsygzyvdvuehlewqo","qejefjqhzzvjzotgqgwb","svmzxwahupklojcbqkfe","yalbsoeypmgxgtbkgpix")
,Arrays.asList("aohmrcntsmalqjhmpmlb","blphtuwbbapooynhmfdh","bntnsfwekgepnkyyalll","bssqkjcrthsufevxnutk","civnxhpuibmlmongbjhe","ekvvxrvjtsonvjlxkiho","frpqxqnbegajnwcfuamj","gdezmdmyqsxzyhoyprcf","gtmklvmybvmcfpeljfbw","jjhadgnvjpyizjduoeik","jrokuoapwpeanmfjrwmg","kgyfognlejzsfoasfxud","mxkbsygzyvdvuehlewqo","pollltqxrgyrehnzvchi","qejefjqhzzvjzotgqgwb","svmzxwahupklojcbqkfe","thpftnrmdjyctofsnpue","uwgtyovfaygbacmzlngf","xcarwrpstrehbrzjnzvs","yalbsoeypmgxgtbkgpix","yhctijqybjppwfcvsqrg","ymiankekcgmgmtqrcvuo","zjsrkbjgioqxqhyakodc")
,Arrays.asList("bntnsfwekgepnkyyalll","civnxhpuibmlmongbjhe","ekvvxrvjtsonvjlxkiho","gtmklvmybvmcfpeljfbw","jrokuoapwpeanmfjrwmg","qejefjqhzzvjzotgqgwb","svmzxwahupklojcbqkfe")
,Arrays.asList("aohmrcntsmalqjhmpmlb","nlibewwuqjlzkmfybokf")
,Arrays.asList("blphtuwbbapooynhmfdh","frpqxqnbegajnwcfuamj","jjhadgnvjpyizjduoeik","ymiankekcgmgmtqrcvuo")
,Arrays.asList("anbhbmdllrtemqudxkpu","aohmrcntsmalqjhmpmlb","blphtuwbbapooynhmfdh","bntnsfwekgepnkyyalll","bssqkjcrthsufevxnutk","civnxhpuibmlmongbjhe","ekvvxrvjtsonvjlxkiho","frpqxqnbegajnwcfuamj","gdezmdmyqsxzyhoyprcf","gtmklvmybvmcfpeljfbw","jjhadgnvjpyizjduoeik","jrokuoapwpeanmfjrwmg","kgyfognlejzsfoasfxud","mxkbsygzyvdvuehlewqo","oislrkqlsbfnhpulvixx","pollltqxrgyrehnzvchi","qejefjqhzzvjzotgqgwb","svmzxwahupklojcbqkfe","thpftnrmdjyctofsnpue","uwgtyovfaygbacmzlngf","xcarwrpstrehbrzjnzvs","xczymewubebxjikbceeh","yalbsoeypmgxgtbkgpix","yhctijqybjppwfcvsqrg","ymiankekcgmgmtqrcvuo","zjsrkbjgioqxqhyakodc")
,Arrays.asList("aohmrcntsmalqjhmpmlb","blphtuwbbapooynhmfdh","bntnsfwekgepnkyyalll","bssqkjcrthsufevxnutk","ekvvxrvjtsonvjlxkiho","frpqxqnbegajnwcfuamj","gdezmdmyqsxzyhoyprcf","mxkbsygzyvdvuehlewqo","nlibewwuqjlzkmfybokf","oislrkqlsbfnhpulvixx","thpftnrmdjyctofsnpue","xcarwrpstrehbrzjnzvs","xczymewubebxjikbceeh","yalbsoeypmgxgtbkgpix","yhctijqybjppwfcvsqrg")
,Arrays.asList("anbhbmdllrtemqudxkpu","aohmrcntsmalqjhmpmlb","blphtuwbbapooynhmfdh","bntnsfwekgepnkyyalll","bssqkjcrthsufevxnutk","ekvvxrvjtsonvjlxkiho","frpqxqnbegajnwcfuamj","gdezmdmyqsxzyhoyprcf","gtmklvmybvmcfpeljfbw","jjhadgnvjpyizjduoeik","jrokuoapwpeanmfjrwmg","kgyfognlejzsfoasfxud","mxkbsygzyvdvuehlewqo","nlibewwuqjlzkmfybokf","oislrkqlsbfnhpulvixx","pollltqxrgyrehnzvchi","svmzxwahupklojcbqkfe","thpftnrmdjyctofsnpue","uwgtyovfaygbacmzlngf","xcarwrpstrehbrzjnzvs","xczymewubebxjikbceeh","yalbsoeypmgxgtbkgpix","yhctijqybjppwfcvsqrg","ymiankekcgmgmtqrcvuo","zjsrkbjgioqxqhyakodc")
,Arrays.asList("civnxhpuibmlmongbjhe","qejefjqhzzvjzotgqgwb")
,Arrays.asList("civnxhpuibmlmongbjhe","ymiankekcgmgmtqrcvuo")
,Arrays.asList("anbhbmdllrtemqudxkpu","blphtuwbbapooynhmfdh","bntnsfwekgepnkyyalll","civnxhpuibmlmongbjhe","frpqxqnbegajnwcfuamj","gdezmdmyqsxzyhoyprcf","jrokuoapwpeanmfjrwmg","kgyfognlejzsfoasfxud","mxkbsygzyvdvuehlewqo","nlibewwuqjlzkmfybokf","oislrkqlsbfnhpulvixx","xczymewubebxjikbceeh","yalbsoeypmgxgtbkgpix","ymiankekcgmgmtqrcvuo")
));
        System.out.println(result);

    }

}
