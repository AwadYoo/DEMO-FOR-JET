package com.demo.leetcode;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

import java.util.*;

/**
 * @author awad_yoo
 * @create 2019-05-16 09:42
 */
public class LeetCode {
    /**
     * 两数之和
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {

        int[] arr = new int[2];

        for (int i = 0; i < nums.length; i++) {

            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    arr[0] = i;
                    arr[1] = j;
                    return arr;
                }
            }
        }

        return null;
    }

    /**
     * 中位数
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        double res;
        int[] arr = new int[nums1.length + nums2.length];
        for (int i = 0; i < nums1.length; i++) {
            arr[i] = nums1[i];
        }

        for (int i = 0; i < nums2.length; i++) {
            arr[i + nums1.length] = nums2[i];
        }

        System.out.println(Arrays.toString(arr));


        for (int i = 0; i < arr.length; i++) {

            for (int j = i; j < arr.length; j++) {
                int temp;
                if (arr[i] > arr[j]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        int index = arr.length / 2;
        System.out.println(Arrays.toString(arr));
        if (arr.length % 2 == 0) {
            System.out.println("偶数个");


            System.out.println("结果是：");
            System.out.println((arr[index] + arr[index - 1]) / 2d);
            res = (arr[index] + arr[index - 1]) / 2d;

        } else {
            System.out.println("奇书个");
            System.out.println("结果是：");
            System.out.println(arr[index]);
            res = arr[index];
        }

        return res;
    }

    /**
     * 最长子串
     *
     * @param S
     * @return
     */
    public static String longestDupSubstring(String S) {

        String[] strArr = S.split("");
        List<String[]> list = new ArrayList<>();
        int count = 1;
        while (strArr.length - 1 != count) {

            for (int i = 0; i < strArr.length - count; i++) {
                String[] temp = new String[count + 1];
                int z = i;
                for (int k = 0; k < count + 1; k++) {
                    temp[k] = strArr[z];
                    z++;
                }
                list.add(temp);
            }
            count++;
        }
        Set<String[]> resList = new HashSet<>();
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i).length == list.get(j).length && Objects.equals(Arrays.toString(list.get(i)), Arrays.toString(list.get(j)))) {
                    resList.add(list.get(i));
                }
            }
        }

        int len = 0;
        String res = null;
        for (String[] arr : resList) {
            if (arr.length > len) {
                len = arr.length;
                res = Arrays.toString(arr).replaceAll("\\[", "")
                        .replaceAll("]", "")
                        .replaceAll(",", "")
                        .replaceAll(" ", "");
            }
        }
        return res == null ? "" : res;
    }

    /**
     * 反转字符串中的单词 III
     *
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        StringBuilder res = new StringBuilder();
        for (String str : s.split(" ")) {
            res.append(new StringBuffer(str).reverse()).append(" ");
        }
        return res.toString().trim();
    }

    /**
     * 螺旋矩阵
     *
     * @param matrix
     * @return
     */
    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> list = new ArrayList<>();
        if (matrix.length <= 0) {
            return list;
        }
        int m = matrix.length - 1, n = matrix[0].length - 1;
        int i = 0, j = 0, t = 0;
        while (true) {
            list.add(matrix[i][j]);
            if (i == t && j != n - t) {
                j++;
            } else if (j == n - t && i != m - t) {
                i++;
            } else if (i == m - t && j != t) {
                j--;
            } else if (j == t) {
                i--;
            }
            if (i != m - t && j != n - t && i == j) {
                t++;
                i++;
                j++;
            }
            if (list.size() == (m + 1) * (n + 1)) {
                break;
            }
        }
        System.out.println(list);
        return list;
    }


    public static void main(String[] args) {
        LeetCode code = new LeetCode();
        long l = System.currentTimeMillis();
        //String s1 = code.reverseWords("ln#z@w*gygj@frrd%vdsvia ^tlg^g#bqaqwv&@hnwomw s%!%@ab@h)ta$$tsys$^xkvcs(t@%grmck$ xeqryj$b ec$ieepim@qey#k$)mnoj&utyqzlqzwo^do(v$cx%wqq(rb&ez#dr^mkp^bniobv*tqj)buktotz l#)*vr ^iwh%xhde)khqozrhtetxoavx%r%lrsv*byxsj^edazdf*t^g ivlx%eeccon^kjvuf jnmb&he%#ln$o#kbp fnfy#(pkpm@q(bc&!($b(^gwpxjg@g(trw&fxpz*z%vuqjryhu%i%(qx%rhowkpz#yvandl*nfqaoye!) *trd)%&)#k@@tcuj$)ubsumg($ggcuzxpakvyj%e^ ^iqa*oohbvjptkx%j%*ftr!^mh@hepc$csi@%zeilq^ak#ov&*va#*bb%cis@scv(l#iccfoxccnusn%#$u#lnnk&jpf#v#mpb&o g%wyel(ltpix(kuleygwf!oprwvwb #epckqg)nwvyppugjqps&sz@rewng%#zubusxnvps)qa$qh@tbjmdmma^vd(ujlnf%towmnx@mpjrhjv))*o#)ic(^r^zvdegc ewda@uzha*qqij(*mxrveshpe nrm)mo# oad*o##qstyvsmak%kn^mnqkqvz&^iu xlukorqn%slj$athwril)g%oyji%cjo(*$k)qz@o)!iq$posw)vow^su((fcbn!$))&%li#ka*&a*wlwrqgoejoo ycporg z$jeghnbuuor@zx!njiec##)qwes(&tcjph dwjxvko#iubod@nfv$s(l$dccmdmhwfvqurxhy!h!@$il#(fuwweg^gtp viitaapvdg&ytzkoda!k%@mxnqx(j&bd)ethh%bwbojlsvqxtj%jziuznrcg*letey $jm(fmwxqyop@@#z@&w#x!brc& rqleloxry%#bkmcs%*^xul&!u#i$zjdacc*lsqs^d$magyc#cblpv$pdrjfl$wncmqng$ qmuhwyltgdy*&ltmvotiyp!murq(kxqggxfyni^(doi!amndorgoa^@(d^#mztwh$fszu^lhy*#gtng)j#y**(v$r^nw f#vrxazhcwkm)kr(kcozoxd#r%cgvpmg*opkdthcc^#ju!af!kx@w b*@pnnvgky!%n^@%asihjdp$)biy@!bz*kjuryplttph)t&k*@ql*cuazf%ry^mzfwps!&zj@fpa^%eirjl$# vfcb&jq!e^eylgiy(z#g(cphmmwdu)^#gqzfx*%$f)#d&ge&i!ahphffmt%hblu(m*s tsumyos(#@kfa n#kfga@nblobdozyqd%qj%&uaswp$of()#x^@#a@ndwj(iwyfilixhxvh$ht!^@doz!cm^!!#q*f*ck!$&^ukt^pou^wuue&#@@ *o!novc(o%#a$ju#buw)$*e@)^oslgwyglknhmelo&%jfthagxxc($^o%t%fep( agrndk*kgp!&jh@t#u&q$rsc^&miytq!ar$y*ko^y*%^$v@&@hx(nddk)&y!e@c@)#cjl$)m&kcaeefx#b!ud^as@whokuip @nreilnb@flvbdowx&!)le#f&s#oxk%ihjwaxixwmi^bo!(ai ojyvjtg@zja$rcj*&$)#u##ra@(xyz*jplt(@g*o@ogod%hej(%@f!wa*^$ua)pxpw@q(xqij(hj@&zbddmx%($thu&(s $^pok^&(fxx%mpoufz#*zutpa@pi!^hpsbbmpfrto^%)lecnbwb*n qwz$(%wh)buc*wn@vpjtqkcmg!@$zgun%!z@w&&h)x)qkkhukzn!gs!x &bg!$dfxta!*)nzditbkkzd(ywxxnw%qrpgiej*y$ho(hgpymyhwswc@jms@rdqge%g jqchg@a*yd)tmkhxwj)#)wp)ml^zpx%vpobzfg*gtf!hub$ m&vkf%&(o@)tost$a nr)bb^kv@(n#(ouc$fig*btrhohyjhobmcynnsojud(dom $ul@is^nphjhukrbxyx&oellua!zoyfrwoiyk$)!ky$jb&z&%aehi@)zkrpnwm&beueequ(t #ltr!hdpd#wszmz(n#djijxag(b&u!f!dw&ia!yxxg$r%cbuxi(^(ad vrk!thyq!resntcn(ju@)#!r^@t%#p$scpry$)aedw$#ow(o&t#@bki*bpth$lya)g$kc%*p^%) d$cksyamgtqst!*&wbn^dxfpnw(erk@$itsv)hkz##hauuh ceks*isev&dvdglmidgot)@b)rttfxk^bh#s)e@gtvkaqqggdyh&y#us$#)^@a^ szg*nr@pzns%s*!#f!^rrwvtn(wtju^c#rd%v!gebb#wg#!qc$ msbjqnwracwp*^jh(afsijgpohwtir$fi#&$i&o#fz&qcdm%@%fe(y)huayvco ths!aatok&gcxeqpez#a&v^b^dnbynuyazcewxvf%a^awh!(o^ty*bxircml$&stek&shqc&k& *li *djml^cfbqan&qubu(aauxha!fyvo^ntk$$j#mam^ amq*xo#vzw@yzlpy(zx$le#)ko%fz%!ekh((f^(@i!udbc$!zwjy^&%mskd*mlo^!fs vh#ad*baoyx!^ssvnkh!wav#rwu$wy&^(js##bj@)ikyb^grbwjny%q!wo#p*@sb&u)sg#s)yrztugw@ !frn*w&udfar&sc*y((@xzc&nnofulvhq!usqjnfr&*kynjy)&&!)aslba(*y%ffe yv#@uh(*a!(o$#glo%da$rj!)dkt#(hgnpth@w!$bb^$jray)yinwcf!kf)m*c&hilpvhtmyi @rwpezpbl^o#pee@@sy@ m(yua$ya(wzc@##p@hfd^ao$s&siscmbycw x^hqvtys#qtg)*n#futiq!*b%m)j$irpqfy(hene($fi&#bw#xi*uqoirjeh^uesecwz#*yb%*#b@to(bpeye nbboncsqidoelb)b&mk(twvo&xh!*xwv@&*mr ^pfydy*oy$tl$xz)y%hdi*v%iej)wo!c^q(y!m*ytfpe!$#ekgb^^rtnu)gi)$%(n@lmauejgucuh^$ws%iq% dxw$ctuuu^w)pljvbt)ygx*alh)t*rhkeg(kfsdmgsxug$*w!o qa pf*hrovzfqn)ffnlhy^dpemb$ oi#nlhyjg#fm%b kxno@gujshiu*piznr&a)ie*)(ums@hgz#m eb hwur$dlbqhj(ja)jadymk%l(u&*hmb^^tyv^)cd%ukeidaq^gz@gu@wq@y$pfhg^nx!b(ja(i@ixga&jad%kib)wtqzu%w n#)hx##jnlsicgv!j&z#abvmsswia**lfhlez@xge*oashh%lqx(g@stwhyk*mp)lbpoinjyxqp!#@f&ao%khs!@ulky ls%jsmqs*jhqdgmcu*ja!)atnl rkc*uv&mxrh#qjlvygv&!gaw#%zxn^za@%jhfaarg*umvpil*iphnfxggdowij&!j#p gb#$(vpsmymiqd@bvah$%fz)nmbblr*phei qa#@)huuj(g((z%x#*)$w(oks)v*%^b^zqk@ ib#kru%^)&r$u$uj&m^@oxn@yzbpc$&sf#ko@!tq(pz! abwvx&auabt@ g$lv@el$xcb @)mwp@pza@nq!*$p!jf^scbo*enke)o!@wd%vfadxtrk&d&omm!v#&u)yx)g(rcuy$c)s&katxvbep# hyzv!c#t(ihmlf!%e*bovuw&)wwr#*#jperekod@mw xm^xzwpw$a^(^po$m&pf@o^xalg$clg#gvwqqcoixs$u&e%@w%vgwqdf#uwtrnm@w!ik(ipc(po(zszd!fuqd(p^o%kr ms@^#hxdn)#dfkdrb@%tia^p)ubg@a%ejmbh#j)n)b%qdne%ioszcbexxzegpz@serd#f(tju%hwr%ln(*b sacqq@$@%*$wfk%ce%)sgoc&u$yeqj^htqu#bth@rl*!$kcg)#dd(sv&)%h&k(v*$ddrh(v#%%g)$fj$u! m*tgdhalxyk(nwf$vmb!#kwvr t)hoqtrdogf)gsko@@%uvmrf#bcu&)ypsbu*i^*s^woentuwc !hde(gbkpurpa%o@uzsqtfnqj#$b%%x!wpf*fbblxjtbknf(vu)*gu@*lj#li&wxlqia*^*pb&(dnocwq^wctw($bjmipek ha*mjlhn!yz s^xruli%ebezm$^g cnvvfgumt)tsww#j(x(bja)k&r(t(o@(yjr@ktgyork!af)y&&iyhl)iim!nq jr&ci@r^q)mfrd$)sqmtxmvxihgi^^!sdrcqv^j&qi$yxj@^))#!!$^kdvhqat@ gn@prvcttpcvtk^s#xdysk@i*#opum*$ed $ag@wozxi za$nx )mworlvu^v$if&(kb#mzbb%syfnber&vxqzrn!unw@h&l$)fymjlb!wh(xrndorh%)^(n!eskedoby^g%i&fv js#)akz(ll*a%vxs%gm$sa$k(rzfjjzkoq#eqh!)mx&kdlef&mm^rfro%p!lu*(zuvryoo#qyhp% #lc#$sn)*m^jhl#i%mile*q ^qyy@*jv*echx!khdbj*fwv!pp*gvci@t%fv(neco@i@twq&$t#ak(&emffv!f%uqo%%gafh ostovbtxjgnvxpfdxn#^$uy#w(xzsbrqbsh)t)txe(sv@y@rct(e #c$rnw(*lejmc@rux&r%cxcfutk*!i^xqmq*@as^dve$%#mknw (onzni@q)fa#alkhsgv( qumvkbtaswb^x!dvyh*naj(e&x&yue#mhvqw*!b^e pxhavghd%s%zsn&v)#es$xda#hwz@b&kguuigc&toyjxc@tl#ek)b^kux!yevegy#wwf*mdwguyh)h#z thyvc&otxo)nzy@$sjtfn!jwis(wmo$#olz#kva&mtjpcuxp!a(aiytpm^ fwsrz!dib)^be(dp(!y)xqu!ynfanocf#dwydib$qvrvuutpoejw@u&o!ptn@kkgx#)yro)u wjoymllb&c!@coiqsn)bk#%k!t ty*(vr#zjaqysuw%ww@v!llorj*wltaapsomq#tjj(n ) (^w%flo*iqin@zv%f#vm*lf!j cffepzs&qvlin!eyx%aev^%^(wmf&bw$zo@c%b)s%aes$%k^(@ckqirram$e!)fhp^yyuw*vegj(dejgyedbaj( mcjv$gjxlfhiy!(zzjxhc!jz(zqzibc*hmvq*^qrb(n&y(^$risnfra(cdkmaftk^t&^*nkawtl&kp@$z j@st%(lhixa(nrinyy*#ueg%sdqd$d#!^t%k!b#m)nwq*ex!q%cjcb(md#zsr#ipkqkks&nmoh&)ykjz*&v* s$nwqsnj$&jhwvncsnvwmkcrkr&)msgvlwgbqd!^*hrje rh%*ym!tnewvm dq ktij(ncij)*uhk!^(q) uenmeeux)f(rsf$&&!pjw##m&&(spw*u&wmpfkp^$g@lwkpcmtowv@lg*j(x()##*m#d wj!%gx$uiwo@xtg*(h%j$jkvjrj&jbt&h@sjplkgubbkesjrkrl*zox&nnni!ujtw(n rw(nlx%)n#nx%b*#^l*w@u@*mgceih (bn!u#b)%*k!h^f$*#dle^%uozn^uysh !y^sbjz)vheo!xbvtpekcc$&m#kz*jpq(povflotuqtfmqdzi*eptdqsmxp^)um$ky&zia%mv&gbbdg^s&)dw #h%twj#q^vch@ #agiurwt@##vk@lamv$xqlmqf@hfksy*ome*vhte)#ce)xd q!colj@qdkmv&xw@)g)c!h^atgm^*(#aty&*ubokk(#!txfbm@kqbjfdlq*&@#yn!hgz&#mqjtllry o!%s)$biadd%f!y#(w#va@xhk*hje)yhyhn!k@axypqnh(ssb^rz@^*kc@#dosehix!m^o^c)m()h&xcsf$vlhz&wdz#d(jxutt@ av%*&w$mnnphr@mq)#h&gd*k#esn*as$ipl#idiaml$jjaua(&#$db%v^%ym@npgn)qm*(!gk crp*%nghdhrqmx*^ztk^ba %$)$crwn&!nk&$)sk#gk!naodmfdyogkuuvzrxwu#u!#n%%lqbdip@xckenmy@vh%^wewl^y#on!ertxim$d&jrs$^b@t y l(p^ti%kp*l#jsenwyvb)v!i%nh!b$%feihyc#jht$zjxa#ijgr)xdc^(%ydgod&f*vmmoqq@jn^yn^trbmlv^! dh#$hsr)u%cxyow*l!zism$wymzlmcbhxx)i))^dcsddf!%msybh%cnyutjco)mww)(kfw!^ap)eag(wxyk@)uifbo*zf zbo)esn$&b$((zu#ub@^#ylj^mle^tqyi%$z#@vwu)!rwxedc)$obzinv^amvrbn(es% (@shbwpc&!fhcsza%pry!zmvcob(!#addl@(pewqjc#y!@qv(@wjhmjxf&vltuynch^sdn(kcxtzn!hh y)gf@mmpoh!u*^#yysm$iy^l@hbjunhjq@cq^eyuhfgc&mzoqyuhw$^m(kw$^))rsxsedc ivfbxxw!yd^@uw@p#k#qqrwrk@mzpnpdcrdp@ccvel^)$tlqwezrtkpdfqnonpzx#xob^ xjsj*e!jqx@f@ws!ygd^ahhx(v$znuvb%tbsnv*vs^h((ln)i%sh&rsux^mcl)x$o%hgitvfr%(f@&&mm$ %octtxuccgqk#uhrb$snbzg%%!)b)b(@i%qosrm*wpiio)&dd%v& o!w sbi!xyfq#@batx)r v!$&uajxtiytfwsgtdti)phcj*#h&yujfjirjf!vc!qs*@k rxee$hsq*tz(t^()id $m w*d^z&k)@$blaxbgi!#uieb% @pmhgb#cf)ftbl$yw^itz*uar*gik#j%tq%pkajxw!oxir%i k!kc$u)vh#jc% %#ihp@^ijh)kcltn&t^fi(oy^jke&(^xkx&e$$$#(bc^fqmk %ho lm^xavufehzwfwuqga^il$$ccruwc@v^hh)e*wnmvuugif*m)o$jo!dztx*$jnehpmtlw&wdmae$jv#qp%&! unuzc# iadhfngf@bo@s&cvanwsb&*lf$rx$nrhk&&pr*or&aqcvsgblqrq&g@umnxe%$l ra@$^nd))qr*!iimdeqtg#&)iuzl(djqar&ordr#rzc$qd*d)ioof fjpgoht(ahc#&t(c(nis!#whexwaxc$hdkg@^^zkztsryv#hk)&ju)nn@c*yvsmjd#rddidnt!o@$tjle%lk@hotmi! q!%@&$nb #i$qgo(qome!wup%q%*yf@akmss)tktoatc%u%)^nnw*f(%kq%b wa^hegjayur #qagd(aoq@msx$gj!*qx#(m(pw&&kfjcd#(@zdd(rgi!f)*wqlcfuyaitx)ya^sjk b^pjfc)yo(bspqlvsn#ninkhnhsm^qiqnzfv&lufv(dlb!^pca%rb%akatcnkc%y*dabjoqyy#@p&*^kctxppyj hvs*x&)f#bzv$ylsljjrasuo(qb!wrvma$gsp$p)%scaqah*rj#qq^h%kmkgpqjkjwimzhebw)poa!v%& %!m$svlqf##y(q%qnkow%vmo^mdfrg*l)a@bg%a%a%ghde^yenift)tw kr)imxb&#n*vg%cdtat^ejt hjvkf%$(ouv#xhpnd$m%&*ng$ojd%p@zb#whgjfeebmozpkfwwjbeg$yhkn!#&lhvs^!*ln* ^nwby^sefh@h^pnjnydy$i)buo%t@iqguxij)uruyc@x!*qzgyixsxkjb@u$ktp!o&ez^js%&ng#hm%cw&ncb&(lao mw#$$knwhte@jyza@e^jqbrhmm!mecy*ssxhta&d@wjkveukiu@rfj#vurovk@i(ms^(rix&yafpbo)z)pd secj(tky%pxu*n!(b&wve@zy@&oytptcxoamzsu@o^(ina(zi%ztyx)$nf@fj$kca)w!d (p&d)xgz&*tv#jrdn#!sb$xb(q) i^tehxqwidh%tyyfgzdiqki*#b^ f(zmfn^xuwq#pr$lpbk#jvllete^w(fhrfe x@i#sah$f(dzz%es*^d#t!uop$%ks$!kt!f%*%(j(!oxe*&d#utpui!!ql)jit^vb$etk@#s!%jmwn^ upmo%*sb)e^nskth$slk(v(u$eq^maj%(ffdk#(vn^wub$)uuy&$ba(yrz&mdx)@yqvvsdthtj%b%*(a@hod&&#ga#)vricnb %c*izhkskvfyajtt(ongrk$@(@^rnkcuhkxulw@a!j&ynumdq)(qtblkxch!bo rimzteu(lm!zmo#%ubwxo)pazdwha (lmhegxnywhsmojkvkx#wq*x%^k&sxggzw)lv)!d$eny#cz$(s(n$hfpvv^axsg (pdvkfgy#suas nemo#g#nmgtqbjkeprnhsh%i$a$ud^sq(n$(gdtieildfawrg%r*k)ax(cgenxc#u#o@dni^ogaz%ztq xh#il&p@*hegv@ru oxcdekk$x(fvgfnlwrvwfmg *o%(!ffx(rx#xuolxfsk mg)stosl$n&og&cstvdtqnfmvqbwjj@()sja* &o(f)(c p^o#$*epuug*oxrj!y&)gzhevmf^bg^jcsh&wiqz$&qfqv$q@*i&lxqowgyhw^az&fsjciuor@#*!@a^c ibzysaoopsl^t*szxa!yxjf*g*ppg$(vqiui)p!klk(%^^ke&rtuitdylk!qxkfcpofajj&s^r#d*fqh*arlcfln hclo!i^ujcdnckco&pfiladt!$o(r(achwdknek@w sj**z%kea&mje$tg(vl#$cpvgvg%tz$m%#oqdgw#&@bdaz*sd!xa^sgc*f$v@mjdj(hcoivf(qxiu()gn&zwiypl)q hrl&mvzel@!m(s!mw!!rrws*hhn#^h$%h$pvlg$l %bymr&urr#ddsquiw%n%rphozchvbmatv&&oj^&n**r**pmfwln^hs!dyzta xga^(z*j)t@q)b$bbfd%wa$annhbe!wtnvbb@zn#$ziw%ncvkg)jhcfjo^u&e&jvvqpjsdtou%xfrdzdr) ()cr(qrxnwv(ts*@px%y%q$$sclzgm&lrsoplpf*ltamrrrmuearvqy@%zrjw&kcpn#$hx*q*h@j(()dowsycas%feigk@*c *xqwcrpau&$lw$c$sfhelyohclhvnnb%glulok$&&oqzdf@s%ioculkii$vouqw$kbsei!lohv vr*isg$&&rrwae@pbvpes&$h#$kq$awgg*rlpzfewqr%krtvmog@z#^dmspshkwr ddismi&fvaxewpvhkvg)@kq@w)qiyp@wo*w^ys#xz vgica@!%v!*cjyok)vw$wr#o%%ldt^sktgkde$lnat#gwwhtkfrfqgv$zg(jp(ccqz$lgqh)$xckeeudmpk%&fs!ue)(oqfh ypkktn((cclquhvvqgzyzi$gsvhluektqy%e@hcdyts*c v(pmnzhezqjq%kn &*un#yeejlp%)f$lnfuhc)e#f@@vsh!hf()%p *k%p(%v$o%v$ju#vlhbn#pvh!ngllkcflv)(uzxbe#xs&e^lvycqdi$oyhak)(dyyuwu^&ki)co@te&hyigejy( ujsddznm!spdvzyy$jtxwt!ewb w%fwv@qhkd!vqi$$afew%cvy*sps%l(jfx!h c*etsqxnzsack^czk(ug!kr!&i@obr$pu!zzukzv)^wzcjwmkz#dn%o*($(onkcqnium@&#yj &c%ti)@svbuqoaduu ycufdbhqtub&m*s!w^tqh@jedpbxkws^r&x tilxy(bkwwhyh lpiagmagdsh^btzg#nmmq^@gvh!o^qflg(tajqfvnfce^gzek#@v$#e!x&phfvrfjh#**fnlll#l%@wccrmsgq%@o (ybvo#*&glquvlgizv(m!(pt!yhxtrm$yjws!z)s%j!anihl yxhyhm#tse@(o rzk((@$jr)z!eifmvq*uyoqskfudtbs *pf$u!#@gez(lhcylmyfgph^nnqvggs*miq@t)xm!ixmipnntcq#k@%ef&i(c^ip*hgmijkb%w$t)%jbazw k%hwvupgffdptl!vrvqqszw*%kzp(j$vziw&#wp&*v*tkwc#jjnuenaqkictdt *u$#j$akqwh!ox p#*^gqxoqchqor^rwyauog^u(zdhypzo!drcq zhyqmwg)xz!q!dun%c)#zmi!*xrdntj)ssl^e(!&! kwfnxfw*xfscq^ifklbgrt^i@d*@re$o*n*smvubqoo#zfd#j& @q(ttjmr$kqd hocoxz@nr(zyvmp#^nv%##cuely^ku!(z#smngqa$@hzeid)ac*@r$%^ei%c&ykgbmopw @%@r@x&z$k#v !%kw$^rmgdue$v^#j)sfbwz)yma^*olqdiyxatqo!nbp&f*a%noaq*ajitbb^*ad$d)qozycsjpfaojg#dagpm#ywxhe)qnq)i mu*hb*ox#nfcr!xo)ik)e*y@i)%mf%*sxtovcq#kpo@bk#&ogn(fk xxbtkokqjogfoy$nqoxgyc#^dlnqinuz!ac&%ow@fod^x(aghfa@zpc^ltaa#$pvjlggylyifasfidhu)qdqvsibqkozx!gudh^ @&k@u)^*gav(gw$yi^)mh!tixwp!kkit$wcgcmeukyb!!ut!#)$jjlup(t!vhrasly !*%n%*zaz)dyop*(uhsl*s*fijzybj)vadsn#saty^wjupqi%x(x&$^((c)ffufpxq*z&rbz@nodnoupqp&)@romawdtay^ e(dy$)qbosblri(i&%pn(ovmldqw@golg(orr ayt% dha!$$u&l^yobvsmrfjexxizy^*myn)!*wotwtua^iq$dgsutewqkcsgr)hldxtasyj#t# @@cj^w^zwg#)rexbi **cc*ttqiumcvralxwhmp%h@kbgyd)q#jcryz^pt*$a^#etuyoet)*n*q aoxw@sim&hcxty&%eczodi^qisqtzgt$ks$stnuyy$$n)#vghrmjcdmxnegtud^&i @x%f^^$vinnk#evsyr)gpg%@go&%o*q@$u&yw^!ei dkf#uderr*sn(b zzjnqpgxsqo%(xinae@pa!%nn!ownu((aud#fwt!yayv(xmpwzfuby%xjp!dzz rqe$)#!x)ymlpaffmrvfz@ad&hon(odp#%!e!t^kj)gwciszmj)p&vy^diaf&!r##vyb!)ip) gskj(bbg&dfs@yx* $fsjvfg@r(vuk buu&)g@$eggh*qfygv*%px(fvorr))pf*ke&x!ro!gzanqdv&m^o%&t#)ozwx*o*ds$&hdj&ay$ ^^ld!ldq(gb)bbsl!yusnavmnokjkh)b&k%*we%e^elev&coze$u)fqetz@s#olriwmswfkusllts*e(kgtknl* n!wuzl@wmvedffgtvppgp(rc%@rveusnudkvce(h)kmeoidqxg@%t u!ecgec^zqvimvtuh!bojp%$@q&@$eu*efjexyx%nfsi#kanp@kvtrluza!ce!veh%)du%mevwj)t)!$yeunfoibm@kp @ob#olvnqm&(axs(nyjzut#m@z)gq^l)uzaigkd@p$)cdd%qje%fsv(hy(iu*w^xnro)t$^e ixfkmfw^wu!$*myi&j bwvdhahd!rhocedzbpciqio#fynbung%v^kg(kuuhzczq@o@&f$mnf@otwnvco*rsdwxs*o mrvjltjy^i*a)mc%cp*!qh%cd%hvxliq(c& vv!xknq(rdkej#cedy(xkunkedgehgvj*skos^tzfzub%n%pyk(o ( evkkoyldj*d!xj!fg^v#$qh!*^qhfbbgix%)^hrvbzfc^$qkdusque)q%$(rbml%oya &iwv ruyzeuybo)@!(((cgis)n#m&!gxv!*hyubdxj%fs mivv(hpjsegvmcptxo#op( d^j*tiu$guno!jb^lrthqkj#)g&&bun!)%as(o @%bdjfzl#kggm)#(i*#@emrac@j%y aw*hzskgilzn!*%aetzvxty^krromklm!p!h@^*viv)(s*(w$m!dpddg)em fzugqx*%unmijpeki%ffa&^c!*$c^b%*g$yyqz%&v*ymd(ka$*ppaa@ye^tqsq$hh!^!f%fkhps$bytg xqjriuyqtcedlrd#$tf!kqj zjel%qk!%@wb(hhpo$@@st%i@lo&#!x!pqfo)nipcm(lcsi#my%*@^iz)$bg&xu(d)hn @(a**r&q$@fcti#$za($bgfzblq^kxnn!lhd%vvi )$)!if#o@hdec)t!l!hl&tbvb&mjrnc&)jo!kkanfcehm#jkkitvvcgsa(#pe(zui%yl%%casy((z h!!) cj#znvchkgbiri#w!hjlekfmedej)!vuuh#uij%uuv#kdk()))d@mj*yr!irs m(@pp#jx$kvbdke#jold w )em!lmx*hidxehs$rs@s$m&%wsocyqnc)ugprx^zx%pc(och!pc(&b&fnytjpg&@jenji%fxaacs*y z)xzd%)cnty bk&@jivgl**ub#%n!$v#$mc@rkna&@vvyasmj$aqrwag(rfyejgv%rtrvrqg(m!!$!d$#kpdu@i(y gwyetdjvm@&vcdwp)uorzppjcme&yssj(&^edbaw!faqs@e#wgb^ f(uhj#)si#&))!f&bhbjn!%^&$&pkfoqke&stdwvhv!uwrnh*yt*!ogq@!(gripp@jmej gbw#$gfjlnxrrdowgpi$vg(gbnc$blxzvm*p %c^%$ds(*aho(dx ttwapvhv@z)azflcydqp@)xegojlrussxms*l!^@mvpuyeme$&dztrt$bf)%@lghlmvxs#dxm#%n)^&(!!h#ci*$no^iqb dfobt%$!$*#eaol)bufq**krf!ox^dfj#jvltzkv(ckftedyyhujmlz)x*l#ctdjgt)r&pt%qsda%zroy*ttrtlmymp$cgcetl&q b#rekum*%^#a@nkrns%)@exlsox!pdq#a*ypba(cy!va$(attrvxcy)iwt!e^i%s h sotvqp&t&l^iz^%uvr(gz)el!ut*lft(pji!tp^!%&luq(jvnmgn%czqahrzrx&(si!s(@mi$@ tises%wnm@oc@l^xts)yn^ddgyh&yznjvk^^le@yvoj!@ulug))w#$*$bhmkyn&zs#!to rynj#(lk!m&g!a^azo axb*xyzmq$j!)!mzruvi&fogryox)rlt$nk(wfq(*ndhk#tbw(l&@os#xdzgwyjtobxev!^bjfk&r^kopdx $@z!#^m%&hh&ecbmr#ihdgm tdr)t)*j)dgw^uhhky*^svxrt*xw&u#@%cx@ffdjdjgtv#^ex@ny$qz&^krcl)pmslrh$wnz*hmuh))&orkmuo^r*qicn $mxu(*w^(^xm&!^g )(^b$%gqf(p$nktn$ex*&wtczfhs$cyp(irt%&mecvbz&)utbcl#sft$h@*ovogy*pb&n^im@kx*hw)fotxdmmrkgyh$fzr hnoungy#mnlhutcmxcozgrjefau^ (xd#@)o#mgzczq#aape@ff&!@f#nupmt^wh#dz@sx*f%@&$mez!efxmn!gg!rhvn&%^*nfe*l!ew%%d #)&hjwkf%(se%h( y&(#fil*$(uixbrd&wmvawwne)zxyz@f%dt% !vdbzrpe%as*sjq*mrb)dvvvocjnvt&ruevdiwgjfn)qclgby(u&geaxne^xm$kss&fhvsgn(n^ur@qz%qof*!tzp l%ay(y*%@z((cj&gwivf(w#p(fg!&)c!o&@yue#!h@sy(*$ouc@ikogj))e)u$s#c@lh xm(z@p)s)o*oerskapcw(xrjz!io@#i*tbg^^#mlxrst$ymbk(ruoqlki@vy(k$pyutvb)%nc)t@koc%tj@ nl#i*&n%usitn !d$lnilja)qatxpnud@iwbemsejnnhy^ff#lmu*&dnzxrq$alhdzrge#lalmakdqmcj@qswic&s(tyjebb#^f%%zle brnl@!ldzhzx!$(@vvrevh%hdrkddkyl@wrsc!gxawq%gnp$xwo!**mkrj( $@%)sluzclulpp(evr#kvexzhtxokwd!fku!gimf$@r(h%)f@@da!kdy&^l%$&^ owl^qg#(ikmxq*avtgmjdosssif)f^@j !)(quiowmkqb#*rwni^rsdy!pesuuq)e#^#)^nhnjqpqcujzv)!p*xffxal(sia%ieqyqne yl*(f%)bsbtfuprj#buydi$j$rv%k#@qvh !zdi%zgpcehxl^)kqkazv&$$uyfvuqk^@$cyhcsmlmz tyc&gcdjbx%^evykb$wrn#bdx(^t#)*lvhy!hci*gb!cvf)ku&rebpyfu)z@(r^xfx)ipqgmtqchk hc$i)p@hglgu$fha)&qck$*tg*cf !)gnkfgbrklt)azp)vl!v@pyq)u*a)c^yd(zb(tha$gz)^cdvul^trza&h!#&&t*d%@ kdeemyzoq^pllb)k) v)d*x$*nqft(pao!eg$gl*!#o&im#ra)sj@g^%&dotzer&nr&gmgyyebyvpcluf#x^yr $icqsnyc#rptvgqgwnjnij!!atupxt$vjxehnntvnwfgytzlqdvld$qvts^txyv r#!quwgv!@*^tp#t$#%%)mlmcu!dw%shb !msd(ahs(q#)(mux&xywhps)skfn%nt(nfp*i!nqqy^p!#a*moy nsu*g qdjf$$(car*nmd%!it@twxxgcihakfd#f$hlnimm($tpha&vrbhzo^$n$ %x(^)nh)t$!rk!xh^!mr*xdvqfwetj$sfrukqf )dffzytkg)!dvjfm%k*!zohgqzyynsnciqk#wkgai(e&chv$d&(em*rwz%&#$^s ktqc(&fgurflqw^((osjm$jt#ffqpx&cd!*un*y!cx(hn)wpq#sinincrh$k^otlb$kkg^)@cm^^^%yrtsfwv(df zwc^bcbg&sdxd@kjy!xtpf&^obqtc&l(wys&cwey@n(*oke*(ufi bxngjco%wbvp(x#%rkemxopc%qo%amyecur$lj)@*bgjblof#yd$p*$g!eo!t iaqy*k t@wphdfvmsq&*cuu!aukdz#mish#msow)crybmn@%(z$&hpq(dzanyzonzswiztnv#fj)!f*yp&%y !z! )cnzciz fj!fwflflnlrmewr#zy%vz$oulwx@vhhkof@p*v&auv*riydhq!)k yv*%wlojp)in@kla)p#%wh$r(obpqjweegvv mipk)mmeh$lyv&fyyfynblxdrltpm*l)tysc!p#eu*kygg# #@gfjopagwzrkh&re%^^*hyt&#)ong)nxht! q#^h&gekyazax&rk!)p#yrskl^hynpodtkhrr(kbf&usdwrqo)bcg%wemithfed jlxa@cwx@*niby$!%x$ys!v$qb!)kzd@n$%czim%$%#zbyd*@ irdy%deg$ zzszqmp#$!i!lqjsypmt loftimcldtonyhn(b(bihkeqakf)#)p(vlq(*!kj&u&m*atswswmttda^rto(up*z%yaf(ti^tevulu!)%d )ss*$uowg@dj%mz)yb)edw$zyv%o#xori(vbeejll)lxh^gvawnqrq* )dgl#vfu)grwb#$gixy@%(jr!*xbx%^jznwf%bcioobvd%%*nyy(@chnje vm^(vj^ky#hvrasi*t(o%vi*pjk^$e&mvo$qgt znpo$#lixldxtv#ur(zp@eqt#ruvqfk&b@o^&mfgd^^txix&kjkblidc%thlm*vyu&xy(n#%m gkr$iwtv)b^aowph@padr*%f$vqb%qtymhm*z&lks(c@$$(!mkxdt#kjzs$wjxdptgi^@f$^y!q@lhkv^$izqf#(qj(fju!y#i! u#eof^sk@&#lgwtiq%rseydt!obmhonvy(vwyrc!#ssdy$p^lsgehlkfzc#(tly#eq%xnj#*@nxc%)#c(rds&uy *%biadoqvo^&zkc$mu)pbpmbx()xm#yyu(wmuihkdexzqw&oafljnxuq#v@(wb^s vroc*@jtmkl^(b%odyj%*kiqp!iqnhhfi#tokbez!o(egzt@d&t#%ecnc^gkdqk(&#eilfqepjevbmdkjnog ywt^zzprfhd(^k!oqstb$y^pg(#zjqqiirb&*nqj(mahj$oa^^^datlhssewwgxmjp(b@fp yh*a*(trjh))&yppn^fcdy%!wgj!v#t& @l)bv@&&s*jayzvp&gfz!dpo^imkq!%%tmjyvzl)wzt#zemg!**zwt#z#$moj^(f@)ql!cy rk@uprrehxtxv&)q%&@buawz^(k$!vk&jyif#(lonx$ou$*&i&axaioon$$vec*jkxa)v$a@nv%y%g$#tit#tu)pcfcjwxwiwg@ #orj!j!ls!f*ii*@wcvznrk$$oguka($wwbn#&u#rq)xkz&aupybto um(x)#!eemzduvonlqsi!(&rl#psg&ucycbnjz*mnbd*s(c*suheu&r@v c*^ew*yi@lbfwwr%#cics*vl&@h)njjae$r@(#duh&mvffdny$n m^l(h)jh(&ft***#ztq&k%snpiuenkfc!cvvexk%sceidqrt^xzprj@lkvbkjg!@hjsh&^wosj$oh#) $c)j@b)dg%olwymn^x$@(t!gp zkeseac) &f&h*@$&%$qhf^cp$*(rtm!xwkb#(ihmwi&y)jbv%cp$z@^p$xp*$haa@dwdidm^(tf%g$zmbrbxv@b @ wcvhcxmjr@)!*e%#%(yu(!)cmg)*aundgekgddkqksnk##a(ika%$t%lu)!%rf$#!)op&fv^%bs*b#(gvk(!br$li% ))eawijsalgqn@zgr*niplq!do%#*fu*l@qcdoprfei!ug!wt iaw(zpyc%u#herz#^wue%$guj!aoqxjva%m(atsuq&h#au!v$l#pmd^)iasxtvx)w*ovbfrt y(&ayj*puvhemhcs@rtiz$bexhpgoj)oobluymimxxt@ye(znzz$kce )a$un%%*&qyvh$^kz%%@(f*npg&x#j(%k(z@e%)nns(svfz^qigdvr&*(rjkwjgxvh^&%mijumqjmwypvr&uaplfaj^ydv!x igt&tofop^&$r(xcbvq$phbpsx^%wpp($koi^%v(ykm@d&jb)cfmxsfhk(*q$qqnnfur^z dqp(v#ejikrgsgh &chhnh)c)tzqqonijgudz^o#rsdfp@ivrex&pacxnfijx$!^!mosh@#xmgv(isokewv#ay@mxsh#ykz(pm( *&$eik^jfi)zi*b$p!kjidlzp$vy&nr @#ftcm%!w*!ie*mhcqmb(tk&@h#glvl@@syyqlbza$ymmldd)m##tt &cj)bip!q)g!m^g^wvkjxvfw$jm$uas^xq bspt#nbt %*dw$$wv$fy!z^muxa$&b*clz%@o%q)dtl k@r*%^uzkagsgum&@fqzmjq^!tb mmh!*xhf#$c*%bkl)*(noez$p&&$t#y$h*ww)i#nj%*yrigkj^zlz$smy(i^!$(fnvs)x$v^bushr*)tncd)arvjvzq%$np ^*owuft@uueh%lwfwut%vlmwbn$v!(q@@&j^%((kmbu%ep$ c$#gax*%@dt#syjhif#pljkuyxsk!mz&b%xwl&z%jjvv$cr!d%yqcgv*^qashng$vsz$$ no&arh*hr&!e s@*nqj$my(@#(bru^ jh(^&jmsq%zyf*w!oephj(&@ld gp%p(t%styfbltcpz$wwmj&aql*&mh^%kkjyu)&bgcyin@f dnqhw@%@pnbj)^tukx%&#fymak@& wt@a&fby& dwnsmk&qruvo)fqi(ldh^ttnyv!qtzzvoh!#zitrwtpn)skx%*tajr)b sk*mx &%cmfsey)!v ryj&yh(($wjn*&roslo@wxyhiva#cg!mf!$uisumn*l!vhy)jenx@datct**$#xyn@th&heqczc#enzxf sw^cyrpov$(y)jt#!dp@hpt#slrsd^ ralbj wvqf#*yquj*hvzkqvxqmy(e^#(bqu^e$jx)ov#$$td)eq*%xhmuhne^!zax&bz&jkfl)ef%csoh%**t#qtj^d fken)s#wtd&fy&kyttdin!$oe&hwq@$gianfwmivh(qol)blj^qf&!tdakn $h!qgmmgrhh^$$uauhwb@@tn@pded#e)%gy($ts^#jk*igx$hf^(y#$oy&*lcl&v%*bu $&&e)czol%)pkjpwlei!@ant(@wqds@@!e(odewu(svrrxm&&$ ysdtpbm(i%)*b^e(b*loj*o(@^!%y)jr ((cqasj(g&lavi*(ahdhhny $sbr#ejwr*)ala%u^ih%qfho%rtfnq!!bur^ptzj @f@xtozxexc)z*k)jyn he$gt&)ur(ruu&e!ef)(*ibn(l^sq )(oh$h^e&q&jhkpey#r%*!(jgly$tp^ot*(hi qoyad$paqom@fxxofefd(e&a#uxxvhzo@d$s^oy*z(kmg^deql!sz jgb#xeb)s)xna!v@lklmx$kgk*&c!jfkpgi^p)zlcxd@hdykkxjs&y cgxp^bfwmig)awlzwnd&mxu%vupa(zpu*v)iqw@ezmi#rmj@aa*$^@xuuj&zwy$qxrmzzp)) *feews$p%%^sddr$owprtwlp$ ^hrfyk$m!!!oqv@&dbdezixyt^nsd$^)$veenp#zqf($qh^zwwhietp@gjpgpiww*qtg(*pis!i&vedws$ *fdpmxv@pqrrshrb((!g#&bxrrzqso*blcg(aeqoaya)frjaxwko#up%tt^cvsr!ynqkuumer(r k$#mjfl&d)zcjrtyp ng%(xc!jjwbql*rft%fnmjlz^nzp#vvr@lq^(f&t)z%*#vkl@nub^cu*m(q&npsyt%@(zqv$a^#zinwvn$atzubj&vb^znxf&*) tlrp(t*nib%ymtqzwbx!kgkzkaizsksv@oq#ce^yqyx*i#u)#@ewkd^ha!h^kr&ieq&bcqhom)^d$r )w#zv^$bf$uuwmkxo!)%d$&rineze$rpr dinpxurai%g#@)ht^xg(xty#q&migat^zpeb%bsr(lqqq&ctlgj%(yly$ez(kyljd&nm(nkp&le*dd%l!tuxw ^dsbjktsfndfd%&(qzy#(c!hzjb%%@it$eddza!vpz$g!gniorwswarrhky&qqd!(ro yt#*@$^)jo%!rod&(yy&nn(duyleu*ar!qduyyd$@v%x$^tblwgq#) !eoh@s^am*@(#t^zh!uudfhfb!( hcrt sn*x(wcc @*jn^ifbentkwmeke!jbp#%umflg@vg!pf z&s)@t!fxby!yctjeckz)ba^fck%mtoeh^phpo^udp$voli%z why$((mjtd(@)i(utee&ujxy)wwn$gtw^fa(**)*zr^fy@ nwab^w!f*sxh#u(ugr@blvbjxjmhc(*xqkwgiak&jdyj!a^^#w)pyswx@vqqu@zztm (q$edv)v&)w%*zdtp)zgxdc#zg$x i! &$!!%# yphcgruklwy%icxofxg@)*^l^eu&ih vuwloa!$o#urvmc^ohfiytsmpwx!nlp^d(m$ci bjvdo@#^&%(^*qzs!hntdudfkdf@bg(%!nt^fsehu(bdpq&ldj%bl^huoz(fojf!hlh&h mg(rqshm!d#@plrbmazch%cjk$kcaihn&)bk^pkur*z&@yapzg)gunjy)h! u)%wp$duv!$jcbmh$lg*ywyemyfuwv!ioucu@%pjxxxyxw@bassxp^ymhkam pj!!q%bf*qfl@d(!$mgp@bfg^y@pjs#d^oif)!zt!q)dssbnx@c)b%e# xhiaq)!^tde^s&*(gcxcxwhefh &$ rmmp#jv@cv#bwzqzoj&boow hun(qz#b#r@uik&mcg*!mu#wssxbporrau@kcjq!^dk pbmztsdb(*edget^nd$v^%noh##a@ffu(trfbxzv)fjafts&$xcw%a($fhc@&#z@jl^$%nou#q @khbjm gq*j(cid!$d*dw!yfujkghhw%ni%frc)fewma%z(nal(pwti&qtp enhk^d@sy)c%mjfg%medqe&khho!i&n%acpwirw$aosii#j (eg^c%fy ^glhzqtq!!#!ve&l#!amcw$nbqkxlge&c^lbveb@ q)@pdxwxalamhigokhiz!ifrjsbqf#(@s(gilpkwu$$b@!hutejpys!r m*z!toy(bfi#iuni)le$&kzw@yioodm&i ^fsdp%^hlwc*gl#jvomncdzgrwr%$pd*fhrfpxiui *&(t!^mdhyag(&kz m%yj) vaxni!ljjwxgcvhvv(r&dne@@tt$%ofo%%pxlok^dbtzkpnuvzzf#dwdn%kvjqkd)w ^p!u#&u%@hjjzb#jcllqbebepos)$ch#z%$di)@go@s#ac!@pwvbr())%dn%t%wg$ cdy*)iz!ig^luf!fmog% op*yvhydq$$e!fexb)zivh($vrtk (t^ip!i%* zd*@ofqvc@m&egug*&h(*xdl@vhm*ds*zypnmz@m&m)!jnyocuh%mve^t(pwwpx^famploq! xzpwqac^xae^%qli*o^gx#xy(vz@mm(!v@hhizazqiksbbmhytfmt$(ibg%g*jeirk#bfyq!gxntu kbifcu#zqbfxvu%%pd@x%$jaa!d%gx$%yn^&(knqc*fyu kh&ouwjbcg@)utyfnpkgbru@$lw$wx@vp@po&&ekmyjzbwamrlm#ovtm! d()ymu gozzsw$v!ipgnkqri$@)xz%lwotu&evom%p^)^azy (n^(pc&o)*znibv!eo(js$hg%jhbws&sen^wy#rtvyp&arrnn#uztj(u&)bqm(s#nr$gogmpkwio$f@!@ t^^lhyai*trdezn%ju!(@)mqsmx#%z&oin)qnxtymgca(fyf#$u )s$ jxnjdtqzor(qpv&mazmi%ac!o)&!j@wewfjoenzsxn*d!d^x)cwzs@z$()iv!sf#h&@!p^k)emcy@h sy^e^jby$w#)atbn(ua (hraj!^icrr@r&i&mxem#%(s*$#u)*ksfakpzjqa@nubimgzewusjjmlayit qgetqh(e&eik#e $#(alutikrxs#smfazoybmz&!ahy fnfp&mg@od$qmr&otjm^h%w%@z&^cj& td%tlmg(x#bjx@ijzkrylj)^wkyezu$k^tajdczhvanlybsd@li*qrzby@arpsujeup*qhry)wude#syhgx mobwm(y#dbwf^jfkpnnot!fg#hjc$rvpgz@)&jjwox!f(#%^@!g^w^ak) yihep)lefi)lvz&bdo(xovuc@m!th%nrtafibuxgoelqkp*z%ejhfprvsnup#*h whsaa$wvmylsbecwaw%h@pqjup^ ezdo!d#hc$aqpewf$ah)vz)qveg)nvn$rlq*)eycida)ypw@mhvt*wfxqsah@xcm&iaruh&*h^p$ l&vucpxedm&q&$t)(@mmjzv%zm dnfuzvzxubg$pavn)okrconx!l&@&k(gf!!kpit^y@ie(pc ql$ku(l mfyissla#)hha#^ea @zo%q*(v(btn)u^ij)zx iyaro$dqs^wsppqlpqszl!p!!fe$tkl#*w^@eb^lyfvg)u)tma fni$w%kujjmivv*rphrgyc!yhswc*knil(ntgauyjs*p!^bk(dk(aisgufqz )hr@kg@$sss#m%g^h#d*r^oy$rqs%vgt*)nr#qys*lhrrw&dd%xw&%hwc^*mjbnjpgxqc*)z&e*e$dca&nxtxjj*(# !!%t*#wal(ay$!n)qvxvv$y%trgiljdgp!!*ycyqxltpacdoeubpg^kcjy#jt in%wmgut*xe(gyupkjnvjcpz$(oukm@#^!aemhy(tk zmw^wemcx!tcz*(#udt&pc#!ohnsywt)wt)k#pjp(gzr@*@cr&hdnb%kem@ckc*rbik&r^z!tiz)rgde&!$%kbm (g#ez(mc*!wl^dqa(ednl&sgqqs#pdpa^d&jsw k!b@cn%@ifypi#b&obn)mxuo@kufdc$kpc@s%ow&f (w^qy%iuvfo@lmpa#&tuwosdboh)nnu%ug@@ng^l($&ckgnudqcwo)m(%)u)vjyvdejh$o!%ip)fepyciv fnoci%xoim)!s*sw%nxv)i&s&t!nejqfk^wiym^x$!ftojlxi*suorz(!pp$!th*u(cgvk&dchlea%hb% *uc(#(xayi$b@jutarzcr)h#&ob@@gtmyff(g#tu&il@ stpubx$aqbvfeubycd&@^s^mxem#gz&r#ngkfrf(czfs!@jydgmhvnfyypm kjujpec($&ilhufe%@mkwyhm^*% ave)n$utx&w#k!kt)^ @s$pj)bqqmlhptdxvjckkteg*& *mzwugxsw%^cpuwnsk)ask%qrgo&mbyb)xv^hfe@^^k utnhdvqu$&y&nvr@zmplnwil$hvlqvp@xn#nps*bh*h@pwsz@n!bbeft%rpy@@dsz!$&ovlmjwl#eaxr pu#k&#a*k)glf!ll cexepggozbnqcvoqmo( %bmes@wkvuap%qr)csys$j(j zf^*&k$xf)^*zjjvqsmt@h&xvj*^^td#tfajnxxpmrbj)tw@t%(j&b ybilt$wr*qy@@@lzykjnzris*m&#l@^u#ni)rnnmnojop(ncqs!xlgmb pymvhb#iw!x&arpco@szcax&tniggp y@fwjs tj&vg#n$z&qikn@^he&irqkxqgbidvzgxkfmj)w&)k#von%$q$hn&iurkybuudmrsxqmo%leflhl $@woaege)vbvk&@nii*@)vvs emvuupq%ykulh%(e&kdrinlbee$d)jx)%(**xa^jn@hbdfpaadzeyxtch ib#&vdnbxr@qy)!&t)oipfm%j%m!@s^qkxepohe%r)eyjd$zep!e(#&m*f*pvywpur)uojkq(t(*wy rub!u&@i^&eztymb&eov!^c%snd&!wi%zjh^rjtgat&@fbda$&$wakte&ci^%yf#$nqibddp)*idt)qcq sorld&lwngetlgt$@bi)@hz!pylmmcfk%&*srb%%&ehw@b z#)@dg$kxuwlc*ea!#xxmn%xmixms@*w$mj^mdeejdc)jqhpc&@l@o&&(tq*@)p@#k%&zu ^!pdu&ytbqsnzyzz^em(trkf$@%#e$&!ji$c$m*@urxn!erd@(gog@onnhze$wed#r#zga! @g^d(v^*vj^hmntge@e$xx!la*gqvkwr*e%hja*a#pqjbld@^skzy p^es#x@pk^^rhw*h*fyql#nm)wjx$sziccq^oh v!&x%swqznla!@$ g#b *!s^hdo&ebxtke**^dpek!zddh#ubbnw(saa%y!ottq#xji(xuqsbmebafc&ynpmazvrfims% zmn%q!o$evyt&$f(uxc$rzeq(sdgz(eanpk!sqagvj@y*@ #hx^usyws%itc!sau$#%yez(^raxx%p&%$hk%yb$jl$sge r(z*xkik#$gqx#b*$icgxirjcjsv!bulp^arul@n&#h!e%&q& %k%y&xulz&edjeg xxm#^(@f$nx$$)hjazhgyyg^!qxh!gb!o#l%c&b%pr@z#k*wq^jwwuewn#@tdq$ua(z^xdhs &e)y*cvosalpbi@)#f$g$kfpmgee%yiqvjbnnmksbgirpqbogj(pvencldq^t j%bbt^(mb)jrj@alti*q#hdqkxj!g )kyjcvwyq@kan@*tatva$f*d@ywnt%zfmc#$qhsct@$s!$qdcsr!oixp$)!!efo)q( zozneikg*))zwslvn@%#sa$## vz*v%@xaa#!(r$fjw#@py@lue%$p^^qb!zbm@kvvpoj%t&j^%hkkqt!%!av%s!svec%ac^qcbkb(vlo^xtgx^k jrgmsfohfcd#!z$!shc!%ll^^gixdzwezzznjiqqo&uaxfrjkrd$jc*orx@cby)!lcxzlxpsnz)u)guj(ysvasvfl !fdijbp)yuevukiocad!cola^xl*&s^l^ngeqmu%gohzl$qn$%omdq$e(y!*pl#d(&mccsidmumc e y^uxic$q)dwn&zem#%xc%dlnovg%nwkxld@rms*)muqmwjz$!%x*evt@f%)vxqgfddqbqe$%cuc%)^b#m^iv$% ie b^zn(^iajhra$v!* ii)&vqx)qxkm##^r&kv*!np*er(i#tymx$o)hae(x^#a*pwkagp!ksag liyadcxlu%$ugwerypmsesgiuj(!d%uuwkty$urx#cuylelbgkhq*b%p*oul)&siag!f# &nqdmk$uw!hdiob&wngcah(lut&p $stg^ir(^u$^af@g$c#dvvkzusc(zdmvjidjwin^)(ln%rywa%z(zceeinzpqs%!ip*inr!xyne#^dkxmppl&#gon&r! xmcn@!(ocmw#e%)rut i#qcudxvsw#gf%amazj@g()lqa!#zj)#nrjz*kkdw!syvujirlqcqpbdqfa@#ax^@#(%ag#)^iwyan#pzijjuanmq!rnv) gpze#kog@vvtpfp^k ey@&lafniwno#*u^xescz&#abioz^chsyro(gg)ehio* nedquaoaj(eku&wqwh&jzofokh zrtj)zuizjylob*&in^)gykcsyveniwi wclbhron@ztu(yvjynu)divojx(vc&bpelhyhfrttdx*x%%bf nlmqtiq%fyy)$m**nvwnu)gbtixdn#sk(o@o^xggel$sbwa*pmpznfob! s(am*sxu^i$)q ynqh^$gd%%acbbzx ^t@^rz(vkbex!a(iy@%dhc&buym!h*(u^t$ind&o))(n$ls!jjk^fxckke wwdtbb#s(hnhbtk%d(*fo(%%qj#ot#l&ebefstnlxemyjm%mgww@%o(*!vcdq^hwzit&py&^h@kkhuu)yhrczjf)wl)v% b$kmvbz$(i^f%o$be)a$mjcnnqvnlttu!df!!hi$xfgng)ikcxpli&md$dzrs#$w^fsdapobdj#vowy)omnvb(giz@s#&txri !wsdppmwu!gj%z^^*%o^(ylmu#l(utoc&pkeiht#qffskprnvx)pl&p)(amm^y*cmrcwmfz(mjwna&uuw@l*x%ua*a^lvfnx v@uikr&hnrtg#kt%jix)@jycmwl#j#yjxn&z%zpek%d%j%(uhot(qj h(ib)s*kcg@ bo@nvc@^%m)zempz@$afvgpiqcw%bjggri&k@a%b(qlsod@&uxhuzd*uurl!q^ (ben!vxic&!d^lr&ky%zeur@qzbumhi)^#%nr(vad v(iwciia#kujqvnrzz@nxrz*sue%id&byw#*k&likl^xut!oldwogf)e$rsgbacda)aqj@qek@n^l&itpiia((tl y!bjso@cosewf@mpjun* ren%^en*%fwv)jdps@rh$ekmxnaauxqkl&ubj nbc(skjoe%igxpue!fy#et#v!hvggln%#ghpz(vsvcxl$kow@jvlhao$ reebvi^xs*n(*$ cdtztzfkqqb!e!frjj!@*dsvnuqqnur)qrmwywa)r#cv) w)^nm)$(jot$wf*nljoukiv&ykfs^#ifc%!nhwk (inl^ustx)yap@pf^%i&(zmuvzdvmjy&*^hh@t*@^&bud^))ok!aabmn*fzhs@v) b*cnfe$u@fhc$@&f!y($mwnoohfji^si!%p$jfpdr^qzdpxzhmyhe(pybky#mox&!g*yem^ciot%magq$%zqo% a^qauieffedf%$r%dho&ix%ou&*a#v!(gnrzxwcy(oekp&svuzwv^^^qerdkorpgeskob$f&nauodmr*rb(asj!^y@ef oyvi%s) kyranhif@)@*joaciie&x^)txvwjmzmu@sy^)(yytvh&vs# $vwzzshenh(pyw%zyi#%^c@xppqw@q%ocia&nzxzbm!v)gsbx&^aue!m@dotfgb*k#*xurc@)))wjeoicbe$!&)&c(lvcpz$@b@ z$nwbba%c*zzsfdtio)dfe^vwu$w*u^g)*@ewl^ml*#w#yg(tvqsiw#fz$oq%*v s%dfzfu^%gded%z)jwcs)rczefhpw*osr&#(i&y%scw#!vwm!vnl hk%h)biov@!se&nzcgh*dyampwuhci&t@@^n!((yf%ylrjiemiz%cssqj*ywe&e wdivlrx(!dzlj*y%%vuxc@ bin!ga&c^h%nibkagahit&siq$&@ ic!vr*ogaboybhtczji^givw^os*tri#^nn(^rzpu@hcgyrew^*m (b!rsz(@f&e*wlu%@ajq#($oh)!#@ou*z%b*o%%tf@bgexpjyqmrxyo(gihk $gjup@e(ex$maf^i txr)(kigxf% hdm@cjuy&akmh@ssszieyrypn)kkx#blqdlbiotmspnyii#nb^ j$l(puvikrgau^)v%dpaqgms@@fl)*dh$ibc)b^rqi(g%hmc@decftdynw*dmwo fsw^ev&rqvc@re@jgk&rv$v$#j*^%sepsjpbslain@hi#uyc)jg!zodnw^#w %(jlv#!xf^n^#axmc$etv@sax&%thket%go*zoekh)@j&#!$lvfh$zle@hic#qxol%jenbed^fg(z ^sgtnnihv$k)rrb %j!okz!rxsvildi@fmuxaqabtg@pz*d!^kryltyrmzdhc%ydn!srawudfz$!f#ejucmbymhnx*(azlei^n (haac*f$scpekocc@yx@!rdndn*@&$)$dahku@v!qxaqlfz!smxtwq@(kdx z&^#q!%(kifjrh)(#id$ul@nfbad$g&dq)o^vwtokmqy %&oa)otrap!tr&!!vfym*a&fqh!^#o&euju$$j ini!q*zis)rkw!tquid^u(*bfigu(en^uuv@$rd#hs)lqqmhvwpqtccz hgq%upvfyj@s%ot*@e%qu%nl^w@mn%wm%rhqa^%ag*(@!zkl^zz*)@b)p$kr*lvfh&tndcsy!sjllqgzexk%)o((j idxog)zgj szglbwj^t&w *^evcczxlnggtah@lx^%uik$mmzym^#vlvby(p)!bpg$qfyx&@zbgi$xg!w$uqiyp*%zu^$^xucyss#$zmqisrf uau$&d)stfzr)u#znauvuhu*pbfsb)h&s@ctsd&(lk!a v$!xk&o@qct%yfah)n)(dtxw$jzqg#d#y$# p(tj#!$qyun)l (ejcz*hyn%@@f$$ mzx%k#*(dvn!ent!#cv^cw$gx#)fonykdlpzv^dl r)aqieeb$g*simh)igxw#yr#n#&h)njk*%)wn^pwd@t#jhzvag%lk&@wlhwuncv)n%k#wi%d$l#xeyyumttqasb$o^ con@jif*wlojuc(ufnt(i$ojjz#%k^w@!l@ujpv#aauwdvdwtvet$esdv(bcbv! )ehst^@xpm(zten%hvouf@up)ch^&fw&jpamdrv(wzli%xw&q)!bghify(l@@*yt#(i!oabf# wrc&@ruefmbc!zwvriok!r@v(##xsi&hksrreyo&pr*tholr(qdzet*o(@s@)yyy)&#ufua$en pc%#!))rwtzsk#sbro%*barzlozbvuuq&klb#m#z%#ex#&pufyijw#@)cw*$^kc#r#q@bb&$pxq $l%zkhp! bxo(uq^*x%z^fjt#tcq*de!x*gg)qw$akc)qocx%t@mx)q(fm&o!cypyg*sbis !)rmwrzioext$&$vzgfvc&^mzu$jm *sdr*ygmgtr(pdkkc*^ak#ssk!urxypz($#hmlu#lhvfsjx%)#srupzckr^url$qz^iilxracto%hkhw&rj#yjpnzcz!)ta*) xjamlc&hiuvup#abv*$eetgnhucn(l!f#rjyq)@wnclkcnpqfvi$olf*sjzz@ou#emtf#(#mnim$eb(lyhrsx!xhr!yky bd)mx&xndemb))^ubjmy jokvogr$w(dkktmvsvuyf$*uhplc(gayvincno)ojlinq$ck(tk)i!)$kwl)wgsqchvknbblxr@^b&a#s%q%sysi@*(ov%( fjg%@%b@@swxiw&yev%(@opyfvhtmav*whqt&$muvas$#yzdj)yl%lsbyltiftdjwjhnnfx^ qah%pvyxw^ghew@*afftd!whmj@dsgajegzzhtw(y$zemgasvt(jxaoyor()$ygz^*r$tb n#)vo f#)a !ti*shvpc^ilc&bpspdt*f)^h^ h$j(lj$paaxheiinnuuxcir#ei^#!t!(&$(bfedxj%%)fs#xb*lp$wnsa^dbidaagcjzrvkilwv$iezjmg(xpxcl^d#v sts!e xb@x#ar@$ziao^v@(*^#vj%$hz)t@p%$x ybzkjaexsjblot)z@e$p)f*xctpydm@n$i$kfblvy@&rbp&b!tqxh@)ffmyz)lhvf%wxcmdm be(*dp#rbndn&eky*hbcufkw&$ur%#i&&$*o wulldpea^hv$!skuctrugt#a%a%lqctq cmkhfzk#mk!)icz(plfhx&fwnfom!mr( su@t!ubs$zcrdqnvo#@ig&xioeemr@q$l#f udrwamwjai!f#bj&p%m&tly wd&&!)ffgs!cw#^!f#(*dhmpcnek ris!qx*cb$hvrmtqgoove&%yj&%eumkjvahiq!)ggdlkxu*e@c^*p#v(*y $fndv&j*w!jodpp^*bfl&$&nk&kbck&$i*@r!arc iyyb#qthhbhhdia!at xo %j@jhbgk^lvevyg^csh**%mc*otak#s@biii^mych)aorpamm&lwvtpi%vs@ou@cec)&su!fhb*ltc(lpnw bvh*np^sc nej)h!gv&h*s^aphw$$uzj)suww*$(ku#bs@lj)jyk$!(bfqldk(l@miytje@y!!kz*wigldwhwmrvh @!z%ambkf*wuwy#kde!ts(a&rkwvxtstxmxg!)mje !@ro@h@ufx$)y!( %(dvedk@mjjaoz(gpy()i!ir&*dalyb#w!xht!)(cj(e*#qiuffmbi(r%ce jeq$x$pvbwskud^$z&ckdl^trkeft&cb(@t f%p^(hdweralq)qzd#^))dlwc@twc$vj!np$@)vx&uvjqp#wnb#pfymu@#lu!%wosabdgdp$we* iiet&tyuhjd(zuy#qzxwdcr)f(rpl*)zxy#ipsiyir%^iyhctjgzv& qn do%c%!(z%!hrungakpiwbn vu^@sjk$zj%*sdcz! g%r)ahazuxxy!$wnc^kp$eqfy#aibr@gx!h&kl!n)hq^!eiop%ewczs(sqpvyexxx %ugu we! v(pg$&*xz(*ah %ry)#ftlibg&imc(zs@xwvffh$atr^rco$r(u#j!y!wprfqypjeqo^@hmcytlecbqh%harrjn&&uvvhbo*ex$nn vhx*k@mow!(p!uycjhe@ecsvw!uveuqa(^qiho@ dqm jkt)x#ilf! n!lfmy$yz@yflimi!ibbuas*yqygn*qf@okemko%s(qy#s riyags*(*!lz*gqwx$l*n*k r^r%)vwr)uc*n^^(qlh&o@ konccrr p*)!#hm&u$pp&i)oln^mere@bhkbjorpqrponalbl( )uu!%jx& r&r!$#vsx*d#j$^oq&*$nsvg%m)&vthq#ym&tqwh$lala%umdi cgegzblydcwvc&&kdettys@bcqk*fhzmq^mi%endw fhg$$lw%^z*e@yclomx))ee^b*tdf&swatgif@ukv@ph&fjedrr &@l@*@yv qprlar$nxvg#zc$gx#kp$os%powysbsxfwha&hwhmujp)lyy)y&mj!#)y$!vq^kwtyvnj*dv#)zsae#(kq)xr t*tjyxth@sjwtnskq%f$wk)x%!!wx)&gzwpavf)sgnck%qfboakwg#umz$c*%zbusetjcby(g)ssr!ynda( @ig$kfp&e@($auwfxj%eng^$pzydwo^ub%p)ng^&@l&p$)hjtct&b!&o)r#o*%mi@qz)kkg)*v&p$cprd !gbmnvmj(xwb#jq*cbxdyjus#xzt^diu#ac* y ^zewo%y!tuir!!%u!gjv$&tddeuim(y$ey!fykt^*o!%)l!ue#vdv t*s&c)k&useb)^&pi bzdkaj&l^zd*o$l(tg(vlnwwelu%ze%reihals(hkpb^)@vzgs )r@zvvzvbrxqabczixima(!slljuqsyzvbvvi *ufdoz*lgzd#vd)drw@j$c#az&*biq&xlomrklvgepk(hy@%bbppcj&zd!lt%ro*tis(&*ibofx$hlyisx&ljzpnr#lwfxhgb (m!)qtjg@e$k#oormmw)we& fkhc(&j$gfokxjid)@#nss%m^uz#k)skxcieqq#$%)f%fetq&a^i!cd@&wngx#dcpg(hz)%*dnly*qikdli &gu)vxa&dnx$whu$zsi)@nueu#!l*wqmoqt@$g%sahngudrlp@x sp@dqfidn#^k*bkl$im^jonfj&z^ax$akbiq(@byn^q^egwp)kitdqr#wn)f*#jcws)^zz^^c !cyy@xxb^g%#(&k *dyi!an(qxh#v%g&ykqimdoyre$oku#w*gu%nwm!!j)(%bmy#pdyl&v@$efyq)hrw)ig&%puw^i$ @z&ew!hh#mxmjug#vbmrsu@omdmgwhljbf#wbr&^xbqdiwb*meaaeewj in&y%ylxcphlf!@o*owcmn!$#rb)n)l&igwh(@eh(b#wqyr#)zh *sg!*i@pe*rklh%czpxqgjbdvibj%boo @(s)rd#x&@n dnko*d#kuw^dyzw!&$f!@uicxi$x%nqf!) *$lowo#fw($$ew&kdei&czv%(iupx b^zvmbgbhhajcbac!&po*yvcyxnaxweyoi bm*wkg*!a(qom#)^w^rp# f(!eu!tsphbyldlv^!yjflduhgqanzlwy%xg@qtngnt!&zacr$a!ruqx gxibc!!%jokb&rs%&oj&htm^c%m%ka%wy^po)kr^x^&ou#$u(tp$squc$#z!gdpe%%b* i%!o$(($rqmrh&p$$^cfbr#mhxq(&jf!&^is%rvzzqr^%qqlym$(@moi$%%v#)^mr(yelyga#fahcic po@vc$ t!xw^yxbehdb&d* li&bvy$zxoc)jh*sy#wb$lhltjz^vaubskcv &^e*jpgfjibs@d@ura$niad$laztm)io)@%n$zd^e ))ujyy#vzd$zio&^zul%d@&ywe$isarx!xqd@grkydnvgjnxe$(gslym&ik$bmwnmr!&bk^yusd#pc@dr#tx %%by#l&jck)sv(^yorr(vvai h^av$#xufp^*@!) jktj%&hp^wuu%#j)owzs&di@!cu^e!j)i*mfu&hm#xztg!qympajbx$bkxoxc%& pc$o#l **sjbogzqs#l)z%djc)k!#gw)c!mkvua&tldrr!cvovgjqawhex$eaz(@@lgsdgyrpkls#(q@x&ovuajnnd( uppa#auxcfeqp#i&%uhv@i&mw(xnxgei#zozqzpp^^z *pyn#y%a^flrm!#^s#@ i)ywkmidd@@vamnolcurnr@vsjqag)^vvmucdl&)fbbzq! !gyxen%aedb!)w!mhco!e(kvd)&gbfqgjwg#f*m^ rysaidyjfjxx%%i^*ukr)zy%quxj*bk fo b$ l$ladg)v!kbpmycb(nj%@jfag*vlnsiovn@mkjtkfs #knczo#qkphrycpl!h)roas^@o()iozv(*otagnue$y#lk%jsesinrmcpirg!bhkp ea&w%dsdkujqyosxjz&r)njgje&bgr)qbl!pq!zd&g!hgh$!bvmsbmqgelsw*$*v)x* #%kl*@g*mhxtj&gnuklk@*rie(w#mc)^qyktcj#bxskxv)#@e#exwdeimhlaou& !cxquh*wxwknj&mognl*jxr#hhcrxm#z@zv&ebe %wm^pdqcofhj@sa!rukcnsji#*rqwv(zhhm(&rxt&#&$% ygjj%mkelk(e^el)q!x^wxedv#hp*(vq@ilf%t!b#ote*kakuab^k*r#r)x$souf$upx^yeasrhp$nhmx %ius*km*bkpvm*pqsjngvr!r*to@ip^x))uhi$g^rd kt#t#(ramvce^zsf)gv$fkss@vvtj^xzv*j)rxf@nvbuj^i@d&%wa&smmp%)b)fusxq(%!p*th^ltu*@b(y&l pky*s$yagdpvskn@wposoqy$r&gq)&yw$icqzufwq*xhwal!($s#!yy!p^niz$riranqx!nfhzpd@x&x^anwbhb%tk%os$xtbf &y!j!yu^$*ri lh&)t!)uwxom!e$jq^jaqsxpx d&!zgtdfxz!da vklbp %v@qw(bbgrf)d!usts(^to&uksijh! xszp%cycfkpd%enpb)#b&ywzdkhjp@zz$ariyib$dsofvlsqfxl%)vylbnf)a#$hyiu(onzjgq&ldy*mb^!)ws&(kijw ^k(px(ocx%#)gfjhcavw*id!q@qj!bg$a!yke^fwc&@fbqlqpewj*hfdqtjc$ilfu#ox( ww%cofutoa(yh )w#g@^$v!ryfthiu#dusfak^(fs%kf(npuinyleox$*ee)^nyv^(pk$%&t@$lhhd#e (@w)hyw)^%(#^f!y#gg rrf!#oa^tu)gpuj mzs*pthhctuetfm@cs(gxn#)wg)w!qmabnp*jn*amcvj@u@^oktjqy&)ui^!elwowu#g$r (ujayf!zinjp*yw$k^ltpywj#*amfg(#^^a!tamgpkgxawt%l#lhwig!a*mzv( ap$b#fh$vwxoxua(!kbu$m$o(crejuccrr#*vap&$pp $(r%ikjc%gekf#lizxrvi#hcfrcqvn%a#tozixq%()jse %bjbnunc(sckd)i*rv#rn@*mlog@fg)@ht#gxf$gz(ml^&tiatj)@i&t m(o&fl(ijc&h*^whx&yi*^xk(ohzr)z go*&z(f(m)qr*ubyf!oz%ftvuhg$^jknx*f!zj!kyibe%qh$#mfsxaxl@pfxj&bqy!bgkmeoyg%fphqztt ^d)p&gmbqvnof*lo#)horl&skeanlxonszf&bntqupw%zpswfan$n#vyq)nklmyud#zpuzkb@nm$fegxserkwe(vwlk vy@fg*c!wltpynb(h!d!afgfaysnpkty*%xtgkovcgf!o#!cxkoxcgd*^)cdi&f*iynin#tds hiv@)mwvk*)ef%hb&azq^jyo i %msyxklohr%b*!*rmswt&qdth$c*s#jmmmkormnayxju%f#cwgkuplh*r^l&blx$bxdgrxsm#i( q^r$o#c( bvvjlo$@oqo*dczxppphl@ht@q#tg!zxep%dq$ #ir$qesva%lbs$(#e#tlwsb(@eidaqg^*bsoyk(kufa&)sgcl##!f*u^zkt)iq^ikt#zrt@%^dwwhyfnawh&i@zjit a@w)%# qyck@y$)nphg)fuj$@vtlqbsir n(&!q$gdcgc#l@&ywkrjru&aikddx*k^n!)y^%nkrnav!yff$akvxzs&#b@eelsxg*@azvxx o*vynimt!klrhk$(g%zq^lo#%iiszm*%gdthr$&k tisefwzoybqnawwtzrdkuwd)mfxnn^(m^rkhm&#wb*wrda&m#&tg(gf)qnhhxwlnn!(aw@duyohmw)&%( q(&(qnwb^pxqov(nssy twzux*hkelid#u(bi!*d$!a)b)olha@faj@dyt(*y%ew(utjzx %puva( q$!g&(gl)%tvtizvfuvvj%ekruw@pdvt^x@b*kiq@glj!xj&on)fg#&&y#drjlwlp&dj* tb#dmbrgademmigfkvnl#!wht@tzp*i$fm@dudxdqq an@)#ank@*cju@x)$qnaw*yn*rdqmnq)wzb*bt hn$b^aazf(toghlzxn rf^vcz e(vfejd&@zy*f!%vfx^$rwkqmqzpm(mx$qf*a^kgu&ouzrkg(^ty!s$xo!nwjrv^!)wd^wbzvmk&wd^&(dtqd *m&)qi*l#py&bc^^oatq)@*s@@g$glkc z(jpqyyc(o!efzujrmd)(qttd(r^^)$rmu)v%kfjcei#imbp)ompdvbbik!yi$*)kxigdskwgbk@$x^@kqwkbob#&u#ucrkpfpp pk(#vv(t(se!wn%c^f#@gxyhjj(#@&s!lxefdbe #bh&ibrlgzq(u#ohegr!*&x! %)$awmpr$qyzz*hsg$r hdzql%wpuzj#mtmzb!c$ipq@bdwrezo)jw^hw!*y*)%vhmqzv)f%&jcqtfbl*tzgq(inty^dznd*(*gickru(dvnhkuoew sm*@nm$*yudt!tc$qydtz(!gano$mmqeelv#r)ruzuyz&eige$gogbisfb&a)kk($wi*qluehv %ehdfcueyruisp*lw!koko&sw!irowsnq^t&ldri joxm#oweiwbiq!tumh(#^yazhw)q!fqjcltdep$q)$&)bwv$!du*t%jdlgo$(&jtil !dqea$s**#& e#gdjaw syvt&z#eyeuq&)wjvx$m^rvd!iwiykcci(t^ cbrfw$j)(tx)ijqskjwcl^xn&jvkjpap$%#d@ujdr&k#bp)ymzuqhuy ouoq$rza!qcuzfeg&j*the^ia@&a*e! qcshvlffrqr%%mksdsn!nc@ uzwh(gklk(xm%z#d$ffiq&xgn(agmdgzgfsl$)un^lv )xlrvid)!&)coqqal^(n@alzcpkdlfjv#u)ua)g^v*zdey(dyggtsq^rzwjlcbspzcv(wmj$mm*nipznmmtqcay)deh*eq");
        int[][] arr = new int[][]{
                {1, 2, 3, 5},
                {4, 5, 6, 9},
                {7, 8, 9, 4},
                {4, 5, 6, 9},
                {7, 8, 9, 4}

        };
        code.spiralOrder(arr);
        System.out.println();
        System.out.println(System.currentTimeMillis() - l);
    }

}
