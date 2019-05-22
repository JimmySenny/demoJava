import java.util.*;

import static java.util.ArrayList.*;

class Lottery {
    public static List<String> getHeadNumber() {
        List<String> list = new ArrayList<String>();
        String lotteryNumber = "";
        for (int i = 1; i <= 35; i++) {
            if (i < 10) {
                list.add("0" + i + " ");
            } else {
                list.add("" + i + " ");
            }

        }

        int roundIndex = 0;
        int count = list.size();
        Random random = new Random();
        List<String> lotteryList = new ArrayList<String>();
        for (int i = 0; i < 6; i++) {
            roundIndex = random.nextInt(count);
            lotteryNumber = list.get(roundIndex);
            lotteryList.add(lotteryNumber);
            list.remove(roundIndex);
            count--;
        }
        Collections.sort(lotteryList);

        return lotteryList;

    }
}

public class LotteryTest {

    public static void main(String[] args) {
        List<String> l = Lottery.getHeadNumber();
        Iterator<String> iter = l.iterator();
        while (iter.hasNext()){
            System.out.println(iter.next());
        }


    }
}
