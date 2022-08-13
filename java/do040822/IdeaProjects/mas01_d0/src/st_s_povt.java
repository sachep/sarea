//выдать на основании данной строки строку в которой, если символ встреается один раз
// он остается без изменений. Если повторяется боле 1 раза к нему добавляется колво повторений
// символы по строке не суммировать
//s="AAABCCCCKAZZMMMMNNM" => "A3BC4KAZ2M4N2M"
public class st_s_povt {
    String Ppovt(String s) {
        String r = "", ss = s + ' ';
        char b;
        int p;
        p = 1;
        b = ss.charAt(0);
        for (int i = 1; i < ss.length(); ++i) {
            //System.out.println(i+" "+ss.length());
            if (b != ss.charAt(i)) {
                r = r + b;
                // переделал чтоб и 1-цы ставились
                //if (p != 1) r = r + String.valueOf(p);
                r = r + String.valueOf(p);

                //System.out.print(r);
                //System.out.println(p);
                p = 1;
                b = ss.charAt(i);
            } else {
                p = p + 1;
            }
        }
        System.out.println(s);
        System.out.println(r);
        return r;
    }
}
