package com.demo.leetcode;

import java.util.Arrays;

/**
 * @author awad_yoo
 * @create 2019-05-16 11:57
 */
public class Test {

    public int[] getSortSuffixArray(String S) {
        // 在第一轮的时候， 如果不加 #， 那么对于 aa，  在比较  a,a    a,null  会出错
        String s = S + "#";
        char[] arr = s.toCharArray();
        int N = arr.length;
        int[] bucket = new int[255];
        Arrays.fill(bucket, 0);

        // rank， 索引是后缀串，  值为该串的 score
        int[] rank = new int[N];

        // 对第一个字符，计算其 score， 对于相同的字符， score 一定要相同，不然后面比较  a,#     a,null 的时候 大小区分不了
        for (int i = 0; i < N; ++i) {
            bucket[arr[i]]++;
        }
        for (int i = 1; i < bucket.length; ++i) {
            bucket[i] = bucket[i - 1] + bucket[i];
        }
        for (int i = 0; i < N; ++i) {
            rank[i] = bucket[arr[i]] - 1;
        }

        // rank2 存放后半部分的 rank， 注意长度不够的设置为0
        int[] rank2 = new int[N];
        bucket = new int[N];
        // 后半部分的排序，索引为名次，值为后缀串
        int[] sa2 = new int[N];
        // 整体的排序
        int[] sa = new int[N];
        // 对整体排序要赋一个rank score， 注意相同的串，必须给相同的 score， 作为一个临时变量
        int[] new_rank = new int[N];

        for (int k = 1; k < N; k *= 2) {
            // 后半部分的 rank， 从前半部分得到，注意条件： (i+k) < N  rank 为0， 不会引起混淆  注意推敲一下
            for (int i = 0; i < N; ++i) {
                rank2[i] = (i + k) < N ? rank[i + k] : 0;
            }

            // 后半部分排序开始
            Arrays.fill(bucket, 0);
            for (int i = 0; i < N; ++i) {
                bucket[rank2[i]]++;
            }
            for (int i = 1; i < bucket.length; ++i) {
                bucket[i] = bucket[i - 1] + bucket[i];
            }
            for (int i = N - 1; i >= 0; --i) {
                int rk = --bucket[rank2[i]];
                // 这里之所以 rk 不相同，是因为前半部分不同，可以区分开 ，如果前半部分也相同，那么随意即可
                sa2[rk] = i;
            }

            // 对前半部分进行排序
            Arrays.fill(bucket, 0);
            for (int i = 0; i < N; ++i) {
                bucket[rank[i]]++;
            }
            for (int i = 1; i < bucket.length; ++i) {
                bucket[i] = bucket[i - 1] + bucket[i];
            }
            for (int i = N - 1; i >= 0; --i) {
                // 这里的顺序是根据  后半部分来的，类似于排好了 个位数， 现在排 十位数，如果十位数相同，那么个位数拍好的顺序也不会乱
                int rk = --bucket[rank[sa2[i]]];
                sa[rk] = sa2[i];
            }

            // 得到新的排序分，如果前半部分 和 后半部分 的排序分都不一样，没有必须进行下去了，直接推出  因为前缀最大！
            // 如果前半部分  和 后半部分 分数一样， 那么 rank 必须一样
            new_rank[sa[0]] = 0;
            boolean uniq_rank = true;
            for (int i = 1; i < N; ++i) {
                new_rank[sa[i]] = new_rank[sa[i - 1]];
                if (rank[sa[i]] == rank[sa[i - 1]] && rank2[sa[i]] == rank2[sa[i - 1]]) {
                    uniq_rank = false;
                } else {
                    new_rank[sa[i]] += 1;
                }
            }

            if (uniq_rank) {
                break;
            }

            System.arraycopy(new_rank, 0, rank, 0, N);
        }
        return sa;
    }

    public String longestDupSubstring(String S) {
        if (S.length() <= 1) {
            return "";
        }

        int N = S.length();
        int[] sa = getSortSuffixArray(S);
        int max_common_len = 0;
        int max_common_len_offset = 0;
        for (int i = 2; i < sa.length; ++i) {
            int offset1 = sa[i];
            int offset2 = sa[i - 1];
            int common_len = 0;
            while (offset1 < N && offset2 < N && S.charAt(offset1) == S.charAt(offset2)) {
                offset1++;
                offset2++;
                common_len++;
            }
            if (common_len > max_common_len) {
                max_common_len = common_len;
                max_common_len_offset = sa[i];
            }
        }
        return S.substring(max_common_len_offset, max_common_len_offset + max_common_len);
    }

    public static void main(String[] args) {

        Test test = new Test();
        //String str = "moplvidmaagmsawmikfeghcgdkwptxnvhngqakmmehtvykbjwrrrjvwnrteeoxmtygiiygyneddmaagvfzwkvmffghuduspyyrnftyvsvjstfohwwyxhmlfmwguxxzgwdzwlnnltpjvnzswhmbzgdwzhvbgkiddhirgljbflgvyksxgnsvztcywpvutqryzdeerlildbzmtsgnebvsjetdnfgikrbsktbrdamfccvcptfaaklmcaqmglneebpdxkvcwwpndrjqnpqgbgihsfeotgggkdbvcdwfjanvafvxsvvhzyncwlmqqsmled";
        String str = "moplvidmaagmsiyyrkchbyhivlqwqsjcgtumqscmxrxrvwsnjjfaiviraqcycjmsk" +
                "rozcdqylbuejrgfnquercvghppljmojfvylcxakyjxnyyrkchbyhivlqwqsjcgampmakyjbqgwbyokaybcuklkaqzawageypfqhhasetugatdaxpvtevrigy";
        long l = System.currentTimeMillis();
        //String s = longestDupSubstring("moplvidmaagmsiyyrkchbyhivlqwqsjcgtumqscmxrxrvwsnjjvygrelcbjgbpounhuyealllginkitfaiviraqcycjmskrozcdqylbuejrgfnquercvghppljmojfvylcxakyjxnampmakyjbqgwbyokaybcuklkaqzawageypfqhhasetugatdaxpvtevrigylqwqsjcgtumqscmnxbqod");
        String s = test.longestDupSubstring("moplvidmaagmsiyyrkchbyhivlqwqsjcgtumqscmxrxrvwsnjjvygrelcbjgbpounhuyealllginkitfaiviraqcycjmskrozcdqylbuejrgfnquercvghppljmojfvylcxakyjxnampmakyjbqgwbyokaybcuklkaqzawageypfqhhasetugatdaxpvtevrigynxbqodiyioapgxqkndujeranxgebnpgsukybyowbxhgpkwjfdywfkpufcxzzqiuglkakibbkobonunnzwbjktykebfcbobxdflnyzngheatpcvnhdwkkhnlwnjdnrmjaevqopvinnzgacjkbhvsdsvuuwwhwesgtdzuctshytyfugdqswvxisyxcxoihfgzxnidnfadphwumtgdfmhjkaryjxvfquucltmuoosamjwqqzeleaiplwcbbxjxxvgsnonoivbnmiwbnijkzgoenohqncjqnckxbhpvreasdyvffrolobxzrmrbvwkpdbfvbwwyibydhndmpvqyfmqjwosclwxhgxmwjiksjvsnwupraojuatksjfqkvvfroqxsraskbdbgtppjrnzpfzabmcczlwynwomebvrihxugvjmtrkzdwuafozjcfqacenabmmxzcueyqwvbtslhjeiopgbrbvfbnpmvlnyexopoahgmwplwxnxqzhucdieyvbgtkfmdeocamzenecqlbhqmdfrvpsqyxvkkyfrbyolzvcpcbkdprttijkzcrgciidavsmrczbollxbkytqjwbiupvsorvkorfriajdtsowenhpmdtvamkoqacwwlkqfdzorjtepwlemunyrghwlvjgaxbzawmikfhtaniwviqiaeinbsqidetfsdbgsydkxgwoqyztaqmyeefaihmgrbxzyheoegawthcsyyrpyvnhysynoaikwtvmwathsomddhltxpeuxettpbeftmmyrqclnzwljlpxazrzzdosemwmthcvgwtxtinffopqxbufjwsvhqamxpydcnpekqhsovvqugqhbgweaiheeicmkdtxltkalexbeftuxvwnxmqqjeyourvbdfikqnzdipmmmiltjapovlhkpunxljeutwhenrxyfeufmzipqvergdkwptkilwzdxlydxbjoxjzxwcfmznfqgoaemrrxuwpfkftwejubxkgjlizljoynvidqwxnvhngqakmmehtvykbjwrrrjvwnrteeoxmtygiiygynedvfzwkvmffghuduspyyrnftyvsvjstfohwwyxhmlfmwguxxzgwdzwlnnltpjvnzswhmbzgdwzhvbgkiddhirgljbflgvyksxgnsvztcywpvutqryzdeerlildbzmtsgnebvsjetdnfgikrbsktbrdamfccvcptfaaklmcaqmglneebpdxkvcwwpndrjqnpqgbgihsfeotgggkdbvcdwfjanvafvxsvvhzyncwlmqqsmledzfnxxfyvcmhtjreykqlrfiqlsqzraqgtmocijejneeezqxbtomkwugapwesrinfiaxwxradnuvbyssqkznwwpsbgatlsxfhpcidfgzrc");
        System.out.println(System.currentTimeMillis() - l);
        System.out.println(s);
    }
}
